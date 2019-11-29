package com.tencent.imcore;

public class AddFriendReq {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public AddFriendReq() {
        this(internalSnsExtJNI.new_AddFriendReq(), true);
    }

    protected AddFriendReq(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AddFriendReq addFriendReq) {
        if (addFriendReq == null) {
            return 0;
        }
        return addFriendReq.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_AddFriendReq(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public String getIdentifier() {
        return internalSnsExtJNI.AddFriendReq_identifier_get(this.swigCPtr, this);
    }

    public byte[] getNickname() {
        return internalSnsExtJNI.AddFriendReq_nickname_get(this.swigCPtr, this);
    }

    public byte[] getSource() {
        return internalSnsExtJNI.AddFriendReq_source_get(this.swigCPtr, this);
    }

    public byte[] getWording() {
        return internalSnsExtJNI.AddFriendReq_wording_get(this.swigCPtr, this);
    }

    public void setIdentifier(String str) {
        internalSnsExtJNI.AddFriendReq_identifier_set(this.swigCPtr, this, str);
    }

    public void setNickname(byte[] bArr) {
        internalSnsExtJNI.AddFriendReq_nickname_set(this.swigCPtr, this, bArr);
    }

    public void setSource(byte[] bArr) {
        internalSnsExtJNI.AddFriendReq_source_set(this.swigCPtr, this, bArr);
    }

    public void setWording(byte[] bArr) {
        internalSnsExtJNI.AddFriendReq_wording_set(this.swigCPtr, this, bArr);
    }
}
