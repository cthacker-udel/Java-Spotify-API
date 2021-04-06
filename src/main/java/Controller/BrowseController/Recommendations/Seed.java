package Controller.BrowseController.Recommendations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Seed {

    @SerializedName("initialPoolSize")
    @Expose
    private Integer initialPoolSize;
    @SerializedName("afterFilteringSize")
    @Expose
    private Integer afterFilteringSize;
    @SerializedName("afterRelinkingSize")
    @Expose
    private Integer afterRelinkingSize;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;

    public Integer getInitialPoolSize() {
        return initialPoolSize;
    }

    public void setInitialPoolSize(Integer initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    public Integer getAfterFilteringSize() {
        return afterFilteringSize;
    }

    public void setAfterFilteringSize(Integer afterFilteringSize) {
        this.afterFilteringSize = afterFilteringSize;
    }

    public Integer getAfterRelinkingSize() {
        return afterRelinkingSize;
    }

    public void setAfterRelinkingSize(Integer afterRelinkingSize) {
        this.afterRelinkingSize = afterRelinkingSize;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
