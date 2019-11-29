package com.salesforce.android.service.common.analytics;

import java.util.Map;

public interface ServiceAnalyticsListener {
    void onServiceAnalyticsEvent(String str, Map<String, Object> map);
}
