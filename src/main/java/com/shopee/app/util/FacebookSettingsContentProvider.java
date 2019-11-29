package com.shopee.app.util;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.FacebookSdk;
import com.facebook.share.internal.ShareConstants;
import d.d.b.j;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class FacebookSettingsContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26112a = new a((g) null);

    /* renamed from: b  reason: collision with root package name */
    private static final int f26113b = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    private static final int f26114c = Math.max(2, Math.min(f26113b - 1, 4));

    /* renamed from: d  reason: collision with root package name */
    private static final int f26115d = ((f26113b * 2) + 1);

    /* renamed from: e  reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f26116e = new LinkedBlockingQueue<>(128);

    /* renamed from: f  reason: collision with root package name */
    private static final b f26117f = new b();

    /* renamed from: g  reason: collision with root package name */
    private static final p f26118g = new p(f26114c, f26115d, 30, TimeUnit.SECONDS, f26116e, f26117f);

    public int delete(Uri uri, String str, String[] strArr) {
        j.b(uri, ShareConstants.MEDIA_URI);
        return 0;
    }

    public String getType(Uri uri) {
        j.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        j.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        j.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        j.b(uri, ShareConstants.MEDIA_URI);
        return 0;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        f26118g.allowCoreThreadTimeOut(true);
    }

    public static final class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f26119a = new AtomicInteger(1);

        b() {
        }

        public Thread newThread(Runnable runnable) {
            j.b(runnable, "r");
            return new Thread(runnable, "FB-AsyncTask #" + this.f26119a.getAndIncrement());
        }
    }

    public boolean onCreate() {
        com.google.android.play.core.missingsplits.a a2 = com.google.android.play.core.missingsplits.b.a(getContext());
        j.a((Object) a2, "MissingSplitsManagerFactory.create(context)");
        if (a2.b()) {
            return false;
        }
        FacebookSdk.setExecutor(f26118g);
        return true;
    }
}
