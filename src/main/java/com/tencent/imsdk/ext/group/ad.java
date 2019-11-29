package com.tencent.imsdk.ext.group;

final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupAssistantListener f30911a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupCacheInfo f30912b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMCoreGroupAssistantCallback f30913c;

    ad(IMCoreGroupAssistantCallback iMCoreGroupAssistantCallback, TIMGroupAssistantListener tIMGroupAssistantListener, TIMGroupCacheInfo tIMGroupCacheInfo) {
        this.f30913c = iMCoreGroupAssistantCallback;
        this.f30911a = tIMGroupAssistantListener;
        this.f30912b = tIMGroupCacheInfo;
    }

    public final void run() {
        this.f30911a.onGroupAdd(this.f30912b);
    }
}
