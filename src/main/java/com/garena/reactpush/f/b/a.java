package com.garena.reactpush.f.b;

import com.garena.reactpush.c.b;
import com.garena.reactpush.data.AssetDiff;
import com.garena.reactpush.data.ReactAsset;
import com.garena.reactpush.f.f.b;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f8469a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8470b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.garena.reactpush.f.f.a f8471c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final b f8472d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f8473e;

    public a(OkHttpClient okHttpClient, String str, com.garena.reactpush.f.f.a aVar, b bVar, Map<String, String> map) {
        this.f8469a = okHttpClient;
        this.f8470b = str;
        this.f8471c = aVar;
        this.f8472d = bVar;
        this.f8473e = map;
    }

    public void a(List<AssetDiff> list, String str) {
        int size = list == null ? 0 : list.size();
        final AtomicInteger atomicInteger = new AtomicInteger();
        final AtomicInteger atomicInteger2 = new AtomicInteger(size);
        final CountDownLatch countDownLatch = new CountDownLatch(size);
        if (list != null) {
            for (AssetDiff next : list) {
                final CountDownLatch countDownLatch2 = countDownLatch;
                final AssetDiff assetDiff = next;
                final AtomicInteger atomicInteger3 = atomicInteger;
                final AtomicInteger atomicInteger4 = atomicInteger2;
                a(next, str, next.getKey(), this.f8473e.get(next.getKey()), new b.a() {
                    public void a(Call call, Exception exc) {
                        countDownLatch2.countDown();
                    }

                    public void a(File file) {
                        if (a.this.f8471c.a(assetDiff)) {
                            atomicInteger3.incrementAndGet();
                            atomicInteger4.decrementAndGet();
                        }
                        countDownLatch2.countDown();
                    }
                });
            }
        }
        new Thread() {
            public void run() {
                try {
                    countDownLatch.await();
                    a.this.f8472d.a(atomicInteger.get(), atomicInteger2.get());
                } catch (InterruptedException unused) {
                    a.this.f8472d.a(atomicInteger.get(), atomicInteger2.get());
                }
            }
        }.start();
    }

    private void a(AssetDiff assetDiff, String str, String str2, String str3, b.a aVar) {
        ReactAsset reactAsset = (ReactAsset) assetDiff.getAsset().f1883b;
        if (reactAsset == null) {
            new File(this.f8470b.concat(str3).concat(((ReactAsset) assetDiff.getAsset().f1882a).getPath())).delete();
            aVar.a((File) null);
            return;
        }
        new com.garena.reactpush.c.b(this.f8469a, this.f8470b.concat(str3).concat(reactAsset.getPath()), str.concat(str3).concat(reactAsset.getDownloadPath(str2)), aVar).a();
    }
}
