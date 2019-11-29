package com.tencent.imcore;

public class FriendGroup {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendGroup() {
        this(internalSnsExtJNI.new_FriendGroup(), true);
    }

    protected FriendGroup(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendGroup friendGroup) {
        if (friendGroup == null) {
            return 0;
        }
        return friendGroup.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendGroup(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getCount() {
        return internalSnsExtJNI.FriendGroup_count_get(this.swigCPtr, this);
    }

    public StrVec getIdentifiers() {
        long FriendGroup_identifiers_get = internalSnsExtJNI.FriendGroup_identifiers_get(this.swigCPtr, this);
        if (FriendGroup_identifiers_get == 0) {
            return null;
        }
        return new StrVec(FriendGroup_identifiers_get, false);
    }

    public byte[] getName() {
        return internalSnsExtJNI.FriendGroup_name_get(this.swigCPtr, this);
    }

    public FriendProfileVec getProfiles() {
        long FriendGroup_profiles_get = internalSnsExtJNI.FriendGroup_profiles_get(this.swigCPtr, this);
        if (FriendGroup_profiles_get == 0) {
            return null;
        }
        return new FriendProfileVec(FriendGroup_profiles_get, false);
    }

    public SWIGTYPE_p_std__vectorT_long_long_t getTinyids() {
        long FriendGroup_tinyids_get = internalSnsExtJNI.FriendGroup_tinyids_get(this.swigCPtr, this);
        if (FriendGroup_tinyids_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__vectorT_long_long_t(FriendGroup_tinyids_get, false);
    }

    public void setCount(long j) {
        internalSnsExtJNI.FriendGroup_count_set(this.swigCPtr, this, j);
    }

    public void setIdentifiers(StrVec strVec) {
        internalSnsExtJNI.FriendGroup_identifiers_set(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec);
    }

    public void setName(byte[] bArr) {
        internalSnsExtJNI.FriendGroup_name_set(this.swigCPtr, this, bArr);
    }

    public void setProfiles(FriendProfileVec friendProfileVec) {
        internalSnsExtJNI.FriendGroup_profiles_set(this.swigCPtr, this, FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec);
    }

    public void setTinyids(SWIGTYPE_p_std__vectorT_long_long_t sWIGTYPE_p_std__vectorT_long_long_t) {
        internalSnsExtJNI.FriendGroup_tinyids_set(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_long_long_t.getCPtr(sWIGTYPE_p_std__vectorT_long_long_t));
    }
}
