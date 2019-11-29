package com.tencent.cos.xml.model.object;

import android.util.Base64;
import com.appsflyer.share.Constants;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.tencent.cos.xml.common.COSACL;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.common.COSStorageClass;
import com.tencent.cos.xml.common.MetaDataDirective;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.ACLAccount;
import com.tencent.cos.xml.utils.DigestUtils;
import com.tencent.cos.xml.utils.URLEncodeUtils;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CopyObjectRequest extends ObjectRequest {
    private CopySourceStruct copySourceStruct;

    public String getMethod() {
        return "PUT";
    }

    public CopyObjectRequest(String str, String str2, CopySourceStruct copySourceStruct2) throws CosXmlClientException {
        super(str, str2);
        this.copySourceStruct = copySourceStruct2;
        setCopySource(copySourceStruct2);
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return RequestBodySerializer.bytes((String) null, new byte[0]);
    }

    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        CopySourceStruct copySourceStruct2 = this.copySourceStruct;
        if (copySourceStruct2 != null) {
            copySourceStruct2.checkParameters();
            return;
        }
        throw new CosXmlClientException("copy source must not be null");
    }

    public void setCosPath(String str) {
        this.cosPath = str;
    }

    public String getCosPath() {
        return this.cosPath;
    }

    public void setCopySource(CopySourceStruct copySourceStruct2) throws CosXmlClientException {
        this.copySourceStruct = copySourceStruct2;
        CopySourceStruct copySourceStruct3 = this.copySourceStruct;
        if (copySourceStruct3 != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE, copySourceStruct3.getSource());
        }
    }

    public String getCopySource() {
        return this.copySourceStruct.toString();
    }

    public void setCopyMetaDataDirective(MetaDataDirective metaDataDirective) {
        if (metaDataDirective != null) {
            addHeader(COSRequestHeaderKey.X_COS_METADATA_DIRECTIVE, metaDataDirective.getMetaDirective());
        }
    }

    public void setCopyIfModifiedSince(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_MODIFIED_SINCE, str);
        }
    }

    public void setCopyIfUnmodifiedSince(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_UNMODIFIED_SINCE, str);
        }
    }

    public void setCopyIfMatch(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_MATCH, str);
        }
    }

    public void setCopyIfNoneMatch(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_NONE_MATCH, str);
        }
    }

    public void setCopySourceServerSideEncryptionCustomerKey(String str) throws CosXmlClientException {
        if (str != null) {
            addHeader("x-cos-copy-source-server-side-encryption-customer-algorithm", "AES256");
            addHeader("x-cos-copy-source-server-side-encryption-customer-key", DigestUtils.getBase64(str));
            try {
                addHeader("x-cos-copy-source-server-side-encryption-customer-key-MD5", Base64.encodeToString(MessageDigest.getInstance(Hash.ALGORITHM_MD5).digest(str.getBytes(Charset.forName("UTF-8"))), 2));
            } catch (NoSuchAlgorithmException e2) {
                throw new CosXmlClientException((Throwable) e2);
            }
        }
    }

    public void setCopySourceServerSideEncryptionKMS(String str, String str2) throws CosXmlClientException {
        addHeader("'x-cos-copy-source-server-side-encryption", "cos/kms");
        if (str != null) {
            addHeader("x-cos-copy-source-server-side-encryption-cos-kms-key-id", str);
        }
        if (str2 != null) {
            addHeader("x-cos-copy-source-server-side-encryption-context", DigestUtils.getBase64(str2));
        }
    }

    public void setCosStorageClass(COSStorageClass cOSStorageClass) {
        if (cOSStorageClass != null) {
            addHeader(COSRequestHeaderKey.X_COS_STORAGE_CLASS_, cOSStorageClass.getStorageClass());
        }
    }

    public void setXCOSACL(COSACL cosacl) {
        if (cosacl != null) {
            addHeader(COSRequestHeaderKey.X_COS_ACL, cosacl.getAcl());
        }
    }

    public void setXCOSACL(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.X_COS_ACL, str);
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

    public void setXCOSMeta(String str, String str2) {
        if (str != null && str2 != null) {
            addHeader(str, str2);
        }
    }

    public static class CopySourceStruct {
        public String appid;
        public String bucket;
        public String cosPath;
        public String region;
        public String versionId;

        public CopySourceStruct(String str, String str2, String str3, String str4) {
            this.appid = str;
            this.bucket = str2;
            this.region = str3;
            this.cosPath = str4;
        }

        public CopySourceStruct(String str, String str2, String str3, String str4, String str5) {
            this(str, str2, str3, str4);
            this.versionId = str5;
        }

        public void checkParameters() throws CosXmlClientException {
            if (this.bucket != null) {
                String str = this.cosPath;
                if (str == null) {
                    throw new CosXmlClientException("copy source cosPath must not be null");
                } else if (this.appid == null) {
                    throw new CosXmlClientException("copy source appid must not be null");
                } else if (this.region != null) {
                    this.cosPath = URLEncodeUtils.cosPathEncode(str);
                } else {
                    throw new CosXmlClientException("copy source region must not be null");
                }
            } else {
                throw new CosXmlClientException("copy source bucket must not be null");
            }
        }

        public String getSource() throws CosXmlClientException {
            String str = this.cosPath;
            if (str != null && !str.startsWith(Constants.URL_PATH_DELIMITER)) {
                this.cosPath = Constants.URL_PATH_DELIMITER + this.cosPath;
            }
            this.cosPath = URLEncodeUtils.cosPathEncode(this.cosPath);
            StringBuilder sb = new StringBuilder();
            String str2 = this.bucket;
            if (str2.endsWith("-" + this.appid)) {
                sb.append(this.bucket);
                sb.append(".");
            } else {
                sb.append(this.bucket);
                sb.append("-");
                sb.append(this.appid);
                sb.append(".");
            }
            sb.append("cos");
            sb.append(".");
            sb.append(this.region);
            sb.append(".");
            sb.append("myqcloud.com");
            sb.append(this.cosPath);
            if (this.versionId != null) {
                sb.append("?versionId=");
                sb.append(this.versionId);
            }
            return sb.toString();
        }
    }
}
