package com.example.tranvanha.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    private static String DATABASE_NAME="Class19.db";
    private String TABLE_NAME="sanpham";
    private String CREATE_TABLE = "create table sanpham (masanpham text,tensanpham text,giatien int)";
    private String DELETE_TABLE = "drop table if exists sanpham";

    public MyDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, factory, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }
    public void insertSanpham (String masp,String tensp,int giatien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("masanpham", masp);
        values.put("tensanpham", tensp);
        values.put("giatien", giatien);
        db.insert(TABLE_NAME, null, values);
    }
    public ArrayList<Sanpham> getSanpham1(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from sanpham";
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Sanpham> sanphamlists = new ArrayList<>();
        while (cursor.moveToNext()){
            String u = cursor.getString(cursor.getColumnIndexOrThrow("masanpham"));
            String p = cursor.getString(cursor.getColumnIndexOrThrow("tensanpham"));
            int v = cursor.getInt(cursor.getColumnIndexOrThrow("giatien"));
            Sanpham sanpham=new Sanpham(u,p,v);
            sanphamlists.add(sanpham);
        }
        return sanphamlists;

    }


    }


