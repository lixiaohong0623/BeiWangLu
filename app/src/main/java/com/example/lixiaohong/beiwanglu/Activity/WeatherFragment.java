package com.example.lixiaohong.beiwanglu.Activity;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lixiaohong.beiwanglu.R;

/**
 * Created by li.xiaohong on 2015/12/16.
 */
public class WeatherFragment extends Fragment {
  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.weather_fragment,container,false);
    return view;
  }
}
