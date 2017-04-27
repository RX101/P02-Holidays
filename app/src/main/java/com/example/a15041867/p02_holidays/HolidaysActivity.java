package com.example.a15041867.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HolidaysActivity extends AppCompatActivity {

    ListView lv1;
    ArrayAdapter aa1;
    ArrayList<holidays> holiday;
    TextView tvTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);

        lv1 = (ListView) this.findViewById(R.id.lvHolidays);
        tvTypes = (TextView) findViewById(R.id.tvTypes);

        Intent i = getIntent();
        String types = i.getStringExtra("types");
        tvTypes.setText(types);



        //create a few food objects in Food array
        holiday = new ArrayList<holidays>();
        if(types.equalsIgnoreCase("Secular")){
            holiday.add(new holidays("New Year's Holiday", "1 Jan 2017", "Have Fun"));
            holiday.add(new holidays("Labour Day", "1 May 2017","No Work"));
        }else if (types.equalsIgnoreCase("Ethnic & Religion")){
            holiday.add(new holidays("Chinese New Year", "28-29 Jan 2017", "Have Fun"));
            holiday.add(new holidays("Good Friday", "14 April 2017","No Work"));
        }

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa1 = new HolidayAdapter(this, R.layout.row, holiday);
        lv1.setAdapter(aa1);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                holidays selectedItem = holiday.get(position);

//                Toast.makeText(HolidaysActivity.this, selectedItem.getName()
//                                + " : " + selectedItem.getDate(),
//                        Toast.LENGTH_SHORT).show();

                Toast.makeText(HolidaysActivity.this,
                                " Description: " + selectedItem.getDesc(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
