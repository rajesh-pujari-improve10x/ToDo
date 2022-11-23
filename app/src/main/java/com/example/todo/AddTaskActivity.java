package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTaskActivity extends AppCompatActivity {

    EditText taskTextTxt;
    EditText descriptionTextTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setTitle("Add Task");
        handleAddBtn();
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
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, TaskListActivity.class);
            taskTextTxt = findViewById(R.id.task_text_txt);
            String task = taskTextTxt.getText().toString();
            descriptionTextTxt = findViewById(R.id.description_text_txt);
            String description = descriptionTextTxt.getText().toString();
            addTask(task, description);
            startActivity(intent);
        });
    }
}