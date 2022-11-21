package com.example.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoViewHolder> {

    public ArrayList<ToDo> toDos;

    public void setData(ArrayList<ToDo> todosList) {
        toDos = todosList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_item, parent, false);
        ToDoViewHolder toDoViewHolder = new ToDoViewHolder(view);
        return toDoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDo toDo = toDos.get(position);
        holder.taskTxt.setText(toDo.task);
        holder.descriptionTxt.setText(toDo.description);
    }

    @Override
    public int getItemCount() {
        return toDos.size();
    }
}
