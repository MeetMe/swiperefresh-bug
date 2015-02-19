package com.example.swiperefreshlayout.visibility;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;

public class FixedSwipeRefreshLayout extends SwipeRefreshLayout {
    private boolean mRefreshingOnVisible = false;

    public FixedSwipeRefreshLayout(Context context) {
        super(context);
    }

    public FixedSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        if (visibility != View.VISIBLE && isRefreshing()) {
            mRefreshingOnVisible = true;
            setRefreshing(false);
            clearDisappearingChildren();
        } else if (visibility == View.VISIBLE && mRefreshingOnVisible) {
            setRefreshing(true);
            mRefreshingOnVisible = false;
        }

        super.onVisibilityChanged(changedView, visibility);
    }
}
