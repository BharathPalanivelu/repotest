package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.DeleteResult;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class DeleteMultiObjectResult extends CosXmlResult {
    public DeleteResult deleteResult;

    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.deleteResult = new DeleteResult();
        try {
            XmlParser.parseDeleteResult(httpResponse.byteStream(), this.deleteResult);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public String printResult() {
        DeleteResult deleteResult2 = this.deleteResult;
        return deleteResult2 != null ? deleteResult2.toString() : super.printResult();
    }
}
