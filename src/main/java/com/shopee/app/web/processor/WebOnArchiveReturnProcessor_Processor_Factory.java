package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.data.store.c.e;
import com.shopee.app.util.n;
import com.shopee.app.web.processor.WebOnArchiveReturnProcessor;
import javax.inject.Provider;

public final class WebOnArchiveReturnProcessor_Processor_Factory implements b<WebOnArchiveReturnProcessor.Processor> {
    private final Provider<n> eventBusProvider;
    private final Provider<e> returnStoreProvider;

    public WebOnArchiveReturnProcessor_Processor_Factory(Provider<n> provider, Provider<e> provider2) {
        this.eventBusProvider = provider;
        this.returnStoreProvider = provider2;
    }

    public WebOnArchiveReturnProcessor.Processor get() {
        return new WebOnArchiveReturnProcessor.Processor(this.eventBusProvider.get(), this.returnStoreProvider.get());
    }

    public static WebOnArchiveReturnProcessor_Processor_Factory create(Provider<n> provider, Provider<e> provider2) {
        return new WebOnArchiveReturnProcessor_Processor_Factory(provider, provider2);
    }
}
