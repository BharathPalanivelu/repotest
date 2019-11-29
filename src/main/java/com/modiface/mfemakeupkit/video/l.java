package com.modiface.mfemakeupkit.video;

import android.media.MediaFormat;
import android.os.Build;
import com.google.android.gms.common.util.GmsVersion;
import com.tencent.ijk.media.player.IjkMediaMeta;

class l {

    /* renamed from: a  reason: collision with root package name */
    static final String f15447a = "video/avc";

    /* renamed from: b  reason: collision with root package name */
    static final int f15448b = 15;

    /* renamed from: c  reason: collision with root package name */
    static final int f15449c = 0;

    /* renamed from: d  reason: collision with root package name */
    static final int f15450d = 100;

    /* renamed from: e  reason: collision with root package name */
    static final int[] f15451e = {GmsVersion.VERSION_SAGA, 4000000, 2000000};

    /* renamed from: f  reason: collision with root package name */
    static final Integer[] f15452f = {0, 2, 1, null};

    /* renamed from: g  reason: collision with root package name */
    static final String f15453g = "audio/mp4a-latm";
    static final int h = 44100;
    static final int i = 64000;
    static final int j = 1024;
    static final int k = 25;
    static final int l = 100;
    static final int m = 100;
    static final int[] n = {5, 1, 0};
    int A = 100;
    int[] B = n;
    String o = f15447a;
    int p = 15;
    int q = 0;
    int[] r = f15451e;
    Integer[] s = f15452f;
    int t = 100;
    String u = f15453g;
    int v = 44100;
    int w = i;
    int x = 1024;
    int y = 25;
    int z = 100;

    l() {
    }

    private MediaFormat b(int i2, int i3) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.o, i2, i3);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("frame-rate", this.p);
        createVideoFormat.setInteger("i-frame-interval", this.q);
        return createVideoFormat;
    }

    /* access modifiers changed from: package-private */
    public MediaFormat[] a(int i2, int i3) {
        MediaFormat[] mediaFormatArr;
        if (Build.VERSION.SDK_INT >= 21) {
            Integer[] numArr = this.s;
            if (numArr.length > 0) {
                mediaFormatArr = new MediaFormat[(this.r.length * numArr.length)];
                for (int i4 = 0; i4 < this.r.length; i4++) {
                    int i5 = 0;
                    while (true) {
                        Integer[] numArr2 = this.s;
                        if (i5 >= numArr2.length) {
                            break;
                        }
                        mediaFormatArr[(numArr2.length * i4) + i5] = b(i2, i3);
                        mediaFormatArr[(this.s.length * i4) + i5].setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, this.r[i4]);
                        Integer[] numArr3 = this.s;
                        if (numArr3[i5] != null) {
                            mediaFormatArr[(numArr3.length * i4) + i5].setInteger("bitrate-mode", numArr3[i5].intValue());
                        }
                        i5++;
                    }
                }
                return mediaFormatArr;
            }
        }
        mediaFormatArr = new MediaFormat[this.r.length];
        for (int i6 = 0; i6 < this.r.length; i6++) {
            mediaFormatArr[i6] = b(i2, i3);
            mediaFormatArr[i6].setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, this.r[i6]);
        }
        return mediaFormatArr;
    }

    /* access modifiers changed from: package-private */
    public MediaFormat a() {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.u, this.v, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, this.w);
        createAudioFormat.setInteger("channel-count", 1);
        return createAudioFormat;
    }
}
