package com.shopee.app.ui.setting.cell;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;

public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f25201a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25202b;

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setBackgroundResource(R.drawable.bottom_border_white_background_highlight);
    }

    public void a(boolean z) {
        if (z) {
            this.f25201a.setVisibility(0);
        } else {
            this.f25201a.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        if (z) {
            this.f25201a.setImageResource(R.drawable.com_garena_shopee_ic_done);
        } else {
            this.f25201a.setImageBitmap((Bitmap) null);
        }
    }

    public void setText(String str) {
        this.f25202b.setText(str);
    }
}
