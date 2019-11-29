package com.c.a.c.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.c.a.i.i;

class v {

    /* renamed from: a  reason: collision with root package name */
    private boolean f5881a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f5882b = new Handler(Looper.getMainLooper(), new a());

    v() {
    }

    public void a(s<?> sVar) {
        i.a();
        if (this.f5881a) {
            this.f5882b.obtainMessage(1, sVar).sendToTarget();
            return;
        }
        this.f5881a = true;
        sVar.e();
        this.f5881a = false;
    }

    private static class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((s) message.obj).e();
            return true;
        }
    }
}
