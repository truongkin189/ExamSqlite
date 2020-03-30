package com.example.examsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SqliteHelper extends SQLiteOpenHelper {
    public static final String DATABASE = "QLSV";
    public static final String TABLE = "SV";
    public static final String NAME = "TEN";
    public static final String CODE = "MASV";
    public static final String MARK = "DIEMTB";

    SQLiteDatabase sqLiteDatabase;
    public SqliteHelper(@Nullable Context context) {
        super(context, DATABASE, null, 1);
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql  = " create table "+ TABLE + " ( " + NAME+ " nvarchar(60), "+ CODE + " char(20), "
                + MARK + " char(5))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = " drop table if exists " + TABLE;
        sqLiteDatabase.execSQL(sql);
    }

    // insert
    public  long InsertData(SinhVien sv ){
        ContentValues cv = new ContentValues();
        cv.put(NAME,sv.getTen());
        cv.put(CODE,sv.getMasv());
        cv.put(MARK,sv.getDiem());

     return sqLiteDatabase.insert(TABLE,null,cv);
    }
    // show
    public ArrayList<SinhVien>  ShowData(){
        String sql = " select * from " + TABLE;
        Cursor cs = sqLiteDatabase.rawQuery(sql,null);
        ArrayList<SinhVien> arr = new ArrayList<>();

        while (cs.moveToNext()){
            SinhVien sv = new SinhVien();
            sv.ten = cs.getString(0);
            sv.masv = cs.getString(1);
            sv.diem = cs.getString(2);
            arr.add(sv);
        }
        return arr;
    }
    public ArrayList<SinhVien>  ShowDataMax4(){
        String sql = " select * from SV WHERE DIEMTB<4";
        Cursor cs = sqLiteDatabase.rawQuery(sql,null);
        ArrayList<SinhVien> arr = new ArrayList<>();

        while (cs.moveToNext()){
            SinhVien sv = new SinhVien();
            sv.ten = cs.getString(0);
            sv.masv = cs.getString(1);
            sv.diem = cs.getString(2);
            arr.add(sv);
        }
        return arr;
    }
    public  void Deldata(String code){

      sqLiteDatabase.delete(TABLE,CODE + "=?",new String[]{code});

    }
    public  void Delall(){

        sqLiteDatabase.delete(TABLE,null,null);

    }
// cập nhật dữ liệu
    public  void UpdateData(SinhVien svnew,String code){

        ContentValues cv = new ContentValues();
        cv.put(NAME,svnew.getTen());
        cv.put(CODE,svnew.getMasv());
        cv.put(MARK,svnew.getDiem());
        //
        sqLiteDatabase.update(TABLE,cv,CODE + "=?",new String[]{code});
    }

}
