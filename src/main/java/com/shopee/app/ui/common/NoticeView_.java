package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class NoticeView_ extends t implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f20987c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f20988d = new c();

    public NoticeView_(Context context) {
        super(context);
        b();
    }

    public NoticeView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public NoticeView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public NoticeView_(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        b();
    }

    public static t a(Context context) {
        NoticeView_ noticeView_ = new NoticeView_(context);
        noticeView_.onFinishInflate();
        return noticeView_;
    }

    public void onFinishInflate() {
        if (!this.f20987c) {
            this.f20987c = true;
            inflate(getContext(), R.layout.notice_view, this);
            this.f20988d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20988d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21339a = (TextView) aVar.internalFindViewById(R.id.notice_text);
        this.f21340b = (ImageView) aVar.internalFindViewById(R.id.notice_cross);
        a();
    }
}
