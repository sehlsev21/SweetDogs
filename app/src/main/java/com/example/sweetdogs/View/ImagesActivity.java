package com.example.sweetdogs.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.sweetdogs.Adapters.BreedAdapter;
import com.example.sweetdogs.Adapters.ImageAdapter;
import com.example.sweetdogs.Models.Breed;
import com.example.sweetdogs.Models.BreedImage;
import com.example.sweetdogs.Models.SubBreedImage;
import com.example.sweetdogs.R;
import com.example.sweetdogs.Services.BreedAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImagesActivity extends AppCompatActivity {

    String breed;
    String subBreed;
    Retrofit retrofit;
    BreedAPI breedAPI;
    ArrayList<String> imageUrlList;
    private RecyclerView rwImages;
    private ImageAdapter imageAdapter;
    private String BASE_URL = "https://dog.ceo/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            subBreed = bundle.getString("subBreed");
            breed = bundle.getString("breed");
        }

        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        rwImages = findViewById(R.id.rwImages);
        rwImages.setHasFixedSize(true);
        loadImages();
    }

    private void loadImages() {
        breedAPI = retrofit.create(BreedAPI.class);

        if(subBreed == null){
            Call<BreedImage> call = breedAPI.getBreedImages(breed);
            call.enqueue(new Callback<BreedImage>() {
                @Override
                public void onResponse(Call<BreedImage> call, Response<BreedImage> response) {
                    imageUrlList = new ArrayList<>(response.body().getBreedImage());
                    rwImages.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                    imageAdapter = new ImageAdapter(ImagesActivity.this,imageUrlList);
                    rwImages.setAdapter(imageAdapter);
                }

                @Override
                public void onFailure(Call<BreedImage> call, Throwable t) {
                    t.printStackTrace();
                }
            });

        }else{
            Call<SubBreedImage> call = breedAPI.getSubBreedImages(breed,subBreed);
            call.enqueue(new Callback<SubBreedImage>() {
                @Override
                public void onResponse(Call<SubBreedImage> call, Response<SubBreedImage> response) {
                    imageUrlList = new ArrayList<>(response.body().getSubBreedImage());
                    rwImages.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                    imageAdapter = new ImageAdapter(ImagesActivity.this,imageUrlList);
                    rwImages.setAdapter(imageAdapter);
                }

                @Override
                public void onFailure(Call<SubBreedImage> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }
}