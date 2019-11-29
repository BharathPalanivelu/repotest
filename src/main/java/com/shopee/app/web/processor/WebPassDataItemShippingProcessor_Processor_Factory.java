package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.util.n;
import com.shopee.app.web.processor.WebPassDataItemShippingProcessor;
import javax.inject.Provider;

public final class WebPassDataItemShippingProcessor_Processor_Factory implements b<WebPassDataItemShippingProcessor.Processor> {
    private final Provider<n> eventBusProvider;

    public WebPassDataItemShippingProcessor_Processor_Factory(Provider<n> provider) {
        this.eventBusProvider = provider;
    }

    public WebPassDataItemShippingProcessor.Processor get() {
        return new WebPassDataItemShippingProcessor.Processor(this.eventBusProvider.get());
    }

    public static WebPassDataItemShippingProcessor_Processor_Factory create(Provider<n> provider) {
        return new WebPassDataItemShippingProcessor_Processor_Factory(provider);
    }
}
