package com.tencent.imsdk.ext.message;

import com.tencent.imcore.Draft;
import com.tencent.imcore.ICallbackWithMsgVec;
import com.tencent.imcore.Msg;
import com.tencent.imcore.MsgLocatorVec;
import com.tencent.imcore.MsgVec;
import com.tencent.imcore.SessionExt;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.IMFunc;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMNetworkStatus;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;
import java.util.ArrayList;
import java.util.List;

public class TIMConversationExt {
    /* access modifiers changed from: private */
    public static final String TAG = "TIMConversationExt";
    private SessionExt sessionExt;

    public static abstract class GetMsgsListener extends ICallbackWithMsgVec {
        public TIMValueCallBack<List<TIMMessage>> callback = null;

        public GetMsgsListener(TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
            this.callback = tIMValueCallBack;
            swigReleaseOwnership();
        }

        public final void done(MsgVec msgVec) {
            ArrayList arrayList = new ArrayList();
            if (msgVec != null) {
                for (int i = 0; ((long) i) < msgVec.size(); i++) {
                    TIMMessage tIMMessage = new TIMMessage(msgVec.get(i));
                    if (tIMMessage.getConversation().getType() != TIMConversationType.Invalid) {
                        arrayList.add(tIMMessage);
                    }
                }
            }
            IMMsfCoreProxy.mainHandler.post(new al(this, arrayList));
            swigTakeOwnership();
        }

        public final void fail(int i, String str) {
            QLog.e(TIMConversationExt.TAG, 1, "getmsgs failed");
            IMMsfCoreProxy.mainHandler.post(new am(this, i, str));
            swigTakeOwnership();
        }
    }

    public TIMConversationExt(TIMConversation tIMConversation) {
        this.sessionExt = new SessionExt(IMLiteBridge.getSession(tIMConversation == null ? new TIMConversation() : tIMConversation));
    }

    public void deleteLocalMessage(TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            this.sessionExt.deleteLocalMsg((Msg) null, new ah(this, tIMCallBack));
        }
    }

    public void disableStorage() {
        if (IMFunc.preCheck(false, (Object) null, (QualityReportHelper) null) == 0) {
            this.sessionExt.ignoreStorage();
        }
    }

    public void findMessages(List<TIMMessageLocator> list, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty(), tIMValueCallBack, (QualityReportHelper) null) == 0) {
                MsgLocatorVec msgLocatorVec = new MsgLocatorVec();
                for (TIMMessageLocator next : list) {
                    if (next != null) {
                        msgLocatorVec.add(next.convertTo());
                    }
                }
                this.sessionExt.findMsg(msgLocatorVec, new ai(this, tIMValueCallBack));
            }
        }
    }

    public TIMMessageDraft getDraft() {
        if (IMFunc.preCheck(false, (Object) null, (QualityReportHelper) null) != 0) {
            return null;
        }
        return TIMMessageDraft.convertFrom(this.sessionExt.getDraft());
    }

    public List<TIMMessage> getLastMsgs(long j) {
        ArrayList arrayList = new ArrayList();
        MsgVec undeletedMsgsFromCache = this.sessionExt.getUndeletedMsgsFromCache(j);
        if (undeletedMsgsFromCache != null) {
            long size = undeletedMsgsFromCache.size();
            for (int i = 0; ((long) i) < size; i++) {
                arrayList.add(new TIMMessage(undeletedMsgsFromCache.get(i)));
            }
        }
        return arrayList;
    }

    public void getLocalMessage(int i, TIMMessage tIMMessage, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            Msg msg = null;
            if (IMFunc.preCheck(false, tIMValueCallBack, (QualityReportHelper) null) == 0) {
                if (tIMMessage != null) {
                    msg = tIMMessage.getMsg();
                }
                this.sessionExt.getLocalMsgs((long) i, msg, new ag(this, tIMValueCallBack));
            }
        }
    }

    public void getMessage(int i, TIMMessage tIMMessage, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            Msg msg = null;
            if (IMFunc.preCheck(false, tIMValueCallBack, (QualityReportHelper) null) == 0) {
                if (tIMMessage != null) {
                    msg = tIMMessage.getMsg();
                }
                if (IMMsfCoreProxy.get().getNetworkStatus() == TIMNetworkStatus.TIM_NETWORK_STATUS_DISCONNECTED) {
                    QLog.d(TAG, 1, "network disconnected, get Msgs from local");
                    this.sessionExt.getLocalMsgs((long) i, msg, new ac(this, tIMValueCallBack));
                    return;
                }
                this.sessionExt.getMsgs((long) i, msg, new ad(this, tIMValueCallBack));
            }
        }
    }

    public void getMessageForward(int i, TIMMessage tIMMessage, TIMValueCallBack<List<TIMMessage>> tIMValueCallBack) {
        if (tIMValueCallBack != null) {
            if (IMFunc.preCheck(tIMMessage == null, tIMValueCallBack, (QualityReportHelper) null) == 0) {
                this.sessionExt.getMsgsForward((long) i, tIMMessage.getMsg(), new ae(this, tIMValueCallBack));
            }
        }
    }

    public long getUnreadMessageNum() {
        return this.sessionExt.msgUnread();
    }

    public boolean hasDraft() {
        if (IMFunc.preCheck(false, (Object) null, (QualityReportHelper) null) != 0) {
            return false;
        }
        return this.sessionExt.hasDraft();
    }

    public int importMsg(List<TIMMessage> list) {
        int preCheck = IMFunc.preCheck(list == null || list.isEmpty(), (Object) null, (QualityReportHelper) null);
        if (preCheck != 0) {
            return preCheck;
        }
        MsgVec msgVec = new MsgVec();
        for (TIMMessage msg : list) {
            msgVec.add(msg.getMsg());
        }
        return this.sessionExt.importMsg(msgVec);
    }

    public void revokeMessage(TIMMessage tIMMessage, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            if (IMFunc.preCheck(tIMMessage == null, tIMCallBack, (QualityReportHelper) null) == 0) {
                this.sessionExt.revokeMsg(tIMMessage.getMsg(), new aj(this, tIMCallBack));
            }
        }
    }

    public int saveMessage(TIMMessage tIMMessage, String str, boolean z) {
        int preCheck = IMFunc.preCheck(tIMMessage == null || tIMMessage.getMsg() == null || str == null || str.length() == 0, (Object) null, (QualityReportHelper) null);
        if (preCheck != 0) {
            return preCheck;
        }
        if (this.sessionExt.saveMsg(tIMMessage.getMsg(), str, z) == 1) {
            return 0;
        }
        return BaseConstants.ERR_DATABASE_OPERATE_FAILED;
    }

    public void setDraft(TIMMessageDraft tIMMessageDraft) {
        if (IMFunc.preCheck(false, (Object) null, (QualityReportHelper) null) == 0) {
            Draft draft = new Draft();
            if (tIMMessageDraft != null) {
                draft = tIMMessageDraft.convertTo();
            }
            this.sessionExt.setDraft(draft);
        }
    }

    public void setReadMessage(TIMMessage tIMMessage, TIMCallBack tIMCallBack) {
        Msg msg = null;
        if (IMFunc.preCheck(false, tIMCallBack, (QualityReportHelper) null) == 0) {
            if (tIMMessage != null) {
                msg = tIMMessage.getMsg();
            }
            this.sessionExt.reportReaded(msg, new af(this, tIMCallBack));
        }
    }

    public void syncMsgRevokedNotification(TIMCallBack tIMCallBack) {
        if (tIMCallBack != null && IMFunc.preCheck(false, tIMCallBack, (QualityReportHelper) null) == 0) {
            this.sessionExt.syncRevokeNotify(new ak(this, tIMCallBack));
        }
    }
}
