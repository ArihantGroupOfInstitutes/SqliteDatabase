package com.sachinshelke.sqlitedatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sachinshelke.sqlitedatabase.database.wrapper.StudentWrapper;
import com.sachinshelke.sqlitedatabase.model.Student;

import java.util.List;
import java.util.Random;

public class LoginActivity extends AppCompatActivity {


    private StudentWrapper studentWrapper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        studentWrapper = new StudentWrapper();
    }

    public void login(View view) {


        for (int i = 0; i < 5; i++) {
            Student student = new Student();


            student.setName("Abc Xyx");
            student.setAddress("Pulgate Bus Stand, Pune");
            student.setMobileNumber(new Random(9999999999L).nextLong());
            student.setCourseId(1);
            student.setYear(2);
            student.setProfilePic("db");
            student.setRollNumber(100 + i);

            studentWrapper.addStudent(this, student);
        }


    }


    public void register(View view) {

        List<Student> studentList = studentWrapper.getStudents(this);


    }
}
