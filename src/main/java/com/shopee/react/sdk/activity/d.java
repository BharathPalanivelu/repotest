package com.shopee.react.sdk.activity;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.react.ReactInstanceManager;
import com.shopee.react.sdk.b;

public class d extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ReactInstanceManager f30169a;

    public d(Context context, ReactInstanceManager reactInstanceManager) {
        super(context);
        this.f30169a = reactInstanceManager;
    }

    public void a() {
        if (b.a().c()) {
            View a2 = com.shopee.react.sdk.a.b.a(getContext());
            a2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.f30169a.showDevOptionsDialog();
                }
            });
            addView(a2, a2.getLayoutParams());
        }
    }
}
