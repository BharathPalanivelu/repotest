package com.shopee.a;

import android.text.TextUtils;
import com.shopee.a.c.c;
import com.shopee.shopeetracker.utils.Logger;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f15742a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, c> f15743b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private String f15744c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f15745d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f15746e = "first";

    public static b a() {
        if (f15742a == null) {
            synchronized (b.class) {
                if (f15742a == null) {
                    f15742a = new b();
                }
            }
        }
        return f15742a;
    }

    public void a(String str, c cVar) {
        if (cVar != null && !TextUtils.isEmpty(str)) {
            try {
                this.f15743b.put(str, cVar);
            } catch (Exception e2) {
                Logger.debug("add PageInfo error " + e2.getMessage());
            }
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f15743b.remove(str);
            } catch (Exception e2) {
                Logger.debug("remove PageInfo error " + e2.getMessage());
            }
        }
    }

    public c b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return this.f15743b.get(str);
        } catch (Exception e2) {
            Logger.debug("remove PageInfo error " + e2.getMessage());
            return null;
        }
    }

    public String b() {
        return this.f15744c;
    }

    public void c(String str) {
        this.f15744c = str;
    }

    public String c() {
        return this.f15745d;
    }

    public void d(String str) {
        this.f15745d = str;
    }

    public String d() {
        return this.f15746e;
    }

    public void e(String str) {
        this.f15746e = str;
    }
}
