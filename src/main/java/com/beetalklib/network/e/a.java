package com.beetalklib.network.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.beetalklib.network.d.b;
import com.beetalklib.network.d.f;

public class a extends Handler implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.beetalklib.network.d.a f5533a;

    public a(Looper looper, com.beetalklib.network.d.a aVar) {
        super(looper);
        this.f5533a = aVar;
    }

    public void a() {
        obtainMessage(2, (Object) null).sendToTarget();
    }

    public void a(f fVar) {
        obtainMessage(3, fVar).sendToTarget();
    }

    public void b() {
        obtainMessage(4).sendToTarget();
    }

    public void a(long j) {
        Message message = new Message();
        message.what = 5;
        sendMessageDelayed(message, j);
        com.beetalklib.network.c.a.b("resume request submit at %d", Long.valueOf(SystemClock.currentThreadTimeMillis()));
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 2) {
            this.f5533a.a();
        } else if (i == 3) {
            this.f5533a.a((f) message.obj);
        } else if (i == 4) {
            this.f5533a.b();
        } else if (i == 5) {
            com.beetalklib.network.c.a.b("resume request exec at %d", Long.valueOf(SystemClock.currentThreadTimeMillis()));
            this.f5533a.a();
        }
    }
}
