package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

final class zzek extends Thread implements zzej {
    private static zzek zzanw;
    private volatile boolean closed = false;
    private final LinkedBlockingQueue<Runnable> zzahb = new LinkedBlockingQueue<>();
    private volatile boolean zzahc = false;
    /* access modifiers changed from: private */
    public volatile zzem zzanx;
    /* access modifiers changed from: private */
    public final Context zzrm;
    private final Clock zzsd = DefaultClock.getInstance();

    static zzek zzq(Context context) {
        if (zzanw == null) {
            zzanw = new zzek(context);
        }
        return zzanw;
    }

    private zzek(Context context) {
        super("GAThread");
        if (context != null) {
            this.zzrm = context.getApplicationContext();
        } else {
            this.zzrm = context;
        }
        start();
    }

    public final void zzb(String str, String str2, String str3, Map<String, String> map, String str4) {
        zzc(new zzel(this, this, this.zzsd.currentTimeMillis(), str, str2, str3, map, str4));
    }

    public final void zzc(Runnable runnable) {
        this.zzahb.add(runnable);
    }

    public final void run() {
        while (true) {
            boolean z = this.closed;
            try {
                Runnable take = this.zzahb.take();
                if (!this.zzahc) {
                    take.run();
                }
            } catch (InterruptedException e2) {
                try {
                    zzev.zzaw(e2.toString());
                } catch (Exception e3) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    PrintStream printStream = new PrintStream(byteArrayOutputStream);
                    zzpf.zza(e3, printStream);
                    printStream.flush();
                    String str = new String(byteArrayOutputStream.toByteArray());
                    zzev.zzav(str.length() != 0 ? "Error on Google TagManager Thread: ".concat(str) : new String("Error on Google TagManager Thread: "));
                    zzev.zzav("Google TagManager is shutting down.");
                    this.zzahc = true;
                }
            }
        }
    }
}
