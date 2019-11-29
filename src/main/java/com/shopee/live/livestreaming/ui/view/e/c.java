package com.shopee.live.livestreaming.ui.view.e;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.live.livestreaming.a.f;
import com.shopee.live.livestreaming.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.util.ab;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.p;
import com.squareup.a.w;

public class c extends f {

    /* renamed from: b  reason: collision with root package name */
    RelativeLayout f29319b = ((RelativeLayout) a(c.e.rl_bottom_product_item));

    /* renamed from: c  reason: collision with root package name */
    TextView f29320c = ((TextView) a(c.e.tv_show));

    /* renamed from: d  reason: collision with root package name */
    TextView f29321d = ((TextView) a(c.e.tv_showing));

    /* renamed from: e  reason: collision with root package name */
    ImageView f29322e = ((ImageView) a(c.e.iv_add_cart));

    /* renamed from: f  reason: collision with root package name */
    ProgressBar f29323f = ((ProgressBar) a(c.e.loading_progress));

    /* renamed from: g  reason: collision with root package name */
    private ImageView f29324g = ((ImageView) a(c.e.iv_bottom_product_item));
    private TextView h = ((TextView) a(c.e.tv_product_sort));
    private TextView i = ((TextView) a(c.e.tv_product_sort_second));
    private TextView j = ((TextView) a(c.e.tv_product_name));
    /* access modifiers changed from: private */
    public TextView k = ((TextView) a(c.e.tv_money_discount));
    /* access modifiers changed from: private */
    public TextView l = ((TextView) a(c.e.tv_money_without_discount));

    static View b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(c.f.live_streaming_layout_bottom_product_item, viewGroup, false);
    }

    c(View view) {
        super(view);
    }

    public void a(int i2, SessionProductEntity.ProductItem productItem) {
        if (i2 < 99) {
            this.h.setVisibility(0);
            this.i.setVisibility(8);
            this.h.setText(String.valueOf(i2 + 1));
        } else {
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            this.i.setText(String.valueOf(i2 + 1));
        }
        if (!d.a(productItem.getImage())) {
            w.a(b.b().c()).a(p.a(productItem.getImage())).a(c.d.live_streaming_ic_list_product_default).b(c.d.live_streaming_ic_list_product_default).a(this.f29324g);
        } else {
            this.f29324g.setImageResource(c.d.live_streaming_ic_list_product_default);
        }
        this.j.setText(productItem.getName());
        a(productItem);
    }

    private void a(SessionProductEntity.ProductItem productItem) {
        String a2 = ab.a();
        final AnonymousClass1 r4 = new CharacterStyle() {
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(com.garena.android.appkit.tools.b.a(c.b.main_color));
                textPaint.setTextSize((float) com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_price_txt_size));
            }
        };
        final AnonymousClass2 r5 = new CharacterStyle() {
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(com.garena.android.appkit.tools.b.a(c.b.color_txt_price_before_discount));
                textPaint.setTextSize((float) com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_price_before_txt_size));
                textPaint.setFlags(16);
                textPaint.setAntiAlias(true);
            }
        };
        boolean z = !d.a(productItem.getPrice());
        boolean z2 = !d.a(productItem.getPrice_max());
        boolean z3 = !d.a(productItem.getPrice_min());
        boolean z4 = !d.a(productItem.getPrice_before_discount());
        String a3 = a(z ? productItem.getPrice() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a4 = a(z2 ? productItem.getPrice_max() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a5 = a(z3 ? productItem.getPrice_min() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String a6 = a(z4 ? productItem.getPrice_before_discount() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a4) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a5) || (z2 && a4.equals(a5))) {
            final String str = a2 + ab.a(a3);
            String str2 = a2 + ab.a(a6);
            if (!z4 || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(a6) || productItem.getPrice_before_discount().equals(a3)) {
                b();
                this.l.setText(str);
                return;
            }
            a();
            this.k.setText(str + str2);
            final String str3 = str2;
            this.k.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    c.this.k.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (c.this.k.getLineCount() > 1) {
                        int lineEnd = c.this.k.getLayout().getLineEnd(0);
                        String str = c.this.k.getText().subSequence(0, lineEnd - 3) + "...";
                        if (str.length() - 3 > str.length()) {
                            SpannableString spannableString = new SpannableString(str + SQLBuilder.BLANK + str.substring(str.length(), str.length()));
                            spannableString.setSpan(r4, 0, str.length(), 33);
                            spannableString.setSpan(r5, str.length() + 1, str.length() + -2, 33);
                            c.this.k.setText(spannableString);
                        } else {
                            SpannableString spannableString2 = new SpannableString(str);
                            c.this.b();
                            spannableString2.setSpan(r4, 0, str.length(), 33);
                            c.this.l.setText(spannableString2);
                        }
                    } else {
                        SpannableString spannableString3 = new SpannableString(str + SQLBuilder.BLANK + str3);
                        spannableString3.setSpan(r4, 0, str.length(), 33);
                        spannableString3.setSpan(r5, str.length() + 1, spannableString3.length(), 33);
                        c.this.k.setText(spannableString3);
                    }
                    return false;
                }
            });
        } else if (z2 && z3) {
            StringBuilder sb = new StringBuilder();
            b();
            SpannableString spannableString = new SpannableString(a2 + ab.a(a5));
            spannableString.setSpan(r4, 0, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(a2 + ab.a(a4));
            spannableString2.setSpan(r4, 0, spannableString2.length(), 33);
            SpannableString spannableString3 = new SpannableString(" ~ ");
            spannableString3.setSpan(r4, 0, spannableString3.length(), 33);
            sb.append(spannableString);
            sb.append(spannableString3);
            sb.append(spannableString2);
            this.l.setText(sb.toString());
        }
    }

    private void a() {
        this.k.setVisibility(0);
        this.l.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void b() {
        this.k.setVisibility(8);
        this.l.setVisibility(0);
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
