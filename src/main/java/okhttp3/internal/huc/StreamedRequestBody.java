package okhttp3.internal.huc;

import com.tencent.ijk.media.player.IjkMediaMeta;
import e.c;
import e.d;
import e.n;
import e.o;
import java.io.IOException;
import okhttp3.internal.http.UnrepeatableRequestBody;

final class StreamedRequestBody extends OutputStreamRequestBody implements UnrepeatableRequestBody {
    private final o pipe = new o(IjkMediaMeta.AV_CH_TOP_FRONT_CENTER);

    StreamedRequestBody(long j) {
        initOutputStream(n.a(this.pipe.b()), j);
    }

    public void writeTo(d dVar) throws IOException {
        c cVar = new c();
        while (this.pipe.a().read(cVar, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) != -1) {
            dVar.write(cVar, cVar.a());
        }
    }
}
