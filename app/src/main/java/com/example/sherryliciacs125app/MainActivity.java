package com.example.sherryliciacs125app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lipstick = findViewById(R.id.lipstick);
        lipstick.setOnClickListener(unused -> startActivity(new Intent(this, Lipstick.class)));

        Button lipgloss = findViewById(R.id.lipgloss);
        lipgloss.setOnClickListener(unused -> startActivity(new Intent(this, Lipgloss.class)));

        Button lipstain = findViewById(R.id.lipstain);
        lipstain.setOnClickListener(unused -> startActivity(new Intent(this, Lipstain.class)));

        Button lipliquid = findViewById(R.id.lipliquid);
        lipliquid.setOnClickListener(unused -> startActivity(new Intent(this, Lipliquid.class)));
    }
}
