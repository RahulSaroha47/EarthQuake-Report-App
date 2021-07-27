package com.example.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> Earthquakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout

        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
       final EarthquakeAdaptor adapter = new EarthquakeAdaptor(this,Earthquakes);
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Earthquake currentearthquake = adapter.getItem(position);

                Uri earthquakeuri = Uri.parse(currentearthquake.getURL());

                Intent websiteintent = new Intent(Intent.ACTION_VIEW,earthquakeuri);
                startActivity(websiteintent);

            }
        });


        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface

    }

}