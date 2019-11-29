package com.shopee.app.ui.shopassistant;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class h extends g implements a, b {
    private boolean i = false;
    private final c j = new c();

    public h(Context context) {
        super(context);
        e();
    }

    public static g a(Context context) {
        h hVar = new h(context);
        hVar.onFinishInflate();
        return hVar;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.j);
        this.f25455a = getContext().getResources().getDimensionPixelSize(R.dimen.dp60);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        a();
    }
}
