package com.google.android.exoplayer2.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f8978a = new b(new int[]{2}, 2);

    /* renamed from: b  reason: collision with root package name */
    private final int[] f8979b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8980c;

    public static b a(Context context) {
        return a(context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static b a(Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return f8978a;
        }
        return new b(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    b(int[] iArr, int i) {
        if (iArr != null) {
            this.f8979b = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.f8979b);
        } else {
            this.f8979b = new int[0];
        }
        this.f8980c = i;
    }

    public boolean a(int i) {
        return Arrays.binarySearch(this.f8979b, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Arrays.equals(this.f8979b, bVar.f8979b) || this.f8980c != bVar.f8980c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f8980c + (Arrays.hashCode(this.f8979b) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f8980c + ", supportedEncodings=" + Arrays.toString(this.f8979b) + "]";
    }
}
