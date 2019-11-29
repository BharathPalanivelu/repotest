package com.tencent.cos.xml.model.service;

import com.appsflyer.share.Constants;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.qcloud.core.http.RequestBodySerializer;

public final class GetServiceRequest extends CosXmlRequest {
    public void checkParameters() throws CosXmlClientException {
    }

    public String getHostPrefix() {
        return "service";
    }

    public String getMethod() {
        return "GET";
    }

    public String getPath() {
        return Constants.URL_PATH_DELIMITER;
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public String getHost(String str, String str2, boolean z) {
        return getHostPrefix() + ".cos." + "myqcloud.com";
    }
}
