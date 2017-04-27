package com.example.a15041867.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15041867 on 27/4/2017.
 */

public class HolidayAdapter extends ArrayAdapter<holidays> {
    private ArrayList<holidays> holiday;
    private Context context;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivIcon;

    public HolidayAdapter(Context context, int resource, ArrayList<holidays> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvName = (TextView) rowView.findViewById(R.id.tvHolidays);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivIcon = (ImageView) rowView.findViewById(R.id.ivIcon);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        holidays currentModule = holiday.get(position);
        // Set the TextView to show the food

        tvName.setText(currentModule.getName());
        tvDate.setText(currentModule.getDate());
        // Set the image to star or nostar accordingly
        if(currentModule.getName() == "New Year's Holiday") {
            ivIcon.setImageResource(R.drawable.newyear);
        }
        else if (currentModule.getName() == "Chinese New Year"){
            ivIcon.setImageResource(R.drawable.cny);
        }
        else if (currentModule.getName() == "Good Friday"){
            ivIcon.setImageResource(R.drawable.goodfriday);
        }
        else {
            ivIcon.setImageResource(R.drawable.labourday);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }

}
