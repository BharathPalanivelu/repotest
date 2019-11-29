package com.tencent.imcore;

public class DeviceId {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DeviceId() {
        this(internalJNI.new_DeviceId(), true);
    }

    protected DeviceId(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DeviceId deviceId) {
        if (deviceId == null) {
            return 0;
        }
        return deviceId.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_DeviceId(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public byte[] getAndroid_id() {
        return internalJNI.DeviceId_android_id_get(this.swigCPtr, this);
    }

    public byte[] getImei() {
        return internalJNI.DeviceId_imei_get(this.swigCPtr, this);
    }

    public byte[] getMac_md5() {
        return internalJNI.DeviceId_mac_md5_get(this.swigCPtr, this);
    }

    public byte[] getSimulate_idfa() {
        return internalJNI.DeviceId_simulate_idfa_get(this.swigCPtr, this);
    }

    public void setAndroid_id(byte[] bArr) {
        internalJNI.DeviceId_android_id_set(this.swigCPtr, this, bArr);
    }

    public void setImei(byte[] bArr) {
        internalJNI.DeviceId_imei_set(this.swigCPtr, this, bArr);
    }

    public void setMac_md5(byte[] bArr) {
        internalJNI.DeviceId_mac_md5_set(this.swigCPtr, this, bArr);
    }

    public void setSimulate_idfa(byte[] bArr) {
        internalJNI.DeviceId_simulate_idfa_set(this.swigCPtr, this, bArr);
    }
}
