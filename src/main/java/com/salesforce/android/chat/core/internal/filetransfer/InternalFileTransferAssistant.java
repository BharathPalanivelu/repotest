package com.salesforce.android.chat.core.internal.filetransfer;

import com.google.a.g;
import com.salesforce.android.chat.core.ChatAnalyticsEmit;
import com.salesforce.android.chat.core.FileTransferAssistant;
import com.salesforce.android.chat.core.internal.filetransfer.FileTransferProgressMonitor;
import com.salesforce.android.chat.core.internal.filetransfer.FileUploadRequestComposer;
import com.salesforce.android.chat.core.internal.liveagent.response.message.FileTransferMessage;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpJob;
import com.salesforce.android.service.common.http.HttpMediaType;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.TlsSocketFactory;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.json.LiveAgentStringResponseDeserializer;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.lang.reflect.Type;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.concurrent.Executors;

public class InternalFileTransferAssistant implements FileTransferAssistant {
    private static final int BYTES_PER_KILOBYTE = 1024;
    private static final int KILOBYTES_PER_MEGABYTE = 1024;
    static final double MAX_FILE_SIZE_IN_BYTES = 2411724.8d;
    /* access modifiers changed from: private */
    public static final ServiceLogger log = ServiceLogging.getLogger(FileTransferAssistant.class);
    private final String mFileToken;
    BasicAsync<Float> mFileTransferAsync;
    private final HttpJob.Builder<LiveAgentStringResponse> mHttpJobBuilder;
    private final JobQueue mJobQueue;
    private final String mOrganizationId;
    private final FileTransferProgressMonitor.Factory mProgressMonitorFactory;
    private final FileUploadRequestComposer.Factory mRequestComposerFactory;
    private final SessionInfo mSessionInfo;
    private final String mUploadUrl;

    private InternalFileTransferAssistant(Builder builder) {
        this.mOrganizationId = builder.mOrganizationId;
        this.mSessionInfo = builder.mSessionInfo;
        this.mUploadUrl = builder.mUploadUrl;
        this.mFileToken = builder.mFileToken;
        this.mJobQueue = builder.mJobQueue;
        this.mHttpJobBuilder = builder.mHttpJobBuilder;
        this.mRequestComposerFactory = builder.mRequestComposerFactory;
        this.mProgressMonitorFactory = builder.mProgressMonitorFactory;
        this.mFileTransferAsync = BasicAsync.create();
    }

    public void cancel() {
        this.mFileTransferAsync.cancel();
    }

    public Async<Float> uploadFile(byte[] bArr, String str) {
        try {
            ChatAnalyticsEmit.userFileTransferUploadInitiated(str, Integer.valueOf(bArr.length));
            checkValidOperation(this.mFileTransferAsync);
            checkValidParameters(bArr, str);
            log.info("Uploading a file to {}", this.mUploadUrl);
            HttpRequest buildFileUploadRequest = buildFileUploadRequest(bArr, HttpFactory.mediaType(str));
            monitorRequestProgress(buildFileUploadRequest, this.mFileTransferAsync);
            submitRequest(buildFileUploadRequest);
            return this.mFileTransferAsync;
        } catch (Exception e2) {
            log.error(e2.getMessage());
            return BasicAsync.error(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public HttpRequest buildFileUploadRequest(byte[] bArr, HttpMediaType httpMediaType) {
        return this.mRequestComposerFactory.createBuilder().organizationId(this.mOrganizationId).sessionInfo(this.mSessionInfo).fileToken(this.mFileToken).fileUploadUrl(this.mUploadUrl).imageBytes(bArr).fileMediaType(httpMediaType).build().createRequest();
    }

    /* access modifiers changed from: package-private */
    public void monitorRequestProgress(HttpRequest httpRequest, BasicAsync<Float> basicAsync) {
        this.mProgressMonitorFactory.createBuilder().fileTransferAsync(basicAsync).requestBody(httpRequest.body()).build();
    }

    /* access modifiers changed from: package-private */
    public void submitRequest(HttpRequest httpRequest) {
        this.mJobQueue.add(this.mHttpJobBuilder.httpRequest(httpRequest).build()).onResult(new Async.ResultHandler<LiveAgentStringResponse>() {
            public void handleResult(Async<?> async, LiveAgentStringResponse liveAgentStringResponse) {
                InternalFileTransferAssistant.log.info("File Transfer result: {}", liveAgentStringResponse.getValue());
                if (liveAgentStringResponse.getValue().equals(FileTransferMessage.EVENT_TYPE_FAILURE)) {
                    InternalFileTransferAssistant.this.mFileTransferAsync.setError((Throwable) new Exception("A remote upload failure has occurred."));
                }
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                InternalFileTransferAssistant.log.error("Error transferring file\n{}", th);
                InternalFileTransferAssistant.this.mFileTransferAsync.setError(th);
            }
        }).onComplete(new Async.CompletionHandler() {
            public void handleComplete(Async<?> async) {
                InternalFileTransferAssistant.this.mFileTransferAsync.complete();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void checkValidOperation(Async<Float> async) {
        if (async.isCancelled()) {
            throw new IllegalStateException("Unable to upload file. Operation has been canceled.");
        } else if (async.hasFailed()) {
            throw new IllegalStateException("Unable to upload file. Operation has failed");
        } else if (async.isComplete()) {
            throw new IllegalStateException("Operation had already completed.");
        }
    }

    /* access modifiers changed from: package-private */
    public void checkValidParameters(byte[] bArr, String str) {
        if (!isImageBytesValid(bArr)) {
            throw new IllegalArgumentException(String.format(Locale.getDefault(), "Upload file size is invalid. File size must be less than %.0f kb and non-empty.", new Object[]{Double.valueOf(2355.2d)}));
        } else if (!isContentTypeValid(str)) {
            throw new IllegalArgumentException(String.format(Locale.getDefault(), "ContentType \"%s\" is not valid. Unable to upload file.", new Object[]{str}));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isImageBytesValid(byte[] bArr) {
        return ((double) bArr.length) <= MAX_FILE_SIZE_IN_BYTES && bArr.length > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isContentTypeValid(String str) {
        return HttpFactory.mediaType(str) != null;
    }

    public static class Factory {
        public Builder createBuilder() {
            return new Builder();
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String mFileToken;
        private HttpClient mHttpClient;
        /* access modifiers changed from: private */
        public HttpJob.Builder<LiveAgentStringResponse> mHttpJobBuilder;
        /* access modifiers changed from: private */
        public JobQueue mJobQueue;
        /* access modifiers changed from: private */
        public String mOrganizationId;
        /* access modifiers changed from: private */
        public FileTransferProgressMonitor.Factory mProgressMonitorFactory;
        /* access modifiers changed from: private */
        public FileUploadRequestComposer.Factory mRequestComposerFactory;
        /* access modifiers changed from: private */
        public SessionInfo mSessionInfo;
        /* access modifiers changed from: private */
        public String mUploadUrl;

        public Builder organizationId(String str) {
            this.mOrganizationId = str;
            return this;
        }

        public Builder sessionInfo(SessionInfo sessionInfo) {
            this.mSessionInfo = sessionInfo;
            return this;
        }

        public Builder uploadUrl(String str) {
            this.mUploadUrl = str;
            return this;
        }

        public Builder fileToken(String str) {
            this.mFileToken = str;
            return this;
        }

        public Builder jobQueue(JobQueue jobQueue) {
            this.mJobQueue = jobQueue;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder httpJobBuilder(HttpJob.Builder<LiveAgentStringResponse> builder) {
            this.mHttpJobBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder httpClient(HttpClient httpClient) {
            this.mHttpClient = httpClient;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder requestComposerFactory(FileUploadRequestComposer.Factory factory) {
            this.mRequestComposerFactory = factory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder progressMonitorFactory(FileTransferProgressMonitor.Factory factory) {
            this.mProgressMonitorFactory = factory;
            return this;
        }

        public InternalFileTransferAssistant build() throws NoSuchAlgorithmException, KeyManagementException {
            Arguments.checkValidSalesforceId(this.mOrganizationId, "Invalid Organization ID");
            Arguments.checkNotNull(this.mSessionInfo);
            Arguments.checkNotNull(this.mUploadUrl);
            Arguments.checkNotNull(this.mFileToken);
            if (this.mHttpJobBuilder == null) {
                this.mHttpJobBuilder = new HttpJob.Builder<>();
            }
            if (this.mJobQueue == null) {
                this.mJobQueue = new JobQueue(Executors.newCachedThreadPool(PriorityThreadFactory.background()));
            }
            if (this.mHttpClient == null) {
                this.mHttpClient = HttpFactory.client().sslSocketFactory(new TlsSocketFactory(), TlsSocketFactory.systemDefaultTrustManager()).build();
            }
            if (this.mRequestComposerFactory == null) {
                this.mRequestComposerFactory = new FileUploadRequestComposer.Factory();
            }
            if (this.mProgressMonitorFactory == null) {
                this.mProgressMonitorFactory = new FileTransferProgressMonitor.Factory();
            }
            this.mHttpJobBuilder.httpClient(this.mHttpClient).gson(new g().a((Type) LiveAgentStringResponse.class, (Object) new LiveAgentStringResponseDeserializer()).d()).responseClass(LiveAgentStringResponse.class);
            return new InternalFileTransferAssistant(this);
        }
    }
}
