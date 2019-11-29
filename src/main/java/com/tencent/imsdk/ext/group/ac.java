package com.tencent.imsdk.ext.group;

import java.util.List;

final class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupAssistantListener f30907a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30908b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ List f30909c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ IMCoreGroupAssistantCallback f30910d;

    ac(IMCoreGroupAssistantCallback iMCoreGroupAssistantCallback, TIMGroupAssistantListener tIMGroupAssistantListener, String str, List list) {
        this.f30910d = iMCoreGroupAssistantCallback;
        this.f30907a = tIMGroupAssistantListener;
        this.f30908b = str;
        this.f30909c = list;
    }

    public final void run() {
        this.f30907a.onMemberUpdate(this.f30908b, this.f30909c);
    }
}
