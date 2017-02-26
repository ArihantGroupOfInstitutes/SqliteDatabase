package com.sachinshelke.sqlitedatabase.database.wrapper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sachinshelke.sqlitedatabase.database.ArihantSqliteOpenHelper;
import com.sachinshelke.sqlitedatabase.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sachin K. Shelke on 26/02/17.
 */

public class StudentWrapper {


    ArihantSqliteOpenHelper openHelper;


    public void addStudent(Context context, Student student) {

        SQLiteDatabase database = new ArihantSqliteOpenHelper(context).getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("roll_no", student.getRollNumber());
            contentValues.put("student_name", student.getName());
            contentValues.put("mobile_number", student.getMobileNumber());
            contentValues.put("address", student.getAddress());
            contentValues.put("course_id", student.getCourseId());
            contentValues.put("year", student.getYear());
            contentValues.put("profile_pic", student.getProfilePic());


            database.insert("tbl_Student", null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.close();
            }
        }


    }


    public List<Student> getStudents(Context context) {

        List<Student> studentList = new ArrayList<>();

        SQLiteDatabase database = new ArihantSqliteOpenHelper(context).getWritableDatabase();
        Cursor cursor = null;
        try {


            cursor = database.query("tbl_Student", null, null, null, null, null, null);

            if (cursor.getCount() > 0) {
                cursor.moveToFirst();

                do {
                    Student student = new Student();
                    student.setRollNumber(cursor.getInt(cursor.getColumnIndex("roll_no")));
                    student.setName(cursor.getString(cursor.getColumnIndex("student_name")));
                    student.setMobileNumber(cursor.getLong(cursor.getColumnIndex("mobile_number")));
                    student.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                    student.setCourseId(cursor.getInt(cursor.getColumnIndex("course_id")));
                    student.setYear(cursor.getInt(cursor.getColumnIndex("year")));
                    student.setProfilePic(cursor.getString(cursor.getColumnIndex("profile_pic")));


                    studentList.add(student);


                } while (cursor.moveToNext());

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            {
                if (database != null) {
                    database.close();
                }

                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        return studentList;


    }


}






















