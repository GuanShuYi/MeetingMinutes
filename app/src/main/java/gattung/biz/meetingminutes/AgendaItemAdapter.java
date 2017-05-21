package gattung.biz.meetingminutes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by torsten on 21.05.2017.
 */

public class AgendaItemAdapter extends BaseAdapter {
    Agenda mAgenda;

    private Context mContext;
    private LayoutInflater mInflater;

    public AgendaItemAdapter(Context context, Agenda agenda){
        mAgenda = agenda;
        mContext = context;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mAgenda.items.size();
    }

    @Override
    public Object getItem(int i) {
        return mAgenda.items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        AgendaItemViewHolder viewHolder;
        if ( convertView == null ){
            convertView = mInflater.inflate(R.layout.agenda_item, null);
            viewHolder = new AgendaItemViewHolder();
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.tvAgendaItemTitle);
            viewHolder.tvDuration = (TextView)convertView.findViewById(R.id.tvAgendaItemDuration);
            viewHolder.tvDescription = (TextView)convertView.findViewById(R.id.tvAgendaItemDescription);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AgendaItemViewHolder)convertView.getTag();
        }

        AgendaItem item = mAgenda.items.get(position);
        viewHolder.tvTitle.setText(item.title);
        viewHolder.tvDuration.setText(item.getDurationInMinutes());
        viewHolder.tvDescription.setText(item.description);

        return convertView;
    }
}

class AgendaItemViewHolder {
    TextView tvTitle;
    TextView tvDuration;
    TextView tvDescription;
}