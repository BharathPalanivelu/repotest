package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.content.Intent;
import com.shopee.app.ui.dialog.a;

public final class NfcSupportDetectingModule$showNfcPopup$1 implements a.C0318a {
    final /* synthetic */ NfcSupportDetectingModule this$0;

    NfcSupportDetectingModule$showNfcPopup$1(NfcSupportDetectingModule nfcSupportDetectingModule) {
        this.this$0 = nfcSupportDetectingModule;
    }

    public void onPositive() {
        this.this$0.onNfcPopupResponse(true);
        Activity access$getActivity = this.this$0.getActivity();
        if (access$getActivity != null) {
            access$getActivity.startActivity(new Intent("android.settings.NFC_SETTINGS"));
        }
    }

    public void onNegative() {
        this.this$0.onNfcPopupResponse(false);
    }
}
