package com.shopee.app.appuser;

import b.a.b;
import b.a.c;

public final class UserModule_ProvideTrackTrakLoggerFactory implements b<com.shopee.app.ui.tracklog.b> {
    private final UserModule module;

    public UserModule_ProvideTrackTrakLoggerFactory(UserModule userModule) {
        this.module = userModule;
    }

    public com.shopee.app.ui.tracklog.b get() {
        return (com.shopee.app.ui.tracklog.b) c.a(this.module.provideTrackTrakLogger(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static UserModule_ProvideTrackTrakLoggerFactory create(UserModule userModule) {
        return new UserModule_ProvideTrackTrakLoggerFactory(userModule);
    }

    public static com.shopee.app.ui.tracklog.b proxyProvideTrackTrakLogger(UserModule userModule) {
        return (com.shopee.app.ui.tracklog.b) c.a(userModule.provideTrackTrakLogger(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
