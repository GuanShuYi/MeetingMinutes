package gattung.biz.meetingminutes;

import android.os.Bundle;

/**
 * Created by torsten on 21.05.2017.
 */

public class AgendaItem {
    String title;
    String description;
    String owner;
    int duration;
    String category;

    public AgendaItem(String t, String des, String o, int dur, String cat){
        title = t; description=des; owner=o; duration=dur; category = cat;
    }

    public AgendaItem(Bundle b){
        updateFromBundle(b);
    }

    public String getDurationInMinutes(){
        return duration + " min";
    }

    public String getDurationAsText(){
        if ( duration < 60 )
            return duration + " min";
        else {
            return duration/60+":"+duration%60+" h";
        }
    }

    Bundle getBundle(int id){
        Bundle b = new Bundle();
        b.putInt("id",id);
        b.putString("title", title);
        b.putString("description", description);
        b.putInt("duration", duration);
        return b;
    }

    public void updateFromBundle(Bundle b){
        title = b.getString("title");
        description = b.getString("description");
        duration = b.getInt("duration");
    }
}
