package com.tencent.cos.xml.exception;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qcloud.core.common.QCloudServiceException;

public class CosXmlServiceException extends QCloudServiceException {
    private static final long serialVersionUID = 1;
    private String httpMsg;

    public CosXmlServiceException(String str) {
        super((String) null);
        this.httpMsg = str;
    }

    public CosXmlServiceException(String str, Exception exc) {
        super(str, exc);
    }

    public String getHttpMessage() {
        return this.httpMsg;
    }

    public String getMessage() {
        return getErrorMessage() + " (Service: " + getServiceName() + "; Status Code: " + getStatusCode() + "; Status Message: " + this.httpMsg + "; Error Code: " + getErrorCode() + "; Request ID: " + getRequestId() + SQLBuilder.PARENTHESES_RIGHT;
    }
}
