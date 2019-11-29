package com.tencent.liteav.txcvodplayer;

import android.view.View;
import com.tencent.ijk.media.player.IMediaPlayer;

public interface a {

    /* renamed from: com.tencent.liteav.txcvodplayer.a$a  reason: collision with other inner class name */
    public interface C0493a {
        void a(b bVar);

        void a(b bVar, int i, int i2);

        void a(b bVar, int i, int i2, int i3);
    }

    public interface b {
        a a();

        void a(IMediaPlayer iMediaPlayer);
    }

    void addRenderCallback(C0493a aVar);

    View getView();

    void removeRenderCallback(C0493a aVar);

    void setAspectRatio(int i);

    void setVideoRotation(int i);

    void setVideoSampleAspectRatio(int i, int i2);

    void setVideoSize(int i, int i2);

    boolean shouldWaitForResize();
}
