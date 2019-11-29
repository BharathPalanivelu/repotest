package com.tencent.ijk.media.exo;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.a.d;
import com.google.android.exoplayer2.ab;
import com.google.android.exoplayer2.ac;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.ae;
import com.google.android.exoplayer2.al;
import com.google.android.exoplayer2.aq;
import com.google.android.exoplayer2.ar;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.l.a;
import com.google.android.exoplayer2.l.c;
import com.google.android.exoplayer2.l.g;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.k;
import com.google.android.exoplayer2.m.m;
import com.google.android.exoplayer2.m.o;
import com.google.android.exoplayer2.m.q;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.source.d.a;
import com.google.android.exoplayer2.source.dash.i;
import com.google.android.exoplayer2.source.dash.l;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.source.y;
import com.tencent.ijk.media.exo.demo.EventLogger;
import com.tencent.ijk.media.player.AbstractMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IjkBitrateItem;
import com.tencent.ijk.media.player.MediaInfo;
import com.tencent.ijk.media.player.misc.IjkTrackInfo;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Map;

public class IjkExoMediaPlayer extends AbstractMediaPlayer implements ad.a {
    private static final k BANDWIDTH_METER = new k();
    private EventLogger eventLogger;
    private Context mAppContext;
    private Uri mDataSource;
    private SimplePlayerListener mSimpleListener = new SimplePlayerListener();
    private Surface mSurface;
    /* access modifiers changed from: private */
    public int mVideoHeight;
    /* access modifiers changed from: private */
    public int mVideoWidth;
    private Handler mainHandler;
    private f.a mediaDataSourceFactory;
    private aq player;
    private c trackSelector;

    public int getAudioSessionId() {
        return 0;
    }

    public int getBitrateIndex() {
        return 0;
    }

    public MediaInfo getMediaInfo() {
        return null;
    }

    public IjkTrackInfo[] getTrackInfo() {
        return null;
    }

    public int getVideoSarDen() {
        return 1;
    }

    public int getVideoSarNum() {
        return 1;
    }

    public boolean isLooping() {
        return false;
    }

    public boolean isPlayable() {
        return true;
    }

    public void onLoadingChanged(boolean z) {
    }

    public void onPlaybackParametersChanged(al alVar) {
    }

    public void onPositionDiscontinuity() {
    }

    public void onTimelineChanged(ar arVar, Object obj) {
    }

    public void onTracksChanged(com.google.android.exoplayer2.source.ad adVar, g gVar) {
    }

    public void setAudioStreamType(int i) {
    }

    public void setBitrateIndex(int i) {
    }

    public void setKeepInBackground(boolean z) {
    }

    public void setLogEnabled(boolean z) {
    }

    public void setScreenOnWhilePlaying(boolean z) {
    }

    public void setWakeMode(Context context, int i) {
    }

    public IjkExoMediaPlayer(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.mediaDataSourceFactory = buildDataSourceFactory(true);
        this.mainHandler = new Handler();
        ab abVar = new ab(context);
        this.trackSelector = new c(new a.C0177a(BANDWIDTH_METER));
        this.player = ae.a(abVar, this.trackSelector);
        this.player.a((ad.a) this);
        this.eventLogger = new EventLogger(this.trackSelector);
        this.player.a((ad.a) this.eventLogger);
        this.player.a((d) this.eventLogger);
        this.player.a((com.google.android.exoplayer2.k.f) this.eventLogger);
        this.player.a((f.a) this.eventLogger);
        this.player.a((aq.b) this.mSimpleListener);
    }

    public aq getPlayer() {
        return this.player;
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            setSurface((Surface) null);
        } else {
            setSurface(surfaceHolder.getSurface());
        }
    }

    public void setSurface(Surface surface) {
        this.mSurface = surface;
        aq aqVar = this.player;
        if (aqVar != null) {
            aqVar.a(surface);
        }
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void setDataSource(Context context, Uri uri) {
        this.mDataSource = uri;
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        setDataSource(context, uri);
    }

    public void setDataSource(String str) {
        setDataSource(this.mAppContext, Uri.parse(str));
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        throw new UnsupportedOperationException("no support");
    }

    public String getDataSource() {
        return this.mDataSource.toString();
    }

    public void prepareAsync() {
        this.player.a(buildMediaSource(this.mDataSource, (String) null));
        this.player.a(false);
    }

    public void start() {
        aq aqVar = this.player;
        if (aqVar != null) {
            aqVar.a(true);
        }
    }

    public void stop() throws IllegalStateException {
        aq aqVar = this.player;
        if (aqVar != null) {
            aqVar.d();
        }
    }

    public void pause() throws IllegalStateException {
        aq aqVar = this.player;
        if (aqVar != null) {
            aqVar.a(false);
        }
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public boolean isPlaying() {
        aq aqVar = this.player;
        if (aqVar == null) {
            return false;
        }
        int a2 = aqVar.a();
        if (a2 == 2 || a2 == 3) {
            return this.player.b();
        }
        return false;
    }

    public void seekTo(long j) throws IllegalStateException {
        aq aqVar = this.player;
        if (aqVar != null) {
            aqVar.a(j);
        }
    }

    public long getCurrentPosition() {
        aq aqVar = this.player;
        if (aqVar == null) {
            return 0;
        }
        return aqVar.f();
    }

    public long getDuration() {
        aq aqVar = this.player;
        if (aqVar == null) {
            return 0;
        }
        return aqVar.e();
    }

    public void reset() {
        aq aqVar = this.player;
        if (aqVar != null) {
            aqVar.d();
            this.player.b((ad.a) this.eventLogger);
            this.player = null;
        }
        this.mSurface = null;
        this.mDataSource = null;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    public void setLooping(boolean z) {
        throw new UnsupportedOperationException("no support");
    }

    public void setRate(float f2) {
        this.player.a(new al(f2, f2));
    }

    public float getRate() {
        return this.player.c().f9109b;
    }

    public void setVolume(float f2, float f3) {
        this.player.a((f2 + f3) / 2.0f);
    }

    public void release() {
        if (this.player != null) {
            reset();
            this.eventLogger = null;
        }
    }

    public int getBufferedPercentage() {
        aq aqVar = this.player;
        if (aqVar == null) {
            return 0;
        }
        return aqVar.g();
    }

    public j getVideoFormat() {
        aq aqVar = this.player;
        if (aqVar == null) {
            return null;
        }
        return aqVar.h();
    }

    public int getObservedBitrate() {
        return this.eventLogger.getObservedBitrate();
    }

    public com.google.android.exoplayer2.d.d getVideoDecoderCounters() {
        return this.player.i();
    }

    public y buildMediaSource(Uri uri, String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            i = t.b(uri);
        } else {
            i = t.i("." + str);
        }
        if (i == 0) {
            return new i(uri, buildDataSourceFactory(false), new l.a(this.mediaDataSourceFactory), this.mainHandler, this.eventLogger);
        } else if (i == 1) {
            return new com.google.android.exoplayer2.source.d.d(uri, buildDataSourceFactory(false), new a.C0190a(this.mediaDataSourceFactory), this.mainHandler, this.eventLogger);
        } else if (i == 2) {
            return new com.google.android.exoplayer2.source.c.t(uri, this.mediaDataSourceFactory, this.mainHandler, this.eventLogger);
        } else {
            if (i == 3) {
                return new w(uri, this.mediaDataSourceFactory, new com.google.android.exoplayer2.e.c(), this.mainHandler, this.eventLogger);
            }
            throw new IllegalStateException("Unsupported type: " + i);
        }
    }

    private f.a buildDataSourceFactory(boolean z) {
        k kVar = z ? BANDWIDTH_METER : null;
        return new m(this.mAppContext, kVar, buildHttpDataSourceFactory(kVar));
    }

    public q.b buildHttpDataSourceFactory(k kVar) {
        return new o(t.a(this.mAppContext, "ExoPlayerDemo"), kVar);
    }

    private class SimplePlayerListener implements aq.b {
        private SimplePlayerListener() {
        }

        public void onVideoSizeChanged(int i, int i2, int i3, float f2) {
            int unused = IjkExoMediaPlayer.this.mVideoWidth = i;
            int unused2 = IjkExoMediaPlayer.this.mVideoHeight = i2;
            IjkExoMediaPlayer.this.notifyOnVideoSizeChanged(i, i2, 1, 1);
            if (i3 > 0) {
                boolean unused3 = IjkExoMediaPlayer.this.notifyOnInfo(10001, i3);
            }
        }

        public void onRenderedFirstFrame() {
            boolean unused = IjkExoMediaPlayer.this.notifyOnInfo(3, 0);
        }
    }

    public void onPlayerStateChanged(boolean z, int i) {
        if (i == 1) {
            notifyOnCompletion();
        } else if (i == 2) {
            notifyOnInfo(IMediaPlayer.MEDIA_INFO_BUFFERING_START, this.player.g());
        } else if (i == 3) {
            notifyOnPrepared();
        } else if (i == 4) {
            notifyOnCompletion();
        }
    }

    public void onPlayerError(ac acVar) {
        notifyOnError(1, 1);
    }

    public ArrayList<IjkBitrateItem> getSupportedBitrates() {
        return new ArrayList<>();
    }
}
