package com.c.a.c.d.e;

import android.util.Log;
import com.c.a.c.b.a.b;
import com.c.a.c.b.s;
import com.c.a.c.f;
import com.c.a.c.g;
import com.c.a.c.k;
import com.tencent.imsdk.TIMGroupManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class j implements k<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    private final List<f> f6095a;

    /* renamed from: b  reason: collision with root package name */
    private final k<ByteBuffer, c> f6096b;

    /* renamed from: c  reason: collision with root package name */
    private final b f6097c;

    public j(List<f> list, k<ByteBuffer, c> kVar, b bVar) {
        this.f6095a = list;
        this.f6096b = kVar;
        this.f6097c = bVar;
    }

    public boolean a(InputStream inputStream, com.c.a.c.j jVar) throws IOException {
        return !((Boolean) jVar.a(i.f6094b)).booleanValue() && g.a(this.f6095a, inputStream, this.f6097c) == f.a.GIF;
    }

    public s<c> a(InputStream inputStream, int i, int i2, com.c.a.c.j jVar) throws IOException {
        byte[] a2 = a(inputStream);
        if (a2 == null) {
            return null;
        }
        return this.f6096b.a(ByteBuffer.wrap(a2), i, i2, jVar);
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
        try {
            byte[] bArr = new byte[TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            return null;
        }
    }
}
