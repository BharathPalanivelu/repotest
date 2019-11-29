package com.shopee.app.ui.follow.following;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.a.n;

public class y extends LinearLayout implements n<t> {

    /* renamed from: a  reason: collision with root package name */
    TextView f21765a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f21766b;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public y(Context context) {
        super(context);
    }

    public void a(t tVar) {
        this.f21765a.setText(tVar.h());
        this.f21766b.setImageDrawable(b.f(tVar.i()));
    }
}
