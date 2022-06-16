package com.example.sweetdogs.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BreedImage {
    @SerializedName("message")
    private List<String> breedImageUrl;

    public List<String> getBreedImage(){
        return breedImageUrl;
    }
}
