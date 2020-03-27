package com.example.student_feedback;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Timer;

public class DBhelper extends SQLiteOpenHelper {

    static String DB_Name = "details.db";
    static int DB_version = 1;

    public static String Table_Name = "details";
    public static String ID_COL = "ID";
    public static String NAM_COL = "NAME";
    public static String CLG_COL = "COLLEGE";
    public static String YEAR_COL = "YEAR";
    public static String EMAIL_COL = "EMAIL";
    public static String MOB_COL = "MOBILE";
    public static String FEEDBACK_COL = "FEEDBACK";
    public static String WRITE_COL = "WRITE";
    public static String RATING_COL = "RATING";
    public static String TIME_COL = "TIME";

    public static String query = "CREATE TABLE details("+ID_COL+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAM_COL+" TEXT, "
            +CLG_COL+" TEXT, "+YEAR_COL+" TEXT, "+EMAIL_COL+" TEXT, "+MOB_COL+" TEXT, "+FEEDBACK_COL+" TEXT, "+WRITE_COL+" TEXT, "+RATING_COL+" INTEGER, "+TIME_COL+" TEXT)";

    public DBhelper(@Nullable Context context) {
        super(context, DB_Name, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public ArrayList<data> getData(){
        ArrayList<data> ulist = new ArrayList<data>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = db.rawQuery("SELECT * FROM details", null);
            c.moveToFirst();
            do {
                String name = c.getString(c.getColumnIndex(NAM_COL));
                String college = c.getString(c.getColumnIndex(CLG_COL));
                String year = c.getString(c.getColumnIndex(YEAR_COL));
                String email = c.getString(c.getColumnIndex(EMAIL_COL));
                String mobile = c.getString(c.getColumnIndex(MOB_COL));
                String feedback = c.getString(c.getColumnIndex(FEEDBACK_COL));
                String write = c.getString(c.getColumnIndex(WRITE_COL));
                int rating = c.getInt(c.getColumnIndex(RATING_COL));
                String time = c.getString(c.getColumnIndex(TIME_COL));

                data dts = new data(name, college, year, email, mobile, feedback, write, rating, time);
                ulist.add(dts);
            } while (c.moveToNext());
            return ulist;
        } catch (Exception ee){
            Log.e("Error","Unsuccessful");
        }
        return ulist;
    }

    public boolean insert(data e){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAM_COL, e.name);
        cv.put(CLG_COL, e.college);
        cv.put(YEAR_COL, e.year);
        cv.put(EMAIL_COL, e.email);
        cv.put(MOB_COL, e.mobile);
        cv.put(FEEDBACK_COL, e.feedback);
        cv.put(WRITE_COL, e.write);
        cv.put(RATING_COL, e.rating);
        cv.put(TIME_COL, e.time);
        db.insert("details", null, cv);
        return true;
    }

    public boolean delete_data(String name){

        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("DELETE FROM " + "details " + "WHERE NAME "+"=\"" + name + "\";");

        } catch (Exception e){
            Log.e("Error","Unsuccessfull.");
            return  false;
        }return  true;
    }
}
