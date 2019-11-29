package com.salesforce.android.service.common.http;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import okhttp3.CacheControl;
import okhttp3.Challenge;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;

public interface HttpResponse extends Closeable {
    HttpResponseBody body();

    CacheControl cacheControl();

    HttpResponse cacheResponse();

    List<Challenge> challenges();

    int code();

    Handshake handshake();

    String header(String str);

    String header(String str, String str2);

    List<String> headers(String str);

    Headers headers();

    boolean isRedirect();

    boolean isSuccessful();

    String message();

    HttpResponse networkResponse();

    HttpResponseBody peekBody(long j) throws IOException;

    HttpResponse priorResponse();

    Protocol protocol();

    long receivedResponseAtMillis();

    HttpRequest request();

    long sentRequestAtMillis();
}
