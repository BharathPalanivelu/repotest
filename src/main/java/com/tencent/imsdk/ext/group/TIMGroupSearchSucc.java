package com.tencent.imsdk.ext.group;

import java.util.List;

public class TIMGroupSearchSucc {
    List<TIMGroupDetailInfo> infoList;
    long totalNum;

    public List<TIMGroupDetailInfo> getInfoList() {
        return this.infoList;
    }

    public long getTotalNum() {
        return this.totalNum;
    }
}
