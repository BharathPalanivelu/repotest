package com.salesforce.android.service.common.utilities.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;
import java.lang.Enum;

public interface LifecycleState<M extends Enum<M> & LifecycleMetric> {
    M[] getMetrics();
}
