package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSACL;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.model.tag.ACLAccount;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class InitMultipartUploadRequest extends ObjectRequest {
    public String getMethod() {
        return "POST";
    }

    public InitMultipartUploadRequest(String str, String str2) {
        super(str, str2);
    }

    public void setCacheControl(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.CACHE_CONTROL, str);
        }
    }

    public void setContentDisposition(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.CONTENT_DISPOSITION, str);
        }
    }

    public void setContentEncoding(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.CONTENT_ENCODING, str);
        }
    }

    public void setExpires(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.EXPIRES, str);
        }
    }

    public void setXCOSMeta(String str, String str2) {
        if (str != null && str2 != null) {
            addHeader(str, str2);
        }
    }

    public void setXCOSACL(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.X_COS_ACL, str);
        }
    }

    public void setXCOSACL(COSACL cosacl) {
        if (cosacl != null) {
            addHeader(COSRequestHeaderKey.X_COS_ACL, cosacl.getAcl());
        }
    }

    public void setXCOSGrantRead(ACLAccount aCLAccount) {
        if (aCLAccount != null) {
            addHeader(COSRequestHeaderKey.X_COS_GRANT_READ, aCLAccount.getAccount());
        }
    }

    public void setXCOSGrantWrite(ACLAccount aCLAccount) {
        if (aCLAccount != null) {
            addHeader(COSRequestHeaderKey.X_COS_GRANT_WRITE, aCLAccount.getAccount());
        }
    }

    public void setXCOSReadWrite(ACLAccount aCLAccount) {
        if (aCLAccount != null) {
            addHeader(COSRequestHeaderKey.X_COS_GRANT_FULL_CONTROL, aCLAccount.getAccount());
        }
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("uploads", (Object) null);
        return this.queryParameters;
    }

    public RequestBodySerializer getRequestBody() {
        return RequestBodySerializer.bytes((String) null, new byte[0]);
    }
}
