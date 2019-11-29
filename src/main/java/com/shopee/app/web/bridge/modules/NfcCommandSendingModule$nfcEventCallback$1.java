package com.shopee.app.web.bridge.modules;

import com.shopee.app.util.i.a;
import d.d.b.j;

public final class NfcCommandSendingModule$nfcEventCallback$1 implements a.b {
    final /* synthetic */ NfcCommandSendingModule this$0;

    NfcCommandSendingModule$nfcEventCallback$1(NfcCommandSendingModule nfcCommandSendingModule) {
        this.this$0 = nfcCommandSendingModule;
    }

    public void onResponse(String str, String str2, String str3) {
        j.b(str, "tagId");
        j.b(str2, "cmd");
        j.b(str3, "data");
        this.this$0.onCmdExecutedSuccessfully(str, str2, str3);
    }

    public void onError(String str, String str2, Exception exc) {
        j.b(str, "tagId");
        j.b(str2, "cmd");
        j.b(exc, "e");
        this.this$0.onCmdExecutedFailed(str, str2, exc);
    }
}
