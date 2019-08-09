
package se.alicedarner.flickerino.service.getImageDataObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Selectedimage {

    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("stat")
    @Expose
    private String stat;

    public Photo getPhoto() {
        return photo;
    }

    public String getStat() {
        return stat;
    }

}
