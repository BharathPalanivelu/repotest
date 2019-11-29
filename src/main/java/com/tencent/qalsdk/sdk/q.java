package com.tencent.qalsdk.sdk;

import android.os.Process;
import android.util.Log;
import com.garena.android.gpns.utility.CONSTANT;

final class q extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ p f32270a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q(p pVar, String str) {
        super(str);
        this.f32270a = pVar;
    }

    public final void run() {
        if (m.f32260a && this.f32270a.f32269a.u.compareAndSet(false, true)) {
            try {
                String unused = this.f32270a.f32269a.r = MsfSdkUtils.getProcessName(this.f32270a.f32269a.A);
                Process.myPid();
                Log.d("appMemory", "QLog init retry ");
                this.f32270a.f32269a.b(System.currentTimeMillis());
                this.f32270a.f32269a.f32263c.setName("logWriteThread");
                this.f32270a.f32269a.f32263c.start();
                this.f32270a.f32269a.z.removeCallbacks(this.f32270a.f32269a.f32265e);
                this.f32270a.f32269a.f32264d.start();
            } catch (Exception e2) {
                this.f32270a.f32269a.u.set(false);
                e2.printStackTrace();
                int i = this.f32270a.f32269a.y.get();
                Log.d("appMemory", "QLog init post retry " + i + " times, interval " + this.f32270a.f32269a.h[i]);
                this.f32270a.f32269a.z.removeCallbacks(this.f32270a.f32269a.f32265e);
                this.f32270a.f32269a.z.postDelayed(this.f32270a.f32269a.f32265e, (long) (this.f32270a.f32269a.h[i] * CONSTANT.TIME.MIN_1));
                int i2 = i + 1;
                if (i2 >= this.f32270a.f32269a.h.length) {
                    i2 = 0;
                }
                this.f32270a.f32269a.y.set(i2);
            }
        }
    }
}
