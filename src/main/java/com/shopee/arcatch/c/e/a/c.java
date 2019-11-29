package com.shopee.arcatch.c.e.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f26793a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaMuxer f26794b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26795c;

    /* renamed from: d  reason: collision with root package name */
    private int f26796d;

    /* renamed from: e  reason: collision with root package name */
    private int f26797e;

    /* renamed from: f  reason: collision with root package name */
    private b f26798f;

    /* renamed from: g  reason: collision with root package name */
    private b f26799g;
    private int h = -1;
    private int i = -1;
    private LinkedList<Integer> j;
    private LinkedList<MediaCodec.BufferInfo> k;
    private LinkedList<Integer> l;
    private LinkedList<MediaCodec.BufferInfo> m;
    private long n = -1;
    private long o = -1;

    enum a {
        AUDIO,
        VIDEO
    }

    @TargetApi(21)
    public c(String str) throws IOException {
        this.f26793a = str;
        this.f26794b = new MediaMuxer(this.f26793a, 0);
        this.f26797e = 0;
        this.f26796d = 0;
        this.f26795c = false;
        this.j = new LinkedList<>();
        this.k = new LinkedList<>();
        this.l = new LinkedList<>();
        this.m = new LinkedList<>();
    }

    public void a() {
        b bVar = this.f26798f;
        if (bVar != null) {
            bVar.b();
        }
        b bVar2 = this.f26799g;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    public void b() {
        b bVar = this.f26798f;
        if (bVar != null) {
            bVar.a();
        }
        b bVar2 = this.f26799g;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    public void c() {
        b bVar = this.f26798f;
        if (bVar != null) {
            bVar.d();
        }
        b bVar2 = this.f26799g;
        if (bVar2 != null) {
            bVar2.d();
        }
    }

    public void d() {
        b bVar = this.f26798f;
        if (bVar != null) {
            bVar.c();
        }
        b bVar2 = this.f26799g;
        if (bVar2 != null) {
            bVar2.c();
        }
    }

    public synchronized boolean e() {
        return this.f26795c;
    }

    @TargetApi(21)
    public void a(b bVar) {
        if (bVar instanceof d) {
            if (this.f26798f == null) {
                this.f26798f = bVar;
            } else {
                throw new IllegalArgumentException("Video encoder already added.");
            }
        } else if (!(bVar instanceof a)) {
            throw new IllegalArgumentException("unsupported encoder");
        } else if (this.f26799g == null) {
            this.f26799g = bVar;
        } else {
            throw new IllegalArgumentException("Video encoder already added.");
        }
        int i2 = 1;
        int i3 = this.f26798f != null ? 1 : 0;
        if (this.f26799g == null) {
            i2 = 0;
        }
        this.f26796d = i3 + i2;
    }

    @TargetApi(21)
    public synchronized boolean f() {
        this.f26797e++;
        if (this.f26796d > 0 && this.f26797e == this.f26796d) {
            this.f26794b.start();
            this.f26795c = true;
            notifyAll();
            while (true) {
                MediaCodec.BufferInfo poll = this.k.poll();
                if (poll == null) {
                    break;
                }
                b(this.j.poll().intValue(), poll);
            }
            while (true) {
                MediaCodec.BufferInfo poll2 = this.m.poll();
                if (poll2 == null) {
                    break;
                }
                a(this.l.poll().intValue(), poll2);
            }
        }
        return this.f26795c;
    }

    public synchronized void a(int i2, MediaCodec.BufferInfo bufferInfo) {
        if (!this.f26795c) {
            this.l.add(new Integer(i2));
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
            this.m.add(bufferInfo2);
        } else if (this.f26799g != null) {
            a(this.h, this.f26799g.a(i2), bufferInfo);
            this.f26799g.b(i2);
        }
    }

    public synchronized void b(int i2, MediaCodec.BufferInfo bufferInfo) {
        if (!this.f26795c) {
            this.j.add(new Integer(i2));
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
            this.k.add(bufferInfo2);
        } else if (this.f26798f != null) {
            a(this.i, this.f26798f.a(i2), bufferInfo);
            this.f26798f.b(i2);
        }
    }

    @TargetApi(21)
    public synchronized void g() {
        this.f26797e--;
        if (this.f26796d > 0 && this.f26797e <= 0) {
            this.f26794b.stop();
            this.f26799g = null;
            this.f26798f = null;
            this.f26795c = false;
        }
    }

    @TargetApi(21)
    public synchronized int a(MediaFormat mediaFormat, a aVar) {
        int addTrack;
        if (!this.f26795c) {
            addTrack = this.f26794b.addTrack(mediaFormat);
            if (aVar == a.AUDIO) {
                this.h = addTrack;
            } else if (aVar == a.VIDEO) {
                this.i = addTrack;
            }
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return addTrack;
    }

    @TargetApi(21)
    public void a(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (!this.f26795c) {
            return;
        }
        if (this.h == i2) {
            if (this.n < bufferInfo.presentationTimeUs) {
                this.n = bufferInfo.presentationTimeUs;
                this.f26794b.writeSampleData(i2, byteBuffer, bufferInfo);
            }
        } else if (this.o < bufferInfo.presentationTimeUs) {
            this.o = bufferInfo.presentationTimeUs;
            this.f26794b.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }
}
