package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.LifecycleConfiguration;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class GetBucketLifecycleResult extends CosXmlResult {
    public LifecycleConfiguration lifecycleConfiguration;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.lifecycleConfiguration = new LifecycleConfiguration();
        try {
            XmlParser.parseLifecycleConfiguration(httpResponse.byteStream(), this.lifecycleConfiguration);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public String printResult() {
        LifecycleConfiguration lifecycleConfiguration2 = this.lifecycleConfiguration;
        return lifecycleConfiguration2 != null ? lifecycleConfiguration2.toString() : super.printResult();
    }
}
