package getRequests;

import Client.SpotifyClient;

import java.util.ArrayList;

public class Item extends SpotifyClient {

    private String queryType;
    private ArrayList<String> itemTypes;

    public Item(){
        super();
    }

    public String convertItemTypes(){
        return String.join(",",this.itemTypes);
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public ArrayList<String> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(ArrayList<String> itemTypes) {
        this.itemTypes = itemTypes;
    }
}
