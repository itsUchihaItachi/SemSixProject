package com.example.versionfour.ui.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.versionfour.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PostAdapter extends FirebaseRecyclerAdapter<Post, PostAdapter.PostViewHolder> {
    public PostAdapter(@NonNull FirebaseRecyclerOptions<Post> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull Post post) {

        holder.eventname.setText(post.getEventname());
        holder.eventplace.setText(post.getEventplace());
        holder.startdate.setText(post.getStartdate());
        holder.starttime.setText(post.getStarttime());
        holder.enddate.setText(post.getEnddate());
        holder.endtime.setText(post.getEndtime());
        holder.eventlink.setText(post.getEventlink());
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post,parent,false);
                return new PostViewHolder(view);
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView eventname,eventplace,startdate,starttime,enddate,endtime,eventlink;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            eventname = itemView.findViewById(R.id.eventname);
            eventplace = itemView.findViewById(R.id.eventplace);
            startdate = itemView.findViewById(R.id.startdate);
            starttime = itemView.findViewById(R.id.starttime);
            enddate = itemView.findViewById(R.id.enddate);
            endtime = itemView.findViewById(R.id.endtime);
            eventlink = itemView.findViewById(R.id.eventlink);
        }
    }
}
