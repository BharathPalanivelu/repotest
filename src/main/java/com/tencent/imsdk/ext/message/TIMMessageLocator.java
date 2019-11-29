package com.tencent.imsdk.ext.message;

import com.tencent.imcore.MessageLocator;
import com.tencent.imcore.SessionType;
import com.tencent.imsdk.TIMConversationType;
import java.io.UnsupportedEncodingException;

public class TIMMessageLocator {
    private boolean isRevokedMsg = false;
    private boolean isSelf = true;
    private long rand = 0;
    private long seq = 0;
    private byte[] sid;
    private SessionType stype = SessionType.kNull;
    private long timestamp = 0;

    protected TIMMessageLocator(MessageLocator messageLocator) {
        this.timestamp = messageLocator.getTime();
        this.seq = messageLocator.getSeq();
        this.rand = messageLocator.getRand();
        this.isSelf = messageLocator.getIs_self();
        this.stype = messageLocator.getType();
        this.sid = messageLocator.getSid();
        this.isRevokedMsg = messageLocator.getIsRevokedMsg();
    }

    /* access modifiers changed from: protected */
    public MessageLocator convertTo() {
        MessageLocator messageLocator = new MessageLocator();
        messageLocator.setTime(this.timestamp);
        messageLocator.setSeq(this.seq);
        messageLocator.setRand(this.rand);
        messageLocator.setIs_self(this.isSelf);
        messageLocator.setSid(this.sid);
        messageLocator.setType(this.stype);
        messageLocator.setIsRevokedMsg(this.isRevokedMsg);
        return messageLocator;
    }

    /* access modifiers changed from: protected */
    public long getRand() {
        return this.rand;
    }

    /* access modifiers changed from: protected */
    public long getSeq() {
        return this.seq;
    }

    /* access modifiers changed from: protected */
    public String getSid() {
        try {
            return this.sid != null ? new String(this.sid, "utf-8") : "";
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public SessionType getStype() {
        return this.stype;
    }

    /* access modifiers changed from: protected */
    public long getTimestamp() {
        return this.timestamp;
    }

    /* access modifiers changed from: protected */
    public boolean isRevokedMsg() {
        return this.isRevokedMsg;
    }

    /* access modifiers changed from: protected */
    public boolean isSelf() {
        return this.isSelf;
    }

    public String toString() {
        String str = "ConverSationType: " + TIMConversationType.getType(this.stype);
        try {
            str = str + ", ConversationID: " + new String(this.sid, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return str + ", seq: " + this.seq + ", rand: " + this.rand + ", isSelf: " + this.isSelf + ", isRevokedMsg: " + this.isRevokedMsg;
    }
}
