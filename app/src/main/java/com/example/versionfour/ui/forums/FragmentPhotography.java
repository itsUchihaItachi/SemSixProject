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

public class FragmentPhotography extends Fragment {

    View view;
    RecyclerView photographyRecyclerView;
    ArrayList<PhotographyModel> photographyModels;
    PhotographyAdapter photographyAdapter;

    public FragmentPhotography() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_forums_photography,container,false);

        photographyRecyclerView = view.findViewById(R.id.photographyRecycleView);
        Integer [] photographyPics = {R.drawable.attendance1,R.drawable.forum1,R.drawable.contact1,R.drawable.timetable1,R.drawable.maps1,R.drawable.event1,R.drawable.links1};
        String [] photographyDesc ={"some Desc","some Desc","some Desc","some Desc","some Desc","some Desc","some Desc"};

        photographyModels = new ArrayList<>();
        for(int i = 0 ; i < photographyPics.length ; i++){
            PhotographyModel model= new PhotographyModel(photographyPics[i], photographyDesc[i]);
            photographyModels.add(model);
        }

        LinearLayoutManager photographyLinearLayoutManager = new LinearLayoutManager(
                getContext(),LinearLayoutManager.HORIZONTAL, false);

        photographyRecyclerView.setLayoutManager(photographyLinearLayoutManager);
        photographyRecyclerView.setItemAnimator(new DefaultItemAnimator());

        photographyAdapter = new PhotographyAdapter(getContext(), photographyModels);
        photographyRecyclerView.setAdapter(photographyAdapter);


        return view;
    }
}
