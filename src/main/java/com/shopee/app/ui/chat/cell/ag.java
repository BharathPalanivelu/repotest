package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ag extends af implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f20049b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f20050c = new c();

    public ag(Context context, View view) {
        super(context, view);
        b();
    }

    public static af a(Context context, View view) {
        ag agVar = new ag(context, view);
        agVar.onFinishInflate();
        return agVar;
    }

    public void onFinishInflate() {
        if (!this.f20049b) {
            this.f20049b = true;
            inflate(getContext(), R.layout.chat_system_msg_layout, this);
            this.f20050c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20050c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20047a = (FrameLayout) aVar.internalFindViewById(R.id.content_container);
        a();
    }
}
