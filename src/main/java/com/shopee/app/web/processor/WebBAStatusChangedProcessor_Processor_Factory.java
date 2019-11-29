package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.al;
import com.shopee.app.util.n;
import com.shopee.app.web.processor.WebBAStatusChangedProcessor;
import javax.inject.Provider;

public final class WebBAStatusChangedProcessor_Processor_Factory implements b<WebBAStatusChangedProcessor.Processor> {
    private final Provider<n> eventBusProvider;
    private final Provider<al> loginStoreProvider;
    private final Provider<UserInfo> userProvider;

    public WebBAStatusChangedProcessor_Processor_Factory(Provider<n> provider, Provider<UserInfo> provider2, Provider<al> provider3) {
        this.eventBusProvider = provider;
        this.userProvider = provider2;
        this.loginStoreProvider = provider3;
    }

    public WebBAStatusChangedProcessor.Processor get() {
        return new WebBAStatusChangedProcessor.Processor(this.eventBusProvider.get(), this.userProvider.get(), this.loginStoreProvider.get());
    }

    public static WebBAStatusChangedProcessor_Processor_Factory create(Provider<n> provider, Provider<UserInfo> provider2, Provider<al> provider3) {
        return new WebBAStatusChangedProcessor_Processor_Factory(provider, provider2, provider3);
    }
}
