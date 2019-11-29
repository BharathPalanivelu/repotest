package com.shopee.scanner;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.util.d;
import java.util.ArrayList;
import java.util.List;

abstract class e {

    /* renamed from: a  reason: collision with root package name */
    protected final Handler f30326a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            try {
                d dVar = (d) message.obj;
                e.this.f30327b.a((List) dVar.f1882a, (List) dVar.f1883b);
            } catch (RuntimeException e2) {
                g.a.a.a((Throwable) e2);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f30327b;

    interface a {
        void a(List<String> list, List<String> list2);
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public abstract void a(Context context);

    e(a aVar) {
        this.f30327b = aVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(List<a> list) {
        g.a.a.a("AirPay-Scanner").b("Received detections: %s", list.toString());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a next : list) {
            int a2 = next.a();
            if (a2 == 1) {
                arrayList2.add(next.b());
            } else if (a2 == 2) {
                arrayList.add(next.b());
            }
        }
        Message obtainMessage = this.f30326a.obtainMessage();
        obtainMessage.obj = new d(arrayList, arrayList2);
        obtainMessage.sendToTarget();
    }
}
