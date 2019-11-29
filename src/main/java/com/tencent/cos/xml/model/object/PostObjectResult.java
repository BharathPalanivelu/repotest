package com.tencent.cos.xml.model.object;

import com.appsflyer.share.Constants;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.PostResponse;
import com.tencent.cos.xml.transfer.XmlSlimParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class PostObjectResult extends CosXmlResult {
    public String eTag;
    public String location;
    public PostResponse postResponse;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlClientException, CosXmlServiceException {
        super.parseResponseBody(httpResponse);
        this.eTag = httpResponse.header("ETag");
        this.location = httpResponse.header(Constants.HTTP_REDIRECT_URL_HEADER_FIELD);
        this.postResponse = new PostResponse();
        try {
            if (httpResponse.byteStream() != null) {
                XmlSlimParser.parsePostResponseResult(httpResponse.byteStream(), this.postResponse);
            }
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public String printResult() {
        return super.printResult();
    }
}
