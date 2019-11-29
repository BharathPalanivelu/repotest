package com.modiface.mfemakeupkit.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;

final class k {

    /* renamed from: a  reason: collision with root package name */
    private a f15436a = a.UNINITIALIZED;

    /* renamed from: b  reason: collision with root package name */
    private boolean f15437b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15438c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15439d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f15440e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f15441f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f15442g = 0;
    private m h = new m();
    private MediaMuxer i = null;
    private final l j;

    private enum a {
        UNINITIALIZED,
        INITIALIZED,
        STARTED
    }

    k(l lVar) {
        this.j = lVar;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, boolean z) throws IllegalArgumentException, IOException {
        b();
        this.i = new MediaMuxer(str, 0);
        this.f15436a = a.INITIALIZED;
        this.f15439d = z;
        this.h = new m();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f15436a == a.STARTED) {
            m mVar = this.h;
            if (mVar.f15454a > 0) {
                try {
                    if (this.f15438c && mVar.f15455b <= 0) {
                        ByteBuffer wrap = ByteBuffer.wrap(new byte[this.j.x]);
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.offset = 0;
                        bufferInfo.presentationTimeUs = this.f15442g;
                        bufferInfo.size = this.j.x;
                        bufferInfo.flags = 1;
                        this.i.writeSampleData(this.f15441f, wrap, bufferInfo);
                        this.h.f15455b = 1;
                    }
                } catch (IllegalArgumentException | IllegalStateException unused) {
                    this.h.f15455b = 0;
                }
                if (!this.f15438c || this.h.f15455b > 0) {
                    try {
                        this.i.stop();
                    } catch (IllegalStateException unused2) {
                    }
                }
            }
        }
        MediaMuxer mediaMuxer = this.i;
        if (mediaMuxer != null) {
            mediaMuxer.release();
            this.i = null;
        }
        this.f15436a = a.UNINITIALIZED;
        this.f15442g = 0;
        this.f15437b = false;
        this.f15438c = false;
        this.f15439d = false;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f15439d = z;
    }

    /* access modifiers changed from: package-private */
    public m a() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public boolean a(MediaFormat mediaFormat) throws IllegalArgumentException, IllegalStateException {
        if (this.f15439d && this.f15436a == a.INITIALIZED && !this.f15438c && mediaFormat != null) {
            this.f15441f = this.i.addTrack(mediaFormat);
            this.f15438c = true;
        }
        if (!this.f15439d || this.f15438c) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(d dVar, MediaCodec.BufferInfo bufferInfo) throws IllegalArgumentException, IllegalStateException {
        if (this.f15439d && this.f15436a == a.STARTED && this.f15438c && dVar != null && dVar.a() && bufferInfo != null && bufferInfo.size > 0 && (bufferInfo.flags & 2) == 0) {
            this.i.writeSampleData(this.f15441f, dVar.f15424b, bufferInfo);
            m mVar = this.h;
            mVar.f15455b++;
            mVar.f15456c = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(MediaFormat mediaFormat) throws IllegalArgumentException, IllegalStateException {
        if (this.f15436a == a.INITIALIZED && !this.f15437b && mediaFormat != null) {
            this.f15440e = this.i.addTrack(mediaFormat);
            this.f15437b = true;
        }
        return this.f15437b;
    }

    /* access modifiers changed from: package-private */
    public void b(d dVar, MediaCodec.BufferInfo bufferInfo) throws IllegalArgumentException, IllegalStateException {
        if (this.f15436a != a.UNINITIALIZED && this.f15437b && dVar != null && dVar.a() && bufferInfo != null && bufferInfo.size > 0 && (bufferInfo.flags & 2) == 0) {
            if (this.f15436a == a.INITIALIZED && this.f15437b && (!this.f15439d || this.f15438c)) {
                this.i.start();
                this.f15442g = bufferInfo.presentationTimeUs;
                this.f15436a = a.STARTED;
            }
            if (this.f15436a == a.STARTED) {
                this.i.writeSampleData(this.f15440e, dVar.f15424b, bufferInfo);
                this.h.f15454a++;
            }
        }
    }
}
