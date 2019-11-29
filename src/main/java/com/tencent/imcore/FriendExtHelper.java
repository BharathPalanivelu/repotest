package com.tencent.imcore;

public class FriendExtHelper {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendExtHelper() {
        this(internalSnsExtJNI.new_FriendExtHelper(), true);
    }

    protected FriendExtHelper(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendExtHelper friendExtHelper) {
        if (friendExtHelper == null) {
            return 0;
        }
        return friendExtHelper.swigCPtr;
    }

    public static FriendshipManagerExt getFriendshipManagerExt(String str) {
        long FriendExtHelper_getFriendshipManagerExt__SWIG_1 = internalSnsExtJNI.FriendExtHelper_getFriendshipManagerExt__SWIG_1(str);
        if (FriendExtHelper_getFriendshipManagerExt__SWIG_1 == 0) {
            return null;
        }
        return new FriendshipManagerExt(FriendExtHelper_getFriendshipManagerExt__SWIG_1, false);
    }

    public static SWIGTYPE_p_void getFriendshipManagerExt(String str, IFriendshipNotify iFriendshipNotify) {
        long FriendExtHelper_getFriendshipManagerExt__SWIG_0 = internalSnsExtJNI.FriendExtHelper_getFriendshipManagerExt__SWIG_0(str, IFriendshipNotify.getCPtr(iFriendshipNotify), iFriendshipNotify);
        if (FriendExtHelper_getFriendshipManagerExt__SWIG_0 == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(FriendExtHelper_getFriendshipManagerExt__SWIG_0, false);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendExtHelper(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }
}
