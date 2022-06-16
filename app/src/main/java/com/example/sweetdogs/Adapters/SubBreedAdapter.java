package com.example.sweetdogs.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sweetdogs.R;
import com.example.sweetdogs.View.ImagesActivity;
import com.example.sweetdogs.View.SubBreedsActivity;

import java.util.ArrayList;

public class SubBreedAdapter extends RecyclerView.Adapter<SubBreedAdapter.RowHolder> {

    private ArrayList<String> subBreedList;
    private String breed;
    private Context mContext;

    public SubBreedAdapter(ArrayList<String> subBreedList, String breed, Context mContext) {
        this.subBreedList = subBreedList;
        this.breed = breed;
        this.mContext = mContext;
    }

    public class RowHolder extends RecyclerView.ViewHolder{
        public CardView cardSubBreed;
        public TextView subBreedText;
        public RowHolder(@NonNull View itemView) {
            super(itemView);
            cardSubBreed = itemView.findViewById(R.id.cardSubBreed);
            subBreedText = itemView.findViewById(R.id.subBreedText);
        }
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_subbreed,parent,false);
        return new RowHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.subBreedText.setText(subBreedList.get(position));
        holder.cardSubBreed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ImagesActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("subBreed", subBreedList.get(position));
                bundle.putString("breed", breed);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subBreedList.size();
    }


}
