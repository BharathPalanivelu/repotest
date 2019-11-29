package com.shopee.e.a;

import android.content.Context;
import android.util.Log;
import com.f.a.e;
import com.f.a.f;
import com.f.a.g;
import com.f.a.i;
import com.f.a.k;

public class c implements b {
    public c(Context context) {
        boolean a2 = a(context);
        i.a((f) new a(a2, k.a().a(false).a(0).b(7).a("SZ").a()));
        i.a((f) new b(a2, com.f.a.b.a().a("SZ").a((g) new d(context)).a()));
    }

    private boolean a(Context context) {
        boolean z;
        boolean endsWith = context.getPackageName().endsWith(".int");
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                z = true;
                if (endsWith && !z) {
                    return false;
                }
            }
        } catch (Exception e2) {
            Log.e("OrhanbutStrategy", "checkLoggable: ", e2);
        }
        z = false;
        return endsWith ? true : true;
    }

    private static class b extends com.f.a.c {

        /* renamed from: a  reason: collision with root package name */
        private boolean f27142a = false;

        public b(boolean z, e eVar) {
            super(eVar);
            this.f27142a = z;
        }

        public boolean a(int i, String str) {
            return this.f27142a;
        }
    }

    private static class a extends com.f.a.a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f27141a = false;

        public a(boolean z, e eVar) {
            super(eVar);
            this.f27141a = z;
        }

        public boolean a(int i, String str) {
            return this.f27141a;
        }
    }

    public void a(String str, Object... objArr) {
        i.a(str, objArr);
    }

    public void a(Object obj) {
        i.a(obj);
    }

    public void b(String str, Object... objArr) {
        i.b(str, objArr);
    }

    public void a(Throwable th, String str, Object... objArr) {
        i.a(th, str, objArr);
    }

    public void c(String str, Object... objArr) {
        i.c(str, objArr);
    }

    public void d(String str, Object... objArr) {
        i.d(str, objArr);
    }
}
