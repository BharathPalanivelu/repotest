package com.tencent.imcore;

public class IMCoreUser {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected IMCoreUser(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(IMCoreUser iMCoreUser) {
        if (iMCoreUser == null) {
            return 0;
        }
        return iMCoreUser.swigCPtr;
    }

    public int applyDownloadFile(ApplyDownloadFileReq applyDownloadFileReq, IApplyDownloadFileCallback iApplyDownloadFileCallback) {
        return internalJNI.IMCoreUser_applyDownloadFile(this.swigCPtr, this, ApplyDownloadFileReq.getCPtr(applyDownloadFileReq), applyDownloadFileReq, IApplyDownloadFileCallback.getCPtr(iApplyDownloadFileCallback), iApplyDownloadFileCallback);
    }

    public int cancelAllPicupTask() {
        return internalJNI.IMCoreUser_cancelAllPicupTask(this.swigCPtr, this);
    }

    public void cancelTask(long j) {
        internalJNI.IMCoreUser_cancelTask(this.swigCPtr, this, j);
    }

    public int compressPic(String str, String str2, int i) {
        return internalJNI.IMCoreUser_compressPic(this.swigCPtr, this, str, str2, i);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_IMCoreUser(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean fake() {
        return internalJNI.IMCoreUser_fake(this.swigCPtr, this);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public FriendshipManager getFriendshipMgr() {
        return new FriendshipManager(internalJNI.IMCoreUser_getFriendshipMgr(this.swigCPtr, this), false);
    }

    public GroupManager getGroupMgr() {
        return new GroupManager(internalJNI.IMCoreUser_getGroupMgr(this.swigCPtr, this), false);
    }

    public int getImageUploadProgrss(long j) {
        return internalJNI.IMCoreUser_getImageUploadProgrss(this.swigCPtr, this, j);
    }

    public FriendProfile getSelfProfile() {
        long IMCoreUser_getSelfProfile = internalJNI.IMCoreUser_getSelfProfile(this.swigCPtr, this);
        if (IMCoreUser_getSelfProfile == 0) {
            return null;
        }
        return new FriendProfile(IMCoreUser_getSelfProfile, false);
    }

    public Session getSession(SessionType sessionType, String str) {
        return new Session(internalJNI.IMCoreUser_getSession(this.swigCPtr, this, sessionType.swigValue(), str), true);
    }

    public boolean httpRequest(HttpMethod httpMethod, String str, byte[] bArr, EnvRequestClosure envRequestClosure) {
        return internalJNI.IMCoreUser_httpRequest(this.swigCPtr, this, httpMethod.swigValue(), str, bArr, EnvRequestClosure.getCPtr(envRequestClosure), envRequestClosure);
    }

    public void loginSync() {
        internalJNI.IMCoreUser_loginSync(this.swigCPtr, this);
    }

    public int manualPush(byte[] bArr) {
        return internalJNI.IMCoreUser_manualPush(this.swigCPtr, this, bArr);
    }

    public boolean runOnIOThread(SWIGTYPE_p_std__functionT_void_fF_t sWIGTYPE_p_std__functionT_void_fF_t) {
        return internalJNI.IMCoreUser_runOnIOThread(this.swigCPtr, this, SWIGTYPE_p_std__functionT_void_fF_t.getCPtr(sWIGTYPE_p_std__functionT_void_fF_t));
    }

    public boolean runOnMainThread(SWIGTYPE_p_std__functionT_void_fF_t sWIGTYPE_p_std__functionT_void_fF_t) {
        return internalJNI.IMCoreUser_runOnMainThread(this.swigCPtr, this, SWIGTYPE_p_std__functionT_void_fF_t.getCPtr(sWIGTYPE_p_std__functionT_void_fF_t));
    }

    public boolean runOnTaskThread(SWIGTYPE_p_std__functionT_void_fF_t sWIGTYPE_p_std__functionT_void_fF_t) {
        return internalJNI.IMCoreUser_runOnTaskThread(this.swigCPtr, this, SWIGTYPE_p_std__functionT_void_fF_t.getCPtr(sWIGTYPE_p_std__functionT_void_fF_t));
    }

    public boolean sSORequest(String str, byte[] bArr, EnvRequestClosure envRequestClosure) {
        return internalJNI.IMCoreUser_sSORequest__SWIG_1(this.swigCPtr, this, str, bArr, EnvRequestClosure.getCPtr(envRequestClosure), envRequestClosure);
    }

    public boolean sSORequest(String str, byte[] bArr, EnvRequestClosure envRequestClosure, long j) {
        return internalJNI.IMCoreUser_sSORequest__SWIG_0(this.swigCPtr, this, str, bArr, EnvRequestClosure.getCPtr(envRequestClosure), envRequestClosure, j);
    }

    public void saveSelfProfile(FriendProfile friendProfile) {
        internalJNI.IMCoreUser_saveSelfProfile(this.swigCPtr, this, FriendProfile.getCPtr(friendProfile), friendProfile);
    }

    public long submitUploadTask(String str, IImageUploadCallback iImageUploadCallback) {
        return internalJNI.IMCoreUser_submitUploadTask__SWIG_1(this.swigCPtr, this, str, IImageUploadCallback.getCPtr(iImageUploadCallback), iImageUploadCallback);
    }

    public long submitUploadTask(String str, IImageUploadCallback iImageUploadCallback, int i) {
        return internalJNI.IMCoreUser_submitUploadTask__SWIG_0(this.swigCPtr, this, str, IImageUploadCallback.getCPtr(iImageUploadCallback), iImageUploadCallback, i);
    }
}
