package com.salesforce.android.service.common.utilities.internal.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectionInfo;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;

public class ConnectivityTracker extends BroadcastReceiver {
    private static final ServiceLogger log = ServiceLogging.getLogger(ConnectivityTracker.class);
    private final ConnectionInfo.Builder mConnectionInfoBuilder;
    private final ConnectivityManager mConnectivityManager;
    private ConnectivityState mConnectivityState = ConnectivityState.UNKNOWN;
    private final Context mContext;
    private final Listener mListener;

    public interface Listener {
        void onConnectivityChanged(ConnectionInfo connectionInfo, ConnectivityState connectivityState, ConnectivityState connectivityState2);
    }

    protected ConnectivityTracker(Builder builder) {
        this.mContext = builder.mContext;
        this.mListener = builder.mListener;
        this.mConnectivityManager = builder.mConnectivityManager;
        this.mConnectionInfoBuilder = builder.mConnectionInfoBuilder;
        log.debug("Setting up network connectivity broadcast receiver");
        this.mContext.registerReceiver(this, builder.mIntentFactory.createIntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.mConnectivityState = getConnectivityState();
    }

    public ConnectivityState getConnectivityState() {
        NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        return parseConnectivityState(activeNetworkInfo, this.mConnectionInfoBuilder.networkInfo(activeNetworkInfo).build().isConnected());
    }

    public ConnectionInfo getConnectionInfo() {
        return this.mConnectionInfoBuilder.networkInfo(this.mConnectivityManager.getActiveNetworkInfo()).build();
    }

    public void teardown() {
        log.debug("Removing network connectivity broadcast receiver");
        this.mContext.unregisterReceiver(this);
    }

    /* renamed from: com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$net$NetworkInfo$State = new int[NetworkInfo.State.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                android.net.NetworkInfo$State[] r0 = android.net.NetworkInfo.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$net$NetworkInfo$State = r0
                int[] r0 = $SwitchMap$android$net$NetworkInfo$State     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$android$net$NetworkInfo$State     // Catch:{ NoSuchFieldError -> 0x001f }
                android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public ConnectivityState parseConnectivityState(NetworkInfo networkInfo, boolean z) {
        int i = AnonymousClass1.$SwitchMap$android$net$NetworkInfo$State[(networkInfo != null ? networkInfo.getState() : NetworkInfo.State.DISCONNECTED).ordinal()];
        if (i == 1) {
            return z ? ConnectivityState.SWITCHING : ConnectivityState.DISCONNECTED;
        }
        if (i != 2) {
            return ConnectivityState.UNKNOWN;
        }
        return ConnectivityState.CONNECTED;
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Object obj = extras.get("networkInfo");
            if (obj != null && (obj instanceof NetworkInfo)) {
                NetworkInfo networkInfo = (NetworkInfo) obj;
                ConnectionInfo build = this.mConnectionInfoBuilder.networkInfo(networkInfo).build();
                ConnectivityState parseConnectivityState = parseConnectivityState(networkInfo, build.isConnected());
                ConnectivityState connectivityState = this.mConnectivityState;
                if (parseConnectivityState != connectivityState) {
                    this.mConnectivityState = parseConnectivityState;
                    log.debug("Connectivity change: {} -> {}", connectivityState.name(), this.mConnectivityState.name());
                    log.debug(ServiceLogger.PLACEHOLDER, build);
                    this.mListener.onConnectivityChanged(build, this.mConnectivityState, connectivityState);
                }
            }
        }
    }

    public static class Builder {
        protected ConnectionInfo.Builder mConnectionInfoBuilder;
        protected ConnectivityManager mConnectivityManager;
        Context mContext;
        protected IntentFactory mIntentFactory;
        Listener mListener;

        /* access modifiers changed from: package-private */
        public Builder connectivityManager(ConnectivityManager connectivityManager) {
            this.mConnectivityManager = connectivityManager;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder intentFactory(IntentFactory intentFactory) {
            this.mIntentFactory = intentFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder connectionInfoBuilder(ConnectionInfo.Builder builder) {
            this.mConnectionInfoBuilder = builder;
            return this;
        }

        public ConnectivityTracker build(Context context, Listener listener) {
            this.mContext = context;
            this.mListener = listener;
            if (this.mConnectivityManager == null) {
                this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            }
            if (this.mIntentFactory == null) {
                this.mIntentFactory = new IntentFactory();
            }
            if (this.mConnectionInfoBuilder == null) {
                this.mConnectionInfoBuilder = new ConnectionInfo.Builder();
            }
            return new ConnectivityTracker(this);
        }
    }
}
