package com.shopee.feeds.feedlibrary.editor.sticker;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.b.b;
import com.shopee.feeds.feedlibrary.editor.sticker.a.e;
import com.shopee.feeds.feedlibrary.view.GradientTextView;

public class c extends com.shopee.feeds.feedlibrary.editor.b.c {
    private GradientTextView i;

    public c(Context context) {
        this(context, (AttributeSet) null);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.i = (GradientTextView) LayoutInflater.from(context).inflate(c.f.feeds_layout_photo_editor_sticker_mention_item_view, this, true).findViewById(c.e.tv_username);
        this.i.a(c.b.feeds_comment_voucher_sticker_text_gradient_start, c.b.feeds_comment_voucher_sticker_text_gradient_end);
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(1.5f);
        }
    }

    public void setInfo(b bVar) {
        super.setInfo(bVar);
        this.i.setText(((e) bVar).m());
    }
}
