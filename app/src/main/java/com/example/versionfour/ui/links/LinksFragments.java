package com.example.versionfour.ui.links;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.versionfour.R;

import java.util.ArrayList;
import java.util.List;

public class LinksFragments extends Fragment {

    private Context context;
    private List<LinksViewModel> availList = new ArrayList<LinksViewModel>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_links, container, false);

        //TODO: Do stuf  with your UI (rootView)
        availList.add(new LinksViewModel("Under-Graduate Programmes", "https://mitwpu.edu.in/ug-programmes/"));
        availList.add(new LinksViewModel("Post-Graduate Programmes", "https://mitwpu.edu.in/pg-programmes/"));

        ArrayAdapter<LinksViewModel> adapter = new CustomAdapter();

        ListView myFirstListView = rootView.findViewById(R.id.myFirstListView);

        myFirstListView.setAdapter(adapter);


        myFirstListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LinksViewModel myCurrentList = availList.get(position);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(myCurrentList.getUrl()));
                startActivity(i);
            }
        });


        return rootView;
    }

    private class CustomAdapter extends ArrayAdapter<LinksViewModel> {
        public CustomAdapter() {
            super(context, R.layout.my_layout, availList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.my_layout, parent, false);
            }
            LinksViewModel myCurrentList = availList.get(position);

            TextView myName = (TextView) convertView.findViewById(R.id.name);

            myName.setText(myCurrentList.getNameOfLink());

            return convertView;
        }
    }
}
