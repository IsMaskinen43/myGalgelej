package com.example.mygalgeleg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class highscoreAdapter extends RecyclerView.Adapter<highscoreAdapter.ViewHolder> implements View.OnClickListener {

    List<DTOhigscore> scoreList;

    public highscoreAdapter(List<DTOhigscore> scoreList) {
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
        DTOhigscore dto = scoreList.get(position);
        // Set item views based on your views and data model
        TextView textName = holder.nameTextView;
        TextView textWord = holder.wordTextView;
        TextView textScore = holder.highscoreTextView;
        Button btn_delete = holder.btn_delete;

        textName.setText(dto.getName());
        textWord.setText(dto.getWord());
        textScore.setText(String.valueOf(dto.getFailedGeuss()));
        btn_delete.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }


    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView nameTextView;
        public TextView highscoreTextView;
        public TextView wordTextView;
        public Button btn_delete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.HI_name);
            wordTextView = (TextView) itemView.findViewById(R.id.HI_word);
            highscoreTextView = (TextView) itemView.findViewById(R.id.HI_score);
            btn_delete = itemView.findViewById(R.id.HI_Item_deletButton);
            btn_delete.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            int id =this.getLayoutPosition();
           // DatabaseHelper dh = new DatabaseHelper();
        }
    }
}

