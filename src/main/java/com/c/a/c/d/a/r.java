package com.c.a.c.d.a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.c.a.c.b.a.e;
import com.c.a.c.b.s;
import com.c.a.c.i;
import com.c.a.c.j;
import com.c.a.c.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class r implements k<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final i<Long> f6047a = i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new i.a<Long>() {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f6052a = ByteBuffer.allocate(8);

        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f6052a) {
                this.f6052a.position(0);
                messageDigest.update(this.f6052a.putLong(l.longValue()).array());
            }
        }
    });

    /* renamed from: b  reason: collision with root package name */
    public static final i<Integer> f6048b = i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", null, new i.a<Integer>() {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f6053a = ByteBuffer.allocate(4);

        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f6053a) {
                    this.f6053a.position(0);
                    messageDigest.update(this.f6053a.putInt(num.intValue()).array());
                }
            }
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private static final a f6049c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final e f6050d;

    /* renamed from: e  reason: collision with root package name */
    private final a f6051e;

    public boolean a(ParcelFileDescriptor parcelFileDescriptor, j jVar) {
        return true;
    }

    public r(e eVar) {
        this(eVar, f6049c);
    }

    r(e eVar, a aVar) {
        this.f6050d = eVar;
        this.f6051e = aVar;
    }

    public s<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, j jVar) throws IOException {
        Bitmap bitmap;
        long longValue = ((Long) jVar.a(f6047a)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) jVar.a(f6048b);
            MediaMetadataRetriever a2 = this.f6051e.a();
            try {
                a2.setDataSource(parcelFileDescriptor.getFileDescriptor());
                if (longValue == -1) {
                    bitmap = a2.getFrameAtTime();
                } else if (num == null) {
                    bitmap = a2.getFrameAtTime(longValue);
                } else {
                    bitmap = a2.getFrameAtTime(longValue, num.intValue());
                }
                a2.release();
                parcelFileDescriptor.close();
                return d.a(bitmap, this.f6050d);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            } catch (Throwable th) {
                a2.release();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    static class a {
        a() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }
}
