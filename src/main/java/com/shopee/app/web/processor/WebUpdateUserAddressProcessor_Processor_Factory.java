package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.util.n;
import com.shopee.app.web.processor.WebUpdateUserAddressProcessor;
import javax.inject.Provider;

public final class WebUpdateUserAddressProcessor_Processor_Factory implements b<WebUpdateUserAddressProcessor.Processor> {
    private final Provider<n> eventBusProvider;

    public WebUpdateUserAddressProcessor_Processor_Factory(Provider<n> provider) {
        this.eventBusProvider = provider;
    }

    public WebUpdateUserAddressProcessor.Processor get() {
        return new WebUpdateUserAddressProcessor.Processor(this.eventBusProvider.get());
    }

    public static WebUpdateUserAddressProcessor_Processor_Factory create(Provider<n> provider) {
        return new WebUpdateUserAddressProcessor_Processor_Factory(provider);
    }
}
