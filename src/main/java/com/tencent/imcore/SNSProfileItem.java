package com.tencent.imcore;

public class SNSProfileItem {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SNSProfileItem() {
        this(internalSnsExtJNI.new_SNSProfileItem(), true);
    }

    protected SNSProfileItem(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SNSProfileItem sNSProfileItem) {
        if (sNSProfileItem == null) {
            return 0;
        }
        return sNSProfileItem.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_SNSProfileItem(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public BytesMap getMpCustom() {
        long SNSProfileItem_mpCustom_get = internalSnsExtJNI.SNSProfileItem_mpCustom_get(this.swigCPtr, this);
        if (SNSProfileItem_mpCustom_get == 0) {
            return null;
        }
        return new BytesMap(SNSProfileItem_mpCustom_get, false);
    }

    public BytesCompatUintMap getMpCustomUint() {
        long SNSProfileItem_mpCustomUint_get = internalSnsExtJNI.SNSProfileItem_mpCustomUint_get(this.swigCPtr, this);
        if (SNSProfileItem_mpCustomUint_get == 0) {
            return null;
        }
        return new BytesCompatUintMap(SNSProfileItem_mpCustomUint_get, false);
    }

    public BytesMap getMpProfiles() {
        long SNSProfileItem_mpProfiles_get = internalSnsExtJNI.SNSProfileItem_mpProfiles_get(this.swigCPtr, this);
        if (SNSProfileItem_mpProfiles_get == 0) {
            return null;
        }
        return new BytesMap(SNSProfileItem_mpProfiles_get, false);
    }

    public String getSIdentifier() {
        return internalSnsExtJNI.SNSProfileItem_sIdentifier_get(this.swigCPtr, this);
    }

    public void setMpCustom(BytesMap bytesMap) {
        internalSnsExtJNI.SNSProfileItem_mpCustom_set(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    public void setMpCustomUint(BytesCompatUintMap bytesCompatUintMap) {
        internalSnsExtJNI.SNSProfileItem_mpCustomUint_set(this.swigCPtr, this, BytesCompatUintMap.getCPtr(bytesCompatUintMap), bytesCompatUintMap);
    }

    public void setMpProfiles(BytesMap bytesMap) {
        internalSnsExtJNI.SNSProfileItem_mpProfiles_set(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    public void setSIdentifier(String str) {
        internalSnsExtJNI.SNSProfileItem_sIdentifier_set(this.swigCPtr, this, str);
    }
}
