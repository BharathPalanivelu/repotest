package com.tencent.qcloud.core.http;

import a.g;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.auth.QCloudCredentials;
import com.tencent.qcloud.core.auth.QCloudSigner;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.task.QCloudTask;
import com.tencent.qcloud.core.task.TaskExecutors;
import e.c;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class HttpTask<T> extends QCloudTask<HttpResult<T>> {
    private static AtomicInteger increments = new AtomicInteger(1);
    private final QCloudCredentialProvider credentialProvider;
    private Call httpCall;
    private final QCloudHttpClient httpClient;
    private HttpMetric httpMetric;
    private final HttpRequest<T> httpRequest;
    private HttpResponse<T> httpResponse;
    private HttpResult<T> httpResult;
    private QCloudProgressListener mProgressListener = new QCloudProgressListener() {
        public void onProgress(long j, long j2) {
            HttpTask.this.onProgress(j, j2);
        }
    };

    HttpTask(HttpRequest<T> httpRequest2, QCloudCredentialProvider qCloudCredentialProvider, QCloudHttpClient qCloudHttpClient) {
        super("HttpTask-" + httpRequest2.tag() + "-" + increments.getAndIncrement(), httpRequest2.tag());
        this.httpRequest = httpRequest2;
        this.httpClient = qCloudHttpClient;
        this.credentialProvider = qCloudCredentialProvider;
    }

    public HttpTask<T> schedule() {
        if (this.httpRequest.getRequestBody() instanceof ProgressBody) {
            scheduleOn(TaskExecutors.UPLOAD_EXECUTOR, new g());
        } else if (this.httpRequest.getResponseBodyConverter() instanceof ProgressBody) {
            scheduleOn(TaskExecutors.DOWNLOAD_EXECUTOR, new g());
        } else {
            scheduleOn(TaskExecutors.COMMAND_EXECUTOR, new g());
        }
        return this;
    }

    public boolean isSuccessful() {
        HttpResult<T> httpResult2 = this.httpResult;
        return httpResult2 != null && httpResult2.isSuccessful();
    }

    public HttpResult<T> getResult() {
        return this.httpResult;
    }

    public HttpTask<T> attachMetric(HttpMetric httpMetric2) {
        this.httpMetric = httpMetric2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean isUploadTask() {
        if (this.httpRequest.getRequestBody() instanceof StreamingRequestBody) {
            return ((StreamingRequestBody) this.httpRequest.getRequestBody()).isLargeData();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isDownloadTask() {
        return this.httpRequest.getResponseBodyConverter() instanceof ProgressBody;
    }

    /* access modifiers changed from: package-private */
    public double getAverageStreamingSpeed(long j) {
        ProgressBody progressBody;
        if (this.httpRequest.getRequestBody() instanceof ProgressBody) {
            progressBody = (ProgressBody) this.httpRequest.getRequestBody();
        } else {
            progressBody = this.httpRequest.getResponseBodyConverter() instanceof ProgressBody ? (ProgressBody) this.httpRequest.getResponseBodyConverter() : null;
        }
        if (progressBody == null) {
            return 0.0d;
        }
        double bytesTransferred = (double) progressBody.getBytesTransferred();
        Double.isNaN(bytesTransferred);
        double d2 = (double) j;
        Double.isNaN(d2);
        return (bytesTransferred / 1024.0d) / (d2 / 1000.0d);
    }

    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b9 A[Catch:{ all -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c3 A[Catch:{ all -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.qcloud.core.http.HttpResult<T> execute() throws com.tencent.qcloud.core.common.QCloudClientException, com.tencent.qcloud.core.common.QCloudServiceException {
        /*
            r6 = this;
            com.tencent.qcloud.core.http.HttpMetric r0 = r6.httpMetric
            if (r0 == 0) goto L_0x0007
            r0.start()
        L_0x0007:
            com.tencent.qcloud.core.http.HttpRequest<T> r0 = r6.httpRequest
            boolean r0 = r0.shouldCalculateContentMD5()
            if (r0 == 0) goto L_0x0012
            r6.calculateContentMD5()
        L_0x0012:
            com.tencent.qcloud.core.http.HttpRequest<T> r0 = r6.httpRequest
            com.tencent.qcloud.core.auth.QCloudSigner r0 = r0.getQCloudSigner()
            if (r0 == 0) goto L_0x001f
            com.tencent.qcloud.core.http.HttpRequest<T> r1 = r6.httpRequest
            r6.signRequest(r0, r1)
        L_0x001f:
            com.tencent.qcloud.core.http.HttpRequest<T> r0 = r6.httpRequest
            okhttp3.RequestBody r0 = r0.getRequestBody()
            boolean r0 = r0 instanceof com.tencent.qcloud.core.http.ProgressBody
            if (r0 == 0) goto L_0x0036
            com.tencent.qcloud.core.http.HttpRequest<T> r0 = r6.httpRequest
            okhttp3.RequestBody r0 = r0.getRequestBody()
            com.tencent.qcloud.core.http.ProgressBody r0 = (com.tencent.qcloud.core.http.ProgressBody) r0
            com.tencent.qcloud.core.common.QCloudProgressListener r1 = r6.mProgressListener
            r0.setProgressListener(r1)
        L_0x0036:
            r0 = 0
            com.tencent.qcloud.core.http.HttpRequest<T> r1 = r6.httpRequest     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            java.lang.String r2 = r6.getIdentifier()     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            r1.setOkHttpRequestTag(r2)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            com.tencent.qcloud.core.http.HttpRequest<T> r1 = r6.httpRequest     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            okhttp3.Request r1 = r1.buildRealRequest()     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            com.tencent.qcloud.core.http.QCloudHttpClient r2 = r6.httpClient     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            okhttp3.Call r2 = r2.getOkHttpCall(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            r6.httpCall = r2     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            com.tencent.qcloud.core.http.HttpMetric r2 = r6.httpMetric     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            if (r2 == 0) goto L_0x0086
            com.tencent.qcloud.core.http.HttpMetric r2 = r6.httpMetric     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            okhttp3.HttpUrl r3 = r1.url()     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            r2.setRequestUrl(r3)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            com.tencent.qcloud.core.http.HttpMetric r2 = r6.httpMetric     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            java.lang.String r3 = r1.method()     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            r2.setRequestMethod(r3)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            okhttp3.RequestBody r1 = r1.body()     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            if (r1 == 0) goto L_0x0086
            com.tencent.qcloud.core.http.HttpMetric r2 = r6.httpMetric     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            long r3 = r1.contentLength()     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            r2.setRequestPayloadSize(r3)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            okhttp3.MediaType r1 = r1.contentType()     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            if (r1 == 0) goto L_0x0086
            com.tencent.qcloud.core.http.HttpMetric r2 = r6.httpMetric     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            java.lang.String r1 = r1.type()     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            r2.setRequestContentType(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
        L_0x0086:
            okhttp3.Call r1 = r6.httpCall     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            okhttp3.Response r1 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            if (r1 == 0) goto L_0x0097
            com.tencent.qcloud.core.http.HttpResult<T> r2 = r6.httpResult     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
            if (r2 != 0) goto L_0x0095
            r6.convertResponse(r1)     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
        L_0x0095:
            r2 = r0
            goto L_0x009e
        L_0x0097:
            com.tencent.qcloud.core.common.QCloudServiceException r2 = new com.tencent.qcloud.core.common.QCloudServiceException     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
            java.lang.String r3 = "http response is null"
            r2.<init>(r3)     // Catch:{ IOException -> 0x00a8, all -> 0x00a3 }
        L_0x009e:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
            r1 = r2
            goto L_0x00dc
        L_0x00a3:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x00fc
        L_0x00a8:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x00b1
        L_0x00ad:
            r1 = move-exception
            goto L_0x00fc
        L_0x00af:
            r1 = move-exception
            r2 = r0
        L_0x00b1:
            java.lang.Throwable r3 = r1.getCause()     // Catch:{ all -> 0x00fa }
            boolean r3 = r3 instanceof com.tencent.qcloud.core.common.QCloudClientException     // Catch:{ all -> 0x00fa }
            if (r3 == 0) goto L_0x00c3
            java.lang.Throwable r1 = r1.getCause()     // Catch:{ all -> 0x00fa }
            com.tencent.qcloud.core.common.QCloudClientException r1 = (com.tencent.qcloud.core.common.QCloudClientException) r1     // Catch:{ all -> 0x00fa }
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x00d9
        L_0x00c3:
            java.lang.Throwable r3 = r1.getCause()     // Catch:{ all -> 0x00fa }
            boolean r3 = r3 instanceof com.tencent.qcloud.core.common.QCloudServiceException     // Catch:{ all -> 0x00fa }
            if (r3 == 0) goto L_0x00d2
            java.lang.Throwable r1 = r1.getCause()     // Catch:{ all -> 0x00fa }
            com.tencent.qcloud.core.common.QCloudServiceException r1 = (com.tencent.qcloud.core.common.QCloudServiceException) r1     // Catch:{ all -> 0x00fa }
            goto L_0x00d9
        L_0x00d2:
            com.tencent.qcloud.core.common.QCloudClientException r3 = new com.tencent.qcloud.core.common.QCloudClientException     // Catch:{ all -> 0x00fa }
            r3.<init>((java.lang.Throwable) r1)     // Catch:{ all -> 0x00fa }
            r1 = r0
            r0 = r3
        L_0x00d9:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x00dc:
            com.tencent.qcloud.core.http.HttpMetric r2 = r6.httpMetric
            if (r2 == 0) goto L_0x00e3
            r2.stop()
        L_0x00e3:
            if (r0 == 0) goto L_0x00ed
            com.tencent.qcloud.core.http.HttpMetric r1 = r6.httpMetric
            if (r1 == 0) goto L_0x00ec
            r1.traceException(r0)
        L_0x00ec:
            throw r0
        L_0x00ed:
            if (r1 == 0) goto L_0x00f7
            com.tencent.qcloud.core.http.HttpMetric r0 = r6.httpMetric
            if (r0 == 0) goto L_0x00f6
            r0.traceException(r1)
        L_0x00f6:
            throw r1
        L_0x00f7:
            com.tencent.qcloud.core.http.HttpResult<T> r0 = r6.httpResult
            return r0
        L_0x00fa:
            r1 = move-exception
            r0 = r2
        L_0x00fc:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.core.http.HttpTask.execute():com.tencent.qcloud.core.http.HttpResult");
    }

    public void cancel() {
        Call call = this.httpCall;
        if (call != null) {
            call.cancel();
        }
        super.cancel();
    }

    private void signRequest(QCloudSigner qCloudSigner, HttpRequest httpRequest2) throws QCloudClientException {
        QCloudCredentialProvider qCloudCredentialProvider = this.credentialProvider;
        if (qCloudCredentialProvider != null) {
            QCloudCredentials credentials = qCloudCredentialProvider.getCredentials();
            if (credentials == null) {
                throw new QCloudClientException("can't get credentials for provider : " + this.credentialProvider);
            } else if (httpRequest2.getSignProvider() != null) {
                qCloudSigner.sign((QCloudHttpRequest) httpRequest2, credentials);
            } else {
                throw new QCloudClientException("no source to sign");
            }
        } else {
            throw new QCloudClientException("no credentials provider");
        }
    }

    private void calculateContentMD5() throws QCloudClientException {
        RequestBody requestBody = this.httpRequest.getRequestBody();
        if (requestBody != null) {
            c cVar = new c();
            try {
                requestBody.writeTo(cVar);
                this.httpRequest.addHeader(HttpConstants.Header.MD5, cVar.x().b());
                cVar.close();
            } catch (IOException e2) {
                throw new QCloudClientException("calculate md5 error", e2);
            }
        } else {
            throw new QCloudClientException("get md5 canceled, request body is null.");
        }
    }

    /* access modifiers changed from: package-private */
    public void convertResponse(Response response) throws QCloudClientException, QCloudServiceException {
        HttpMetric httpMetric2 = this.httpMetric;
        if (httpMetric2 != null) {
            httpMetric2.setStatusCode(response.code());
            ResponseBody body = response.body();
            if (body != null) {
                this.httpMetric.setResponsePayloadSize(body.contentLength());
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    this.httpMetric.setResponseContentType(contentType.type());
                }
            }
        }
        this.httpResponse = new HttpResponse<>(this.httpRequest, response);
        ResponseBodyConverter<T> responseBodyConverter = this.httpRequest.getResponseBodyConverter();
        if (responseBodyConverter instanceof ProgressBody) {
            ((ProgressBody) responseBodyConverter).setProgressListener(this.mProgressListener);
        }
        this.httpResult = new HttpResult<>(this.httpResponse, responseBodyConverter.convert(this.httpResponse));
    }
}
