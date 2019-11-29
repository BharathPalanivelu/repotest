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

@ReactModule(name = "GAShopeeBITracker")
public class BITrackerModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GAShopeeBITracker";
    private a mActionTracker;

    public String getName() {
        return NAME;
    }

    public BITrackerModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mActionTracker = aVar;
    }

    @ReactMethod
    public void trackAction(String str) {
        com.garena.android.appkit.d.a.b("[GAShopeeBITracker]" + str, new Object[0]);
        this.mActionTracker.c(str);
    }

    @ReactMethod
    public void trackActionByGroup(String str) {
        com.garena.android.appkit.d.a.b("[GAShopeeBITracker]" + str, new Object[0]);
        i iVar = (i) WebRegister.GSON.a(str, i.class);
        if (iVar != null && iVar.a() != 0) {
            Iterator<l> it = iVar.iterator();
            while (it.hasNext()) {
                this.mActionTracker.c(WebRegister.GSON.a(it.next()));
            }
        }
    }
}
