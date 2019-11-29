package com.google.android.exoplayer2.a;

import android.os.Handler;
import com.google.android.exoplayer2.j;

public interface d {
    void onAudioDecoderInitialized(String str, long j, long j2);

    void onAudioDisabled(com.google.android.exoplayer2.d.d dVar);

    void onAudioEnabled(com.google.android.exoplayer2.d.d dVar);

    void onAudioInputFormatChanged(j jVar);

    void onAudioSessionId(int i);

    void onAudioTrackUnderrun(int i, long j, long j2);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f8982a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final d f8983b;

        public a(Handler handler, d dVar) {
            this.f8982a = dVar != null ? (Handler) com.google.android.exoplayer2.n.a.a(handler) : null;
            this.f8983b = dVar;
        }

        public void a(final com.google.android.exoplayer2.d.d dVar) {
            if (this.f8983b != null) {
                this.f8982a.post(new Runnable() {
                    public void run() {
                        a.this.f8983b.onAudioEnabled(dVar);
                    }
                });
            }
        }

        public void a(String str, long j, long j2) {
            if (this.f8983b != null) {
                final String str2 = str;
                final long j3 = j;
                final long j4 = j2;
                this.f8982a.post(new Runnable() {
                    public void run() {
                        a.this.f8983b.onAudioDecoderInitialized(str2, j3, j4);
                    }
                });
            }
        }

        public void a(final j jVar) {
            if (this.f8983b != null) {
                this.f8982a.post(new Runnable() {
                    public void run() {
                        a.this.f8983b.onAudioInputFormatChanged(jVar);
                    }
                });
            }
        }

        public void a(int i, long j, long j2) {
            if (this.f8983b != null) {
                final int i2 = i;
                final long j3 = j;
                final long j4 = j2;
                this.f8982a.post(new Runnable() {
                    public void run() {
                        a.this.f8983b.onAudioTrackUnderrun(i2, j3, j4);
                    }
                });
            }
        }

        public void b(final com.google.android.exoplayer2.d.d dVar) {
            if (this.f8983b != null) {
                this.f8982a.post(new Runnable() {
                    public void run() {
                        dVar.a();
                        a.this.f8983b.onAudioDisabled(dVar);
                    }
                });
            }
        }

        public void a(final int i) {
            if (this.f8983b != null) {
                this.f8982a.post(new Runnable() {
                    public void run() {
                        a.this.f8983b.onAudioSessionId(i);
                    }
                });
            }
        }
    }
}
