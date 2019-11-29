package com.shopee.app.ui.tracklog;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class f extends e implements a, b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f25652a = false;

    /* renamed from: b  reason: collision with root package name */
    private final c f25653b = new c();

    public f(Context context, String str) {
        super(context, str);
        b();
    }

    public static e a(Context context, String str) {
        f fVar = new f(context, str);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.f25652a) {
            this.f25652a = true;
            inflate(getContext(), R.layout.track_badge_detail_view, this);
            this.f25653b.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f25653b);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        a();
    }
}
