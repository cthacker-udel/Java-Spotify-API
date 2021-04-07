package Controller.FollowController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artists {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("total")
    @Expose
    private Integer total;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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
