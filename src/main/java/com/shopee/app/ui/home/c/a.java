package com.shopee.app.ui.home.c;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.id.R;

public class a extends com.garena.android.uikit.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    Button f22134a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f22135b = new Runnable() {
        public void run() {
            a.this.f22134a.setText(b.e(R.string.button_ok) + " (" + a.this.f22136c + ") ");
            if (a.this.f22136c <= 0) {
                a.this.f22134a.setText(b.e(R.string.button_ok));
                a.this.f22134a.setEnabled(true);
                a.this.f22134a.setTextColor(b.a(R.color.primary));
                return;
            }
            a.b(a.this);
            a aVar = a.this;
            aVar.postDelayed(aVar.f22135b, 1000);
            a.this.f22134a.setEnabled(false);
            a.this.f22134a.setTextColor(b.a(R.color.black26));
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f22136c = 5;

    static /* synthetic */ int b(a aVar) {
        int i = aVar.f22136c;
        aVar.f22136c = i - 1;
        return i;
    }

    public a(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f22134a.setEnabled(false);
        this.f22134a.setTextColor(b.a(R.color.black26));
        postDelayed(this.f22135b, 1000);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        try {
            Activity activity = (Activity) getContext();
            ar.a(false);
        } catch (Exception unused) {
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }
}
