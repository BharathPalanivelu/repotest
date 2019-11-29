package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imcore.INotifyCallback;
import com.tencent.imcore.QrEventType;
import com.tencent.imcore.Session;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;

public class TIMConversation {
    /* access modifiers changed from: private */
    public static final String tag = ("imsdk." + TIMConversation.class.getSimpleName());
    private String identifer;
    private String peer;
    private TIMConversationType type;

    abstract class aa extends INotifyCallback {

        /* renamed from: a  reason: collision with root package name */
        public TIMValueCallBack<TIMMessage> f30667a = null;

        /* renamed from: b  reason: collision with root package name */
        TIMMessage f30668b = null;

        /* renamed from: c  reason: collision with root package name */
        private QualityReportHelper f30669c;

        aa(TIMMessage tIMMessage, TIMValueCallBack<TIMMessage> tIMValueCallBack, QualityReportHelper qualityReportHelper) {
            this.f30668b = tIMMessage;
            this.f30667a = tIMValueCallBack;
            this.f30669c = qualityReportHelper;
            swigReleaseOwnership();
        }

        public final void done() {
            if (this.f30667a != null) {
                QLog.i(TIMConversation.tag, 1, "SendMsg|5-Callback|Succ|");
                IMMsfCoreProxy.mainHandler.post(new cs(this));
            } else {
                QLog.i(TIMConversation.tag, 1, "SendMsg|5-Callback|Fail|user not set succ cb");
            }
            QualityReportHelper qualityReportHelper = this.f30669c;
            if (qualityReportHelper != null) {
                qualityReportHelper.init(0, "");
                this.f30669c.report();
            }
            swigTakeOwnership();
        }

        public final void fail(int i, String str) {
            if (this.f30667a != null) {
                String access$000 = TIMConversation.tag;
                QLog.i(access$000, 1, "SendMsg|5-Callback|Succ|code=" + i + ", msg=" + str);
                IMMsfCoreProxy.mainHandler.post(new ct(this, i, str));
            } else {
                String access$0002 = TIMConversation.tag;
                QLog.i(access$0002, 1, "SendMsg|5-Callback|Fail|user not set fail cb, code=" + i + ", msg=" + str);
            }
            QualityReportHelper qualityReportHelper = this.f30669c;
            if (qualityReportHelper != null) {
                qualityReportHelper.init(i, str);
                this.f30669c.report();
            }
            swigTakeOwnership();
        }
    }

    public TIMConversation() {
        this.identifer = "";
        this.peer = "";
        this.type = TIMConversationType.Invalid;
        this.identifer = TIMManager.getInstance().getIdentifier();
    }

    protected TIMConversation(String str) {
        this.identifer = "";
        this.peer = "";
        this.type = TIMConversationType.Invalid;
        this.identifer = str;
    }

    /* access modifiers changed from: protected */
    public void fromSession(Session session) {
        this.type = TIMConversationType.Invalid;
        if (session != null) {
            this.type = !session.isValid() ? TIMConversationType.Invalid : TIMConversationType.getType(session.type());
            setPeer(session.sid());
        }
    }

    /* access modifiers changed from: protected */
    public String getIdentifer() {
        return this.identifer;
    }

    public String getPeer() {
        return this.peer;
    }

    /* access modifiers changed from: protected */
    public Session getSession() {
        return TIMManager.getInstanceById(this.identifer).getCoreUser().getSession(TIMConversationType.getType(this.type), this.peer);
    }

    public TIMConversationType getType() {
        return this.type;
    }

    public void sendMessage(TIMMessage tIMMessage, TIMValueCallBack<TIMMessage> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            QualityReportHelper qualityReportHelper = new QualityReportHelper(QrEventType.kEventSendMsg.swigValue());
            if (IMFunc.preCheck(tIMMessage == null, tIMValueCallBack, qualityReportHelper) == 0) {
                tIMMessage.setConversation(this);
                String str = tag;
                QLog.i(str, 1, "SendMsg|1-Begin|Succ|type=" + this.type + ", conversation=" + this.peer);
                getSession().sendMsg(tIMMessage.getMsg(), new cq(this, tIMMessage, tIMValueCallBack, qualityReportHelper));
            }
        }
    }

    public void sendOnlineMessage(TIMMessage tIMMessage, TIMValueCallBack<TIMMessage> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            QualityReportHelper qualityReportHelper = new QualityReportHelper(QrEventType.kEventSendMsg.swigValue());
            if (IMFunc.preCheck(tIMMessage == null, tIMValueCallBack, qualityReportHelper) == 0) {
                tIMMessage.setConversation(this);
                getSession().sendCustomMsg(tIMMessage.getMsg(), new cr(this, tIMMessage, tIMValueCallBack, qualityReportHelper), 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setIdentifer(String str) {
        this.identifer = str;
    }

    /* access modifiers changed from: package-private */
    public void setPeer(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.peer = str;
        }
    }

    /* access modifiers changed from: package-private */
    public void setType(TIMConversationType tIMConversationType) {
        if (tIMConversationType != null) {
            this.type = tIMConversationType;
        }
    }

    /* access modifiers changed from: protected */
    public boolean valid() {
        return this.type != TIMConversationType.Invalid;
    }
}
