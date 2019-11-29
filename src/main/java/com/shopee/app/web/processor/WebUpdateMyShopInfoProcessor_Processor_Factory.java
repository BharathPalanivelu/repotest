package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.web.processor.WebUpdateMyShopInfoProcessor;
import javax.inject.Provider;

public final class WebUpdateMyShopInfoProcessor_Processor_Factory implements b<WebUpdateMyShopInfoProcessor.Processor> {
    private final Provider<UserInfo> userInfoProvider;

    public WebUpdateMyShopInfoProcessor_Processor_Factory(Provider<UserInfo> provider) {
        this.userInfoProvider = provider;
    }

    public WebUpdateMyShopInfoProcessor.Processor get() {
        return new WebUpdateMyShopInfoProcessor.Processor(this.userInfoProvider.get());
    }

    public static WebUpdateMyShopInfoProcessor_Processor_Factory create(Provider<UserInfo> provider) {
        return new WebUpdateMyShopInfoProcessor_Processor_Factory(provider);
    }
}
