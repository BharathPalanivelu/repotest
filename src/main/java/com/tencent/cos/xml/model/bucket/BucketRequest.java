package com.tencent.cos.xml.model.bucket;

import com.appsflyer.share.Constants;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.CosXmlRequest;

public abstract class BucketRequest extends CosXmlRequest {
    protected String bucket;

    public String getPath() {
        return Constants.URL_PATH_DELIMITER;
    }

    public BucketRequest(String str) {
        this.bucket = str;
    }

    public String getHostPrefix() {
        return this.bucket;
    }

    public void checkParameters() throws CosXmlClientException {
        if (this.bucket == null) {
            throw new CosXmlClientException("bucket must not be null");
        }
    }
}
