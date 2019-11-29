package com.tencent.cos.xml.model.object;

import android.util.Base64;
import com.appsflyer.share.Constants;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.utils.DigestUtils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class ObjectRequest extends CosXmlRequest {
    protected String bucket;
    protected String cosPath;

    public ObjectRequest(String str, String str2) {
        this.bucket = str;
        this.cosPath = str2;
    }

    public String getHostPrefix() {
        return this.bucket;
    }

    public String getPath() {
        String str = this.cosPath;
        if (str == null || str.startsWith(Constants.URL_PATH_DELIMITER)) {
            return this.cosPath;
        }
        return Constants.URL_PATH_DELIMITER + this.cosPath;
    }

    public void checkParameters() throws CosXmlClientException {
        if (this.bucket == null) {
            throw new CosXmlClientException("bucket must not be null ");
        } else if (this.cosPath == null) {
            throw new CosXmlClientException("cosPath must not be null ");
        }
    }

    public void setCOSServerSideEncryption() {
        addHeader("x-cos-server-side-encryption", "AES256");
    }

    public void setCOSServerSideEncryptionWithCustomerKey(String str) throws CosXmlClientException {
        if (str != null) {
            addHeader("x-cos-server-side-encryption-customer-algorithm", "AES256");
            addHeader("x-cos-server-side-encryption-customer-key", DigestUtils.getBase64(str));
            try {
                addHeader("x-cos-server-side-encryption-customer-key-MD5", Base64.encodeToString(MessageDigest.getInstance(Hash.ALGORITHM_MD5).digest(str.getBytes(Charset.forName("UTF-8"))), 2));
            } catch (NoSuchAlgorithmException e2) {
                throw new CosXmlClientException((Throwable) e2);
            }
        }
    }

    public void setCOSServerSideEncryptionWithKMS(String str, String str2) throws CosXmlClientException {
        addHeader("x-cos-server-side-encryption", "cos/kms");
        if (str != null) {
            addHeader("x-cos-server-side-encryption-cos-kms-key-id", str);
        }
        if (str2 != null) {
            addHeader("x-cos-server-side-encryption-context", DigestUtils.getBase64(str2));
        }
    }
}
