package com.example.sherryliciacs125app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;


public class LipstickPage extends AppCompatActivity {

    private String url;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lipstick);

        Button returnlipstick = findViewById(R.id.returnlipstick);
        returnlipstick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(LipstickPage.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        webRequest();
    }

    @Override
    protected void onStart() {
        super.onStart();
        webRequest();
    }

    public void webRequest() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        url = "http://makeup-api.herokuapp.com/api/v1/products.json?product_category=lipstick&product_type=lipstick";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        System.out.println(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    public JSONObject getJson() throws Exception{
        return JsonReader.readJsonFromUrl(url);
    }
    public LipstickPage[] getLipstickArray() throws Exception {
        gson.fromJson(getJson(), OneLipstick.class);
        gson.from

    }




}
