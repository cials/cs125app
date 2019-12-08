package com.example.sherryliciacs125app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;


import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class LipstickPage extends AppCompatActivity {

    private static final String TAG = "LipstickPage";

    private String url;
    private JsonObject alldata;
    private OneLipstick[] lipstickArray;

    //vars
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> imageURL = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lipstick);
        Log.d(TAG, "onCreate: Lipstick Started.");

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
        initImageBitmaps();
//        try {
//            getJson();
//        } catch (Exception e) {
//            Intent myIntent = new Intent(LipstickPage.this,
//                    MainActivity.class);
//            startActivity(myIntent);
//        }
//
//        individualValues();
//
//        TextView testResult = findViewById(R.id.testresult);
//        testResult.setText(lipstickArray[0].getBrand());

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

    public JsonObject getJson() throws Exception {
        JsonParser jsonParser = new JsonParser();
        JsonObject gsonObject = (JsonObject) jsonParser.parse(JsonReader.readJsonFromUrl(url).toString());
        alldata = gsonObject;
        return alldata;
    }


//1. create json object that contains all json content from url
//2. use dot method to say like String name = jsonobjname.get("name").getAsString;
// 3. put all this json individual values inside a function, and connect it to our layout
// 4. inflate chunks

    public void individualValues() {
        JsonArray allLipsticks = alldata.getAsJsonArray();
        lipstickArray = new OneLipstick[100];
        int index = 0;
        for (JsonElement lipElement : allLipsticks) {
            JsonObject lipObject = lipElement.getAsJsonObject();

            OneLipstick oneLipstick = new OneLipstick();
            oneLipstick.setBrand(lipObject.get("brand").getAsString());
            oneLipstick.setName(lipObject.get("name").getAsString());
            oneLipstick.setPrice(lipObject.get("name").getAsDouble());
            oneLipstick.setCurrency(lipObject.get("currency").getAsString());
            oneLipstick.setPriceSign(lipObject.get("price_sign").getAsString());
            oneLipstick.setDescription(lipObject.get("description").getAsString());
            oneLipstick.setImagelink(lipObject.get("image_link").getAsString());

            lipstickArray[index] = oneLipstick;
        }
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        names.add("Blotted Lip");
        imageURL.add("https://cdn.shopify.com/s/files/1/1338/0845/products/brain-freeze_a_800x1200.jpg?v=1502255076");

        names.add("Lippie Stix");
        imageURL.add("https://cdn.shopify.com/s/files/1/1338/0845/collections/blottedlip-lippie-stix_grande.jpg?v=1512588803");

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recylerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, names, imageURL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}

