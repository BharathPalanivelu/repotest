package com.shopee.feeds.feedlibrary.editor.text;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import com.devspark.robototextview.widget.RobotoTextView;
import com.facebook.appevents.AppEventsConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.util.c;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.v;

public class PriceTextView extends RobotoTextView {
    public PriceTextView(Context context) {
        super(context);
    }

    public PriceTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PriceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setPrice(ProductEntity.ProductItem productItem) {
        boolean z = !d.a(productItem.getPrice());
        boolean z2 = !d.a(productItem.getPrice_max());
        boolean z3 = !d.a(productItem.getPrice_min());
        boolean z4 = !d.a(productItem.getPrice_before_discount());
        String a2 = a(z ? productItem.getPrice() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a3 = a(z2 ? productItem.getPrice_max() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a4 = a(z3 ? productItem.getPrice_min() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a5 = a(z4 ? productItem.getPrice_before_discount() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        final String a6 = v.a();
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a3) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a4) || (z2 && a3.equals(a4))) {
            final String str = a6 + v.a(a2);
            final String str2 = a6 + v.a(a5);
            if (!z4 || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a5) || productItem.getPrice_before_discount().equals(a2)) {
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(c.f28270b, 0, a6.length(), 33);
                spannableString.setSpan(c.f28269a, a6.length(), spannableString.length(), 33);
                setText(spannableString);
                return;
            }
            setText(str2 + str);
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    PriceTextView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    String str = str;
                    String str2 = str2;
                    if (PriceTextView.this.getLineCount() > 1) {
                        int lineEnd = PriceTextView.this.getLayout().getLineEnd(0);
                        if (lineEnd - 3 > str.length()) {
                            int length = lineEnd - str.length();
                            String str3 = PriceTextView.this.getText().subSequence(0, length - 3) + "...";
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            sb.append(SQLBuilder.BLANK);
                            sb.append(str);
                            SpannableString spannableString = new SpannableString(sb.toString());
                            spannableString.setSpan(c.f28272d, 0, str3.length(), 33);
                            spannableString.setSpan(c.f28270b, str3.length() + 1, str3.length() + a6.length() + 1, 33);
                            spannableString.setSpan(c.f28269a, str3.length() + a6.length() + 1, sb.length(), 33);
                            PriceTextView.this.setText(spannableString);
                        } else {
                            SpannableString spannableString2 = new SpannableString(str.subSequence(0, lineEnd - 1) + "...");
                            spannableString2.setSpan(c.f28270b, 0, a6.length(), 33);
                            spannableString2.setSpan(c.f28269a, a6.length(), spannableString2.length(), 33);
                            PriceTextView.this.setText(spannableString2);
                        }
                    } else {
                        SpannableString spannableString3 = new SpannableString(str2 + SQLBuilder.BLANK + str);
                        spannableString3.setSpan(c.f28272d, 0, str2.length(), 33);
                        spannableString3.setSpan(c.f28270b, str2.length() + 1, str2.length() + a6.length() + 1, 33);
                        spannableString3.setSpan(c.f28269a, str2.length() + a6.length() + 1, spannableString3.length(), 33);
                        PriceTextView.this.setText(spannableString3);
                    }
                    return false;
                }
            });
        } else if (z2 && z3) {
            String str3 = a6 + v.a(a4);
            String str4 = str3 + " ~ " + (a6 + v.a(a3));
            if (str4.length() > 17) {
                str4 = str4.substring(0, 17) + "...";
            }
            SpannableString spannableString2 = new SpannableString(str4);
            spannableString2.setSpan(c.f28271c, 0, a6.length(), 33);
            if (str3.length() + 3 <= spannableString2.length()) {
                spannableString2.setSpan(c.f28273e, a6.length(), str3.length() + 3, 33);
                if (str3.length() + 3 + a6.length() <= spannableString2.length()) {
                    spannableString2.setSpan(c.f28270b, str3.length() + 3, str3.length() + 3 + a6.length(), 33);
                    if (str3.length() + 3 + a6.length() <= spannableString2.length()) {
                        spannableString2.setSpan(c.f28269a, str3.length() + 3 + a6.length(), spannableString2.length(), 33);
                    }
                    setText(spannableString2);
                    return;
                }
                spannableString2.setSpan(c.f28270b, str3.length() + 3, spannableString2.length(), 33);
                setText(spannableString2);
                return;
            }
            spannableString2.setSpan(c.f28273e, a6.length(), spannableString2.length(), 33);
            setText(spannableString2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setPriceWithOutIntervalPrice(com.shopee.feeds.feedlibrary.data.entity.ProductEntity.ProductItem r17) {
        /*
            r16 = this;
            r9 = r16
            java.lang.String r0 = r17.getPrice()
            boolean r0 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r0)
            r0 = r0 ^ 1
            java.lang.String r1 = r17.getPrice_max()
            boolean r1 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r1)
            r1 = r1 ^ 1
            java.lang.String r2 = r17.getPrice_min()
            boolean r2 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r2)
            r2 = r2 ^ 1
            java.lang.String r3 = r17.getPrice_before_discount()
            boolean r3 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r3)
            r3 = r3 ^ 1
            java.lang.String r4 = r17.getPrice_min_before_discount()
            boolean r4 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r4)
            r4 = r4 ^ 1
            java.lang.String r5 = r17.getPrice_max_before_discount()
            boolean r5 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r5)
            r5 = r5 ^ 1
            java.lang.String r6 = "0"
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r17.getPrice()
            goto L_0x0048
        L_0x0047:
            r0 = r6
        L_0x0048:
            java.lang.String r0 = r9.a(r0)
            if (r1 == 0) goto L_0x0053
            java.lang.String r1 = r17.getPrice_max()
            goto L_0x0054
        L_0x0053:
            r1 = r6
        L_0x0054:
            java.lang.String r7 = r9.a(r1)
            if (r2 == 0) goto L_0x005f
            java.lang.String r1 = r17.getPrice_min()
            goto L_0x0060
        L_0x005f:
            r1 = r6
        L_0x0060:
            java.lang.String r8 = r9.a(r1)
            if (r3 == 0) goto L_0x006b
            java.lang.String r1 = r17.getPrice_before_discount()
            goto L_0x006c
        L_0x006b:
            r1 = r6
        L_0x006c:
            java.lang.String r1 = r9.a(r1)
            if (r4 == 0) goto L_0x0077
            java.lang.String r2 = r17.getPrice_min_before_discount()
            goto L_0x0078
        L_0x0077:
            r2 = r6
        L_0x0078:
            java.lang.String r10 = r9.a(r2)
            if (r5 == 0) goto L_0x0083
            java.lang.String r2 = r17.getPrice_max_before_discount()
            goto L_0x0084
        L_0x0083:
            r2 = r6
        L_0x0084:
            java.lang.String r11 = r9.a(r2)
            java.lang.String r4 = com.shopee.feeds.feedlibrary.util.v.a()
            boolean r2 = r6.equals(r1)
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x00a8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r1 = com.shopee.feeds.feedlibrary.util.v.a((java.lang.String) r1)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L_0x00a9
        L_0x00a8:
            r1 = r3
        L_0x00a9:
            boolean r2 = r6.equals(r7)
            java.lang.String r5 = "~"
            if (r2 != 0) goto L_0x00e0
            boolean r2 = r6.equals(r8)
            if (r2 != 0) goto L_0x00e0
            boolean r2 = r7.equals(r8)
            if (r2 != 0) goto L_0x00e0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r1 = com.shopee.feeds.feedlibrary.util.v.a((java.lang.String) r8)
            r0.append(r1)
            r0.append(r5)
            r0.append(r4)
            java.lang.String r1 = com.shopee.feeds.feedlibrary.util.v.a((java.lang.String) r7)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2 = r0
            r12 = r3
            goto L_0x00f5
        L_0x00e0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r0 = com.shopee.feeds.feedlibrary.util.v.a((java.lang.String) r0)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r2 = r0
            r12 = r1
        L_0x00f5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            r0.append(r2)
            boolean r1 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r12)
            if (r1 != 0) goto L_0x0109
            r0.append(r5)
        L_0x0109:
            int r1 = r2.indexOf(r5)
            r13 = -1
            if (r1 == r13) goto L_0x0113
            r0.append(r5)
        L_0x0113:
            int r1 = r12.indexOf(r5)
            if (r1 == r13) goto L_0x011c
            r0.append(r5)
        L_0x011c:
            com.shopee.feeds.feedlibrary.util.j r1 = com.shopee.feeds.feedlibrary.util.j.a()
            int r1 = r1.h()
            if (r1 <= 0) goto L_0x02d4
            int r14 = r2.indexOf(r5)
            java.lang.String r15 = " ~ "
            if (r14 == r13) goto L_0x014e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r14 = com.shopee.feeds.feedlibrary.util.v.a((java.lang.String) r8)
            r2.append(r14)
            r2.append(r15)
            r2.append(r4)
            java.lang.String r14 = com.shopee.feeds.feedlibrary.util.v.a((java.lang.String) r7)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
        L_0x014e:
            int r5 = r12.indexOf(r5)
            if (r5 == r13) goto L_0x0175
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r10 = com.shopee.feeds.feedlibrary.util.v.a((java.lang.String) r10)
            r5.append(r10)
            r5.append(r15)
            r5.append(r4)
            java.lang.String r10 = com.shopee.feeds.feedlibrary.util.v.a((java.lang.String) r11)
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            goto L_0x0176
        L_0x0175:
            r5 = r12
        L_0x0176:
            java.lang.String r0 = r0.toString()
            int r0 = r0.length()
            r10 = 0
            if (r0 <= r1) goto L_0x01c2
            int r0 = r1 + -1
            int r11 = r2.length()
            java.lang.String r12 = "..."
            if (r0 <= r11) goto L_0x01ae
            boolean r0 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r5)
            if (r0 != 0) goto L_0x01c2
            int r0 = r2.length()
            int r1 = r1 - r0
            int r1 = r1 + -1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r1 + -1
            java.lang.CharSequence r1 = r5.subSequence(r10, r1)
            r0.append(r1)
            r0.append(r12)
            java.lang.String r3 = r0.toString()
            goto L_0x01c3
        L_0x01ae:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.CharSequence r0 = r2.subSequence(r10, r0)
            r1.append(r0)
            r1.append(r12)
            java.lang.String r2 = r1.toString()
            goto L_0x01c3
        L_0x01c2:
            r3 = r5
        L_0x01c3:
            boolean r0 = r6.equals(r7)
            r1 = 33
            if (r0 != 0) goto L_0x025d
            boolean r0 = r6.equals(r8)
            if (r0 != 0) goto L_0x025d
            boolean r0 = r7.equals(r8)
            if (r0 != 0) goto L_0x025d
            int r0 = r4.length()
            java.lang.String r3 = com.shopee.feeds.feedlibrary.util.v.a((java.lang.String) r8)
            int r3 = r3.length()
            android.text.SpannableString r4 = new android.text.SpannableString
            r4.<init>(r2)
            int r5 = r2.length()
            int r6 = r0 * 2
            int r7 = r6 + 3
            int r7 = r7 + r3
            if (r5 <= r7) goto L_0x0221
            android.text.style.CharacterStyle r2 = com.shopee.feeds.feedlibrary.util.c.f28270b
            android.text.style.CharacterStyle r2 = android.text.style.CharacterStyle.wrap(r2)
            r4.setSpan(r2, r10, r0, r1)
            android.text.style.CharacterStyle r2 = com.shopee.feeds.feedlibrary.util.c.f28269a
            android.text.style.CharacterStyle r2 = android.text.style.CharacterStyle.wrap(r2)
            int r5 = r0 + r3
            r4.setSpan(r2, r0, r5, r1)
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28270b
            android.text.style.CharacterStyle r0 = android.text.style.CharacterStyle.wrap(r0)
            int r6 = r6 + r3
            int r6 = r6 + 3
            r4.setSpan(r0, r5, r6, r1)
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28269a
            android.text.style.CharacterStyle r0 = android.text.style.CharacterStyle.wrap(r0)
            int r2 = r4.length()
            r4.setSpan(r0, r6, r2, r1)
            goto L_0x0259
        L_0x0221:
            int r2 = r2.length()
            int r5 = r0 + 3
            int r5 = r5 + r3
            if (r2 <= r5) goto L_0x024b
            android.text.style.CharacterStyle r2 = com.shopee.feeds.feedlibrary.util.c.f28270b
            android.text.style.CharacterStyle r2 = android.text.style.CharacterStyle.wrap(r2)
            r4.setSpan(r2, r10, r0, r1)
            android.text.style.CharacterStyle r2 = com.shopee.feeds.feedlibrary.util.c.f28269a
            android.text.style.CharacterStyle r2 = android.text.style.CharacterStyle.wrap(r2)
            int r3 = r3 + r0
            r4.setSpan(r2, r0, r3, r1)
            android.text.style.CharacterStyle r0 = com.shopee.feeds.feedlibrary.util.c.f28270b
            android.text.style.CharacterStyle r0 = android.text.style.CharacterStyle.wrap(r0)
            int r2 = r4.length()
            r4.setSpan(r0, r3, r2, r1)
            goto L_0x0259
        L_0x024b:
            android.text.style.CharacterStyle r2 = com.shopee.feeds.feedlibrary.util.c.f28270b
            r4.setSpan(r2, r10, r0, r1)
            android.text.style.CharacterStyle r2 = com.shopee.feeds.feedlibrary.util.c.f28269a
            int r3 = r4.length()
            r4.setSpan(r2, r0, r3, r1)
        L_0x0259:
            r9.setText(r4)
            goto L_0x02d3
        L_0x025d:
            boolean r0 = com.shopee.feeds.feedlibrary.util.d.a((java.lang.String) r3)
            if (r0 != 0) goto L_0x02b5
            android.text.SpannableString r0 = new android.text.SpannableString
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r6 = " "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.<init>(r2)
            android.text.style.CharacterStyle r2 = com.shopee.feeds.feedlibrary.util.c.f28272d
            int r5 = r3.length()
            r0.setSpan(r2, r10, r5, r1)
            android.text.style.CharacterStyle r2 = com.shopee.feeds.feedlibrary.util.c.f28270b
            int r5 = r3.length()
            int r5 = r5 + 1
            int r6 = r3.length()
            int r6 = r6 + 1
            int r7 = r4.length()
            int r6 = r6 + r7
            r0.setSpan(r2, r5, r6, r1)
            android.text.style.CharacterStyle r2 = com.shopee.feeds.feedlibrary.util.c.f28269a
            int r3 = r3.length()
            int r3 = r3 + 1
            int r4 = r4.length()
            int r3 = r3 + r4
            int r3 = r3 + 1
            int r4 = r0.length()
            r0.setSpan(r2, r3, r4, r1)
            r9.setText(r0)
            goto L_0x02d3
        L_0x02b5:
            android.text.SpannableString r0 = new android.text.SpannableString
            r0.<init>(r2)
            android.text.style.CharacterStyle r2 = com.shopee.feeds.feedlibrary.util.c.f28270b
            int r3 = r4.length()
            r0.setSpan(r2, r10, r3, r1)
            android.text.style.CharacterStyle r2 = com.shopee.feeds.feedlibrary.util.c.f28269a
            int r3 = r4.length()
            int r4 = r0.length()
            r0.setSpan(r2, r3, r4, r1)
            r9.setText(r0)
        L_0x02d3:
            return
        L_0x02d4:
            java.lang.String r0 = r0.toString()
            r9.setText(r0)
            android.view.ViewTreeObserver r13 = r16.getViewTreeObserver()
            com.shopee.feeds.feedlibrary.editor.text.PriceTextView$2 r14 = new com.shopee.feeds.feedlibrary.editor.text.PriceTextView$2
            r0 = r14
            r1 = r16
            r3 = r12
            r5 = r8
            r6 = r7
            r7 = r10
            r8 = r11
            r0.<init>(r2, r3, r4, r5, r6, r7, r8)
            r13.addOnPreDrawListener(r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.editor.text.PriceTextView.setPriceWithOutIntervalPrice(com.shopee.feeds.feedlibrary.data.entity.ProductEntity$ProductItem):void");
    }

    public void setPriceWithIntervalPrice(ProductEntity.ProductItem productItem) {
        String str;
        String str2;
        boolean z = !d.a(productItem.getPrice());
        boolean z2 = !d.a(productItem.getPrice_max());
        boolean z3 = !d.a(productItem.getPrice_min());
        boolean z4 = !d.a(productItem.getPrice_before_discount());
        boolean z5 = !d.a(productItem.getPrice_min_before_discount());
        boolean z6 = !d.a(productItem.getPrice_max_before_discount());
        String a2 = a(z ? productItem.getPrice() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a3 = a(z2 ? productItem.getPrice_max() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a4 = a(z3 ? productItem.getPrice_min() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a5 = a(z4 ? productItem.getPrice_before_discount() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a6 = a(z5 ? productItem.getPrice_min_before_discount() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a7 = a(z6 ? productItem.getPrice_max_before_discount() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        final String a8 = v.a();
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a3) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a4) || a3.equals(a4)) {
            str = a8 + v.a(a2);
        } else {
            str = a8 + v.a(a4) + "~" + a8 + v.a(a3);
        }
        final String str3 = str;
        if (!AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a6) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a7) && !a6.equals(a7)) {
            str2 = a8 + v.a(a6) + "~" + a8 + v.a(a7);
        } else if (!AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a5)) {
            str2 = a8 + v.a(a5);
        } else {
            str2 = "";
        }
        String str4 = str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append(str3);
        if (!d.a(str4)) {
            sb.append("~");
        }
        if (str3.indexOf("~") != -1) {
            sb.append("~");
        }
        if (str4.indexOf("~") != -1) {
            sb.append("~");
        }
        setText(sb.toString());
        final String str5 = str4;
        final String str6 = a4;
        final String str7 = a3;
        final String str8 = a6;
        final String str9 = a7;
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                PriceTextView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                String str = str3;
                String str2 = str5;
                if (str.indexOf("~") != -1) {
                    str = a8 + v.a(str6) + " ~ " + a8 + v.a(str7);
                }
                if (str5.indexOf("~") != -1) {
                    str2 = a8 + v.a(str8) + " ~ " + a8 + v.a(str9);
                }
                if (PriceTextView.this.getLineCount() > 1) {
                    int lineEnd = PriceTextView.this.getLayout().getLineEnd(0);
                    int i = lineEnd - 3;
                    if (i <= str.length()) {
                        str = str.subSequence(0, i) + "...";
                        str2 = "";
                    } else if (!d.a(str2)) {
                        int length = lineEnd - str.length();
                        str2 = str2.subSequence(0, length - 3) + "...";
                    }
                }
                if (!d.a(str2)) {
                    SpannableString spannableString = new SpannableString(str2 + SQLBuilder.BLANK + str);
                    spannableString.setSpan(c.f28272d, 0, str2.length(), 33);
                    spannableString.setSpan(c.f28270b, str2.length() + 1, spannableString.length(), 33);
                    PriceTextView.this.setText(spannableString);
                } else {
                    SpannableString spannableString2 = new SpannableString(str);
                    spannableString2.setSpan(c.f28270b, 0, spannableString2.length(), 33);
                    PriceTextView.this.setText(spannableString2);
                }
                return false;
            }
        });
    }

    public void setPriceWithOutIntervalPriceAndSmall(ProductEntity.ProductItem productItem) {
        String str;
        final String str2;
        boolean z = !d.a(productItem.getPrice());
        boolean z2 = !d.a(productItem.getPrice_max());
        boolean z3 = !d.a(productItem.getPrice_min());
        boolean z4 = !d.a(productItem.getPrice_before_discount());
        boolean z5 = !d.a(productItem.getPrice_min_before_discount());
        boolean z6 = !d.a(productItem.getPrice_max_before_discount());
        String a2 = a(z ? productItem.getPrice() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a3 = a(z2 ? productItem.getPrice_max() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a4 = a(z3 ? productItem.getPrice_min() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a5 = a(z4 ? productItem.getPrice_before_discount() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a6 = a(z5 ? productItem.getPrice_min_before_discount() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a7 = a(z6 ? productItem.getPrice_max_before_discount() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        final String a8 = v.a();
        final String str3 = "";
        if (!AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a5)) {
            str = a8 + v.a(a5);
        } else {
            str = str3;
        }
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a3) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a4) || a3.equals(a4)) {
            str2 = a8 + v.a(a2);
            str3 = str;
        } else {
            str2 = a8 + v.a(a4) + "~" + a8 + v.a(a3);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append(str2);
        if (!d.a(str3)) {
            sb.append("~");
        }
        if (str2.indexOf("~") != -1) {
            sb.append("~");
        }
        if (str3.indexOf("~") != -1) {
            sb.append("~");
        }
        setText(sb.toString());
        final String str4 = a4;
        final String str5 = a3;
        final String str6 = a6;
        final String str7 = a7;
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                PriceTextView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                String str = str2;
                String str2 = str3;
                if (str.indexOf("~") != -1) {
                    str = a8 + v.a(str4) + " ~ " + a8 + v.a(str5);
                }
                if (str3.indexOf("~") != -1) {
                    str2 = a8 + v.a(str6) + " ~ " + a8 + v.a(str7);
                }
                if (PriceTextView.this.getLineCount() > 1) {
                    int lineEnd = PriceTextView.this.getLayout().getLineEnd(0);
                    int i = lineEnd - 3;
                    if (i <= str.length()) {
                        str = str.subSequence(0, i) + "...";
                        str2 = "";
                    } else if (!d.a(str2)) {
                        int length = lineEnd - str.length();
                        str2 = str2.subSequence(0, length - 3) + "...";
                    }
                }
                if (!d.a(str2)) {
                    SpannableString spannableString = new SpannableString(str2 + SQLBuilder.BLANK + str);
                    spannableString.setSpan(c.f28272d, 0, str2.length(), 33);
                    spannableString.setSpan(c.f28270b, str2.length() + 1, spannableString.length(), 33);
                    PriceTextView.this.setText(spannableString);
                } else {
                    SpannableString spannableString2 = new SpannableString(str);
                    spannableString2.setSpan(c.f28270b, 0, spannableString2.length(), 33);
                    PriceTextView.this.setText(spannableString2);
                }
                return false;
            }
        });
    }

    private String a(String str) {
        try {
            return Double.parseDouble(str) < 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }
}
