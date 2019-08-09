
package se.alicedarner.flickerino.service.getImageDataObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Visibility {

    @SerializedName("ispublic")
    @Expose
    private Integer ispublic;
    @SerializedName("isfriend")
    @Expose
    private Integer isfriend;
    @SerializedName("isfamily")
    @Expose
    private Integer isfamily;

    public Integer getIspublic() {
        return ispublic;
    }

    public Integer getIsfriend() {
        return isfriend;
    }

    public Integer getIsfamily() {
        return isfamily;
    }

}
