package com.example.myapplication;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "UserDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(name TEXT PRIMARY KEY, contact TEXT, dob TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public boolean insertData(String n, String c, String d) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("name", n); v.put("contact", c); v.put("dob", d);
        return db.insert("users", null, v) != -1;
    }

    public boolean updateData(String n, String c, String d) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("contact", c); v.put("dob", d);
        return db.update("users", v, "name=?", new String[]{n}) > 0;
    }

    public boolean deleteData(String n) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete("users", "name=?", new String[]{n}) > 0;
    }

    public Cursor getData() {
        return getReadableDatabase().rawQuery("SELECT * FROM users", null);
    }
}
