package com.example.sweetdogs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sweetdogs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.RowHolder>{
    private Context mContext;
    private ArrayList<String> imageUrlList;

    public ImageAdapter(Context mContext, ArrayList<String> imageUrlList) {
        this.mContext = mContext;
        this.imageUrlList = imageUrlList;
    }

    public class RowHolder extends RecyclerView.ViewHolder{

        public CardView cardImage;
        public ImageView imageView;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_image,parent,false);
        return new RowHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {

        Picasso.get()
                .load(imageUrlList.get(position))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageUrlList.size();
    }


}
