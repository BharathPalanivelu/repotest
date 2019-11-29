package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.data.store.t;
import com.shopee.app.util.n;
import com.shopee.app.web.processor.WebFollowUserUpdateProcessor;
import javax.inject.Provider;

public final class WebFollowUserUpdateProcessor_Processor_Factory implements b<WebFollowUserUpdateProcessor.Processor> {
    private final Provider<t> contactStoreProvider;
    private final Provider<n> eventBusProvider;

    public WebFollowUserUpdateProcessor_Processor_Factory(Provider<n> provider, Provider<t> provider2) {
        this.eventBusProvider = provider;
        this.contactStoreProvider = provider2;
    }

    public WebFollowUserUpdateProcessor.Processor get() {
        return new WebFollowUserUpdateProcessor.Processor(this.eventBusProvider.get(), this.contactStoreProvider.get());
    }

    public static WebFollowUserUpdateProcessor_Processor_Factory create(Provider<n> provider, Provider<t> provider2) {
        return new WebFollowUserUpdateProcessor_Processor_Factory(provider, provider2);
    }
}
