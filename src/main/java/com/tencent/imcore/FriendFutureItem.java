package com.tencent.imcore;

public class FriendFutureItem {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendFutureItem() {
        this(internalSnsExtJNI.new_FriendFutureItem(), true);
    }

    protected FriendFutureItem(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendFutureItem friendFutureItem) {
        if (friendFutureItem == null) {
            return 0;
        }
        return friendFutureItem.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendFutureItem(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getDdwAddTime() {
        return internalSnsExtJNI.FriendFutureItem_ddwAddTime_get(this.swigCPtr, this);
    }

    public FutureType getEType() {
        return FutureType.swigToEnum(internalSnsExtJNI.FriendFutureItem_eType_get(this.swigCPtr, this));
    }

    public BytesMap getMpRecommendTags() {
        long FriendFutureItem_mpRecommendTags_get = internalSnsExtJNI.FriendFutureItem_mpRecommendTags_get(this.swigCPtr, this);
        if (FriendFutureItem_mpRecommendTags_get == 0) {
            return null;
        }
        return new BytesMap(FriendFutureItem_mpRecommendTags_get, false);
    }

    public byte[] getSAddSource() {
        return internalSnsExtJNI.FriendFutureItem_sAddSource_get(this.swigCPtr, this);
    }

    public byte[] getSAddWording() {
        return internalSnsExtJNI.FriendFutureItem_sAddWording_get(this.swigCPtr, this);
    }

    public String getSIdentifier() {
        return internalSnsExtJNI.FriendFutureItem_sIdentifier_get(this.swigCPtr, this);
    }

    public FriendProfile getStProfile() {
        long FriendFutureItem_stProfile_get = internalSnsExtJNI.FriendFutureItem_stProfile_get(this.swigCPtr, this);
        if (FriendFutureItem_stProfile_get == 0) {
            return null;
        }
        return new FriendProfile(FriendFutureItem_stProfile_get, false);
    }

    public void setDdwAddTime(long j) {
        internalSnsExtJNI.FriendFutureItem_ddwAddTime_set(this.swigCPtr, this, j);
    }

    public void setEType(FutureType futureType) {
        internalSnsExtJNI.FriendFutureItem_eType_set(this.swigCPtr, this, futureType.swigValue());
    }

    public void setMpRecommendTags(BytesMap bytesMap) {
        internalSnsExtJNI.FriendFutureItem_mpRecommendTags_set(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    public void setSAddSource(byte[] bArr) {
        internalSnsExtJNI.FriendFutureItem_sAddSource_set(this.swigCPtr, this, bArr);
    }

    public void setSAddWording(byte[] bArr) {
        internalSnsExtJNI.FriendFutureItem_sAddWording_set(this.swigCPtr, this, bArr);
    }

    public void setSIdentifier(String str) {
        internalSnsExtJNI.FriendFutureItem_sIdentifier_set(this.swigCPtr, this, str);
    }

    public void setStProfile(FriendProfile friendProfile) {
        internalSnsExtJNI.FriendFutureItem_stProfile_set(this.swigCPtr, this, FriendProfile.getCPtr(friendProfile), friendProfile);
    }
}
