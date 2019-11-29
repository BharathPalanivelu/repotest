package com.tencent.cos.xml.model.service;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.ListAllMyBuckets;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class GetServiceResult extends CosXmlResult {
    public ListAllMyBuckets listAllMyBuckets;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        try {
            this.listAllMyBuckets = new ListAllMyBuckets();
            XmlParser.parseListAllMyBucketsResult(httpResponse.byteStream(), this.listAllMyBuckets);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public String printResult() {
        ListAllMyBuckets listAllMyBuckets2 = this.listAllMyBuckets;
        return listAllMyBuckets2 != null ? listAllMyBuckets2.toString() : super.printResult();
    }
}
