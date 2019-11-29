package com.tencent.qalsdk.service;

import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.config.a;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.sdk.r;
import com.tencent.qalsdk.util.QLog;

public final class g extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private static String f32315a = "MSF.S.RespHandler";

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f32316b = true;

    /* renamed from: c  reason: collision with root package name */
    private j f32317c;

    public g(j jVar) {
        this.f32317c = jVar;
    }

    public final void run() {
        while (this.f32316b) {
            try {
                r take = this.f32317c.e().take();
                if (take != null) {
                    if (take.f32271a != null) {
                        String d2 = a.d(take.f32271a);
                        String str = f32315a;
                        QLog.d(str, "service getMsfMessagePairs resp:" + take.f32271a.getServiceCmd() + ":" + take.f32271a.getRequestSsoSeq() + ":" + take.f32271a.getAppSeq());
                        c.a(d2, take.f32271a, take.f32272b);
                    } else if (take.f32272b != null) {
                        FromServiceMsg fromServiceMsg = take.f32272b;
                        c.a(fromServiceMsg.getAttributes().get("to_SenderProcessName") != null ? (String) fromServiceMsg.getAttributes().get("to_SenderProcessName") : "", take.f32271a, take.f32272b);
                    }
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }
}
