package com.tencent.imcore;

public class FriendPendencyItem {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendPendencyItem() {
        this(internalSnsExtJNI.new_FriendPendencyItem(), true);
    }

    protected FriendPendencyItem(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendPendencyItem friendPendencyItem) {
        if (friendPendencyItem == null) {
            return 0;
        }
        return friendPendencyItem.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendPendencyItem(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getDdwAddTime() {
        return internalSnsExtJNI.FriendPendencyItem_ddwAddTime_get(this.swigCPtr, this);
    }

    public int getIType() {
        return internalSnsExtJNI.FriendPendencyItem_iType_get(this.swigCPtr, this);
    }

    public byte[] getSAddSource() {
        return internalSnsExtJNI.FriendPendencyItem_sAddSource_get(this.swigCPtr, this);
    }

    public byte[] getSAddWording() {
        return internalSnsExtJNI.FriendPendencyItem_sAddWording_get(this.swigCPtr, this);
    }

    public String getSIdentifier() {
        return internalSnsExtJNI.FriendPendencyItem_sIdentifier_get(this.swigCPtr, this);
    }

    public byte[] getSNickname() {
        return internalSnsExtJNI.FriendPendencyItem_sNickname_get(this.swigCPtr, this);
    }

    public void setDdwAddTime(long j) {
        internalSnsExtJNI.FriendPendencyItem_ddwAddTime_set(this.swigCPtr, this, j);
    }

    public void setIType(int i) {
        internalSnsExtJNI.FriendPendencyItem_iType_set(this.swigCPtr, this, i);
    }

    public void setSAddSource(byte[] bArr) {
        internalSnsExtJNI.FriendPendencyItem_sAddSource_set(this.swigCPtr, this, bArr);
    }

    public void setSAddWording(byte[] bArr) {
        internalSnsExtJNI.FriendPendencyItem_sAddWording_set(this.swigCPtr, this, bArr);
    }

    public void setSIdentifier(String str) {
        internalSnsExtJNI.FriendPendencyItem_sIdentifier_set(this.swigCPtr, this, str);
    }

    public void setSNickname(byte[] bArr) {
        internalSnsExtJNI.FriendPendencyItem_sNickname_set(this.swigCPtr, this, bArr);
    }
}
