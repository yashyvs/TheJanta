package com.yash.thejanta;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerFragmentAdapter extends FragmentStateAdapter {

    private String[] titles = {"Home", "Health", "Science", "Technology", "Sports", "Entertainment"};

    public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:return new HomeFragment();
            case 1:return new HealthFragment();
            case 2:return new ScienceFragment();
            case 3:return new TechnologyFragment();
            case 4:return new SportsFragment();
            case 5:return new EntertainmentFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
