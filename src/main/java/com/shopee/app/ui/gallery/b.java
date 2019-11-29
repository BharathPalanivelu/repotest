package com.shopee.app.ui.gallery;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: d  reason: collision with root package name */
    private boolean f21866d = false;

    /* renamed from: e  reason: collision with root package name */
    private final c f21867e = new c();

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
        if (!this.f21866d) {
            this.f21866d = true;
            inflate(getContext(), R.layout.album_item_layout, this);
            this.f21867e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f21867e);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21844a = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f21845b = (TextView) aVar.internalFindViewById(R.id.label);
        this.f21846c = (TextView) aVar.internalFindViewById(R.id.count);
    }
}
