package gattung.biz.meetingminutes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class AgendaItemListActivity extends Activity {

    public final static int EDIT_AGENDA_ITEM_REQUEST_CODE = 101;

    ListView lvAgendaItems;
    Agenda mAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_item_list);
        lvAgendaItems = (ListView) findViewById(R.id.lvAgendaItemList);
        mAgenda = new Agenda();
        lvAgendaItems.setAdapter(new AgendaItemAdapter(this, mAgenda));

        lvAgendaItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view,
                                            int position, long id) {
                        Intent intentEditAgendaItem = new Intent(getApplicationContext(), AgendaItemEditorActivity.class);
                        intentEditAgendaItem.putExtra("AgendaItem", mAgenda.items.get(position).getBundle(position));
                        startActivityForResult(intentEditAgendaItem, EDIT_AGENDA_ITEM_REQUEST_CODE);
                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent result){
        switch (requestCode){
            case EDIT_AGENDA_ITEM_REQUEST_CODE:
                if ( resultCode == Activity.RESULT_OK ){
                    if ( result != null ) {
                        Bundle data = result.getBundleExtra("AgendaItem");
                        if (data != null) {
                            int id = data.getInt("id", -1);
                            if (id > -1)
                                mAgenda.items.get(id).updateFromBundle(data);
                            else
                                mAgenda.items.add(new AgendaItem(data));
                        }
                        ((AgendaItemAdapter)(lvAgendaItems.getAdapter())).notifyDataSetChanged();
                        //mAgendaItemAdapter.notifyDataSetChanged();
                    }
                }
                break;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.agenda_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mnuAddItem:
            case R.id.mnuSettings:
            case R.id.mnuDelete:
                Toast.makeText(getApplicationContext(), "Feature not implemented - yet!",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
