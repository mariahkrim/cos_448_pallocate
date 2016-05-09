package com.example.mariahk.pallocate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;
import java.util.ArrayList;

/**
 * Created by mariahk on 4/30/16.
 */
    public class makeUserAreaOutput extends ArrayAdapter<Event> {

        public makeUserAreaOutput(Context context, ArrayList<Event> events) {
            super(context, 0, events);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Event event = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_userarea, parent, false);
            }
            // Lookup view for data population
            TextView viewTime = (TextView) convertView.findViewById(R.id.time);
            TextView viewName = (TextView) convertView.findViewById(R.id.name);
            TextView viewLocation = (TextView) convertView.findViewById(R.id.location);
            TextView viewEventTitle = (TextView) convertView.findViewById(R.id.eventTitle);

            // Populate the data into the template view using the data object
            viewName.setText(event.namePerson);
            viewTime.setText(event.timeEvent);
            viewLocation.setText(event.locationEvent);
            viewEventTitle.setText(event.nameEvent);
            // Return the completed view to render on screen
            return convertView;
        }
}
