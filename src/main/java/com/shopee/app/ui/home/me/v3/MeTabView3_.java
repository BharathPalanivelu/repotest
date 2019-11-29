package com.shopee.app.ui.home.me.v3;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.tabs.TabLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class MeTabView3_ extends MeTabView3 implements a, b {
    private boolean s = false;
    private final c t = new c();

    public MeTabView3_(Context context) {
        super(context);
        k();
    }

    public static MeTabView3 a(Context context) {
        MeTabView3_ meTabView3_ = new MeTabView3_(context);
        meTabView3_.onFinishInflate();
        return meTabView3_;
    }

    public void onFinishInflate() {
        if (!this.s) {
            this.s = true;
            inflate(getContext(), R.layout.me_tab_layout3, this);
            this.t.a((a) this);
        }
        super.onFinishInflate();
    }

    private void k() {
        c a2 = c.a(this.t);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22446a = (RelativeLayout) aVar.internalFindViewById(R.id.me_tab_content_layout);
        this.f22447b = (SwipeRefreshLayout) aVar.internalFindViewById(R.id.swipe_container);
        this.f22448c = (a) aVar.internalFindViewById(R.id.me_cover);
        this.f22449d = (FrameLayout) aVar.internalFindViewById(R.id.switch_container);
        this.f22450e = (TabLayout) aVar.internalFindViewById(R.id.tab_layout);
        d();
    }
}
