package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudProgressListener;

public interface ProgressBody {
    long getBytesTransferred();

    void setProgressListener(QCloudProgressListener qCloudProgressListener);
}
