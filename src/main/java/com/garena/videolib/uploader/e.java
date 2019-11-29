package com.garena.videolib.uploader;

import com.tencent.ijk.media.player.IjkMediaMeta;
import e.d;
import e.n;
import e.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;

public class e extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    private final File f8725a;

    /* renamed from: b  reason: collision with root package name */
    private final a f8726b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8727c;

    /* renamed from: d  reason: collision with root package name */
    private int f8728d;

    /* renamed from: e  reason: collision with root package name */
    private int f8729e = 5;

    public interface a {
        void a(int i);
    }

    public e(File file, String str, a aVar) {
        this.f8725a = file;
        this.f8727c = str;
        this.f8726b = aVar;
    }

    public e(File file, String str, a aVar, int i) {
        this.f8725a = file;
        this.f8727c = str;
        this.f8726b = aVar;
        this.f8728d = i;
    }

    public long contentLength() {
        return this.f8725a.length() - ((long) this.f8728d);
    }

    public MediaType contentType() {
        return MediaType.parse(this.f8727c);
    }

    public void writeTo(d dVar) throws IOException {
        v vVar = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f8725a);
            fileInputStream.skip((long) this.f8728d);
            vVar = n.a((InputStream) fileInputStream);
            long j = (long) this.f8728d;
            long contentLength = contentLength() + ((long) this.f8728d);
            int i = 0;
            while (true) {
                long read = vVar.read(dVar.b(), IjkMediaMeta.AV_CH_TOP_FRONT_LEFT);
                if (read != -1) {
                    j += read;
                    int i2 = (int) ((((float) j) / ((float) contentLength)) * 100.0f);
                    if (i2 == 100 || i2 - i > this.f8729e) {
                        dVar.flush();
                        this.f8726b.a(i2);
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        } finally {
            Util.closeQuietly(vVar);
        }
    }
}
