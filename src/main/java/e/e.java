package e;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public interface e extends v, ReadableByteChannel {
    long a(byte b2) throws IOException;

    long a(u uVar) throws IOException;

    String a(long j, Charset charset) throws IOException;

    String a(Charset charset) throws IOException;

    void a(long j) throws IOException;

    void a(c cVar, long j) throws IOException;

    void a(byte[] bArr) throws IOException;

    boolean a(long j, f fVar) throws IOException;

    c b();

    boolean b(long j) throws IOException;

    f d(long j) throws IOException;

    String e(long j) throws IOException;

    String f(long j) throws IOException;

    boolean f() throws IOException;

    InputStream g();

    byte[] h(long j) throws IOException;

    byte i() throws IOException;

    void i(long j) throws IOException;

    short j() throws IOException;

    int k() throws IOException;

    long l() throws IOException;

    short m() throws IOException;

    int n() throws IOException;

    long o() throws IOException;

    long p() throws IOException;

    long q() throws IOException;

    String s() throws IOException;

    String t() throws IOException;

    byte[] v() throws IOException;
}
