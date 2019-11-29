package com.shopee.app.ui.chat2.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.garena.android.appkit.tools.a.b;
import com.garena.sticker.e.b;
import com.shopee.app.a;
import com.shopee.app.ui.image.editor.d.d;
import com.shopee.id.R;
import com.squareup.a.w;
import d.d.b.j;
import java.util.HashMap;

public final class c extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private b f20290a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f20291b;

    public c(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public View a(int i) {
        if (this.f20291b == null) {
            this.f20291b = new HashMap();
        }
        View view = (View) this.f20291b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f20291b.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        View.inflate(context, R.layout.sticker_item_layout, this);
        a();
    }

    private final void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        setBackgroundResource(R.drawable.bg_color_background_highlight);
        setGravity(17);
        int a2 = d.a(4, getContext());
        int a3 = d.a(8, getContext());
        setPadding(a2, a3, a2, a3);
    }

    public final void setSticker(b bVar) {
        j.b(bVar, "stickerModel");
        this.f20290a = bVar;
        b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
        if (r1 != null) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b() {
        /*
            r4 = this;
            int r0 = com.shopee.app.a.C0250a.tv_roboto
            android.view.View r0 = r4.a((int) r0)
            com.devspark.robototextview.widget.RobotoTextView r0 = (com.devspark.robototextview.widget.RobotoTextView) r0
            java.lang.String r1 = "tv_roboto"
            d.d.b.j.a((java.lang.Object) r0, (java.lang.String) r1)
            com.garena.sticker.e.b r2 = r4.f20290a
            if (r2 == 0) goto L_0x001d
            boolean r2 = r2.e()
            r3 = 1
            if (r2 != r3) goto L_0x001d
            int r2 = r4.getVisibility()
            goto L_0x001f
        L_0x001d:
            r2 = 8
        L_0x001f:
            r0.setVisibility(r2)
            int r0 = com.shopee.app.a.C0250a.tv_roboto
            android.view.View r0 = r4.a((int) r0)
            com.devspark.robototextview.widget.RobotoTextView r0 = (com.devspark.robototextview.widget.RobotoTextView) r0
            d.d.b.j.a((java.lang.Object) r0, (java.lang.String) r1)
            com.garena.sticker.e.b r1 = r4.f20290a
            if (r1 == 0) goto L_0x0038
            java.lang.String r1 = r1.b()
            if (r1 == 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            java.lang.String r1 = ""
        L_0x003a:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = com.shopee.app.a.C0250a.layout_square_frame
            android.view.View r0 = r4.a((int) r0)
            com.shopee.app.ui.common.SquareFrameLayout r0 = (com.shopee.app.ui.common.SquareFrameLayout) r0
            r1 = 56
            r0.setMaxWidth(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.chat2.b.c.b():void");
    }

    public final void a(String str) {
        j.b(str, "url");
        w.a(getContext()).a(str).b(b.a.r, b.a.r).e().a((int) R.drawable.default_sticker).a((ImageView) a(a.C0250a.sticker_image));
    }
}
