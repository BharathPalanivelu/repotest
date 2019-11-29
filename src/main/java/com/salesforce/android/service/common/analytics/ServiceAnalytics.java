package com.salesforce.android.service.common.analytics;

import com.salesforce.android.service.common.analytics.internal.InternalServiceAnalytics;

public class ServiceAnalytics {
    private ServiceAnalytics() {
    }

    public static void addListener(ServiceAnalyticsListener serviceAnalyticsListener) {
        InternalServiceAnalytics.addListener(serviceAnalyticsListener);
    }

    public static void removeListener(ServiceAnalyticsListener serviceAnalyticsListener) {
        InternalServiceAnalytics.removeListener(serviceAnalyticsListener);
    }
}
