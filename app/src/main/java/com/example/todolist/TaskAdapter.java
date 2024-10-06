package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private ArrayList<Task> taskList;
    private TaskDatabaseHelper dbHelper;

    public TaskAdapter(ArrayList<Task> taskList, TaskDatabaseHelper dbHelper) {
        this.taskList = taskList;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskDescription.setText(task.getDescription());
        holder.taskCheckbox.setChecked(task.isCompleted());

        holder.taskCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            dbHelper.updateTask(task.getId(), isChecked);
        });

        //Mise à Jour Dynamique de la Liste Lors de la Suppression
        holder.deleteButton.setOnClickListener(v -> {
            dbHelper.deleteTask(task.getId());
            taskList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, taskList.size());  // Mettre à jour les autres éléments
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public CheckBox taskCheckbox;
        public TextView taskDescription;
        public Button deleteButton;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskCheckbox = itemView.findViewById(R.id.taskCheckbox);
            taskDescription = itemView.findViewById(R.id.taskDescription);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
