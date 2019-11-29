package com.shopee.feeds.feedlibrary.editor.text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.c;

public class a extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f28085a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f28086b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0432a f28087c;

    /* renamed from: com.shopee.feeds.feedlibrary.editor.text.a$a  reason: collision with other inner class name */
    public interface C0432a {
        void a(int i);
    }

    public a(Context context) {
        this(context, (AttributeSet) null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28086b = (ImageView) LayoutInflater.from(context).inflate(c.f.feeds_layout_photo_editor_color_picker_item, this, true).findViewById(c.e.iv_color);
        this.f28086b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (a.this.f28087c != null) {
                    a.this.f28087c.a(a.this.f28085a);
                }
            }
        });
    }

    public void setColorId(int i) {
        this.f28085a = i;
        this.f28086b.setColorFilter(b.a(i));
    }

    public void setColorPickListener(C0432a aVar) {
        this.f28087c = aVar;
    }
}
