package se.alicedarner.flickerino.service.searchObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("farm")
    @Expose
    private String farm;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("secret")
    @Expose
    private String secret;

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFarm() {
        return farm;
    }

    public String getServer() {
        return server;
    }

    public String getSecret() {
        return secret;
    }
}