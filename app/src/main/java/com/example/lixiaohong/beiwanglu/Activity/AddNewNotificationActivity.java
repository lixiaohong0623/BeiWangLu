package com.example.lixiaohong.beiwanglu.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lixiaohong.beiwanglu.R;

import java.util.Calendar;

/**
 * Created by li.xiaohong on 2015/12/22.
 */
public class AddNewNotificationActivity extends Activity implements View.OnClickListener {
  private TextView createTime;
  private TextView textShow;
  private ImageView voiceTextTransfer;
  private ImageView alarm;
  private EditText textInput;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_new_notification_activity);
    initialResources();
  }

  public void initialResources() {
    alarm = (ImageView) findViewById(R.id.alarm);
    textInput = (EditText) findViewById(R.id.et_text);
    createTime = (TextView) findViewById(R.id.time_today);
    textShow = (TextView) findViewById(R.id.tv_temp_show);
    voiceTextTransfer = (ImageView) findViewById(R.id.voice_text_transfer);
    createTime.setText(getCreateTime());
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
  }

  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.voice_text_transfer:
        break;
      case R.id.alarm:
        break;
    }
  }

  public String getCreateTime() {
    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH);
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);
    return year + "年" + month + "月" + day + "日" + hour + ":" + minute;
  }
}
