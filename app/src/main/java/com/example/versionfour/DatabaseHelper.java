package com.example.versionfour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context)

    {
        super(context, "user.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(email text primary key,password text)");
        ContentValues cv=new ContentValues();
        String e="mit";
        String p="123";
        cv.put("email",e);
        cv.put("pass",p);
        long ins=db.insert("user",null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);

    }

    public void  insert()
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        String e="mit";
        String p="123";
        cv.put("email",e);
        cv.put("password",p);
        long ins=db.insert("user",null,cv);

    }

    public boolean checkEmail(String email,String pass)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from user where email=? and password=?",new String[]{email,pass});
        if(c.getCount()>0)return true;
        else
            return false;

    }
}
