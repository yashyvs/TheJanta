package com.yash.thejanta;

import com.yash.thejanta.Model.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {


    void onFetchData(List<NewsHeadlines> list, String message);
    void onError(String message);


}
