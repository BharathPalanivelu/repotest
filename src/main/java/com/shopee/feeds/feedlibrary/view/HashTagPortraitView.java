package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.m;
import com.squareup.a.e;
import com.squareup.a.w;

public class HashTagPortraitView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CircleImageView f28456a;

    /* renamed from: b  reason: collision with root package name */
    private RobotoTextView f28457b;

    public HashTagPortraitView(Context context) {
        this(context, (AttributeSet) null);
    }

    public HashTagPortraitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HashTagPortraitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = LayoutInflater.from(context).inflate(c.f.feeds_layout_hashtag_portratit, this, true);
        this.f28456a = (CircleImageView) inflate.findViewById(c.e.civ_portrait);
        this.f28457b = (RobotoTextView) inflate.findViewById(c.e.tv_mark);
    }

    public void setImage(final String str) {
        if (!d.a(str)) {
            w.a(getContext()).a(m.a(str, true)).a(c.d.feeds_bg_color_grey_ring).b(c.d.feeds_bg_color_grey_ring).a((ImageView) this.f28456a, (e) new e() {
                public void c() {
                    h.b("%s", "tagdbmod hashtag sus " + m.a(str, true));
                }

                public void d() {
                    h.b("%s", "tagdbmod hashtag err " + m.a(str, false));
                    w.a(HashTagPortraitView.this.getContext()).a(m.a(str, false)).a(c.d.feeds_bg_color_grey_ring).b(c.d.feeds_bg_color_grey_ring).a((ImageView) HashTagPortraitView.this.f28456a);
                }
            });
        } else {
            this.f28456a.setImageResource(c.d.feeds_bg_color_grey_ring);
        }
    }

    public void a() {
        this.f28457b.setVisibility(8);
    }

    public void b() {
        this.f28457b.setVisibility(0);
    }
}
