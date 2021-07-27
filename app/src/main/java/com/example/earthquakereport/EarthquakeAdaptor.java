package com.example.earthquakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdaptor extends ArrayAdapter<Earthquake> {

    public EarthquakeAdaptor(Context context, ArrayList<Earthquake> Earthquakes) {
        super(context, 0, Earthquakes);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent, false);
        }

        Earthquake currentEarthquake  = getItem(position);

        DecimalFormat formatter = new DecimalFormat("0.00");
        String display = formatter.format(currentEarthquake.getMagnitude());
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitude.setText(display);

        String original_Location = currentEarthquake.getLocation();
        String first_string;
        String second_string;

        if(original_Location.contains(" of ")) {
            String[] spliter = original_Location.split(" of ");
           first_string = spliter[0] + " of ";
           second_string = spliter[1];
        }
        else
            {
               first_string  = "Near the";
               second_string = original_Location;
            }

        TextView location_first = (TextView) listItemView.findViewById(R.id.first_string);
        location_first.setText(first_string);

        TextView location_second = (TextView) listItemView.findViewById(R.id.second_string);
        location_second.setText(second_string);

        TextView date = (TextView) listItemView.findViewById(R.id.date);

        Date dateObject = new Date(currentEarthquake.getDate());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD,yyyy , HH:mm ");
        String simpleDate = dateFormatter.format(dateObject);
        date.setText(simpleDate);

        return listItemView;
    }
}
