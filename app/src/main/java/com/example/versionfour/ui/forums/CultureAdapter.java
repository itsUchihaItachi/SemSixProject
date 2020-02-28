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

public class CultureAdapter extends RecyclerView.Adapter<CultureAdapter.ViewHolder> {

    ArrayList<CultureModel> cultureModels;
    Context context;

    public CultureAdapter(Context context, ArrayList<CultureModel> cultureModels) {
        this.cultureModels = cultureModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.culture_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(cultureModels.get(position).getCulturePics());
        holder.textView.setText(cultureModels.get(position).getCultureDesc());

    }

    @Override
    public int getItemCount() {
        return cultureModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

         public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cultureRowImgView);
            textView = itemView.findViewById(R.id.cultureRowText);
        }
    }
}
