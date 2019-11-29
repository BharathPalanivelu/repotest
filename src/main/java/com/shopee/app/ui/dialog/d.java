package com.shopee.app.ui.dialog;

import android.content.Context;
import android.widget.Button;
import android.widget.RelativeLayout;

public class d extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    f f21543a;

    /* renamed from: b  reason: collision with root package name */
    Button f21544b;

    /* renamed from: c  reason: collision with root package name */
    private a f21545c;

    public interface a {
        void onCheckout(int i);
    }

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public d(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f21545c != null && this.f21543a.getQuantity() > 0) {
            this.f21545c.onCheckout(this.f21543a.getQuantity());
        }
    }

    public void a(String str, String str2, String str3, a aVar) {
        this.f21545c = aVar;
        this.f21543a.a(str, str2, str3);
    }

    public void a(int i, int i2) {
        this.f21543a.a(i, i2);
    }

    public void setCurrentQuantity(int i) {
        this.f21543a.setQuantity(i);
    }

    public void setBottomButton(String str) {
        this.f21544b.setText(str);
    }
}
