package com.tencent.imsdk;

import com.tencent.imcore.EnvRequestClosure;
import com.tencent.imsdk.log.QLog;

final class ac implements TIMValueCallBack<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ EnvRequestClosure f30682a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30683b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMCoreAndroidEnv f30684c;

    ac(IMCoreAndroidEnv iMCoreAndroidEnv, EnvRequestClosure envRequestClosure, String str) {
        this.f30684c = iMCoreAndroidEnv;
        this.f30682a = envRequestClosure;
        this.f30683b = str;
    }

    public final void onError(int i, String str) {
        if (6206 == i) {
            IMMsfCoreProxy.get().notifyOnUsersigExpired(this.f30683b);
        }
        if (str == null) {
            str = "";
        }
        try {
            this.f30682a.fail(i, str);
        } catch (Throwable th) {
            QLog.e(IMCoreAndroidEnv.logTag, 1, IMFunc.getExceptionInfo(th));
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.f30682a.done((byte[]) obj);
        } catch (Throwable th) {
            QLog.e(IMCoreAndroidEnv.logTag, 1, IMFunc.getExceptionInfo(th));
        }
    }
}
