package com.shopee.app.react.view.bigimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.shopee.app.react.view.bigimage.RNBigImageViewManager;
import com.shopee.id.R;
import com.squareup.a.aa;
import com.squareup.a.r;
import com.squareup.a.w;

public class a extends AppCompatImageView {
    public a(Context context) {
        super(context);
    }

    public void setSource(String str) {
        if (TextUtils.isEmpty(str)) {
            a();
        } else {
            w.a(getContext()).a(str).a().a((ImageView) this);
        }
    }

    public void setSource(RNBigImageViewManager.a aVar) {
        if (TextUtils.isEmpty(aVar.a())) {
            a();
            return;
        }
        aa a2 = w.a(getContext()).a(aVar.a());
        if (aVar.c() <= 0 || aVar.b() <= 0) {
            int width = getWidth();
            int height = getHeight();
            if (width > 0 && height > 0) {
                a2.b(width, height).f();
                if ("centerInside".equals(aVar.e())) {
                    a2.e();
                } else if ("centerCrop".equals(aVar.e())) {
                    a2.d();
                }
            }
        } else {
            a2.b(aVar.b(), aVar.c()).f();
            if ("centerInside".equals(aVar.e())) {
                a2.e();
            } else if ("centerCrop".equals(aVar.e())) {
                a2.d();
            }
        }
        if (aVar.g()) {
            a2.a(Bitmap.Config.RGB_565);
        }
        if (aVar.d()) {
            a2.a(r.NO_CACHE, r.NO_STORE);
        }
        if (aVar.f()) {
            a2.g();
        }
        a2.a((ImageView) this);
    }

    private void a() {
        w.a(getContext()).a((int) R.drawable.sp_transparent).a((ImageView) this);
    }
}
