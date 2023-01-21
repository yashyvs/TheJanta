package com.yash.thejanta;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NewsHeadlinesViewHolder extends RecyclerView.ViewHolder {

    TextView text_title,text_source;
    ImageView img_headline;
    CardView cardview;

    public NewsHeadlinesViewHolder(@NonNull View itemView) {
        super(itemView);

        text_source = itemView.findViewById(R.id.textSource);
        text_title = itemView.findViewById(R.id.textTitle);
        img_headline = itemView.findViewById(R.id.img_headline);
        cardview = itemView.findViewById(R.id.main_container);

    }
}
