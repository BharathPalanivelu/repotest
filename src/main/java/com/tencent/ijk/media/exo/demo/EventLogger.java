package com.tencent.ijk.media.exo.demo;

import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.a.d;
import com.google.android.exoplayer2.ac;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.al;
import com.google.android.exoplayer2.ar;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.b.h;
import com.google.android.exoplayer2.f.b.k;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.l.e;
import com.google.android.exoplayer2.l.g;
import com.google.android.exoplayer2.m.i;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.w;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class EventLogger implements d, ad.a, f.a, com.google.android.exoplayer2.k.f, r, w.a {
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final String TAG = "EventLogger";
    private static final NumberFormat TIME_FORMAT = NumberFormat.getInstance(Locale.US);
    private long mBytesLoaded = 0;
    private long mBytesLoadedSeconds = 0;
    private long mLastBytesLoadedTime = 0;
    private final ar.a period;
    private final long startTimeMs;
    private final e trackSelector;
    private final ar.b window;

    private static String getAdaptiveSupportString(int i, int i2) {
        return i < 2 ? "N/A" : i2 != 0 ? i2 != 4 ? i2 != 8 ? "?" : "YES" : "YES_NOT_SEAMLESS" : "NO";
    }

    private static String getFormatSupportString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "?" : "YES" : "NO_EXCEEDS_CAPABILITIES" : "NO_UNSUPPORTED_TYPE" : "NO";
    }

    private static String getStateString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "E" : "R" : "B" : "I";
    }

    private static String getTrackStatusString(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    public void onDownstreamFormatChanged(int i, j jVar, int i2, Object obj, long j) {
    }

    public void onLoadCanceled(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
    }

    public void onUpstreamDiscarded(int i, long j, long j2) {
    }

    public void onVideoSizeChanged(int i, int i2, int i3, float f2) {
    }

    static {
        TIME_FORMAT.setMinimumFractionDigits(2);
        TIME_FORMAT.setMaximumFractionDigits(2);
        TIME_FORMAT.setGroupingUsed(false);
    }

    public EventLogger(e eVar) {
        this.trackSelector = eVar;
        this.window = new ar.b();
        this.period = new ar.a();
        this.startTimeMs = SystemClock.elapsedRealtime();
    }

    public void onLoadingChanged(boolean z) {
        Log.d(TAG, "loading [" + z + "]");
    }

    public void onPlayerStateChanged(boolean z, int i) {
        Log.d(TAG, "state [" + getSessionTimeString() + ", " + z + ", " + getStateString(i) + "]");
    }

    public void onPositionDiscontinuity() {
        Log.d(TAG, "positionDiscontinuity");
    }

    public void onPlaybackParametersChanged(al alVar) {
        Log.d(TAG, "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[]{Float.valueOf(alVar.f9109b), Float.valueOf(alVar.f9110c)}));
    }

    public void onTimelineChanged(ar arVar, Object obj) {
        int a2 = arVar.a();
        int b2 = arVar.b();
        Log.d(TAG, "sourceInfo [periodCount=" + a2 + ", windowCount=" + b2);
        for (int i = 0; i < Math.min(a2, 3); i++) {
            arVar.a(i, this.period);
            Log.d(TAG, "  period [" + getTimeString(this.period.a()) + "]");
        }
        if (a2 > 3) {
            Log.d(TAG, "  ...");
        }
        for (int i2 = 0; i2 < Math.min(b2, 3); i2++) {
            arVar.a(i2, this.window);
            Log.d(TAG, "  window [" + getTimeString(this.window.b()) + ", " + this.window.f9132d + ", " + this.window.f9133e + "]");
        }
        if (b2 > 3) {
            Log.d(TAG, "  ...");
        }
        Log.d(TAG, "]");
    }

    public void onPlayerError(ac acVar) {
        Log.e(TAG, "playerFailed [" + getSessionTimeString() + "]", acVar);
    }

    public void onTracksChanged(com.google.android.exoplayer2.source.ad adVar, g gVar) {
        String str;
        String str2;
        EventLogger eventLogger;
        EventLogger eventLogger2 = this;
        e.a a2 = eventLogger2.trackSelector.a();
        if (a2 == null) {
            Log.d(TAG, "Tracks []");
            return;
        }
        Log.d(TAG, "Tracks [");
        int i = 0;
        while (true) {
            str = "  ]";
            str2 = " [";
            if (i >= a2.f10726a) {
                break;
            }
            com.google.android.exoplayer2.source.ad a3 = a2.a(i);
            com.google.android.exoplayer2.l.f a4 = gVar.a(i);
            if (a3.f11538b > 0) {
                Log.d(TAG, "  Renderer:" + i + str2);
                int i2 = 0;
                while (i2 < a3.f11538b) {
                    com.google.android.exoplayer2.source.ac a5 = a3.a(i2);
                    com.google.android.exoplayer2.source.ad adVar2 = a3;
                    String str3 = str;
                    String adaptiveSupportString = getAdaptiveSupportString(a5.f11534a, a2.a(i, i2, false));
                    Log.d(TAG, "    Group:" + i2 + ", adaptive_supported=" + adaptiveSupportString + str2);
                    int i3 = 0;
                    while (i3 < a5.f11534a) {
                        String trackStatusString = getTrackStatusString(a4, a5, i3);
                        String formatSupportString = getFormatSupportString(a2.a(i, i2, i3));
                        String str4 = str2;
                        Log.d(TAG, "      " + trackStatusString + " Track:" + i3 + ", " + j.b(a5.a(i3)) + ", supported=" + formatSupportString);
                        i3++;
                        str2 = str4;
                    }
                    String str5 = str2;
                    Log.d(TAG, "    ]");
                    i2++;
                    a3 = adVar2;
                    str = str3;
                }
                String str6 = str;
                if (a4 != null) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= a4.e()) {
                            break;
                        }
                        a aVar = a4.a(i4).f10425d;
                        if (aVar != null) {
                            Log.d(TAG, "    Metadata [");
                            eventLogger = this;
                            eventLogger.printMetadata(aVar, "      ");
                            Log.d(TAG, "    ]");
                            break;
                        }
                        i4++;
                    }
                    Log.d(TAG, str6);
                }
                eventLogger = this;
                Log.d(TAG, str6);
            } else {
                eventLogger = eventLogger2;
            }
            i++;
            eventLogger2 = eventLogger;
        }
        EventLogger eventLogger3 = eventLogger2;
        String str7 = str;
        String str8 = str2;
        com.google.android.exoplayer2.source.ad a6 = a2.a();
        if (a6.f11538b > 0) {
            Log.d(TAG, "  Renderer:None [");
            int i5 = 0;
            while (i5 < a6.f11538b) {
                StringBuilder sb = new StringBuilder();
                sb.append("    Group:");
                sb.append(i5);
                String str9 = str8;
                sb.append(str9);
                Log.d(TAG, sb.toString());
                com.google.android.exoplayer2.source.ac a7 = a6.a(i5);
                int i6 = 0;
                while (i6 < a7.f11534a) {
                    String trackStatusString2 = getTrackStatusString(false);
                    com.google.android.exoplayer2.source.ad adVar3 = a6;
                    String formatSupportString2 = getFormatSupportString(0);
                    Log.d(TAG, "      " + trackStatusString2 + " Track:" + i6 + ", " + j.b(a7.a(i6)) + ", supported=" + formatSupportString2);
                    i6++;
                    a6 = adVar3;
                }
                com.google.android.exoplayer2.source.ad adVar4 = a6;
                Log.d(TAG, "    ]");
                i5++;
                str8 = str9;
            }
            Log.d(TAG, str7);
        }
        Log.d(TAG, "]");
    }

    public void onMetadata(a aVar) {
        Log.d(TAG, "onMetadata [");
        printMetadata(aVar, "  ");
        Log.d(TAG, "]");
    }

    public void onAudioEnabled(com.google.android.exoplayer2.d.d dVar) {
        Log.d(TAG, "audioEnabled [" + getSessionTimeString() + "]");
    }

    public void onAudioSessionId(int i) {
        Log.d(TAG, "audioSessionId [" + i + "]");
    }

    public void onAudioDecoderInitialized(String str, long j, long j2) {
        Log.d(TAG, "audioDecoderInitialized [" + getSessionTimeString() + ", " + str + "]");
    }

    public void onAudioInputFormatChanged(j jVar) {
        Log.d(TAG, "audioFormatChanged [" + getSessionTimeString() + ", " + j.b(jVar) + "]");
    }

    public void onAudioDisabled(com.google.android.exoplayer2.d.d dVar) {
        Log.d(TAG, "audioDisabled [" + getSessionTimeString() + "]");
    }

    public void onAudioTrackUnderrun(int i, long j, long j2) {
        printInternalError("audioTrackUnderrun [" + i + ", " + j + ", " + j2 + "]", (Exception) null);
    }

    public void onVideoEnabled(com.google.android.exoplayer2.d.d dVar) {
        Log.d(TAG, "videoEnabled [" + getSessionTimeString() + "]");
    }

    public void onVideoDecoderInitialized(String str, long j, long j2) {
        Log.d(TAG, "videoDecoderInitialized [" + getSessionTimeString() + ", " + str + "]");
    }

    public void onVideoInputFormatChanged(j jVar) {
        Log.d(TAG, "videoFormatChanged [" + getSessionTimeString() + ", " + j.b(jVar) + "]");
    }

    public void onVideoDisabled(com.google.android.exoplayer2.d.d dVar) {
        Log.d(TAG, "videoDisabled [" + getSessionTimeString() + "]");
    }

    public void onDroppedFrames(int i, long j) {
        Log.d(TAG, "droppedFrames [" + getSessionTimeString() + ", " + i + "]");
    }

    public void onRenderedFirstFrame(Surface surface) {
        Log.d(TAG, "renderedFirstFrame [" + surface + "]");
    }

    public void onDrmSessionManagerError(Exception exc) {
        printInternalError("drmSessionManagerError", exc);
    }

    public void onDrmKeysRestored() {
        Log.d(TAG, "drmKeysRestored [" + getSessionTimeString() + "]");
    }

    public void onDrmKeysRemoved() {
        Log.d(TAG, "drmKeysRemoved [" + getSessionTimeString() + "]");
    }

    public void onDrmKeysLoaded() {
        Log.d(TAG, "drmKeysLoaded [" + getSessionTimeString() + "]");
    }

    public void onLoadError(IOException iOException) {
        printInternalError("loadError", iOException);
    }

    public void onLoadStarted(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3) {
        if (this.mLastBytesLoadedTime == 0) {
            this.mLastBytesLoadedTime = System.currentTimeMillis();
        }
    }

    public void onLoadError(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        printInternalError("loadError", iOException);
    }

    public void onLoadCompleted(i iVar, int i, int i2, j jVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        long currentTimeMillis = System.currentTimeMillis();
        long j6 = this.mLastBytesLoadedTime;
        if (j6 != 0) {
            logBytesLoadedInSeconds(j5, (float) ((currentTimeMillis - j6) / 1000));
            this.mLastBytesLoadedTime = currentTimeMillis;
        }
    }

    private void logBytesLoadedInSeconds(long j, float f2) {
        this.mBytesLoaded += j;
        this.mBytesLoadedSeconds = (long) (((float) this.mBytesLoadedSeconds) + f2);
    }

    public int getObservedBitrate() {
        long j = this.mBytesLoadedSeconds;
        if (j == 0) {
            return 0;
        }
        double d2 = (double) (this.mBytesLoaded / j);
        Double.isNaN(d2);
        StringBuilder sb = new StringBuilder();
        sb.append(" mBytesLoaded ");
        sb.append(this.mBytesLoaded);
        sb.append(" in ");
        sb.append(this.mBytesLoadedSeconds);
        sb.append(" seconds (");
        int i = (int) (d2 * 8.0d);
        sb.append(i);
        sb.append(" b/s indicated ");
        Log.d(TAG, sb.toString());
        return i;
    }

    private void printInternalError(String str, Exception exc) {
        Log.e(TAG, "internalError [" + getSessionTimeString() + ", " + str + "]", exc);
    }

    private void printMetadata(a aVar, String str) {
        for (int i = 0; i < aVar.a(); i++) {
            a.C0166a a2 = aVar.a(i);
            if (a2 instanceof com.google.android.exoplayer2.f.b.j) {
                com.google.android.exoplayer2.f.b.j jVar = (com.google.android.exoplayer2.f.b.j) a2;
                Log.d(TAG, str + String.format("%s: value=%s", new Object[]{jVar.f9819f, jVar.f9823b}));
            } else if (a2 instanceof k) {
                k kVar = (k) a2;
                Log.d(TAG, str + String.format("%s: url=%s", new Object[]{kVar.f9819f, kVar.f9825b}));
            } else if (a2 instanceof com.google.android.exoplayer2.f.b.i) {
                com.google.android.exoplayer2.f.b.i iVar = (com.google.android.exoplayer2.f.b.i) a2;
                Log.d(TAG, str + String.format("%s: owner=%s", new Object[]{iVar.f9819f, iVar.f9820a}));
            } else if (a2 instanceof com.google.android.exoplayer2.f.b.f) {
                com.google.android.exoplayer2.f.b.f fVar = (com.google.android.exoplayer2.f.b.f) a2;
                Log.d(TAG, str + String.format("%s: mimeType=%s, filename=%s, description=%s", new Object[]{fVar.f9819f, fVar.f9810a, fVar.f9811b, fVar.f9812c}));
            } else if (a2 instanceof com.google.android.exoplayer2.f.b.a) {
                com.google.android.exoplayer2.f.b.a aVar2 = (com.google.android.exoplayer2.f.b.a) a2;
                Log.d(TAG, str + String.format("%s: mimeType=%s, description=%s", new Object[]{aVar2.f9819f, aVar2.f9791a, aVar2.f9792b}));
            } else if (a2 instanceof com.google.android.exoplayer2.f.b.e) {
                com.google.android.exoplayer2.f.b.e eVar = (com.google.android.exoplayer2.f.b.e) a2;
                Log.d(TAG, str + String.format("%s: language=%s, description=%s", new Object[]{eVar.f9819f, eVar.f9807a, eVar.f9808b}));
            } else if (a2 instanceof h) {
                Log.d(TAG, str + String.format("%s", new Object[]{((h) a2).f9819f}));
            } else if (a2 instanceof com.google.android.exoplayer2.f.a.a) {
                com.google.android.exoplayer2.f.a.a aVar3 = (com.google.android.exoplayer2.f.a.a) a2;
                Log.d(TAG, str + String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[]{aVar3.f9782a, Long.valueOf(aVar3.f9785d), aVar3.f9783b}));
            }
        }
    }

    private String getSessionTimeString() {
        return getTimeString(SystemClock.elapsedRealtime() - this.startTimeMs);
    }

    private static String getTimeString(long j) {
        return j == -9223372036854775807L ? "?" : TIME_FORMAT.format((double) (((float) j) / 1000.0f));
    }

    private static String getTrackStatusString(com.google.android.exoplayer2.l.f fVar, com.google.android.exoplayer2.source.ac acVar, int i) {
        return getTrackStatusString((fVar == null || fVar.d() != acVar || fVar.c(i) == -1) ? false : true);
    }
}
