package com.tencent.imsdk.utils;

import android.text.TextUtils;
import com.tencent.imcore.DeviceId;
import com.tencent.imcore.IMCore;
import com.tencent.imcore.SdkReportItem;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.log.QLog;
import java.io.UnsupportedEncodingException;

public class QualityReportHelper {
    private static final String tag = "imsdk.QualityReportHelper";
    private int code;
    private String descr;
    private int eventId;
    private long startTime;

    public QualityReportHelper() {
        this.code = 0;
        this.descr = "";
        this.startTime = 0;
        this.startTime = System.currentTimeMillis();
    }

    public QualityReportHelper(int i) {
        this.code = 0;
        this.descr = "";
        this.startTime = 0;
        this.eventId = i;
        this.startTime = System.currentTimeMillis();
    }

    public int getCode() {
        return this.code;
    }

    public String getDescr() {
        return this.descr;
    }

    public int getEventId() {
        return this.eventId;
    }

    public void init(int i, int i2, String str) {
        this.eventId = i;
        this.code = i2;
        if (!TextUtils.isEmpty(str)) {
            this.descr = str;
        }
    }

    public void init(int i, String str) {
        this.code = i;
        if (!TextUtils.isEmpty(str)) {
            this.descr = str;
        }
    }

    public void report() {
        try {
            if (IMMsfCoreProxy.get().getMode() == 1) {
                SdkReportItem sdkReportItem = new SdkReportItem();
                sdkReportItem.setEvent(this.eventId);
                sdkReportItem.setCode(this.code);
                sdkReportItem.setDesc(this.descr.getBytes("utf-8"));
                sdkReportItem.setStart_time_ms(this.startTime);
                sdkReportItem.setEnd_time_ms(System.currentTimeMillis());
                IMCore.get().qrReportEvent(sdkReportItem);
                return;
            }
            QLog.w(tag, 1, "ignore reportQrEvent event:" + this.eventId + "|code:" + this.code + "|descr:" + this.descr);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            QLog.e(tag, 1, QLog.getStackTraceString(th));
        }
    }

    public void reportDeviceID() {
        try {
            if (IMMsfCoreProxy.get().getMode() == 1) {
                DeviceId deviceId = new DeviceId();
                deviceId.setAndroid_id(IMMsfCoreProxy.get().getAndroidId().getBytes("utf-8"));
                deviceId.setImei(IMMsfCoreProxy.get().getIMEI().getBytes("utf-8"));
                deviceId.setMac_md5(IMMsfCoreProxy.get().getMacAddress().getBytes("utf-8"));
                IMCore.get().qrReportDeviceId(deviceId);
            }
        } catch (Throwable th) {
            QLog.e(tag, 1, QLog.getStackTraceString(th));
        }
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setDescr(String str) {
        this.descr = str;
    }

    public void setEventId(int i) {
        this.eventId = i;
    }
}
