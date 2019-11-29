package com.shopee.app.e;

import android.media.MediaPlayer;

public final class a {
    public static final void a(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }
}
