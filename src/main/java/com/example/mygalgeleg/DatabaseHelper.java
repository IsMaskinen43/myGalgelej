package com.example.mygalgeleg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "Highscore";
    private static final String col0 = "ID";
    private static final String col1 = "NAME";
    private static final String col2 = "WORD";
    private static final String col3 = "FAILS";


    public DatabaseHelper( Context context) {
        super(context,TABLE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE Highscore (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, WORD TEXT, FAILS INTEGER)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addData(DTOhigscore dto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1, dto.getName());
        contentValues.put(col2, dto.getWord());
        contentValues.put(col3, dto.getFailedGeuss());

        //Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void deleteData(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID = " +id,null);

    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
