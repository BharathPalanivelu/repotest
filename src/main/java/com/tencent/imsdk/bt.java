package com.tencent.imsdk;

import com.appsflyer.share.Constants;
import com.tencent.imsdk.IMFunc;
import com.tencent.imsdk.log.QLog;

final class bt implements IMFunc.RequestListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f30785a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30786b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ String f30787c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30788d;

    bt(IMMsfCoreProxy iMMsfCoreProxy, String str, String str2, String str3) {
        this.f30788d = iMMsfCoreProxy;
        this.f30785a = str;
        this.f30786b = str2;
        this.f30787c = str3;
    }

    public final void onFail(String str) {
        QLog.e("imsdk.IMMsfCoreProxy", 1, "uploadLogFile->failed: " + this.f30785a + "|" + str);
        IMMsfCoreProxy.get().logReport(this.f30786b, this.f30787c, BaseConstants.ERR_HTTP_REQ_FAILED, str);
    }

    public final void onSuccess(byte[] bArr) {
        QLog.i("imsdk.IMMsfCoreProxy", 1, "uploadLogFile->success: " + this.f30785a + Constants.URL_PATH_DELIMITER + this.f30786b);
        IMMsfCoreProxy.get().logReport(this.f30786b, this.f30787c, 0, "");
    }
}
