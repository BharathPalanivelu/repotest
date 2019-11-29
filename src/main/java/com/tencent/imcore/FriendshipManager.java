package com.tencent.imcore;

public class FriendshipManager {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected FriendshipManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public FriendshipManager(String str) {
        this(internalJNI.new_FriendshipManager(str), true);
    }

    protected static long getCPtr(FriendshipManager friendshipManager) {
        if (friendshipManager == null) {
            return 0;
        }
        return friendshipManager.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_FriendshipManager(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public SWIGTYPE_p_void getInitTask() {
        long FriendshipManager_getInitTask = internalJNI.FriendshipManager_getInitTask(this.swigCPtr, this);
        if (FriendshipManager_getInitTask == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(FriendshipManager_getInitTask, false);
    }

    public boolean getProfile(StrVec strVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalJNI.FriendshipManager_getProfile(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public SWIGTYPE_p_void getSyncTask() {
        long FriendshipManager_getSyncTask = internalJNI.FriendshipManager_getSyncTask(this.swigCPtr, this);
        if (FriendshipManager_getSyncTask == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(FriendshipManager_getSyncTask, false);
    }

    public void registerMsgEvent(SWIGTYPE_p_imcore__MsgManager sWIGTYPE_p_imcore__MsgManager) {
        internalJNI.FriendshipManager_registerMsgEvent(this.swigCPtr, this, SWIGTYPE_p_imcore__MsgManager.getCPtr(sWIGTYPE_p_imcore__MsgManager));
    }

    public boolean setProfile(SetProfileOption setProfileOption, INotifyCallback iNotifyCallback) {
        return internalJNI.FriendshipManager_setProfile(this.swigCPtr, this, SetProfileOption.getCPtr(setProfileOption), setProfileOption, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }
}
