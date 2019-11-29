package com.shopee.feeds.feedlibrary.editor.sticker;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.b.c;
import com.squareup.a.e;
import com.squareup.a.w;

public class b extends c {
    private ImageView i;
    /* access modifiers changed from: private */
    public a j;

    public interface a {
        void a();
    }

    public b(Context context) {
        this(context, (AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.i = (ImageView) LayoutInflater.from(context).inflate(c.f.feeds_layout_photo_editor_sticker_image_item_view, this, true).findViewById(c.e.iv_image);
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(1.0f);
        }
    }

    public void setInfo(com.shopee.feeds.feedlibrary.editor.b.b bVar) {
        super.setInfo(bVar);
        w.a(getContext()).a(com.shopee.feeds.feedlibrary.data.c.b.b(((com.shopee.feeds.feedlibrary.editor.sticker.a.c) bVar).m())).a(c.d.feeds_ic_placeholder).a(this.i, (e) new e() {
            public void c() {
            }

            public void d() {
                if (b.this.j != null) {
                    b.this.j.a();
                }
            }
        });
    }

    public b a(a aVar) {
        this.j = aVar;
        return this;
    }

    public b a(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        this.i.setLayoutParams(layoutParams);
        return this;
    }
}
