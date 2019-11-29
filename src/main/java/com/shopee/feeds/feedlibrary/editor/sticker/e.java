package com.shopee.feeds.feedlibrary.editor.sticker;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.b.c;
import com.shopee.feeds.feedlibrary.view.GradientTextView;

public class e extends c {
    private GradientTextView i;
    private TextView j;
    private TextView k;

    public e(Context context) {
        this(context, (AttributeSet) null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View inflate = LayoutInflater.from(context).inflate(c.f.feeds_layout_photo_editor_sticker_voucher_item_view, this, true);
        this.i = (GradientTextView) inflate.findViewById(c.e.tv_voucher);
        this.j = (TextView) inflate.findViewById(c.e.tv_status);
        this.k = (TextView) inflate.findViewById(c.e.tv_describe);
        this.i.a(c.b.feeds_comment_voucher_sticker_text_gradient_start, c.b.feeds_comment_voucher_sticker_text_gradient_end);
        this.i.invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(2.0f);
        }
        this.j.setText(b.e(c.g.feeds_voucher_claim));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0336  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:61:0x0205=Splitter:B:61:0x0205, B:40:0x015a=Splitter:B:40:0x015a, B:76:0x026f=Splitter:B:76:0x026f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setInfo(com.shopee.feeds.feedlibrary.editor.b.b r20) {
        /*
            r19 = this;
            r1 = r19
            super.setInfo(r20)
            r2 = r20
            com.shopee.feeds.feedlibrary.editor.sticker.a.f r2 = (com.shopee.feeds.feedlibrary.editor.sticker.a.f) r2
            int r3 = r2.o()
            java.lang.String r4 = r2.y()
            java.lang.String r5 = r2.z()
            java.lang.String r0 = com.shopee.feeds.feedlibrary.util.v.b()
            java.lang.String r6 = "0"
            java.lang.String r7 = "%"
            java.lang.String r8 = "TW"
            java.lang.String r9 = ""
            r10 = 0
            r11 = 1
            if (r3 == 0) goto L_0x0054
            if (r3 == r11) goto L_0x0031
            r20 = r6
            r7 = r9
            r14 = r7
            r15 = r14
            r6 = 0
        L_0x002d:
            r12 = 0
            r13 = 0
            goto L_0x00d7
        L_0x0031:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            int r13 = r2.p()
            r12.append(r13)
            r12.append(r7)
            java.lang.String r7 = r12.toString()
            int r12 = com.shopee.feeds.feedlibrary.c.g.feeds_voucher_sticker_coins_cashback
            java.lang.Object[] r13 = new java.lang.Object[r11]
            r13[r10] = r9
            java.lang.String r12 = com.garena.android.appkit.tools.b.a(r12, r13)
            r20 = r6
            r14 = r9
            r15 = r12
            r6 = 1
            goto L_0x002d
        L_0x0054:
            java.lang.String r12 = r2.n()
            boolean r12 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r12)
            if (r12 != 0) goto L_0x008e
            java.lang.String r12 = r2.n()
            boolean r12 = r12.equals(r6)
            if (r12 != 0) goto L_0x008e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r12 = com.shopee.feeds.feedlibrary.util.v.a()
            r7.append(r12)
            java.lang.String r12 = r2.n()
            java.lang.String r12 = com.shopee.feeds.feedlibrary.util.v.c(r12, r11)
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            java.lang.String r12 = r2.n()
            java.lang.String r12 = com.shopee.feeds.feedlibrary.util.v.e(r12)
            r14 = r12
            r12 = 1
            goto L_0x00bd
        L_0x008e:
            int r12 = r2.m()
            if (r12 <= 0) goto L_0x00ba
            boolean r12 = r8.equals(r0)
            if (r12 == 0) goto L_0x00a3
            int r7 = r2.m()
            java.lang.String r7 = com.shopee.feeds.feedlibrary.util.v.a((int) r7)
            goto L_0x00b6
        L_0x00a3:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            int r13 = r2.m()
            r12.append(r13)
            r12.append(r7)
            java.lang.String r7 = r12.toString()
        L_0x00b6:
            r14 = r9
            r12 = 0
            r13 = 1
            goto L_0x00be
        L_0x00ba:
            r7 = r9
            r14 = r7
            r12 = 0
        L_0x00bd:
            r13 = 0
        L_0x00be:
            boolean r15 = r8.equals(r0)
            if (r15 == 0) goto L_0x00c9
            java.lang.String r15 = "折 "
            r20 = r6
            goto L_0x00d6
        L_0x00c9:
            int r15 = com.shopee.feeds.feedlibrary.c.g.feeds_voucher_sticker_view_off_label
            r20 = r6
            java.lang.Object[] r6 = new java.lang.Object[r11]
            r6[r10] = r9
            java.lang.String r6 = com.garena.android.appkit.tools.b.a(r15, r6)
            r15 = r6
        L_0x00d6:
            r6 = 0
        L_0x00d7:
            android.text.SpannableString r11 = new android.text.SpannableString
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r15)
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            android.text.style.AbsoluteSizeSpan r10 = new android.text.style.AbsoluteSizeSpan
            int r16 = com.shopee.feeds.feedlibrary.c.C0424c.feeds_voucher_title_txt_size_big
            r17 = r9
            int r9 = com.garena.android.appkit.tools.b.d(r16)
            r10.<init>(r9)
            android.text.style.AbsoluteSizeSpan r9 = new android.text.style.AbsoluteSizeSpan
            int r10 = com.shopee.feeds.feedlibrary.c.C0424c.feeds_voucher_title_txt_size_small
            int r10 = com.garena.android.appkit.tools.b.d(r10)
            r9.<init>(r10)
            java.lang.String r9 = "TH"
            java.lang.String r10 = "VN"
            r16 = r11
            java.lang.String r11 = "ID"
            r18 = r2
            r2 = 18
            if (r12 == 0) goto L_0x01c3
            boolean r6 = r11.equals(r0)     // Catch:{ Exception -> 0x01be }
            if (r6 != 0) goto L_0x015a
            boolean r6 = r10.equals(r0)     // Catch:{ Exception -> 0x01be }
            if (r6 != 0) goto L_0x015a
            boolean r6 = r8.equals(r0)     // Catch:{ Exception -> 0x01be }
            if (r6 != 0) goto L_0x015a
            boolean r0 = r9.equals(r0)     // Catch:{ Exception -> 0x01be }
            if (r0 == 0) goto L_0x012a
            goto L_0x015a
        L_0x012a:
            android.text.SpannableString r11 = new android.text.SpannableString     // Catch:{ Exception -> 0x01be }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01be }
            r0.<init>()     // Catch:{ Exception -> 0x01be }
            r0.append(r7)     // Catch:{ Exception -> 0x01be }
            r0.append(r14)     // Catch:{ Exception -> 0x01be }
            r0.append(r15)     // Catch:{ Exception -> 0x01be }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01be }
            r11.<init>(r0)     // Catch:{ Exception -> 0x01be }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28275g     // Catch:{ Exception -> 0x0232 }
            int r6 = r7.length()     // Catch:{ Exception -> 0x0232 }
            r8 = 0
            r11.setSpan(r0, r8, r6, r2)     // Catch:{ Exception -> 0x0232 }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28274f     // Catch:{ Exception -> 0x0232 }
            int r6 = r7.length()     // Catch:{ Exception -> 0x0232 }
            int r7 = r11.length()     // Catch:{ Exception -> 0x0232 }
            r11.setSpan(r0, r6, r7, r2)     // Catch:{ Exception -> 0x0232 }
            goto L_0x02a1
        L_0x015a:
            android.text.SpannableString r11 = new android.text.SpannableString     // Catch:{ Exception -> 0x01be }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01be }
            r0.<init>()     // Catch:{ Exception -> 0x01be }
            r0.append(r15)     // Catch:{ Exception -> 0x01be }
            r0.append(r7)     // Catch:{ Exception -> 0x01be }
            r0.append(r14)     // Catch:{ Exception -> 0x01be }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01be }
            r11.<init>(r0)     // Catch:{ Exception -> 0x01be }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28274f     // Catch:{ Exception -> 0x0232 }
            android.text.style.CharacterStyle r0 = android.text.style.CharacterStyle.wrap(r0)     // Catch:{ Exception -> 0x0232 }
            int r6 = r15.length()     // Catch:{ Exception -> 0x0232 }
            r8 = 0
            r11.setSpan(r0, r8, r6, r2)     // Catch:{ Exception -> 0x0232 }
            boolean r0 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r14)     // Catch:{ Exception -> 0x0232 }
            if (r0 != 0) goto L_0x01af
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28275g     // Catch:{ Exception -> 0x0232 }
            int r6 = r15.length()     // Catch:{ Exception -> 0x0232 }
            int r8 = r15.length()     // Catch:{ Exception -> 0x0232 }
            int r9 = r7.length()     // Catch:{ Exception -> 0x0232 }
            int r8 = r8 + r9
            r11.setSpan(r0, r6, r8, r2)     // Catch:{ Exception -> 0x0232 }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28274f     // Catch:{ Exception -> 0x0232 }
            android.text.style.CharacterStyle r0 = android.text.style.CharacterStyle.wrap(r0)     // Catch:{ Exception -> 0x0232 }
            int r6 = r15.length()     // Catch:{ Exception -> 0x0232 }
            int r7 = r7.length()     // Catch:{ Exception -> 0x0232 }
            int r6 = r6 + r7
            int r7 = r11.length()     // Catch:{ Exception -> 0x0232 }
            r11.setSpan(r0, r6, r7, r2)     // Catch:{ Exception -> 0x0232 }
            goto L_0x02a1
        L_0x01af:
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28275g     // Catch:{ Exception -> 0x0232 }
            int r6 = r15.length()     // Catch:{ Exception -> 0x0232 }
            int r7 = r11.length()     // Catch:{ Exception -> 0x0232 }
            r11.setSpan(r0, r6, r7, r2)     // Catch:{ Exception -> 0x0232 }
            goto L_0x02a1
        L_0x01be:
            r0 = move-exception
            r11 = r16
            goto L_0x029b
        L_0x01c3:
            if (r13 == 0) goto L_0x0234
            boolean r6 = r11.equals(r0)     // Catch:{ Exception -> 0x01be }
            if (r6 != 0) goto L_0x0205
            boolean r6 = r10.equals(r0)     // Catch:{ Exception -> 0x01be }
            if (r6 != 0) goto L_0x0205
            boolean r0 = r9.equals(r0)     // Catch:{ Exception -> 0x01be }
            if (r0 == 0) goto L_0x01d8
            goto L_0x0205
        L_0x01d8:
            android.text.SpannableString r11 = new android.text.SpannableString     // Catch:{ Exception -> 0x01be }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01be }
            r0.<init>()     // Catch:{ Exception -> 0x01be }
            r0.append(r7)     // Catch:{ Exception -> 0x01be }
            r0.append(r15)     // Catch:{ Exception -> 0x01be }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01be }
            r11.<init>(r0)     // Catch:{ Exception -> 0x01be }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28275g     // Catch:{ Exception -> 0x0232 }
            int r6 = r7.length()     // Catch:{ Exception -> 0x0232 }
            r8 = 0
            r11.setSpan(r0, r8, r6, r2)     // Catch:{ Exception -> 0x0232 }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28274f     // Catch:{ Exception -> 0x0232 }
            int r6 = r7.length()     // Catch:{ Exception -> 0x0232 }
            int r7 = r11.length()     // Catch:{ Exception -> 0x0232 }
            r11.setSpan(r0, r6, r7, r2)     // Catch:{ Exception -> 0x0232 }
            goto L_0x02a1
        L_0x0205:
            android.text.SpannableString r11 = new android.text.SpannableString     // Catch:{ Exception -> 0x01be }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01be }
            r0.<init>()     // Catch:{ Exception -> 0x01be }
            r0.append(r15)     // Catch:{ Exception -> 0x01be }
            r0.append(r7)     // Catch:{ Exception -> 0x01be }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01be }
            r11.<init>(r0)     // Catch:{ Exception -> 0x01be }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28274f     // Catch:{ Exception -> 0x0232 }
            int r6 = r15.length()     // Catch:{ Exception -> 0x0232 }
            r7 = 0
            r11.setSpan(r0, r7, r6, r2)     // Catch:{ Exception -> 0x0232 }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28275g     // Catch:{ Exception -> 0x0232 }
            int r6 = r15.length()     // Catch:{ Exception -> 0x0232 }
            int r7 = r11.length()     // Catch:{ Exception -> 0x0232 }
            r11.setSpan(r0, r6, r7, r2)     // Catch:{ Exception -> 0x0232 }
            goto L_0x02a1
        L_0x0232:
            r0 = move-exception
            goto L_0x029b
        L_0x0234:
            if (r6 == 0) goto L_0x029f
            boolean r6 = r11.equals(r0)     // Catch:{ Exception -> 0x01be }
            if (r6 != 0) goto L_0x026f
            boolean r0 = r10.equals(r0)     // Catch:{ Exception -> 0x01be }
            if (r0 == 0) goto L_0x0243
            goto L_0x026f
        L_0x0243:
            android.text.SpannableString r11 = new android.text.SpannableString     // Catch:{ Exception -> 0x01be }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01be }
            r0.<init>()     // Catch:{ Exception -> 0x01be }
            r0.append(r7)     // Catch:{ Exception -> 0x01be }
            r0.append(r15)     // Catch:{ Exception -> 0x01be }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01be }
            r11.<init>(r0)     // Catch:{ Exception -> 0x01be }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28275g     // Catch:{ Exception -> 0x0232 }
            int r6 = r7.length()     // Catch:{ Exception -> 0x0232 }
            r8 = 0
            r11.setSpan(r0, r8, r6, r2)     // Catch:{ Exception -> 0x0232 }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28274f     // Catch:{ Exception -> 0x0232 }
            int r6 = r7.length()     // Catch:{ Exception -> 0x0232 }
            int r7 = r11.length()     // Catch:{ Exception -> 0x0232 }
            r11.setSpan(r0, r6, r7, r2)     // Catch:{ Exception -> 0x0232 }
            goto L_0x02a1
        L_0x026f:
            android.text.SpannableString r11 = new android.text.SpannableString     // Catch:{ Exception -> 0x01be }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01be }
            r0.<init>()     // Catch:{ Exception -> 0x01be }
            r0.append(r15)     // Catch:{ Exception -> 0x01be }
            r0.append(r7)     // Catch:{ Exception -> 0x01be }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01be }
            r11.<init>(r0)     // Catch:{ Exception -> 0x01be }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28274f     // Catch:{ Exception -> 0x0232 }
            int r6 = r15.length()     // Catch:{ Exception -> 0x0232 }
            r7 = 0
            r11.setSpan(r0, r7, r6, r2)     // Catch:{ Exception -> 0x0232 }
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28275g     // Catch:{ Exception -> 0x0232 }
            int r6 = r15.length()     // Catch:{ Exception -> 0x0232 }
            int r7 = r11.length()     // Catch:{ Exception -> 0x0232 }
            r11.setSpan(r0, r6, r7, r2)     // Catch:{ Exception -> 0x0232 }
            goto L_0x02a1
        L_0x029b:
            r0.printStackTrace()
            goto L_0x02a1
        L_0x029f:
            r11 = r16
        L_0x02a1:
            com.shopee.feeds.feedlibrary.view.GradientTextView r0 = r1.i
            r0.setText(r11)
            boolean r0 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r5)
            if (r0 == 0) goto L_0x02ae
            r5 = r20
        L_0x02ae:
            boolean r0 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r4)
            if (r0 != 0) goto L_0x0336
            r2 = 1
            if (r3 == r2) goto L_0x02bc
            java.lang.String r9 = com.shopee.feeds.feedlibrary.util.v.a()
            goto L_0x02be
        L_0x02bc:
            r9 = r17
        L_0x02be:
            r0 = 2
            if (r3 != r2) goto L_0x02f9
            int r3 = com.shopee.feeds.feedlibrary.c.g.feeds_voucher_sticker_min_spend_with_capped_for_coin_cashback
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = com.shopee.feeds.feedlibrary.util.v.a()
            r6.append(r7)
            java.lang.String r5 = com.shopee.feeds.feedlibrary.util.v.b(r5, r2)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r6 = 0
            r0[r6] = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r9)
            java.lang.String r4 = com.shopee.feeds.feedlibrary.util.v.d(r4)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r0[r2] = r4
            java.lang.String r0 = com.garena.android.appkit.tools.b.a(r3, r0)
            goto L_0x0330
        L_0x02f9:
            int r3 = com.shopee.feeds.feedlibrary.c.g.feeds_voucher_sticker_min_spend_with_capped
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = com.shopee.feeds.feedlibrary.util.v.a()
            r6.append(r7)
            java.lang.String r5 = com.shopee.feeds.feedlibrary.util.v.b(r5, r2)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r6 = 0
            r0[r6] = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r9)
            java.lang.String r4 = com.shopee.feeds.feedlibrary.util.v.b(r4, r2)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r0[r2] = r4
            java.lang.String r0 = com.garena.android.appkit.tools.b.a(r3, r0)
        L_0x0330:
            android.widget.TextView r2 = r1.k
            r2.setText(r0)
            goto L_0x0362
        L_0x0336:
            r2 = 1
            int r0 = com.shopee.feeds.feedlibrary.c.g.feeds_voucher_sticker_min_spend
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = com.shopee.feeds.feedlibrary.util.v.a()
            r4.append(r5)
            java.lang.String r5 = r18.z()
            java.lang.String r2 = com.shopee.feeds.feedlibrary.util.v.b(r5, r2)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r4 = 0
            r3[r4] = r2
            java.lang.String r0 = com.garena.android.appkit.tools.b.a(r0, r3)
            android.widget.TextView r2 = r1.k
            r2.setText(r0)
        L_0x0362:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.editor.sticker.e.setInfo(com.shopee.feeds.feedlibrary.editor.b.b):void");
    }
}
