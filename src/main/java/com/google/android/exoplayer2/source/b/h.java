package com.google.android.exoplayer2.source.b;

import android.util.Log;
import com.google.android.exoplayer2.q.f;
import com.google.android.exoplayer2.r.q;

public final class h {
    public static boolean a(f fVar, int i, Exception exc) {
        return a(fVar, i, exc, 60000);
    }

    public static boolean a(f fVar, int i, Exception exc, long j) {
        if (!a(exc)) {
            return false;
        }
        boolean a2 = fVar.a(i, j);
        int i2 = ((q.e) exc).responseCode;
        if (a2) {
            Log.w("ChunkedTrackBlacklist", "Blacklisted: duration=" + j + ", responseCode=" + i2 + ", format=" + fVar.a(i));
        } else {
            Log.w("ChunkedTrackBlacklist", "Blacklisting failed (cannot blacklist last enabled track): responseCode=" + i2 + ", format=" + fVar.a(i));
        }
        return a2;
    }

    public static boolean a(Exception exc) {
        if (!(exc instanceof q.e)) {
            return false;
        }
        int i = ((q.e) exc).responseCode;
        if (i == 404 || i == 410) {
            return true;
        }
        return false;
    }
}
