package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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

    public void handleAddBtn() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, TaskListActivity.class);
            taskTextTxt = findViewById(R.id.task_text_txt);
            String task = taskTextTxt.getText().toString();
            descriptionTextTxt = findViewById(R.id.description_text_txt);
            String description = descriptionTextTxt.getText().toString();
            intent.putExtra("Task", task);
            intent.putExtra("Description", description);
            startActivity(intent);
        });
    }
}