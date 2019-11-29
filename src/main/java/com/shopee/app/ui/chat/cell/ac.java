package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.m;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ac extends ab implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f20037e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f20038f = new c();

    public ac(Context context) {
        super(context);
        b();
    }

    public void onFinishInflate() {
        if (!this.f20037e) {
            this.f20037e = true;
            inflate(getContext(), R.layout.chat_remote_layout, this);
            this.f20038f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20038f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static ab a(Context context) {
        ac acVar = new ac(context);
        acVar.onFinishInflate();
        return acVar;
    }

    public void onViewChanged(a aVar) {
        this.f20032a = (FrameLayout) aVar.internalFindViewById(R.id.content_container);
        this.f20033b = (TextView) aVar.internalFindViewById(R.id.chat_status);
        this.f20034c = (AvatarView) aVar.internalFindViewById(R.id.avatar);
        this.f20035d = (m) aVar.internalFindViewById(R.id.arrow);
        a();
    }
}
