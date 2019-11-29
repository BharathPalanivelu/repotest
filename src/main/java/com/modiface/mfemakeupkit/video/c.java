package com.modiface.mfemakeupkit.video;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

class c {

    /* renamed from: a  reason: collision with root package name */
    private a f15414a = a.UNINITIALIZED;

    /* renamed from: b  reason: collision with root package name */
    private MediaCodec f15415b = null;

    /* renamed from: c  reason: collision with root package name */
    private Surface f15416c = null;

    /* renamed from: d  reason: collision with root package name */
    private MediaCodec.BufferInfo f15417d = new MediaCodec.BufferInfo();

    /* renamed from: e  reason: collision with root package name */
    private boolean f15418e = false;

    private enum a {
        UNINITIALIZED,
        INITIALIZED,
        STARTED
    }

    c() {
    }

    /* access modifiers changed from: package-private */
    public void a(String str) throws IOException {
        if (!d()) {
            this.f15415b = MediaCodec.createEncoderByType(str);
            this.f15414a = a.INITIALIZED;
        }
    }

    /* access modifiers changed from: package-private */
    public Surface b() {
        return this.f15416c;
    }

    /* access modifiers changed from: package-private */
    public MediaFormat c() throws IllegalStateException {
        if (!d()) {
            return null;
        }
        return this.f15415b.getOutputFormat();
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f15414a != a.UNINITIALIZED;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f15414a == a.STARTED;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (e()) {
            try {
                this.f15415b.stop();
            } catch (IllegalStateException unused) {
            }
        }
        Surface surface = this.f15416c;
        if (surface != null) {
            surface.release();
            this.f15416c = null;
        }
        if (d()) {
            this.f15415b.release();
            this.f15415b = null;
            this.f15414a = a.UNINITIALIZED;
        }
        this.f15417d = new MediaCodec.BufferInfo();
        this.f15418e = false;
    }

    /* access modifiers changed from: package-private */
    public void g() throws MediaCodec.CodecException {
        if (e()) {
            this.f15415b.signalEndOfInputStream();
        }
    }

    /* access modifiers changed from: package-private */
    public d b(long j) throws IllegalStateException {
        if (e() && !this.f15418e) {
            ByteBuffer[] inputBuffers = this.f15415b.getInputBuffers();
            int dequeueInputBuffer = this.f15415b.dequeueInputBuffer(j);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                return new d(dequeueInputBuffer, byteBuffer);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(MediaFormat[] mediaFormatArr, boolean z) throws IllegalStateException, MediaCodec.CryptoException {
        if (d()) {
            int i = 0;
            while (i < mediaFormatArr.length) {
                try {
                    this.f15415b.configure(mediaFormatArr[i], (Surface) null, (MediaCrypto) null, 1);
                    break;
                } catch (MediaCodec.CryptoException | IllegalStateException e2) {
                    if (i < mediaFormatArr.length - 1) {
                        i++;
                    } else {
                        throw e2;
                    }
                }
            }
            if (z) {
                Surface surface = this.f15416c;
                if (surface != null) {
                    surface.release();
                    this.f15416c = null;
                }
                this.f15416c = this.f15415b.createInputSurface();
            }
            this.f15415b.start();
            this.f15414a = a.STARTED;
        }
    }

    /* access modifiers changed from: package-private */
    public d a(long j) throws IllegalStateException {
        ByteBuffer byteBuffer = null;
        if (!e() || this.f15418e) {
            return null;
        }
        int dequeueOutputBuffer = this.f15415b.dequeueOutputBuffer(this.f15417d, j);
        if (dequeueOutputBuffer >= 0) {
            byteBuffer = this.f15415b.getOutputBuffers()[dequeueOutputBuffer];
            if (byteBuffer != null) {
                MediaCodec.BufferInfo bufferInfo = this.f15417d;
                if (bufferInfo.size > 0) {
                    byteBuffer.position(bufferInfo.offset);
                    MediaCodec.BufferInfo bufferInfo2 = this.f15417d;
                    byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                }
            }
        }
        if ((this.f15417d.flags & 4) != 0) {
            this.f15418e = true;
        }
        return new d(dequeueOutputBuffer, byteBuffer);
    }

    /* access modifiers changed from: package-private */
    public void a(d dVar) throws IllegalStateException {
        if (d() && dVar != null && dVar.a()) {
            this.f15415b.releaseOutputBuffer(dVar.f15423a, false);
        }
    }

    /* access modifiers changed from: package-private */
    public MediaCodec.BufferInfo a() {
        return this.f15417d;
    }

    /* access modifiers changed from: package-private */
    public void a(d dVar, int i, int i2, long j) throws MediaCodec.CryptoException, IllegalStateException {
        if (dVar != null && dVar.a()) {
            this.f15415b.queueInputBuffer(dVar.f15423a, i, i2, j, 0);
        }
    }
}
