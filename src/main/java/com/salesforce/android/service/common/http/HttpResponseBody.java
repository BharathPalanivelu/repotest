package com.salesforce.android.service.common.http;

import e.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import okhttp3.MediaType;

public interface HttpResponseBody extends Closeable {
    InputStream byteStream();

    byte[] bytes() throws IOException;

    Reader charStream();

    long contentLength();

    MediaType contentType();

    e source();

    String string() throws IOException;
}
