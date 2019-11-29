package com.airbnb.lottie.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.g;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f3497a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Context f3498b;

    /* renamed from: c  reason: collision with root package name */
    private String f3499c;

    /* renamed from: d  reason: collision with root package name */
    private com.airbnb.lottie.b f3500d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, g> f3501e;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, g> map) {
        this.f3499c = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f3499c;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.f3499c += IOUtils.DIR_SEPARATOR_UNIX;
            }
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f3501e = new HashMap();
            this.f3498b = null;
            return;
        }
        this.f3498b = ((View) callback).getContext();
        this.f3501e = map;
        a(bVar);
    }

    public void a(com.airbnb.lottie.b bVar) {
        this.f3500d = bVar;
    }

    public Bitmap a(String str) {
        g gVar = this.f3501e.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap c2 = gVar.c();
        if (c2 != null) {
            return c2;
        }
        com.airbnb.lottie.b bVar = this.f3500d;
        if (bVar != null) {
            Bitmap a2 = bVar.a(gVar);
            if (a2 != null) {
                a(str, a2);
            }
            return a2;
        }
        String b2 = gVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!b2.startsWith("data:") || b2.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f3499c)) {
                    AssetManager assets = this.f3498b.getAssets();
                    return a(str, BitmapFactory.decodeStream(assets.open(this.f3499c + b2), (Rect) null, options));
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException e2) {
                Log.w("LOTTIE", "Unable to open asset.", e2);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(b2.substring(b2.indexOf(44) + 1), 0);
                return a(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e3) {
                Log.w("LOTTIE", "data URL did not have correct base64 format.", e3);
                return null;
            }
        }
    }

    public void a() {
        synchronized (f3497a) {
            for (Map.Entry<String, g> value : this.f3501e.entrySet()) {
                g gVar = (g) value.getValue();
                Bitmap c2 = gVar.c();
                if (c2 != null) {
                    c2.recycle();
                    gVar.a((Bitmap) null);
                }
            }
        }
    }

    public boolean a(Context context) {
        return (context == null && this.f3498b == null) || this.f3498b.equals(context);
    }

    private Bitmap a(String str, Bitmap bitmap) {
        synchronized (f3497a) {
            this.f3501e.get(str).a(bitmap);
        }
        return bitmap;
    }
}
