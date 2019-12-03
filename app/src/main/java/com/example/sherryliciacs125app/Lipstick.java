package com.example.sherryliciacs125app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static androidx.core.content.ContextCompat.startActivity;

public class Lipstick extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lipstick);

        Button returnlipstick = findViewById(R.id.returnlipstick);
        returnlipstick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(Lipstick.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
