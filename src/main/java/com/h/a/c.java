package com.h.a;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import com.h.a.c;
import java.util.Hashtable;
import java.util.Map;

public abstract class c<T extends c> {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, e> f6898c = new Hashtable();

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f6899a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f6900b;

    public c(SharedPreferences sharedPreferences) {
        this.f6899a = sharedPreferences;
    }

    /* access modifiers changed from: protected */
    public d a(String str) {
        Object obj = f6898c.get(str);
        if (obj == null) {
            obj = new d(this, this.f6899a, str);
            f6898c.put(str, obj);
        } else if (!(obj instanceof d)) {
            throw new IllegalArgumentException(String.format("key %s is already used for other type", new Object[]{str}));
        }
        return (d) obj;
    }

    /* access modifiers changed from: protected */
    public b b(String str) {
        Object obj = f6898c.get(str);
        if (obj == null) {
            obj = new b(this, this.f6899a, str);
            f6898c.put(str, obj);
        } else if (!(obj instanceof b)) {
            throw new IllegalArgumentException(String.format("key %s is already used for other type", new Object[]{str}));
        }
        return (b) obj;
    }

    /* access modifiers changed from: protected */
    public a c(String str) {
        Object obj = f6898c.get(str);
        if (obj == null) {
            obj = new a(this, this.f6899a, str);
            f6898c.put(str, obj);
        } else if (!(obj instanceof a)) {
            throw new IllegalArgumentException(String.format("key %s is already used for other type", new Object[]{str}));
        }
        return (a) obj;
    }

    public T u() {
        w().clear();
        return this;
    }

    @TargetApi(9)
    public void v() {
        SharedPreferences.Editor editor = this.f6900b;
        if (editor != null) {
            try {
                editor.apply();
            } catch (Exception unused) {
                this.f6900b.commit();
            }
            this.f6900b = null;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized SharedPreferences.Editor w() {
        if (this.f6900b == null) {
            this.f6900b = this.f6899a.edit();
        }
        return this.f6900b;
    }
}
