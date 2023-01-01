package com.yash.thejanta.Model;

import java.util.List;

public class NewsApiResponse {

    String status;
    int totalResults;
    List<NewsHeadlines> articles;


    public NewsApiResponse(String status, int totalResults, List<NewsHeadlines> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsHeadlines> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsHeadlines> articles) {
        this.articles = articles;
    }


}
