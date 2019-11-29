package com.salesforce.android.service.common.utilities.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetricWatcher;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleStateWatcher;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.Enum;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LifecycleEvaluator<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
    private S mCurrentState;
    private S mForcedState;
    private final Set<LifecycleListener<S, M>> mListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private final ServiceLogger mLog;
    private final LifecycleMetricWatcher<S, M> mMetricWatcher;
    private S mMilestoneState;
    private final EnumSet<M> mSatisfiedMetrics;
    private final LifecycleStateWatcher<S, M> mStateWatcher;
    private final S[] mStates;

    LifecycleEvaluator(Class<S> cls, Class<M> cls2, LifecycleMetricWatcher<S, M> lifecycleMetricWatcher, LifecycleStateWatcher<S, M> lifecycleStateWatcher, ServiceLogger serviceLogger) {
        this.mStates = (Enum[]) cls.getEnumConstants();
        this.mSatisfiedMetrics = EnumSet.noneOf(cls2);
        S s = this.mStates[0];
        this.mCurrentState = s;
        this.mMilestoneState = s;
        this.mMetricWatcher = lifecycleMetricWatcher;
        this.mStateWatcher = lifecycleStateWatcher;
        this.mLog = serviceLogger;
        this.mForcedState = null;
    }

    public LifecycleEvaluator<S, M> setMilestoneState(S s) {
        this.mMilestoneState = s;
        return this;
    }

    public LifecycleEvaluator<S, M> setSatisfied(M m, boolean z) {
        if (z) {
            this.mSatisfiedMetrics.add(m);
        } else {
            this.mSatisfiedMetrics.remove(m);
        }
        this.mLog.debug("Metric {}.{} has been set to {}", m.getClass().getSimpleName(), m.name(), Boolean.valueOf(z));
        return this;
    }

    public LifecycleEvaluator<S, M> setMetricSatisfied(M m) {
        return setSatisfied(m, true);
    }

    public LifecycleEvaluator<S, M> setMetricUnsatisfied(M m) {
        return setSatisfied(m, false);
    }

    public void evaluateState() {
        S firstState = getFirstState();
        Enum finalState = getFinalState();
        S s = this.mForcedState;
        if (s == null) {
            s = this.mCurrentState;
        }
        if (s.ordinal() >= this.mMilestoneState.ordinal()) {
            firstState = this.mMilestoneState;
        }
        Iterator it = EnumSet.range(firstState, finalState).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Enum enumR = (Enum) it.next();
            if (!isStateSatisfied(enumR)) {
                finalState = enumR;
                break;
            }
        }
        setCurrentState(finalState);
        this.mForcedState = null;
    }

    public LifecycleEvaluator<S, M> moveToMilestone() {
        this.mForcedState = this.mMilestoneState;
        return this;
    }

    public S getFirstState() {
        return this.mStates[0];
    }

    public S getFinalState() {
        S[] sArr = this.mStates;
        return sArr[sArr.length - 1];
    }

    public S getCurrentState() {
        return this.mCurrentState;
    }

    public boolean isCurrentStateBefore(S s) {
        return this.mCurrentState.ordinal() < s.ordinal();
    }

    public boolean isCurrentStateAfter(S s) {
        return this.mCurrentState.ordinal() > s.ordinal();
    }

    public boolean isCurrentStateEqual(S s) {
        return this.mCurrentState.ordinal() == s.ordinal();
    }

    public void addListener(LifecycleListener<S, M> lifecycleListener) {
        this.mListeners.add(lifecycleListener);
    }

    public void removeListener(LifecycleListener<S, M> lifecycleListener) {
        this.mListeners.remove(lifecycleListener);
    }

    /* access modifiers changed from: package-private */
    public boolean isMetricSatisfied(M m) {
        return this.mSatisfiedMetrics.contains(m);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentState(S s) {
        if (s != this.mCurrentState) {
            this.mStateWatcher.push(s, this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isStateSatisfied(S s) {
        LifecycleState lifecycleState = (LifecycleState) s;
        if (lifecycleState.getMetrics() == null) {
            return true;
        }
        for (Enum isMetricSatisfied : lifecycleState.getMetrics()) {
            if (!isMetricSatisfied(isMetricSatisfied)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void metricTimedOut(M m) {
        for (LifecycleListener<S, M> onMetricTimeout : this.mListeners) {
            onMetricTimeout.onMetricTimeout(m);
        }
    }

    /* access modifiers changed from: package-private */
    public void stateChanged(S s) {
        S s2 = this.mCurrentState;
        this.mCurrentState = s;
        if (this.mCurrentState == getFinalState()) {
            this.mMetricWatcher.stop();
            this.mStateWatcher.stop();
        } else {
            this.mMetricWatcher.watch(this.mCurrentState, this);
        }
        for (LifecycleListener<S, M> onStateChanged : this.mListeners) {
            onStateChanged.onStateChanged(s, s2);
        }
    }

    public static class Builder<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
        private ServiceLogger mLog;
        private LifecycleMetricWatcher<S, M> mMetricWatcher;
        private LifecycleStateWatcher<S, M> mStateWatcher;

        public Builder<S, M> lifecycleMetricWatcher(LifecycleMetricWatcher<S, M> lifecycleMetricWatcher) {
            this.mMetricWatcher = lifecycleMetricWatcher;
            return this;
        }

        public Builder<S, M> lifecycleStateWatcher(LifecycleStateWatcher<S, M> lifecycleStateWatcher) {
            this.mStateWatcher = lifecycleStateWatcher;
            return this;
        }

        public Builder<S, M> logger(ServiceLogger serviceLogger) {
            this.mLog = serviceLogger;
            return this;
        }

        public LifecycleEvaluator<S, M> build(Class<S> cls, Class<M> cls2) {
            if (this.mMetricWatcher == null) {
                this.mMetricWatcher = new LifecycleMetricWatcher.Builder().build(cls);
            }
            if (this.mStateWatcher == null) {
                this.mStateWatcher = new LifecycleStateWatcher.Builder().build(cls);
            }
            if (this.mLog == null) {
                this.mLog = ServiceLogging.getLogger(LifecycleEvaluator.class, String.format("LifecycleEvaluator:%s", new Object[]{cls.getSimpleName()}));
            }
            return new LifecycleEvaluator(cls, cls2, this.mMetricWatcher, this.mStateWatcher, this.mLog);
        }
    }
}
