package com.shopee.app.ui.home.follow;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.webview.g;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class FollowTab_ extends FollowTab implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f22204g = false;
    private final c h = new c();

    public FollowTab_(Context context) {
        super(context);
        i();
    }

    public static FollowTab a(Context context) {
        FollowTab_ followTab_ = new FollowTab_(context);
        followTab_.onFinishInflate();
        return followTab_;
    }

    public void onFinishInflate() {
        if (!this.f22204g) {
            this.f22204g = true;
            inflate(getContext(), R.layout.follow_tab_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22197a = (g) aVar.internalFindViewById(R.id.webPageView);
        this.f22198b = (com.shopee.app.ui.common.b) aVar.internalFindViewById(R.id.ask_login_view);
        d();
    }
}
