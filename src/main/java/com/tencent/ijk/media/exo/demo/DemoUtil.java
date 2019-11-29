package com.tencent.ijk.media.exo.demo;

import android.text.TextUtils;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.h;
import java.util.Locale;

final class DemoUtil {
    public static String buildTrackName(j jVar) {
        String str;
        if (h.b(jVar.f10427f)) {
            str = joinWithSeparator(joinWithSeparator(joinWithSeparator(buildResolutionString(jVar), buildBitrateString(jVar)), buildTrackIdString(jVar)), buildSampleMimeTypeString(jVar));
        } else if (h.a(jVar.f10427f)) {
            str = joinWithSeparator(joinWithSeparator(joinWithSeparator(joinWithSeparator(buildLanguageString(jVar), buildAudioPropertyString(jVar)), buildBitrateString(jVar)), buildTrackIdString(jVar)), buildSampleMimeTypeString(jVar));
        } else {
            str = joinWithSeparator(joinWithSeparator(joinWithSeparator(buildLanguageString(jVar), buildBitrateString(jVar)), buildTrackIdString(jVar)), buildSampleMimeTypeString(jVar));
        }
        return str.length() == 0 ? "unknown" : str;
    }

    private static String buildResolutionString(j jVar) {
        if (jVar.j == -1 || jVar.k == -1) {
            return "";
        }
        return jVar.j + "x" + jVar.k;
    }

    private static String buildAudioPropertyString(j jVar) {
        if (jVar.r == -1 || jVar.s == -1) {
            return "";
        }
        return jVar.r + "ch, " + jVar.s + "Hz";
    }

    private static String buildLanguageString(j jVar) {
        return (TextUtils.isEmpty(jVar.y) || "und".equals(jVar.y)) ? "" : jVar.y;
    }

    private static String buildBitrateString(j jVar) {
        if (jVar.f10423b == -1) {
            return "";
        }
        return String.format(Locale.US, "%.2fMbit", new Object[]{Float.valueOf(((float) jVar.f10423b) / 1000000.0f)});
    }

    private static String joinWithSeparator(String str, String str2) {
        if (str.length() == 0) {
            return str2;
        }
        if (str2.length() == 0) {
            return str;
        }
        return str + ", " + str2;
    }

    private static String buildTrackIdString(j jVar) {
        if (jVar.f10422a == null) {
            return "";
        }
        return "id:" + jVar.f10422a;
    }

    private static String buildSampleMimeTypeString(j jVar) {
        return jVar.f10427f == null ? "" : jVar.f10427f;
    }

    private DemoUtil() {
    }
}
