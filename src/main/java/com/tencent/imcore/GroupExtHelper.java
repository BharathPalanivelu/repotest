package com.tencent.imcore;

public class GroupExtHelper {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupExtHelper() {
        this(internalGroupExtJNI.new_GroupExtHelper(), true);
    }

    protected GroupExtHelper(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupExtHelper groupExtHelper) {
        if (groupExtHelper == null) {
            return 0;
        }
        return groupExtHelper.swigCPtr;
    }

    public static GroupManagerExt getGroupManagerExt(String str) {
        long GroupExtHelper_getGroupManagerExt__SWIG_1 = internalGroupExtJNI.GroupExtHelper_getGroupManagerExt__SWIG_1(str);
        if (GroupExtHelper_getGroupManagerExt__SWIG_1 == 0) {
            return null;
        }
        return new GroupManagerExt(GroupExtHelper_getGroupManagerExt__SWIG_1, false);
    }

    public static SWIGTYPE_p_void getGroupManagerExt(String str, IGroupNotify iGroupNotify) {
        long GroupExtHelper_getGroupManagerExt__SWIG_0 = internalGroupExtJNI.GroupExtHelper_getGroupManagerExt__SWIG_0(str, IGroupNotify.getCPtr(iGroupNotify), iGroupNotify);
        if (GroupExtHelper_getGroupManagerExt__SWIG_0 == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(GroupExtHelper_getGroupManagerExt__SWIG_0, false);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupExtHelper(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }
}
