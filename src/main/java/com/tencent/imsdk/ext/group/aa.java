package com.tencent.imsdk.ext.group;

import java.util.List;

final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupAssistantListener f30899a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30900b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ List f30901c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ IMCoreGroupAssistantCallback f30902d;

    aa(IMCoreGroupAssistantCallback iMCoreGroupAssistantCallback, TIMGroupAssistantListener tIMGroupAssistantListener, String str, List list) {
        this.f30902d = iMCoreGroupAssistantCallback;
        this.f30899a = tIMGroupAssistantListener;
        this.f30900b = str;
        this.f30901c = list;
    }

    public final void run() {
        this.f30899a.onMemberJoin(this.f30900b, this.f30901c);
    }
}
