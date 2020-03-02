package com.example.versionfour.ui.forums;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.versionfour.R;

import java.util.ArrayList;

public class FragmentMarketing extends Fragment {

    View view;
    RecyclerView marketingRecyclerView;
    ArrayList<MarketingModel> marketingModels;
    MarketingAdapter marketingAdapter;

    public FragmentMarketing() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_forums_marketing,container,false);

        marketingRecyclerView = view.findViewById(R.id.marketingRecycleView);
        Integer [] marketingPics = {R.drawable.attendance1,R.drawable.forum1,R.drawable.contact1,R.drawable.timetable1,R.drawable.maps1,R.drawable.event1,R.drawable.links1};
        String [] marketingDesc ={"some Desc","some Desc","some Desc","some Desc","some Desc","some Desc","some Desc"};

        marketingModels = new ArrayList<>();
        for(int i = 0 ; i < marketingPics.length ; i++){
            MarketingModel model= new MarketingModel(marketingPics[i], marketingDesc[i]);
            marketingModels.add(model);
        }

        LinearLayoutManager marketingLinearLayoutManager = new LinearLayoutManager(
                getContext(),LinearLayoutManager.HORIZONTAL, false);

        marketingRecyclerView.setLayoutManager(marketingLinearLayoutManager);
        marketingRecyclerView.setItemAnimator(new DefaultItemAnimator());

        marketingAdapter = new MarketingAdapter(getContext(), marketingModels);
        marketingRecyclerView.setAdapter(marketingAdapter);

        return view;
    }
}
