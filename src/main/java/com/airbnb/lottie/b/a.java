package com.airbnb.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.c.h;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final h<String> f3491a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<h<String>, Typeface> f3492b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Typeface> f3493c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f3494d;

    /* renamed from: e  reason: collision with root package name */
    private com.airbnb.lottie.a f3495e;

    /* renamed from: f  reason: collision with root package name */
    private String f3496f = ".ttf";

    public a(Drawable.Callback callback, com.airbnb.lottie.a aVar) {
        this.f3495e = aVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f3494d = null;
            return;
        }
        this.f3494d = ((View) callback).getContext().getAssets();
    }

    public void a(com.airbnb.lottie.a aVar) {
        this.f3495e = aVar;
    }

    public Typeface a(String str, String str2) {
        this.f3491a.a(str, str2);
        Typeface typeface = this.f3492b.get(this.f3491a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a2 = a(a(str), str2);
        this.f3492b.put(this.f3491a, a2);
        return a2;
    }

    private Typeface a(String str) {
        Typeface typeface = this.f3493c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = null;
        com.airbnb.lottie.a aVar = this.f3495e;
        if (aVar != null) {
            typeface2 = aVar.a(str);
        }
        com.airbnb.lottie.a aVar2 = this.f3495e;
        if (aVar2 != null && typeface2 == null) {
            String b2 = aVar2.b(str);
            if (b2 != null) {
                typeface2 = Typeface.createFromAsset(this.f3494d, b2);
            }
        }
        if (typeface2 == null) {
            typeface2 = Typeface.createFromAsset(this.f3494d, "fonts/" + str + this.f3496f);
        }
        this.f3493c.put(str, typeface2);
        return typeface2;
    }

    private Typeface a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }
}
