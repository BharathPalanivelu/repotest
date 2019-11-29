package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.object.GetObjectBytesResult;
import com.tencent.cos.xml.model.tag.CosError;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpResponse;
import com.tencent.qcloud.core.http.ResponseBodyConverter;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

public class ResponseBytesConverter<T> extends ResponseBodyConverter<T> {
    private GetObjectBytesResult getObjectBytesResult;

    public ResponseBytesConverter(GetObjectBytesResult getObjectBytesResult2) {
        this.getObjectBytesResult = getObjectBytesResult2;
    }

    /* access modifiers changed from: protected */
    public T convert(HttpResponse<T> httpResponse) throws QCloudClientException, QCloudServiceException {
        parseCOSXMLError(httpResponse);
        this.getObjectBytesResult.parseResponseBody(httpResponse);
        return this.getObjectBytesResult;
    }

    private void parseCOSXMLError(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        int code = httpResponse.code();
        if (code < 200 || code >= 300) {
            CosXmlServiceException cosXmlServiceException = new CosXmlServiceException(httpResponse.message());
            cosXmlServiceException.setStatusCode(code);
            cosXmlServiceException.setRequestId(httpResponse.header("x-cos-request-id"));
            InputStream byteStream = httpResponse.byteStream();
            if (byteStream != null) {
                CosError cosError = new CosError();
                try {
                    XmlSlimParser.parseError(byteStream, cosError);
                    cosXmlServiceException.setErrorCode(cosError.code);
                    cosXmlServiceException.setErrorMessage(cosError.message);
                    cosXmlServiceException.setRequestId(cosError.requestId);
                    cosXmlServiceException.setServiceName(cosError.resource);
                } catch (XmlPullParserException e2) {
                    throw new CosXmlClientException((Throwable) e2);
                } catch (IOException e3) {
                    throw new CosXmlClientException((Throwable) e3);
                }
            }
            throw cosXmlServiceException;
        }
    }
}
