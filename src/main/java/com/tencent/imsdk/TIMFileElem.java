package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imcore.ApplyDownloadFileReq;
import com.tencent.imcore.QrEventType;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TIMFileElem extends TIMElem {
    private static final String tag = "TIMFileElem";
    private long businessId = 0;
    private byte[] data = null;
    private int downloadFlag = 0;
    private String fileName;
    /* access modifiers changed from: private */
    public long fileSize;
    private String path;
    private int taskId;
    private List<String> urls = new ArrayList();
    private String uuid = null;

    public TIMFileElem() {
        this.type = TIMElemType.File;
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

    /* access modifiers changed from: package-private */
    public int getDownloadFlag() {
        return this.downloadFlag;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getPath() {
        return this.path;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public void getToFile(String str, TIMCallBack tIMCallBack) {
        QualityReportHelper qualityReportHelper = new QualityReportHelper(QrEventType.kEventRecvFile.swigValue());
        if (TextUtils.isEmpty(this.uuid)) {
            tIMCallBack.onError(BaseConstants.ERR_INVALID_SDK_OBJECT, "uuid is empty");
            qualityReportHelper.init(BaseConstants.ERR_INVALID_SDK_OBJECT, "uuid is empty");
            qualityReportHelper.report();
            return;
        }
        QLog.i(tag, 1, "download file, downloadFlag: " + this.downloadFlag);
        if (this.downloadFlag == 2) {
            IMMsfCoreProxy.get().downloadToFile(this.urls, str, tIMCallBack, qualityReportHelper, this.fileSize);
            return;
        }
        cw cwVar = new cw(this, tIMCallBack, str, qualityReportHelper);
        ApplyDownloadFileReq applyDownloadFileReq = new ApplyDownloadFileReq();
        applyDownloadFileReq.setBusiId(this.businessId);
        applyDownloadFileReq.setDownloadFlag((long) this.downloadFlag);
        applyDownloadFileReq.setType(1);
        applyDownloadFileReq.setUuid(this.uuid);
        TIMManager.getInstanceById(this.identifier).getCoreUser().applyDownloadFile(applyDownloadFileReq, cwVar);
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
    public void setDownloadFlag(int i) {
        this.downloadFlag = i;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    /* access modifiers changed from: package-private */
    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.path = str;
            this.fileSize = new File(str).length();
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
