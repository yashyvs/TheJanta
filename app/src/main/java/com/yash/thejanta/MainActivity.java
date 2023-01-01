package com.yash.thejanta;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    private String[] titles = {"Home", "Health", "Science", "Technology", "Sports", "Entertainment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(this);
        viewPager2.setAdapter(viewPagerFragmentAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> tab.setText(titles[position]))).attach();
    }
}