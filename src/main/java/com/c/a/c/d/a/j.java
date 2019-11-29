package com.c.a.c.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.c.a.c;
import com.c.a.c.b.a.e;
import com.c.a.c.b.s;
import com.c.a.c.m;
import java.security.MessageDigest;

public class j implements m<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private final m<Bitmap> f6020b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6021c;

    public m<BitmapDrawable> a() {
        return this;
    }

    public j(m<Bitmap> mVar, boolean z) {
        this.f6020b = mVar;
        this.f6021c = z;
    }

    public s<Drawable> a(Context context, s<Drawable> sVar, int i, int i2) {
        e a2 = c.a(context).a();
        Drawable c2 = sVar.c();
        s<Bitmap> a3 = i.a(a2, c2, i, i2);
        if (a3 != null) {
            s<T> a4 = this.f6020b.a(context, a3, i, i2);
            if (!a4.equals(a3)) {
                return a(context, (Bitmap) a4.c());
            }
            a4.e();
            return sVar;
        } else if (!this.f6021c) {
            return sVar;
        } else {
            throw new IllegalArgumentException("Unable to convert " + c2 + " to a Bitmap");
        }
    }

    private s<Drawable> a(Context context, Bitmap bitmap) {
        return l.a(context, bitmap);
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f6020b.equals(((j) obj).f6020b);
        }
        return false;
    }

    public int hashCode() {
        return this.f6020b.hashCode();
    }

    public void a(MessageDigest messageDigest) {
        this.f6020b.a(messageDigest);
    }
}
