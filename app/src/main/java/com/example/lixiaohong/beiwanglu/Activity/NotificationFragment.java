package com.example.lixiaohong.beiwanglu.Activity;


import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;

/**
 * Created by li.xiaohong on 2015/12/16.
 */
public class NotificationFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {


  @Override
  public Loader<Cursor> onCreateLoader(int id, Bundle args) {
    return null;
  }

  public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
    ((CursorAdapter)getListAdapter()).changeCursor(cursor);
  }

  @Override
  public void onLoaderReset(Loader<Cursor> arg0) {
    ((CursorAdapter)getListAdapter()).changeCursor(null);
  }
}
