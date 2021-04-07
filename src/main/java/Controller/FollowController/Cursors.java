package Controller.FollowController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cursors {

    @SerializedName("after")
    @Expose
    private String after;

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

}
