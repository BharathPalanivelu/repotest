package com.salesforce.android.service.common.ui.views;

import com.salesforce.android.service.common.ui.internal.animation.ViewDimensionAnimator;

final class SalesforceConnectionBanner$toggleDisplay$1 implements Runnable {
    final /* synthetic */ boolean $connected;
    final /* synthetic */ SalesforceConnectionBanner this$0;

    SalesforceConnectionBanner$toggleDisplay$1(SalesforceConnectionBanner salesforceConnectionBanner, boolean z) {
        this.this$0 = salesforceConnectionBanner;
        this.$connected = z;
    }

    public final void run() {
        this.this$0.bringToFront();
        SalesforceConnectionBanner salesforceConnectionBanner = this.this$0;
        salesforceConnectionBanner.startAnimation(new ViewDimensionAnimator(this.$connected ? 0 : salesforceConnectionBanner.getBannerHeight(), this.this$0, ViewDimensionAnimator.Type.HEIGHT, this.this$0.getAnimationDuration()));
        this.this$0.getAnimationHandler().removeCallbacksAndMessages((Object) null);
    }
}
