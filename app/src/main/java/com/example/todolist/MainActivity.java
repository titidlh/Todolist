package com.example.todolist;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TaskDatabaseHelper dbHelper;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private ArrayList<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new TaskDatabaseHelper(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        taskList = new ArrayList<>();
        loadTasks();

        adapter = new TaskAdapter(taskList, dbHelper);
        recyclerView.setAdapter(adapter);

        Button addButton = findViewById(R.id.addButton);
        // Vérifiez que les vues ne sont pas nulles
        if (recyclerView == null) {
            Log.e("MainActivity", "RecyclerView n'est pas initialisé correctement !");
        }
        if (addButton == null) {
            Log.e("MainActivity", "addButton n'est pas initialisé correctement !");
        }
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddTaskActivity.class));
            }
        });
    }

    private void loadTasks() {
        Cursor cursor = dbHelper.getAllTasks();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(TaskDatabaseHelper.COLUMN_ID));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(TaskDatabaseHelper.COLUMN_DESCRIPTION));
                boolean completed = cursor.getInt(cursor.getColumnIndexOrThrow(TaskDatabaseHelper.COLUMN_COMPLETED)) == 1;

                // Vérifier si la tâche est déjà dans la liste avant de l'ajouter
                if (!taskExists(id)) {
                    taskList.add(new Task(id, description, completed));
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    // Méthode pour vérifier si la tâche existe déjà dans la liste
    private boolean taskExists(int taskId) {
        for (Task task : taskList) {
            if (task.getId() == taskId) {
                return true;
            }
        }
        return false;
    }


    @Override
    protected void onResume() {
        super.onResume();
        reloadTasks();  // Recharger les tâches lorsque l'activité revient en avant-plan
    }

    private void reloadTasks() {
        taskList.clear();  // Vider la liste actuelle
        loadTasks();  // Recharger les tâches depuis la base de données
        adapter.notifyDataSetChanged();  // Notifier l'adapter que les données ont changé
    }

}
