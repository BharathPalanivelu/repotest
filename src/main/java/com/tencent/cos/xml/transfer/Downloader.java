package com.tencent.cos.xml.transfer;

import android.content.Context;
import com.tencent.cos.xml.CosXml;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.utils.SharePreferenceUtils;
import java.io.File;
import java.util.List;

public class Downloader {
    private String bucket;
    private String cosPath;
    /* access modifiers changed from: private */
    public CosXml cosXmlServer;
    /* access modifiers changed from: private */
    public GetObjectRequest getObjectRequest;
    /* access modifiers changed from: private */
    public ListenerHandler listenerHandler = new ListenerHandler();
    private String localFileName;
    private String localPath;
    /* access modifiers changed from: private */
    public long rangeStart = 0;
    /* access modifiers changed from: private */
    public SharePreferenceUtils sharePreferedUtils;

    public Downloader(Context context, CosXml cosXml) {
        this.sharePreferedUtils = SharePreferenceUtils.instance(context);
        this.cosXmlServer = cosXml;
    }

    public void setProgress(CosXmlProgressListener cosXmlProgressListener) {
        this.listenerHandler.setCosXmlProgressListener(cosXmlProgressListener);
    }

    public GetObjectResult download(String str, String str2, String str3, String str4) throws CosXmlClientException, CosXmlServiceException {
        this.bucket = str;
        this.cosPath = str2;
        this.localPath = str3;
        this.localFileName = str4;
        checkParameters();
        List list = (List) this.cosXmlServer.headObject(new HeadObjectRequest(str, str2)).headers.get("ETag");
        String str5 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
        this.getObjectRequest = new GetObjectRequest(str, str2, str3, str4);
        this.rangeStart = 0;
        String downloadPath = this.getObjectRequest.getDownloadPath();
        if (str5 != null) {
            String value = this.sharePreferedUtils.getValue(downloadPath);
            if (value == null || !str5.equals(value)) {
                this.sharePreferedUtils.updateValue(downloadPath, str5);
            } else {
                this.rangeStart = getRange(downloadPath);
            }
        }
        this.getObjectRequest.setRange(this.rangeStart);
        this.getObjectRequest.setProgressListener(this.listenerHandler);
        GetObjectResult object = this.cosXmlServer.getObject(this.getObjectRequest);
        this.sharePreferedUtils.clear(downloadPath);
        return object;
    }

    public void download(String str, String str2, String str3, String str4, CosXmlResultListener cosXmlResultListener) {
        this.bucket = str;
        this.cosPath = str2;
        this.localPath = str3;
        this.localFileName = str4;
        this.listenerHandler.setCosXmlResultListener(cosXmlResultListener);
        try {
            checkParameters();
            this.getObjectRequest = new GetObjectRequest(str, str2, str3, str4);
            this.cosXmlServer.headObjectAsync(new HeadObjectRequest(str, str2), new CosXmlResultListener() {
                public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                    List list = (List) ((HeadObjectResult) cosXmlResult).headers.get("ETag");
                    String str = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                    long unused = Downloader.this.rangeStart = 0;
                    String downloadPath = Downloader.this.getObjectRequest.getDownloadPath();
                    if (str != null) {
                        String value = Downloader.this.sharePreferedUtils.getValue(downloadPath);
                        if (value == null || !str.equals(value)) {
                            Downloader.this.sharePreferedUtils.updateValue(downloadPath, str);
                        } else {
                            Downloader downloader = Downloader.this;
                            long unused2 = downloader.rangeStart = downloader.getRange(downloadPath);
                        }
                    }
                    Downloader.this.getObjectRequest.setRange(Downloader.this.rangeStart);
                    Downloader.this.getObjectRequest.setProgressListener(Downloader.this.listenerHandler);
                    Downloader.this.cosXmlServer.getObjectAsync(Downloader.this.getObjectRequest, Downloader.this.listenerHandler);
                }

                public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                    Downloader.this.listenerHandler.onFail(Downloader.this.getObjectRequest, cosXmlClientException, cosXmlServiceException);
                }
            });
        } catch (CosXmlClientException e2) {
            this.listenerHandler.onFail(this.getObjectRequest, e2, (CosXmlServiceException) null);
        }
    }

    public void cancel() {
        GetObjectRequest getObjectRequest2 = this.getObjectRequest;
        if (getObjectRequest2 != null) {
            CosXml cosXml = this.cosXmlServer;
            if (cosXml != null) {
                cosXml.cancel(getObjectRequest2);
            }
        }
    }

    /* access modifiers changed from: private */
    public long getRange(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        return 0;
    }

    private void checkParameters() throws CosXmlClientException {
        if (this.bucket == null) {
            throw new CosXmlClientException("bucket must not be null ");
        } else if (this.cosPath == null) {
            throw new CosXmlClientException("cosPath must not be null ");
        } else if (this.localPath == null) {
            throw new CosXmlClientException("localPath must not be null ");
        }
    }

    private class ListenerHandler implements CosXmlProgressListener, CosXmlResultListener {
        private CosXmlProgressListener cosXmlProgressListener;
        private CosXmlResultListener cosXmlResultListener;

        public ListenerHandler() {
        }

        public void setCosXmlProgressListener(CosXmlProgressListener cosXmlProgressListener2) {
            this.cosXmlProgressListener = cosXmlProgressListener2;
        }

        public void setCosXmlResultListener(CosXmlResultListener cosXmlResultListener2) {
            this.cosXmlResultListener = cosXmlResultListener2;
        }

        public void onProgress(long j, long j2) {
            CosXmlProgressListener cosXmlProgressListener2 = this.cosXmlProgressListener;
            if (cosXmlProgressListener2 != null) {
                cosXmlProgressListener2.onProgress(Downloader.this.rangeStart + j, Downloader.this.rangeStart + j2);
            }
        }

        public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
            Downloader.this.sharePreferedUtils.clear(Downloader.this.getObjectRequest.getDownloadPath());
            CosXmlResultListener cosXmlResultListener2 = this.cosXmlResultListener;
            if (cosXmlResultListener2 != null) {
                cosXmlResultListener2.onSuccess(cosXmlRequest, cosXmlResult);
            }
        }

        public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
            CosXmlResultListener cosXmlResultListener2 = this.cosXmlResultListener;
            if (cosXmlResultListener2 != null) {
                cosXmlResultListener2.onFail(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
            }
        }
    }
}
