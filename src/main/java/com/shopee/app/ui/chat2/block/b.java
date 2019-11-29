package com.shopee.app.ui.chat2.block;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f20304b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f20305c = new c();

    public b(Context context) {
        super(context);
        a();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.f20304b) {
            this.f20304b = true;
            inflate(getContext(), R.layout.block_user_btm_layout, this);
            this.f20305c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f20305c);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20303a = (TextView) aVar.internalFindViewById(R.id.label);
    }
}
