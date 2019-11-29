package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.data.store.at;
import com.shopee.app.util.n;
import com.shopee.app.web.processor.WebCreateNewCheckoutProcessor;
import javax.inject.Provider;

public final class WebCreateNewCheckoutProcessor_Processor_Factory implements b<WebCreateNewCheckoutProcessor.Processor> {
    private final Provider<n> eventBusProvider;
    private final Provider<at> notiStoreProvider;

    public WebCreateNewCheckoutProcessor_Processor_Factory(Provider<n> provider, Provider<at> provider2) {
        this.eventBusProvider = provider;
        this.notiStoreProvider = provider2;
    }

    public WebCreateNewCheckoutProcessor.Processor get() {
        return new WebCreateNewCheckoutProcessor.Processor(this.eventBusProvider.get(), this.notiStoreProvider.get());
    }

    public static WebCreateNewCheckoutProcessor_Processor_Factory create(Provider<n> provider, Provider<at> provider2) {
        return new WebCreateNewCheckoutProcessor_Processor_Factory(provider, provider2);
    }
}
