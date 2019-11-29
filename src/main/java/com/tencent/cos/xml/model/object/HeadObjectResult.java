package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.qcloud.core.http.HttpResponse;

public final class HeadObjectResult extends CosXmlResult {
    public String cosObjectType;
    public String cosStorageClass;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.cosObjectType = httpResponse.header("x-cos-object-type");
        this.cosStorageClass = httpResponse.header(COSRequestHeaderKey.X_COS_STORAGE_CLASS_);
    }
}
