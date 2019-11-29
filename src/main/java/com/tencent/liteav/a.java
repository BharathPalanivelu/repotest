package com.tencent.liteav;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.c;
import com.tencent.liteav.beauty.d;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class a implements d, com.tencent.liteav.videoencoder.d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f31101a = "a";

    /* renamed from: b  reason: collision with root package name */
    private int f31102b = 300;

    /* renamed from: c  reason: collision with root package name */
    private long f31103c = 0;

    /* renamed from: d  reason: collision with root package name */
    private C0484a f31104d;

    /* renamed from: e  reason: collision with root package name */
    private HandlerThread f31105e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f31106f = false;

    /* renamed from: g  reason: collision with root package name */
    private com.tencent.liteav.videoencoder.b f31107g;
    private TXSNALPacket h;
    private c i = null;
    private ByteBuffer j = null;
    private Bitmap k = null;
    private int l = 0;
    private int m = 0;
    /* access modifiers changed from: private */
    public WeakReference<b> n = null;

    public interface b {
        void a();

        void a(Bitmap bitmap, ByteBuffer byteBuffer, int i, int i2);

        void a(com.tencent.liteav.videoencoder.b bVar);
    }

    public int a(int i2, int i3, int i4) {
        return 0;
    }

    public void a(long j2, long j3, long j4) {
    }

    public void a(MediaFormat mediaFormat) {
    }

    public void a(byte[] bArr, int i2, int i3, int i4, long j2) {
    }

    public void a(int i2, int i3, int i4, long j2) {
        TXCLog.w(f31101a, "bkgpush: got texture");
        com.tencent.liteav.videoencoder.b bVar = this.f31107g;
        if (bVar != null) {
            bVar.a(i2, i3, i4, TXCTimeUtil.getTimeTick());
        }
    }

    public void a(TXSNALPacket tXSNALPacket, int i2) {
        this.h = tXSNALPacket;
        String str = f31101a;
        StringBuilder sb = new StringBuilder();
        sb.append("bkgpush: got nal type: ");
        Object obj = tXSNALPacket;
        if (tXSNALPacket != null) {
            obj = Integer.valueOf(tXSNALPacket.nalType);
        }
        sb.append(obj);
        TXCLog.w(str, sb.toString());
        com.tencent.liteav.videoencoder.b bVar = this.f31107g;
        if (bVar != null) {
            bVar.a((com.tencent.liteav.videoencoder.d) null);
            com.tencent.liteav.videoencoder.b bVar2 = this.f31107g;
            try {
                if (this.n != null) {
                    b bVar3 = (b) this.n.get();
                    if (bVar3 != null) {
                        bVar3.a(bVar2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public a(b bVar) {
        this.n = new WeakReference<>(bVar);
    }

    public void a(int i2, int i3) {
        if (this.f31106f) {
            TXCLog.w(f31101a, "bkgpush: start background publish return when started");
            return;
        }
        this.f31106f = true;
        b(i2, i3);
        c();
        C0484a aVar = this.f31104d;
        if (aVar != null) {
            aVar.sendEmptyMessageDelayed(1001, (long) this.f31102b);
        }
        String str = f31101a;
        TXCLog.w(str, "bkgpush: start background publish with time:" + ((this.f31103c - System.currentTimeMillis()) / 1000) + ", interval:" + this.f31102b);
    }

    public void a(int i2, int i3, Bitmap bitmap, int i4, int i5) {
        if (this.f31106f) {
            TXCLog.w(f31101a, "bkgpush: start background publish return when started");
            return;
        }
        if (bitmap == null) {
            try {
                String str = f31101a;
                TXCLog.w(str, "bkgpush: background publish img is empty, add default img " + i4 + "*" + i5);
                ColorDrawable colorDrawable = new ColorDrawable(-16777216);
                Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                colorDrawable.draw(new Canvas(createBitmap));
                bitmap = createBitmap;
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (Error unused) {
            }
        }
        String str2 = f31101a;
        TXCLog.w(str2, "bkgpush: generate bitmap " + i4 + "*" + i5);
        this.k = bitmap;
        this.l = i4;
        this.m = i5;
        a(i2, i3);
    }

    public void a() {
        this.f31106f = false;
        this.j = null;
        this.k = null;
        TXCLog.w(f31101a, "bkgpush: stop background publish");
        d();
    }

    private void b(int i2, int i3) {
        if (i2 > 0) {
            if (i2 >= 8) {
                i2 = 8;
            } else if (i2 <= 3) {
                i2 = 3;
            }
            this.f31102b = 1000 / i2;
        } else {
            this.f31102b = 200;
        }
        long j2 = (long) i3;
        if (i3 > 0) {
            this.f31103c = System.currentTimeMillis() + (j2 * 1000);
        } else {
            this.f31103c = System.currentTimeMillis() + 300000;
        }
    }

    private void c() {
        d();
        this.f31105e = new HandlerThread("TXImageCapturer");
        this.f31105e.start();
        this.f31104d = new C0484a(this.f31105e.getLooper(), this.f31102b, this.f31103c);
    }

    private void d() {
        C0484a aVar = this.f31104d;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages((Object) null);
            this.f31104d = null;
        }
        HandlerThread handlerThread = this.f31105e;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f31105e = null;
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        int i2;
        int i3 = 0;
        try {
            if (this.n != null && this.f31106f) {
                b bVar = (b) this.n.get();
                if (bVar != null) {
                    Bitmap bitmap = this.k;
                    ByteBuffer byteBuffer = this.j;
                    if (byteBuffer != null || bitmap == null) {
                        i2 = 0;
                    } else {
                        int width = bitmap.getWidth();
                        try {
                            int height = bitmap.getHeight();
                            try {
                                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * height * 4);
                                bitmap.copyPixelsToBuffer(allocateDirect);
                                allocateDirect.rewind();
                                this.j = allocateDirect;
                                ByteBuffer byteBuffer2 = allocateDirect;
                                i2 = height;
                                i3 = width;
                                byteBuffer = byteBuffer2;
                            } catch (Exception unused) {
                                i2 = height;
                                i3 = width;
                                String str = f31101a;
                                TXCLog.w(str, "bkgpush: generate bitmap pixel exception " + i3 + "*" + i2);
                            } catch (Error unused2) {
                                i2 = height;
                                i3 = width;
                                String str2 = f31101a;
                                TXCLog.w(str2, "bkgpush: generate bitmap pixel error " + i3 + "*" + i2);
                            }
                        } catch (Exception unused3) {
                            i3 = width;
                            i2 = 0;
                            String str3 = f31101a;
                            TXCLog.w(str3, "bkgpush: generate bitmap pixel exception " + i3 + "*" + i2);
                        } catch (Error unused4) {
                            i3 = width;
                            i2 = 0;
                            String str22 = f31101a;
                            TXCLog.w(str22, "bkgpush: generate bitmap pixel error " + i3 + "*" + i2);
                        }
                    }
                    if (bitmap != null && byteBuffer != null) {
                        try {
                            bVar.a(bitmap, byteBuffer, this.l, this.m);
                        } catch (Exception unused5) {
                        } catch (Error unused6) {
                            String str222 = f31101a;
                            TXCLog.w(str222, "bkgpush: generate bitmap pixel error " + i3 + "*" + i2);
                        }
                    }
                }
            }
        } catch (Exception unused7) {
            i2 = 0;
            String str32 = f31101a;
            TXCLog.w(str32, "bkgpush: generate bitmap pixel exception " + i3 + "*" + i2);
        } catch (Error unused8) {
            i2 = 0;
            String str2222 = f31101a;
            TXCLog.w(str2222, "bkgpush: generate bitmap pixel error " + i3 + "*" + i2);
        }
    }

    /* renamed from: com.tencent.liteav.a$a  reason: collision with other inner class name */
    private class C0484a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private int f31109b = 300;

        /* renamed from: c  reason: collision with root package name */
        private long f31110c = 0;

        public C0484a(Looper looper, int i, long j) {
            super(looper);
            this.f31109b = i;
            this.f31110c = j;
        }

        public void handleMessage(Message message) {
            if (message.what == 1001) {
                try {
                    a.this.e();
                    if (System.currentTimeMillis() < this.f31110c) {
                        sendEmptyMessageDelayed(1001, (long) this.f31109b);
                        return;
                    }
                    TXCLog.w(a.f31101a, "bkgpush:stop background publish when timeout");
                    if (a.this.n != null && a.this.f31106f) {
                        b bVar = (b) a.this.n.get();
                        if (bVar != null) {
                            bVar.a();
                        }
                        boolean unused = a.this.f31106f = false;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
