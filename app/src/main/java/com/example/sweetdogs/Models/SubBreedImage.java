package com.example.sweetdogs.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubBreedImage {
    @SerializedName("message")
    private List<String> subBreedImageUrl;

    public List<String> getSubBreedImage(){
        return subBreedImageUrl;
    }
}
