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

public class SportsFragment extends Fragment {

    NewsHeadlinesAdapter adapter;
    private RecyclerView recyclerViewOfSports;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RetrofitApiUtilities retrofitApiUtilities = new RetrofitApiUtilities(getContext());
        retrofitApiUtilities.getNewsHeadlines(listener,"sports",null);
        return inflater.inflate(R.layout.fragment_sports, container, false);
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
        recyclerViewOfSports = (RecyclerView) getActivity().findViewById(R.id.recyclerviewOfSports);
        recyclerViewOfSports.setHasFixedSize(true);
        recyclerViewOfSports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsHeadlinesAdapter(getContext(), list);
        recyclerViewOfSports.setAdapter(adapter);

    }

}