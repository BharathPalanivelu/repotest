package com.tencent.imsdk;

import com.tencent.imsdk.utils.QualityReportHelper;
import java.util.List;

final class cw extends af<TIMCallBack> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30848b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ QualityReportHelper f30849c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ TIMFileElem f30850d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cw(TIMFileElem tIMFileElem, TIMCallBack tIMCallBack, String str, QualityReportHelper qualityReportHelper) {
        super(tIMCallBack);
        this.f30850d = tIMFileElem;
        this.f30848b = str;
        this.f30849c = qualityReportHelper;
    }

    public final void a(int i, String str) {
        ((TIMCallBack) this.f30689a).onError(i, str);
        this.f30849c.init(i, str);
        this.f30849c.report();
    }

    public final void a(List<String> list) {
        List<String> list2 = list;
        IMMsfCoreProxy.get().downloadToFile(list2, this.f30848b, (TIMCallBack) this.f30689a, this.f30849c, this.f30850d.fileSize);
    }
}
