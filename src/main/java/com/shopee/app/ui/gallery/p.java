package com.shopee.app.ui.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class p extends o implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f21990g = false;
    private final c h = new c();

    public p(Context context, boolean z) {
        super(context, z);
        b();
    }

    public static o a(Context context, boolean z) {
        p pVar = new p(context, z);
        pVar.onFinishInflate();
        return pVar;
    }

    public void onFinishInflate() {
        if (!this.f21990g) {
            this.f21990g = true;
            inflate(getContext(), R.layout.gallery_item_view_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21984b = (ImageView) aVar.internalFindViewById(R.id.image);
        this.f21985c = (CheckBox) aVar.internalFindViewById(R.id.checkbox);
        this.f21986d = (ViewGroup) aVar.internalFindViewById(R.id.video_details);
        this.f21987e = (TextView) aVar.internalFindViewById(R.id.video_duration);
        this.f21988f = aVar.internalFindViewById(R.id.disableOverlay);
        a();
    }
}
