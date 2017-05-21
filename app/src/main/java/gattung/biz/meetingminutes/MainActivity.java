package gattung.biz.meetingminutes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView lvAgendaList;
    ArrayList<Agenda> mAgendaList;

    //AgendaItemAdapter mAgendaItemAdapter = null;

    public final static int EDIT_AGENDA_REQUEST_CODE = 201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvAgendaList = (ListView) findViewById(R.id.lvAgendaList);
        mAgendaList = new ArrayList<>();
        mAgendaList.add(new Agenda());
        mAgendaList.add(new Agenda("Morning Meeting", "see Whiteboard"));

        lvAgendaList.setAdapter(new AgendaListAdapter(this, mAgendaList));

        lvAgendaList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view,
                                            int position, long id) {
                        Intent intentShowAgendaItems = new Intent(getApplicationContext(), AgendaItemListActivity.class);
                        //intentShowAgendaItems.putExtra("AgendaItem", mAgendaList.get(position).getBundle(position));
                        startActivity(intentShowAgendaItems);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mnuNewAgenda:
            case R.id.mnuSettings:
            case R.id.mnuDelete:
                Toast.makeText(getApplicationContext(), "Feature not implemented - yet!",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
