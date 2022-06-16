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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.CardViewTasarimTutucuBreed> {

    private Context mContext;
    private Map<String, List<String>> map;
    private ArrayList<String> breedList;

    public BreedAdapter(Context mContext, Map<String, List<String>> map) {
        this.mContext = mContext;
        this.map = map;
    }

    public class CardViewTasarimTutucuBreed extends RecyclerView.ViewHolder{
        public CardView cardBreed;
        public TextView breedText;
        public CardViewTasarimTutucuBreed(@NonNull View itemView) {
            super(itemView);
            cardBreed = itemView.findViewById(R.id.cardBreed);
            breedText = itemView.findViewById(R.id.breedText);
        }
    }

    @NonNull
    @Override
    public CardViewTasarimTutucuBreed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_breed,parent,false);
        return new CardViewTasarimTutucuBreed(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimTutucuBreed holder, @SuppressLint("RecyclerView") int position) {
        Set set = map.entrySet(); //key(anahtar) değerleri
        Iterator it = set.iterator();
        breedList = new ArrayList<>();

        while(it.hasNext()){
            Map.Entry me = (Map.Entry) it.next();
            breedList.add((String) me.getKey());

        }
        List<String> subBreedList = map.get(breedList.get(position));

        if (subBreedList.size() == 0){
            holder.breedText.setText("YOK " + breedList.get(position));
        }else{
            holder.breedText.setText("VAR " + breedList.get(position));
        }

        holder.cardBreed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (subBreedList.size() == 0){
                    Intent intent = new Intent(mContext, ImagesActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("breed", breedList.get(position));
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
                else{
                    Intent intent = new Intent(mContext, SubBreedsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("subBreeds", (ArrayList<String>) subBreedList);
                    bundle.putString("breed", breedList.get(position));
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return map.size();
    }


}
