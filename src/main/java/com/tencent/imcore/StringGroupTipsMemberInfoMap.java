package com.tencent.imcore;

public class StringGroupTipsMemberInfoMap {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public StringGroupTipsMemberInfoMap() {
        this(internalJNI.new_StringGroupTipsMemberInfoMap__SWIG_0(), true);
    }

    protected StringGroupTipsMemberInfoMap(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public StringGroupTipsMemberInfoMap(StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap) {
        this(internalJNI.new_StringGroupTipsMemberInfoMap__SWIG_1(getCPtr(stringGroupTipsMemberInfoMap), stringGroupTipsMemberInfoMap), true);
    }

    protected static long getCPtr(StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap) {
        if (stringGroupTipsMemberInfoMap == null) {
            return 0;
        }
        return stringGroupTipsMemberInfoMap.swigCPtr;
    }

    public void clear() {
        internalJNI.StringGroupTipsMemberInfoMap_clear(this.swigCPtr, this);
    }

    public void del(String str) {
        internalJNI.StringGroupTipsMemberInfoMap_del(this.swigCPtr, this, str);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_StringGroupTipsMemberInfoMap(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean empty() {
        return internalJNI.StringGroupTipsMemberInfoMap_empty(this.swigCPtr, this);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public GroupTipsMemberInfo get(String str) {
        return new GroupTipsMemberInfo(internalJNI.StringGroupTipsMemberInfoMap_get(this.swigCPtr, this, str), false);
    }

    public boolean hasKey(String str) {
        return internalJNI.StringGroupTipsMemberInfoMap_hasKey(this.swigCPtr, this, str);
    }

    public void set(String str, GroupTipsMemberInfo groupTipsMemberInfo) {
        internalJNI.StringGroupTipsMemberInfoMap_set(this.swigCPtr, this, str, GroupTipsMemberInfo.getCPtr(groupTipsMemberInfo), groupTipsMemberInfo);
    }

    public long size() {
        return internalJNI.StringGroupTipsMemberInfoMap_size(this.swigCPtr, this);
    }
}
