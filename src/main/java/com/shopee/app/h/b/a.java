package com.shopee.app.h.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.c;
import com.garena.android.appkit.b.d;
import com.garena.android.appkit.b.e;
import com.shopee.app.h.f;
import com.shopee.app.h.l;
import com.shopee.app.h.n;
import com.shopee.app.network.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f17622a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Pair<String, String>> f17623b = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f17624c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public g f17625d;

    /* renamed from: e  reason: collision with root package name */
    private e f17626e = new d() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            n nVar = (n) aVar;
            if (a.this.f17624c.containsKey(nVar.f17683a.a())) {
                if (((c) aVar.data).a()) {
                    a.this.f17624c.remove(nVar.f17683a.a());
                    if (!a.this.b() && a.this.f17624c.isEmpty()) {
                        b.a("file_b_upload", (com.garena.android.appkit.b.a) new n(a.this.f17625d.a(), new c(0)), b.a.NETWORK_BUS);
                        return;
                    }
                    return;
                }
                b.a("file_b_upload", (com.garena.android.appkit.b.a) new n(a.this.f17625d.a(), new c(3)), b.a.NETWORK_BUS);
            }
        }
    };

    public static a a() {
        if (f17622a == null) {
            f17622a = new a();
        }
        return f17622a;
    }

    private a() {
        b.a("file_upload", this.f17626e, b.a.NETWORK_BUS);
    }

    public boolean a(String str, byte[] bArr) {
        try {
            l.a().a(f.a().a(str), bArr, bArr.length);
            return true;
        } catch (IOException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return false;
        }
    }

    public boolean a(String str) {
        return f.a().e(f.a().b(str));
    }

    public boolean b(String str, byte[] bArr) {
        try {
            l.a().a(f.a().b(str), bArr, bArr.length);
            return true;
        } catch (IOException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return false;
        }
    }

    public void a(Set<String> set, g gVar) {
        this.f17625d = gVar;
        this.f17623b.clear();
        this.f17624c.clear();
        for (String next : set) {
            this.f17623b.add(new Pair(next, f.a().b(next)));
        }
        b();
    }

    /* access modifiers changed from: private */
    public boolean b() {
        if (this.f17623b.isEmpty()) {
            return false;
        }
        try {
            Pair remove = this.f17623b.remove(0);
            g gVar = new g();
            this.f17624c.put(gVar.a(), remove.first);
            byte[] a2 = com.shopee.app.h.a.b.c().a((String) remove.second);
            if (a2 == null) {
                com.garena.android.appkit.d.a.a("incorrect file path %s", remove.second);
            }
            com.garena.android.appkit.d.a.e("check next uploading:" + ((String) remove.first), new Object[0]);
            com.shopee.app.h.a.c.a().a((String) remove.first, a2, gVar.a(), new com.shopee.app.network.b(a2.length));
        } catch (IOException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
        return true;
    }

    public String a(byte[] bArr) {
        String a2 = com.shopee.app.g.c.a(bArr);
        try {
            l.a().a(f.a().b(a2), bArr, bArr.length);
            return a2;
        } catch (IOException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    /* renamed from: com.shopee.app.h.b.a$a  reason: collision with other inner class name */
    class C0261a extends com.shopee.app.h.a.d {

        /* renamed from: a  reason: collision with root package name */
        final String f17632a;

        /* renamed from: b  reason: collision with root package name */
        final String f17633b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f17634c;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public Runnable f17636e;

        public C0261a(String str, String str2, Runnable runnable, boolean z) {
            super(str);
            this.f17636e = runnable;
            this.f17632a = str;
            this.f17633b = str2;
            this.f17634c = z;
        }

        public void onError(int i) {
            super.onError(i);
            if (i == 16) {
                com.garena.android.appkit.d.a.e("image cannot be found", new Object[0]);
            }
            com.garena.android.appkit.d.a.a("download avatar :%s error:%d", this.f17633b, Integer.valueOf(i));
        }

        public void onFinish(byte[] bArr, int i) {
            if (this.f17634c) {
                a.this.a(this.f17632a, bArr);
            } else {
                a.this.b(this.f17632a, bArr);
            }
            if (this.f17636e != null) {
                com.garena.android.appkit.f.f.a().a(new Runnable() {
                    public void run() {
                        C0261a.this.f17636e.run();
                    }
                });
            }
        }
    }

    public Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public void a(String str, String str2, Runnable runnable, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            com.shopee.app.h.a.a.a().a(str2, (com.beetalklib.a.a.b) new C0261a(str, str2, runnable, z));
        }
    }

    public void a(String str, String str2, Runnable runnable) {
        com.shopee.app.h.a.a.a().a(str, str2, new C0261a(str2, str2, runnable, false));
    }
}
