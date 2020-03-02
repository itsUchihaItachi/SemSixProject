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

class EntrepreneurAdapter extends RecyclerView.Adapter<EntrepreneurAdapter.ViewHolder> {

    ArrayList<EntrepreneurModel> entrepreneurModels;
    Context context;


    public EntrepreneurAdapter(Context context, ArrayList<EntrepreneurModel> entrepreneurModels) {
        this.entrepreneurModels = entrepreneurModels;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.entrepreneur_row_item, parent, false);
        return new EntrepreneurAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(entrepreneurModels.get(position).getEntrepreneurPics());
        holder.textView.setText(entrepreneurModels.get(position).getEntrepreneurDesc());
    }

    @Override
    public int getItemCount() {
        return entrepreneurModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.entrepreneurRowImgView);
            textView = itemView.findViewById(R.id.entrepreneurRowText);
        }
    }
}
