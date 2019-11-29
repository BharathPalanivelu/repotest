package com.shopee.app.web.processor;

import b.a.b;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.q;
import com.shopee.app.data.store.r;
import com.shopee.app.util.n;
import com.shopee.app.web.processor.WebSplitCheckoutProcessor;
import javax.inject.Provider;

public final class WebSplitCheckoutProcessor_Processor_Factory implements b<WebSplitCheckoutProcessor.Processor> {
    private final Provider<q> checkoutIdStoreProvider;
    private final Provider<r> checkoutStoreProvider;
    private final Provider<n> eventBusProvider;
    private final Provider<at> notiStoreProvider;

    public WebSplitCheckoutProcessor_Processor_Factory(Provider<n> provider, Provider<r> provider2, Provider<q> provider3, Provider<at> provider4) {
        this.eventBusProvider = provider;
        this.checkoutStoreProvider = provider2;
        this.checkoutIdStoreProvider = provider3;
        this.notiStoreProvider = provider4;
    }

    public WebSplitCheckoutProcessor.Processor get() {
        return new WebSplitCheckoutProcessor.Processor(this.eventBusProvider.get(), this.checkoutStoreProvider.get(), this.checkoutIdStoreProvider.get(), this.notiStoreProvider.get());
    }

    public static WebSplitCheckoutProcessor_Processor_Factory create(Provider<n> provider, Provider<r> provider2, Provider<q> provider3, Provider<at> provider4) {
        return new WebSplitCheckoutProcessor_Processor_Factory(provider, provider2, provider3, provider4);
    }
}
