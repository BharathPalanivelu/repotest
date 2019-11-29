package com.tencent.imsdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.ApplyDownloadFileReq;
import com.tencent.imcore.QrEventType;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;
import java.util.ArrayList;
import java.util.List;

public class TIMVideo {
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final String tag = "TIMVideo";
    private long businessId = 0;
    private int downloadFlag = 0;
    private long duaration;
    private String identifier = "";
    /* access modifiers changed from: private */
    public long size;
    private String type = "";
    private List<String> urls = new ArrayList();
    private String uuid = "";

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

    public long getDuaration() {
        return this.duaration;
    }

    public long getSize() {
        return this.size;
    }

    public String getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public List<String> getUrls() {
        return this.urls;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void getVideo(String str, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            QualityReportHelper qualityReportHelper = new QualityReportHelper(QrEventType.kEventRecvVideo.swigValue());
            if (TextUtils.isEmpty(this.uuid)) {
                IMErrInfo iMErrInfo = new IMErrInfo(BaseConstants.ERR_INVALID_SDK_OBJECT, "uuid is empty");
                tIMCallBack.onError(iMErrInfo.getCode(), iMErrInfo.getMsg());
                qualityReportHelper.init(iMErrInfo.getCode(), iMErrInfo.getMsg());
                qualityReportHelper.report();
                return;
            }
            String str2 = tag;
            QLog.i(str2, 1, "download video, downloadFlag: " + this.downloadFlag);
            if (this.downloadFlag == 2) {
                IMMsfCoreProxy.get().downloadToFile(this.urls, str, tIMCallBack, qualityReportHelper, this.size);
                return;
            }
            dn dnVar = new dn(this, tIMCallBack, str, qualityReportHelper);
            ApplyDownloadFileReq applyDownloadFileReq = new ApplyDownloadFileReq();
            applyDownloadFileReq.setBusiId(this.businessId);
            applyDownloadFileReq.setDownloadFlag((long) this.downloadFlag);
            applyDownloadFileReq.setType(2);
            applyDownloadFileReq.setUuid(this.uuid);
            TIMManager.getInstanceById(this.identifier).getCoreUser().applyDownloadFile(applyDownloadFileReq, dnVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBusinessId(long j) {
        this.businessId = j;
    }

    /* access modifiers changed from: package-private */
    public void setDownloadFlag(int i) {
        this.downloadFlag = i;
    }

    public void setDuaration(long j) {
        this.duaration = j;
    }

    /* access modifiers changed from: protected */
    public void setIdentifier(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.identifier = str;
        }
    }

    /* access modifiers changed from: package-private */
    public void setSize(long j) {
        this.size = j;
    }

    public void setType(String str) {
        if (str != null) {
            this.type = str;
        }
    }

    /* access modifiers changed from: package-private */
    public void setUrls(List<String> list) {
        this.urls = list;
    }

    /* access modifiers changed from: package-private */
    public void setUuid(String str) {
        if (str != null) {
            this.uuid = str;
        }
    }
}
