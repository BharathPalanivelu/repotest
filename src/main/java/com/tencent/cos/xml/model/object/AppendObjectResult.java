package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.qcloud.core.http.HttpResponse;

public final class AppendObjectResult extends CosXmlResult {
    private String contentSHA1;
    private String nextAppendPosition;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.contentSHA1 = httpResponse.header("x-cos-content-sha1");
        this.nextAppendPosition = httpResponse.header("x-cos-next-append-position");
    }

    public String printResult() {
        return super.printResult() + "\n" + this.contentSHA1 + "\n" + this.nextAppendPosition + "\n";
    }
}
