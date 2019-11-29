package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.content.Context;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.i.c;
import com.shopee.app.util.i.d;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.id.R;
import d.d.b.j;
import d.i;

public final class NfcSupportDetectingModule extends WebBridgeModule {
    public static final Companion Companion = new Companion((g) null);
    public static final String NAME = "detectNfcSupport";
    private final c nfcHandler;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[d.values().length];

        static {
            $EnumSwitchMapping$0[d.NFC_SUPPORTED_AND_ON.ordinal()] = 1;
            $EnumSwitchMapping$0[d.NFC_NOT_SUPPORTED.ordinal()] = 2;
            $EnumSwitchMapping$0[d.NFC_SUPPORTED_BUT_OFF.ordinal()] = 3;
            $EnumSwitchMapping$0[d.USER_DENIED.ordinal()] = 4;
            $EnumSwitchMapping$0[d.WAIT_FOR_NEXT_VIEW_WILL_REAPPEAR.ordinal()] = 5;
        }
    }

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return NAME;
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NfcSupportDetectingModule(Context context, c cVar) {
        super(context);
        j.b(context, "context");
        j.b(cVar, "nfcHandler");
        this.nfcHandler = cVar;
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (obj instanceof Params) {
            d a2 = this.nfcHandler.a();
            if (a2 != d.NFC_SUPPORTED_BUT_OFF || !((Params) obj).getShouldTurnOnNfc()) {
                handleNfcStatus(a2);
            } else {
                showNfcPopup();
            }
        }
    }

    public final void resolvePromise(BridgeResult<?> bridgeResult) {
        j.b(bridgeResult, AbTestingModule.KEY_RESULT);
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(bridgeResult.toJson());
        }
    }

    private final void handleNfcStatus(d dVar) {
        BridgeResult<?> bridgeResult;
        int i = WhenMappings.$EnumSwitchMapping$0[dVar.ordinal()];
        if (i == 1) {
            bridgeResult = BridgeResult.Companion.success();
        } else if (i == 2 || i == 3 || i == 4 || i == 5) {
            bridgeResult = BridgeResult.Companion.fail(dVar.getErrorCode());
        } else {
            throw new i();
        }
        resolvePromise(bridgeResult);
    }

    private final void showNfcPopup() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            a.a(getContext(), b.e(R.string.sp_description_switch_on_nfc), b.e(R.string.button_cancel), b.e(R.string.sp_settings), (a.C0318a) new NfcSupportDetectingModule$showNfcPopup$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void onNfcPopupResponse(boolean z) {
        d dVar;
        if (z) {
            dVar = d.WAIT_FOR_NEXT_VIEW_WILL_REAPPEAR;
        } else {
            dVar = d.USER_DENIED;
        }
        handleNfcStatus(dVar);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final class Params {
        @com.google.a.a.c(a = "shouldTurnOnNfc")
        private final boolean shouldTurnOnNfc;

        public static /* synthetic */ Params copy$default(Params params, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = params.shouldTurnOnNfc;
            }
            return params.copy(z);
        }

        public final boolean component1() {
            return this.shouldTurnOnNfc;
        }

        public final Params copy(boolean z) {
            return new Params(z);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Params) {
                    if (this.shouldTurnOnNfc == ((Params) obj).shouldTurnOnNfc) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.shouldTurnOnNfc;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "Params(shouldTurnOnNfc=" + this.shouldTurnOnNfc + SQLBuilder.PARENTHESES_RIGHT;
        }

        public Params(boolean z) {
            this.shouldTurnOnNfc = z;
        }

        public final boolean getShouldTurnOnNfc() {
            return this.shouldTurnOnNfc;
        }
    }
}
