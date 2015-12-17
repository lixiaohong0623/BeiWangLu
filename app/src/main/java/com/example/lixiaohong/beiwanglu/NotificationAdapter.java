package com.example.lixiaohong.beiwanglu;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * Created by li.xiaohong on 2015/12/17.
 */
public class NotificationAdapter extends CursorAdapter {

  public NotificationAdapter(Context context,Cursor cursor){
    super(context,cursor,true);

  }
  /**
   * Bind an existing view to the data pointed to by cursor
   *
   * @param view    Existing view, returned earlier by newView
   * @param context Interface to application's global information
   * @param cursor  The cursor from which to get the data. The cursor is already
   */
  @Override
  public void bindView(View view, Context context, Cursor cursor) {

  }

  /**
   * Makes a new view to hold the data pointed to by cursor.
   *
   * @param context Interface to application's global information
   * @param cursor  The cursor from which to get the data. The cursor is already
   *                moved to the correct position.
   * @param parent  The parent to which the new view is attached to
   * @return the newly created view.
   */
  @Override
  public View newView(Context context, Cursor cursor, ViewGroup parent) {
    return null;
  }
}
