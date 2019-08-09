
package se.alicedarner.flickerino.service.getImageDataObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("nsid")
    @Expose
    private String nsid;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("realname")
    @Expose
    private String realname;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("iconserver")
    @Expose
    private Integer iconserver;
    @SerializedName("iconfarm")
    @Expose
    private Integer iconfarm;
    @SerializedName("path_alias")
    @Expose
    private String pathAlias;

    public String getNsid() {
        return nsid;
    }

    public String getUsername() {
        return username;
    }

    public String getRealname() {
        return realname;
    }

    public String getLocation() {
        return location;
    }

    public Integer getIconserver() {
        return iconserver;
    }

    public Integer getIconfarm() {
        return iconfarm;
    }

    public String getPathAlias() {
        return pathAlias;
    }

}
