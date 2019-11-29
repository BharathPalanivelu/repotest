package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LoadMoreRecycyleView extends RecyclerView {
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

    public LoadMoreRecycyleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LoadMoreRecycyleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadMoreRecycyleView(Context context, AttributeSet attributeSet, int i) {
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
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        return linearLayoutManager.y() > 0 && linearLayoutManager.p() == linearLayoutManager.I() - 1 && getScrollState() == 1;
    }
}
