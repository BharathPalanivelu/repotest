package com.salesforce.android.service.common.analytics.internal;

import com.salesforce.android.service.common.analytics.ServiceAnalyticsListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InternalServiceAnalytics {
    static final Set<ServiceAnalyticsListener> mAnalyticsListeners = new HashSet();

    private InternalServiceAnalytics() {
    }

    public static void addListener(ServiceAnalyticsListener serviceAnalyticsListener) {
        mAnalyticsListeners.add(serviceAnalyticsListener);
    }

    public static void removeListener(ServiceAnalyticsListener serviceAnalyticsListener) {
        mAnalyticsListeners.remove(serviceAnalyticsListener);
    }

    public static void emit(String str, Map<String, Object> map) {
        for (ServiceAnalyticsListener onServiceAnalyticsEvent : mAnalyticsListeners) {
            onServiceAnalyticsEvent.onServiceAnalyticsEvent(str, map);
        }
    }

    public static void emit(String str, Object... objArr) {
        emit(str, parseEventData(objArr));
    }

    static Map<String, Object> parseEventData(Object... objArr) {
        if (objArr.length % 2 == 0) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < objArr.length; i += 2) {
                hashMap.put(objArr[i].toString(), objArr[i + 1]);
            }
            return hashMap;
        }
        throw new IllegalArgumentException("Analytics Event Data is invalid. Please specify an even number of data arguments. Data: " + Arrays.toString(objArr));
    }
}
