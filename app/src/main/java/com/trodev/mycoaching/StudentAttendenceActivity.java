package com.trodev.mycoaching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StudentAttendenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendence);

        getSupportActionBar().setTitle("Student Attendence");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}