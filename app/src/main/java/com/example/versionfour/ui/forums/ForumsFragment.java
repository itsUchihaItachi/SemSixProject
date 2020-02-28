package com.example.versionfour.ui.forums;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.versionfour.R;
import com.example.versionfour.ui.questionPaper.FragmentQuestionFY;
import com.example.versionfour.ui.questionPaper.FragmentQuestionSY;
import com.example.versionfour.ui.questionPaper.FragmentQuestionTY;
import com.example.versionfour.ui.questionPaper.QuestionViewPagerAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ForumsFragment extends Fragment {

    private TabLayout tabLayout_forums;
    private AppBarLayout appBarLayout_forums;
    private ViewPager viewPager_forums;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_forums, container, false);
        tabLayout_forums =  root.findViewById(R.id.forums_tabs);

        appBarLayout_forums =root.findViewById(R.id.appBarForums);
        viewPager_forums = root.findViewById(R.id.forums_viewpager);

        ForumsAdapter adapterForums = new ForumsAdapter(getChildFragmentManager());
        adapterForums.addFragment(new FragmentCulture(),"Culture");
        adapterForums.addFragment(new FragmentEntrepreneur(),"Entrepreneur");
        adapterForums.addFragment(new FragmentPhotography(),"Store");
        adapterForums.addFragment(new FragmentMarketing(),"Store");

        viewPager_forums.setAdapter(adapterForums);
        tabLayout_forums.setupWithViewPager(viewPager_forums);

        return root;
    }
}