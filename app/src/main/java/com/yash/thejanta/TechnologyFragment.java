package com.yash.thejanta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yash.thejanta.Model.NewsApiResponse;
import com.yash.thejanta.Model.NewsHeadlines;

import java.util.List;

public class TechnologyFragment extends Fragment {

    NewsHeadlinesAdapter adapter;
    private RecyclerView recyclerViewOfTechnology;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RetrofitApiUtilities retrofitApiUtilities = new RetrofitApiUtilities(getContext());
        retrofitApiUtilities.getNewsHeadlines(listener,"technology",null);
        return inflater.inflate(R.layout.fragment_technology, container, false);
    }
    public OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {


            showNews(list);

        }

        @Override
        public void onError(String message) {

        }
    };
    private void showNews(List<NewsHeadlines> list) {
        recyclerViewOfTechnology = (RecyclerView) getActivity().findViewById(R.id.recyclerviewOfTechnology);
        recyclerViewOfTechnology.setHasFixedSize(true);
        recyclerViewOfTechnology.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsHeadlinesAdapter(getContext(), list);
        recyclerViewOfTechnology.setAdapter(adapter);

    }

}