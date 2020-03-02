package com.example.versionfour.ui.forums;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.versionfour.R;

import java.util.ArrayList;
class PhotographyAdapter extends RecyclerView.Adapter<PhotographyAdapter.ViewHolder> {
        ArrayList<PhotographyModel> photographyModels;
        Context context;


public PhotographyAdapter(Context context, ArrayList<PhotographyModel> photographyModels) {
        this.photographyModels = photographyModels;
        this.context = context;
        }


@NonNull
@Override
public PhotographyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.photography_row_item, parent, false);
        return new PhotographyAdapter.ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull PhotographyAdapter.ViewHolder holder, int position) {

        holder.imageView.setImageResource(photographyModels.get(position).getPhotographyPics());
        holder.textView.setText(photographyModels.get(position).getPhotographyDesc());
        }

@Override
public int getItemCount() {
        return photographyModels.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.photographyRowImgView);
        textView = itemView.findViewById(R.id.photographyRowText);
    }
}
}

