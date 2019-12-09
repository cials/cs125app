package com.example.sherryliciacs125app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Lipstick extends AppCompatActivity {

    private static final String TAG = "Lipstick";
    private RecyclerView recyclerView;

    private String url;

    private List<OneLipstick> lipstickList;
    private RecyclerView.Adapter adapter;

    private DividerItemDecoration dividerItemDecoration;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lipstick);
        Log.d(TAG, "onCreate: Lipstick Started.");

        //setting up recycler view and connecting it with our lipstick adapter.
        recyclerView = findViewById(R.id.recyclerview);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());

        // creating lipsticklist, a list of Lipstick objects which we will add to recycler view.
        //each lipstick object has product name, brand, price, description.
        lipstickList = new ArrayList<>();
        adapter = new LipstickAdapter(getApplicationContext(), lipstickList);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        //return button in every page to return to main page
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

        //calling get json data function
        getData();

    }
    //oncreate end

    //getData function fetches json data from makeupAPI from the internet using Volley,
    //and puts that data inside elements in our recyclerview block.
    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");        // helpful. tells user data is loading & not crashing.
        progressDialog.show();

        //this is what's different in every lipstick category class: the JSON URL for that specific lipstick category.
        url = "http://makeup-api.herokuapp.com/api/v1/products.json?product_category=lipstick&product_type=lipstick";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //response is a jsonArray
                        //we use a for loop to get jsonObjects with index i from the array.
                        //then, we initialize those jsonObjects to our recyclerview elements.
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                //creating OneLipstick object
                                //putting json values to that OneLipstick object
                                OneLipstick oneLipstick = new OneLipstick();
                                oneLipstick.setBrand("Brand: " + jsonObject.getString("brand"));
                                oneLipstick.setName("Name: " + jsonObject.getString("name"));
                                oneLipstick.setPrice("Price: USD " + jsonObject.getString("price"));
                                oneLipstick.setDescription(jsonObject.getString("description"));
                                oneLipstick.setImageURL(jsonObject.getString("image_link"));

                                //once 1 lipstick object (which is 1 recyclerview block) has been created,
                                //we add it to our lipstick list. lipstick list contains lipstick objects.
                                //every lipstick objects has product brand, name, price, description.
                                lipstickList.add(oneLipstick);

                            } catch (JSONException e) {
                                e.printStackTrace(); // printing error
                                progressDialog.dismiss();
                            }
                        }
                        adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });

        //after fetching all that json, want to make a request queue using volley
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonArrayRequest);
    }


//1. create json object that contains all json content from url
//2. use dot method to say like String name = jsonobjname.get("name").getAsString;
// 3. put all this json individual values inside a function, and connect it to our layout
// 4. inflate chunks

}

