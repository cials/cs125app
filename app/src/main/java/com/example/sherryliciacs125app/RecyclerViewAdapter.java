package com.example.sherryliciacs125app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mProductName;
    private ArrayList<String> mProductBrand;
    private ArrayList<String> mPrice;
    private ArrayList<String> mDescription;
    private ArrayList<String> mLipPic;
    private Context context;

    //constructor for 1 single recyclerview block
    public RecyclerViewAdapter(ArrayList<String> mProductName, ArrayList<String> mProductBrand,
                               ArrayList<String> mPrice, ArrayList<String> mDescription,
                               ArrayList<String> mLipPic, Context context) {
        this.mProductName = mProductName;
        this.mProductBrand = mProductBrand;
        this.mPrice = mPrice;
        this.mDescription = mDescription;
        this.mLipPic = mLipPic;
        this.context = context;
    }

    //inflating layout_listitem and creating a viewholder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        //glide is for images
        Glide.with(context)
                .asBitmap()
                .load(mLipPic.get(position))
                .into(holder.lipPic);

        //setting text for the text views
        holder.productName.setText(mProductName.get(position));
        holder.productBrand.setText(mProductBrand.get(position));
        holder.price.setText(mPrice.get(position));
        holder.description.setText(mDescription.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mProductName.get(position));
                Toast.makeText(context, mProductName.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //important: tells adapter how many list items we have. if we left it = 0, the screen would be blank
    @Override
    public int getItemCount() {
        return mProductName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView lipPic;
        TextView productName;
        TextView productBrand;
        TextView price;
        TextView description;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lipPic = itemView.findViewById(R.id.lippic);
            productName = itemView.findViewById(R.id.productname);
            productBrand = itemView.findViewById(R.id.productbrand);
            price = itemView.findViewById(R.id.price);
            description = itemView.findViewById(R.id.description);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
