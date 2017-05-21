package gattung.biz.meetingminutes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by torsten on 21.05.2017.
 */

public class Agenda {
    ArrayList<AgendaItem> items;
    String mTitle;
    String mDescription;
    Date mStartDate;
    Date mEndDate;

    public Agenda(){
        items = new ArrayList<>();
        items.add(new AgendaItem("Arrival", "Time to arrive and get the meeting started", "All", 5, ""));
        items.add(new AgendaItem("Agenda", "Purpose & Agenda of this meeting", "NN", 5, ""));
        items.add(new AgendaItem("Topic 1", "The most important topic", "NN", 15, ""));
        items.add(new AgendaItem("Topic 2", "The 2nd most important topic", "NN", 10, ""));
        items.add(new AgendaItem("Topic 3", "The least important topic", "NN", 5, ""));
        items.add(new AgendaItem("Parking Lot", "Time to discuss open topics", "All", 5, ""));
        //startDate = Calendar.getInstance(Calendar.)
        mTitle = "Default Meeting";
        mDescription = "A typical meeting structure";
    }

    public Agenda(String title, String description) {
        mTitle = title;
        mDescription = description;
        //mStartDate = startDate;
    }
}
