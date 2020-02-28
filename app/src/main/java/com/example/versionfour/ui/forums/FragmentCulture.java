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

public class FragmentCulture extends Fragment {

    View view;
    RecyclerView cultureRecyclerView;
    ArrayList<CultureModel> cultureModels;
    CultureAdapter cultureAdapter;

    public FragmentCulture() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_forums_culture,container,false);
        cultureRecyclerView = view.findViewById(R.id.cultureRecycleView);
        Integer [] culturePics = {R.drawable.attendance1,R.drawable.forum1,R.drawable.contact1,R.drawable.timetable1,R.drawable.maps1,R.drawable.event1,R.drawable.links1};
        String [] cultureDesc ={"some Desc","some Desc","some Desc","some Desc","some Desc","some Desc","some Desc"};

        cultureModels = new ArrayList<>();
        for(int i = 0 ; i < culturePics.length ; i++){
            CultureModel model= new CultureModel(culturePics[i], cultureDesc[i]);
            cultureModels.add(model);
        }

        LinearLayoutManager cultureLinearLayoutManager = new LinearLayoutManager(
                getContext(),LinearLayoutManager.HORIZONTAL, false);

        cultureRecyclerView.setLayoutManager(cultureLinearLayoutManager);
        cultureRecyclerView.setItemAnimator(new DefaultItemAnimator());

        cultureAdapter = new CultureAdapter(getContext(), cultureModels);
        cultureRecyclerView.setAdapter(cultureAdapter);
        return view;
    }
}
