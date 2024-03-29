
package se.alicedarner.flickerino.service.getImageDataObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Url {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("_content")
    @Expose
    private String content;

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

}
