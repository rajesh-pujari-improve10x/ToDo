package com.example.todo;

import com.google.gson.annotations.SerializedName;

public class ToDo {
    @SerializedName("_id")
    public String id;
    public String task;
    public String description;
}
