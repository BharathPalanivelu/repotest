package com.facebook.common.memory;

import java.io.Closeable;
import java.nio.ByteBuffer;

public interface PooledByteBuffer extends Closeable {
    void close();

    ByteBuffer getByteBuffer();

    long getNativePtr();

    boolean isClosed();

    byte read(int i);

    int read(int i, byte[] bArr, int i2, int i3);

    int size();

    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }
}
