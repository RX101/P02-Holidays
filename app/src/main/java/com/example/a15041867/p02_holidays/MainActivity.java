package com.example.a15041867.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTypes;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTypes = (ListView) findViewById(R.id.lvTypes);

        al = new ArrayList<String>();
        al.add("Secular");
        al.add("Ethnic & Religion");

        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);
        lvTypes.setAdapter(aa);

        lvTypes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedTypes = al.get(position);

                Toast.makeText(MainActivity.this, selectedTypes,
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, HolidaysActivity.class);
                intent.putExtra("types", selectedTypes);
                startActivity(intent);
            }
        });
    }
}
