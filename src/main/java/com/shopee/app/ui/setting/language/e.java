package com.shopee.app.ui.setting.language;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f25263g = false;
    private final c h = new c();

    public e(Context context) {
        super(context);
        d();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.f25263g) {
            this.f25263g = true;
            inflate(getContext(), R.layout.language_settings_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.h);
        this.f25257a = getContext().getResources().getDimensionPixelSize(R.dimen.dp48);
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
