package com.shopee.app.ui.follow.following;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f21630b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f21631c = new c();

    public b(Context context) {
        super(context);
        b();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.f21630b) {
            this.f21630b = true;
            inflate(getContext(), R.layout.following_text_item_layout, this);
            this.f21631c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f21631c);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21629a = (TextView) aVar.internalFindViewById(R.id.title_text);
        a();
    }
}
