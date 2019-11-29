package okhttp3.internal.huc;

import com.tencent.qcloud.core.http.HttpConstants;
import e.c;
import e.d;
import java.io.IOException;
import okhttp3.Request;

final class BufferedRequestBody extends OutputStreamRequestBody {
    final c buffer = new c();
    long contentLength = -1;

    BufferedRequestBody(long j) {
        initOutputStream(this.buffer, j);
    }

    public long contentLength() throws IOException {
        return this.contentLength;
    }

    public Request prepareToSendRequest(Request request) throws IOException {
        if (request.header(HttpConstants.Header.CONTENT_LENGTH) != null) {
            return request;
        }
        outputStream().close();
        this.contentLength = this.buffer.a();
        return request.newBuilder().removeHeader(HttpConstants.Header.TRANSFER_ENCODING).header(HttpConstants.Header.CONTENT_LENGTH, Long.toString(this.buffer.a())).build();
    }

    public void writeTo(d dVar) throws IOException {
        this.buffer.a(dVar.b(), 0, this.buffer.a());
    }
}
