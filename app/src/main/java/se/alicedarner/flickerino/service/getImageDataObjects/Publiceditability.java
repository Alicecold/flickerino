
package se.alicedarner.flickerino.service.getImageDataObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Publiceditability {

    @SerializedName("cancomment")
    @Expose
    private Integer cancomment;

    public Integer getCancomment() {
        return cancomment;
    }

}
