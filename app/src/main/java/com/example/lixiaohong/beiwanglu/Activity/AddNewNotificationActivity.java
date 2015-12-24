package com.example.lixiaohong.beiwanglu.Activity;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lixiaohong.beiwanglu.DataBase.DatabaseFactory;
import com.example.lixiaohong.beiwanglu.DataBase.NotificationDatabase;
import com.example.lixiaohong.beiwanglu.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by li.xiaohong on 2015/12/22.
 */
public class AddNewNotificationActivity extends Activity implements View.OnClickListener {
  private TextView createTime;
  private TextView textShow;
  private TextView save;
  private ImageView voiceTextTransfer;
  private ImageView alarm;
  private EditText textInput;
  private String curTime;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_new_notification_activity);
    initialResources();
  }

  public void initialResources() {
    save = (TextView) findViewById(R.id.save);
    alarm = (ImageView) findViewById(R.id.alarm);
    textInput = (EditText) findViewById(R.id.et_text);
    textShow = (TextView) findViewById(R.id.tv_temp_show);
    createTime = (TextView) findViewById(R.id.time_today);
    voiceTextTransfer = (ImageView) findViewById(R.id.voice_text_transfer);
    curTime = getCreateTime();
    createTime.setText(curTime);
    textInput.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      @Override
      public void afterTextChanged(Editable s) {
        textShow.setText(s.toString());
      }
    });
    save.setOnClickListener(this);
  }

  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.voice_text_transfer:
        break;
      case R.id.alarm:
        break;
      case R.id.save:
        handleSaveNewNotification();
    }
  }

  public String getCreateTime() {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ");
    Date curDate = new Date(System.currentTimeMillis());
    String str = formatter.format(curDate);
    return str;
  }

  public void handleSaveNewNotification() {
    String notificationContent = textInput.getText().toString();
    if (notificationContent == null || notificationContent.isEmpty()) {
      Toast.makeText(this, "提醒内容为空，请重新输入", Toast.LENGTH_SHORT).show();
    } else {
      NotificationDatabase notificationDatabase = DatabaseFactory.getNotificationDatabase(this);
      ContentValues contentValues = new ContentValues();
      contentValues.put(NotificationDatabase.DATE_CREATE, curTime);
      contentValues.put(NotificationDatabase.CONTENT_TEXT, notificationContent);
      notificationDatabase.insertData(contentValues);
    }

    textInput.setText("");
    textShow.setText("");
  }
}
