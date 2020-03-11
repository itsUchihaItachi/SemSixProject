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

public  class FragmentEntrepreneur extends Fragment {

    View view;
    RecyclerView entrepreneurRecyclerView;
    ArrayList<EntrepreneurModel> entrepreneurModels;
    EntrepreneurAdapter entrepreneurAdapter;

    public FragmentEntrepreneur() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_forums_entrepreneur,container,false);

        entrepreneurRecyclerView = view.findViewById(R.id.entrepreneurRecycleView);
        Integer [] entrepreneurPics = {R.drawable.attendance1,R.drawable.forum1,R.drawable.contact1,R.drawable.timetable1,R.drawable.maps1,R.drawable.event1,R.drawable.links1};
        String [] entrepreneurDesc ={"some Desc","some Desc","some Desc","some Desc","some Desc","some Desc","some Desc"};

        entrepreneurModels = new ArrayList<>();
        for(int i = 0 ; i < entrepreneurPics.length ; i++){
            EntrepreneurModel model= new EntrepreneurModel(entrepreneurPics[i], entrepreneurDesc[i]);
            entrepreneurModels.add(model);
        }

        LinearLayoutManager entrepreneurLinearLayoutManager = new LinearLayoutManager(
                getContext(),LinearLayoutManager.VERTICAL, false);

        entrepreneurRecyclerView.setLayoutManager(entrepreneurLinearLayoutManager);
        entrepreneurRecyclerView.setItemAnimator(new DefaultItemAnimator());

        entrepreneurAdapter = new EntrepreneurAdapter(getContext(), entrepreneurModels);
        entrepreneurRecyclerView.setAdapter(entrepreneurAdapter);
        return view;
    }
}
