package com.tencent.imcore;

public class INotify {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public INotify() {
        this(internalJNI.new_INotify(), true);
        internalJNI.INotify_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected INotify(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(INotify iNotify) {
        if (iNotify == null) {
            return 0;
        }
        return iNotify.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_INotify(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public void onMsgEvent(MsgVec msgVec) {
        if (getClass() == INotify.class) {
            internalJNI.INotify_onMsgEvent(this.swigCPtr, this, MsgVec.getCPtr(msgVec), msgVec);
            return;
        }
        internalJNI.INotify_onMsgEventSwigExplicitINotify(this.swigCPtr, this, MsgVec.getCPtr(msgVec), msgVec);
    }

    public void onMsgRevoke(MessageLocator messageLocator) {
        if (getClass() == INotify.class) {
            internalJNI.INotify_onMsgRevoke(this.swigCPtr, this, MessageLocator.getCPtr(messageLocator), messageLocator);
            return;
        }
        internalJNI.INotify_onMsgRevokeSwigExplicitINotify(this.swigCPtr, this, MessageLocator.getCPtr(messageLocator), messageLocator);
    }

    public void onMsgUpdate(MsgVec msgVec) {
        if (getClass() == INotify.class) {
            internalJNI.INotify_onMsgUpdate(this.swigCPtr, this, MsgVec.getCPtr(msgVec), msgVec);
            return;
        }
        internalJNI.INotify_onMsgUpdateSwigExplicitINotify(this.swigCPtr, this, MsgVec.getCPtr(msgVec), msgVec);
    }

    public void onRecvGroupEventTips(GroupTipsElem groupTipsElem) {
        if (getClass() == INotify.class) {
            internalJNI.INotify_onRecvGroupEventTips(this.swigCPtr, this, GroupTipsElem.getCPtr(groupTipsElem), groupTipsElem);
            return;
        }
        internalJNI.INotify_onRecvGroupEventTipsSwigExplicitINotify(this.swigCPtr, this, GroupTipsElem.getCPtr(groupTipsElem), groupTipsElem);
    }

    public void onRecvMsgReceipt(MsgReceiptVec msgReceiptVec) {
        if (getClass() == INotify.class) {
            internalJNI.INotify_onRecvMsgReceipt(this.swigCPtr, this, MsgReceiptVec.getCPtr(msgReceiptVec), msgReceiptVec);
            return;
        }
        internalJNI.INotify_onRecvMsgReceiptSwigExplicitINotify(this.swigCPtr, this, MsgReceiptVec.getCPtr(msgReceiptVec), msgReceiptVec);
    }

    public void onRefresh() {
        if (getClass() == INotify.class) {
            internalJNI.INotify_onRefresh(this.swigCPtr, this);
        } else {
            internalJNI.INotify_onRefreshSwigExplicitINotify(this.swigCPtr, this);
        }
    }

    public void onRefreshConversation(SessionUUIDVec sessionUUIDVec) {
        if (getClass() == INotify.class) {
            internalJNI.INotify_onRefreshConversation(this.swigCPtr, this, SessionUUIDVec.getCPtr(sessionUUIDVec), sessionUUIDVec);
            return;
        }
        internalJNI.INotify_onRefreshConversationSwigExplicitINotify(this.swigCPtr, this, SessionUUIDVec.getCPtr(sessionUUIDVec), sessionUUIDVec);
    }

    public void onUploadProgress(Msg msg, int i, int i2, int i3) {
        if (getClass() == INotify.class) {
            internalJNI.INotify_onUploadProgress(this.swigCPtr, this, Msg.getCPtr(msg), msg, i, i2, i3);
            return;
        }
        internalJNI.INotify_onUploadProgressSwigExplicitINotify(this.swigCPtr, this, Msg.getCPtr(msg), msg, i, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        internalJNI.INotify_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalJNI.INotify_change_ownership(this, this.swigCPtr, true);
    }
}
