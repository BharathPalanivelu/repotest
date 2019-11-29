package com.tencent.imsdk.ext.group;

final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupAssistantListener f30914a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30915b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMCoreGroupAssistantCallback f30916c;

    ae(IMCoreGroupAssistantCallback iMCoreGroupAssistantCallback, TIMGroupAssistantListener tIMGroupAssistantListener, String str) {
        this.f30916c = iMCoreGroupAssistantCallback;
        this.f30914a = tIMGroupAssistantListener;
        this.f30915b = str;
    }

    public final void run() {
        this.f30914a.onGroupDelete(this.f30915b);
    }
}
