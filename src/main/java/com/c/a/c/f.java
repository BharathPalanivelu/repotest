package com.c.a.c;

import com.c.a.c.b.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface f {
    int a(InputStream inputStream, b bVar) throws IOException;

    a a(InputStream inputStream) throws IOException;

    a a(ByteBuffer byteBuffer) throws IOException;

    public enum a {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean hasAlpha;

        private a(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }
}
