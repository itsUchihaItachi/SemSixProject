package com.example.versionfour.ui.tt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.versionfour.R;
import com.example.versionfour.ui.questionPaper.FragmentQuestionFY;
import com.example.versionfour.ui.questionPaper.FragmentQuestionSY;
import com.example.versionfour.ui.questionPaper.FragmentQuestionTY;
import com.example.versionfour.ui.questionPaper.QuestionViewPagerAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class TTFragment extends Fragment {

    private TabLayout tabLayout_tt;
    private AppBarLayout appBarLayout_tt;
    private ViewPager viewPager_tt;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tt, container, false);
        tabLayout_tt =  root.findViewById(R.id.time_table_tabs);

        appBarLayout_tt =root.findViewById(R.id.appBarTT);
        viewPager_tt = root.findViewById(R.id.time_table_viewpager);

        TTViewPageAdapter adapter = new TTViewPageAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentFyTT(),"First Year");
        adapter.addFragment(new FragmentSyTT(),"Second Year");
        adapter.addFragment(new FragmentTyTT(),"Third Year");

        viewPager_tt.setAdapter(adapter);
        tabLayout_tt.setupWithViewPager(viewPager_tt);

        return root;
    }
}