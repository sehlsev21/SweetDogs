package com.example.sweetdogs.Services;

import com.example.sweetdogs.Models.Breed;
import com.example.sweetdogs.Models.BreedImage;
import com.example.sweetdogs.Models.SubBreedImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface BreedAPI {

    //Ana ırklar
    @GET("api/breeds/list/all")
    Call<Breed> getBreeds();

    //Ana ırk fotoğraf
    @GET("api/breed/{breed}/images")
    Call<BreedImage> getBreedImages(@Path("breed") String breed);

    //Alt ırk fotoğraf
    @GET("api/breed/{breed}/{subBreed}/images")
    Call<SubBreedImage> getSubBreedImages(@Path("breed") String breed , @Path("subBreed") String subBreed);
}
