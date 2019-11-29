package com.shopee.app.ui.tutorial;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.shopee.app.application.ar;
import com.squareup.a.w;

public class h extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f25716a;

    /* renamed from: b  reason: collision with root package name */
    Button f25717b;

    public h(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f25717b.setVisibility(8);
    }

    public void setImage(int i) {
        w.a(getContext()).a(i).a().e().a(this.f25716a);
    }

    public void b() {
        this.f25717b.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        ar.f().e().loginStore().i();
        ((Activity) getContext()).finish();
    }
}
