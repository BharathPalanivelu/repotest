package com.shopee.app.ui.image.editor.c.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.imageeditor.a.c.n;

public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f22903a;

    /* renamed from: b  reason: collision with root package name */
    TextView f22904b;

    /* renamed from: c  reason: collision with root package name */
    private n f22905c;

    public a(Context context) {
        super(context);
    }

    public void setPreset(n nVar) {
        this.f22905c = nVar;
    }

    public void setText(String str) {
        this.f22904b.setText(str);
    }

    public void setIconBitmap(Bitmap bitmap) {
        this.f22903a.setImageBitmap(bitmap);
    }

    public n getPreset() {
        return this.f22905c;
    }

    public void setEnabled(boolean z) {
        if (z) {
            this.f22903a.setColorFilter(0);
        } else {
            this.f22903a.setColorFilter(-7829368, PorterDuff.Mode.DARKEN);
        }
        super.setEnabled(z);
    }
}
