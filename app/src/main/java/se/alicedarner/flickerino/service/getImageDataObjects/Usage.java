
package se.alicedarner.flickerino.service.getImageDataObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usage {

    @SerializedName("candownload")
    @Expose
    private Integer candownload;
    @SerializedName("canblog")
    @Expose
    private Integer canblog;
    @SerializedName("canprint")
    @Expose
    private Integer canprint;
    @SerializedName("canshare")
    @Expose
    private Integer canshare;

    public Integer getCandownload() {
        return candownload;
    }

    public Integer getCanblog() {
        return canblog;
    }

    public Integer getCanprint() {
        return canprint;
    }

    public Integer getCanshare() {
        return canshare;
    }

}
