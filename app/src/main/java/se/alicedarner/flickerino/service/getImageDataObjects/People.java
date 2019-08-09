
package se.alicedarner.flickerino.service.getImageDataObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class People {

    @SerializedName("haspeople")
    @Expose
    private Integer haspeople;

    public Integer getHaspeople() {
        return haspeople;
    }

}
