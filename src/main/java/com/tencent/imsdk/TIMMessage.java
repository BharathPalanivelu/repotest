package com.tencent.imsdk;

import com.tencent.imcore.Elem;
import com.tencent.imcore.Msg;
import com.tencent.imcore.MsgPriority;
import com.tencent.imsdk.log.QLog;
import java.io.UnsupportedEncodingException;

public class TIMMessage {
    private static final TIMElem defaultElem = new dk();
    private static final String tag = "imsdk.TIMMessage";
    private TIMConversation conversation;
    private Msg msg;

    public TIMMessage() {
        try {
            this.msg = Msg.newMsg();
        } catch (Throwable th) {
            QLog.e(tag, 1, QLog.getStackTraceString(th));
        }
        this.conversation = new TIMConversation();
    }

    public TIMMessage(Msg msg2) {
        try {
            this.msg = Msg.newMsg(msg2);
            this.conversation = new TIMConversation();
            this.conversation.fromSession(this.msg.session());
        } catch (Throwable th) {
            this.conversation = new TIMConversation();
            QLog.e(tag, 1, QLog.getStackTraceString(th));
        }
    }

    public int addElement(TIMElem tIMElem) {
        if (this.msg == null || tIMElem == null) {
            return 1;
        }
        Elem elem2Internal = IMLiteBridge.elem2Internal(tIMElem);
        if (elem2Internal == null) {
            return 1;
        }
        this.msg.addElem(elem2Internal);
        return 0;
    }

    public boolean copyFrom(TIMMessage tIMMessage) {
        Msg msg2 = this.msg;
        if (msg2 == null || tIMMessage == null) {
            return false;
        }
        return msg2.copyFrom(tIMMessage.getMsg());
    }

    public TIMConversation getConversation() {
        return this.conversation;
    }

    public TIMElem getElement(int i) {
        Msg msg2 = this.msg;
        if (msg2 == null || i < 0) {
            return defaultElem;
        }
        long j = (long) i;
        try {
            msg2.elemType(j);
            return IMLiteBridge.elemFromInternal(this.msg.getElem(j));
        } catch (Throwable th) {
            QLog.e(tag, 1, IMFunc.getExceptionInfo(th));
            return defaultElem;
        }
    }

    public long getElementCount() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return 0;
        }
        return msg2.elemSize();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getGroupName() {
        /*
            r3 = this;
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x001a, Throwable -> 0x000e }
            com.tencent.imcore.Msg r1 = r3.msg     // Catch:{ UnsupportedEncodingException -> 0x001a, Throwable -> 0x000e }
            byte[] r1 = r1.getGroupName()     // Catch:{ UnsupportedEncodingException -> 0x001a, Throwable -> 0x000e }
            java.lang.String r2 = "utf-8"
            r0.<init>(r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x001a, Throwable -> 0x000e }
            goto L_0x001f
        L_0x000e:
            r0 = move-exception
            java.lang.String r0 = com.tencent.imsdk.IMFunc.getExceptionInfo(r0)
            r1 = 1
            java.lang.String r2 = "imsdk.TIMMessage"
            com.tencent.imsdk.log.QLog.e(r2, r1, r0)
            goto L_0x001e
        L_0x001a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x001e:
            r0 = 0
        L_0x001f:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0027
            java.lang.String r0 = ""
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.TIMMessage.getGroupName():java.lang.String");
    }

    public Msg getMsg() {
        return this.msg;
    }

    public String getMsgId() {
        Msg msg2 = this.msg;
        String str = "";
        if (msg2 == null) {
            QLog.i(tag, 1, "msg is null");
        } else {
            try {
                str = new String(msg2.msgid(), "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            }
        }
        QLog.i(tag, 1, "msgid " + str);
        return str;
    }

    public long getMsgUniqueId() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.uniqueid();
        }
        return 0;
    }

    public TIMMessageOfflinePushSettings getOfflinePushSettings() {
        Msg msg2 = this.msg;
        if (msg2 == null || !msg2.getOfflinePushInfo().getIsValid()) {
            return null;
        }
        return TIMMessageOfflinePushSettings.convertFrom(this.msg.getOfflinePushInfo());
    }

    public TIMMessagePriority getPriority() {
        if (this.msg == null) {
            return TIMMessagePriority.Normal;
        }
        for (TIMMessagePriority tIMMessagePriority : TIMMessagePriority.values()) {
            if (tIMMessagePriority.getValue() == this.msg.priority().swigValue()) {
                return tIMMessagePriority;
            }
        }
        return TIMMessagePriority.Normal;
    }

    public long getRand() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return 0;
        }
        return msg2.rand();
    }

    public TIMGroupReceiveMessageOpt getRecvFlag() {
        if (this.msg != null) {
            return TIMGroupReceiveMessageOpt.values()[this.msg.getRecvFlag()];
        }
        return null;
    }

    public String getSender() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.getSender();
        }
        QLog.i(tag, 1, "msg is null");
        return null;
    }

    public TIMGroupMemberInfo getSenderGroupMemberProfile() {
        if (this.msg == null || getConversation().getType() != TIMConversationType.Group) {
            return null;
        }
        TIMGroupMemberInfo tIMGroupMemberInfo = new TIMGroupMemberInfo(this.msg.getSenderGroupMemberProfile());
        if (tIMGroupMemberInfo.getUser().length() == 0) {
            return null;
        }
        return tIMGroupMemberInfo;
    }

    public TIMUserProfile getSenderProfile() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return null;
        }
        TIMUserProfile tIMUserProfile = new TIMUserProfile(msg2.getSenderProfile());
        if (tIMUserProfile.getIdentifier().length() == 0) {
            return null;
        }
        return tIMUserProfile;
    }

    public long getSeq() {
        Msg msg2 = this.msg;
        if (msg2 == null) {
            return 0;
        }
        return msg2.seq();
    }

    public boolean isSelf() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.isSelf();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setConversation(TIMConversation tIMConversation) {
        this.conversation = tIMConversation;
    }

    public void setOfflinePushSettings(TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings) {
        if (this.msg != null && tIMMessageOfflinePushSettings != null) {
            this.msg.setOfflinePushInfo(tIMMessageOfflinePushSettings.convertTo());
        }
    }

    public void setPriority(TIMMessagePriority tIMMessagePriority) {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            msg2.setPriority(MsgPriority.swigToEnum(tIMMessagePriority.getValue()));
        }
    }

    public TIMMessageStatus status() {
        if (this.msg != null) {
            for (TIMMessageStatus tIMMessageStatus : TIMMessageStatus.values()) {
                if (tIMMessageStatus.getStatus() == this.msg.status()) {
                    return tIMMessageStatus;
                }
            }
        }
        return TIMMessageStatus.SendSucc;
    }

    public long timestamp() {
        Msg msg2 = this.msg;
        if (msg2 != null) {
            return msg2.time();
        }
        return 0;
    }
}
