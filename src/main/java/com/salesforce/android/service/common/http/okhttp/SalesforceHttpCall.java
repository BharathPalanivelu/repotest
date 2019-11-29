package com.salesforce.android.service.common.http.okhttp;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.salesforce.android.service.common.http.HttpCall;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.HttpResponse;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

public class SalesforceHttpCall implements HttpCall {
    private final Call mCall;

    public static HttpCall wrap(Call call) {
        return new SalesforceHttpCall(call);
    }

    SalesforceHttpCall(Call call) {
        this.mCall = call;
    }

    public void cancel() {
        this.mCall.cancel();
    }

    public HttpRequest request() {
        return SalesforceOkHttpRequest.wrap(this.mCall.request());
    }

    public HttpResponse execute() throws IOException {
        return SalesforceOkHttpResponse.wrap(FirebasePerfOkHttpClient.execute(this.mCall));
    }

    public void enqueue(Callback callback) {
        FirebasePerfOkHttpClient.enqueue(this.mCall, callback);
    }

    public boolean isExecuted() {
        return this.mCall.isExecuted();
    }

    public boolean isCanceled() {
        return this.mCall.isCanceled();
    }

    public Call unwrap() {
        return this.mCall;
    }
}
