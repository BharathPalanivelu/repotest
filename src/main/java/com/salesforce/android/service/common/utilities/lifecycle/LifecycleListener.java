package com.salesforce.android.service.common.utilities.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;
import java.lang.Enum;

public interface LifecycleListener<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
    void onMetricTimeout(M m);

    void onStateChanged(S s, S s2);
}
