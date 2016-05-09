package com.example.mariahk.pallocate;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
public class AddFriends extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friends);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button addFriendButt = (Button) findViewById(R.id.butt_add_friend);

        addFriendButt.setOnClickListener(new View.OnClickListener() {
            // @Override
            Intent intent = getIntent();
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AddFriends.this);
                builder.setMessage("Your friend was added!")
                        .setPositiveButton("OK", null)
                        .create()
                        .show();

                Intent intent = new Intent(AddFriends.this, ShowFriends.class);
                AddFriends.this.startActivity(intent);
            }
        });

    }

}
