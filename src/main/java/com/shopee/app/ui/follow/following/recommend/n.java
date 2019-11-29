package com.shopee.app.ui.follow.following.recommend;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class n extends m implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f21725c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f21726d = new c();

    public n(Context context) {
        super(context);
        b();
    }

    public static m a(Context context) {
        n nVar = new n(context);
        nVar.onFinishInflate();
        return nVar;
    }

    public void onFinishInflate() {
        if (!this.f21725c) {
            this.f21725c = true;
            inflate(getContext(), R.layout.sns_banner_layout, this);
            this.f21726d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f21726d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21723a = (TextView) aVar.internalFindViewById(R.id.invite_friend_title);
        this.f21724b = (TextView) aVar.internalFindViewById(R.id.invite_friend_hint);
        a();
    }
}
