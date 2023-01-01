package com.yash.thejanta;

import android.content.Context;
import android.widget.Toast;

import com.yash.thejanta.Model.NewsApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitApiUtilities {

    String BaseURL = "https://newsapi.org/v2/";
    Context context;
    Retrofit retrofit = new Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create()).build();


    public RetrofitApiUtilities(Context context) {
        this.context = context;
    }




    public void getNewsHeadlines(OnFetchDataListener listener,String category,String query){

        CallNewsApi callNewsApi =retrofit.create(CallNewsApi.class);
        Call<NewsApiResponse>call = callNewsApi.callHeadlines("in",100,category,query,context.getString(R.string.api_key));

        try{
            call.enqueue(new Callback<NewsApiResponse>() {
                @Override
                public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {

                    if(!response.isSuccessful()){
                        Toast.makeText(context, "Error!!", Toast.LENGTH_SHORT).show();
                    }
                    listener.onFetchData(response.body().getArticles(),response.message());
                }

                @Override
                public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                    listener.onError("Request Failed");

                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public interface CallNewsApi{

        @GET("top-headlines")
        Call<NewsApiResponse> callHeadlines(
                @Query("country") String country,
                @Query("pageSize") int pagesize,
                @Query("category") String category,
                @Query("q") String query,
                @Query("apikey") String api_key
        );
    }


}