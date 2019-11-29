package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import androidx.core.g.w;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.shopee.feeds.feedlibrary.c;

public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f28425a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f28426b;

    /* renamed from: c  reason: collision with root package name */
    private a f28427c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f28428d;

    /* renamed from: e  reason: collision with root package name */
    private int f28429e;

    /* renamed from: f  reason: collision with root package name */
    private int f28430f;

    /* renamed from: g  reason: collision with root package name */
    private int f28431g;

    public interface a {
        void i();
    }

    public CustomSwipeRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28428d = false;
        this.f28431g = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setScrollUpChild(View view) {
        this.f28425a = view;
    }

    public boolean canChildScrollUp() {
        if (this.f28425a == null) {
            return super.canChildScrollUp();
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return w.b(this.f28425a, -1);
        }
        View view = this.f28425a;
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() <= 0 || (absListView.getFirstVisiblePosition() <= 0 && absListView.getChildAt(0).getTop() >= absListView.getPaddingTop())) {
                return false;
            }
            return true;
        } else if (w.b(view, -1) || this.f28425a.getScrollY() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f28426b == null) {
            this.f28426b = (RecyclerView) findViewById(c.e.recycler_view);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f28429e = (int) motionEvent.getRawY();
        } else if (action == 1) {
            int i = this.f28429e;
            int i2 = this.f28430f;
            if (i - i2 >= this.f28431g && !this.f28428d && i2 > 0 && a()) {
                setLoading(true);
                a aVar = this.f28427c;
                if (aVar != null) {
                    aVar.i();
                }
            }
        } else if (action == 2) {
            this.f28430f = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setLoading(boolean z) {
        this.f28428d = z;
    }

    public void setOnLoadListener(a aVar) {
        this.f28427c = aVar;
    }

    public boolean a() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f28426b.getLayoutManager();
        return linearLayoutManager.y() > 0 && linearLayoutManager.p() == linearLayoutManager.I() - 1 && this.f28426b.getScrollState() == 1;
    }
}
