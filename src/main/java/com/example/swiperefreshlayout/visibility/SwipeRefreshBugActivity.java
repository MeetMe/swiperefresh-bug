package com.example.swiperefreshlayout.visibility;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class SwipeRefreshBugActivity extends Activity {
    private static final String TAG = SwipeRefreshBugActivity.class.getSimpleName();

    private SwipeRefreshLayout mSrl1;
    private SwipeRefreshLayout mSrl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_refresh_bug);
        mSrl1 = (SwipeRefreshLayout) findViewById(R.id.srl1);
        mSrl2 = (SwipeRefreshLayout) findViewById(R.id.srl2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.swipe_refresh_bug, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        item.setChecked(!item.isChecked());

        if (id == R.id.set_refreshing) {
            Log.v(TAG, "set refreshing " + item.isChecked());
            mSrl1.setRefreshing(item.isChecked());
            mSrl2.setRefreshing(item.isChecked());
            return true;
        } else if (id == R.id.set_visible) {
            Log.v(TAG, "set visible " + item.isChecked());
            mSrl1.setVisibility(item.isChecked() ? View.VISIBLE : View.GONE);
            mSrl2.setVisibility(item.isChecked() ? View.VISIBLE : View.GONE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
