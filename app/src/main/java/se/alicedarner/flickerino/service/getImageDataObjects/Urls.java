
package se.alicedarner.flickerino.service.getImageDataObjects;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Urls {

    @SerializedName("url")
    @Expose
    private List<Url> url = null;

    public List<Url> getUrl() {
        return url;
    }

}
