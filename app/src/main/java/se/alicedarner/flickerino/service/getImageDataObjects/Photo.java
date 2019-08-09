
package se.alicedarner.flickerino.service.getImageDataObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("farm")
    @Expose
    private Integer farm;
    @SerializedName("dateuploaded")
    @Expose
    private String dateuploaded;
    @SerializedName("isfavorite")
    @Expose
    private Integer isfavorite;
    @SerializedName("license")
    @Expose
    private Integer license;
    @SerializedName("safety_level")
    @Expose
    private Integer safetyLevel;
    @SerializedName("rotation")
    @Expose
    private Integer rotation;
    @SerializedName("originalsecret")
    @Expose
    private String originalsecret;
    @SerializedName("originalformat")
    @Expose
    private String originalformat;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("visibility")
    @Expose
    private Visibility visibility;
    @SerializedName("dates")
    @Expose
    private Dates dates;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("editability")
    @Expose
    private Editability editability;
    @SerializedName("publiceditability")
    @Expose
    private Publiceditability publiceditability;
    @SerializedName("usage")
    @Expose
    private Usage usage;
    @SerializedName("comments")
    @Expose
    private Comments comments;
    @SerializedName("notes")
    @Expose
    private Notes notes;
    @SerializedName("people")
    @Expose
    private People people;
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("media")
    @Expose
    private String media;

    public String getId() {
        return id;
    }

    public String getSecret() {
        return secret;
    }

    public String getServer() {
        return server;
    }

    public Integer getFarm() {
        return farm;
    }

    public String getDateuploaded() {
        return dateuploaded;
    }

    public Integer getIsfavorite() {
        return isfavorite;
    }

    public Integer getLicense() {
        return license;
    }

    public Integer getSafetyLevel() {
        return safetyLevel;
    }

    public Integer getRotation() {
        return rotation;
    }

    public String getOriginalsecret() {
        return originalsecret;
    }

    public String getOriginalformat() {
        return originalformat;
    }

    public Owner getOwner() {
        return owner;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public Dates getDates() {
        return dates;
    }

    public Integer getViews() {
        return views;
    }

    public Editability getEditability() {
        return editability;
    }

    public Publiceditability getPubliceditability() {
        return publiceditability;
    }

    public Usage getUsage() {
        return usage;
    }

    public Comments getComments() {
        return comments;
    }

    public Notes getNotes() {
        return notes;
    }

    public People getPeople() {
        return people;
    }

    public Urls getUrls() {
        return urls;
    }

    public String getMedia() {
        return media;
    }

}
