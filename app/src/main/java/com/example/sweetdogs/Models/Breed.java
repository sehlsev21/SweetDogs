
package com.example.sweetdogs.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;


public class Breed {

    @SerializedName("message")
    private Map<String,List<String>> breeds;

    public Map<String,List<String>> getBreed(){
        return breeds;
    }

}
