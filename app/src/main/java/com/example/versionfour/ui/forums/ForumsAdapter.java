package com.example.versionfour.ui.forums;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.versionfour.R;

import java.util.List;

public class ForumsAdapter extends RecyclerView.Adapter<ForumsAdapter.ForumsViewHodler> {

    private List<ForumsViewModel> forumsViewModelList;
    private Context context;

    public ForumsAdapter(List<ForumsViewModel> forumsViewModelList ,Context context){
        this.forumsViewModelList = forumsViewModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ForumsViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_forum_item, parent, false);

        return new ForumsViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForumsViewHodler holder, int position) {
        ForumsViewModel forumsViewModel = forumsViewModelList.get(position);
        holder.textViewHeading.setText(forumsViewModel.getHead());
        holder.textViewDescription.setText(forumsViewModel.getDesc());
    }

    @Override
    public int getItemCount() {
        return forumsViewModelList.size();
    }

    public class ForumsViewHodler extends RecyclerView.ViewHolder {

        public TextView textViewHeading, textViewDescription;

        public ForumsViewHodler(@NonNull View itemView) {
            super(itemView);

            textViewHeading = (TextView) itemView.findViewById(R.id.forumsHeadingTextView);
            textViewDescription = (TextView) itemView.findViewById(R.id.forumsDescriptionTextView);
        }
    }
}
