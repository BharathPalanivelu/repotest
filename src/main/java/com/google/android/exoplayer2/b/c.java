package com.google.android.exoplayer2.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f9160a = new c(new int[]{2}, 2);

    /* renamed from: b  reason: collision with root package name */
    private final int[] f9161b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9162c;

    public static c a(Context context) {
        return a(context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static c a(Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return f9160a;
        }
        return new c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    c(int[] iArr, int i) {
        if (iArr != null) {
            this.f9161b = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.f9161b);
        } else {
            this.f9161b = new int[0];
        }
        this.f9162c = i;
    }

    public boolean a(int i) {
        return Arrays.binarySearch(this.f9161b, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!Arrays.equals(this.f9161b, cVar.f9161b) || this.f9162c != cVar.f9162c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f9162c + (Arrays.hashCode(this.f9161b) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f9162c + ", supportedEncodings=" + Arrays.toString(this.f9161b) + "]";
    }
}
