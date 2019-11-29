package com.shopee.app.react.modules.app.notification;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.protocol.NotiCodes;
import com.shopee.app.web.WebRegister;
import java.util.ArrayList;
import java.util.List;

@ReactModule(name = "GANotiRegister")
public class NotiRegisterModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GANotiRegister";
    private List<Integer> mNotifications = new ArrayList();

    public String getName() {
        return NAME;
    }

    public NotiRegisterModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void registerNotiCodes(String str) {
        this.mNotifications = ((NotiCodes) WebRegister.GSON.a(str, NotiCodes.class)).notiCodes;
    }

    public List<Integer> getNotifications() {
        return this.mNotifications;
    }
}
