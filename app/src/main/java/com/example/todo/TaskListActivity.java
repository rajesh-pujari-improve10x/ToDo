package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    public ArrayList<ToDo> todos;
    public RecyclerView taskListRv;
    public ToDoAdapter toDoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        getSupportActionBar().setTitle("Task List");
        handleAddBtn();
        setupTaskListData();
        setupTaskListRv();
    }

    public void setupTaskListData() {
        todos = new ArrayList<>();

        ToDo getVegetables = new ToDo();
        getVegetables.task = "get vegetables";
        getVegetables.description = "for 1 week";
        todos.add(getVegetables);

        ToDo readingNews = new ToDo();
        readingNews.task = "Reading news";
        readingNews.description = "Explore politics, filmy and sport news";
        todos.add(readingNews);

        ToDo prepareLunch = new ToDo();
        prepareLunch.task = "Prepare Lunch";
        prepareLunch.description = "Biryani and Raitha. yummyyyyy";
        todos.add(prepareLunch);

        ToDo haveBreakfast = new ToDo();
        haveBreakfast.task = "Have Breakfast";
        haveBreakfast.description = "Healthy breakfast for a better morning";
        todos.add(haveBreakfast);
    }

    public void setupTaskListRv() {
        taskListRv = findViewById(R.id.task_list_rv);
        taskListRv.setLayoutManager(new LinearLayoutManager(this));
        toDoAdapter = new ToDoAdapter();
        toDoAdapter.setData(todos);
        taskListRv.setAdapter(toDoAdapter);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
    }

    public void handleAddBtn() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
        });
    }
}