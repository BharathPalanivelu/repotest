package com.shopee.app.ui.tracklog;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f25686e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f25687f = new c();

    public k(Context context) {
        super(context);
        c();
    }

    public static j a(Context context) {
        k kVar = new k(context);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.f25686e) {
            this.f25686e = true;
            inflate(getContext(), R.layout.track_log_view_layout, this);
            this.f25687f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.f25687f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25669a = (RecyclerView) aVar.internalFindViewById(R.id.listView);
        this.f25670b = (SwipeRefreshLayout) aVar.internalFindViewById(R.id.swipe_container);
        this.f25671c = (SwitchCompat) aVar.internalFindViewById(R.id.androidV3Only);
        a();
    }
}
