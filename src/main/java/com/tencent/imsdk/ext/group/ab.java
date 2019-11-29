package com.tencent.imsdk.ext.group;

import java.util.List;

final class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupAssistantListener f30903a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30904b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ List f30905c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ IMCoreGroupAssistantCallback f30906d;

    ab(IMCoreGroupAssistantCallback iMCoreGroupAssistantCallback, TIMGroupAssistantListener tIMGroupAssistantListener, String str, List list) {
        this.f30906d = iMCoreGroupAssistantCallback;
        this.f30903a = tIMGroupAssistantListener;
        this.f30904b = str;
        this.f30905c = list;
    }

    public final void run() {
        this.f30903a.onMemberQuit(this.f30904b, this.f30905c);
    }
}
