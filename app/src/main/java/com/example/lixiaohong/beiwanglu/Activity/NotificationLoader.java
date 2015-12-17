package com.example.lixiaohong.beiwanglu.Activity;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;

import com.example.lixiaohong.beiwanglu.DataBase.DatabaseFactory;

/**
 * Created by li.xiaohong on 2015/12/16.
 */
public class NotificationLoader extends CursorLoader {

  private Context context;
  private String filter;

  public NotificationLoader(Context context, String filter) {
    super(context);
    this.context = context;
    this.filter = filter;
  }

  @Override
  public Cursor loadInBackground() {
    Cursor cursor = DatabaseFactory.getNotificationDatabase(context).query(filter, null);
    return (cursor == null && cursor.moveToNext()) ? cursor : null;
  }
}
