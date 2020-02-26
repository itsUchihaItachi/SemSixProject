package com.example.versionfour.ui.questionPaper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.versionfour.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class QuestionPaperFragments extends  Fragment {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_question_paper, container, false);
        tabLayout =  root.findViewById(R.id.question_tabs);

        appBarLayout =root.findViewById(R.id.appBarQP);
        viewPager = root.findViewById(R.id.question_paper_viewpager);

        QuestionViewPagerAdapter adapter = new QuestionViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentQuestionFY(),"Quiz");
        adapter.addFragment(new FragmentQuestionSY(),"Explore");
        adapter.addFragment(new FragmentQuestionTY(),"Store");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }
}