package com.shopee.app.ui.product.search;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f24798e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f24799f = new c();

    public b(Context context) {
        super(context);
        b();
    }

    public void onFinishInflate() {
        if (!this.f24798e) {
            this.f24798e = true;
            inflate(getContext(), R.layout.search_curated_hint_item_layout, this);
            this.f24799f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f24799f);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onViewChanged(a aVar) {
        this.f24780a = (ImageView) aVar.internalFindViewById(R.id.imageView);
        this.f24781b = (TextView) aVar.internalFindViewById(R.id.hintText);
        this.f24782c = (TextView) aVar.internalFindViewById(R.id.tag1Text);
        this.f24783d = (TextView) aVar.internalFindViewById(R.id.tag2Text);
        a();
    }
}
