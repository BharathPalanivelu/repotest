package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.CosXmlService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.CopyObjectRequest;
import com.tencent.cos.xml.model.object.CopyObjectResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.UploadPartCopyRequest;
import com.tencent.cos.xml.model.object.UploadPartCopyResult;
import com.tencent.cos.xml.transfer.UploadService;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CopyObjectService {
    private CosXmlService cosXmlService;
    private UploadService.EncryptionType encryptionType = UploadService.EncryptionType.NONE;
    private long maxSliceSize = 5242880;
    private String sourceCustomerKey;
    private String sourceCustomerKeyId;
    private String sourceJsonContent;

    public static class CopyServerResult extends CosXmlResult {
        public String eTag;
    }

    public CopyObjectService(CosXmlService cosXmlService2) {
        this.cosXmlService = cosXmlService2;
    }

    public void setCopySourceCustomerKey(String str) {
        this.encryptionType = UploadService.EncryptionType.SSEC;
        this.sourceCustomerKey = str;
    }

    public void setCopySourceCustomerKeyIdAndJsonContent(String str, String str2) {
        this.sourceCustomerKeyId = str;
        this.sourceJsonContent = str2;
        this.encryptionType = UploadService.EncryptionType.SSEKMS;
    }

    /* renamed from: com.tencent.cos.xml.transfer.CopyObjectService$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType = new int[UploadService.EncryptionType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
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
                com.tencent.cos.xml.transfer.UploadService$EncryptionType r1 = com.tencent.cos.xml.transfer.UploadService.EncryptionType.SSEC     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.tencent.cos.xml.transfer.UploadService$EncryptionType r1 = com.tencent.cos.xml.transfer.UploadService.EncryptionType.SSEKMS     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.transfer.CopyObjectService.AnonymousClass1.<clinit>():void");
        }
    }

    private void setCopySourceEncryptionRequest(CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        if (cosXmlRequest != null) {
            int i = AnonymousClass1.$SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType[this.encryptionType.ordinal()];
            if (i == 1) {
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    if (cosXmlRequest instanceof HeadObjectRequest) {
                        ((HeadObjectRequest) cosXmlRequest).setCOSServerSideEncryptionWithKMS(this.sourceCustomerKeyId, this.sourceJsonContent);
                    } else if (cosXmlRequest instanceof CopyObjectRequest) {
                        ((CopyObjectRequest) cosXmlRequest).setCopySourceServerSideEncryptionKMS(this.sourceCustomerKeyId, this.sourceJsonContent);
                    }
                }
            } else if (cosXmlRequest instanceof HeadObjectRequest) {
                ((HeadObjectRequest) cosXmlRequest).setCOSServerSideEncryptionWithCustomerKey(this.sourceCustomerKey);
            } else if (cosXmlRequest instanceof CopyObjectRequest) {
                ((CopyObjectRequest) cosXmlRequest).setCopySourceServerSideEncryptionCustomerKey(this.sourceCustomerKey);
            }
        }
    }

    public CosXmlResult copyObject(String str, String str2, CopyObjectRequest.CopySourceStruct copySourceStruct) throws CosXmlClientException, CosXmlServiceException {
        CopyServerResult copyServerResult = new CopyServerResult();
        long headObject = headObject(copySourceStruct.bucket, copySourceStruct.cosPath);
        if (headObject >= this.maxSliceSize) {
            CompleteMultiUploadResult copyObjectForLargeFile = copyObjectForLargeFile(str, str2, copySourceStruct, headObject);
            copyServerResult.headers = copyObjectForLargeFile.headers;
            copyServerResult.httpCode = copyObjectForLargeFile.httpCode;
            copyServerResult.httpMessage = copyObjectForLargeFile.httpMessage;
            copyServerResult.accessUrl = copyObjectForLargeFile.accessUrl;
            copyServerResult.eTag = copyObjectForLargeFile.completeMultipartUpload.eTag;
        } else {
            CopyObjectResult copyObjectForSmallFile = copyObjectForSmallFile(str, str2, copySourceStruct);
            copyServerResult.headers = copyObjectForSmallFile.headers;
            copyServerResult.httpCode = copyObjectForSmallFile.httpCode;
            copyServerResult.httpMessage = copyObjectForSmallFile.httpMessage;
            copyServerResult.accessUrl = copyObjectForSmallFile.accessUrl;
            copyServerResult.eTag = copyObjectForSmallFile.copyObject.eTag;
        }
        return copyServerResult;
    }

    public CosXmlResult copyObject(String str, String str2, CopyObjectRequest.CopySourceStruct copySourceStruct, long j) throws CosXmlClientException, CosXmlServiceException {
        if (j >= this.maxSliceSize) {
            return copyObjectForLargeFile(str, str2, copySourceStruct, j);
        }
        return copyObjectForSmallFile(str, str2, copySourceStruct);
    }

    private long headObject(String str, String str2) throws CosXmlServiceException, CosXmlClientException {
        HeadObjectRequest headObjectRequest = new HeadObjectRequest(str, str2);
        setCopySourceEncryptionRequest(headObjectRequest);
        HeadObjectResult headObject = this.cosXmlService.headObject(headObjectRequest);
        if (headObject != null) {
            return Long.valueOf((String) ((List) headObject.headers.get(HttpConstants.Header.CONTENT_LENGTH)).get(0)).longValue();
        }
        return -1;
    }

    private CopyObjectResult copyObjectForSmallFile(String str, String str2, CopyObjectRequest.CopySourceStruct copySourceStruct) throws CosXmlServiceException, CosXmlClientException {
        CopyObjectRequest copyObjectRequest = new CopyObjectRequest(str, str2, copySourceStruct);
        setCopySourceEncryptionRequest(copyObjectRequest);
        return this.cosXmlService.copyObject(copyObjectRequest);
    }

    private CompleteMultiUploadResult copyObjectForLargeFile(String str, String str2, CopyObjectRequest.CopySourceStruct copySourceStruct, long j) throws CosXmlClientException, CosXmlServiceException {
        String initMultiUpload = initMultiUpload(str, str2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j2 = this.maxSliceSize;
        long j3 = -1;
        int i = 1;
        while (true) {
            long j4 = j - 1;
            if (j3 >= j4) {
                return completeMultipart(str, str2, initMultiUpload, linkedHashMap);
            }
            String str3 = str;
            String str4 = str2;
            long j5 = j3 + 1;
            long j6 = j3 + j2;
            long j7 = j6 >= j4 ? j4 : j6;
            linkedHashMap.put(Integer.valueOf(i), copyObjectForLargeFile(str, str2, i, initMultiUpload, copySourceStruct, j5, j7).copyObject.eTag);
            i++;
            j3 = j7;
        }
    }

    private String initMultiUpload(String str, String str2) throws CosXmlServiceException, CosXmlClientException {
        return this.cosXmlService.initMultipartUpload(new InitMultipartUploadRequest(str, str2)).initMultipartUpload.uploadId;
    }

    private UploadPartCopyResult copyObjectForLargeFile(String str, String str2, int i, String str3, CopyObjectRequest.CopySourceStruct copySourceStruct, long j, long j2) throws CosXmlServiceException, CosXmlClientException {
        UploadPartCopyRequest uploadPartCopyRequest = new UploadPartCopyRequest(str, str2, i, str3, copySourceStruct, j, j2);
        setCopySourceEncryptionRequest(uploadPartCopyRequest);
        return this.cosXmlService.copyObject(uploadPartCopyRequest);
    }

    private CompleteMultiUploadResult completeMultipart(String str, String str2, String str3, Map<Integer, String> map) throws CosXmlServiceException, CosXmlClientException {
        return this.cosXmlService.completeMultiUpload(new CompleteMultiUploadRequest(str, str2, str3, map));
    }
}
