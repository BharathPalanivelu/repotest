package com.tencent.imcore;

public class MapParserStringProfile {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MapParserStringProfile() {
        this(internalJNI.new_MapParserStringProfile(), true);
    }

    protected MapParserStringProfile(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapParserStringProfile mapParserStringProfile) {
        if (mapParserStringProfile == null) {
            return 0;
        }
        return mapParserStringProfile.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_MapParserStringProfile(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void fetchMapKeys(StringProfileMap stringProfileMap) {
        internalJNI.MapParserStringProfile_fetchMapKeys(this.swigCPtr, this, StringProfileMap.getCPtr(stringProfileMap), stringProfileMap);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public SWIGTYPE_p_std__string getKey(int i) {
        long MapParserStringProfile_getKey = internalJNI.MapParserStringProfile_getKey(this.swigCPtr, this, i);
        if (MapParserStringProfile_getKey == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__string(MapParserStringProfile_getKey, false);
    }

    public StrVec getKeys() {
        long MapParserStringProfile_keys_get = internalJNI.MapParserStringProfile_keys_get(this.swigCPtr, this);
        if (MapParserStringProfile_keys_get == 0) {
            return null;
        }
        return new StrVec(MapParserStringProfile_keys_get, false);
    }

    public FriendProfile getValue(StringProfileMap stringProfileMap, int i) {
        long MapParserStringProfile_getValue = internalJNI.MapParserStringProfile_getValue(this.swigCPtr, this, StringProfileMap.getCPtr(stringProfileMap), stringProfileMap, i);
        if (MapParserStringProfile_getValue == 0) {
            return null;
        }
        return new FriendProfile(MapParserStringProfile_getValue, false);
    }

    public void setKeys(StrVec strVec) {
        internalJNI.MapParserStringProfile_keys_set(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec);
    }
}
