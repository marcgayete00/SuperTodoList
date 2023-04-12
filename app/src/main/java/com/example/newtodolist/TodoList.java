package com.example.newtodolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TodoList extends AppCompatActivity {

    private TextView banner;
    private Button addTask;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        banner = findViewById(R.id.banner);
        addTask = findViewById(R.id.addtask);

        addTask.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddTask.class);
            startActivity(intent);
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> data = new ArrayList<>();
        Adapter adapter = new Adapter(data);
        recyclerView.setAdapter(adapter);


    }
}