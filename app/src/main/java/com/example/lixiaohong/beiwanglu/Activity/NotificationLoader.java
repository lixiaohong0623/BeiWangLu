package com.example.lixiaohong.beiwanglu.Activity;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by li.xiaohong on 2015/12/16.
 */
public class NotificationLoader extends AsyncTaskLoader {

  private Context context;
  private String filter;
  public NotificationLoader(Context context,String filter){
    super(context);
    this.context = context;
    this.filter = filter;
  }
  @Override
  public Object loadInBackground() {
    return null;
  }
}
