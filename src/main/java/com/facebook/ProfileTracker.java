package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.h.a.a;
import com.facebook.internal.Validate;

public abstract class ProfileTracker {
    private final a broadcastManager;
    private boolean isTracking = false;
    private final BroadcastReceiver receiver;

    /* access modifiers changed from: protected */
    public abstract void onCurrentProfileChanged(Profile profile, Profile profile2);

    public ProfileTracker() {
        Validate.sdkInitialized();
        this.receiver = new ProfileBroadcastReceiver();
        this.broadcastManager = a.a(FacebookSdk.getApplicationContext());
        startTracking();
    }

    public void startTracking() {
        if (!this.isTracking) {
            addBroadcastReceiver();
            this.isTracking = true;
        }
    }

    public void stopTracking() {
        if (this.isTracking) {
            this.broadcastManager.a(this.receiver);
            this.isTracking = false;
        }
    }

    public boolean isTracking() {
        return this.isTracking;
    }

    private class ProfileBroadcastReceiver extends BroadcastReceiver {
        private ProfileBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (ProfileManager.ACTION_CURRENT_PROFILE_CHANGED.equals(intent.getAction())) {
                ProfileTracker.this.onCurrentProfileChanged((Profile) intent.getParcelableExtra(ProfileManager.EXTRA_OLD_PROFILE), (Profile) intent.getParcelableExtra(ProfileManager.EXTRA_NEW_PROFILE));
            }
        }
    }

    private void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ProfileManager.ACTION_CURRENT_PROFILE_CHANGED);
        this.broadcastManager.a(this.receiver, intentFilter);
    }
}
