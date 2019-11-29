package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.a;

public class c extends TXCAudioBasePlayController implements com.tencent.liteav.audio.c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f31140a = ("AudioCenter:" + c.class.getSimpleName());

    /* renamed from: b  reason: collision with root package name */
    private a f31141b;

    public c(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.mJitterBuffer != 0) {
            nativeDestoryJitterBuffer(this.mJitterBuffer);
            this.mJitterBuffer = 0;
        }
    }

    public static void a(Context context, int i) {
        TXCTraeJNI.setContext(context);
        TXCTraeJNI.nativeSetAudioMode(i);
    }

    public int startPlay() {
        TXCLog.i(f31140a, "start play audio!");
        if (!this.mIsPlaying) {
            super.startPlay();
            if (!nativeIsTracksEmpty()) {
                TXCTraeJNI.InitTraeEngineLibrary(this.mContext);
                TXCTraeJNI.traeStartPlay(this.mContext);
            }
            TXCLog.i(f31140a, "finish start play audio!");
            return 0;
        }
        TXCLog.e(f31140a, "repeat start play audio, ignore it!");
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
    }

    public int stopPlay() {
        TXCLog.i(f31140a, "stop play audio!");
        if (this.mIsPlaying) {
            super.stopPlay();
            if (this.mJitterBuffer != 0) {
                nativeDestoryJitterBuffer(this.mJitterBuffer);
                this.mJitterBuffer = 0;
            }
            if (nativeIsTracksEmpty()) {
                TXCTraeJNI.traeStopPlay();
            }
            this.f31141b = null;
            TXCLog.i(f31140a, "finish stop play audio!");
            return 0;
        }
        TXCLog.e(f31140a, "repeat stop play audio, ignore it!");
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
    }
}
