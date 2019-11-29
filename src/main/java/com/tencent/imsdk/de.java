package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;

final class de extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ QualityReportHelper f30863a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManager f30864b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    de(TIMGroupManager tIMGroupManager, TIMCallBack tIMCallBack, QualityReportHelper qualityReportHelper) {
        super(tIMCallBack);
        this.f30864b = tIMGroupManager;
        this.f30863a = qualityReportHelper;
    }

    public final void onDone() {
        QLog.i("MSF.C.TIMGroupManager", 1, "JoinGroup|3-Callback|Succ|code=0");
        this.cb.onSuccess();
        this.f30863a.init(0, "");
        this.f30863a.report();
    }

    public final void onFail(int i, String str) {
        QLog.i("MSF.C.TIMGroupManager", 1, "JoinGroup|3-Callback|Succ|code=" + i + ", msg=" + str);
        this.cb.onError(i, str);
        this.f30863a.init(i, str);
        this.f30863a.report();
    }
}
