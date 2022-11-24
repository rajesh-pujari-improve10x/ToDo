package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTaskActivity extends AppCompatActivity {

    public ToDo toDo;
    public EditText taskTextTxt;
    public EditText descriptionTextTxt;
    public Button addBtn;
    public Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        taskTextTxt = findViewById(R.id.task_text_txt);
        descriptionTextTxt = findViewById(R.id.description_text_txt);
        addBtn = findViewById(R.id.add_btn);
        updateBtn = findViewById(R.id.update_btn);
        if (getIntent().hasExtra("ToDo")) {
            getSupportActionBar().setTitle("Edit Task");
            toDo = (ToDo) getIntent().getSerializableExtra("ToDo");
            updateBtn.setVisibility(View.VISIBLE);
            addBtn.setVisibility(View.GONE);
            showData();
            handleUpdateBtn();
        } else {
            getSupportActionBar().setTitle("Add Task");
            updateBtn.setVisibility(View.GONE);
            addBtn.setVisibility(View.VISIBLE);
            handleAddBtn();
        }
    }

    public void addTask(String taskName, String description) {
        ToDo toDo = new ToDo();
        toDo.task = taskName;
        toDo.description = description;

        ToDoApi toDoApi = new ToDoApi();
        ToDoService toDoService = toDoApi.createToDOService();
        Call<ToDo> call = toDoService.createTask(toDo);
        call.enqueue(new Callback<ToDo>() {
            @Override
            public void onResponse(Call<ToDo> call, Response<ToDo> response) {
                //Toast.makeText(AddTaskActivity.this, "Successfully Added New Task", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ToDo> call, Throwable t) {
                Toast.makeText(AddTaskActivity.this, "Failed The Add New Task", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void handleAddBtn() {
        addBtn.setOnClickListener(view -> {
            String task = taskTextTxt.getText().toString();
            String description = descriptionTextTxt.getText().toString();
            addTask(task, description);
        });
    }

    public void showData() {
        taskTextTxt.setText(toDo.task);
        descriptionTextTxt.setText(toDo.description);
    }

    public void handleUpdateBtn() {
        updateBtn.setOnClickListener(view -> {
            String task = taskTextTxt.getText().toString();
            String description = descriptionTextTxt.getText().toString();
            updateTask(toDo.id, task, description);
        });
    }

    public void updateTask(String id, String taskName, String description) {
        toDo = new ToDo();
        toDo.task = taskName;
        toDo.description = description;

        ToDoApi toDoApi = new ToDoApi();
        ToDoService toDoService = toDoApi.createToDOService();
        Call<Void> call = toDoService.updateTask(id, toDo);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(AddTaskActivity.this, "Successfully Updated Task", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AddTaskActivity.this, "Failed Update Task", Toast.LENGTH_SHORT).show();
            }
        });
    }
}