package Controller.BrowseController.Categories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseCategory {

    @SerializedName("categories")
    @Expose
    private Categories categories;

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

}
