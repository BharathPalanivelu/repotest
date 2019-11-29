package com.shopee.app.ui.setting;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class f extends e implements a, b {
    private boolean i = false;
    private final c j = new c();

    public f(Context context) {
        super(context);
        b();
    }

    public static e a(Context context) {
        f fVar = new f(context);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.simple_list_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.j);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f25206a = (TextView) aVar.internalFindViewById(R.id.font_itc);
        this.f25207b = (TextView) aVar.internalFindViewById(R.id.font_majalla);
        this.f25208c = (TextView) aVar.internalFindViewById(R.id.font_padauk);
        this.f25209d = (TextView) aVar.internalFindViewById(R.id.font_one);
        this.f25210e = (TextView) aVar.internalFindViewById(R.id.font_two);
        this.f25211f = (TextView) aVar.internalFindViewById(R.id.font_three);
        a();
    }
}
