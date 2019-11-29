package com.tencent.imsdk.ext.group;

final class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupAssistantListener f30917a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupCacheInfo f30918b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMCoreGroupAssistantCallback f30919c;

    af(IMCoreGroupAssistantCallback iMCoreGroupAssistantCallback, TIMGroupAssistantListener tIMGroupAssistantListener, TIMGroupCacheInfo tIMGroupCacheInfo) {
        this.f30919c = iMCoreGroupAssistantCallback;
        this.f30917a = tIMGroupAssistantListener;
        this.f30918b = tIMGroupCacheInfo;
    }

    public final void run() {
        this.f30917a.onGroupUpdate(this.f30918b);
    }
}
