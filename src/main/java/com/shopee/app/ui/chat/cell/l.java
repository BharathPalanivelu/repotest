package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.app.ui.common.m;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class l extends k implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f20115e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f20116f = new c();

    public l(Context context) {
        super(context);
        c();
    }

    public void onFinishInflate() {
        if (!this.f20115e) {
            this.f20115e = true;
            inflate(getContext(), R.layout.chat_local_layout, this);
            this.f20116f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.f20116f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static k a(Context context) {
        l lVar = new l(context);
        lVar.onFinishInflate();
        return lVar;
    }

    public void onViewChanged(a aVar) {
        this.f20110a = (FrameLayout) aVar.internalFindViewById(R.id.content_container);
        this.f20111b = (TextView) aVar.internalFindViewById(R.id.chat_status);
        this.f20112c = (m) aVar.internalFindViewById(R.id.arrow);
        this.f20113d = (ImageView) aVar.internalFindViewById(R.id.icon_tick);
        if (this.f20113d != null) {
            this.f20113d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.b();
                }
            });
        }
        a();
    }
}
