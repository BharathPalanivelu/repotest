package com.tencent.imsdk;

import java.util.ArrayList;
import java.util.List;

public class TIMSNSSystemElem extends TIMElem {
    private long decideReportTimestamp;
    private List<TIMSNSChangeInfo> infoList = new ArrayList();
    private long pendencyReportTimestamp;
    private long recommendReportTimestamp;
    private TIMSNSSystemType subType;

    public TIMSNSSystemElem() {
        this.type = TIMElemType.SNSTips;
    }

    public List<TIMSNSChangeInfo> getChangeInfoList() {
        return this.infoList;
    }

    public long getDecideReportTimestamp() {
        return this.decideReportTimestamp;
    }

    public long getPendencyReportTimestamp() {
        return this.pendencyReportTimestamp;
    }

    public long getRecommendReportTimestamp() {
        return this.recommendReportTimestamp;
    }

    public TIMSNSSystemType getSubType() {
        return this.subType;
    }

    /* access modifiers changed from: package-private */
    public void setDecideReportTimestamp(long j) {
        this.decideReportTimestamp = j;
    }

    /* access modifiers changed from: package-private */
    public void setPendencyReportTimestamp(long j) {
        this.pendencyReportTimestamp = j;
    }

    /* access modifiers changed from: package-private */
    public void setRecommendReportTimestamp(long j) {
        this.recommendReportTimestamp = j;
    }

    /* access modifiers changed from: package-private */
    public void setSubType(long j) {
        this.subType = TIMSNSSystemType.getType((int) j);
    }
}
