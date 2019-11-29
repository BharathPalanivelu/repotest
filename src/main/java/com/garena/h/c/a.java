package com.garena.h.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.garena.h.e;

public class a extends Handler implements com.garena.h.a {

    /* renamed from: a  reason: collision with root package name */
    private com.garena.h.a f8021a;

    public a(Looper looper, com.garena.h.a aVar) {
        super(looper);
        this.f8021a = aVar;
    }

    public void a() {
        obtainMessage(2, (Object) null).sendToTarget();
    }

    public void a(e eVar) {
        obtainMessage(3, eVar).sendToTarget();
    }

    public void b() {
        obtainMessage(4).sendToTarget();
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 2) {
            this.f8021a.a();
        } else if (i == 3) {
            this.f8021a.a((e) message.obj);
        } else if (i == 4) {
            this.f8021a.b();
        }
    }
}
