package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.CORSConfiguration;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class GetBucketCORSResult extends CosXmlResult {
    public CORSConfiguration corsConfiguration;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.corsConfiguration = new CORSConfiguration();
        try {
            XmlParser.parseCORSConfiguration(httpResponse.byteStream(), this.corsConfiguration);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public String printResult() {
        CORSConfiguration cORSConfiguration = this.corsConfiguration;
        return cORSConfiguration != null ? cORSConfiguration.toString() : super.printResult();
    }
}
