package com.airpay.paysdk.base.ui.weidget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airpay.paysdk.base.bean.BPProductDetail;
import com.airpay.paysdk.base.bean.BPThirdPartyOrderDetail;
import com.airpay.paysdk.base.bean.CollectionQrShop;
import com.airpay.paysdk.base.d.m;
import com.airpay.paysdk.c;
import com.airpay.paysdk.pay.b;
import com.litesuits.orm.db.assit.SQLBuilder;

public class k extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f3955a = ((ImageView) findViewById(c.f.com_garena_beepay_img_product_icon));

    /* renamed from: b  reason: collision with root package name */
    private TextView f3956b = ((TextView) findViewById(c.f.com_garena_beepay_txt_product_name));

    /* renamed from: c  reason: collision with root package name */
    private TextView f3957c = ((TextView) findViewById(c.f.tv_shop_name));

    /* renamed from: d  reason: collision with root package name */
    private TextView f3958d = ((TextView) findViewById(c.f.com_garena_beepay_txt_product_payable));

    /* renamed from: e  reason: collision with root package name */
    private long f3959e;

    /* renamed from: f  reason: collision with root package name */
    private String f3960f;

    /* renamed from: g  reason: collision with root package name */
    private BPProductDetail f3961g;
    private BPThirdPartyOrderDetail h;

    public k(Context context) {
        super(context);
        inflate(context, c.h.com_garena_beepay_item_payment_option_order_details, this);
    }

    public void a(BPProductDetail bPProductDetail, BPThirdPartyOrderDetail bPThirdPartyOrderDetail, long j, String str, boolean z) {
        this.f3961g = bPProductDetail;
        this.h = bPThirdPartyOrderDetail;
        this.f3959e = j;
        this.f3960f = str;
        a();
    }

    @SuppressLint({"SetTextI18n"})
    public void a() {
        this.f3958d.setText(b.b((double) this.f3959e), TextView.BufferType.SPANNABLE);
        BPThirdPartyOrderDetail bPThirdPartyOrderDetail = this.h;
        if (bPThirdPartyOrderDetail != null) {
            CollectionQrShop shop = bPThirdPartyOrderDetail.getShop();
            if (shop != null) {
                this.f3957c.setVisibility(0);
                this.f3957c.setText(shop.getShopName());
                this.f3956b.setText(shop.getOwnerName());
                m.a(this.f3955a, shop.getShopIcon(), c.d.icon_collection_qr_shop_default);
                return;
            }
        }
        m.a(this.f3955a, this.f3961g.productImageUrl, this.f3961g.iconBackup);
        if (this.f3961g.productName instanceof String) {
            this.f3956b.setText(this.f3961g.productName);
        } else {
            this.f3956b.setText(this.f3961g.productName, TextView.BufferType.SPANNABLE);
        }
        if (this.f3961g.hasSeparateComponents) {
            TextView textView = this.f3956b;
            textView.setText(this.f3961g.productNameWithExtraLeft + SQLBuilder.BLANK + this.f3961g.productNameWithExtraMiddle + SQLBuilder.BLANK + this.f3961g.productNameWithExtraRight);
            return;
        }
        this.f3956b.setText(this.f3961g.productNameWithExtra);
    }
}
