package com.tencent.imsdk;

import android.os.Process;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

final class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ArrayList f30699a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMCoreNotify f30700b;

    ak(IMCoreNotify iMCoreNotify, ArrayList arrayList) {
        this.f30700b = iMCoreNotify;
        this.f30699a = arrayList;
    }

    public final void run() {
        Set<TIMMessageListener> messageListeners = TIMManager.getInstanceById(this.f30700b.identifer).getMessageListeners();
        QLog.i("IMCoreNotify", 1, "listeners size: " + messageListeners.size() + "|msg size: " + this.f30699a.size() + "|pid:" + Process.myPid());
        if (messageListeners.size() == 0) {
            QLog.i("IMCoreNotify", 1, "RecvMsg|4-Callback|Fail|user not set onNewMessage cb");
        } else {
            Object[] array = messageListeners.toArray();
            for (Object obj : array) {
                TIMMessageListener tIMMessageListener = (TIMMessageListener) obj;
                if (tIMMessageListener != null && tIMMessageListener.onNewMessages(this.f30699a)) {
                    break;
                }
            }
            Iterator it = this.f30699a.iterator();
            while (it.hasNext()) {
                TIMMessage tIMMessage = (TIMMessage) it.next();
                QLog.i("IMCoreNotify", 1, "RecvMsg|4-Callback|Succ|type=" + tIMMessage.getConversation().getType() + ", sid=" + tIMMessage.getConversation().getPeer() + ", msgid=" + tIMMessage.getMsgId() + ", seq=" + tIMMessage.getMsg().seq() + ", rand=" + tIMMessage.getMsg().rand() + ", time=" + tIMMessage.getMsg().time());
            }
        }
        if (messageListeners.size() == 0 && IMMsfCoreProxy.get().isOfflinePushEnabled(IMMsfCoreProxy.get().getContext(), this.f30700b.identifer)) {
            TIMOfflinePushListener offlinePushListener = TIMManager.getInstanceById(this.f30700b.identifer).getOfflinePushListener();
            if (offlinePushListener != null) {
                Iterator it2 = this.f30699a.iterator();
                while (it2.hasNext()) {
                    TIMOfflinePushNotification tIMOfflinePushNotification = new TIMOfflinePushNotification(IMMsfCoreProxy.get().getContext(), (TIMMessage) it2.next());
                    if (tIMOfflinePushNotification.isValid()) {
                        tIMOfflinePushNotification.setIdentifier(this.f30700b.identifer);
                        offlinePushListener.handleNotification(tIMOfflinePushNotification);
                    }
                }
            }
        }
    }
}
