package com.example.lixiaohong.beiwanglu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.lixiaohong.beiwanglu.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements View.OnClickListener{

  private ViewPager viewPager;
  private TextView  tvNotify;
  private TextView  tvWeather;
  private TextView  tvTopic;
  private List<Fragment> fragmentList;
  private ArrayList<Fragment> viewContainer;

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
    switch (id){
      case R.id.menu_add_new_notification:
        handleAddNewNotification();
        break;
    }

    return super.onOptionsItemSelected(item);
  }



  private void initialResources(){
    viewPager = (ViewPager) findViewById(R.id.viewPager);
    tvNotify  = (TextView) findViewById(R.id.tv_myStaff);
    tvWeather = (TextView) findViewById(R.id.tv_weather);
    tvTopic   = (TextView) findViewById(R.id.tv_myTopic);
    viewContainer = new ArrayList<Fragment>();
    Fragment notificationFragment = new NotificationFragment();
    Fragment weatherFragment = new WeatherFragment();
    View view2 = LayoutInflater.from(this).inflate(R.layout.weather_fragment, null);
    viewContainer.add(notificationFragment);
    viewContainer.add(weatherFragment);
    viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
    viewPager.setCurrentItem(0);
    tvNotify.setPressed(true);
    tvWeather.setPressed(false);
    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override
      public void onPageSelected(int position) {
       switch (position){
         case 0:
           tvNotify.setPressed(true);
           tvWeather.setPressed(false);
           break;
         case 1:
           tvWeather.setPressed(true);
           tvNotify.setPressed(false);
           break;
       }
      }

      @Override
      public void onPageScrollStateChanged(int state) {
      }
    });
    tvNotify.setOnClickListener(this);
    tvWeather.setOnClickListener(this);
  }

  public class MyFragmentAdapter extends FragmentPagerAdapter{
    public MyFragmentAdapter(FragmentManager fm) {
      super(fm);
    }
    public  Fragment getItem(int position){
      return (Fragment)viewContainer.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
      return viewContainer.size();
    }
  }

  public void handleAddNewNotification(){
    Intent intent = new Intent(MainActivity.this,AddNewNotificationActivity.class);
    startActivity(intent);
  }

  public void onClick( View view) {
    switch (view.getId()){
      case R.id.tv_myStaff:
        viewPager.setCurrentItem(0);
        tvNotify.setPressed(true);
        tvWeather.setPressed(false);
        break;
      case R.id.tv_weather:
        viewPager.setCurrentItem(1);
        tvNotify.setPressed(false);
        tvWeather.setPressed(true);
        break;
    }
  }
}
