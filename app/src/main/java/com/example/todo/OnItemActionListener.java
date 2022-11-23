package com.example.todo;

public interface OnItemActionListener {

    void onDelete(String id);
    void onEdit(ToDo todo);
}
