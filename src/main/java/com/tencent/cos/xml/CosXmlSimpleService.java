package com.tencent.cos.xml;

import android.content.Context;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.AbortMultiUploadRequest;
import com.tencent.cos.xml.model.object.AbortMultiUploadResult;
import com.tencent.cos.xml.model.object.AppendObjectRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.DeleteObjectRequest;
import com.tencent.cos.xml.model.object.DeleteObjectResult;
import com.tencent.cos.xml.model.object.GetObjectBytesRequest;
import com.tencent.cos.xml.model.object.GetObjectBytesResult;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadResult;
import com.tencent.cos.xml.model.object.ListPartsRequest;
import com.tencent.cos.xml.model.object.ListPartsResult;
import com.tencent.cos.xml.model.object.PostObjectRequest;
import com.tencent.cos.xml.model.object.PostObjectResult;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectResult;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.object.UploadPartResult;
import com.tencent.cos.xml.transfer.ResponseBytesConverter;
import com.tencent.cos.xml.transfer.ResponseFileBodySerializer;
import com.tencent.cos.xml.transfer.ResponseXmlS3BodySerializer;
import com.tencent.cos.xml.utils.URLEncodeUtils;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.auth.QCloudLifecycleCredentials;
import com.tencent.qcloud.core.auth.QCloudSignSourceProvider;
import com.tencent.qcloud.core.auth.SessionQCloudCredentials;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudResultListener;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.HttpResult;
import com.tencent.qcloud.core.http.HttpTask;
import com.tencent.qcloud.core.http.QCloudHttpClient;
import com.tencent.qcloud.core.http.QCloudHttpRequest;
import com.tencent.qcloud.core.http.ResponseBodyConverter;
import com.tencent.qcloud.core.logger.FileLogAdapter;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.net.UnknownHostException;

public class CosXmlSimpleService implements SimpleCosXml {
    public static String appCachePath;
    protected String appid;
    protected QCloudHttpClient client;
    protected QCloudCredentialProvider credentialProvider;
    protected String ip;
    protected String region;
    protected String scheme;
    protected String tag = "CosXml";

    public CosXmlSimpleService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudCredentialProvider qCloudCredentialProvider) {
        QCloudLogger.addAdapter(new FileLogAdapter(context, "QLog"));
        appCachePath = context.getApplicationContext().getExternalCacheDir().getPath();
        this.client = QCloudHttpClient.getDefault();
        this.client.addVerifiedHost("*.myqcloud.com");
        this.client.setDebuggable(cosXmlServiceConfig.isDebuggable());
        this.scheme = cosXmlServiceConfig.getProtocol();
        this.region = cosXmlServiceConfig.getRegion();
        this.appid = cosXmlServiceConfig.getAppid();
        this.ip = cosXmlServiceConfig.getIp();
        this.credentialProvider = qCloudCredentialProvider;
    }

    public void addCustomerDNS(String str, String[] strArr) throws CosXmlClientException {
        try {
            this.client.addDnsRecord(str, strArr);
        } catch (UnknownHostException e2) {
            throw new CosXmlClientException((Throwable) e2);
        }
    }

    /* access modifiers changed from: protected */
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> QCloudHttpRequest buildHttpRequest(T1 t1, T2 t2) throws CosXmlClientException {
        t1.checkParameters();
        String host = t1.getHost(this.appid, this.region, t1.isSupportAccelerate());
        QCloudHttpRequest.Builder scheme2 = new QCloudHttpRequest.Builder().method(t1.getMethod()).scheme(this.scheme);
        String str = this.ip;
        if (str == null) {
            str = host;
        }
        QCloudHttpRequest.Builder tag2 = scheme2.host(str).path(t1.getPath()).addHeader(HttpConstants.Header.HOST, host).userAgent(CosXmlServiceConfig.DEFAULT_USER_AGENT).tag((Object) this.tag);
        if (this.credentialProvider == null) {
            tag2.signer((String) null, (QCloudSignSourceProvider) null);
        } else if (t1 instanceof PostObjectRequest) {
            tag2.signer((String) null, (QCloudSignSourceProvider) null);
            try {
                QCloudLifecycleCredentials qCloudLifecycleCredentials = (QCloudLifecycleCredentials) this.credentialProvider.getCredentials();
                ((PostObjectRequest) t1).setSecretIdAndKey(qCloudLifecycleCredentials.getSecretId(), qCloudLifecycleCredentials.getSignKey(), qCloudLifecycleCredentials.getKeyTime());
                QCloudCredentialProvider qCloudCredentialProvider = this.credentialProvider;
                if (qCloudCredentialProvider instanceof SessionQCloudCredentials) {
                    tag2.addHeader("x-cos-security-token", ((SessionQCloudCredentials) qCloudCredentialProvider).getToken());
                }
            } catch (QCloudClientException e2) {
                throw new CosXmlClientException((Throwable) e2);
            }
        } else {
            tag2.signer("CosXmlSigner", t1.getSignSourceProvider());
        }
        tag2.query(t1.getQueryString());
        tag2.addHeaders(t1.getRequestHeaders());
        if (t1.isNeedMD5()) {
            tag2.contentMD5();
        }
        if (t1.getRequestBody() != null) {
            tag2.body(t1.getRequestBody());
        }
        if (t1 instanceof GetObjectRequest) {
            tag2.converter((ResponseBodyConverter) new ResponseFileBodySerializer((GetObjectResult) t2, ((GetObjectRequest) t1).getDownloadPath(), 0));
        } else if (t1 instanceof GetObjectBytesRequest) {
            tag2.converter((ResponseBodyConverter) new ResponseBytesConverter((GetObjectBytesResult) t2));
        } else {
            tag2.converter((ResponseBodyConverter) new ResponseXmlS3BodySerializer(t2));
        }
        return tag2.build();
    }

    /* access modifiers changed from: protected */
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> T2 execute(T1 t1, T2 t2) throws CosXmlClientException, CosXmlServiceException {
        HttpTask httpTask;
        try {
            QCloudHttpRequest buildHttpRequest = buildHttpRequest(t1, t2);
            if (t1 instanceof PostObjectRequest) {
                httpTask = this.client.resolveRequest(buildHttpRequest, (QCloudCredentialProvider) null);
            } else {
                httpTask = this.client.resolveRequest(buildHttpRequest, this.credentialProvider);
            }
            t1.setTask(httpTask);
            if (t1 instanceof AppendObjectRequest) {
                httpTask.addProgressListener(((AppendObjectRequest) t1).getProgressListener());
            } else if (t1 instanceof PutObjectRequest) {
                httpTask.addProgressListener(((PutObjectRequest) t1).getProgressListener());
            } else if (t1 instanceof UploadPartRequest) {
                httpTask.addProgressListener(((UploadPartRequest) t1).getProgressListener());
            } else if (t1 instanceof GetObjectRequest) {
                httpTask.addProgressListener(((GetObjectRequest) t1).getProgressListener());
            } else if (t1 instanceof PostObjectRequest) {
                httpTask.addProgressListener(((PostObjectRequest) t1).getProgressListener());
            }
            return (CosXmlResult) ((HttpResult) httpTask.executeNow()).content();
        } catch (QCloudServiceException e2) {
            throw ((CosXmlServiceException) e2);
        } catch (QCloudClientException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    /* access modifiers changed from: protected */
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> void schedule(final T1 t1, T2 t2, final CosXmlResultListener cosXmlResultListener) {
        HttpTask httpTask;
        AnonymousClass1 r0 = new QCloudResultListener<HttpResult<T2>>() {
            public void onSuccess(HttpResult<T2> httpResult) {
                cosXmlResultListener.onSuccess(t1, (CosXmlResult) httpResult.content());
            }

            public void onFailure(QCloudClientException qCloudClientException, QCloudServiceException qCloudServiceException) {
                if (qCloudClientException != null) {
                    cosXmlResultListener.onFail(t1, new CosXmlClientException((Throwable) qCloudClientException), (CosXmlServiceException) null);
                } else {
                    cosXmlResultListener.onFail(t1, (CosXmlClientException) null, (CosXmlServiceException) qCloudServiceException);
                }
            }
        };
        try {
            QCloudHttpRequest buildHttpRequest = buildHttpRequest(t1, t2);
            if (t1 instanceof PostObjectRequest) {
                httpTask = this.client.resolveRequest(buildHttpRequest, (QCloudCredentialProvider) null);
            } else {
                httpTask = this.client.resolveRequest(buildHttpRequest, this.credentialProvider);
            }
            t1.setTask(httpTask);
            if (t1 instanceof AppendObjectRequest) {
                httpTask.addProgressListener(((AppendObjectRequest) t1).getProgressListener());
            } else if (t1 instanceof PutObjectRequest) {
                httpTask.addProgressListener(((PutObjectRequest) t1).getProgressListener());
            } else if (t1 instanceof UploadPartRequest) {
                httpTask.addProgressListener(((UploadPartRequest) t1).getProgressListener());
            } else if (t1 instanceof GetObjectRequest) {
                httpTask.addProgressListener(((GetObjectRequest) t1).getProgressListener());
            } else if (t1 instanceof PostObjectRequest) {
                httpTask.addProgressListener(((PostObjectRequest) t1).getProgressListener());
            }
            httpTask.schedule().addResultListener(r0);
        } catch (QCloudClientException e2) {
            cosXmlResultListener.onFail(t1, new CosXmlClientException((Throwable) e2), (CosXmlServiceException) null);
        }
    }

    public String getAccessUrl(CosXmlRequest cosXmlRequest) {
        String host = cosXmlRequest.getHost(this.appid, this.region, false);
        String path = cosXmlRequest.getPath();
        try {
            path = URLEncodeUtils.cosPathEncode(cosXmlRequest.getPath());
        } catch (CosXmlClientException unused) {
        }
        return host + path;
    }

    public InitMultipartUploadResult initMultipartUpload(InitMultipartUploadRequest initMultipartUploadRequest) throws CosXmlClientException, CosXmlServiceException {
        return (InitMultipartUploadResult) execute(initMultipartUploadRequest, new InitMultipartUploadResult());
    }

    public void initMultipartUploadAsync(InitMultipartUploadRequest initMultipartUploadRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(initMultipartUploadRequest, new InitMultipartUploadResult(), cosXmlResultListener);
    }

    public ListPartsResult listParts(ListPartsRequest listPartsRequest) throws CosXmlClientException, CosXmlServiceException {
        return (ListPartsResult) execute(listPartsRequest, new ListPartsResult());
    }

    public void listPartsAsync(ListPartsRequest listPartsRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(listPartsRequest, new ListPartsResult(), cosXmlResultListener);
    }

    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws CosXmlClientException, CosXmlServiceException {
        return (UploadPartResult) execute(uploadPartRequest, new UploadPartResult());
    }

    public void uploadPartAsync(UploadPartRequest uploadPartRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(uploadPartRequest, new UploadPartResult(), cosXmlResultListener);
    }

    public AbortMultiUploadResult abortMultiUpload(AbortMultiUploadRequest abortMultiUploadRequest) throws CosXmlClientException, CosXmlServiceException {
        return (AbortMultiUploadResult) execute(abortMultiUploadRequest, new AbortMultiUploadResult());
    }

    public void abortMultiUploadAsync(AbortMultiUploadRequest abortMultiUploadRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(abortMultiUploadRequest, new AbortMultiUploadResult(), cosXmlResultListener);
    }

    public CompleteMultiUploadResult completeMultiUpload(CompleteMultiUploadRequest completeMultiUploadRequest) throws CosXmlClientException, CosXmlServiceException {
        CompleteMultiUploadResult completeMultiUploadResult = new CompleteMultiUploadResult();
        completeMultiUploadResult.accessUrl = getAccessUrl(completeMultiUploadRequest);
        return (CompleteMultiUploadResult) execute(completeMultiUploadRequest, completeMultiUploadResult);
    }

    public void completeMultiUploadAsync(CompleteMultiUploadRequest completeMultiUploadRequest, CosXmlResultListener cosXmlResultListener) {
        CompleteMultiUploadResult completeMultiUploadResult = new CompleteMultiUploadResult();
        completeMultiUploadResult.accessUrl = getAccessUrl(completeMultiUploadRequest);
        schedule(completeMultiUploadRequest, completeMultiUploadResult, cosXmlResultListener);
    }

    public DeleteObjectResult deleteObject(DeleteObjectRequest deleteObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteObjectResult) execute(deleteObjectRequest, new DeleteObjectResult());
    }

    public void deleteObjectAsync(DeleteObjectRequest deleteObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteObjectRequest, new DeleteObjectResult(), cosXmlResultListener);
    }

    public GetObjectResult getObject(GetObjectRequest getObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetObjectResult) execute(getObjectRequest, new GetObjectResult());
    }

    public void getObjectAsync(GetObjectRequest getObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getObjectRequest, new GetObjectResult(), cosXmlResultListener);
    }

    public PutObjectResult putObject(PutObjectRequest putObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        PutObjectResult putObjectResult = new PutObjectResult();
        putObjectResult.accessUrl = getAccessUrl(putObjectRequest);
        return (PutObjectResult) execute(putObjectRequest, putObjectResult);
    }

    public void putObjectAsync(PutObjectRequest putObjectRequest, CosXmlResultListener cosXmlResultListener) {
        PutObjectResult putObjectResult = new PutObjectResult();
        putObjectResult.accessUrl = getAccessUrl(putObjectRequest);
        schedule(putObjectRequest, putObjectResult, cosXmlResultListener);
    }

    public PostObjectResult postObject(PostObjectRequest postObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PostObjectResult) execute(postObjectRequest, new PostObjectResult());
    }

    public void postObjectAsync(PostObjectRequest postObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(postObjectRequest, new PostObjectResult(), cosXmlResultListener);
    }

    public byte[] getObject(String str, String str2) throws CosXmlClientException, CosXmlServiceException {
        GetObjectBytesResult getObjectBytesResult = (GetObjectBytesResult) execute(new GetObjectBytesRequest(str, str2), new GetObjectBytesResult());
        return getObjectBytesResult != null ? getObjectBytesResult.data : new byte[0];
    }

    public void cancel(CosXmlRequest cosXmlRequest) {
        if (cosXmlRequest != null && cosXmlRequest.getHttpTask() != null) {
            cosXmlRequest.getHttpTask().cancel();
        }
    }

    public void cancelAll() {
        for (HttpTask cancel : this.client.getTasksByTag(this.tag)) {
            cancel.cancel();
        }
    }

    public void release() {
        cancelAll();
    }

    public String getAppid() {
        return this.appid;
    }

    public String getRegion() {
        return this.region;
    }
}
