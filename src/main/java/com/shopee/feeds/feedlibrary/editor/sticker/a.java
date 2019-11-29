package com.shopee.feeds.feedlibrary.editor.sticker;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.f.f;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.c.b;
import com.shopee.feeds.feedlibrary.editor.b.c;
import com.shopee.feeds.feedlibrary.util.l;
import com.shopee.feeds.feedlibrary.view.widget.StarRatingBar;

public class a extends c {
    private TextView i;
    private StarRatingBar j;
    private TextView k;
    private int l;

    public a(Context context) {
        this(context, (AttributeSet) null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = 3;
        View inflate = LayoutInflater.from(context).inflate(c.f.feeds_layout_photo_editor_sticker_buyer_item_view, this, true);
        this.i = (TextView) inflate.findViewById(c.e.buyer_name);
        this.j = (StarRatingBar) inflate.findViewById(c.e.ratings_bar);
        this.k = (TextView) inflate.findViewById(c.e.comment);
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(2.2f);
        }
        setVisibility(4);
    }

    public void b() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.addRule(11, -1);
        layoutParams.addRule(12, -1);
        layoutParams.rightMargin = l.a(8, getContext());
        layoutParams.bottomMargin = l.a(65, getContext());
        setLayoutParams(layoutParams);
    }

    private boolean c() {
        return "id".equals(b.f());
    }

    public void setInfo(com.shopee.feeds.feedlibrary.editor.b.b bVar) {
        super.setInfo(bVar);
        com.shopee.feeds.feedlibrary.editor.sticker.a.a aVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.a) bVar;
        this.i.setText(aVar.n());
        this.j.setRatings(aVar.o());
        this.k.setText(aVar.p());
        if (!c()) {
            f.a().a(new Runnable() {
                public void run() {
                }
            });
        }
    }
}
