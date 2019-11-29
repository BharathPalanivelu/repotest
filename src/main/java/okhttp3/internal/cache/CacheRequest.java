package okhttp3.internal.cache;

import e.u;
import java.io.IOException;

public interface CacheRequest {
    void abort();

    u body() throws IOException;
}
