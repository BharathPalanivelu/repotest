package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.feeds.feedlibrary.util.h;

public class SearchLoadMoreRecycyleView extends RecyclerView {
    private a M;
    private boolean N;
    private int O;
    private int P;
    private int Q;

    public interface a {
        void a();
    }

    private void z() {
    }

    public SearchLoadMoreRecycyleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchLoadMoreRecycyleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchLoadMoreRecycyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.N = false;
        z();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.O = (int) motionEvent.getRawY();
        } else if (action == 1) {
            int i = this.O;
            int i2 = this.P;
            if (i - i2 >= this.Q && !this.N && i2 > 0 && y()) {
                setLoading(true);
                a aVar = this.M;
                if (aVar != null) {
                    aVar.a();
                }
            }
        } else if (action == 2) {
            this.P = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setLoading(boolean z) {
        this.N = z;
    }

    public void setOnLoadListener(a aVar) {
        this.M = aVar;
    }

    public boolean y() {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) getLayoutManager();
        int p = gridLayoutManager.p();
        int y = gridLayoutManager.y();
        int I = gridLayoutManager.I();
        int scrollState = getScrollState();
        h.b("%s", "dbcanLoadMore " + I + "," + p + "," + y + "," + scrollState);
        return y > 0 && p == I - 1 && scrollState == 1;
    }
}
