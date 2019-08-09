package se.alicedarner.flickerino.service.searchObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResult {

    @SerializedName("photos")
    @Expose
    private Result result;

    public Result getResult() {
        return result;
    }

}
