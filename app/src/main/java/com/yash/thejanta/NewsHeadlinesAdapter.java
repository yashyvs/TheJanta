package com.yash.thejanta;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yash.thejanta.Model.NewsHeadlines;

import java.util.List;

public class NewsHeadlinesAdapter extends RecyclerView.Adapter<NewsHeadlinesViewHolder> {

    Context context;
    List<NewsHeadlines> headlines;

    public NewsHeadlinesAdapter(Context context, List<NewsHeadlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public NewsHeadlinesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_list_item,parent,false);
        return new NewsHeadlinesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHeadlinesViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());

        if(headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        }

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,webViewActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("url",headlines.get(position).getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
