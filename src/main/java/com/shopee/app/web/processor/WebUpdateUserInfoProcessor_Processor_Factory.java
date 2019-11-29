package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.web.processor.WebUpdateUserInfoProcessor;
import javax.inject.Provider;

public final class WebUpdateUserInfoProcessor_Processor_Factory implements b<WebUpdateUserInfoProcessor.Processor> {
    private final Provider<UserInfo> userInfoProvider;

    public WebUpdateUserInfoProcessor_Processor_Factory(Provider<UserInfo> provider) {
        this.userInfoProvider = provider;
    }

    public WebUpdateUserInfoProcessor.Processor get() {
        return new WebUpdateUserInfoProcessor.Processor(this.userInfoProvider.get());
    }

    public static WebUpdateUserInfoProcessor_Processor_Factory create(Provider<UserInfo> provider) {
        return new WebUpdateUserInfoProcessor_Processor_Factory(provider);
    }
}
