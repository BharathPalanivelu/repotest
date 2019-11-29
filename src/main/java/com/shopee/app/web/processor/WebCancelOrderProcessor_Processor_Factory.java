package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.c.c;
import com.shopee.app.tracking.f;
import com.shopee.app.util.n;
import com.shopee.app.web.processor.WebCancelOrderProcessor;
import javax.inject.Provider;

public final class WebCancelOrderProcessor_Processor_Factory implements b<WebCancelOrderProcessor.Processor> {
    private final Provider<n> eventBusProvider;
    private final Provider<at> notiStoreProvider;
    private final Provider<c> orderStoreProvider;
    private final Provider<f> trackerProvider;

    public WebCancelOrderProcessor_Processor_Factory(Provider<n> provider, Provider<f> provider2, Provider<c> provider3, Provider<at> provider4) {
        this.eventBusProvider = provider;
        this.trackerProvider = provider2;
        this.orderStoreProvider = provider3;
        this.notiStoreProvider = provider4;
    }

    public WebCancelOrderProcessor.Processor get() {
        return new WebCancelOrderProcessor.Processor(this.eventBusProvider.get(), this.trackerProvider.get(), this.orderStoreProvider.get(), this.notiStoreProvider.get());
    }

    public static WebCancelOrderProcessor_Processor_Factory create(Provider<n> provider, Provider<f> provider2, Provider<c> provider3, Provider<at> provider4) {
        return new WebCancelOrderProcessor_Processor_Factory(provider, provider2, provider3, provider4);
    }
}
