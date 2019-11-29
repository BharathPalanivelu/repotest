package com.tencent.imcore;

public class MsgLocatorVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MsgLocatorVec() {
        this(internalMsgExtJNI.new_MsgLocatorVec__SWIG_0(), true);
    }

    public MsgLocatorVec(long j) {
        this(internalMsgExtJNI.new_MsgLocatorVec__SWIG_1(j), true);
    }

    protected MsgLocatorVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MsgLocatorVec msgLocatorVec) {
        if (msgLocatorVec == null) {
            return 0;
        }
        return msgLocatorVec.swigCPtr;
    }

    public void add(MessageLocator messageLocator) {
        internalMsgExtJNI.MsgLocatorVec_add(this.swigCPtr, this, MessageLocator.getCPtr(messageLocator), messageLocator);
    }

    public long capacity() {
        return internalMsgExtJNI.MsgLocatorVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalMsgExtJNI.MsgLocatorVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalMsgExtJNI.delete_MsgLocatorVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public MessageLocator get(int i) {
        return new MessageLocator(internalMsgExtJNI.MsgLocatorVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalMsgExtJNI.MsgLocatorVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalMsgExtJNI.MsgLocatorVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, MessageLocator messageLocator) {
        internalMsgExtJNI.MsgLocatorVec_set(this.swigCPtr, this, i, MessageLocator.getCPtr(messageLocator), messageLocator);
    }

    public long size() {
        return internalMsgExtJNI.MsgLocatorVec_size(this.swigCPtr, this);
    }
}
