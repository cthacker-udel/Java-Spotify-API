package Controller.PlayerController.CurrentUserRecentTrack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseTrack {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("cursors")
    @Expose
    private Cursors cursors;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("href")
    @Expose
    private String href;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Cursors getCursors() {
        return cursors;
    }

    public void setCursors(Cursors cursors) {
        this.cursors = cursors;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
