package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.Logger;

final class zzgv implements Logger {
    zzgv() {
    }

    public final void error(String str) {
        zzev.zzav(str);
    }

    public final void error(Exception exc) {
        zzev.zza("", exc);
    }

    public final void info(String str) {
        zzev.zzaw(str);
    }

    public final void verbose(String str) {
        zzev.zzab(str);
    }

    public final void warn(String str) {
        zzev.zzac(str);
    }

    public final void setLogLevel(int i) {
        zzev.zzac("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }

    public final int getLogLevel() {
        zzev.getLogLevel();
        return 3;
    }
}
