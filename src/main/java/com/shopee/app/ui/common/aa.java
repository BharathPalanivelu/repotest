package com.shopee.app.ui.common;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.f;
import com.afollestad.materialdialogs.f;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.upload.IUploadView;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

public class aa extends RelativeLayout implements IUploadView {

    /* renamed from: a  reason: collision with root package name */
    TextView f21108a;

    /* renamed from: b  reason: collision with root package name */
    SmoothProgressBar f21109b;

    /* renamed from: c  reason: collision with root package name */
    m f21110c;

    /* renamed from: d  reason: collision with root package name */
    View f21111d;

    /* renamed from: e  reason: collision with root package name */
    TextView f21112e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f21113f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f21114g;
    y h;
    bc i;
    ak j;
    private boolean k;
    private SpannableString l;
    private Float m;

    public interface a {
        void a(aa aaVar);
    }

    public aa(Context context) {
        super(context);
        a(context);
    }

    public aa(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public aa(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        if (!isInEditMode()) {
            ((a) ((x) context).b()).a(this);
            setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.i.a(this.h);
        this.h.a(this);
        this.f21109b.setProgressDrawable(b.f(R.drawable.progress_bar_progress));
        setStateInProgress();
        this.l = f.a(getContext()).b((int) R.drawable.ic_video_productname).c(this.f21108a.getLineHeight()).a().a();
    }

    public void setLabel(String str) {
        this.f21108a.setText(str);
    }

    public void setVideo(final boolean z) {
        if (!z) {
            return;
        }
        if (this.f21108a.getMeasuredWidth() == 0) {
            post(new Runnable() {
                public void run() {
                    aa.this.setVideo(z);
                }
            });
            return;
        }
        String charSequence = this.f21108a.getText().toString();
        if (this.m == null) {
            this.m = Float.valueOf(this.f21108a.getPaint().measureText(charSequence));
        }
        float measuredWidth = (float) (this.f21108a.getMeasuredWidth() - b.a.m);
        if (this.m.floatValue() > measuredWidth) {
            int floatValue = (int) (((measuredWidth * 1.0f) / this.m.floatValue()) * ((float) charSequence.length()));
            if (floatValue > 6) {
                TextView textView = this.f21108a;
                textView.setText(charSequence.substring(0, floatValue - 6) + "...");
            }
            this.f21108a.append(SQLBuilder.BLANK);
            this.f21108a.append(this.l);
            return;
        }
        this.f21108a.append(SQLBuilder.BLANK);
        this.f21108a.append(this.l);
    }

    public void setProgress(int i2) {
        if (i2 > 100) {
            this.f21109b.setIndeterminate(true);
            setCancelEnabled(false);
            return;
        }
        this.f21109b.setIndeterminate(false);
        this.f21109b.setProgress(i2);
        setCancelEnabled(true);
    }

    public void setImage(String str) {
        z.b(getContext()).a(str).a(this.f21113f);
    }

    private void setCancelEnabled(boolean z) {
        if (z) {
            this.f21110c.setColor(com.garena.android.appkit.tools.b.a(R.color.black54));
            this.f21110c.setClickable(true);
            return;
        }
        this.f21110c.setColor(com.garena.android.appkit.tools.b.a(R.color.black26));
        this.f21110c.setClickable(false);
    }

    public void setStateInProgress() {
        this.f21111d.setVisibility(4);
        this.f21114g.setVisibility(8);
        this.f21110c.setVisibility(0);
        this.f21109b.setVisibility(0);
        this.f21112e.setVisibility(4);
    }

    public void setStateFailed(String str) {
        this.f21111d.setVisibility(0);
        this.f21114g.setVisibility(0);
        this.f21110c.setVisibility(4);
        this.f21109b.setVisibility(4);
        this.f21112e.setVisibility(0);
        this.f21112e.setText(str);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.h.g();
        com.shopee.app.ui.dialog.a.a(getContext(), 0, (int) R.string.sp_label_product_upload_cancel_warning, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (f.b) new f.b() {
            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                aa.this.h.e();
                aa.this.setStateInProgress();
                aa.this.setVisibility(8);
            }

            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                aa.this.h.h();
            }
        }, false);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        com.shopee.app.ui.dialog.a.a(getContext(), 0, (int) R.string.sp_label_product_upload_cancel_warning, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                aa.this.h.e();
                aa.this.setStateInProgress();
                aa.this.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.h.f();
        setStateInProgress();
        setProgress(101);
    }

    public void show() {
        com.garena.android.appkit.d.a.a("progress show....", new Object[0]);
        setVisibility(0);
    }

    public void hide() {
        com.garena.android.appkit.d.a.a("progress hide....", new Object[0]);
        setVisibility(8);
    }

    public boolean isShown() {
        return getVisibility() == 0;
    }

    public void e() {
        this.k = true;
        this.h.i();
        this.m = null;
    }

    public void f() {
        this.k = false;
    }

    public void g() {
        this.i.b(this.h);
    }
}
