package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.shopee.app.application.ar;
import com.shopee.app.ui.webview.g;
import com.shopee.app.util.b;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.protocol.NavigateAppRL;
import com.shopee.navigator.b.a;
import com.shopee.navigator.c;

public class NavigateAppRLModule extends WebBridgeModule {
    b mAppPathHelper;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "navigateAppRL";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    public NavigateAppRLModule(Context context) {
        super(context);
        getComponent().inject(this);
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (getActivity() != null) {
            NavigateAppRL navigateAppRL = (NavigateAppRL) obj;
            this.mAppPathHelper.a(navigateAppRL.getAppRL(), navigateAppRL.getParams());
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (i == 1021) {
            ar.f().e().navigator2().a(activity, i, i2, intent);
            if (!(activity instanceof a) && intent != null) {
                String stringExtra = intent.getStringExtra("popData");
                if (stringExtra != null) {
                    g view = getView();
                    if (view != null) {
                        view.d(stringExtra);
                        return;
                    }
                    return;
                }
                c cVar = new c(intent);
                g view2 = getView();
                if (view2 != null) {
                    view2.d(cVar.d());
                }
            }
        }
    }
}
