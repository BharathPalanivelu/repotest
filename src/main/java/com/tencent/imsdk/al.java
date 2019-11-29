package com.tencent.imsdk;

import android.os.Process;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.Set;

final class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ArrayList f30701a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMCoreNotify f30702b;

    al(IMCoreNotify iMCoreNotify, ArrayList arrayList) {
        this.f30702b = iMCoreNotify;
        this.f30701a = arrayList;
    }

    public final void run() {
        Set<TIMMessageUpdateListener> messageUpdateListeners = TIMManager.getInstanceById(this.f30702b.identifer).getMessageUpdateListeners();
        QLog.d("IMCoreNotify", 1, "msg update listeners size: " + messageUpdateListeners.size() + "|msg size: " + this.f30701a.size() + "|pid:" + Process.myPid());
        if (!messageUpdateListeners.isEmpty()) {
            Object[] array = messageUpdateListeners.toArray();
            int i = 0;
            while (i < array.length) {
                TIMMessageUpdateListener tIMMessageUpdateListener = (TIMMessageUpdateListener) array[i];
                if (tIMMessageUpdateListener == null || !tIMMessageUpdateListener.onMessagesUpdate(this.f30701a)) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
