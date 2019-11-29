package com.tencent.timint;

import com.tencent.imsdk.log.QLog;
import java.util.Map;

final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TIMIntManager f32498a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f32499b;

    ad(TIMIntManager tIMIntManager, String str) {
        this.f32498a = tIMIntManager;
        this.f32499b = str;
    }

    public final void run() {
        Map<String, byte[]> a2 = this.f32498a.dbhelper.a();
        if (a2 == null) {
            QLog.d("MSF.C.TIMIntManager", 1, "failed to get map from db");
            return;
        }
        for (Map.Entry next : a2.entrySet()) {
            int parseInt = Integer.parseInt((String) next.getKey());
            this.f32498a.request(this.f32499b, (byte[]) next.getValue(), new ae(this, parseInt));
        }
    }
}
