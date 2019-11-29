package com.shopee.app.react.modules.app.tracker;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.i;
import com.google.a.l;
import com.shopee.app.tracking.a;
import com.shopee.app.web.WebRegister;
import java.util.Iterator;

@ReactModule(name = "GAShopeeBITrackerV2")
public class BITrackerModuleV2 extends ReactContextBaseJavaModule {
    protected static final String NAME = "GAShopeeBITrackerV2";
    private a mActionTracker;

    public String getName() {
        return NAME;
    }

    public BITrackerModuleV2(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mActionTracker = aVar;
    }

    @ReactMethod
    public void trackAction(String str) {
        com.garena.android.appkit.d.a.b("[GAShopeeBITrackerV2]" + str, new Object[0]);
        this.mActionTracker.d(str);
    }

    @ReactMethod
    public void trackActions(String str) {
        com.garena.android.appkit.d.a.b("[GAShopeeBITrackerV2]" + str, new Object[0]);
        try {
            i iVar = (i) WebRegister.GSON.a(str, i.class);
            if (iVar != null && iVar.a() != 0) {
                Iterator<l> it = iVar.iterator();
                while (it.hasNext()) {
                    this.mActionTracker.d(WebRegister.GSON.a(it.next()));
                }
            }
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
