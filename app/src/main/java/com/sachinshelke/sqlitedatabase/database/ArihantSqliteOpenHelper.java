package com.sachinshelke.sqlitedatabase.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Sachin K. Shelke on 26/02/17.
 */

public class ArihantSqliteOpenHelper extends SQLiteOpenHelper {


    private final String TAG = ArihantSqliteOpenHelper.class.getSimpleName();


    public static final String DB_NAME = "STUDENT.db";
    private static final int DB_VERSION = 1;


    public ArihantSqliteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "In Database OnCreate Method");


        db.execSQL("create table tbl_User (user_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, username text, password text, last_modified_data datetime)");
        db.execSQL("create table tbl_Student(student_id integer PRIMARY KEY AUTOINCREMENT NOT NULL, roll_no number, student_name text, address text, mobile_number number, course_id integer, year integer, profile_pic text)");
        db.execSQL("create table tbl_Courses(course_id integer PRIMARY KEY AUTOINCREMENT NOT NULL, course_name text, abbrivation text, total_years int)");
        db.execSQL("create table tbl_Subject(subject_id integer PRIMARY KEY AUTOINCREMENT NOT NULL, course_id integer, subject_name text, year int, subject_abbrivation text)");


        Log.v(TAG, "Four table created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        Log.d(TAG, "In Database OnCreate Method");

    }


    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
