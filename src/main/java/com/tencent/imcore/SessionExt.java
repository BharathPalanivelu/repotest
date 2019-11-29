package com.tencent.imcore;

public class SessionExt {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SessionExt(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public SessionExt(Session session) {
        this(internalMsgExtJNI.new_SessionExt(Session.getCPtr(session), session), true);
    }

    protected static long getCPtr(SessionExt sessionExt) {
        if (sessionExt == null) {
            return 0;
        }
        return sessionExt.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalMsgExtJNI.delete_SessionExt(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public int deleteLocalMsg(Msg msg, INotifyCallback iNotifyCallback) {
        return internalMsgExtJNI.SessionExt_deleteLocalMsg(this.swigCPtr, this, Msg.getCPtr(msg), msg, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public void findMsg(MsgLocatorVec msgLocatorVec, ICallbackWithMsgVec iCallbackWithMsgVec) {
        internalMsgExtJNI.SessionExt_findMsg(this.swigCPtr, this, MsgLocatorVec.getCPtr(msgLocatorVec), msgLocatorVec, ICallbackWithMsgVec.getCPtr(iCallbackWithMsgVec), iCallbackWithMsgVec);
    }

    public Draft getDraft() {
        return new Draft(internalMsgExtJNI.SessionExt_getDraft(this.swigCPtr, this), true);
    }

    public void getLocalMsgs(long j, Msg msg, ICallbackWithMsgVec iCallbackWithMsgVec) {
        internalMsgExtJNI.SessionExt_getLocalMsgs(this.swigCPtr, this, j, Msg.getCPtr(msg), msg, ICallbackWithMsgVec.getCPtr(iCallbackWithMsgVec), iCallbackWithMsgVec);
    }

    public void getMsgs(long j, Msg msg, ICallbackWithMsgVec iCallbackWithMsgVec) {
        internalMsgExtJNI.SessionExt_getMsgs(this.swigCPtr, this, j, Msg.getCPtr(msg), msg, ICallbackWithMsgVec.getCPtr(iCallbackWithMsgVec), iCallbackWithMsgVec);
    }

    public void getMsgsForward(long j, Msg msg, ICallbackWithMsgVec iCallbackWithMsgVec) {
        internalMsgExtJNI.SessionExt_getMsgsForward(this.swigCPtr, this, j, Msg.getCPtr(msg), msg, ICallbackWithMsgVec.getCPtr(iCallbackWithMsgVec), iCallbackWithMsgVec);
    }

    public MsgVec getMsgsFromCache(long j) {
        return new MsgVec(internalMsgExtJNI.SessionExt_getMsgsFromCache__SWIG_1(this.swigCPtr, this, j), true);
    }

    public MsgVec getMsgsFromCache(long j, Msg msg) {
        return new MsgVec(internalMsgExtJNI.SessionExt_getMsgsFromCache__SWIG_0(this.swigCPtr, this, j, Msg.getCPtr(msg), msg), true);
    }

    public MsgVec getUndeletedMsgsFromCache(long j) {
        return new MsgVec(internalMsgExtJNI.SessionExt_getUndeletedMsgsFromCache__SWIG_1(this.swigCPtr, this, j), true);
    }

    public MsgVec getUndeletedMsgsFromCache(long j, Msg msg) {
        return new MsgVec(internalMsgExtJNI.SessionExt_getUndeletedMsgsFromCache__SWIG_0(this.swigCPtr, this, j, Msg.getCPtr(msg), msg), true);
    }

    public boolean hasDraft() {
        return internalMsgExtJNI.SessionExt_hasDraft(this.swigCPtr, this);
    }

    public void ignoreStorage() {
        internalMsgExtJNI.SessionExt_ignoreStorage(this.swigCPtr, this);
    }

    public int importMsg(MsgVec msgVec) {
        return internalMsgExtJNI.SessionExt_importMsg(this.swigCPtr, this, MsgVec.getCPtr(msgVec), msgVec);
    }

    public long msgUnread() {
        return internalMsgExtJNI.SessionExt_msgUnread(this.swigCPtr, this);
    }

    public void reportReaded(Msg msg, INotifyCallback iNotifyCallback) {
        internalMsgExtJNI.SessionExt_reportReaded(this.swigCPtr, this, Msg.getCPtr(msg), msg, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public void revokeMsg(Msg msg, INotifyCallback iNotifyCallback) {
        internalMsgExtJNI.SessionExt_revokeMsg(this.swigCPtr, this, Msg.getCPtr(msg), msg, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public int saveMsg(Msg msg, String str, boolean z) {
        return internalMsgExtJNI.SessionExt_saveMsg(this.swigCPtr, this, Msg.getCPtr(msg), msg, str, z);
    }

    public void setDraft(Draft draft) {
        internalMsgExtJNI.SessionExt_setDraft(this.swigCPtr, this, Draft.getCPtr(draft), draft);
    }

    public void syncRevokeNotify(INotifyCallback iNotifyCallback) {
        internalMsgExtJNI.SessionExt_syncRevokeNotify(this.swigCPtr, this, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }
}
