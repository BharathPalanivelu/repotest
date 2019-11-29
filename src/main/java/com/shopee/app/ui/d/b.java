package com.shopee.app.ui.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shopee.app.ui.common.m;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f21462g = false;
    private final c h = new c();

    public b(Context context) {
        super(context);
        b();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.f21462g) {
            this.f21462g = true;
            inflate(getContext(), R.layout.search_bar_display_view, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.h);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21454a = (m) aVar.internalFindViewById(R.id.search_icon);
        this.f21455b = (TextView) aVar.internalFindViewById(R.id.title_text);
        this.f21456c = (LinearLayout) aVar.internalFindViewById(R.id.container);
        this.f21457d = (HorizontalScrollView) aVar.internalFindViewById(R.id.scroll);
        this.f21458e = aVar.internalFindViewById(R.id.search_container);
        if (this.f21457d != null) {
            this.f21457d.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return b.this.a(view, motionEvent);
                }
            });
        }
        a();
    }
}
