package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airpay.paysdk.base.b.a;
import com.airpay.paysdk.c;

public class BBPermissionEmptyView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    protected ImageView f3850a;

    /* renamed from: b  reason: collision with root package name */
    protected TextView f3851b;

    /* renamed from: c  reason: collision with root package name */
    protected TextView f3852c;

    /* renamed from: d  reason: collision with root package name */
    protected Button f3853d;

    public BBPermissionEmptyView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public BBPermissionEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        context.startActivity(intent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009c, code lost:
        if (r8.equals(com.facebook.appevents.AppEventsConstants.EVENT_PARAM_VALUE_NO) != false) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r7, android.util.AttributeSet r8) {
        /*
            r6 = this;
            int r0 = com.airpay.paysdk.c.h.com_garena_beepay_permission_empty_view
            inflate(r7, r0, r6)
            r0 = 1
            r6.setOrientation(r0)
            r1 = 17
            r6.setGravity(r1)
            int r1 = com.airpay.paysdk.c.f.com_garena_beepay_empty_view_image
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.f3850a = r1
            int r1 = com.airpay.paysdk.c.f.com_garena_beepay_empty_view_text_title
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.f3851b = r1
            int r1 = com.airpay.paysdk.c.f.com_garena_beepay_empty_view_text_description
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.f3852c = r1
            int r1 = com.airpay.paysdk.c.f.com_garena_beepay_btn_navigate_to_settings
            android.view.View r1 = r6.findViewById(r1)
            android.widget.Button r1 = (android.widget.Button) r1
            r6.f3853d = r1
            android.widget.Button r1 = r6.f3853d
            com.airpay.paysdk.base.ui.weidget.-$$Lambda$BBPermissionEmptyView$KOn4ALLQLelEu5IgSEtck2a7idw r2 = new com.airpay.paysdk.base.ui.weidget.-$$Lambda$BBPermissionEmptyView$KOn4ALLQLelEu5IgSEtck2a7idw
            r2.<init>()
            r1.setOnClickListener(r2)
            if (r8 == 0) goto L_0x010a
            int[] r1 = com.airpay.paysdk.c.k.BBPermissionEmptyView
            android.content.res.TypedArray r7 = r7.obtainStyledAttributes(r8, r1)
            int r8 = com.airpay.paysdk.c.k.BBPermissionEmptyView_permission_text_reason
            java.lang.String r8 = r7.getString(r8)
            r6.setReason((java.lang.String) r8)
            int r8 = com.airpay.paysdk.c.k.BBPermissionEmptyView_permission_text_description
            java.lang.String r8 = r7.getString(r8)
            r6.setDescription(r8)
            int r8 = com.airpay.paysdk.c.k.BBPermissionEmptyView_permission_btn_settings
            r1 = 0
            boolean r8 = r7.getBoolean(r8, r1)
            r6.setSettingsButtonVisibility(r8)
            int r8 = com.airpay.paysdk.c.k.BBPermissionEmptyView_permission_image
            r2 = -1
            int r8 = r7.getResourceId(r8, r2)
            if (r8 == r2) goto L_0x0072
            android.widget.ImageView r3 = r6.f3850a
            r3.setImageResource(r8)
        L_0x0072:
            int r8 = com.airpay.paysdk.c.k.BBPermissionEmptyView_permission_theme
            java.lang.String r8 = r7.getString(r8)
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r4 = "0"
            if (r3 == 0) goto L_0x0081
            r8 = r4
        L_0x0081:
            int r3 = r8.hashCode()
            r5 = 48
            if (r3 == r5) goto L_0x0098
            r0 = 49
            if (r3 == r0) goto L_0x008e
            goto L_0x009f
        L_0x008e:
            java.lang.String r0 = "1"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x009f
            r0 = 0
            goto L_0x00a0
        L_0x0098:
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r0 = -1
        L_0x00a0:
            if (r0 == 0) goto L_0x00d5
            android.widget.TextView r8 = r6.f3851b
            android.content.res.Resources r0 = r6.getResources()
            int r1 = com.airpay.paysdk.c.b.com_garena_beepay_txt_color_light
            int r0 = r0.getColor(r1)
            r8.setTextColor(r0)
            android.widget.TextView r8 = r6.f3852c
            android.content.res.Resources r0 = r6.getResources()
            int r1 = com.airpay.paysdk.c.b.com_garena_beepay_txt_color_light
            int r0 = r0.getColor(r1)
            r8.setTextColor(r0)
            android.widget.Button r8 = r6.f3853d
            int r0 = com.airpay.paysdk.c.d.bg_btn_blue_radius_2
            r8.setBackgroundResource(r0)
            android.content.res.Resources r8 = r6.getResources()
            int r0 = com.airpay.paysdk.c.b.com_garena_beepay_bg_color_normal
            int r8 = r8.getColor(r0)
            r6.setBackgroundColor(r8)
            goto L_0x0107
        L_0x00d5:
            android.widget.TextView r8 = r6.f3851b
            android.content.res.Resources r0 = r6.getResources()
            int r1 = com.airpay.paysdk.c.b.com_garena_beepay_txt_color_white
            int r0 = r0.getColor(r1)
            r8.setTextColor(r0)
            android.widget.TextView r8 = r6.f3852c
            android.content.res.Resources r0 = r6.getResources()
            int r1 = com.airpay.paysdk.c.b.com_garena_beepay_txt_color_white
            int r0 = r0.getColor(r1)
            r8.setTextColor(r0)
            android.widget.Button r8 = r6.f3853d
            int r0 = com.airpay.paysdk.c.d.com_garena_beepay_standard_round_btn_style
            r8.setBackgroundResource(r0)
            android.content.res.Resources r8 = r6.getResources()
            int r0 = com.airpay.paysdk.c.b.com_garena_beepay_permission_dark
            int r8 = r8.getColor(r0)
            r6.setBackgroundColor(r8)
        L_0x0107:
            r7.recycle()
        L_0x010a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airpay.paysdk.base.ui.weidget.BBPermissionEmptyView.a(android.content.Context, android.util.AttributeSet):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Context context = getContext();
        a(context);
        a.a().a(context, c.i.com_garena_beepay_label_please_click_permission_and_enable_permission);
    }

    public void setReason(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f3851b.setVisibility(8);
            return;
        }
        this.f3851b.setVisibility(0);
        this.f3851b.setText(str);
    }

    public void setReason(int i) {
        setReason(getResources().getString(i));
    }

    public void setDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f3852c.setVisibility(8);
            return;
        }
        this.f3852c.setVisibility(0);
        this.f3852c.setText(str);
    }

    public void setSettingsButtonVisibility(boolean z) {
        if (z) {
            this.f3853d.setVisibility(0);
        } else {
            this.f3853d.setVisibility(8);
        }
    }

    public void setImageResource(int i) {
        this.f3850a.setImageResource(i);
    }
}
