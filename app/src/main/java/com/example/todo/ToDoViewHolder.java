package com.example.todo;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ToDoViewHolder extends RecyclerView.ViewHolder {

    public TextView taskTxt;
    public TextView descriptionTxt;
    public ImageButton deleteBtn;

    public ToDoViewHolder(@NonNull View itemView) {
        super(itemView);
        taskTxt = itemView.findViewById(R.id.task_txt);
        descriptionTxt = itemView.findViewById(R.id.description_txt);
        deleteBtn = itemView.findViewById(R.id.delete_btn);
    }
}
