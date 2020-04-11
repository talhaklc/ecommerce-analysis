package com.n12.search.analysis;

import java.sql.Timestamp;

public class SearchProductModel {

    private Integer userId;

    private Integer city;

    private Timestamp timestamp;

    private String search;

    public SearchProductModel() {
    }

    public SearchProductModel(Integer userId, Integer city, Timestamp timestamp, String search) {
        this.userId = userId;
        this.city = city;
        this.timestamp = timestamp;
        this.search = search;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
