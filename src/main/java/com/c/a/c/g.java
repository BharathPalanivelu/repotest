package com.c.a.c;

import com.c.a.c.b.a.b;
import com.c.a.c.d.a.m;
import com.c.a.c.f;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class g {
    public static f.a a(List<f> list, InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return f.a.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new m(inputStream, bVar);
        }
        inputStream.mark(5242880);
        for (f a2 : list) {
            try {
                f.a a3 = a2.a(inputStream);
                if (a3 != f.a.UNKNOWN) {
                    inputStream.reset();
                    return a3;
                }
            } finally {
                inputStream.reset();
            }
        }
        return f.a.UNKNOWN;
    }

    public static f.a a(List<f> list, ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return f.a.UNKNOWN;
        }
        for (f a2 : list) {
            f.a a3 = a2.a(byteBuffer);
            if (a3 != f.a.UNKNOWN) {
                return a3;
            }
        }
        return f.a.UNKNOWN;
    }

    public static int b(List<f> list, InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new m(inputStream, bVar);
        }
        inputStream.mark(5242880);
        for (f a2 : list) {
            try {
                int a3 = a2.a(inputStream, bVar);
                if (a3 != -1) {
                    inputStream.reset();
                    return a3;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }
}
