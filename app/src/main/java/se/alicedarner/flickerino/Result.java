package se.alicedarner.flickerino;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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