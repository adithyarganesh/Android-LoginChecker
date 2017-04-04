package com.example.arvind.basicproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public String DATABASE = "data";
    public String TABLE = "DATA";
    public String ITEM = "ITEM";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "data", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DATA ( ITEM VARCHAR(30) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addData(String s){
        ContentValues cv = new ContentValues();
        cv.put(ITEM,s);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("DATA", null, cv);
    }

    ArrayList<String> displayData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM DATA", null);
        c.moveToFirst();
        ArrayList<String> arrayList = new ArrayList<String>();
        while(!c.isAfterLast()){
            if(c.getString(0)!=null){
                arrayList.add(c.getString(0));
            }c.moveToNext();
        }
        return arrayList;
    }

    boolean checker(String s){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM DATA WHERE ITEM = " + "\"" + s + "\"" , null);
        c.moveToFirst();
        if(c.getCount() != 0) return true;
        else return false;
    }
}
