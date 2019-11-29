package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class UploadPartRequest extends ObjectRequest {
    private byte[] data;
    private long fileContentLength;
    private long fileOffset;
    private InputStream inputStream;
    private int partNumber;
    private CosXmlProgressListener progressListener;
    private String srcPath;
    private String uploadId;

    public String getMethod() {
        return "PUT";
    }

    private UploadPartRequest(String str, String str2) {
        super(str, str2);
        this.fileOffset = -1;
        this.fileContentLength = -1;
    }

    public UploadPartRequest(String str, String str2, int i, String str3, String str4) {
        this(str, str2);
        this.partNumber = i;
        this.srcPath = str3;
        this.uploadId = str4;
        this.fileOffset = -1;
        this.fileContentLength = -1;
    }

    public UploadPartRequest(String str, String str2, int i, String str3, long j, long j2, String str4) {
        this(str, str2);
        this.partNumber = i;
        setSrcPath(str3, j, j2);
        this.uploadId = str4;
    }

    public UploadPartRequest(String str, String str2, int i, byte[] bArr, String str3) {
        this(str, str2);
        this.partNumber = i;
        this.data = bArr;
        this.uploadId = str3;
        this.fileOffset = -1;
        this.fileContentLength = -1;
    }

    public UploadPartRequest(String str, String str2, int i, InputStream inputStream2, String str3) throws CosXmlClientException {
        this(str, str2);
        this.partNumber = i;
        this.inputStream = inputStream2;
        this.uploadId = str3;
        this.fileOffset = -1;
        this.fileContentLength = -1;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("partNumber", String.valueOf(this.partNumber));
        this.queryParameters.put("uploadID", this.uploadId);
        return super.getQueryString();
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        String str = this.srcPath;
        if (str == null) {
            byte[] bArr = this.data;
            if (bArr != null) {
                return RequestBodySerializer.bytes((String) null, bArr);
            }
            if (this.inputStream != null) {
                return RequestBodySerializer.stream((String) null, new File(CosXmlSimpleService.appCachePath), this.inputStream);
            }
            return null;
        } else if (this.fileOffset != -1) {
            return RequestBodySerializer.file((String) null, new File(str), this.fileOffset, this.fileContentLength);
        } else {
            return RequestBodySerializer.file((String) null, new File(str));
        }
    }

    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.partNumber <= 0) {
            throw new CosXmlClientException("partNumber must be >= 1");
        } else if (this.uploadId == null) {
            throw new CosXmlClientException("uploadID must not be null");
        } else if (this.srcPath == null && this.data == null && this.inputStream == null) {
            throw new CosXmlClientException("Data Source must not be null");
        } else {
            String str = this.srcPath;
            if (str != null && !new File(str).exists()) {
                throw new CosXmlClientException("upload file does not exist");
            }
        }
    }

    public void setSrcPath(String str) {
        this.srcPath = str;
    }

    public void setSrcPath(String str, long j, long j2) {
        this.srcPath = str;
        this.fileOffset = j;
        this.fileContentLength = j2;
    }

    public String getSrcPath() {
        return this.srcPath;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public long getFileLength() {
        byte[] bArr = this.data;
        if (bArr != null) {
            this.fileContentLength = (long) bArr.length;
        } else {
            String str = this.srcPath;
            if (str != null && this.fileContentLength == -1) {
                this.fileContentLength = new File(str).length();
            }
        }
        return this.fileContentLength;
    }

    public void setProgressListener(CosXmlProgressListener cosXmlProgressListener) {
        this.progressListener = cosXmlProgressListener;
    }

    public CosXmlProgressListener getProgressListener() {
        return this.progressListener;
    }
}
