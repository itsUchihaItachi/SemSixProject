package com.example.versionfour.ui.forums;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ForumsAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentListForums =  new ArrayList<>();
    private final List<String> fragmentListTitlesForums = new ArrayList<>();

    public ForumsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentListForums.get(position);
    }

    @Override
    public int getCount() {
        return fragmentListTitlesForums.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitlesForums.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        fragmentListForums.add(fragment);
        fragmentListTitlesForums.add(title);
    }
}
