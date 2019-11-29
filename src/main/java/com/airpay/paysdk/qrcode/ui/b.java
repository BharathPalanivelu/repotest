package com.airpay.paysdk.qrcode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airpay.paysdk.base.ui.weidget.BPLoadingView;
import com.airpay.paysdk.c;

public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f4424a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f4425b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f4426c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f4427d;

    /* renamed from: e  reason: collision with root package name */
    private BPLoadingView f4428e;

    /* renamed from: f  reason: collision with root package name */
    private View f4429f;

    /* renamed from: g  reason: collision with root package name */
    private View f4430g;

    public b(Context context) {
        super(context);
        a();
    }

    public ImageView getmImgCode() {
        return this.f4425b;
    }

    public TextView getmTxtCode() {
        return this.f4426c;
    }

    public View getmBackgroundView() {
        return this.f4429f;
    }

    public View getmSectionContent() {
        return this.f4430g;
    }

    private void a() {
        inflate(getContext(), c.h.com_garena_beepay_item_ticket_code, this);
        this.f4425b = (ImageView) findViewById(c.f.com_garena_beepay_img_ticket_code);
        this.f4426c = (TextView) findViewById(c.f.com_garena_beepay_txt_ticket_code);
        this.f4427d = (TextView) findViewById(c.f.code_msg);
        this.f4428e = (BPLoadingView) findViewById(c.f.com_garena_beepay_img_ticket_loadingView);
        this.f4429f = findViewById(c.f.com_garena_beepay_view_background);
        this.f4430g = findViewById(c.f.com_garena_beepay_section_content);
    }

    public void setBitmap(Bitmap bitmap) {
        this.f4425b.setImageBitmap(bitmap);
        Bitmap bitmap2 = this.f4424a;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f4424a.recycle();
            this.f4424a = null;
        }
        this.f4424a = bitmap;
    }

    public void a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.f4426c.setVisibility(8);
            return;
        }
        this.f4426c.setVisibility(0);
        this.f4426c.setText(str);
        this.f4426c.getLayoutParams().width = z ? -1 : -2;
        this.f4426c.requestLayout();
    }

    public void a(boolean z) {
        this.f4428e.changeLoadingState(z);
        if (z) {
            this.f4428e.setVisibility(0);
            this.f4425b.setVisibility(4);
            return;
        }
        this.f4428e.setVisibility(4);
        this.f4425b.setVisibility(0);
    }

    public void b(boolean z) {
        this.f4427d.setVisibility(z ? 0 : 8);
    }
}
