package com.tencent.imcore;

public class StringProfileMap {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public StringProfileMap() {
        this(internalJNI.new_StringProfileMap__SWIG_0(), true);
    }

    protected StringProfileMap(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public StringProfileMap(StringProfileMap stringProfileMap) {
        this(internalJNI.new_StringProfileMap__SWIG_1(getCPtr(stringProfileMap), stringProfileMap), true);
    }

    protected static long getCPtr(StringProfileMap stringProfileMap) {
        if (stringProfileMap == null) {
            return 0;
        }
        return stringProfileMap.swigCPtr;
    }

    public void clear() {
        internalJNI.StringProfileMap_clear(this.swigCPtr, this);
    }

    public void del(String str) {
        internalJNI.StringProfileMap_del(this.swigCPtr, this, str);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_StringProfileMap(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean empty() {
        return internalJNI.StringProfileMap_empty(this.swigCPtr, this);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public FriendProfile get(String str) {
        return new FriendProfile(internalJNI.StringProfileMap_get(this.swigCPtr, this, str), false);
    }

    public boolean hasKey(String str) {
        return internalJNI.StringProfileMap_hasKey(this.swigCPtr, this, str);
    }

    public void set(String str, FriendProfile friendProfile) {
        internalJNI.StringProfileMap_set(this.swigCPtr, this, str, FriendProfile.getCPtr(friendProfile), friendProfile);
    }

    public long size() {
        return internalJNI.StringProfileMap_size(this.swigCPtr, this);
    }
}
