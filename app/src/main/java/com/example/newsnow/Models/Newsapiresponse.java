package com.example.newsnow.Models;

import java.util.List;

public class Newsapiresponse {
    String status;
    int totalResults;
    List<Newsheadlines> articles;

    public List<Newsheadlines> getArticles() {
        return articles;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setArticles(List<Newsheadlines> articles) {
        this.articles = articles;
    }
}
