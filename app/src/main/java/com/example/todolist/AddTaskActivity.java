package com.example.todolist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {
    private EditText taskDescription;
    private Button saveButton;
    private TaskDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskDescription = findViewById(R.id.taskDescription);
        saveButton = findViewById(R.id.saveButton);
        // Vérifiez que les vues ne sont pas nulles
        if (taskDescription == null) {
            Log.e("AddTaskActivity", "taskDescription n'est pas initialisé correctement !");
        }
        if (saveButton == null) {
            Log.e("AddTaskActivity", "saveButton n'est pas initialisé correctement !");
        }
        dbHelper = new TaskDatabaseHelper(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = taskDescription.getText().toString();
                dbHelper.addTask(new Task(0, description, false));
                setResult(RESULT_OK);  // Envoyer un résultat positif à MainActivity
                finish(); // Retourner à l'activité principale après l'ajout
            }
        });
    }
}
