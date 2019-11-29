package com.shopee.app.ui.product.add;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.app.ui.common.y;
import com.shopee.app.upload.IUploadView;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class g extends FrameLayout implements IUploadView {

    /* renamed from: a  reason: collision with root package name */
    ProgressWheel f24065a;

    /* renamed from: b  reason: collision with root package name */
    TextView f24066b;

    /* renamed from: c  reason: collision with root package name */
    y f24067c;

    /* renamed from: d  reason: collision with root package name */
    bc f24068d;

    /* renamed from: e  reason: collision with root package name */
    Activity f24069e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24070f;

    private void setCancelEnabled(boolean z) {
    }

    public void setImage(String str) {
    }

    public void setLabel(String str) {
    }

    public void setStateFailed(String str) {
    }

    public void setStateInProgress() {
    }

    public void setVideo(boolean z) {
    }

    public g(Context context) {
        super(context);
        ((d) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24068d.a(this.f24067c);
        this.f24067c.a(this);
        this.f24065a.setLinearProgress(true);
    }

    public void show() {
        FrameLayout frameLayout = (FrameLayout) this.f24069e.findViewById(16908290);
        if (frameLayout != null && !this.f24070f) {
            frameLayout.addView(this, new FrameLayout.LayoutParams(-1, -1));
            this.f24070f = true;
        }
        setVisibility(0);
    }

    public void setProgress(int i) {
        if (i > 100) {
            this.f24065a.setLinearProgress(false);
            this.f24065a.b();
            this.f24066b.setText(b.e(R.string.sp_label_loading));
            return;
        }
        this.f24065a.setLinearProgress(true);
        this.f24065a.setProgress(((float) i) / 100.0f);
        TextView textView = this.f24066b;
        textView.setText(i + "%");
        setCancelEnabled(true);
    }

    public void hide() {
        setVisibility(8);
    }

    public boolean isShown() {
        return this.f24070f && getVisibility() == 0;
    }
}
