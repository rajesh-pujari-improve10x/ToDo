package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListActivity extends AppCompatActivity {

    public ArrayList<ToDo> todos = new ArrayList<>();
    public RecyclerView taskListRv;
    public ToDoAdapter toDoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        getSupportActionBar().setTitle("Task List");
        handleAddBtn();
        setupTaskListRv();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    public void fetchData() {
        ToDoApi toDoApi = new ToDoApi();
        ToDoService toDoService = toDoApi.createToDOService();
        Call<List<ToDo>> call = toDoService.rajeshTasks();
        call.enqueue(new Callback<List<ToDo>>() {
            @Override
            public void onResponse(Call<List<ToDo>> call, Response<List<ToDo>> response) {
                List<ToDo> toDoList =  response.body();
                toDoAdapter.setData(toDoList);
            }

            @Override
            public void onFailure(Call<List<ToDo>> call, Throwable t) {
                Toast.makeText(TaskListActivity.this, "Failed To Load Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setupTaskListRv() {
        taskListRv = findViewById(R.id.task_list_rv);
        taskListRv.setLayoutManager(new LinearLayoutManager(this));
        toDoAdapter = new ToDoAdapter();
        toDoAdapter.setData(todos);
        taskListRv.setAdapter(toDoAdapter);
    }

    public void handleAddBtn() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
        });
    }
}