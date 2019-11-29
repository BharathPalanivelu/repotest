package com.shopee.app.ui.common.a;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.web.protocol.Variant;
import com.shopee.id.R;

public class f extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f21101a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21102b;

    /* renamed from: c  reason: collision with root package name */
    private Variant f21103c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21104d;

    /* renamed from: e  reason: collision with root package name */
    private int f21105e = R.drawable.btn_primary;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public f(Context context) {
        super(context);
    }

    public void setActiveBgRes(int i) {
        this.f21105e = i;
    }

    public void setActive(boolean z) {
        this.f21102b = z;
        if (this.f21102b) {
            this.f21101a.setBackgroundResource(this.f21105e);
            this.f21101a.setTextColor(b.a(R.color.white87));
            return;
        }
        this.f21101a.setBackgroundResource(R.drawable.btn_secondary_grey);
        this.f21101a.setTextColor(b.a(R.color.black87));
    }

    public void b() {
        this.f21101a.setBackgroundResource(R.drawable.btn_black06);
    }

    public void setAllowed(boolean z) {
        this.f21104d = z;
        if (z) {
            this.f21101a.setTextColor(b.a(R.color.black87));
        } else {
            this.f21101a.setTextColor(b.a(R.color.black26));
        }
    }

    public boolean c() {
        return this.f21102b;
    }

    public boolean d() {
        return this.f21104d;
    }

    public void setData(Variant variant) {
        this.f21103c = variant;
        this.f21101a.setText(variant.modelName);
        setAllowed(variant.modelStock > 0);
    }

    public Variant getData() {
        return this.f21103c;
    }
}
