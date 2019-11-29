package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.a;
import java.lang.ref.WeakReference;

public class b extends TXCAudioBasePlayController {

    /* renamed from: a  reason: collision with root package name */
    public static final String f31137a = ("AudioCenter:" + b.class.getSimpleName());

    /* renamed from: b  reason: collision with root package name */
    private a f31138b;

    /* renamed from: c  reason: collision with root package name */
    private a f31139c;

    public b(Context context) {
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
        d.a().a(context, i);
    }

    public int startPlay() {
        TXCLog.i(f31137a, "start play audio!");
        if (!this.mIsPlaying) {
            if (this.mIsHWAcceleration) {
                this.f31138b = new a();
                this.f31138b.a((WeakReference<c>) new WeakReference(this));
            }
            if (!nativeIsTracksEmpty()) {
                d.a().b();
            }
            this.mIsPlaying = true;
            TXCLog.i(f31137a, "finish start play audio!");
            return 0;
        }
        TXCLog.e(f31137a, "repeat start play audio, ignore it!");
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
    }

    public int stopPlay() {
        TXCLog.i(f31137a, "stop play audio!");
        if (this.mIsPlaying) {
            super.stopPlay();
            if (this.mJitterBuffer != 0) {
                nativeDestoryJitterBuffer(this.mJitterBuffer);
                this.mJitterBuffer = 0;
            }
            if (nativeIsTracksEmpty()) {
                d.a().c();
            }
            a aVar = this.f31138b;
            if (aVar != null) {
                aVar.a();
                this.f31138b = null;
            }
            this.f31139c = null;
            TXCLog.i(f31137a, "finish stop play audio!");
            return 0;
        }
        TXCLog.e(f31137a, "repeat stop play audio, ignore it!");
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
    }

    public void onPlayPcmData(byte[] bArr, long j, int i, int i2) {
        super.onPlayPcmData(bArr, j, i, i2);
        if (this.mJitterBuffer != 0) {
            boolean z = this.mIsHWAcceleration;
        }
    }
}
