package com.tencent.imsdk.ext.message;

import com.tencent.imcore.MessageLocator;
import com.tencent.imcore.MsgExt;
import com.tencent.imcore.SessionType;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMMessageStatus;
import java.io.UnsupportedEncodingException;

public class TIMMessageExt {
    private static final String TAG = ("imsdk." + TIMMessageExt.class.getSimpleName());
    private MsgExt msg;
    private TIMMessage timMessage;

    public TIMMessageExt(TIMMessage tIMMessage) {
        tIMMessage = tIMMessage == null ? new TIMMessage() : tIMMessage;
        this.msg = new MsgExt(tIMMessage.getMsg());
        this.timMessage = tIMMessage;
    }

    public boolean checkEquals(TIMMessageLocator tIMMessageLocator) {
        if (tIMMessageLocator == null) {
            return false;
        }
        return (!tIMMessageLocator.isRevokedMsg() || tIMMessageLocator.getStype() != SessionType.kGroup) ? tIMMessageLocator.getStype() == TIMConversationType.getType(this.timMessage.getConversation().getType()) && tIMMessageLocator.getSid().equals(this.timMessage.getConversation().getPeer()) && tIMMessageLocator.getSeq() == this.timMessage.getSeq() && tIMMessageLocator.getRand() == this.timMessage.getRand() && tIMMessageLocator.getTimestamp() == this.timMessage.timestamp() : (this.timMessage.status() == TIMMessageStatus.SendSucc || this.timMessage.status() == TIMMessageStatus.HasRevoked) && tIMMessageLocator.getSeq() == this.timMessage.getSeq() && tIMMessageLocator.getSid().equals(this.timMessage.getConversation().getPeer());
    }

    public boolean convertToImportedMsg() {
        MsgExt msgExt = this.msg;
        if (msgExt == null) {
            return false;
        }
        return msgExt.convertToImportmsg();
    }

    public int getCustomInt() {
        MsgExt msgExt = this.msg;
        if (msgExt == null) {
            return 0;
        }
        return msgExt.customInt();
    }

    public String getCustomStr() {
        MsgExt msgExt = this.msg;
        return msgExt == null ? "" : msgExt.customStr();
    }

    public TIMMessageLocator getMessageLocator() {
        String str;
        MessageLocator messageLocator = new MessageLocator();
        if (this.timMessage != null) {
            TIMConversationType tIMConversationType = TIMConversationType.Invalid;
            if (this.timMessage.getConversation() != null) {
                tIMConversationType = this.timMessage.getConversation().getType();
                str = this.timMessage.getConversation().getPeer();
            } else {
                str = "";
            }
            messageLocator.setType(TIMConversationType.getType(tIMConversationType));
            try {
                messageLocator.setSid(str.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            messageLocator.setSeq(this.timMessage.getSeq());
            messageLocator.setRand(this.timMessage.getRand());
            messageLocator.setTime(this.timMessage.timestamp());
            messageLocator.setIs_self(this.timMessage.isSelf());
        }
        return new TIMMessageLocator(messageLocator);
    }

    public boolean hasGap() {
        MsgExt msgExt = this.msg;
        if (msgExt == null) {
            return false;
        }
        return msgExt.hasGap();
    }

    public boolean isPeerReaded() {
        MsgExt msgExt = this.msg;
        if (msgExt == null) {
            return false;
        }
        return msgExt.isPeerRead();
    }

    public boolean isRead() {
        MsgExt msgExt = this.msg;
        if (msgExt != null) {
            return msgExt.isRead();
        }
        return true;
    }

    public boolean remove() {
        MsgExt msgExt = this.msg;
        if (msgExt == null) {
            return false;
        }
        return msgExt.remove();
    }

    public void setCustomInt(int i) {
        MsgExt msgExt = this.msg;
        if (msgExt != null) {
            msgExt.setCustomInt(i);
        }
    }

    public void setCustomStr(String str) {
        MsgExt msgExt = this.msg;
        if (msgExt != null) {
            if (str == null) {
                str = "";
            }
            msgExt.setCustomStr(str);
        }
    }

    public boolean setSender(String str) {
        MsgExt msgExt = this.msg;
        if (msgExt == null) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return msgExt.setSender(str);
    }

    public boolean setTimestamp(long j) {
        MsgExt msgExt = this.msg;
        if (msgExt == null) {
            return false;
        }
        return msgExt.setTime(j);
    }
}
