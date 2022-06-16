package com.example.sweetdogs.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.example.sweetdogs.Adapters.BreedAdapter;
import com.example.sweetdogs.Models.Breed;
import com.example.sweetdogs.R;
import com.example.sweetdogs.Services.BreedAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private Map<String, List<String>> map;
    private String BASE_URL = "https://dog.ceo/";
    private Retrofit retrofit;
    private BreedAPI breedAPI;
    private RecyclerView rwBreeds;
    private BreedAdapter breedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        rwBreeds = findViewById(R.id.rwBreeds);
        loadBreeds();

    }

    private void loadBreeds() {

        breedAPI = retrofit.create(BreedAPI.class);
        Call<Breed> call3 = breedAPI.getBreeds();
        call3.enqueue(new Callback<Breed>() {

            @Override
            public void onResponse(Call<Breed> call, Response<Breed> response) {

                if (response.isSuccessful()) {

                    map = response.body().getBreed();

                    rwBreeds.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
                    breedAdapter = new BreedAdapter(HomeActivity.this,map);
                    rwBreeds.setAdapter(breedAdapter);

                }
            }

            @Override
            public void onFailure(Call<Breed> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }



}