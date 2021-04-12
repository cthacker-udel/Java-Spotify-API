package Controller.PlaylistController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SnapshotId {

    @SerializedName("snapshot_id")
    @Expose
    private String snapshotId;

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }


}
