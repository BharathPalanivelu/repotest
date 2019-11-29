package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.google.a.o;
import com.shopee.app.ui.sharing.c;
import com.shopee.app.ui.sharing.d;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.ShowSharingPanelMessage;
import d.d.b.j;
import d.d.b.m;
import d.d.b.n;
import d.d.b.p;
import d.f;
import d.f.e;

public class SharingPanelModule extends WebBridgeModule implements d {
    static final /* synthetic */ e[] $$delegatedProperties = {p.a((m) new n(p.a(SharingPanelModule.class), "sharingPanel", "getSharingPanel()Lcom/shopee/app/ui/sharing/SharingPanel;"))};
    private final d.e sharingPanel$delegate = f.a(new SharingPanelModule$sharingPanel$2(this));

    private c getSharingPanel() {
        d.e eVar = this.sharingPanel$delegate;
        e eVar2 = $$delegatedProperties[0];
        return (c) eVar.a();
    }

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "showSharingPanel";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharingPanelModule(Context context) {
        super(context);
        j.b(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (getActivity() == null) {
            return;
        }
        if (obj != null) {
            ShowSharingPanelMessage showSharingPanelMessage = (ShowSharingPanelMessage) obj;
            c sharingPanel = getSharingPanel();
            if (sharingPanel != null) {
                sharingPanel.a(showSharingPanelMessage.getTitle(), showSharingPanelMessage.getSubTitle(), showSharingPanelMessage.getAutoDismissForUnavailablePlatform(), showSharingPanelMessage.getSharingAppIDsTop(), showSharingPanelMessage.getSharingAppIDsBottom(), this);
                return;
            }
            return;
        }
        throw new d.m("null cannot be cast to non-null type com.shopee.app.web.protocol.ShowSharingPanelMessage");
    }

    public void onSelectApp(String str, boolean z) {
        j.b(str, "appId");
        if (getContext() != null) {
            resolvePromise(str, z);
        } else {
            rejectPromise();
        }
    }

    public void onDismiss() {
        rejectPromise();
    }

    public void resolvePromise(String str, boolean z) {
        j.b(str, "sharingAppID");
        o oVar = new o();
        oVar.a("status", (Number) 1);
        oVar.a("sharingAppID", str);
        oVar.a("isAppAvailable", Boolean.valueOf(z));
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(oVar);
        }
    }

    public void rejectPromise() {
        o oVar = new o();
        oVar.a("status", (Number) 0);
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(oVar);
        }
    }
}
