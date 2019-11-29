package com.shopee.app.ui.home.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.home.bottom.BottomNavView;
import com.shopee.app.ui.home.m;
import com.shopee.id.R;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private final com.shopee.app.ui.home.c f22152a;

    /* renamed from: b  reason: collision with root package name */
    private View f22153b;

    /* renamed from: c  reason: collision with root package name */
    private View f22154c;

    public c(com.shopee.app.ui.home.c cVar) {
        this.f22152a = cVar;
    }

    public void a(boolean z, int i) {
        m p = this.f22152a.p();
        if (p != null) {
            a actionBar = this.f22152a.x().getActionBar();
            BottomNavView bottomNavView = p.f22269b;
            if (actionBar == null) {
                return;
            }
            if ((p.m() || p.n()) && bottomNavView != null) {
                FrameLayout frameLayout = (FrameLayout) this.f22152a.findViewById(16908290);
                if (frameLayout != null) {
                    if (this.f22153b == null) {
                        this.f22153b = View.inflate(this.f22152a, R.layout.dim_overlay_layout, (ViewGroup) null);
                        this.f22153b.setFocusableInTouchMode(true);
                        this.f22153b.setClickable(true);
                        frameLayout.addView(this.f22153b, new FrameLayout.LayoutParams(actionBar.getMeasuredWidth(), p.m() ? 0 : actionBar.getMeasuredHeight()));
                    }
                    if (this.f22154c == null) {
                        this.f22154c = View.inflate(this.f22152a, R.layout.dim_overlay_layout, (ViewGroup) null);
                        this.f22154c.setFocusableInTouchMode(true);
                        this.f22154c.setClickable(true);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bottomNavView.getMeasuredWidth(), bottomNavView.getMeasuredHeight());
                        layoutParams.gravity = 80;
                        frameLayout.addView(this.f22154c, layoutParams);
                    }
                    if (z) {
                        this.f22153b.setBackgroundColor(i);
                        this.f22153b.setVisibility(0);
                        this.f22154c.setBackgroundColor(i);
                        this.f22154c.setVisibility(0);
                        return;
                    }
                    this.f22153b.setVisibility(8);
                    this.f22154c.setVisibility(8);
                }
            }
        }
    }

    public boolean a(int i) {
        m p = this.f22152a.p();
        if (p == null) {
            return false;
        }
        if (i == -99281) {
            if (p.m() || p.n()) {
                return true;
            }
            return false;
        } else if (p.getReactTag() == i) {
            return true;
        } else {
            return false;
        }
    }

    public boolean a() {
        View view = this.f22153b;
        return view != null && view.getVisibility() == 0;
    }
}
