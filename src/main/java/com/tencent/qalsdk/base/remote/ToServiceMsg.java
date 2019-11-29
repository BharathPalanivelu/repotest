package com.tencent.qalsdk.base.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.util.QLog;
import java.util.HashMap;

public class ToServiceMsg implements Parcelable {
    public static final Parcelable.Creator<ToServiceMsg> CREATOR = new c();
    private static final String tag = "ToServiceMsg";
    private static final String version = "version";
    private int appId;
    private int appSeq = -1;
    private HashMap<String, Object> attributes = new HashMap<>();
    public Bundle extraData = new Bundle();
    private boolean httpReq = false;
    private MsfCommand msfCommand = MsfCommand.unknown;
    private boolean needResp = true;
    private long sendTimeout = -1;
    private String serviceCmd = "";
    private String serviceName;
    private int ssoSeq = -1;
    private long timeout = -1;
    private byte toVersion = 1;
    private String uin;
    private byte uinType = 20;
    private byte[] wupBuffer = new byte[0];

    public int describeContents() {
        return 0;
    }

    public ToServiceMsg(String str, String str2, String str3) {
        this.serviceName = str;
        this.uin = str2;
        this.serviceCmd = str3;
        this.extraData.putByte("version", this.toVersion);
    }

    public ToServiceMsg(Parcel parcel) {
        readFromParcel(parcel);
    }

    public String toString() {
        return "ToServiceMsg msName:" + this.msfCommand + " ssoSeq:" + getRequestSsoSeq() + " appId:" + this.appId + " appSeq:" + this.appSeq + " sName:" + this.serviceName + " uin:" + this.uin + " sCmd:" + this.serviceCmd + " t:" + this.timeout + " needResp:" + this.needResp + "httpReq:" + this.httpReq;
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.appId);
            parcel.writeInt(this.appSeq);
            parcel.writeString(this.serviceName);
            parcel.writeString(this.uin);
            parcel.writeByte(this.uinType);
            parcel.writeString(this.serviceCmd);
            parcel.writeLong(this.timeout);
            parcel.writeBundle(this.extraData);
            if (this.toVersion > 0) {
                parcel.writeSerializable(this.msfCommand);
                parcel.writeLong(this.sendTimeout);
                byte b2 = 0;
                parcel.writeByte(this.needResp ? (byte) 1 : 0);
                if (this.httpReq) {
                    b2 = 1;
                }
                parcel.writeByte(b2);
                parcel.writeInt(this.wupBuffer.length);
                parcel.writeByteArray(this.wupBuffer);
                parcel.writeInt(this.ssoSeq);
                parcel.writeMap(this.attributes);
            }
        } catch (Throwable th) {
            QLog.e(tag, 1, "writeToParcel Throwable: " + th);
        }
    }

    private void readFromParcel(Parcel parcel) {
        try {
            this.appId = parcel.readInt();
            this.appSeq = parcel.readInt();
            this.serviceName = parcel.readString();
            this.uin = parcel.readString();
            this.uinType = parcel.readByte();
            this.serviceCmd = parcel.readString();
            this.timeout = parcel.readLong();
            this.extraData.clear();
            this.extraData.putAll(parcel.readBundle(Thread.currentThread().getContextClassLoader()));
            this.toVersion = this.extraData.getByte("version");
            if (this.toVersion > 0) {
                this.msfCommand = (MsfCommand) parcel.readSerializable();
                this.sendTimeout = parcel.readLong();
                boolean z = false;
                this.needResp = parcel.readByte() != 0;
                if (parcel.readByte() != 0) {
                    z = true;
                }
                this.httpReq = z;
                this.wupBuffer = new byte[parcel.readInt()];
                parcel.readByteArray(this.wupBuffer);
                this.ssoSeq = parcel.readInt();
                this.attributes.clear();
                parcel.readMap(this.attributes, ToServiceMsg.class.getClassLoader());
            }
        } catch (Throwable th) {
            QLog.e(tag, 1, "readFromParcel Throwable: " + th);
        }
    }

    public byte[] getWupBuffer() {
        return this.wupBuffer;
    }

    public void putWupBuffer(byte[] bArr) {
        this.wupBuffer = bArr;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public void setTimeout(long j) {
        this.timeout = j;
    }

    public String getDestServiceId() {
        return this.serviceName;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public String getUin() {
        return this.uin;
    }

    public void setUin(String str) {
        this.uin = str;
    }

    public String getServiceCmd() {
        return this.serviceCmd;
    }

    public void setServiceCmd(String str) {
        this.serviceCmd = str;
    }

    public boolean isNeedCallback() {
        return this.needResp;
    }

    public void setNeedCallback(boolean z) {
        this.needResp = z;
    }

    public boolean isHttpReq() {
        return this.httpReq;
    }

    public void setIsHttpReq() {
        this.httpReq = true;
    }

    public int getAppId() {
        return this.appId;
    }

    public void setAppId(int i) {
        this.appId = i;
    }

    public int getAppSeq() {
        return this.appSeq;
    }

    public void setAppSeq(int i) {
        this.appSeq = i;
    }

    public int getRequestSsoSeq() {
        return this.ssoSeq;
    }

    public void setRequestSsoSeq(int i) {
        this.ssoSeq = i;
    }

    public Object addAttribute(String str, Object obj) {
        return this.attributes.put(str, obj);
    }

    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    public <T> T getAttribute(String str, T t) {
        if (!this.attributes.containsKey(str)) {
            return t;
        }
        return this.attributes.get(str);
    }

    public HashMap<String, Object> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(HashMap<String, Object> hashMap) {
        this.attributes = hashMap;
    }

    public MsfCommand getMsfCommand() {
        return this.msfCommand;
    }

    public void setMsfCommand(MsfCommand msfCommand2) {
        this.msfCommand = msfCommand2;
    }

    public void setEnableFastResend(boolean z) {
        addAttribute("fastresend", Boolean.valueOf(z));
    }

    public boolean isFastResendEnabled() {
        return ((Boolean) getAttribute("fastresend", false)).booleanValue();
    }

    public boolean isNeedRemindSlowNetwork() {
        return ((Boolean) getAttribute("remind_slown_network", false)).booleanValue();
    }

    public void setNeedRemindSlowNetwork(boolean z) {
        addAttribute("remind_slown_network", Boolean.valueOf(z));
    }

    public byte getUinType() {
        return this.uinType;
    }

    public void setUinType(int i) {
        this.uinType = (byte) i;
    }
}
