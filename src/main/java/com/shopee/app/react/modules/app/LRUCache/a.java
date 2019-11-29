package com.shopee.app.react.modules.app.LRUCache;

import android.content.Context;
import android.text.TextUtils;
import com.jakewharton.a.a;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import d.d.b.j;
import d.h.m;
import d.p;
import io.b.q;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public com.jakewharton.a.a f18705a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f18706b;

    /* renamed from: com.shopee.app.react.modules.app.LRUCache.a$a  reason: collision with other inner class name */
    static final class C0279a<V> implements Callable<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18707a;

        C0279a(a aVar) {
            this.f18707a = aVar;
        }

        public /* synthetic */ Object call() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.f18707a.a().a();
        }
    }

    static final class c<V> implements Callable<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18710a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18711b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18712c;

        c(a aVar, String str, String str2) {
            this.f18710a = aVar;
            this.f18711b = str;
            this.f18712c = str2;
        }

        public /* synthetic */ Object call() {
            return Boolean.valueOf(a());
        }

        public final boolean a() {
            a.C0242a b2 = this.f18710a.a().b(this.f18710a.c(this.f18711b));
            b2.a(0, this.f18712c);
            b2.a();
            return true;
        }
    }

    static final class d<V> implements Callable<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18713a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18714b;

        d(a aVar, String str) {
            this.f18713a = aVar;
            this.f18714b = str;
        }

        public /* synthetic */ Object call() {
            return Boolean.valueOf(a());
        }

        public final boolean a() {
            String c2 = this.f18713a.c(this.f18714b);
            if (TextUtils.isEmpty(c2)) {
                return false;
            }
            return this.f18713a.a().c(c2);
        }
    }

    public a(Context context) {
        j.b(context, "context");
        this.f18706b = context;
        try {
            com.jakewharton.a.a a2 = com.jakewharton.a.a.a(this.f18706b.getDir("LRUCacheModule", 0), 1, 1, 10485760);
            j.a((Object) a2, "DiskLruCache.open(dir, 1, 1, CACHE_MAX_SIZE)");
            this.f18705a = a2;
        } catch (Exception unused) {
        }
    }

    public final com.jakewharton.a.a a() {
        com.jakewharton.a.a aVar = this.f18705a;
        if (aVar == null) {
            j.b("cache");
        }
        return aVar;
    }

    public final io.b.b a(String str, String str2) {
        j.b(str, "key");
        j.b(str2, "data");
        io.b.b a2 = io.b.b.a((Callable<?>) new c(this, str, str2));
        j.a((Object) a2, "Completable.fromCallable…           true\n        }");
        return a2;
    }

    static final class b<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18708a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18709b;

        b(a aVar, String str) {
            this.f18708a = aVar;
            this.f18709b = str;
        }

        /* renamed from: a */
        public final String call() {
            return this.f18708a.a().a(this.f18708a.c(this.f18709b)).b(0);
        }
    }

    public final q<String> a(String str) {
        j.b(str, "key");
        q<String> a2 = q.a(new b(this, str));
        j.a((Object) a2, "Single.fromCallable {\n  …ing(CACHE_INDEX)\n       }");
        return a2;
    }

    public final io.b.b b(String str) {
        j.b(str, "key");
        io.b.b a2 = io.b.b.a((Callable<?>) new d(this, str));
        j.a((Object) a2, "Completable.fromCallable…che.remove(md5)\n        }");
        return a2;
    }

    public final io.b.b b() {
        io.b.b a2 = io.b.b.a((Callable<?>) new C0279a(this));
        j.a((Object) a2, "Completable.fromCallable… cache.delete()\n        }");
        return a2;
    }

    public final String c(String str) {
        j.b(str, "$this$md5");
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            byte[] bytes = str.getBytes(d.h.d.f32688a);
            j.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            String bigInteger = new BigInteger(1, instance.digest(bytes)).toString(16);
            j.a((Object) bigInteger, "BigInteger(1, md.digest(…yteArray())).toString(16)");
            return m.a(bigInteger, 32, '0');
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return "";
        }
    }
}
