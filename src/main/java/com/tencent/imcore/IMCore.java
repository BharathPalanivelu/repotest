package com.tencent.imcore;

public class IMCore {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected IMCore(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static IMCore get() {
        return new IMCore(internalJNI.IMCore_get(), false);
    }

    protected static long getCPtr(IMCore iMCore) {
        if (iMCore == null) {
            return 0;
        }
        return iMCore.swigCPtr;
    }

    public void clearLog(String str, long j) {
        internalJNI.IMCore_clearLog__SWIG_3(this.swigCPtr, this, str, j);
    }

    public void clearLog(String str, long j, String str2) {
        internalJNI.IMCore_clearLog__SWIG_2(this.swigCPtr, this, str, j, str2);
    }

    public void clearLog(String str, long j, String str2, long j2) {
        internalJNI.IMCore_clearLog__SWIG_1(this.swigCPtr, this, str, j, str2, j2);
    }

    public void clearLog(String str, long j, String str2, long j2, int i) {
        internalJNI.IMCore_clearLog__SWIG_0(this.swigCPtr, this, str, j, str2, j2, i);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (!this.swigCMemOwn) {
                this.swigCPtr = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
    }

    public Context getContext() {
        return new Context(internalJNI.IMCore_getContext(this.swigCPtr, this), false);
    }

    public long getTime() {
        return internalJNI.IMCore_getTime(this.swigCPtr, this);
    }

    public IMCoreUser getUser(String str) {
        long IMCore_getUser = internalJNI.IMCore_getUser(this.swigCPtr, this, str);
        if (IMCore_getUser == 0) {
            return null;
        }
        return new IMCoreUser(IMCore_getUser, true);
    }

    public String getVersion(int i) {
        return internalJNI.IMCore_getVersion(this.swigCPtr, this, i);
    }

    public boolean initOpenIM(Context context) {
        return internalJNI.IMCore_initOpenIM(this.swigCPtr, this, Context.getCPtr(context), context);
    }

    public int initUser(UserConfig userConfig, INotifyCallback iNotifyCallback) {
        return internalJNI.IMCore_initUser(this.swigCPtr, this, UserConfig.getCPtr(userConfig), userConfig, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public void lOGGERLOG(int i, String str, int i2, String str2, String str3, String str4) {
        internalJNI.IMCore_lOGGERLOG(this.swigCPtr, this, i, str, i2, str2, str3, str4);
    }

    public void qrReportDeviceId(DeviceId deviceId) {
        internalJNI.IMCore_qrReportDeviceId(this.swigCPtr, this, DeviceId.getCPtr(deviceId), deviceId);
    }

    public void qrReportEvent(SdkReportItem sdkReportItem) {
        internalJNI.IMCore_qrReportEvent(this.swigCPtr, this, SdkReportItem.getCPtr(sdkReportItem), sdkReportItem);
    }

    public void refreshA2(byte[] bArr) {
        internalJNI.IMCore_refreshA2(this.swigCPtr, this, bArr);
    }

    public void refreshSvrDiff(long j) {
        internalJNI.IMCore_refreshSvrDiff(this.swigCPtr, this, j);
    }

    public int unInitUser(String str) {
        return internalJNI.IMCore_unInitUser(this.swigCPtr, this, str);
    }

    public boolean uploadLogFile(String str, UploadLogFileOpt uploadLogFileOpt) {
        return internalJNI.IMCore_uploadLogFile(this.swigCPtr, this, str, UploadLogFileOpt.getCPtr(uploadLogFileOpt), uploadLogFileOpt);
    }
}
