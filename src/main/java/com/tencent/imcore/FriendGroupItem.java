package com.tencent.imcore;

public class FriendGroupItem {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendGroupItem() {
        this(internalSnsExtJNI.new_FriendGroupItem(), true);
    }

    protected FriendGroupItem(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendGroupItem friendGroupItem) {
        if (friendGroupItem == null) {
            return 0;
        }
        return friendGroupItem.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendGroupItem(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public SWIGTYPE_p_std__setT_std__string_t getIdentifiers() {
        long FriendGroupItem_identifiers_get = internalSnsExtJNI.FriendGroupItem_identifiers_get(this.swigCPtr, this);
        if (FriendGroupItem_identifiers_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__setT_std__string_t(FriendGroupItem_identifiers_get, false);
    }

    public byte[] getName() {
        return internalSnsExtJNI.FriendGroupItem_name_get(this.swigCPtr, this);
    }

    public void setIdentifiers(SWIGTYPE_p_std__setT_std__string_t sWIGTYPE_p_std__setT_std__string_t) {
        internalSnsExtJNI.FriendGroupItem_identifiers_set(this.swigCPtr, this, SWIGTYPE_p_std__setT_std__string_t.getCPtr(sWIGTYPE_p_std__setT_std__string_t));
    }

    public void setName(byte[] bArr) {
        internalSnsExtJNI.FriendGroupItem_name_set(this.swigCPtr, this, bArr);
    }
}
