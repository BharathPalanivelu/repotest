package com.shopee.app.ui.home.chat;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ChatTab_ extends ChatTab implements a, b {

    /* renamed from: d  reason: collision with root package name */
    private boolean f22147d = false;

    /* renamed from: e  reason: collision with root package name */
    private final c f22148e = new c();

    public ChatTab_(Context context) {
        super(context);
        e();
    }

    public static ChatTab a(Context context) {
        ChatTab_ chatTab_ = new ChatTab_(context);
        chatTab_.onFinishInflate();
        return chatTab_;
    }

    public void onFinishInflate() {
        if (!this.f22147d) {
            this.f22147d = true;
            inflate(getContext(), R.layout.chat_tab_layout, this);
            this.f22148e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.f22148e);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22141a = (FrameLayout) aVar.internalFindViewById(R.id.tab_cont);
        d();
    }
}
