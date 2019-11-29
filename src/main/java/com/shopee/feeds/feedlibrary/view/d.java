package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.l;

public class d extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f28570a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f28571b;

    /* renamed from: c  reason: collision with root package name */
    private RobotoTextView f28572c;

    public d(Context context) {
        this(context, (AttributeSet) null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        View inflate = LayoutInflater.from(context).inflate(c.f.feeds_layout_water_mark, this, true);
        this.f28570a = (LinearLayout) inflate.findViewById(c.e.water_mark_layout);
        this.f28571b = (ImageView) inflate.findViewById(c.e.water_mark_img);
        this.f28572c = (RobotoTextView) inflate.findViewById(c.e.user_name);
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f28572c.setText(str);
        this.f28572c.setShadowLayer(4.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, Color.parseColor("#80000000"));
    }

    public void a(boolean z, long j, long j2) {
        h.b("", "ShopeeWaterMarkView is " + z + " w=," + j + " h=," + j2);
        if (z) {
            LinearLayout linearLayout = this.f28570a;
            linearLayout.setPadding(linearLayout.getPaddingLeft(), this.f28570a.getPaddingTop(), l.a(3, b.b().c()), l.a(14, b.b().c()));
            ImageView imageView = this.f28571b;
            imageView.setPadding(imageView.getPaddingLeft(), this.f28571b.getPaddingTop(), this.f28571b.getPaddingRight(), l.a(3, b.b().c()));
            RobotoTextView robotoTextView = this.f28572c;
            robotoTextView.setPadding(robotoTextView.getPaddingLeft(), this.f28572c.getPaddingTop(), this.f28572c.getPaddingRight(), l.a(1, b.b().c()));
        } else if (j.a().w()) {
            LinearLayout linearLayout2 = this.f28570a;
            linearLayout2.setPadding(linearLayout2.getPaddingLeft(), this.f28570a.getPaddingTop(), this.f28570a.getPaddingRight(), l.a(19, b.b().c()));
            LinearLayout linearLayout3 = this.f28570a;
            linearLayout3.setPadding(linearLayout3.getPaddingLeft(), this.f28570a.getPaddingTop(), l.a(3, b.b().c()), l.a(15, b.b().c()));
            ImageView imageView2 = this.f28571b;
            imageView2.setPadding(imageView2.getPaddingLeft(), this.f28571b.getPaddingTop(), this.f28571b.getPaddingRight(), l.a(4, b.b().c()));
        } else if (j > j2) {
            LinearLayout linearLayout4 = this.f28570a;
            linearLayout4.setPadding(linearLayout4.getPaddingLeft(), this.f28570a.getPaddingTop(), l.a(3, b.b().c()), l.a(13, b.b().c()));
            ImageView imageView3 = this.f28571b;
            imageView3.setPadding(imageView3.getPaddingLeft(), this.f28571b.getPaddingTop(), this.f28571b.getPaddingRight(), l.a(3, b.b().c()));
            RobotoTextView robotoTextView2 = this.f28572c;
            robotoTextView2.setPadding(robotoTextView2.getPaddingLeft(), this.f28572c.getPaddingTop(), this.f28572c.getPaddingRight(), l.a(3, b.b().c()));
        } else if (j == j2) {
            LinearLayout linearLayout5 = this.f28570a;
            linearLayout5.setPadding(linearLayout5.getPaddingLeft(), this.f28570a.getPaddingTop(), l.a(3, b.b().c()), l.a(13, b.b().c()));
            ImageView imageView4 = this.f28571b;
            imageView4.setPadding(imageView4.getPaddingLeft(), this.f28571b.getPaddingTop(), this.f28571b.getPaddingRight(), l.a(3, b.b().c()));
            RobotoTextView robotoTextView3 = this.f28572c;
            robotoTextView3.setPadding(robotoTextView3.getPaddingLeft(), this.f28572c.getPaddingTop(), this.f28572c.getPaddingRight(), l.a(3, b.b().c()));
        } else {
            LinearLayout linearLayout6 = this.f28570a;
            linearLayout6.setPadding(linearLayout6.getPaddingLeft(), this.f28570a.getPaddingTop(), l.a(1, b.b().c()), l.a(13, b.b().c()));
            ImageView imageView5 = this.f28571b;
            imageView5.setPadding(imageView5.getPaddingLeft(), this.f28571b.getPaddingTop(), this.f28571b.getPaddingRight(), l.a(4, b.b().c()));
            RobotoTextView robotoTextView4 = this.f28572c;
            robotoTextView4.setPadding(robotoTextView4.getPaddingLeft(), this.f28572c.getPaddingTop(), this.f28572c.getPaddingRight(), l.a(3, b.b().c()));
        }
    }
}
