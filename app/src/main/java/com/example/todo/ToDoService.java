package com.example.todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ToDoService {
    @GET("rajeshTodo")
    Call<List<ToDo>> rajeshTasks();

    @POST("rajeshTodo")
    Call<ToDo> createTask(@Body ToDo toDo);

    @DELETE("rajeshTodo/{id}")
    Call<Void> deleteTask(@Path("id") String id);

    @PUT("rajeshTodo/{id}")
    Call<Void> updateTask(@Path("id") String id, @Body ToDo toDo);
}
