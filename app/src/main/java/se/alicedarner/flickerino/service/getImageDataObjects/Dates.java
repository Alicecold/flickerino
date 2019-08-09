
package se.alicedarner.flickerino.service.getImageDataObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dates {

    @SerializedName("posted")
    @Expose
    private String posted;
    @SerializedName("taken")
    @Expose
    private String taken;
    @SerializedName("takengranularity")
    @Expose
    private Integer takengranularity;
    @SerializedName("takenunknown")
    @Expose
    private Integer takenunknown;
    @SerializedName("lastupdate")
    @Expose
    private String lastupdate;

    public String getPosted() {
        return posted;
    }

    public String getTaken() {
        return taken;
    }

    public Integer getTakengranularity() {
        return takengranularity;
    }

    public Integer getTakenunknown() {
        return takenunknown;
    }

    public String getLastupdate() {
        return lastupdate;
    }

}
