package com.garena.android.gpns.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.garena.android.gpns.GNotificationService;

public final class SharedPreferenceStore {
    private static final String KEY = "SERVICE_PREF";
    private static SharedPreferenceStore mInstance;
    private SharedPreferences mPreference;

    private SharedPreferenceStore(Context context) {
        this.mPreference = context.getSharedPreferences(KEY, 0);
    }

    public static SharedPreferenceStore getInstance() {
        if (mInstance == null) {
            mInstance = new SharedPreferenceStore(GNotificationService.getContext());
        }
        return mInstance;
    }

    public void putString(String str, String str2) {
        if (str != null) {
            SharedPreferences.Editor edit = this.mPreference.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public String getString(String str, String str2) {
        return str != null ? this.mPreference.getString(str, str2) : str2;
    }

    public void putInt(String str, int i) {
        if (str != null) {
            SharedPreferences.Editor edit = this.mPreference.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public int getInt(String str, int i) {
        return str != null ? this.mPreference.getInt(str, i) : i;
    }

    public void putLong(String str, long j) {
        if (str != null) {
            SharedPreferences.Editor edit = this.mPreference.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public long getLong(String str, long j) {
        return str != null ? this.mPreference.getLong(str, j) : j;
    }

    public void putBoolean(String str, boolean z) {
        if (str != null) {
            SharedPreferences.Editor edit = this.mPreference.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public boolean getBoolean(String str, boolean z) {
        return str != null ? this.mPreference.getBoolean(str, z) : z;
    }
}
