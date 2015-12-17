package com.example.lixiaohong.beiwanglu.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lixiaohong.beiwanglu.CommonUtil;
import com.example.lixiaohong.beiwanglu.NotificationRecord;

import java.util.ArrayList;
/**
 * Created by li.xiaohong on 2015/12/14.
 */
public class NotificationDatabase {

  private Context context;
  private SQLiteOpenHelper sqLiteOpenHelper;
  private static final String TAG = "NotificationDatabase";
  private static final String TABLE_NAME    = "notification";
  private static final String ID             = "_id";
  private static final String DATE_CREATE   = "date_create";
  private static final String DATE_NOTIFY   = "date_notify";
  private static final String CONTENT_TEXT  = "content_text";
  private static final String CONTENT_IMAGE = "content_image";
  private static final String CONTENT_AUDIO = "content_audio";
  private static final String MEM_NOTIFY    = "men_notify";
  private static final String IS_OVERTIME   = "is_overtime";
  public static final String CREATE_TABLE   = "CREATE TABLE " + TABLE_NAME + "(" + ID + "INTEGER PRIMARY KEY, " + DATE_CREATE +
          "INTEGER, " + DATE_NOTIFY + "INTEGER, " + CONTENT_TEXT + "TEXT, " + CONTENT_IMAGE +"TEXT, "+CONTENT_AUDIO+"TEXT, "+
          MEM_NOTIFY +"TEXT );";

  public NotificationDatabase(Context context, SQLiteOpenHelper sqLiteOpenHelper) {
    this.context = context;
    this.sqLiteOpenHelper = sqLiteOpenHelper;
  }

  public void insertData(ContentValues contentValues){
    SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
  }

  public void updateStatus(int id, int status) {
    SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    String sql = "UPDATE " + TABLE_NAME + " set " + IS_OVERTIME + status + " where " + ID + "=" + id;
    sqLiteDatabase.execSQL(sql);
  }

  public Cursor query(String filter, String orderBy){
    SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    if (orderBy == null){
      orderBy = NotificationDatabase.DATE_CREATE + "ACS";
    }
    return sqLiteDatabase.query(TABLE_NAME,null,null,null,null,orderBy,null);
  }

  public class Reader {
    private final Cursor cursor;
    public Reader( Cursor cursor) {
      this.cursor       = cursor;
    }

    public NotificationRecord getNext() {
      if (cursor == null || !cursor.moveToNext())
        return null;
      return getCurrent();
    }

    public NotificationRecord getCurrent(){
      int id            = cursor.getInt(cursor.getColumnIndexOrThrow(ID));
      long dateCreate   = cursor.getLong(cursor.getColumnIndexOrThrow(DATE_CREATE));
      long dateNotify   = cursor.getLong(cursor.getColumnIndexOrThrow(DATE_NOTIFY));
      String text       = cursor.getString(cursor.getColumnIndexOrThrow(CONTENT_TEXT));
      String imageUri   = cursor.getString(cursor.getColumnIndexOrThrow(CONTENT_IMAGE));
      String audioUri   = cursor.getString(cursor.getColumnIndexOrThrow(CONTENT_AUDIO));
      String men        = cursor.getString(cursor.getColumnIndexOrThrow(MEM_NOTIFY));
      int isOvertime    = cursor.getInt(cursor.getColumnIndexOrThrow(IS_OVERTIME));
      String phoneString = cursor.getString(cursor.getColumnIndexOrThrow(MEM_NOTIFY));
      ArrayList<String> phoneList = new CommonUtil().phoneStringToList(phoneString);
      return new NotificationRecord(id,dateCreate,dateNotify,text,imageUri,audioUri,phoneList,isOvertime);
    }

  }


}
