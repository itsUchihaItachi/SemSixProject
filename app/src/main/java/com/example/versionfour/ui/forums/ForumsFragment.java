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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.versionfour.R;

import java.util.ArrayList;
import java.util.List;

public class ForumsFragment extends Fragment {

    private RecyclerView forumsRecycleView;
    private RecyclerView.Adapter forumsRecycleViewAdapter;

    private List<ForumsViewModel> viewModelList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_forums, container, false);

        forumsRecycleView = root.findViewById(R.id.forumsRecycleView);
        forumsRecycleView.setHasFixedSize(true);

        forumsRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModelList = new ArrayList<>();

        for(int i = 0; i < 10 ; i++){
            ForumsViewModel forumsViewModel = new ForumsViewModel("Heading" + (i+1),"Some description here");
            viewModelList.add(forumsViewModel);
        }

        forumsRecycleViewAdapter = new ForumsAdapter(viewModelList , getContext());
        forumsRecycleView.setAdapter(forumsRecycleViewAdapter);

        return root;
    }
}