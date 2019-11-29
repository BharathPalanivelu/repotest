package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.common;
import com.tencent.imsdk.protocol.stat_settoken;
import com.tencent.imsdk.utils.QualityReportHelper;

final class bf implements TIMValueCallBack<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TIMCallBack f30754a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ QualityReportHelper f30755b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30756c;

    bf(IMMsfCoreProxy iMMsfCoreProxy, TIMCallBack tIMCallBack, QualityReportHelper qualityReportHelper) {
        this.f30756c = iMMsfCoreProxy;
        this.f30754a = tIMCallBack;
        this.f30755b = qualityReportHelper;
    }

    public final void onError(int i, String str) {
        QLog.e("imsdk.IMMsfCoreProxy", 1, "settoken request failed, code: " + i + "|desc: " + str);
        IMMsfCoreProxy.mainHandler.post(new bg(this, i, str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        byte[] bArr = (byte[]) obj;
        stat_settoken.RspBody rspBody = new stat_settoken.RspBody();
        try {
            rspBody.mergeFrom(bArr);
            if (rspBody.enum_cmd_error_code.has()) {
                int i = ((common.CmdErrorCode) rspBody.enum_cmd_error_code.get()).uint32_code.get();
                if (i != 0) {
                    String stringUtf8 = ((common.CmdErrorCode) rspBody.enum_cmd_error_code.get()).bytes_err_msg.get().toStringUtf8();
                    QLog.e("imsdk.IMMsfCoreProxy", 1, "settoken failed, code: " + i + "|desc: " + stringUtf8);
                    this.f30755b.init(i, stringUtf8);
                    this.f30755b.report();
                    IMMsfCoreProxy.mainHandler.post(new bi(this, i, stringUtf8));
                    return;
                }
            }
            QLog.i("imsdk.IMMsfCoreProxy", 1, "settoken succ");
            this.f30755b.init(0, "");
            this.f30755b.report();
            IMMsfCoreProxy.mainHandler.post(new bj(this));
        } catch (Throwable th) {
            IMErrInfo iMErrInfo = new IMErrInfo(BaseConstants.ERR_PARSE_RESPONSE_FAILED, "setToken failed, parse response failed, " + IMFunc.getExceptionInfo(th));
            QLog.e("imsdk.IMMsfCoreProxy", 1, iMErrInfo.getMsg());
            this.f30755b.init(iMErrInfo.getCode(), iMErrInfo.getMsg());
            this.f30755b.report();
            QLog.e("imsdk.IMMsfCoreProxy", 1, iMErrInfo.getMsg());
            IMMsfCoreProxy.mainHandler.post(new bh(this, iMErrInfo));
        }
    }
}
