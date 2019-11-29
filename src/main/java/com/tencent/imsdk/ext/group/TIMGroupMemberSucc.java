package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMGroupMemberInfo;
import java.util.List;

public class TIMGroupMemberSucc {
    private List<TIMGroupMemberInfo> memberInfoList;
    private long nextSeq;

    public List<TIMGroupMemberInfo> getMemberInfoList() {
        return this.memberInfoList;
    }

    public long getNextSeq() {
        return this.nextSeq;
    }

    /* access modifiers changed from: package-private */
    public void setMemberInfoList(List<TIMGroupMemberInfo> list) {
        this.memberInfoList = list;
    }

    /* access modifiers changed from: package-private */
    public void setNextSeq(long j) {
        this.nextSeq = j;
    }
}
