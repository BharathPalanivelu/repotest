package com.shopee.app.react.sync;

import android.os.AsyncTask;
import com.firebase.jobdispatcher.r;
import com.firebase.jobdispatcher.s;
import com.garena.reactpush.d.e;
import com.shopee.app.react.g;
import java.lang.ref.WeakReference;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BundleSyncService extends s {

    /* renamed from: a  reason: collision with root package name */
    private a f19007a;

    public boolean a(r rVar) {
        com.garena.android.appkit.d.a.b("BundleSyncService Start", new Object[0]);
        this.f19007a = new a(this, rVar);
        this.f19007a.execute(new Void[0]);
        return true;
    }

    public boolean b(r rVar) {
        a aVar = this.f19007a;
        if (aVar != null) {
            aVar.cancel(true);
        }
        return true;
    }

    private static class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<BundleSyncService> f19008a;

        /* renamed from: b  reason: collision with root package name */
        private final r f19009b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public BlockingQueue<Integer> f19010c = new ArrayBlockingQueue(3);

        a(BundleSyncService bundleSyncService, r rVar) {
            this.f19008a = new WeakReference<>(bundleSyncService);
            this.f19009b = rVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                g.a().a((e) new e() {
                    public void a(boolean z) {
                        a.this.f19010c.add(1);
                    }

                    public void a(Exception exc) {
                        a.this.f19010c.add(0);
                    }
                });
            } catch (Throwable unused) {
                this.f19010c.add(2);
            }
            try {
                this.f19010c.take().intValue();
                return null;
            } catch (InterruptedException unused2) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            BundleSyncService bundleSyncService = (BundleSyncService) this.f19008a.get();
            if (bundleSyncService != null) {
                bundleSyncService.b(this.f19009b, false);
            }
        }
    }
}
