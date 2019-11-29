package com.tencent.qalsdk.sdk;

import com.tencent.qalsdk.util.QLog;

final class d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f32241a;

    d(c cVar) {
        this.f32241a = cVar;
    }

    public final void run() {
        while (true) {
            try {
                r rVar = (r) c.f32231a.c().take();
                if (rVar != null) {
                    try {
                        if (rVar.f32271a == null) {
                            c.f32234d.post(new e(this, rVar));
                        } else if (!this.f32241a.a(rVar.f32271a, rVar.f32272b)) {
                            QLog.e("CoreWrapper", 1, "unknown resp to" + rVar.f32271a + " from:" + rVar.f32272b);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}
