package com.example.mariahk.pallocate;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ShowFriends extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_friends);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final Button viewIDButton = (Button) findViewById(R.id.myID_button);
        final Button addFriendButton = (Button) findViewById(R.id.addFriend_button);



        viewIDButton.setOnClickListener(new View.OnClickListener() {
            // @Override
            Intent intent = getIntent();
            String name = intent.getStringExtra("name");

            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ShowFriends.this);
                builder.setMessage("Your user ID is: 0004")
                        .setNeutralButton("OK", null)
                        .create()
                        .show();
            }
        });

        addFriendButton.setOnClickListener(new View.OnClickListener() {
            // @Override
            Intent intent = getIntent();

            public void onClick(View v) {
                Intent addFriendIntent = new Intent(ShowFriends.this, AddFriends.class);
                ShowFriends.this.startActivity(addFriendIntent);
            }
        });


        String[] Friends = {"Tanvee", "Erica", "Mariah"};

        ListView listv = (ListView) findViewById(R.id.listFriends);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.layout_friend, R.id.frand, Friends);
        listv.setAdapter(adapter);
    }

}
