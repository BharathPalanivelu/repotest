package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;

public class LiveAgentLoggingServiceConnection implements ServiceConnection {
    private Context mBindContext;
    private final IntentFactory mIntentFactory;
    private boolean mIsBound = false;
    private OnDisconnectedListener mOnDisconnectedListener;
    private BasicAsync<LiveAgentLoggingSession> mSessionAsync;

    public interface OnDisconnectedListener {
        void onServiceDisconnected();
    }

    protected LiveAgentLoggingServiceConnection(Builder builder) {
        this.mIntentFactory = builder.mIntentFactory;
    }

    public Intent createServiceIntent(Context context, LiveAgentLoggingConfiguration liveAgentLoggingConfiguration) {
        Intent createIntent = this.mIntentFactory.createIntent(context, LiveAgentLoggingService.class);
        createIntent.putExtra(LiveAgentLoggingConfiguration.EXTRA_ID, liveAgentLoggingConfiguration);
        return createIntent;
    }

    public Async<LiveAgentLoggingSession> bindToService(Context context, Intent intent) {
        this.mBindContext = context.getApplicationContext();
        this.mIsBound = this.mBindContext.bindService(intent, this, 1);
        if (!this.mIsBound) {
            return BasicAsync.error(new Exception("Unable to bind to LiveAgentLoggingService."));
        }
        this.mSessionAsync = BasicAsync.create();
        return this.mSessionAsync;
    }

    public void unbindFromService() {
        if (this.mIsBound) {
            Context context = this.mBindContext;
            if (context != null) {
                this.mIsBound = false;
                context.unbindService(this);
            }
        }
    }

    public void setOnDisconnectedListener(OnDisconnectedListener onDisconnectedListener) {
        this.mOnDisconnectedListener = onDisconnectedListener;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if ((iBinder instanceof LiveAgentLoggingServiceBinder) && this.mSessionAsync != null) {
            this.mSessionAsync.setResult(((LiveAgentLoggingServiceBinder) iBinder).getLiveAgentLoggingSession());
            this.mSessionAsync.complete();
            this.mSessionAsync = null;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        OnDisconnectedListener onDisconnectedListener = this.mOnDisconnectedListener;
        if (onDisconnectedListener != null) {
            onDisconnectedListener.onServiceDisconnected();
        }
    }

    public static class Builder {
        protected IntentFactory mIntentFactory;

        /* access modifiers changed from: package-private */
        public Builder intentFactory(IntentFactory intentFactory) {
            this.mIntentFactory = intentFactory;
            return this;
        }

        public LiveAgentLoggingServiceConnection build() {
            if (this.mIntentFactory == null) {
                this.mIntentFactory = new IntentFactory();
            }
            return new LiveAgentLoggingServiceConnection(this);
        }
    }
}
