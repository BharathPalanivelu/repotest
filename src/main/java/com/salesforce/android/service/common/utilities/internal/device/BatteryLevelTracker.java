package com.salesforce.android.service.common.utilities.internal.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class BatteryLevelTracker {
    private static final ServiceLogger log = ServiceLogging.getLogger(BatteryLevelTracker.class);
    private final IntentFilter mBatteryFilter;
    private final Context mContext;

    protected BatteryLevelTracker(Builder builder) {
        this.mContext = builder.mContext;
        this.mBatteryFilter = builder.mIntentFactory.createIntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public int getBatteryLevelPercent() {
        Intent registerReceiver = this.mContext.registerReceiver((BroadcastReceiver) null, this.mBatteryFilter);
        if (registerReceiver == null) {
            return 0;
        }
        int intExtra = registerReceiver.getIntExtra("level", 0);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        if (intExtra2 == 0) {
            intExtra2 = -1;
        }
        int round = Math.round((((float) intExtra) / ((float) intExtra2)) * 100.0f);
        log.info("Battery level: {}", Integer.valueOf(round));
        return round;
    }

    public static class Builder {
        protected Context mContext;
        protected IntentFactory mIntentFactory;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder intentFactory(IntentFactory intentFactory) {
            this.mIntentFactory = intentFactory;
            return this;
        }

        public BatteryLevelTracker build() {
            Arguments.checkNotNull(this.mContext);
            if (this.mIntentFactory == null) {
                this.mIntentFactory = new IntentFactory();
            }
            return new BatteryLevelTracker(this);
        }
    }
}
