package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.AccessControlPolicy;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class GetObjectACLResult extends CosXmlResult {
    public AccessControlPolicy accessControlPolicy;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.accessControlPolicy = new AccessControlPolicy();
        try {
            XmlParser.parseAccessControlPolicy(httpResponse.byteStream(), this.accessControlPolicy);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public String printResult() {
        AccessControlPolicy accessControlPolicy2 = this.accessControlPolicy;
        return accessControlPolicy2 != null ? accessControlPolicy2.toString() : super.printResult();
    }
}
