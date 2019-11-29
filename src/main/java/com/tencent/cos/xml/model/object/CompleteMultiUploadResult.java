package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.CompleteMultipartUploadResult;
import com.tencent.cos.xml.transfer.XmlSlimParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class CompleteMultiUploadResult extends CosXmlResult {
    public CompleteMultipartUploadResult completeMultipartUpload;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        try {
            this.completeMultipartUpload = new CompleteMultipartUploadResult();
            XmlSlimParser.parseCompleteMultipartUploadResult(httpResponse.byteStream(), this.completeMultipartUpload);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public String printResult() {
        CompleteMultipartUploadResult completeMultipartUploadResult = this.completeMultipartUpload;
        return completeMultipartUploadResult != null ? completeMultipartUploadResult.toString() : super.printResult();
    }
}
