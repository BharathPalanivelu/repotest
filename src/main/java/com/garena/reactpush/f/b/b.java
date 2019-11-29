package com.garena.reactpush.f.b;

import com.garena.reactpush.c.b;
import com.garena.reactpush.data.BundleDiff;
import com.garena.reactpush.data.ReactBundle;
import com.garena.reactpush.f.d.c;
import java.io.File;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f8483a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8484b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c f8485c;

    public b(OkHttpClient okHttpClient, String str, c cVar) {
        this.f8483a = okHttpClient;
        this.f8484b = str;
        this.f8485c = cVar;
    }

    public void a(List<BundleDiff> list) {
        final int size = list == null ? 0 : list.size();
        final CountDownLatch countDownLatch = new CountDownLatch(size);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final AtomicReference atomicReference = new AtomicReference();
        if (list != null) {
            for (BundleDiff a2 : list) {
                a(a2, new b.a() {
                    public void a(Call call, Exception exc) {
                        atomicBoolean.set(false);
                        atomicReference.set(exc);
                        countDownLatch.countDown();
                    }

                    public void a(File file) {
                        countDownLatch.countDown();
                    }
                });
            }
        }
        new Thread() {
            public void run() {
                try {
                    countDownLatch.await();
                    if (atomicBoolean.get()) {
                        b.this.f8485c.a(size != 0);
                    } else {
                        b.this.f8485c.a((Exception) atomicReference.get());
                    }
                } catch (InterruptedException unused) {
                    b.this.f8485c.a((Exception) atomicReference.get());
                }
            }
        }.start();
    }

    private void a(BundleDiff bundleDiff, b.a aVar) {
        ReactBundle reactBundle = (ReactBundle) bundleDiff.getBundle().f1883b;
        if (reactBundle == null) {
            aVar.a((File) null);
            return;
        }
        new com.garena.reactpush.c.b(this.f8483a, this.f8484b.concat(reactBundle.getName()).concat(".bundle"), reactBundle.getUrl(), aVar).a();
    }
}
