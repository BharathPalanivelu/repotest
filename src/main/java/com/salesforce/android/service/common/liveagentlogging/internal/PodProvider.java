package com.salesforce.android.service.common.liveagentlogging.internal;

import androidx.b.b;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Arrays;

public class PodProvider {
    private static String sForcedPod;
    private b<String> mAvailablePods = new b<>();
    private final b<String> mLiveAgentPods = new b<>();

    public static void overridePod(String str) {
        Arguments.checkValidLiveAgentPod(str);
        sForcedPod = str;
    }

    public PodProvider(Builder builder) {
        String str = sForcedPod;
        if (str != null) {
            this.mLiveAgentPods.add(str);
            this.mAvailablePods.add(sForcedPod);
            return;
        }
        this.mLiveAgentPods.addAll(Arrays.asList(builder.mLiveAgentPods));
        this.mAvailablePods.a(this.mLiveAgentPods);
    }

    public String nextPod() {
        if (!this.mLiveAgentPods.isEmpty()) {
            if (this.mAvailablePods.isEmpty()) {
                this.mAvailablePods.a(this.mLiveAgentPods);
            }
            b<String> bVar = this.mAvailablePods;
            double random = Math.random();
            double size = (double) this.mAvailablePods.size();
            Double.isNaN(size);
            return bVar.c((int) (random * size));
        }
        throw new AllPodsUnavailableException();
    }

    public void removePod(String str) {
        this.mLiveAgentPods.remove(str);
    }

    public static class Builder {
        protected String[] mLiveAgentPods;

        /* access modifiers changed from: package-private */
        public Builder liveAgentPods(String... strArr) {
            this.mLiveAgentPods = strArr;
            return this;
        }

        public PodProvider build() {
            Arguments.checkNotNull(this.mLiveAgentPods);
            return new PodProvider(this);
        }
    }
}
