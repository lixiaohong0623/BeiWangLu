package com.example.lixiaohong.beiwanglu.DataBase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lixiaohong.beiwanglu.DataBase.NotificationDatabase;

import java.util.Objects;

/**
 * Created by li.xiaohong on 2015/12/11.
 */
public class DatabaseFactory {
  private static final String TAG = "DatabaseFactory";
  private static final String DATABASE_NAME = "BeiWangLu";
  private static final int DATABASE_VERSION = 1;
  private static final Object lock = new Object();
  private static DatabaseFactory instance;

  private DatabaseHelper databaseHelper;
  private NotificationDatabase notificationDatabase;

  private DatabaseFactory(Context context) {
    this.databaseHelper = new DatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    this.notificationDatabase = new NotificationDatabase(context,databaseHelper);

  }

  public static DatabaseFactory getInstance(Context context) {
    synchronized (lock) {
      if (instance == null) {
        instance = new DatabaseFactory(context);
      }
      return instance;
    }
  }

  public static NotificationDatabase getNotificationDatabase(Context context) {
    return getInstance(context).notificationDatabase;
  }

  public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
      super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(NotificationDatabase.CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
  }
}
