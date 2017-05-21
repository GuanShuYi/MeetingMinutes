package gattung.biz.meetingminutes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by torsten on 21.05.2017.
 */

public class AgendaListAdapter extends BaseAdapter {
    ArrayList<Agenda> items;
    Context mContext;
    private LayoutInflater mInflater;

    AgendaListAdapter(Context context, ArrayList<Agenda> agendaItems){
        mContext = context;
        items = agendaItems;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        AgendaListViewHolder viewHolder;
        if ( convertView == null ){
            convertView = mInflater.inflate(R.layout.agenda, null);
            viewHolder = new AgendaListViewHolder();
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.tvAgendaTitle);
            //viewHolder.tvDuration = (TextView)convertView.findViewById(R.id.tvAgendaItemDuration);
            viewHolder.tvDescription = (TextView)convertView.findViewById(R.id.tvAgendaDescription);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AgendaListViewHolder)convertView.getTag();
        }

        Agenda item = items.get(position);
        viewHolder.tvTitle.setText(item.mTitle);
        //viewHolder.tvDuration.setText(item.getDurationInMinutes());
        viewHolder.tvDescription.setText(item.mDescription);

        return convertView;
    }
}

class AgendaListViewHolder {
    TextView tvTitle;
    //TextView tvDuration;
    TextView tvDescription;
}