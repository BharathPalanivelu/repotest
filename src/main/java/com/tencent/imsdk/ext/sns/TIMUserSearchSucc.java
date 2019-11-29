package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMUserProfile;
import java.util.List;

public class TIMUserSearchSucc {
    List<TIMUserProfile> infoList;
    long totalNum;

    public List<TIMUserProfile> getInfoList() {
        return this.infoList;
    }

    public long getTotalNum() {
        return this.totalNum;
    }
}
