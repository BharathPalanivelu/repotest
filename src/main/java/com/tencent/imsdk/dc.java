package com.tencent.imsdk;

import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.utils.QualityReportHelper;

final class dc extends TIMGroupManager.aa {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ QualityReportHelper f30860b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMGroupManager f30861c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    dc(TIMGroupManager tIMGroupManager, TIMValueCallBack tIMValueCallBack, QualityReportHelper qualityReportHelper) {
        super(tIMValueCallBack);
        this.f30861c = tIMGroupManager;
        this.f30860b = qualityReportHelper;
    }

    public final void a(int i, String str) {
        this.f30673a.onError(i, str);
        this.f30860b.init(i, str);
        this.f30860b.report();
    }

    public final void a(String str) {
        this.f30673a.onSuccess(str);
        this.f30860b.init(0, "");
        this.f30860b.report();
    }
}
