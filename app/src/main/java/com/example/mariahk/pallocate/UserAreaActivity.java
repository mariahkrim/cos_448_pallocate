package com.example.mariahk.pallocate;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import android.app.ProgressDialog;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.android.volley.VolleyError;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpCookie;
import java.util.ArrayList;

public class UserAreaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        // getData();


        final Button bCreateEvent = (Button) findViewById(R.id.bCreateEvent);
        final Button friendButt = (Button) findViewById(R.id.show_friend_button);


        bCreateEvent.setOnClickListener(new View.OnClickListener() {
            // @Override
            Intent intent = getIntent();
            String name = intent.getStringExtra("name");

            public void onClick(View v) {
                Intent createEventIntent = new Intent(UserAreaActivity.this, CreateEvent.class);
                createEventIntent.putExtra("name", name);
                UserAreaActivity.this.startActivity(createEventIntent);
            }
        });

        friendButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                Intent intent = new Intent(UserAreaActivity.this, ShowFriends.class);
                UserAreaActivity.this.startActivity(intent);
            }
        });

        // Construct the data source
        ArrayList<Event> arrayOfEvents = new ArrayList<Event>();
        // Create the adapter to convert the array to views
        makeUserAreaOutput adapter = new makeUserAreaOutput(this, arrayOfEvents);
        // Attach the adapter to a listview
        ListView listv = (ListView) findViewById(R.id.list);
        listv.setAdapter(adapter);

        /*String[] names = {"Lindy", "Luisa", "Jessica"};
        String[] locations = {"MoMA", "Rocky", "The Dinky"};
        String[] time = {"10:12 am", "1:30pm", "2:48pm"};
        String[] eventName = {"Visit the Art Museum", "Lunch", "Heading to Philly!"};
        */
        Event Event1 = new Event("Mariah", "MoMa", "10:12am", "Visiting the art museum");
        Event Event2 = new Event("Luisa", "Rocky", "1:12pm", "Lunch");
        Event Event3 = new Event("Erica", "The Dinky", "2:48pm", "Going to NY");
        Event Event4 = new Event("Tanvee", "My Room", "9:45pm", "Pregame");
        adapter.add(Event1);
        adapter.add(Event2);
        adapter.add(Event3);
        adapter.add(Event4);

    }

    class ItemList implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup vg = (ViewGroup) view;
            TextView tv = (TextView) vg.findViewById(R.id.name);
            Toast.makeText(UserAreaActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}