package com.tencent.liteav.audio.impl;

import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.Play.d;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.ugc.TXRecordCommon;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static int[] f31193a = {96000, 88200, 64000, 48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000, 24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};

    public static int a(int i) {
        int[] iArr = f31193a;
        if (i >= iArr.length || i < 0) {
            return 0;
        }
        return iArr[i];
    }

    public static int b(int i) {
        if (i == 2) {
            if (d.a().d()) {
                return -5;
            }
            return 0;
        } else if (TXCTraeJNI.nativeTraeIsPlaying()) {
            return -5;
        } else {
            return 0;
        }
    }

    public static int c(int i) {
        if (i == 2) {
            if (f.a().c()) {
                return TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_RECORDER_INVALID;
            }
            return 0;
        } else if (TXCTraeJNI.nativeTraeIsRecording()) {
            return TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_RECORDER_INVALID;
        } else {
            return 0;
        }
    }
}
