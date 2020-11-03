package com.example.mygalgeleg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class highscoreAdapter extends RecyclerView.Adapter<highscoreAdapter.ViewHolder> {

    List<List<String>> scoreList;
    public highscoreAdapter(List<List<String>> scoreList){
    this.scoreList = scoreList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.highscore_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
        List<String> row = scoreList.get(position);
        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        TextView textView2 = holder.highscoreTextView;
        textView.setText(row.get(0));
        textView2.setText(row.get(1));
    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView highscoreTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.HI_name);
            highscoreTextView = (TextView) itemView.findViewById(R.id.HI_score);
        }
    }

}
