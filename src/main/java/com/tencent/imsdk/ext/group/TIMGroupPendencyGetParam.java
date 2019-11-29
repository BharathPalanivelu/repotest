package com.tencent.imsdk.ext.group;

import com.tencent.imcore.GetGroupPendencyOption;

public class TIMGroupPendencyGetParam {
    private long numPerPage;
    private long timestamp;

    /* access modifiers changed from: package-private */
    public GetGroupPendencyOption convertTo() {
        GetGroupPendencyOption getGroupPendencyOption = new GetGroupPendencyOption();
        getGroupPendencyOption.setStart_time(this.timestamp);
        getGroupPendencyOption.setMax_limited(this.numPerPage);
        return getGroupPendencyOption;
    }

    /* access modifiers changed from: package-private */
    public long getNumPerPage() {
        return this.numPerPage;
    }

    /* access modifiers changed from: package-private */
    public long getTimestamp() {
        return this.timestamp;
    }

    public TIMGroupPendencyGetParam setNumPerPage(long j) {
        this.numPerPage = j;
        return this;
    }

    public TIMGroupPendencyGetParam setTimestamp(long j) {
        if (j < 0) {
            j = 0;
        }
        this.timestamp = j;
        return this;
    }
}
