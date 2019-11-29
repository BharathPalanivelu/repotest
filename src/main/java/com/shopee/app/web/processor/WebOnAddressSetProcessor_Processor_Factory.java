package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.util.n;
import com.shopee.app.web.processor.WebOnAddressSetProcessor;
import javax.inject.Provider;

public final class WebOnAddressSetProcessor_Processor_Factory implements b<WebOnAddressSetProcessor.Processor> {
    private final Provider<n> eventBusProvider;

    public WebOnAddressSetProcessor_Processor_Factory(Provider<n> provider) {
        this.eventBusProvider = provider;
    }

    public WebOnAddressSetProcessor.Processor get() {
        return new WebOnAddressSetProcessor.Processor(this.eventBusProvider.get());
    }

    public static WebOnAddressSetProcessor_Processor_Factory create(Provider<n> provider) {
        return new WebOnAddressSetProcessor_Processor_Factory(provider);
    }
}
