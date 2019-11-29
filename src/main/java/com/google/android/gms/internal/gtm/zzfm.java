package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

final class zzfm implements zzfe {
    private final long zzabf;
    private final int zzabg;
    private double zzabh;
    private final Object zzabj;
    private long zzakm;
    private Clock zzsd;

    private zzfm(int i, long j) {
        this.zzabj = new Object();
        this.zzabg = 60;
        this.zzabh = (double) this.zzabg;
        this.zzabf = 2000;
        this.zzsd = DefaultClock.getInstance();
    }

    public zzfm() {
        this(60, 2000);
    }

    public final boolean zzfm() {
        synchronized (this.zzabj) {
            long currentTimeMillis = this.zzsd.currentTimeMillis();
            if (this.zzabh < ((double) this.zzabg)) {
                double d2 = (double) (currentTimeMillis - this.zzakm);
                double d3 = (double) this.zzabf;
                Double.isNaN(d2);
                Double.isNaN(d3);
                double d4 = d2 / d3;
                if (d4 > 0.0d) {
                    this.zzabh = Math.min((double) this.zzabg, this.zzabh + d4);
                }
            }
            this.zzakm = currentTimeMillis;
            if (this.zzabh >= 1.0d) {
                this.zzabh -= 1.0d;
                return true;
            }
            zzev.zzac("No more tokens available.");
            return false;
        }
    }
}
