package com.tencent.liteav.b;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.Record.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.muxer.c;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.microedition.khronos.egl.EGLContext;

public class a implements d, com.tencent.liteav.videoencoder.d {

    /* renamed from: a  reason: collision with root package name */
    private e f31212a = new e();

    /* renamed from: b  reason: collision with root package name */
    private com.tencent.liteav.videoencoder.a f31213b = new com.tencent.liteav.videoencoder.a();

    /* renamed from: c  reason: collision with root package name */
    private c f31214c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public C0486a f31215d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f31216e;

    /* renamed from: f  reason: collision with root package name */
    private long f31217f = 0;

    /* renamed from: g  reason: collision with root package name */
    private long f31218g = -1;
    private boolean h = false;
    private Handler i = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (a.this.f31216e != null) {
                int i = message.what;
                if (i == 1) {
                    a.this.f31216e.a(((Long) message.obj).longValue());
                } else if (i == 2) {
                    TXCLog.d("TXCStreamRecord", "record complete. errcode = " + message.arg1 + ", errmsg = " + ((String) message.obj) + ", outputPath = " + a.this.f31215d.f31225f + ", coverImage = " + a.this.f31215d.f31226g);
                    if (message.arg1 == 0 && a.this.f31215d.f31226g != null && !a.this.f31215d.f31226g.isEmpty() && !com.tencent.liteav.basic.util.b.a(a.this.f31215d.f31225f, a.this.f31215d.f31226g)) {
                        TXCLog.e("TXCStreamRecord", "saveVideoThumb error. sourcePath = " + a.this.f31215d.f31225f + ", coverImagePath = " + a.this.f31215d.f31226g);
                    }
                    if (message.arg1 != 0) {
                        try {
                            File file = new File(a.this.f31215d.f31225f);
                            if (file.exists()) {
                                file.delete();
                            }
                        } catch (Exception unused) {
                        }
                    }
                    a.this.f31216e.a(message.arg1, (String) message.obj, a.this.f31215d.f31225f, a.this.f31215d.f31226g);
                }
            }
        }
    };

    public interface b {
        void a(int i, String str, String str2, String str3);

        void a(long j);
    }

    public void a(int i2, String str) {
    }

    public void a(long j, long j2, long j3) {
    }

    public void a(byte[] bArr, long j, int i2, int i3, int i4) {
    }

    public void a(byte[] bArr, long j, int i2, int i3, int i4, boolean z) {
    }

    /* renamed from: com.tencent.liteav.b.a$a  reason: collision with other inner class name */
    public static class C0486a {

        /* renamed from: a  reason: collision with root package name */
        public int f31220a = 544;

        /* renamed from: b  reason: collision with root package name */
        public int f31221b = TXEAudioDef.TXE_OPUS_SAMPLE_NUM;

        /* renamed from: c  reason: collision with root package name */
        public int f31222c = 20;

        /* renamed from: d  reason: collision with root package name */
        public int f31223d = 1000;

        /* renamed from: e  reason: collision with root package name */
        public EGLContext f31224e;

        /* renamed from: f  reason: collision with root package name */
        public String f31225f;

        /* renamed from: g  reason: collision with root package name */
        public String f31226g;
        public int h = 0;
        public int i = 0;
        public int j = 16;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TXCStreamRecordParams: [width=" + this.f31220a);
            sb.append("; height=" + this.f31221b);
            sb.append("; fps=" + this.f31222c);
            sb.append("; bitrate=" + this.f31223d);
            sb.append("; channels=" + this.h);
            sb.append("; samplerate=" + this.i);
            sb.append("; bits=" + this.j);
            sb.append("; EGLContext=" + this.f31224e);
            sb.append("; coveriamge=" + this.f31226g);
            sb.append("; outputpath=" + this.f31225f + "]");
            return sb.toString();
        }
    }

    public a(Context context) {
        this.f31214c = new c(context, 1);
    }

    public void a(b bVar) {
        this.f31216e = bVar;
    }

    public void a(C0486a aVar) {
        this.f31215d = aVar;
        this.f31217f = 0;
        this.f31218g = -1;
        this.f31214c.a(this.f31215d.f31225f);
        if (aVar.h > 0 && aVar.i > 0 && aVar.j > 0) {
            this.f31212a.a(10, aVar.i, aVar.h, aVar.j, new WeakReference(this));
            this.f31214c.b(com.tencent.liteav.basic.util.b.a(this.f31215d.i, this.f31215d.h, 2));
            this.h = true;
        }
        this.f31213b.setListener(this);
        TXSVideoEncoderParam tXSVideoEncoderParam = new TXSVideoEncoderParam();
        tXSVideoEncoderParam.width = this.f31215d.f31220a;
        tXSVideoEncoderParam.height = this.f31215d.f31221b;
        tXSVideoEncoderParam.fps = this.f31215d.f31222c;
        tXSVideoEncoderParam.glContext = this.f31215d.f31224e;
        tXSVideoEncoderParam.annexb = true;
        tXSVideoEncoderParam.appendSpsPps = false;
        this.f31213b.setBitrate(this.f31215d.f31223d);
        this.f31213b.start(tXSVideoEncoderParam);
    }

    public void a() {
        this.h = false;
        this.f31212a.a();
        this.f31213b.stop();
        if (this.f31214c.b() < 0) {
            Handler handler = this.i;
            handler.sendMessage(Message.obtain(handler, 2, 1, 0, "mp4合成失败"));
            return;
        }
        Handler handler2 = this.i;
        handler2.sendMessage(Message.obtain(handler2, 2, 0, 0, ""));
    }

    public void a(int i2, long j) {
        this.f31213b.pushVideoFrame(i2, this.f31215d.f31220a, this.f31215d.f31221b, j);
    }

    public void a(byte[] bArr, long j) {
        if (this.h) {
            this.f31212a.a(bArr, j);
        } else {
            TXCLog.e("TXCStreamRecord", "drainAudio fail because of not init yet!");
        }
    }

    public static String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String format = simpleDateFormat.format(new Date(Long.valueOf(valueOf + "000").longValue()));
            String a2 = a(context);
            return new File(a2, String.format("TXUGC_%s" + str, new Object[]{format})).getAbsolutePath();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(Context context) {
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return context.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getPath();
        }
        return context.getFilesDir().getPath();
    }

    private String a(int i2) {
        String str;
        switch (i2) {
            case 10000002:
                str = "未启动视频编码器";
                break;
            case 10000003:
                str = "非法视频输入参数";
                break;
            case 10000004:
                str = "视频编码初始化失败";
                break;
            case 10000005:
                str = "视频编码失败";
                break;
            default:
                str = "";
                break;
        }
        Handler handler = this.i;
        handler.sendMessage(Message.obtain(handler, 2, 1, 0, str));
        return str;
    }

    public void b(byte[] bArr, long j, int i2, int i3, int i4) {
        this.f31214c.a(bArr, 0, bArr.length, j * 1000, 1);
    }

    public void a(TXSNALPacket tXSNALPacket, int i2) {
        if (i2 == 0) {
            this.f31214c.b(tXSNALPacket.nalData, 0, tXSNALPacket.nalData.length, tXSNALPacket.pts * 1000, tXSNALPacket.info.flags);
            if (this.f31218g < 0) {
                this.f31218g = tXSNALPacket.pts;
            }
            if (tXSNALPacket.pts > this.f31217f + 500) {
                Handler handler = this.i;
                handler.sendMessage(Message.obtain(handler, 1, new Long(tXSNALPacket.pts - this.f31218g)));
                this.f31217f = tXSNALPacket.pts;
                return;
            }
            return;
        }
        String a2 = a(i2);
        TXCLog.e("TXCStreamRecord", "video encode error! errmsg: " + a2);
    }

    public void a(MediaFormat mediaFormat) {
        this.f31214c.a(mediaFormat);
        if (this.f31214c.c() && this.f31214c.a() < 0) {
            Handler handler = this.i;
            handler.sendMessage(Message.obtain(handler, 2, 1, 0, "mp4封装器启动失败"));
        }
    }
}
