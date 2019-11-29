package com.google.android.exoplayer2.i.d;

import android.util.Log;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.a;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f10125a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10126b;

    /* renamed from: c  reason: collision with root package name */
    public final m.a f10127c;

    /* renamed from: d  reason: collision with root package name */
    public final int f10128d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f10129e;

    public k(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        boolean z2 = true;
        a.a((bArr2 != null ? false : z2) ^ (i == 0));
        this.f10125a = z;
        this.f10126b = str;
        this.f10128d = i;
        this.f10129e = bArr2;
        this.f10127c = new m.a(a(str), bArr, i2, i3);
    }

    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        if (c2 == 0 || c2 == 1) {
            return 1;
        }
        if (c2 == 2 || c2 == 3) {
            return 2;
        }
        Log.w("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR " + "crypto mode.");
        return 1;
    }
}
