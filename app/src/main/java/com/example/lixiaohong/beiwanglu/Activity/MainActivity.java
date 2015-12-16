package com.example.lixiaohong.beiwanglu.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lixiaohong.beiwanglu.R;

import java.util.List;


public class MainActivity extends Activity {

  private ViewPager viewPager;
  private TextView  tvNotify;
  private TextView  tvWhether;
  private TextView  tvTopic;
  private List<Fragment> fragmentList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initialResources();
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  private void initialResources(){
    viewPager = (ViewPager) findViewById(R.id.viewPager);
    tvNotify  = (TextView) findViewById(R.id.tv_myStaff);
    tvWhether = (TextView) findViewById(R.id.tv_whether);
    tvTopic   = (TextView) findViewById(R.id.tv_myTopic);
    
  }
}
