package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.ListBucketVersions;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class ListBucketVersionsResult extends CosXmlResult {
    public ListBucketVersions listBucketVersions;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.listBucketVersions = new ListBucketVersions();
        try {
            XmlParser.parseListBucketVersions(httpResponse.byteStream(), this.listBucketVersions);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(e2.getMessage(), e2);
        } catch (IOException e3) {
            throw new CosXmlClientException(e3.getMessage(), e3);
        }
    }

    public String printResult() {
        ListBucketVersions listBucketVersions2 = this.listBucketVersions;
        if (listBucketVersions2 != null) {
            return listBucketVersions2.toString();
        }
        return super.printResult();
    }
}
