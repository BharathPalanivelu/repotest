package com.tencent.imsdk;

import com.tencent.imsdk.utils.QualityReportHelper;
import java.util.List;

final class dn extends af<TIMCallBack> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30880b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ QualityReportHelper f30881c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ TIMVideo f30882d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    dn(TIMVideo tIMVideo, TIMCallBack tIMCallBack, String str, QualityReportHelper qualityReportHelper) {
        super(tIMCallBack);
        this.f30882d = tIMVideo;
        this.f30880b = str;
        this.f30881c = qualityReportHelper;
    }

    public final void a(int i, String str) {
        ((TIMCallBack) this.f30689a).onError(i, str);
        this.f30881c.init(i, str);
        this.f30881c.report();
    }

    public final void a(List<String> list) {
        List<String> list2 = list;
        IMMsfCoreProxy.get().downloadToFile(list2, this.f30880b, (TIMCallBack) this.f30689a, this.f30881c, this.f30882d.size);
    }
}
