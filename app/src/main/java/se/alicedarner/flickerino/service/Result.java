package se.alicedarner.flickerino.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("photo")
    @Expose
    private List<Photo> photos = null;

    public Integer getPage() {
        return page;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

}