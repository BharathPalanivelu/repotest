package com.salesforce.android.service.common.utilities.internal.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.spatial.Orientation;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class OrientationTracker extends BroadcastReceiver {
    private final Context mContext;
    private final Listener mListener;

    public interface Listener {
        void onOrientationChange(Orientation orientation);
    }

    protected OrientationTracker(Builder builder) {
        this.mContext = builder.mContext;
        this.mListener = builder.mListener;
        this.mContext.registerReceiver(this, builder.mIntentFactory.createIntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }

    public void teardown() {
        this.mContext.unregisterReceiver(this);
    }

    public Orientation getOrientation() {
        return this.mContext.getResources().getConfiguration().orientation == 1 ? Orientation.PORTRAIT : Orientation.LANDSCAPE;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
            this.mListener.onOrientationChange(getOrientation());
        }
    }

    public static class Builder {
        protected Context mContext;
        protected IntentFactory mIntentFactory;
        protected Listener mListener;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder listener(Listener listener) {
            this.mListener = listener;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder intentFactory(IntentFactory intentFactory) {
            this.mIntentFactory = intentFactory;
            return this;
        }

        public OrientationTracker build() {
            Arguments.checkNotNull(this.mContext);
            Arguments.checkNotNull(this.mListener);
            if (this.mIntentFactory == null) {
                this.mIntentFactory = new IntentFactory();
            }
            return new OrientationTracker(this);
        }
    }
}
