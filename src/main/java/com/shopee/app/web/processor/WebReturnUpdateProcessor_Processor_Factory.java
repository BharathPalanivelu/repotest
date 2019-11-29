package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.c.e;
import com.shopee.app.util.n;
import com.shopee.app.web.processor.WebReturnUpdateProcessor;
import javax.inject.Provider;

public final class WebReturnUpdateProcessor_Processor_Factory implements b<WebReturnUpdateProcessor.Processor> {
    private final Provider<n> eventBusProvider;
    private final Provider<at> notiStoreProvider;
    private final Provider<e> returnStoreProvider;

    public WebReturnUpdateProcessor_Processor_Factory(Provider<n> provider, Provider<e> provider2, Provider<at> provider3) {
        this.eventBusProvider = provider;
        this.returnStoreProvider = provider2;
        this.notiStoreProvider = provider3;
    }

    public WebReturnUpdateProcessor.Processor get() {
        return new WebReturnUpdateProcessor.Processor(this.eventBusProvider.get(), this.returnStoreProvider.get(), this.notiStoreProvider.get());
    }

    public static WebReturnUpdateProcessor_Processor_Factory create(Provider<n> provider, Provider<e> provider2, Provider<at> provider3) {
        return new WebReturnUpdateProcessor_Processor_Factory(provider, provider2, provider3);
    }
}
