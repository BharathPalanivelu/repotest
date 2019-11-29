package com.tencent.imsdk;

import com.tencent.imsdk.utils.QualityReportHelper;
import java.util.List;

final class dl extends af<TIMCallBack> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30874b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ QualityReportHelper f30875c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ TIMSnapshot f30876d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    dl(TIMSnapshot tIMSnapshot, TIMCallBack tIMCallBack, String str, QualityReportHelper qualityReportHelper) {
        super(tIMCallBack);
        this.f30876d = tIMSnapshot;
        this.f30874b = str;
        this.f30875c = qualityReportHelper;
    }

    public final void a(int i, String str) {
        ((TIMCallBack) this.f30689a).onError(i, str);
        this.f30875c.init(i, str);
        this.f30875c.report();
    }

    public final void a(List<String> list) {
        List<String> list2 = list;
        IMMsfCoreProxy.get().downloadToFile(list2, this.f30874b, (TIMCallBack) this.f30689a, this.f30875c, this.f30876d.size);
    }
}
