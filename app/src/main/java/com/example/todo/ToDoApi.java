package com.example.todo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ToDoApi {

    public ToDoService createToDOService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crudcrud.com/api/479dd07f8c1d482e9219f7dcb48e25f4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ToDoService toDoService = retrofit.create(ToDoService.class);
        return  toDoService;
    }
}
