package com.garena.reactpush.e.b;

import com.garena.reactpush.data.AssetDiff;
import com.garena.reactpush.data.BundleDiff;
import com.garena.reactpush.data.ReactAsset;
import com.garena.reactpush.data.ReactBundle;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private a f8397a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f8398b;

    public c(OkHttpClient okHttpClient, String str, String str2, Map<String, String> map) {
        this.f8397a = new a(okHttpClient, str, str2);
        this.f8398b = map;
    }

    public void a(List<BundleDiff> list, b bVar) {
        if (list.isEmpty()) {
            bVar.a(false);
            return;
        }
        for (BundleDiff next : list) {
            if (next.isBundleNew()) {
                this.f8397a.a((ReactBundle) next.getBundle().f1883b, bVar);
            } else {
                a(next, bVar);
            }
        }
    }

    private void a(BundleDiff bundleDiff, b bVar) {
        int i = bundleDiff.hasJSChanged() ? 1 : 0;
        final int size = bundleDiff.getAssetList() != null ? bundleDiff.getAssetList().size() + 0 : 0;
        if (i + size > 0) {
            CountDownLatch countDownLatch = new CountDownLatch(i);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final CountDownLatch countDownLatch2 = countDownLatch;
            final AtomicBoolean atomicBoolean2 = atomicBoolean;
            final BundleDiff bundleDiff2 = bundleDiff;
            final b bVar2 = bVar;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        countDownLatch2.await();
                        if (atomicBoolean2.get()) {
                            c.this.a(bundleDiff2, size, bVar2);
                        }
                    } catch (InterruptedException e2) {
                        bVar2.a((Call) null, (Exception) e2);
                    }
                }
            }).start();
            if (bundleDiff.hasJSChanged()) {
                this.f8397a.a((ReactBundle) bundleDiff.getBundle().f1882a, (ReactBundle) bundleDiff.getBundle().f1883b, "", countDownLatch, bVar, atomicBoolean);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(BundleDiff bundleDiff, int i, final b bVar) {
        final CountDownLatch countDownLatch = new CountDownLatch(i);
        new Thread(new Runnable() {
            public void run() {
                try {
                    countDownLatch.await();
                    bVar.a(true);
                } catch (InterruptedException e2) {
                    bVar.a((Call) null, (Exception) e2);
                }
            }
        }).start();
        if (bundleDiff.getAssetList() != null) {
            for (AssetDiff next : bundleDiff.getAssetList()) {
                if (next.isAssetNew()) {
                    this.f8397a.a((ReactBundle) bundleDiff.getBundle().f1882a, (ReactBundle) bundleDiff.getBundle().f1883b, ((ReactBundle) bundleDiff.getBundle().f1883b).getAssetBaseURL(), next.getKey(), (ReactAsset) next.getAsset().f1883b, this.f8398b.get(next.getKey()), countDownLatch, bVar);
                } else {
                    this.f8397a.a((ReactBundle) bundleDiff.getBundle().f1882a, (ReactBundle) bundleDiff.getBundle().f1883b, ((ReactBundle) bundleDiff.getBundle().f1883b).getAssetBaseURL(), next.getKey(), (ReactAsset) next.getAsset().f1882a, (ReactAsset) next.getAsset().f1883b, this.f8398b.get(next.getKey()), countDownLatch, bVar);
                }
            }
        }
    }
}
