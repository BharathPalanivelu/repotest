package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.ListBucket;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class GetBucketResult extends CosXmlResult {
    public ListBucket listBucket;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.listBucket = new ListBucket();
        try {
            XmlParser.parseListBucketResult(httpResponse.byteStream(), this.listBucket);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public String printResult() {
        ListBucket listBucket2 = this.listBucket;
        return listBucket2 != null ? listBucket2.toString() : super.printResult();
    }
}
