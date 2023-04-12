package com.example.newtodolist;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class AddTask extends AppCompatActivity {

    private TextView banner;
    private EditText taskName;
    private Button setDate;
    private EditText viewDate;
    private Button confirmTask;
    Calendar taskDate = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        banner = findViewById(R.id.banner);
        taskName = findViewById(R.id.taskName);
        viewDate = findViewById(R.id.viewDate);
        setDate = findViewById(R.id.setDate);
        confirmTask = findViewById(R.id.confirmtask);

        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la fecha actual

                int year = taskDate.get(Calendar.YEAR);
                int month = taskDate.get(Calendar.MONTH);
                int day = taskDate.get(Calendar.DAY_OF_MONTH);

                // Crear una instancia de DatePickerDialog y mostrarla
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddTask.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                taskDate.set(year, monthOfYear, dayOfMonth);
                                String formattedDate = sdf.format(taskDate.getTime());
                                viewDate.setText(formattedDate);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        confirmTask.setOnClickListener(v -> {
            /*
            // Obtener la instancia de la referencia de la base de datos
            DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();

// Crear una nueva entrada en la base de datos con los datos del usuario y la tarea
            String userId = "usuario1"; // Obtener el ID del usuario
            String taskName = taskName.getText().toString();
            String taskDate = viewDate.getText().toString();
            Todo todo = new Todo(taskName, taskDate);
            databaseRef.child("users").child(userId).child("todos").push().setValue(todo);

             */


            Intent intent = new Intent(this, TodoList.class);
            startActivity(intent);


        });
    }
}
