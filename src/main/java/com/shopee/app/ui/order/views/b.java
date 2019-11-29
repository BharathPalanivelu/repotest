package com.shopee.app.ui.order.views;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.app.util.ae;
import com.shopee.id.R;

public class b extends RelativeLayout implements ae.b {

    /* renamed from: a  reason: collision with root package name */
    TextView f23863a;

    /* renamed from: b  reason: collision with root package name */
    Button f23864b;

    /* renamed from: c  reason: collision with root package name */
    Button f23865c;

    /* renamed from: d  reason: collision with root package name */
    int f23866d;

    /* renamed from: e  reason: collision with root package name */
    int f23867e;

    /* renamed from: f  reason: collision with root package name */
    int f23868f;

    /* renamed from: g  reason: collision with root package name */
    private long f23869g;
    private boolean h = false;

    public b(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i = this.f23867e;
        int i2 = this.f23866d;
        setPadding(i, i2, i, i2);
    }

    public void setIds(long j) {
        this.f23869g = j;
    }

    public long getIdentifier() {
        return this.f23869g;
    }

    public boolean a(long j) {
        return j == this.f23869g;
    }

    public void setLabel(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f23863a.setText(str);
        } else {
            this.f23863a.setText(Html.fromHtml(str));
        }
        d();
    }

    private void d() {
        int visibility = this.f23864b.getVisibility();
        int visibility2 = this.f23865c.getVisibility();
        if (TextUtils.isEmpty(this.f23863a.getText()) || this.f23864b.getVisibility() != 4) {
            this.f23864b.setVisibility(visibility);
            this.f23865c.setVisibility(visibility2);
            if (!TextUtils.isEmpty(this.f23863a.getText()) && this.f23864b.getVisibility() == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f23863a.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.leftMargin = b.a.f7693d;
                this.f23863a.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f23864b.getLayoutParams();
                layoutParams2.weight = 1.0f;
                layoutParams2.leftMargin = b.a.f7693d;
                this.f23864b.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f23865c.getLayoutParams();
                layoutParams3.weight = BitmapDescriptorFactory.HUE_RED;
                layoutParams3.leftMargin = 0;
                this.f23865c.setLayoutParams(layoutParams3);
            } else if (TextUtils.isEmpty(this.f23863a.getText()) && this.f23864b.getVisibility() == 0 && this.f23865c.getVisibility() == 4) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f23863a.getLayoutParams();
                layoutParams4.weight = 1.0f;
                layoutParams4.leftMargin = b.a.f7693d;
                this.f23863a.setLayoutParams(layoutParams4);
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f23864b.getLayoutParams();
                layoutParams5.weight = 1.0f;
                layoutParams5.leftMargin = b.a.f7693d;
                this.f23864b.setLayoutParams(layoutParams5);
                LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.f23865c.getLayoutParams();
                layoutParams6.weight = BitmapDescriptorFactory.HUE_RED;
                layoutParams6.leftMargin = 0;
                this.f23865c.setLayoutParams(layoutParams6);
            } else if (TextUtils.isEmpty(this.f23863a.getText()) && this.f23864b.getVisibility() == 0 && this.f23865c.getVisibility() == 0) {
                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.f23863a.getLayoutParams();
                layoutParams7.weight = BitmapDescriptorFactory.HUE_RED;
                layoutParams7.leftMargin = 0;
                this.f23863a.setLayoutParams(layoutParams7);
                LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.f23864b.getLayoutParams();
                layoutParams8.weight = 1.0f;
                layoutParams8.leftMargin = 0;
                this.f23864b.setLayoutParams(layoutParams8);
                LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.f23865c.getLayoutParams();
                layoutParams9.weight = 1.0f;
                layoutParams9.leftMargin = b.a.f7695f;
                this.f23865c.setLayoutParams(layoutParams9);
            }
        } else {
            LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) this.f23863a.getLayoutParams();
            layoutParams10.weight = 1.0f;
            layoutParams10.leftMargin = b.a.f7693d;
            this.f23863a.setLayoutParams(layoutParams10);
            LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) this.f23864b.getLayoutParams();
            layoutParams11.weight = 1.0f;
            layoutParams11.leftMargin = b.a.f7693d;
            this.f23864b.setLayoutParams(layoutParams11);
            LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) this.f23865c.getLayoutParams();
            layoutParams12.weight = BitmapDescriptorFactory.HUE_RED;
            layoutParams12.leftMargin = 0;
            this.f23865c.setLayoutParams(layoutParams12);
            this.f23864b.setVisibility(8);
            this.f23865c.setVisibility(8);
        }
    }

    private void a(Button button, CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            button.setVisibility(0);
            button.setText(charSequence);
            if (charSequence.equals(com.garena.android.appkit.tools.b.e(R.string.sp_provide_bank_account))) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.weight = 2.0f;
                }
                button.setLayoutParams(layoutParams);
                this.h = true;
            } else if (this.h) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.weight = 1.0f;
                }
                button.setLayoutParams(layoutParams2);
                this.h = false;
            }
        } else {
            button.setVisibility(4);
        }
    }

    public void a(Button button, boolean z) {
        if (z) {
            button.setBackgroundResource(R.drawable.btn_primary);
        } else {
            button.setBackgroundResource(R.drawable.btn_disabled);
        }
    }

    public void a(Button button, int i) {
        if (8 == i) {
            i = 4;
        }
        button.setVisibility(i);
        d();
    }

    public void a(Button button, View.OnClickListener onClickListener) {
        button.setOnClickListener(onClickListener);
    }

    public void setButtonText(CharSequence charSequence) {
        a(this.f23864b, charSequence);
    }

    public void setButtonEnabled(boolean z) {
        a(this.f23864b, z);
    }

    public void setButtonVisibility(int i) {
        a(this.f23864b, i);
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        a(this.f23864b, onClickListener);
    }

    public void setButton1Text(CharSequence charSequence) {
        a(this.f23865c, charSequence);
    }

    public void setButton1Enabled(boolean z) {
        a(this.f23865c, z);
    }

    public void setButton1Visibility(int i) {
        a(this.f23865c, i);
    }

    public void setButton1ClickListener(View.OnClickListener onClickListener) {
        a(this.f23865c, onClickListener);
    }

    public void b() {
        this.f23863a.setTextColor(com.garena.android.appkit.tools.b.a(R.color.red_light));
        this.f23863a.setCompoundDrawablesWithIntrinsicBounds(R.drawable.sales_expire_warming, 0, 0, 0);
    }

    public void c() {
        this.f23863a.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        this.f23863a.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
