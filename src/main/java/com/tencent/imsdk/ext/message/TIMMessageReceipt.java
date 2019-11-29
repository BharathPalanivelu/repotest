package com.tencent.imsdk.ext.message;

import com.tencent.imcore.MsgReceipt;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.TIMConversation;

public class TIMMessageReceipt {
    private TIMConversation conversation;
    private long timestamp = 0;

    protected static TIMMessageReceipt convertFrom(MsgReceipt msgReceipt) {
        if (msgReceipt == null) {
            return null;
        }
        TIMMessageReceipt tIMMessageReceipt = new TIMMessageReceipt();
        if (msgReceipt.getSess() != null) {
            TIMConversation tIMConversation = new TIMConversation();
            IMLiteBridge.setConversationType(tIMConversation, IMLiteBridge.conversationTypeFromInternal(msgReceipt.getSess().getType()));
            IMLiteBridge.setConversationPeer(tIMConversation, msgReceipt.getSess().getSid());
            tIMMessageReceipt.setConversation(tIMConversation);
        }
        tIMMessageReceipt.setTimestamp(msgReceipt.getTimestamp());
        return tIMMessageReceipt;
    }

    public TIMConversation getConversation() {
        return this.conversation;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    /* access modifiers changed from: package-private */
    public void setConversation(TIMConversation tIMConversation) {
        this.conversation = tIMConversation;
    }

    /* access modifiers changed from: package-private */
    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
