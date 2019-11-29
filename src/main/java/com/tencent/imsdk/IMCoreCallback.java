package com.tencent.imsdk;

import com.tencent.imcore.INotifyCallback;

public abstract class IMCoreCallback extends INotifyCallback {
    public TIMCallBack cb;

    public IMCoreCallback(TIMCallBack tIMCallBack) {
        swigReleaseOwnership();
        this.cb = tIMCallBack;
    }

    public void done() {
        IMMsfCoreProxy.mainHandler.post(new ai(this));
        swigTakeOwnership();
    }

    public void fail(int i, String str) {
        IMMsfCoreProxy.mainHandler.post(new aj(this, i, str));
        swigTakeOwnership();
    }

    public abstract void onDone();

    public abstract void onFail(int i, String str);
}
