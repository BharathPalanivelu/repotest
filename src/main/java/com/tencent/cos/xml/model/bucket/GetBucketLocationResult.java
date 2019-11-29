package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.LocationConstraint;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class GetBucketLocationResult extends CosXmlResult {
    public LocationConstraint locationConstraint;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.locationConstraint = new LocationConstraint();
        try {
            XmlParser.parseLocationConstraint(httpResponse.byteStream(), this.locationConstraint);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public String printResult() {
        LocationConstraint locationConstraint2 = this.locationConstraint;
        return locationConstraint2 != null ? locationConstraint2.toString() : super.printResult();
    }
}
