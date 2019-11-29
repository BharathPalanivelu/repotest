package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class ListPartsRequest extends ObjectRequest {
    private String encodingType;
    private String maxParts;
    private String partNumberMarker;
    private String uploadId;

    public String getMethod() {
        return "GET";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public ListPartsRequest(String str, String str2, String str3) {
        super(str, str2);
        this.uploadId = str3;
    }

    public Map<String, String> getQueryString() {
        if (this.uploadId != null) {
            this.queryParameters.put("uploadID", this.uploadId);
        }
        if (this.maxParts != null) {
            this.queryParameters.put("max-parts", this.maxParts);
        }
        if (this.partNumberMarker != null) {
            this.queryParameters.put("part-number-marker", this.maxParts);
        }
        if (this.encodingType != null) {
            this.queryParameters.put("Encoding-type", this.encodingType);
        }
        return this.queryParameters;
    }

    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.uploadId == null) {
            throw new CosXmlClientException("uploadID must not be null");
        }
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setMaxParts(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.maxParts = String.valueOf(i);
    }

    public int getMaxParts() {
        return Integer.parseInt(this.maxParts);
    }

    public void setPartNumberMarker(int i) {
        this.partNumberMarker = String.valueOf(i);
    }

    public int getPartNumberMarker() {
        return Integer.parseInt(this.partNumberMarker);
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public String getEncodingType() {
        return this.encodingType;
    }
}
