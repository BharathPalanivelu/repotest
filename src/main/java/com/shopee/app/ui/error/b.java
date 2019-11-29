package com.shopee.app.ui.error;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shopee.id.R;

public class b extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f21606a;

    /* renamed from: b  reason: collision with root package name */
    ImageButton f21607b;

    /* renamed from: c  reason: collision with root package name */
    private a f21608c;

    public interface a {
        void a();
    }

    public b(Context context) {
        super(context);
    }

    public void setCallback(a aVar) {
        this.f21608c = aVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21606a.setText(R.string.sp_label_bundle_fail_retry);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a aVar = this.f21608c;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).finish();
        }
    }

    public void a(boolean z) {
        this.f21607b.setVisibility(z ? 0 : 8);
    }
}
