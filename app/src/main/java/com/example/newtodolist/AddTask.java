package com.example.newtodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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
    private Button addTask;
    Calendar taskDate = Calendar.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        findViewById(R.id.banner);
        findViewById(R.id.taskName);
        findViewById(R.id.viewDate);
        findViewById(R.id.setDate);
        findViewById(R.id.addTask);

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
                                String formattedDate = sdf.format(taskDate.getTime());
                                viewDate.setText(formattedDate);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });


    }
}