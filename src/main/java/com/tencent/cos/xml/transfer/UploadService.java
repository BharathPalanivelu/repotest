package com.tencent.cos.xml.transfer;

import android.content.Context;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.AbortMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadResult;
import com.tencent.cos.xml.model.object.ListPartsRequest;
import com.tencent.cos.xml.model.object.ListPartsResult;
import com.tencent.cos.xml.model.object.ObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectResult;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.object.UploadPartResult;
import com.tencent.cos.xml.model.tag.ListParts;
import com.tencent.cos.xml.utils.SharePreferenceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class UploadService {
    private static final long SIZE_LIMIT = 2097152;
    /* access modifiers changed from: private */
    public static String TAG = "UploadService";
    /* access modifiers changed from: private */
    public AtomicLong ALREADY_SEND_DATA_LEN;
    /* access modifiers changed from: private */
    public volatile int ERROR_EXIT_FLAG;
    /* access modifiers changed from: private */
    public AtomicInteger UPLOAD_PART_COUNT;
    private String bucket;
    private CompleteMultiUploadRequest completeMultiUploadRequest;
    private String cosPath;
    /* access modifiers changed from: private */
    public CosXmlProgressListener cosXmlProgressListener;
    private CosXmlSimpleService cosXmlService;
    private EncryptionType encryptionType = EncryptionType.NONE;
    private long endTime = -1;
    /* access modifiers changed from: private */
    public long fileLength;
    private List<String> headers = new ArrayList();
    private InitMultipartUploadRequest initMultipartUploadRequest;
    private boolean isNeedMd5 = false;
    private boolean isSupportAccelerate = false;
    private ListPartsRequest listPartsRequest;
    /* access modifiers changed from: private */
    public Exception mException;
    /* access modifiers changed from: private */
    public byte[] objectSync = new byte[0];
    private OnUploadInfoListener onUploadInfoListener;
    private Map<Integer, SlicePartStruct> partStructMap;
    private PutObjectRequest putObjectRequest;
    ResumeData resumeData;
    private SharePreferenceUtils sharePreferenceUtils;
    private long sliceSize = SIZE_LIMIT;
    private String srcPath;
    private long startTime = -1;
    private String uploadId;
    /* access modifiers changed from: private */
    public Map<UploadPartRequest, Long> uploadPartRequestLongMap;
    /* access modifiers changed from: private */
    public UploadServiceResult uploadServiceResult;

    public enum EncryptionType {
        SSE,
        SSEC,
        SSEKMS,
        NONE
    }

    public interface OnUploadInfoListener {
        void onInfo(ResumeData resumeData);
    }

    public static class ResumeData {
        public String bucket;
        public String cosPath;
        public String customerKeyForSSEC;
        public String customerKeyIdForSSEKMS;
        public String jsonContentForSSEKMS;
        public long sliceSize;
        public String srcPath;
        public String uploadId;
    }

    public UploadService(CosXmlSimpleService cosXmlSimpleService, ResumeData resumeData2) {
        this.cosXmlService = cosXmlSimpleService;
        init(resumeData2);
    }

    public UploadService(CosXmlSimpleService cosXmlSimpleService, String str, String str2, String str3, long j, Context context) {
        String str4;
        if (context != null) {
            this.sharePreferenceUtils = SharePreferenceUtils.instance(context.getApplicationContext());
            String key = getKey(cosXmlSimpleService, str, str2, str3, j);
            if (key != null) {
                str4 = this.sharePreferenceUtils.getValue(key);
                ResumeData resumeData2 = new ResumeData();
                resumeData2.bucket = str;
                resumeData2.cosPath = str2;
                resumeData2.sliceSize = j;
                resumeData2.srcPath = str3;
                resumeData2.uploadId = str4;
                this.cosXmlService = cosXmlSimpleService;
                init(resumeData2);
            }
        }
        str4 = null;
        ResumeData resumeData22 = new ResumeData();
        resumeData22.bucket = str;
        resumeData22.cosPath = str2;
        resumeData22.sliceSize = j;
        resumeData22.srcPath = str3;
        resumeData22.uploadId = str4;
        this.cosXmlService = cosXmlSimpleService;
        init(resumeData22);
    }

    /* access modifiers changed from: package-private */
    public String getKey(CosXmlSimpleService cosXmlSimpleService, String str, String str2, String str3, long j) {
        File file = new File(str3);
        String str4 = null;
        if (!file.exists()) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (cosXmlSimpleService != null) {
            str4 = cosXmlSimpleService.getAppid();
        }
        stringBuffer.append(str4);
        stringBuffer.append(";");
        stringBuffer.append(str);
        stringBuffer.append(";");
        stringBuffer.append(str2);
        stringBuffer.append(";");
        stringBuffer.append(str3);
        stringBuffer.append(";");
        stringBuffer.append(file.length());
        stringBuffer.append(";");
        stringBuffer.append(file.lastModified());
        stringBuffer.append(";");
        stringBuffer.append(j);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public void clearSharePreference() {
        SharePreferenceUtils sharePreferenceUtils2 = this.sharePreferenceUtils;
        if (sharePreferenceUtils2 != null) {
            sharePreferenceUtils2.clear(getKey(this.cosXmlService, this.bucket, this.cosPath, this.srcPath, this.sliceSize));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean updateSharePreference(String str) {
        SharePreferenceUtils sharePreferenceUtils2 = this.sharePreferenceUtils;
        if (sharePreferenceUtils2 == null) {
            return false;
        }
        return sharePreferenceUtils2.updateValue(getKey(this.cosXmlService, this.bucket, this.cosPath, this.srcPath, this.sliceSize), str);
    }

    /* access modifiers changed from: package-private */
    public void init(ResumeData resumeData2) {
        this.bucket = resumeData2.bucket;
        this.cosPath = resumeData2.cosPath;
        this.srcPath = resumeData2.srcPath;
        this.sliceSize = resumeData2.sliceSize;
        this.uploadId = resumeData2.uploadId;
        this.UPLOAD_PART_COUNT = new AtomicInteger(0);
        this.ALREADY_SEND_DATA_LEN = new AtomicLong(0);
        this.ERROR_EXIT_FLAG = 0;
        this.partStructMap = new LinkedHashMap();
        this.uploadPartRequestLongMap = new LinkedHashMap();
        this.resumeData = resumeData2;
    }

    private void checkParameter() throws CosXmlClientException {
        String str = this.srcPath;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                this.fileLength = file.length();
                return;
            }
        }
        throw new CosXmlClientException("srcPath :" + this.srcPath + " is invalid or is not exist");
    }

    public void setSign(long j, long j2) {
        this.startTime = j;
        this.endTime = j2;
    }

    private void setSignTime(CosXmlRequest cosXmlRequest) {
        if (cosXmlRequest != null) {
            long j = this.startTime;
            if (j > 0) {
                long j2 = this.endTime;
                if (j2 >= j) {
                    cosXmlRequest.setSign(j, j2);
                }
            }
        }
    }

    public void setRequestHeaders(String str, String str2) {
        if (str != null && str2 != null) {
            this.headers.add(str);
            this.headers.add(str2);
        }
    }

    public void setNeedMd5(boolean z) {
        this.isNeedMd5 = z;
    }

    public void setCOSServerSideEncryptionType(EncryptionType encryptionType2) {
        this.encryptionType = encryptionType2;
    }

    public void isSupportAccelerate(boolean z) {
        this.isSupportAccelerate = z;
    }

    /* renamed from: com.tencent.cos.xml.transfer.UploadService$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType = new int[EncryptionType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.tencent.cos.xml.transfer.UploadService$EncryptionType[] r0 = com.tencent.cos.xml.transfer.UploadService.EncryptionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType = r0
                int[] r0 = $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.tencent.cos.xml.transfer.UploadService$EncryptionType r1 = com.tencent.cos.xml.transfer.UploadService.EncryptionType.NONE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.tencent.cos.xml.transfer.UploadService$EncryptionType r1 = com.tencent.cos.xml.transfer.UploadService.EncryptionType.SSE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.tencent.cos.xml.transfer.UploadService$EncryptionType r1 = com.tencent.cos.xml.transfer.UploadService.EncryptionType.SSEC     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.tencent.cos.xml.transfer.UploadService$EncryptionType r1 = com.tencent.cos.xml.transfer.UploadService.EncryptionType.SSEKMS     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.transfer.UploadService.AnonymousClass5.<clinit>():void");
        }
    }

    private void setEncryption(CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        if (cosXmlRequest != null) {
            int i = AnonymousClass5.$SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType[this.encryptionType.ordinal()];
            if (i == 1) {
                return;
            }
            if (i == 2) {
                ((ObjectRequest) cosXmlRequest).setCOSServerSideEncryption();
            } else if (i == 3) {
                ((ObjectRequest) cosXmlRequest).setCOSServerSideEncryptionWithCustomerKey(this.resumeData.customerKeyForSSEC);
            } else if (i == 4) {
                ((ObjectRequest) cosXmlRequest).setCOSServerSideEncryptionWithKMS(this.resumeData.customerKeyIdForSSEKMS, this.resumeData.jsonContentForSSEKMS);
            }
        }
    }

    public void setProgressListener(CosXmlProgressListener cosXmlProgressListener2) {
        this.cosXmlProgressListener = cosXmlProgressListener2;
    }

    public void setOnUploadInfoListener(OnUploadInfoListener onUploadInfoListener2) {
        this.onUploadInfoListener = onUploadInfoListener2;
    }

    private void setRequestHeaders(CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        if (cosXmlRequest != null) {
            int size = this.headers.size();
            for (int i = 0; i < size - 2; i += 2) {
                cosXmlRequest.setRequestHeaders(this.headers.get(i), this.headers.get(i + 1), false);
            }
        }
    }

    private void setSupportAccelerate(CosXmlRequest cosXmlRequest) {
        if (cosXmlRequest != null) {
            boolean z = this.isSupportAccelerate;
            if (z) {
                cosXmlRequest.isSupportAccelerate(z);
            }
        }
    }

    public UploadServiceResult upload() throws CosXmlClientException, CosXmlServiceException {
        checkParameter();
        if (this.fileLength < SIZE_LIMIT) {
            return putObject(this.bucket, this.cosPath, this.srcPath);
        }
        return multiUploadParts();
    }

    public CosXmlResult resume(ResumeData resumeData2) throws CosXmlServiceException, CosXmlClientException {
        init(resumeData2);
        return upload();
    }

    public ResumeData pause() {
        this.ERROR_EXIT_FLAG = 2;
        ResumeData resumeData2 = new ResumeData();
        resumeData2.bucket = this.bucket;
        resumeData2.cosPath = this.cosPath;
        resumeData2.sliceSize = this.sliceSize;
        resumeData2.srcPath = this.srcPath;
        resumeData2.uploadId = this.uploadId;
        resumeData2.customerKeyForSSEC = this.resumeData.customerKeyForSSEC;
        resumeData2.customerKeyIdForSSEKMS = this.resumeData.customerKeyIdForSSEKMS;
        resumeData2.jsonContentForSSEKMS = this.resumeData.jsonContentForSSEKMS;
        return resumeData2;
    }

    public void abort(CosXmlResultListener cosXmlResultListener) {
        this.ERROR_EXIT_FLAG = 3;
        abortMultiUpload(cosXmlResultListener);
    }

    /* access modifiers changed from: private */
    public void clear() {
        this.putObjectRequest = null;
        this.initMultipartUploadRequest = null;
        this.listPartsRequest = null;
        this.completeMultiUploadRequest = null;
        this.partStructMap.clear();
        this.uploadPartRequestLongMap.clear();
    }

    private UploadServiceResult putObject(String str, String str2, String str3) throws CosXmlClientException, CosXmlServiceException {
        this.UPLOAD_PART_COUNT.set(1);
        this.putObjectRequest = new PutObjectRequest(str, str2, str3);
        this.putObjectRequest.setProgressListener(this.cosXmlProgressListener);
        setSignTime(this.putObjectRequest);
        setRequestHeaders(this.putObjectRequest);
        setSupportAccelerate(this.putObjectRequest);
        setEncryption(this.putObjectRequest);
        this.putObjectRequest.setNeedMD5(this.isNeedMd5);
        this.cosXmlService.putObjectAsync(this.putObjectRequest, new CosXmlResultListener() {
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                synchronized (UploadService.this.objectSync) {
                    PutObjectResult putObjectResult = (PutObjectResult) cosXmlResult;
                    if (UploadService.this.uploadServiceResult == null) {
                        UploadServiceResult unused = UploadService.this.uploadServiceResult = new UploadServiceResult();
                    }
                    UploadService.this.uploadServiceResult.httpCode = putObjectResult.httpCode;
                    UploadService.this.uploadServiceResult.httpMessage = putObjectResult.httpMessage;
                    UploadService.this.uploadServiceResult.headers = putObjectResult.headers;
                    UploadService.this.uploadServiceResult.eTag = putObjectResult.eTag;
                }
                UploadService.this.UPLOAD_PART_COUNT.decrementAndGet();
            }

            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                synchronized (UploadService.this.objectSync) {
                    if (cosXmlClientException != null) {
                        Exception unused = UploadService.this.mException = cosXmlClientException;
                    } else {
                        Exception unused2 = UploadService.this.mException = cosXmlServiceException;
                    }
                    int unused3 = UploadService.this.ERROR_EXIT_FLAG = 1;
                }
            }
        });
        while (this.UPLOAD_PART_COUNT.get() > 0) {
            if (this.ERROR_EXIT_FLAG != 0) {
                break;
            }
        }
        if (this.ERROR_EXIT_FLAG > 0) {
            int i = this.ERROR_EXIT_FLAG;
            if (i == 1) {
                realCancel();
                Exception exc = this.mException;
                if (exc == null) {
                    throw new CosXmlClientException("unknown exception");
                } else if (exc instanceof CosXmlClientException) {
                    throw ((CosXmlClientException) exc);
                } else if (exc instanceof CosXmlServiceException) {
                    throw ((CosXmlServiceException) exc);
                }
            } else if (i == 2) {
                realCancel();
                clear();
                throw new CosXmlClientException("request is cancelled by manual pause");
            } else if (i == 3) {
                throw new CosXmlClientException("request is cancelled by abort request");
            }
        }
        this.uploadServiceResult.accessUrl = this.cosXmlService.getAccessUrl(this.putObjectRequest);
        return this.uploadServiceResult;
    }

    private UploadServiceResult multiUploadParts() throws CosXmlClientException, CosXmlServiceException {
        initSlicePart();
        if (this.uploadId != null) {
            updateSlicePart(listPart());
        } else {
            this.uploadId = initMultiUpload().initMultipartUpload.uploadId;
        }
        if (this.onUploadInfoListener != null) {
            ResumeData resumeData2 = new ResumeData();
            resumeData2.bucket = this.bucket;
            resumeData2.cosPath = this.cosPath;
            resumeData2.sliceSize = this.sliceSize;
            resumeData2.srcPath = this.srcPath;
            resumeData2.uploadId = this.uploadId;
            resumeData2.customerKeyForSSEC = this.resumeData.customerKeyForSSEC;
            resumeData2.customerKeyIdForSSEKMS = this.resumeData.customerKeyIdForSSEKMS;
            resumeData2.jsonContentForSSEKMS = this.resumeData.jsonContentForSSEKMS;
            this.onUploadInfoListener.onInfo(resumeData2);
        }
        updateSharePreference(this.uploadId);
        for (Map.Entry<Integer, SlicePartStruct> value : this.partStructMap.entrySet()) {
            final SlicePartStruct slicePartStruct = (SlicePartStruct) value.getValue();
            if (!slicePartStruct.isAlreadyUpload) {
                uploadPart(slicePartStruct.partNumber, slicePartStruct.offset, slicePartStruct.sliceSize, new CosXmlResultListener() {
                    public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                        synchronized (UploadService.this.objectSync) {
                            slicePartStruct.eTag = ((UploadPartResult) cosXmlResult).eTag;
                            slicePartStruct.isAlreadyUpload = true;
                        }
                        UploadService.this.UPLOAD_PART_COUNT.decrementAndGet();
                    }

                    public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                        synchronized (UploadService.this.objectSync) {
                            if (cosXmlClientException != null) {
                                Exception unused = UploadService.this.mException = cosXmlClientException;
                            } else {
                                Exception unused2 = UploadService.this.mException = cosXmlServiceException;
                            }
                            int unused3 = UploadService.this.ERROR_EXIT_FLAG = 1;
                        }
                    }
                });
            }
        }
        while (this.UPLOAD_PART_COUNT.get() > 0) {
            if (this.ERROR_EXIT_FLAG != 0) {
                break;
            }
        }
        clearSharePreference();
        if (this.ERROR_EXIT_FLAG > 0) {
            int i = this.ERROR_EXIT_FLAG;
            if (i == 1) {
                realCancel();
                Exception exc = this.mException;
                if (exc == null) {
                    throw new CosXmlClientException("unknown exception");
                } else if (exc instanceof CosXmlClientException) {
                    throw ((CosXmlClientException) exc);
                } else if (exc instanceof CosXmlServiceException) {
                    throw ((CosXmlServiceException) exc);
                }
            } else if (i == 2) {
                realCancel();
                clear();
                throw new CosXmlClientException("request is cancelled by manual pause");
            } else if (i == 3) {
                throw new CosXmlClientException("request is cancelled by abort request");
            }
        }
        CompleteMultiUploadResult completeMultiUpload = completeMultiUpload();
        if (this.uploadServiceResult == null) {
            this.uploadServiceResult = new UploadServiceResult();
        }
        this.uploadServiceResult.httpCode = completeMultiUpload.httpCode;
        this.uploadServiceResult.httpMessage = completeMultiUpload.httpMessage;
        this.uploadServiceResult.headers = completeMultiUpload.headers;
        this.uploadServiceResult.eTag = completeMultiUpload.completeMultipartUpload.eTag;
        this.uploadServiceResult.accessUrl = this.cosXmlService.getAccessUrl(this.completeMultiUploadRequest);
        return this.uploadServiceResult;
    }

    private InitMultipartUploadResult initMultiUpload() throws CosXmlServiceException, CosXmlClientException {
        this.initMultipartUploadRequest = new InitMultipartUploadRequest(this.bucket, this.cosPath);
        setSignTime(this.initMultipartUploadRequest);
        setRequestHeaders(this.initMultipartUploadRequest);
        setSupportAccelerate(this.initMultipartUploadRequest);
        setEncryption(this.initMultipartUploadRequest);
        return this.cosXmlService.initMultipartUpload(this.initMultipartUploadRequest);
    }

    private ListPartsResult listPart() throws CosXmlServiceException, CosXmlClientException {
        this.listPartsRequest = new ListPartsRequest(this.bucket, this.cosPath, this.uploadId);
        setSignTime(this.listPartsRequest);
        setRequestHeaders(this.listPartsRequest);
        setSupportAccelerate(this.listPartsRequest);
        return this.cosXmlService.listParts(this.listPartsRequest);
    }

    private void uploadPart(int i, long j, long j2, CosXmlResultListener cosXmlResultListener) {
        CosXmlResultListener cosXmlResultListener2 = cosXmlResultListener;
        final UploadPartRequest uploadPartRequest = new UploadPartRequest(this.bucket, this.cosPath, i, this.srcPath, j, j2, this.uploadId);
        this.uploadPartRequestLongMap.put(uploadPartRequest, 0L);
        uploadPartRequest.setNeedMD5(this.isNeedMd5);
        setSignTime(uploadPartRequest);
        try {
            setRequestHeaders(uploadPartRequest);
            setSupportAccelerate(uploadPartRequest);
            setEncryption(uploadPartRequest);
            uploadPartRequest.setProgressListener(new CosXmlProgressListener() {
                /* JADX WARNING: Code restructure failed: missing block: B:10:0x0056, code lost:
                    com.tencent.qcloud.core.logger.QCloudLogger.d(com.tencent.cos.xml.transfer.UploadService.access$900(), "upload file has been abort", new java.lang.Object[0]);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0054, code lost:
                    if (com.tencent.cos.xml.transfer.UploadService.access$400(r4.this$0) > 0) goto L_0x0056;
                 */
                /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x004e */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onProgress(long r5, long r7) {
                    /*
                        r4 = this;
                        com.tencent.cos.xml.transfer.UploadService r7 = com.tencent.cos.xml.transfer.UploadService.this
                        byte[] r7 = r7.objectSync
                        monitor-enter(r7)
                        com.tencent.cos.xml.transfer.UploadService r8 = com.tencent.cos.xml.transfer.UploadService.this     // Catch:{ Exception -> 0x004e }
                        java.util.concurrent.atomic.AtomicLong r8 = r8.ALREADY_SEND_DATA_LEN     // Catch:{ Exception -> 0x004e }
                        com.tencent.cos.xml.transfer.UploadService r0 = com.tencent.cos.xml.transfer.UploadService.this     // Catch:{ Exception -> 0x004e }
                        java.util.Map r0 = r0.uploadPartRequestLongMap     // Catch:{ Exception -> 0x004e }
                        com.tencent.cos.xml.model.object.UploadPartRequest r1 = r3     // Catch:{ Exception -> 0x004e }
                        java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x004e }
                        java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ Exception -> 0x004e }
                        long r0 = r0.longValue()     // Catch:{ Exception -> 0x004e }
                        long r0 = r5 - r0
                        long r0 = r8.addAndGet(r0)     // Catch:{ Exception -> 0x004e }
                        com.tencent.cos.xml.transfer.UploadService r8 = com.tencent.cos.xml.transfer.UploadService.this     // Catch:{ Exception -> 0x004e }
                        java.util.Map r8 = r8.uploadPartRequestLongMap     // Catch:{ Exception -> 0x004e }
                        com.tencent.cos.xml.model.object.UploadPartRequest r2 = r3     // Catch:{ Exception -> 0x004e }
                        java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x004e }
                        r8.put(r2, r5)     // Catch:{ Exception -> 0x004e }
                        com.tencent.cos.xml.transfer.UploadService r5 = com.tencent.cos.xml.transfer.UploadService.this     // Catch:{ Exception -> 0x004e }
                        com.tencent.cos.xml.listener.CosXmlProgressListener r5 = r5.cosXmlProgressListener     // Catch:{ Exception -> 0x004e }
                        if (r5 == 0) goto L_0x0062
                        com.tencent.cos.xml.transfer.UploadService r5 = com.tencent.cos.xml.transfer.UploadService.this     // Catch:{ Exception -> 0x004e }
                        com.tencent.cos.xml.listener.CosXmlProgressListener r5 = r5.cosXmlProgressListener     // Catch:{ Exception -> 0x004e }
                        com.tencent.cos.xml.transfer.UploadService r6 = com.tencent.cos.xml.transfer.UploadService.this     // Catch:{ Exception -> 0x004e }
                        long r2 = r6.fileLength     // Catch:{ Exception -> 0x004e }
                        r5.onProgress(r0, r2)     // Catch:{ Exception -> 0x004e }
                        goto L_0x0062
                    L_0x004c:
                        r5 = move-exception
                        goto L_0x0064
                    L_0x004e:
                        com.tencent.cos.xml.transfer.UploadService r5 = com.tencent.cos.xml.transfer.UploadService.this     // Catch:{ all -> 0x004c }
                        int r5 = r5.ERROR_EXIT_FLAG     // Catch:{ all -> 0x004c }
                        if (r5 <= 0) goto L_0x0062
                        java.lang.String r5 = com.tencent.cos.xml.transfer.UploadService.TAG     // Catch:{ all -> 0x004c }
                        java.lang.String r6 = "upload file has been abort"
                        r8 = 0
                        java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x004c }
                        com.tencent.qcloud.core.logger.QCloudLogger.d(r5, r6, r8)     // Catch:{ all -> 0x004c }
                    L_0x0062:
                        monitor-exit(r7)     // Catch:{ all -> 0x004c }
                        return
                    L_0x0064:
                        monitor-exit(r7)     // Catch:{ all -> 0x004c }
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.transfer.UploadService.AnonymousClass3.onProgress(long, long):void");
                }
            });
            this.cosXmlService.uploadPartAsync(uploadPartRequest, cosXmlResultListener2);
        } catch (CosXmlClientException e2) {
            cosXmlResultListener2.onFail(this.putObjectRequest, e2, (CosXmlServiceException) null);
        }
    }

    private CompleteMultiUploadResult completeMultiUpload() throws CosXmlServiceException, CosXmlClientException {
        this.completeMultiUploadRequest = new CompleteMultiUploadRequest(this.bucket, this.cosPath, this.uploadId, (Map<Integer, String>) null);
        for (Map.Entry<Integer, SlicePartStruct> value : this.partStructMap.entrySet()) {
            SlicePartStruct slicePartStruct = (SlicePartStruct) value.getValue();
            this.completeMultiUploadRequest.setPartNumberAndETag(slicePartStruct.partNumber, slicePartStruct.eTag);
        }
        setSignTime(this.completeMultiUploadRequest);
        setRequestHeaders(this.completeMultiUploadRequest);
        setSupportAccelerate(this.completeMultiUploadRequest);
        this.completeMultiUploadRequest.setNeedMD5(this.isNeedMd5);
        return this.cosXmlService.completeMultiUpload(this.completeMultiUploadRequest);
    }

    private void abortMultiUpload(final CosXmlResultListener cosXmlResultListener) {
        String str = this.uploadId;
        if (str != null) {
            AbortMultiUploadRequest abortMultiUploadRequest = new AbortMultiUploadRequest(this.bucket, this.cosPath, str);
            setSignTime(abortMultiUploadRequest);
            try {
                setRequestHeaders(abortMultiUploadRequest);
                setSupportAccelerate(abortMultiUploadRequest);
                this.cosXmlService.abortMultiUploadAsync(abortMultiUploadRequest, new CosXmlResultListener() {
                    public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                        cosXmlResultListener.onSuccess(cosXmlRequest, cosXmlResult);
                        UploadService.this.realCancel();
                        UploadService.this.clear();
                    }

                    public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                        cosXmlResultListener.onFail(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                        UploadService.this.realCancel();
                        UploadService.this.clear();
                    }
                });
            } catch (CosXmlClientException e2) {
                cosXmlResultListener.onFail(abortMultiUploadRequest, e2, (CosXmlServiceException) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void realCancel() {
        this.cosXmlService.cancel(this.putObjectRequest);
        this.cosXmlService.cancel(this.initMultipartUploadRequest);
        this.cosXmlService.cancel(this.listPartsRequest);
        this.cosXmlService.cancel(this.completeMultiUploadRequest);
        Map<UploadPartRequest, Long> map = this.uploadPartRequestLongMap;
        if (map != null) {
            for (UploadPartRequest cancel : map.keySet()) {
                this.cosXmlService.cancel(cancel);
            }
        }
    }

    private void initSlicePart() throws CosXmlClientException {
        String str = this.srcPath;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                this.fileLength = file.length();
            } else {
                throw new CosXmlClientException("upload file does not exist");
            }
        }
        long j = this.fileLength;
        if (j > 0) {
            long j2 = this.sliceSize;
            if (j2 > 0) {
                int i = (int) (j / j2);
                int i2 = 1;
                while (i2 < i) {
                    SlicePartStruct slicePartStruct = new SlicePartStruct();
                    slicePartStruct.isAlreadyUpload = false;
                    slicePartStruct.partNumber = i2;
                    long j3 = this.sliceSize;
                    slicePartStruct.offset = ((long) (i2 - 1)) * j3;
                    slicePartStruct.sliceSize = j3;
                    this.partStructMap.put(Integer.valueOf(i2), slicePartStruct);
                    i2++;
                }
                SlicePartStruct slicePartStruct2 = new SlicePartStruct();
                slicePartStruct2.isAlreadyUpload = false;
                slicePartStruct2.partNumber = i2;
                slicePartStruct2.offset = ((long) (i2 - 1)) * this.sliceSize;
                slicePartStruct2.sliceSize = this.fileLength - slicePartStruct2.offset;
                this.partStructMap.put(Integer.valueOf(i2), slicePartStruct2);
                this.UPLOAD_PART_COUNT.set(i2);
                return;
            }
        }
        throw new CosXmlClientException("file size or slice size less than 0");
    }

    private void updateSlicePart(ListPartsResult listPartsResult) {
        if (listPartsResult != null && listPartsResult.listParts != null) {
            List<ListParts.Part> list = listPartsResult.listParts.parts;
            if (list != null) {
                for (ListParts.Part next : list) {
                    if (this.partStructMap.containsKey(Integer.valueOf(next.partNumber))) {
                        SlicePartStruct slicePartStruct = this.partStructMap.get(Integer.valueOf(next.partNumber));
                        slicePartStruct.isAlreadyUpload = true;
                        slicePartStruct.eTag = next.eTag;
                        this.UPLOAD_PART_COUNT.decrementAndGet();
                        this.ALREADY_SEND_DATA_LEN.addAndGet(Long.parseLong(next.size));
                    }
                }
            }
        }
    }

    private static class SlicePartStruct {
        public String eTag;
        public boolean isAlreadyUpload;
        public long offset;
        public int partNumber;
        public long sliceSize;

        private SlicePartStruct() {
        }
    }

    public static class UploadServiceResult extends CosXmlResult {
        public String eTag;

        public String printResult() {
            return super.printResult() + "\n" + "eTag:" + this.eTag + "\n" + "accessUrl:" + this.accessUrl;
        }
    }

    /* access modifiers changed from: package-private */
    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
