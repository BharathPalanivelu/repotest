package com.tencent.imcore;

public class MsgExt {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MsgExt(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public MsgExt(Msg msg) {
        this(internalMsgExtJNI.new_MsgExt(Msg.getCPtr(msg), msg), true);
    }

    protected static long getCPtr(MsgExt msgExt) {
        if (msgExt == null) {
            return 0;
        }
        return msgExt.swigCPtr;
    }

    public boolean convertToImportmsg() {
        return internalMsgExtJNI.MsgExt_convertToImportmsg(this.swigCPtr, this);
    }

    public int customInt() {
        return internalMsgExtJNI.MsgExt_customInt(this.swigCPtr, this);
    }

    public String customStr() {
        return internalMsgExtJNI.MsgExt_customStr(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalMsgExtJNI.delete_MsgExt(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public boolean hasGap() {
        return internalMsgExtJNI.MsgExt_hasGap(this.swigCPtr, this);
    }

    public boolean isPeerRead() {
        return internalMsgExtJNI.MsgExt_isPeerRead(this.swigCPtr, this);
    }

    public boolean isRead() {
        return internalMsgExtJNI.MsgExt_isRead(this.swigCPtr, this);
    }

    public boolean remove() {
        return internalMsgExtJNI.MsgExt_remove(this.swigCPtr, this);
    }

    public boolean setCustomInt(int i) {
        return internalMsgExtJNI.MsgExt_setCustomInt(this.swigCPtr, this, i);
    }

    public boolean setCustomStr(String str) {
        return internalMsgExtJNI.MsgExt_setCustomStr(this.swigCPtr, this, str);
    }

    public boolean setSender(String str) {
        return internalMsgExtJNI.MsgExt_setSender(this.swigCPtr, this, str);
    }

    public boolean setTime(long j) {
        return internalMsgExtJNI.MsgExt_setTime(this.swigCPtr, this, j);
    }
}
