package com.shopee.livequiz.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.b;
import com.shopee.livequiz.c;
import com.shopee.livequiz.g.e;
import com.squareup.a.af;
import com.squareup.a.w;

public class ImageCheckButton extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f29978a;

    /* renamed from: b  reason: collision with root package name */
    private a f29979b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f29980c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f29981d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f29982e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f29983f;

    public interface a {
        void a(boolean z);
    }

    public ImageCheckButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public ImageCheckButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageCheckButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29978a = true;
        View inflate = LayoutInflater.from(context).inflate(c.f.livesdk_shopee_layout_image_check_button, this);
        this.f29982e = (ImageView) inflate.findViewById(c.d.iv_check_state_on);
        this.f29983f = (ImageView) inflate.findViewById(c.d.iv_check_state_off);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageCheckButton imageCheckButton = ImageCheckButton.this;
                imageCheckButton.setChecked(!imageCheckButton.a());
            }
        });
    }

    public void a(String str, String str2) {
        this.f29980c = str;
        this.f29981d = str2;
        b();
    }

    public boolean a() {
        return this.f29978a;
    }

    public void setChecked(boolean z) {
        if (this.f29978a != z) {
            this.f29978a = z;
            a aVar = this.f29979b;
            if (aVar != null) {
                aVar.a(z);
            }
            b();
        }
    }

    public void setCheckListener(a aVar) {
        this.f29979b = aVar;
    }

    private void b() {
        int i = 0;
        this.f29982e.setVisibility(a() ? 0 : 8);
        ImageView imageView = this.f29983f;
        if (a()) {
            i = 8;
        }
        imageView.setVisibility(i);
        this.f29983f.setAdjustViewBounds(true);
        this.f29982e.setAdjustViewBounds(true);
        f.a().a(new Runnable() {
            public void run() {
                ImageCheckButton imageCheckButton = ImageCheckButton.this;
                imageCheckButton.a(imageCheckButton.f29982e, ImageCheckButton.this.f29980c);
                ImageCheckButton imageCheckButton2 = ImageCheckButton.this;
                imageCheckButton2.a(imageCheckButton2.f29983f, ImageCheckButton.this.f29981d);
            }
        }, 100);
        a(this.f29982e, this.f29980c);
        a(this.f29983f, this.f29981d);
    }

    /* access modifiers changed from: private */
    public void a(final ImageView imageView, String str) {
        String c2 = e.a().c(str);
        if (!TextUtils.isEmpty(c2)) {
            w.a(getContext()).a(c2).a((af) new af() {
                public void a(Drawable drawable) {
                }

                public void b(Drawable drawable) {
                }

                public void a(Bitmap bitmap, w.d dVar) {
                    if (bitmap != null) {
                        int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
                        int max2 = Math.max(Math.min(max, b.d(c.b.livequiz_header_icon_max_size)), b.d(c.b.livequiz_header_icon_min_size));
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                        layoutParams.width = max2;
                        layoutParams.height = max2;
                        imageView.setLayoutParams(layoutParams);
                        imageView.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }
}
