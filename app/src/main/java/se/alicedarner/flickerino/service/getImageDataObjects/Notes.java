
package se.alicedarner.flickerino.service.getImageDataObjects;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notes {

    @SerializedName("note")
    @Expose
    private List<Object> note = null;

    public List<Object> getNote() {
        return note;
    }

}
