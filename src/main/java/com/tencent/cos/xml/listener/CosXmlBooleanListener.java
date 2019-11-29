package com.tencent.cos.xml.listener;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;

public interface CosXmlBooleanListener {
    void onFail(CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException);

    void onSuccess(boolean z);
}
