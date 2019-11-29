package com.google.android.exoplayer2.h;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.n.h;
import com.google.android.exoplayer2.n.t;

@TargetApi(16)
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f9902a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f9903b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f9904c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9905d;

    /* renamed from: e  reason: collision with root package name */
    private final MediaCodecInfo.CodecCapabilities f9906e;

    public static a a(String str) {
        return new a(str, (String) null, (MediaCodecInfo.CodecCapabilities) null);
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return new a(str, str2, codecCapabilities);
    }

    private a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        this.f9902a = (String) com.google.android.exoplayer2.n.a.a(str);
        this.f9905d = str2;
        this.f9906e = codecCapabilities;
        boolean z = true;
        this.f9903b = codecCapabilities != null && a(codecCapabilities);
        this.f9904c = (codecCapabilities == null || !c(codecCapabilities)) ? false : z;
    }

    public MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9906e;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.f9906e.profileLevels;
    }

    public boolean b(String str) {
        if (str == null || this.f9905d == null) {
            return true;
        }
        String f2 = h.f(str);
        if (f2 == null) {
            return true;
        }
        if (!this.f9905d.equals(f2)) {
            c("codec.mime " + str + ", " + f2);
            return false;
        }
        Pair<Integer, Integer> a2 = d.a(str);
        if (a2 == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
            if (codecProfileLevel.profile == ((Integer) a2.first).intValue() && codecProfileLevel.level >= ((Integer) a2.second).intValue()) {
                return true;
            }
        }
        c("codec.profileLevel, " + str + ", " + f2);
        return false;
    }

    @TargetApi(21)
    public boolean a(int i, int i2, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9906e;
        if (codecCapabilities == null) {
            c("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("sizeAndRate.vCaps");
            return false;
        } else if (a(videoCapabilities, i, i2, d2)) {
            return true;
        } else {
            if (i >= i2 || !a(videoCapabilities, i2, i, d2)) {
                c("sizeAndRate.support, " + i + "x" + i2 + "x" + d2);
                return false;
            }
            d("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d2);
            return true;
        }
    }

    @TargetApi(21)
    public Point a(int i, int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9906e;
        if (codecCapabilities == null) {
            c("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(t.a(i, widthAlignment) * widthAlignment, t.a(i2, heightAlignment) * heightAlignment);
    }

    @TargetApi(21)
    public boolean a(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9906e;
        if (codecCapabilities == null) {
            c("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            c("sampleRate.support, " + i);
            return false;
        }
    }

    @TargetApi(21)
    public boolean b(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9906e;
        if (codecCapabilities == null) {
            c("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("channelCount.aCaps");
            return false;
        } else if (audioCapabilities.getMaxInputChannelCount() >= i) {
            return true;
        } else {
            c("channelCount.support, " + i);
            return false;
        }
    }

    private void c(String str) {
        Log.d("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f9902a + ", " + this.f9905d + "] [" + t.f10979e + "]");
    }

    private void d(String str) {
        Log.d("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f9902a + ", " + this.f9905d + "] [" + t.f10979e + "]");
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return t.f10975a >= 19 && b(codecCapabilities);
    }

    @TargetApi(19)
    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    @TargetApi(21)
    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d2) {
        if (d2 == -1.0d || d2 <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d2);
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return t.f10975a >= 21 && d(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }
}
