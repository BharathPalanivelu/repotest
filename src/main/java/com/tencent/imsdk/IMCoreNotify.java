package com.tencent.imsdk;

import com.tencent.imcore.GroupTipsElem;
import com.tencent.imcore.INotify;
import com.tencent.imcore.MessageLocator;
import com.tencent.imcore.Msg;
import com.tencent.imcore.MsgReceiptVec;
import com.tencent.imcore.MsgVec;
import com.tencent.imcore.SessionUUIDVec;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;

public class IMCoreNotify extends INotify {
    private static final String tag = "IMCoreNotify";
    /* access modifiers changed from: private */
    public String identifer;

    public IMCoreNotify(String str) {
        this.identifer = str;
        swigReleaseOwnership();
    }

    public void onMsgEvent(MsgVec msgVec) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; ((long) i) < msgVec.size(); i++) {
            arrayList.add(new TIMMessage(msgVec.get(i)));
        }
        IMMsfCoreProxy.mainHandler.post(new ak(this, arrayList));
    }

    public void onMsgRevoke(MessageLocator messageLocator) {
        TIMUserConfig userConfig = TIMManager.getInstanceById(this.identifer).getUserConfig();
        try {
            Class.forName("com.tencent.imsdk.ext.message.IMMsgExtBridge").getMethod("onMessageRevoked", new Class[]{MessageLocator.class, TIMUserConfig.class}).invoke((Object) null, new Object[]{messageLocator, userConfig});
        } catch (Throwable th) {
            QLog.e(tag, 1, "onMsgRevoke failed. " + QLog.getStackTraceString(th));
        }
    }

    public void onMsgUpdate(MsgVec msgVec) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; ((long) i) < msgVec.size(); i++) {
            arrayList.add(new TIMMessage(msgVec.get(i)));
        }
        IMMsfCoreProxy.mainHandler.post(new al(this, arrayList));
    }

    public void onRecvGroupEventTips(GroupTipsElem groupTipsElem) {
        TIMGroupEventListener groupEventListener = TIMManager.getInstanceById(this.identifer).getUserConfig().getGroupEventListener();
        if (groupEventListener == null) {
            QLog.i(tag, 1, "group event listener not exist");
            return;
        }
        IMMsfCoreProxy.mainHandler.post(new aq(this, groupEventListener, new TIMGroupTipsElem(groupTipsElem)));
    }

    public void onRecvMsgReceipt(MsgReceiptVec msgReceiptVec) {
        TIMUserConfig userConfig = TIMManager.getInstanceById(this.identifer).getUserConfig();
        try {
            Class.forName("com.tencent.imsdk.ext.message.IMMsgExtBridge").getMethod("onRecvMsgReceipt", new Class[]{MsgReceiptVec.class, TIMUserConfig.class}).invoke((Object) null, new Object[]{msgReceiptVec, userConfig});
        } catch (Throwable th) {
            QLog.e(tag, 1, "onRecvMsgReceipt failed. " + QLog.getStackTraceString(th));
        }
    }

    public void onRefresh() {
        TIMRefreshListener refreshListener = TIMManager.getInstanceById(this.identifer).getUserConfig().getRefreshListener();
        if (refreshListener == null) {
            QLog.i(tag, 1, "refresh listener not exist");
        } else {
            IMMsfCoreProxy.mainHandler.post(new ao(this, refreshListener));
        }
    }

    public void onRefreshConversation(SessionUUIDVec sessionUUIDVec) {
        TIMRefreshListener refreshListener = TIMManager.getInstanceById(this.identifer).getUserConfig().getRefreshListener();
        if (refreshListener == null) {
            QLog.i(tag, 1, "refresh listener not exist");
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (sessionUUIDVec.size() > 0) {
            for (int i = 0; ((long) i) < sessionUUIDVec.size(); i++) {
                TIMConversation tIMConversation = new TIMConversation(this.identifer);
                tIMConversation.setType(TIMConversationType.getType(sessionUUIDVec.get(i).getType()));
                tIMConversation.setPeer(sessionUUIDVec.get(i).getSid());
                arrayList.add(tIMConversation);
            }
        }
        IMMsfCoreProxy.mainHandler.post(new ap(this, refreshListener, arrayList));
    }

    public void onUploadProgress(Msg msg, int i, int i2, int i3) {
        TIMUploadProgressListener uploadProgressListener = TIMManager.getInstanceById(this.identifer).getUserConfig().getUploadProgressListener();
        if (uploadProgressListener == null) {
            QLog.i(tag, 1, "upload progress listener not exist");
        } else if (msg == null) {
            IMCoreAndroidEnv.get().runOnMainThread((Runnable) new am(this, uploadProgressListener, i2, i3));
        } else {
            IMCoreAndroidEnv.get().runOnMainThread((Runnable) new an(this, uploadProgressListener, new TIMMessage(msg), i, i2, i3));
        }
    }
}
