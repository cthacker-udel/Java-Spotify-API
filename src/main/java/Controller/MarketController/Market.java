package Controller.MarketController;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Market {

    @SerializedName("markets")
    @Expose
    private List<String> markets = null;

    public List<String> getMarkets() {
        return markets;
    }

    public void setMarkets(List<String> markets) {
        this.markets = markets;
    }


}
