package gattung.biz.meetingminutes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgendaItemEditorActivity extends AppCompatActivity {

    Bundle data = null;
    EditText titleEdit;
    EditText durationEdit;
    EditText descriptionEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_item_editor);
        titleEdit = (EditText)findViewById(R.id.inAgendaItemTitle);
        durationEdit = (EditText)findViewById(R.id.inAgendaItemDuration);
        descriptionEdit = (EditText)findViewById(R.id.inAgendaItemDescription);

        Intent intent = getIntent();

        if ( intent != null ) {
            data = intent.getBundleExtra("AgendaItem");
            titleEdit.setText(data.getString("title"));
            durationEdit.setText(data.getInt("duration") + "");
            descriptionEdit.setText(data.getString("description"));
        }

        Button btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                saveItem();
            }
        });

        Button btnCancel = (Button)findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.edit_item_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mnuSave:
                saveItem();
                break;
        }
        return true;
    }

    private void saveItem(){
        data.putString("title", titleEdit.getText().toString());
        data.putString("description", descriptionEdit.getText().toString());
        //TODO: data.putInt("duration", durationEdit.getText().)

        Intent result = new Intent();
        result.putExtra("AgendaItem", data);
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}
