package com.example.sherryliciacs125app;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class LipstickPage extends AppCompatActivity {

    private static final String TAG = "LipstickPage";
    private RecyclerView recyclerView;
//    private final int jsoncode = 1;
//    ArrayList<OneLipstick> oneLipstickArrayList;
//    private static ProgressDialog mProgressDialog;

    private String url = "http://makeup-api.herokuapp.com/api/v1/products.json?product_category=lipstick&product_type=lipstick";


    private List<OneLipstick> lipstickList;
    private RecyclerView.Adapter adapter;

    private DividerItemDecoration dividerItemDecoration;
    private LinearLayoutManager linearLayoutManager;


    //try request queue
    private RequestQueue mQueue;
    private TextView mProductName;
    private TextView mProductBrand;
    private TextView mPrice;
    private TextView mDescription;

    //vars
    private ArrayList<String> productName = new ArrayList<>();
    private ArrayList<String> productBrand = new ArrayList<>();
    private ArrayList<String> price = new ArrayList<>();
    private ArrayList<String> description = new ArrayList<>();
    private ArrayList<String> imageURL = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lipstick);
        Log.d(TAG, "onCreate: Lipstick Started.");

        recyclerView = findViewById(R.id.recylerview);
//        fetchJSON();

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());

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
                Intent myIntent = new Intent(LipstickPage.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

//        getData();

//button parse json tutorial 2
        mProductName = findViewById(R.id.productname);
        mProductBrand = findViewById(R.id.productbrand);
        mPrice = findViewById(R.id.price);
        mDescription = findViewById(R.id.description);

        mQueue = Volley.newRequestQueue(this);

        getData();

//        jsonParse();

        //        Button buttonParse = findViewById(R.id.buttonparse);
//        buttonParse.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                jsonParse();
//            }
//        });


//        webRequest();
//        initImageBitmaps();
//
//        try {
//            getJson();
//            System.out.println("TRY!!!!!!!");
//        } catch (Exception e) {
//            System.out.println("CATCH HELLO");
//            e.printStackTrace();
//            System.out.println(e);
//            Intent myIntent = new Intent(LipstickPage.this,
//                    MainActivity.class);
//            startActivity(myIntent);
//        }
//
//        individualValues();

//        TextView testResult = findViewById(R.id.testresult);
//        testResult.setText(lipstickArray[0].getBrand());
    }
    //oncreate end


//    @Override
//    protected void onStart() {
//        super.onStart();
////        webRequest();
//    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();

        url = "http://makeup-api.herokuapp.com/api/v1/products.json?product_category=lipstick&product_type=lipstick";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        OneLipstick oneLipstick = new OneLipstick();
                        oneLipstick.setBrand("Brand: " + jsonObject.getString("brand"));
                        oneLipstick.setName("Name: " + jsonObject.getString("name"));
                        oneLipstick.setPrice("Price: USD " + jsonObject.getString("price"));
                        oneLipstick.setDescription(jsonObject.getString("description"));
                        oneLipstick.setImageURL(jsonObject.getString("image_link"));

                        lipstickList.add(oneLipstick);

                    } catch (JSONException e) {
                        e.printStackTrace();
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
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonArrayRequest);
    }


//    //json tutorial2
//    private void jsonParse() {
////        url = "http://makeup-api.herokuapp.com/api/v1/products.json?product_category=lipstick&product_type=lipstick";
//        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        try {
//                            for (int i = 0; i < response.length(); i++) {
//                                JSONObject lipstick = response.getJSONObject(i);
//                                String productBrand = lipstick.getString("brand");
//                                String productName = lipstick.getString("name");
//                                String price = lipstick.getString("price");
//                                String description = lipstick.getString("description");
//
////                                mProductBrand.setText("Brand: " + productBrand + "\n");
////                                mProductName.setText("Name: " + productName + "\n");
////                                mPrice.setText("Price: " + price + "\n");
////                                mDescription.setText(description + "\n");
//
//                                System.out.println(productBrand);
//                                mProductName.append(productBrand + "\n" +
//                                        productName + "\n" +
//                                        price + "\n" +
//                                        description + "\n" + "\n\n\n\n\n");
//
//                            }
//
//
//                        } catch (JSONException e){
//                            System.out.println("oh no json didnt work");
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            //when there is an error
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                System.out.println("That didn't work!");
//                error.printStackTrace();
//            }
//        });
//
//        mQueue.add(request);
//    }


//    public void webRequest() {
//        // Instantiate the RequestQueue.
//        RequestQueue queue = Volley.newRequestQueue(this);
//        url = "http://makeup-api.herokuapp.com/api/v1/products.json?product_category=lipstick&product_type=lipstick";
//
//        // Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
//                        System.out.println(response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                System.out.println("That didn't work!");
//            }
//        });
//
//        // Add the request to the RequestQueue.
//        queue.add(stringRequest);
//    }
//
//
//    public JsonObject getJson() throws Exception {
//        JsonParser jsonParser = new JsonParser();
//        JsonObject gsonObject = (JsonObject) jsonParser.parse(JsonReader.readJsonFromUrl(url).toString());
//        alldata = gsonObject;
//        System.out.print("helloooooo");
//        System.out.println(alldata);
//        return alldata;
//    }


//1. create json object that contains all json content from url
//2. use dot method to say like String name = jsonobjname.get("name").getAsString;
// 3. put all this json individual values inside a function, and connect it to our layout
// 4. inflate chunks

//    public void individualValues() {
//        JsonArray allLipsticks = alldata.getAsJsonArray();
//        lipstickArray = new OneLipstick[100];
//        int index = 0;
//        for (JsonElement lipElement : allLipsticks) {
//            JsonObject lipObject = lipElement.getAsJsonObject();
//
//            OneLipstick oneLipstick = new OneLipstick();
//            oneLipstick.setBrand(lipObject.get("brand").getAsString());
//            oneLipstick.setName(lipObject.get("name").getAsString());
//            oneLipstick.setPrice(lipObject.get("name").getAsDouble());
//            oneLipstick.setDescription(lipObject.get("description").getAsString());
//
//            lipstickArray[index] = oneLipstick;
//        }
//    }
//
//    private void initImageBitmaps() {
//        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
//
//        productBrand.add("Brand: Colourpop");
//        productName.add("Product Name: Blotted Lip");
//        price.add("Price: USD 5.5");
//        description.add("Blotted Lip Sheer matte lipstick that creates the perfect popsicle pout! Formula is lightweight, matte and buildable for light to medium coverage.");
//        imageURL.add("https://cdn.shopify.com/s/files/1/1338/0845/products/brain-freeze_a_800x1200.jpg?v=1502255076");
//
//        productBrand.add("Brand: Colourpop");
//        productName.add("Product Name: Lippie Stix");
//        price.add("Price: USD 5.5");
//        description.add("Lippie Stix Formula contains Vitamin E, Mango, Avocado, and Shea butter for added comfort and moisture. None of our Lippie formulas contain any nasty ingredients like Parabens or Sulfates.");
//        imageURL.add("https://cdn.shopify.com/s/files/1/1338/0845/collections/blottedlip-lippie-stix_grande.jpg?v=1512588803");
//
//        //calling initrecyclerview, where we call the recyclerview adapter here.
//        //later we call initimagebitmaps in oncreate
//        initRecyclerView();
//    }
//
//    private void initRecyclerView() {
//        Log.d(TAG, "initRecyclerView: init recyclerview.");
//        RecyclerView recyclerView = findViewById(R.id.recylerview);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(productName, productBrand,
//                price, description, imageURL, this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }

}



