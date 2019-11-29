package com.shopee.app.ui.home.bottom;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.shopee.app.ui.common.f;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f22131e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f22132f = new c();

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
        if (!this.f22131e) {
            this.f22131e = true;
            inflate(getContext(), R.layout.bottom_bar_item_wrapper, this);
            this.f22132f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f22132f);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22126a = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f22127b = (TextView) aVar.internalFindViewById(R.id.title);
        this.f22128c = (f) aVar.internalFindViewById(R.id.badge);
        this.f22129d = (SimpleDraweeView) aVar.internalFindViewById(R.id.tab_animation_icon);
    }
}
