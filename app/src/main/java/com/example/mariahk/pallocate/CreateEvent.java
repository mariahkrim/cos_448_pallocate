package com.example.mariahk.pallocate;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Button;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response.Listener;

import org.json.JSONException;
import org.json.JSONObject;

public class CreateEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TimePicker time = (TimePicker) findViewById(R.id.timePicker);
        final EditText place = (EditText) findViewById(R.id.loc);
        final Button makeEvent = (Button) findViewById(R.id.create_event_button);
        final Button backButt = (Button) findViewById(R.id.back_from_event);
        final EditText eventName = (EditText) findViewById(R.id.eventName);

        backButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                Intent intent = new Intent(CreateEvent.this, UserAreaActivity.class);
                CreateEvent.this.startActivity(intent);
            }
        });

        makeEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String minute = Integer.toString(time.getMinute());
                if (minute.length() == 1) {
                    minute = "0" + minute;
                }

                final String ctime = time.getHour() + ":" + minute;
                final String cplace = place.getText().toString();
                final String cname = eventName.getText().toString();
                Log.d("CAT", "TIME : " + ctime);
                Log.d("CAT", "Name : " + cname);
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("CAT", "I GOT A RESPONSE?");
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Log.d("CAT", "SUCCESS");
                                // Change this later when you get the feed
                                AlertDialog.Builder builder = new AlertDialog.Builder(CreateEvent.this);
                                builder.setMessage("Event successful!")
                                        .setNeutralButton("Ok", null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(CreateEvent.this, UserAreaActivity.class);
                                CreateEvent.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(CreateEvent.this);
                                builder.setMessage("Event creation failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                ServerHandler serverHandler = new ServerHandler(ctime, cplace, cname, responseListener);
                RequestQueue queue = Volley.newRequestQueue(CreateEvent.this);
                queue.add(serverHandler);
            }
        });
    }
}