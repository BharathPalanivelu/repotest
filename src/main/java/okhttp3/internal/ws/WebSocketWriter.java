package okhttp3.internal.ws;

import com.tencent.ijk.media.player.IjkMediaMeta;
import e.c;
import e.d;
import e.f;
import e.u;
import e.w;
import java.io.IOException;
import java.util.Random;

final class WebSocketWriter {
    boolean activeWriter;
    final c buffer = new c();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    private final c.a maskCursor;
    private final byte[] maskKey;
    final Random random;
    final d sink;
    final c sinkBuffer;
    boolean writerClosed;

    WebSocketWriter(boolean z, d dVar, Random random2) {
        if (dVar == null) {
            throw new NullPointerException("sink == null");
        } else if (random2 != null) {
            this.isClient = z;
            this.sink = dVar;
            this.sinkBuffer = dVar.b();
            this.random = random2;
            c.a aVar = null;
            this.maskKey = z ? new byte[4] : null;
            this.maskCursor = z ? new c.a() : aVar;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    /* access modifiers changed from: package-private */
    public void writePing(f fVar) throws IOException {
        writeControlFrame(9, fVar);
    }

    /* access modifiers changed from: package-private */
    public void writePong(f fVar) throws IOException {
        writeControlFrame(10, fVar);
    }

    /* access modifiers changed from: package-private */
    public void writeClose(int i, f fVar) throws IOException {
        f fVar2 = f.f32736b;
        if (!(i == 0 && fVar == null)) {
            if (i != 0) {
                WebSocketProtocol.validateCloseCode(i);
            }
            c cVar = new c();
            cVar.j(i);
            if (fVar != null) {
                cVar.d(fVar);
            }
            fVar2 = cVar.r();
        }
        try {
            writeControlFrame(8, fVar2);
        } finally {
            this.writerClosed = true;
        }
    }

    private void writeControlFrame(int i, f fVar) throws IOException {
        if (!this.writerClosed) {
            int h = fVar.h();
            if (((long) h) <= 125) {
                this.sinkBuffer.k(i | 128);
                if (this.isClient) {
                    this.sinkBuffer.k(h | 128);
                    this.random.nextBytes(this.maskKey);
                    this.sinkBuffer.c(this.maskKey);
                    if (h > 0) {
                        long a2 = this.sinkBuffer.a();
                        this.sinkBuffer.d(fVar);
                        this.sinkBuffer.a(this.maskCursor);
                        this.maskCursor.a(a2);
                        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.k(h);
                    this.sinkBuffer.d(fVar);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public u newMessageSink(int i, long j) {
        if (!this.activeWriter) {
            this.activeWriter = true;
            FrameSink frameSink2 = this.frameSink;
            frameSink2.formatOpcode = i;
            frameSink2.contentLength = j;
            frameSink2.isFirstFrame = true;
            frameSink2.closed = false;
            return frameSink2;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    public void writeMessageFrame(int i, long j, boolean z, boolean z2) throws IOException {
        if (!this.writerClosed) {
            int i2 = 0;
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= 128;
            }
            this.sinkBuffer.k(i);
            if (this.isClient) {
                i2 = 128;
            }
            if (j <= 125) {
                this.sinkBuffer.k(((int) j) | i2);
            } else if (j <= 65535) {
                this.sinkBuffer.k(i2 | 126);
                this.sinkBuffer.j((int) j);
            } else {
                this.sinkBuffer.k(i2 | 127);
                this.sinkBuffer.j(j);
            }
            if (this.isClient) {
                this.random.nextBytes(this.maskKey);
                this.sinkBuffer.c(this.maskKey);
                if (j > 0) {
                    long a2 = this.sinkBuffer.a();
                    this.sinkBuffer.write(this.buffer, j);
                    this.sinkBuffer.a(this.maskCursor);
                    this.maskCursor.a(a2);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            } else {
                this.sinkBuffer.write(this.buffer, j);
            }
            this.sink.e();
            return;
        }
        throw new IOException("closed");
    }

    final class FrameSink implements u {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public void write(c cVar, long j) throws IOException {
            if (!this.closed) {
                WebSocketWriter.this.buffer.write(cVar, j);
                boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.buffer.a() > this.contentLength - IjkMediaMeta.AV_CH_TOP_FRONT_CENTER;
                long h = WebSocketWriter.this.buffer.h();
                if (h > 0 && !z) {
                    WebSocketWriter.this.writeMessageFrame(this.formatOpcode, h, this.isFirstFrame, false);
                    this.isFirstFrame = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        public void flush() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.a(), this.isFirstFrame, false);
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }

        public w timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        public void close() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.a(), this.isFirstFrame, true);
                this.closed = true;
                WebSocketWriter.this.activeWriter = false;
                return;
            }
            throw new IOException("closed");
        }
    }
}
