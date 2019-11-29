package com.beetalklib.network.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class d extends Handler implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f5518a;

    public d(Looper looper, c cVar) {
        super(looper);
        this.f5518a = cVar;
    }

    public void a(int i, int i2) {
        obtainMessage(2, i, i2).sendToTarget();
    }

    public void a(f fVar) {
        obtainMessage(1, fVar).sendToTarget();
    }

    public void b(f fVar) {
        obtainMessage(0, fVar).sendToTarget();
    }

    public void a(int i) {
        obtainMessage(3, Integer.valueOf(i)).sendToTarget();
    }

    public void b(int i) {
        obtainMessage(4, Integer.valueOf(i)).sendToTarget();
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.f5518a.a(message.arg1, message.arg2);
                } else if (i == 3) {
                    this.f5518a.a(message.arg1);
                } else if (i == 4) {
                    this.f5518a.b(message.arg1);
                }
            } else if (message.obj != null) {
                this.f5518a.a((f) message.obj);
            }
        } else if (message.obj != null) {
            this.f5518a.b((f) message.obj);
        }
    }
}
