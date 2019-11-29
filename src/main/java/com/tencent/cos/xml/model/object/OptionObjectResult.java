package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.qcloud.core.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public final class OptionObjectResult extends CosXmlResult {
    private List<String> accessControlAllowHeaders;
    private List<String> accessControlAllowMethods;
    private String accessControlAllowOrigin;
    private List<String> accessControlExposeHeaders;
    private long accessControlMaxAge;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.accessControlAllowOrigin = httpResponse.header("Access-Control-Allow-Origin");
        if (httpResponse.header("Access-Control-Max-Age") != null) {
            this.accessControlMaxAge = Long.parseLong(httpResponse.header("Access-Control-Max-Age"));
        }
        if (httpResponse.header("Access-Control-Allow-Methods") != null) {
            this.accessControlAllowMethods = Arrays.asList(httpResponse.header("Access-Control-Allow-Methods").split(","));
        }
        if (httpResponse.header("Access-Control-Allow-Headers") != null) {
            this.accessControlAllowHeaders = Arrays.asList(httpResponse.header("Access-Control-Allow-Headers").split(","));
        }
        if (httpResponse.header("Access-Control-Expose-Headers") != null) {
            this.accessControlExposeHeaders = Arrays.asList(httpResponse.header("Access-Control-Expose-Headers").split(","));
        }
    }

    public String printResult() {
        return super.printResult() + "\n" + this.accessControlAllowOrigin + "\n" + this.accessControlMaxAge + "\n";
    }
}
