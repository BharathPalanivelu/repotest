package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.ListMultipartUploads;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class ListMultiUploadsResult extends CosXmlResult {
    public ListMultipartUploads listMultipartUploads;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.listMultipartUploads = new ListMultipartUploads();
        try {
            XmlParser.parseListMultipartUploadsResult(httpResponse.byteStream(), this.listMultipartUploads);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(e2.getMessage(), e2);
        } catch (IOException e3) {
            throw new CosXmlClientException(e3.getMessage(), e3);
        }
    }

    public String printResult() {
        ListMultipartUploads listMultipartUploads2 = this.listMultipartUploads;
        if (listMultipartUploads2 != null) {
            return listMultipartUploads2.toString();
        }
        return super.printResult();
    }
}
