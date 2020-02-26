package com.example.versionfour.ui.tt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TTViewPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentListTT =  new ArrayList<>();
    private final List<String> fragmentListTitlesTT = new ArrayList<>();

    public TTViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentListTT.get(position);
    }

    @Override
    public int getCount() {
        return fragmentListTitlesTT.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitlesTT.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        fragmentListTT.add(fragment);
        fragmentListTitlesTT.add(title);
    }

}