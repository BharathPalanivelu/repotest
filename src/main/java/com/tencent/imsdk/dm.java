package com.tencent.imsdk;

import com.tencent.imsdk.utils.QualityReportHelper;
import java.util.List;

final class dm extends af<TIMCallBack> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30877b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ QualityReportHelper f30878c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ TIMSoundElem f30879d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    dm(TIMSoundElem tIMSoundElem, TIMCallBack tIMCallBack, String str, QualityReportHelper qualityReportHelper) {
        super(tIMCallBack);
        this.f30879d = tIMSoundElem;
        this.f30877b = str;
        this.f30878c = qualityReportHelper;
    }

    public final void a(int i, String str) {
        ((TIMCallBack) this.f30689a).onError(i, str);
        this.f30878c.init(i, str);
        this.f30878c.report();
    }

    public final void a(List<String> list) {
        List<String> list2 = list;
        IMMsfCoreProxy.get().downloadToFile(list2, this.f30877b, (TIMCallBack) this.f30689a, this.f30878c, this.f30879d.getDataSize());
    }
}
