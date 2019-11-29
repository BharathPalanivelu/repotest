package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.VersioningConfiguration;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class GetBucketVersioningResult extends CosXmlResult {
    public VersioningConfiguration versioningConfiguration;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.versioningConfiguration = new VersioningConfiguration();
        try {
            XmlParser.parseVersioningConfiguration(httpResponse.byteStream(), this.versioningConfiguration);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public String printResult() {
        VersioningConfiguration versioningConfiguration2 = this.versioningConfiguration;
        return versioningConfiguration2 != null ? versioningConfiguration2.toString() : super.printResult();
    }
}
