package com.example.sherryliciacs125app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LipstickAdapter extends RecyclerView.Adapter<LipstickAdapter.ViewHolder> {

    private Context context;
    private List<OneLipstick> list;

    public LipstickAdapter(Context context, List<OneLipstick> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OneLipstick oneLipstick = list.get(position);

        holder.mBrand.setText(oneLipstick.getBrand());
        holder.mName.setText(oneLipstick.getName());
        holder.mPrice.setText(String.valueOf(oneLipstick.getPrice()));
        holder.mDescription.setText(oneLipstick.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mBrand, mName, mPrice, mDescription;
        RelativeLayout mParentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mBrand = itemView.findViewById(R.id.productbrand);
            mName = itemView.findViewById(R.id.productname);
            mPrice = itemView.findViewById(R.id.price);
            mDescription = itemView.findViewById(R.id.description);
            mParentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }
}


