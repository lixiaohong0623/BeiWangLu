package com.example.lixiaohong.beiwanglu;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lixiaohong.beiwanglu.DataBase.NotificationDatabase;

/**
 * Created by li.xiaohong on 2015/12/17.
 */
public class NotificationAdapter extends CursorAdapter {

  public NotificationAdapter(Context context,Cursor cursor){
    super(context,cursor,true);

  }

  @Override
  public void bindView(View view, Context context, Cursor cursor) {
    ViewHolder viewHolder = (ViewHolder) view.getTag();
    long dateCreate = cursor.getLong(cursor.getColumnIndexOrThrow(NotificationDatabase.DATE_CREATE));
    String content = cursor.getString(cursor.getColumnIndexOrThrow(NotificationDatabase.CONTENT_TEXT));
    int hasAlarm = cursor.getInt(cursor.getColumnIndexOrThrow(NotificationDatabase.HAS_ALARM));
    viewHolder.date.setText(Long.toString(dateCreate));
    viewHolder.content.setText(content);
    viewHolder.alarm.setVisibility(hasAlarm == 0 ? View.GONE : View.VISIBLE);
  }

  @Override
  public View newView(Context context, Cursor cursor, ViewGroup parent) {
    ViewHolder viewHolder = new ViewHolder();
    LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = layoutInflater.inflate(R.layout.notification_list_view,parent,false);
    viewHolder.date = (TextView)view.findViewById(R.id.date);
    viewHolder.content = (TextView)view.findViewById(R.id.content);
    viewHolder.alarm = (ImageView)view.findViewById(R.id.alarm);
    view.setTag(viewHolder);
    return  view;
  }


  public class ViewHolder {
    private TextView date;
    private TextView content;
    private ImageView alarm;
  }
}
