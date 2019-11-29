package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import com.shopee.app.ui.sharing.c;
import d.d.a.a;
import d.d.b.j;
import d.d.b.k;

final class SharingPanelModule$sharingPanel$2 extends k implements a<c> {
    final /* synthetic */ SharingPanelModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharingPanelModule$sharingPanel$2(SharingPanelModule sharingPanelModule) {
        super(0);
        this.this$0 = sharingPanelModule;
    }

    public final c invoke() {
        Activity access$getActivity = this.this$0.getActivity();
        if (access$getActivity == null) {
            return null;
        }
        j.a((Object) access$getActivity, "it");
        return new c(access$getActivity);
    }
}
