package com.google.android.exoplayer2.o;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.s.i;
import com.google.android.exoplayer2.s.v;

@TargetApi(16)
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f10994a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f10995b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f10996c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f10997d;

    /* renamed from: e  reason: collision with root package name */
    private final String f10998e;

    /* renamed from: f  reason: collision with root package name */
    private final MediaCodecInfo.CodecCapabilities f10999f;

    public static a a(String str) {
        return new a(str, (String) null, (MediaCodecInfo.CodecCapabilities) null, false, false);
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, z, z2);
    }

    private a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        this.f10994a = (String) com.google.android.exoplayer2.s.a.a(str);
        this.f10998e = str2;
        this.f10999f = codecCapabilities;
        boolean z3 = true;
        this.f10995b = !z && codecCapabilities != null && a(codecCapabilities);
        this.f10996c = codecCapabilities != null && c(codecCapabilities);
        if (!z2 && (codecCapabilities == null || !e(codecCapabilities))) {
            z3 = false;
        }
        this.f10997d = z3;
    }

    public MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f10999f;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.f10999f.profileLevels;
    }

    public boolean b(String str) {
        if (str == null || this.f10998e == null) {
            return true;
        }
        String f2 = i.f(str);
        if (f2 == null) {
            return true;
        }
        if (!this.f10998e.equals(f2)) {
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
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f10999f;
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
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f10999f;
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
        return new Point(v.a(i, widthAlignment) * widthAlignment, v.a(i2, heightAlignment) * heightAlignment);
    }

    @TargetApi(21)
    public boolean a(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f10999f;
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
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f10999f;
        if (codecCapabilities == null) {
            c("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("channelCount.aCaps");
            return false;
        } else if (a(this.f10994a, this.f10998e, audioCapabilities.getMaxInputChannelCount()) >= i) {
            return true;
        } else {
            c("channelCount.support, " + i);
            return false;
        }
    }

    private void c(String str) {
        Log.d("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f10994a + ", " + this.f10998e + "] [" + v.f11453e + "]");
    }

    private void d(String str) {
        Log.d("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f10994a + ", " + this.f10998e + "] [" + v.f11453e + "]");
    }

    private static int a(String str, String str2, int i) {
        int i2;
        if (i > 1 || ((v.f11449a >= 26 && i > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        if ("audio/ac3".equals(str2)) {
            i2 = 6;
        } else {
            i2 = "audio/eac3".equals(str2) ? 16 : 30;
        }
        Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
        return i2;
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return v.f11449a >= 19 && b(codecCapabilities);
    }

    @TargetApi(19)
    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return v.f11449a >= 21 && d(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return v.f11449a >= 21 && f(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @TargetApi(21)
    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d2) {
        if (d2 == -1.0d || d2 <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d2);
    }
}
