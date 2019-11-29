package e;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

public interface d extends u, WritableByteChannel {
    d A() throws IOException;

    long a(v vVar) throws IOException;

    d a(v vVar, long j) throws IOException;

    c b();

    d b(String str) throws IOException;

    d c(byte[] bArr) throws IOException;

    d c(byte[] bArr, int i, int i2) throws IOException;

    OutputStream c();

    d d(f fVar) throws IOException;

    d e() throws IOException;

    void flush() throws IOException;

    d h(int i) throws IOException;

    d i(int i) throws IOException;

    d j(int i) throws IOException;

    d k(int i) throws IOException;

    d n(long j) throws IOException;

    d o(long j) throws IOException;

    d p(long j) throws IOException;
}
