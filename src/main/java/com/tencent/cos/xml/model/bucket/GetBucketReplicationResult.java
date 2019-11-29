package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.ReplicationConfiguration;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class GetBucketReplicationResult extends CosXmlResult {
    public ReplicationConfiguration replicationConfiguration;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.replicationConfiguration = new ReplicationConfiguration();
        try {
            XmlParser.parseReplicationConfiguration(httpResponse.byteStream(), this.replicationConfiguration);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public String printResult() {
        ReplicationConfiguration replicationConfiguration2 = this.replicationConfiguration;
        return replicationConfiguration2 != null ? replicationConfiguration2.toString() : super.printResult();
    }
}
