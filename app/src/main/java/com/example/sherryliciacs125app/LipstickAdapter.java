package com.example.sherryliciacs125app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

import com.bumptech.glide.Glide;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LipstickAdapter extends RecyclerView.Adapter<LipstickAdapter.ViewHolder> {

    private Context context;
    private List<OneLipstick> list;

    //lipstick adapter constructor.
    public LipstickAdapter(Context context, List<OneLipstick> list) {
        this.context = context;
        this.list = list;
    }

    //onCreateViewHolder: inflates layout_listitem: a single block of recycleview
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(v);
    }

    //onBindViewHolder: adds "json" values to functions in "OneLipstick" class.
    //and calls OneLipstick object to set it inside recycler view.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OneLipstick oneLipstick = list.get(position); // creates OneLipstick object

        //glide is for images
        Glide.with(context)
                .asBitmap()
                .load(oneLipstick.getImageURL())
                .into(holder.mLipPic);

        holder.mBrand.setText(oneLipstick.getBrand());
        holder.mName.setText(oneLipstick.getName());
        holder.mPrice.setText(String.valueOf(oneLipstick.getPrice()));
        holder.mDescription.setText(oneLipstick.getDescription());
    }

    //important: tells adapter how many list items we have. if we left it = 0, the screen would be blank
    @Override
    public int getItemCount() {
        return list.size();
    }

    //ViewHolder = how 1 single block of recyclerview element would look like.
    //we connect the UI to the code here.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mBrand, mName, mPrice, mDescription;
        RelativeLayout mParentLayout;
        ImageView mLipPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mLipPic = itemView.findViewById(R.id.lippic);
            mBrand = itemView.findViewById(R.id.productbrand);
            mName = itemView.findViewById(R.id.productname);
            mPrice = itemView.findViewById(R.id.price);
            mDescription = itemView.findViewById(R.id.description);
            mParentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}


