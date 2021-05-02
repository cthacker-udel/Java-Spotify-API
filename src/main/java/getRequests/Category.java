package getRequests;

import Client.SpotifyClient;

import java.util.HashMap;

public class Category extends SpotifyClient {

    private String country;

    private String locale;

    private Integer limit;

    private Integer offset;

    private String categoryId;

    public Category(){
        super();
    }

    public HashMap<String,Object> convertQueryParams(){

        HashMap<String,Object> queryParams = new HashMap<>();
        if(this.country != null){
            queryParams.put("country",this.country);
        }
        if(this.locale != null){
            queryParams.put("locale",this.locale);
        }
        if(this.limit != null){
            queryParams.put("limit",this.limit);
        }
        if(this.offset != null){
            queryParams.put("offset",this.offset);
        }
        return queryParams;
    }

    public void clearQueryParams(){

        this.country = null;
        this.locale = null;
        this.limit = null;
        this.offset = null;
        this.categoryId = null;

    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
