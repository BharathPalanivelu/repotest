package com.tencent.imcore;

public class GroupManager {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected GroupManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public GroupManager(String str) {
        this(internalJNI.new_GroupManager(str), true);
    }

    protected static long getCPtr(GroupManager groupManager) {
        if (groupManager == null) {
            return 0;
        }
        return groupManager.swigCPtr;
    }

    public static void onMsgEvent(String str, MsgVec msgVec) {
        internalJNI.GroupManager_onMsgEvent(str, MsgVec.getCPtr(msgVec), msgVec);
    }

    public boolean applyJoinGroup(String str, String str2, INotifyCallback iNotifyCallback) {
        return internalJNI.GroupManager_applyJoinGroup(this.swigCPtr, this, str, str2, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public boolean createGroup(CreateGroupParams createGroupParams, ICallbackWithString iCallbackWithString) {
        return internalJNI.GroupManager_createGroup(this.swigCPtr, this, CreateGroupParams.getCPtr(createGroupParams), createGroupParams, ICallbackWithString.getCPtr(iCallbackWithString), iCallbackWithString);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_GroupManager(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean deleteGroup(String str, INotifyCallback iNotifyCallback) {
        return internalJNI.GroupManager_deleteGroup(this.swigCPtr, this, str, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public SWIGTYPE_p_void getInitTask() {
        long GroupManager_getInitTask = internalJNI.GroupManager_getInitTask(this.swigCPtr, this);
        if (GroupManager_getInitTask == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(GroupManager_getInitTask, false);
    }

    public SWIGTYPE_p_void getSyncTask() {
        long GroupManager_getSyncTask = internalJNI.GroupManager_getSyncTask(this.swigCPtr, this);
        if (GroupManager_getSyncTask == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(GroupManager_getSyncTask, false);
    }

    public void onGroupSystemMsgEvent(GroupReportElem groupReportElem) {
        internalJNI.GroupManager_onGroupSystemMsgEvent(this.swigCPtr, this, GroupReportElem.getCPtr(groupReportElem), groupReportElem);
    }

    public boolean quitGroup(String str, INotifyCallback iNotifyCallback) {
        return internalJNI.GroupManager_quitGroup(this.swigCPtr, this, str, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public void registerMsgEvent(SWIGTYPE_p_imcore__MsgManager sWIGTYPE_p_imcore__MsgManager) {
        internalJNI.GroupManager_registerMsgEvent(this.swigCPtr, this, SWIGTYPE_p_imcore__MsgManager.getCPtr(sWIGTYPE_p_imcore__MsgManager));
    }

    public void updateGroupMsgLatestSeq(String str, INotifyCallback iNotifyCallback) {
        internalJNI.GroupManager_updateGroupMsgLatestSeq(this.swigCPtr, this, str, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }
}
