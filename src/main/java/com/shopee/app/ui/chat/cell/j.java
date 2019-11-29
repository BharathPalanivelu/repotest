package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class j extends i implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f20108c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f20109d = new c();

    public j(Context context, an anVar, boolean z) {
        super(context, anVar, z);
        c();
    }

    public void onFinishInflate() {
        if (!this.f20108c) {
            this.f20108c = true;
            inflate(getContext(), R.layout.chat_image_item_layout, this);
            this.f20109d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.f20109d);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f20104b = resources.getDimensionPixelSize(R.dimen.dp150);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static i a(Context context, an anVar, boolean z) {
        j jVar = new j(context, anVar, z);
        jVar.onFinishInflate();
        return jVar;
    }

    public void onViewChanged(a aVar) {
        this.f20103a = (ImageView) aVar.internalFindViewById(R.id.chat_image);
        a();
    }
}
