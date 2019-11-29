package com.shopee.app.ui.chat2;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ac extends ab implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f20254c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f20255d = new c();

    public ac(Context context) {
        super(context);
        a();
    }

    public static ab a(Context context) {
        ac acVar = new ac(context);
        acVar.onFinishInflate();
        return acVar;
    }

    public void onFinishInflate() {
        if (!this.f20254c) {
            this.f20254c = true;
            inflate(getContext(), R.layout.message_shortcut_item_layout, this);
            this.f20255d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f20255d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20252a = (TextView) aVar.internalFindViewById(R.id.text);
        this.f20253b = (ImageView) aVar.internalFindViewById(R.id.button);
    }
}
