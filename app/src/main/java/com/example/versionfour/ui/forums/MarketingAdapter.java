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

class MarketingAdapter extends RecyclerView.Adapter<MarketingAdapter.ViewHolder> {
    ArrayList<MarketingModel> marketingModels;
    Context context;


    public MarketingAdapter(Context context, ArrayList<MarketingModel> marketingModels) {
        this.marketingModels = marketingModels;
        this.context = context;
    }


    @NonNull
    @Override
    public MarketingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.marketing_row_item, parent, false);
        return new MarketingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketingAdapter.ViewHolder holder, int position) {

        holder.imageView.setImageResource(marketingModels.get(position).getMarketingPics());
        holder.textView.setText(marketingModels.get(position).getMarketingDesc());
    }

    @Override
    public int getItemCount() {
        return marketingModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.marketingRowImgView);
            textView = itemView.findViewById(R.id.marketingRowText);
        }
    }
}
