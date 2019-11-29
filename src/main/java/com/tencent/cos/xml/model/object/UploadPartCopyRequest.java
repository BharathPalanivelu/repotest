package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.object.CopyObjectRequest;
import java.util.Map;

public class UploadPartCopyRequest extends CopyObjectRequest {
    private int partNumber;
    private String uploadId;

    public UploadPartCopyRequest(String str, String str2, int i, String str3, CopyObjectRequest.CopySourceStruct copySourceStruct) throws CosXmlClientException {
        this(str, str2, i, str3, copySourceStruct, -1, -1);
    }

    public UploadPartCopyRequest(String str, String str2, int i, String str3, CopyObjectRequest.CopySourceStruct copySourceStruct, long j, long j2) throws CosXmlClientException {
        super(str, str2, copySourceStruct);
        this.partNumber = -1;
        this.uploadId = null;
        this.partNumber = i;
        this.uploadId = str3;
        setCopyRange(j, j2);
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("partNumber", String.valueOf(this.partNumber));
        this.queryParameters.put("uploadId", this.uploadId);
        return super.getQueryString();
    }

    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.partNumber <= 0) {
            throw new CosXmlClientException("partNumber must be >= 1");
        } else if (this.uploadId == null) {
            throw new CosXmlClientException("uploadID must not be null");
        }
    }

    public void setCopyRange(long j, long j2) {
        if (j >= 0 && j2 >= j) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_RANGE, "bytes=" + j + "-" + j2);
        }
    }
}
