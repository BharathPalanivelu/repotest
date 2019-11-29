package com.salesforce.android.service.common.http;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

public interface HttpCall {
    void cancel();

    void enqueue(Callback callback);

    HttpResponse execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    HttpRequest request();

    Call unwrap();
}
