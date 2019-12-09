package com.example.sherryliciacs125app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lipstick button
        ImageButton lipstick = findViewById(R.id.lipstick);
        lipstick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Lipstick.class);
                startActivity(myIntent);
            }
        });

        //lipgloss button
        ImageButton lipgloss = findViewById(R.id.lipgloss);
        lipgloss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Lipgloss.class);
                startActivity(myIntent);
            }
        });

        //lipstain button
        ImageButton lipstain = findViewById(R.id.lipstain);
        lipstain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Lipstain.class);
                startActivity(myIntent);
            }
        });

        //lipliquid button
        ImageButton lipliquid = findViewById(R.id.lipliquid);
        lipliquid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Lipliquid.class);
                startActivity(myIntent);
            }
        });

    }
}
