package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.CompleteMultipartUpload;
import com.tencent.cos.xml.transfer.XmlSlimBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class CompleteMultiUploadRequest extends ObjectRequest {
    private CompleteMultipartUpload completeMultipartUpload = new CompleteMultipartUpload();
    private String uploadId;

    public String getMethod() {
        return "POST";
    }

    public CompleteMultiUploadRequest(String str, String str2, String str3, Map<Integer, String> map) {
        super(str, str2);
        this.uploadId = str3;
        this.completeMultipartUpload.parts = new ArrayList();
        setPartNumberAndETag(map);
    }

    public CompleteMultipartUpload getCompleteMultipartUpload() {
        return this.completeMultipartUpload;
    }

    public void setPartNumberAndETag(int i, String str) {
        CompleteMultipartUpload.Part part = new CompleteMultipartUpload.Part();
        part.partNumber = i;
        part.eTag = str;
        this.completeMultipartUpload.parts.add(part);
    }

    public void setPartNumberAndETag(Map<Integer, String> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                CompleteMultipartUpload.Part part = new CompleteMultipartUpload.Part();
                part.partNumber = ((Integer) next.getKey()).intValue();
                part.eTag = (String) next.getValue();
                this.completeMultipartUpload.parts.add(part);
            }
        }
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("uploadID", this.uploadId);
        return this.queryParameters;
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlSlimBuilder.buildCompleteMultipartUpload(this.completeMultipartUpload));
        } catch (IOException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (XmlPullParserException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.uploadId == null) {
            throw new CosXmlClientException("uploadID must not be null");
        }
    }
}
