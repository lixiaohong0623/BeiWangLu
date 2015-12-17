package com.example.lixiaohong.beiwanglu.Activity;


import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;

import com.example.lixiaohong.beiwanglu.NotificationAdapter;

/**
 * Created by li.xiaohong on 2015/12/16.
 */
public class NotificationFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {


  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    initialAdapter();
  }

  public void initialAdapter(){
    setListAdapter(new NotificationAdapter(getActivity(),null));
  }
  @Override
  public Loader<Cursor> onCreateLoader(int id, Bundle args) {
    NotificationLoader notificationLoader = new NotificationLoader(getActivity().getApplicationContext(),null);
    return notificationLoader;
  }

  public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
    if (getListAdapter() != null) {
      ((CursorAdapter) getListAdapter()).changeCursor(cursor);
    }
  }

  @Override
  public void onLoaderReset(Loader<Cursor> arg0) {
    ((CursorAdapter)getListAdapter()).changeCursor(null);
  }
}
