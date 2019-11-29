package com.shopee.app.ui.follow.following;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class z extends y implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f21767c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f21768d = new c();

    public z(Context context) {
        super(context);
        b();
    }

    public static y a(Context context) {
        z zVar = new z(context);
        zVar.onFinishInflate();
        return zVar;
    }

    public void onFinishInflate() {
        if (!this.f21767c) {
            this.f21767c = true;
            inflate(getContext(), R.layout.recommend_title_view, this);
            this.f21768d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f21768d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21765a = (TextView) aVar.internalFindViewById(R.id.facebook_friends_view);
        this.f21766b = (ImageView) aVar.internalFindViewById(R.id.fb_icon);
        a();
    }
}
