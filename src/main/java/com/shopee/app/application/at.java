package com.shopee.app.application;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.shopee.app.h.r;
import d.d.b.j;
import io.b.d.f;
import io.b.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class at {

    /* renamed from: a  reason: collision with root package name */
    public static final at f15865a = new at();

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f15866b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f15867c = new Object();

    private at() {
    }

    public final void a(Context context) {
        j.b(context, "context");
        WeakReference weakReference = new WeakReference(context);
        f15865a.a(weakReference, new String[]{"dodt@seagroup.com", "kharea@seagroup.com", "hoangnh@seagroup.com"}).b(io.b.h.a.b()).a(io.b.a.b.a.a()).b(new b(weakReference)).a((f<? super Throwable>) c.f15871a).a();
    }

    static final class b<T> implements f<Intent> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WeakReference f15870a;

        b(WeakReference weakReference) {
            this.f15870a = weakReference;
        }

        /* renamed from: a */
        public final void accept(Intent intent) {
            Context context = (Context) this.f15870a.get();
            if (context != null) {
                context.startActivity(intent);
            }
        }
    }

    static final class c<T> implements f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f15871a = new c();

        c() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            r.a().a(th.getMessage());
        }
    }

    static final class a<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WeakReference f15868a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String[] f15869b;

        a(WeakReference weakReference, String[] strArr) {
            this.f15868a = weakReference;
            this.f15869b = strArr;
        }

        /* renamed from: a */
        public final Intent call() {
            String a2 = at.f15865a.a();
            Object obj = this.f15868a.get();
            if (obj == null) {
                j.a();
            }
            j.a(obj, "contextRef.get()!!");
            Uri b2 = com.shopee.app.ui.sharing.base.helper.c.b((Context) obj, a2);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.SUBJECT", "[indonesia-release] Report OkHttpClient traffic");
            intent.putExtra("android.intent.extra.STREAM", b2);
            intent.putExtra("android.intent.extra.EMAIL", this.f15869b);
            return intent;
        }
    }

    private final g<Intent> a(WeakReference<Context> weakReference, String[] strArr) {
        g<Intent> a2 = g.a(new a(weakReference, strArr));
        j.a((Object) a2, "Maybe.fromCallable {\n   …eceivers)\n        }\n    }");
        return a2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0081, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a() {
        /*
            r6 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            com.shopee.app.h.f r1 = com.shopee.app.h.f.a()
            java.lang.String r2 = "BBPathManager.getInstance()"
            d.d.b.j.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.f()
            r0.append(r1)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            java.lang.String r1 = "okhttp_traffic.csv"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "StringBuffer()\n         …)\n            .toString()"
            d.d.b.j.a((java.lang.Object) r0, (java.lang.String) r1)
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x007d }
            r1.<init>(r0)     // Catch:{ IOException -> 0x007d }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x007d }
            r3 = 0
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x007d }
            java.lang.Object r1 = f15867c     // Catch:{ IOException -> 0x007d }
            monitor-enter(r1)     // Catch:{ IOException -> 0x007d }
            java.lang.String r3 = "Source,URL,Start timestamp,Duration (ms),Exception\n"
            java.nio.charset.Charset r4 = d.h.d.f32688a     // Catch:{ all -> 0x007a }
            byte[] r3 = r3.getBytes(r4)     // Catch:{ all -> 0x007a }
            java.lang.String r4 = "(this as java.lang.String).getBytes(charset)"
            d.d.b.j.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ all -> 0x007a }
            r2.write(r3)     // Catch:{ all -> 0x007a }
            java.util.List<java.lang.String> r3 = f15866b     // Catch:{ all -> 0x007a }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ all -> 0x007a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x007a }
        L_0x004e:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x007a }
            if (r4 == 0) goto L_0x0073
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x007a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x007a }
            java.nio.charset.Charset r5 = d.h.d.f32688a     // Catch:{ all -> 0x007a }
            if (r4 == 0) goto L_0x006b
            byte[] r4 = r4.getBytes(r5)     // Catch:{ all -> 0x007a }
            java.lang.String r5 = "(this as java.lang.String).getBytes(charset)"
            d.d.b.j.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ all -> 0x007a }
            r2.write(r4)     // Catch:{ all -> 0x007a }
            goto L_0x004e
        L_0x006b:
            d.m r0 = new d.m     // Catch:{ all -> 0x007a }
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r2)     // Catch:{ all -> 0x007a }
            throw r0     // Catch:{ all -> 0x007a }
        L_0x0073:
            r2.close()     // Catch:{ all -> 0x007a }
            d.p r2 = d.p.f32714a     // Catch:{ all -> 0x007a }
            monitor-exit(r1)     // Catch:{ IOException -> 0x007d }
            return r0
        L_0x007a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ IOException -> 0x007d }
            throw r0     // Catch:{ IOException -> 0x007d }
        L_0x007d:
            r0 = move-exception
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            goto L_0x0082
        L_0x0081:
            throw r0
        L_0x0082:
            goto L_0x0081
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.application.at.a():java.lang.String");
    }
}
