package com.shopee.feeds.feedlibrary.editor.text;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.b.b;
import com.shopee.feeds.feedlibrary.editor.b.c;
import com.shopee.feeds.feedlibrary.view.CustomTextView;

public class d extends c {
    private CustomTextView i;

    public d(Context context) {
        this(context, (AttributeSet) null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            this.i = (CustomTextView) layoutInflater.inflate(c.f.feeds_layout_photo_editor_text_item_view, this, true).findViewById(c.e.tv_text);
            if (Build.VERSION.SDK_INT >= 21) {
                setTranslationZ(1.0f);
            }
        }
    }

    public void setInfo(b bVar) {
        super.setInfo(bVar);
        b bVar2 = (b) bVar;
        int n = bVar2.n();
        int o = bVar2.o();
        this.i.setText(bVar2.m());
        this.i.setTextSize(2, 28.0f);
        if (bVar2.p()) {
            a(n, o);
        } else {
            setTextColor(n);
        }
        this.i.setTextSize(2, (float) bVar2.q());
    }

    private void a(int i2, int i3) {
        this.i.setTextColor(com.garena.android.appkit.tools.b.a(i2));
        this.i.setTextBackgroundColor(com.garena.android.appkit.tools.b.a(i3));
    }

    private void setTextColor(int i2) {
        this.i.setText(this.i.getText().toString());
        this.i.setTextColor(com.garena.android.appkit.tools.b.a(i2));
        this.i.setTextBackgroundColor(com.garena.android.appkit.tools.b.g(c.b.transparent));
    }
}
