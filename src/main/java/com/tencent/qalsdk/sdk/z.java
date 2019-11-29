package com.tencent.qalsdk.sdk;

import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.util.QLog;

final class z extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ x f32296a;

    z(x xVar) {
        this.f32296a = xVar;
    }

    public final void run() {
        while (!x.f32287b.isEmpty()) {
            ToServiceMsg poll = x.f32287b.poll();
            if (poll != null) {
                try {
                    this.f32296a.a(poll);
                } catch (Exception e2) {
                    FromServiceMsg a2 = x.a(poll, poll.getServiceName() + "sendMsgToServiceFailed，" + e2.toString());
                    StringBuilder sb = new StringBuilder("sendMsgToServiceFailed ");
                    sb.append(poll.getServiceCmd());
                    QLog.i("MSF.D.RemoteServiceProxy", sb.toString());
                    this.f32296a.b(poll, a2);
                }
            }
        }
    }
}
