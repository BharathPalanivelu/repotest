package com.garena.android.appkit.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.DaoManager;
import java.util.HashMap;
import java.util.Locale;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected a f6685a;

    /* renamed from: b  reason: collision with root package name */
    private int f6686b = -1;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, a> f6687c;

    /* access modifiers changed from: protected */
    public abstract a a(String str, b bVar);

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public abstract int c();

    /* access modifiers changed from: protected */
    public abstract void d();

    public HashMap<String, a> b() {
        return this.f6687c;
    }

    protected b() {
        f();
    }

    private void f() {
        int c2 = c();
        if (c2 >= 0 && this.f6686b != c2) {
            this.f6686b = c2;
            Locale locale = Locale.ENGLISH;
            this.f6685a = a(String.format(locale, a() + "%d.db", new Object[]{Integer.valueOf(this.f6686b)}), this);
            g();
            this.f6685a.a();
        }
    }

    private void g() {
        this.f6687c = new HashMap<>();
        d();
    }

    public void a(String str, a aVar) {
        this.f6687c.put(str, aVar);
    }

    public void e() {
        this.f6686b = -1;
        if (this.f6685a != null) {
            for (a d2 : this.f6687c.values()) {
                d2.d();
            }
            this.f6687c.clear();
            this.f6685a.close();
            DaoManager.clearCache();
            DaoManager.clearDaoCache();
        }
    }
}
