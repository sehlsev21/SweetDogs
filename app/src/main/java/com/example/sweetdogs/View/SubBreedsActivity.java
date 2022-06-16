package com.example.sweetdogs.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sweetdogs.Adapters.SubBreedAdapter;
import com.example.sweetdogs.R;

import java.util.ArrayList;

public class SubBreedsActivity extends AppCompatActivity {

    private ArrayList<String> subBreeds;
    private String breed;
    private RecyclerView rwSubBreeds;
    private SubBreedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_breeds);

        rwSubBreeds = findViewById(R.id.rwSubBreeds);
        subBreeds = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            subBreeds = bundle.getStringArrayList("subBreeds");
            breed = bundle.getString("breed");
        }

        rwSubBreeds.setLayoutManager(new LinearLayoutManager(SubBreedsActivity.this));
        adapter = new SubBreedAdapter(subBreeds,breed,SubBreedsActivity.this);
        rwSubBreeds.setAdapter(adapter);

    }
}