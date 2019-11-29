package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imcore.ApplyDownloadFileReq;
import com.tencent.imcore.QrEventType;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TIMSoundElem extends TIMElem {
    private static final String tag = "TIMSoundElem";
    private long businessId = 0;
    private byte[] data = null;
    private long dataSize = 0;
    private int downloadFlag = 0;
    private long duration = 0;
    private String path = "";
    private int taskId;
    private List<String> urls = new ArrayList();
    private String uuid = null;

    public TIMSoundElem() {
        this.type = TIMElemType.Sound;
    }

    /* access modifiers changed from: package-private */
    public void addUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.urls.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public long getBusinessId() {
        return this.businessId;
    }

    public long getDataSize() {
        return this.dataSize;
    }

    /* access modifiers changed from: package-private */
    public int getDownloadFlag() {
        return this.downloadFlag;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getPath() {
        return this.path;
    }

    public void getSoundToFile(String str, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            QualityReportHelper qualityReportHelper = new QualityReportHelper(QrEventType.kEventRecvAudio.swigValue());
            if (TextUtils.isEmpty(this.uuid)) {
                tIMCallBack.onError(BaseConstants.ERR_INVALID_SDK_OBJECT, "uuid is empty");
                qualityReportHelper.init(BaseConstants.ERR_INVALID_SDK_OBJECT, "uuid is empty");
                qualityReportHelper.report();
                return;
            }
            QLog.i(tag, 1, "download sound, downloadFlag: " + this.downloadFlag);
            if (this.downloadFlag == 2) {
                IMMsfCoreProxy.get().downloadToFile(this.urls, str, tIMCallBack, qualityReportHelper, getDataSize());
                return;
            }
            dm dmVar = new dm(this, tIMCallBack, str, qualityReportHelper);
            ApplyDownloadFileReq applyDownloadFileReq = new ApplyDownloadFileReq();
            applyDownloadFileReq.setBusiId(this.businessId);
            applyDownloadFileReq.setDownloadFlag((long) this.downloadFlag);
            applyDownloadFileReq.setType(3);
            applyDownloadFileReq.setUuid(this.uuid);
            TIMManager.getInstanceById(this.identifier).getCoreUser().applyDownloadFile(applyDownloadFileReq, dmVar);
        }
    }

    public int getTaskId() {
        return this.taskId;
    }

    /* access modifiers changed from: package-private */
    public List<String> getUrls() {
        return this.urls;
    }

    public String getUuid() {
        return this.uuid;
    }

    /* access modifiers changed from: package-private */
    public void setBusinessId(long j) {
        this.businessId = j;
    }

    /* access modifiers changed from: package-private */
    public void setDataSize(long j) {
        this.dataSize = j;
    }

    /* access modifiers changed from: package-private */
    public void setDownloadFlag(int i) {
        this.downloadFlag = i;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.path = str;
            this.dataSize = new File(str).length();
        }
    }

    /* access modifiers changed from: package-private */
    public void setTaskId(int i) {
        this.taskId = i;
    }

    /* access modifiers changed from: package-private */
    public void setUrls(List<String> list) {
        this.urls = list;
    }

    /* access modifiers changed from: package-private */
    public void setUuid(String str) {
        this.uuid = str;
    }
}
