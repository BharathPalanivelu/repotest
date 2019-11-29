package com.garena.h.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.garena.h.e;

public class d extends Handler implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f8030a;

    public d(Looper looper, c cVar) {
        super(looper);
        this.f8030a = cVar;
    }

    public void a(e eVar) {
        obtainMessage(0, eVar).sendToTarget();
    }

    public void a(String str) {
        obtainMessage(1, str).sendToTarget();
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i == 1 && message.obj != null) {
                this.f8030a.a((String) message.obj);
            }
        } else if (message.obj != null) {
            this.f8030a.a((e) message.obj);
        }
    }
}
