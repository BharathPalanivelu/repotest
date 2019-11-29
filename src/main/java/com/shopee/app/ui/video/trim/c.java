package com.shopee.app.ui.video.trim;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import life.knowledge4.videotrimmer.K4LVideoTrimmer;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {

    /* renamed from: d  reason: collision with root package name */
    private boolean f25801d = false;

    /* renamed from: e  reason: collision with root package name */
    private final org.a.a.b.c f25802e = new org.a.a.b.c();

    public c(Context context, String str) {
        super(context, str);
        d();
    }

    public static b a(Context context, String str) {
        c cVar = new c(context, str);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.f25801d) {
            this.f25801d = true;
            inflate(getContext(), R.layout.video_trimmer_layout, this);
            this.f25802e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.f25802e);
        org.a.a.b.c.a((b) this);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25792a = (K4LVideoTrimmer) aVar.internalFindViewById(R.id.klvtrim);
        a();
    }
}
