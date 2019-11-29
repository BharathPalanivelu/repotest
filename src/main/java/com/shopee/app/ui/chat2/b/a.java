package com.shopee.app.ui.chat2.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.devspark.robototextview.widget.RobotoButton;
import com.shopee.app.a;
import com.shopee.app.data.viewmodel.StickerPack;
import com.shopee.id.R;
import d.d.b.j;
import java.util.HashMap;

public final class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private StickerPack f20282a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f20283b;

    public a(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public View a(int i) {
        if (this.f20283b == null) {
            this.f20283b = new HashMap();
        }
        View view = (View) this.f20283b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f20283b.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        View.inflate(context, R.layout.sticker_download_layout, this);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    public final void setPack(StickerPack stickerPack) {
        j.b(stickerPack, "packModel");
        this.f20282a = stickerPack;
        a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0033, code lost:
        if (r2 != null) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r4 = this;
            int r0 = com.shopee.app.a.C0250a.download_btn
            android.view.View r0 = r4.a(r0)
            com.devspark.robototextview.widget.RobotoButton r0 = (com.devspark.robototextview.widget.RobotoButton) r0
            java.lang.String r1 = "download_btn"
            d.d.b.j.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.res.Resources r2 = r4.getResources()
            r3 = 2131888197(0x7f120845, float:1.9411023E38)
            java.lang.String r2 = r2.getString(r3)
            r1.append(r2)
            java.lang.String r2 = " ("
            r1.append(r2)
            com.shopee.app.data.viewmodel.StickerPack r2 = r4.f20282a
            if (r2 == 0) goto L_0x0036
            com.garena.sticker.e.a r2 = r2.getPack()
            if (r2 == 0) goto L_0x0036
            java.lang.String r2 = r2.e()
            if (r2 == 0) goto L_0x0036
            goto L_0x003b
        L_0x0036:
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x003b:
            r1.append(r2)
            java.lang.String r2 = "Mb)"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            com.shopee.app.data.viewmodel.StickerPack r0 = r4.f20282a
            if (r0 == 0) goto L_0x007b
            com.garena.sticker.e.a r0 = r0.getPack()
            if (r0 == 0) goto L_0x007b
            java.lang.String r0 = r0.b()
            if (r0 == 0) goto L_0x007b
            int r1 = com.garena.android.appkit.tools.a.b.a.f7696g
            int r1 = r1 * 10
            android.content.Context r2 = r4.getContext()
            com.squareup.a.w r2 = com.squareup.a.w.a((android.content.Context) r2)
            com.squareup.a.aa r0 = r2.a((java.lang.String) r0)
            com.squareup.a.aa r0 = r0.b(r1, r1)
            int r1 = com.shopee.app.a.C0250a.download_icon
            android.view.View r1 = r4.a(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.a((android.widget.ImageView) r1)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.chat2.b.a.a():void");
    }

    public final void setDownloadBtnClickListener(View.OnClickListener onClickListener) {
        ((RobotoButton) a(a.C0250a.download_btn)).setOnClickListener(onClickListener);
    }
}
