package com.tencent.cos.xml.exception;

import com.tencent.qcloud.core.common.QCloudClientException;

public class CosXmlClientException extends QCloudClientException {
    private static final long serialVersionUID = 1;

    public CosXmlClientException(String str) {
        super(str);
    }

    public CosXmlClientException(String str, Throwable th) {
        super(str, th);
    }

    public CosXmlClientException(Throwable th) {
        super(th);
    }
}
