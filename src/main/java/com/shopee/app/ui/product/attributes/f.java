package com.shopee.app.ui.product.attributes;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.shopee.app.ui.a.aa;

public class f extends aa<v> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f24278b = -1;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Handler f24279c = new Handler();

    public f(h hVar) {
        super(hVar);
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 instanceof n) {
            final n nVar = (n) view2;
            nVar.setOnTextFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        f.this.f24279c.postDelayed(new Runnable() {
                            public void run() {
                                if (f.this.f24278b == -1 || f.this.f24278b == i) {
                                    int unused = f.this.f24278b = i;
                                    nVar.b();
                                }
                            }
                        }, 200);
                    } else {
                        int unused = f.this.f24278b = -1;
                    }
                }
            });
        }
        return view2;
    }
}
