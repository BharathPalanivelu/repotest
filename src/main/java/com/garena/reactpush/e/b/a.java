package com.garena.reactpush.e.b;

import com.garena.reactpush.c.b;
import com.garena.reactpush.c.h;
import com.garena.reactpush.data.ReactAsset;
import com.garena.reactpush.data.ReactBundle;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f8371a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8372b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8373c;

    public a(OkHttpClient okHttpClient, String str, String str2) {
        this.f8371a = okHttpClient;
        this.f8373c = str;
        this.f8372b = str2;
    }

    public void a(final ReactBundle reactBundle, final b bVar) {
        new h(this.f8371a, this.f8372b.concat(reactBundle.getName()).concat(".zip"), this.f8372b, reactBundle.getZipUrl(this.f8373c), new b.a() {
            public void a(Call call, Exception exc) {
                bVar.a(call, exc);
            }

            public void a(File file) {
                bVar.a(reactBundle, file);
                bVar.a(true);
            }
        }).a();
    }

    public void a(ReactBundle reactBundle, ReactBundle reactBundle2, String str, CountDownLatch countDownLatch, b bVar, AtomicBoolean atomicBoolean) {
        final AtomicBoolean atomicBoolean2 = atomicBoolean;
        final b bVar2 = bVar;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final ReactBundle reactBundle3 = reactBundle;
        final ReactBundle reactBundle4 = reactBundle2;
        new b(this.f8371a, this.f8372b.concat(reactBundle2.getName()).concat(str).concat(".bundle"), reactBundle2.getUrl(), new b.a() {
            public void a(Call call, Exception exc) {
                atomicBoolean2.set(false);
                bVar2.a(call, exc);
                countDownLatch2.countDown();
            }

            public void a(File file) {
                bVar2.a(reactBundle3, reactBundle4, file);
                atomicBoolean2.set(true);
                countDownLatch2.countDown();
            }
        }).a();
    }

    public void a(ReactBundle reactBundle, ReactBundle reactBundle2, String str, String str2, ReactAsset reactAsset, String str3, CountDownLatch countDownLatch, b bVar) {
        String str4 = str3;
        final String str5 = str2;
        final ReactAsset reactAsset2 = reactAsset;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final b bVar2 = bVar;
        final ReactBundle reactBundle3 = reactBundle;
        final ReactBundle reactBundle4 = reactBundle2;
        new b(this.f8371a, this.f8372b.concat(str4).concat(reactAsset.getPath()), str.concat(str4).concat(reactAsset2.getDownloadPath(str5)), new b.a() {
            public void a(Call call, Exception exc) {
                countDownLatch2.countDown();
            }

            public void a(File file) {
                b bVar = bVar2;
                ReactBundle reactBundle = reactBundle3;
                if (reactBundle == null) {
                    reactBundle = reactBundle4;
                }
                bVar.a(reactBundle, str5, reactAsset2, file);
                countDownLatch2.countDown();
            }
        }).a();
    }

    public void a(ReactBundle reactBundle, ReactBundle reactBundle2, String str, String str2, ReactAsset reactAsset, ReactAsset reactAsset2, String str3, CountDownLatch countDownLatch, b bVar) {
        String str4 = str3;
        final String str5 = str2;
        final ReactAsset reactAsset3 = reactAsset2;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final b bVar2 = bVar;
        final ReactBundle reactBundle3 = reactBundle;
        final ReactBundle reactBundle4 = reactBundle2;
        final ReactAsset reactAsset4 = reactAsset;
        new b(this.f8371a, this.f8372b.concat(str4).concat(reactAsset2.getPath()), str.concat(str4).concat(reactAsset3.getDownloadPath(str5)), new b.a() {
            public void a(Call call, Exception exc) {
                countDownLatch2.countDown();
            }

            public void a(File file) {
                b bVar = bVar2;
                ReactBundle reactBundle = reactBundle3;
                if (reactBundle == null) {
                    reactBundle = reactBundle4;
                }
                bVar.a(reactBundle, str5, reactAsset4, reactAsset3, file);
                countDownLatch2.countDown();
            }
        }).a();
    }
}
