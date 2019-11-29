package com.tencent.imsdk.ext.message;

import com.tencent.imcore.IBatchOprCallback;

public class IMCoreBatchOprCallback extends IBatchOprCallback {
    TIMSendMsgToMultiUserCallback cb;

    public IMCoreBatchOprCallback(TIMSendMsgToMultiUserCallback tIMSendMsgToMultiUserCallback) {
        this.cb = tIMSendMsgToMultiUserCallback;
        swigReleaseOwnership();
    }

    public void done() {
        TIMSendMsgToMultiUserCallback tIMSendMsgToMultiUserCallback = this.cb;
        if (tIMSendMsgToMultiUserCallback != null) {
            tIMSendMsgToMultiUserCallback.onSuccess();
        }
        swigTakeOwnership();
    }

    public void fail(int i, String str, IBatchOprCallback.BatchOprDetailInfo batchOprDetailInfo) {
        if (this.cb != null) {
            this.cb.onError(i, str, new TIMBatchOprDetailInfo(batchOprDetailInfo));
        }
        swigTakeOwnership();
    }
}
