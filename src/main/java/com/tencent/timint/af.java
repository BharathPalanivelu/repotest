package com.tencent.timint;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.IMFunc;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.quality_report;

final class af implements TIMValueCallBack<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMCallBack f32502a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ quality_report.ReqBody f32503b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMIntManager f32504c;

    af(TIMIntManager tIMIntManager, TIMCallBack tIMCallBack, quality_report.ReqBody reqBody) {
        this.f32504c = tIMIntManager;
        this.f32502a = tIMCallBack;
        this.f32503b = reqBody;
    }

    public final void onError(int i, String str) {
        QLog.d("MSF.C.TIMIntManager", 1, "request faild! code: " + i + " desc: " + str);
        this.f32502a.onError(i, str);
        this.f32504c.storeQualityReportToLocal(this.f32503b);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        byte[] bArr = (byte[]) obj;
        quality_report.RspBody rspBody = new quality_report.RspBody();
        try {
            rspBody.mergeFrom(bArr);
        } catch (Throwable th) {
            QLog.e("MSF.C.TIMIntManager", 1, IMFunc.getExceptionInfo(th));
            QLog.d("MSF.C.TIMIntManager", 1, "parse quality_report svr rsp failed");
            this.f32502a.onError(BaseConstants.ERR_PARSE_RESPONSE_FAILED, "parse rsp failed");
        }
        if (rspBody.uint32_result.get() != 0) {
            this.f32502a.onError(rspBody.uint32_result.get(), rspBody.str_err_msg.get());
        } else {
            this.f32502a.onSuccess();
        }
        this.f32504c.resendLocalQualityReport("AVQualityReportSvc.C2S");
    }
}
