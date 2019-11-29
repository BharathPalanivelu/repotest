package com.shopee.app.ui.d;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f21468c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f21469d = new c();

    public e(Context context) {
        super(context);
        a();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.f21468c) {
            this.f21468c = true;
            inflate(getContext(), R.layout.search_tag_item, this);
            this.f21469d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f21469d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21464a = (TextView) aVar.internalFindViewById(R.id.label);
        this.f21465b = (ImageView) aVar.internalFindViewById(R.id.cross_icon);
    }
}
