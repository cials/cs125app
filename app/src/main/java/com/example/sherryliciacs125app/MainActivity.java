package com.example.sherryliciacs125app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lipstick = findViewById(R.id.lipstick);
        lipstick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Lipstick.class);
                startActivity(myIntent);
            }
        });

        Button lipgloss = findViewById(R.id.lipgloss);
        lipgloss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Lipgloss.class);
                startActivity(myIntent);
            }
        });

        Button lipstain = findViewById(R.id.lipstain);
        lipstain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Lipstain.class);
                startActivity(myIntent);
            }
        });

        Button lipliquid = findViewById(R.id.lipliquid);
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
