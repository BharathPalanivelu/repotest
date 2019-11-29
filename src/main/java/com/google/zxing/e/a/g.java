package com.google.zxing.e.a;

import com.tencent.rtmp.TXLiveConstants;

final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f14652a = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14653b = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};

    /* renamed from: c  reason: collision with root package name */
    private final f f14654c;

    /* renamed from: d  reason: collision with root package name */
    private final byte f14655d;

    private g(int i) {
        this.f14654c = f.forBits((i >> 3) & 3);
        this.f14655d = (byte) (i & 7);
    }

    static int a(int i, int i2) {
        int i3 = i ^ i2;
        int[] iArr = f14653b;
        return iArr[i3 & 15] + iArr[(i3 >>> 4) & 15] + iArr[(i3 >>> 8) & 15] + iArr[(i3 >>> 12) & 15] + iArr[(i3 >>> 16) & 15] + iArr[(i3 >>> 20) & 15] + iArr[(i3 >>> 24) & 15] + iArr[(i3 >>> 28) & 15];
    }

    static g b(int i, int i2) {
        g c2 = c(i, i2);
        if (c2 != null) {
            return c2;
        }
        return c(i ^ 21522, i2 ^ 21522);
    }

    private static g c(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : f14652a) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new g(iArr[1]);
            }
            int a2 = a(i, i5);
            if (a2 < i3) {
                i4 = iArr[1];
                i3 = a2;
            }
            if (i != i2) {
                int a3 = a(i2, i5);
                if (a3 < i3) {
                    i4 = iArr[1];
                    i3 = a3;
                }
            }
        }
        if (i3 <= 3) {
            return new g(i4);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public f a() {
        return this.f14654c;
    }

    /* access modifiers changed from: package-private */
    public byte b() {
        return this.f14655d;
    }

    public int hashCode() {
        return (this.f14654c.ordinal() << 3) | this.f14655d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f14654c == gVar.f14654c && this.f14655d == gVar.f14655d) {
            return true;
        }
        return false;
    }
}
