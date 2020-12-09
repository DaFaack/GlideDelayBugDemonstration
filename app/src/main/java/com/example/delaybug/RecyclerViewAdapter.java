package com.example.delaybug;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Item> mItem;
    Context mContext;


    public RecyclerViewAdapter(Context context, ArrayList<Item> items){
        mContext = context;
        mItem = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Item currentItem = mItem.get(position);

        final String imageUrl = currentItem.getImageResource();
        final String imageUrlPressed = currentItem.getImageResourceSecond();


        //preload imageNormal
        Glide.with(mContext)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .preload();

        //preload imagePressed
        Glide.with(mContext)
                .load(imageUrlPressed)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .preload();

        //display imageNormal
        Glide.with(mContext)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(holder.itemImageView);



        holder.itemImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //display imagePressed
                Glide.with(mContext)
                        .load(imageUrlPressed)
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .into(holder.itemImageView);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemTextView;
        ImageView itemImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.textViewItem);
            itemImageView = itemView.findViewById(R.id.imageViewItem);
        }
    }

}
