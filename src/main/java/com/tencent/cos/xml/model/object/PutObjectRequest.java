package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.common.COSACL;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.model.tag.ACLAccount;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

public final class PutObjectRequest extends ObjectRequest {
    private byte[] data;
    private long fileLength;
    private InputStream inputStream;
    private CosXmlProgressListener progressListener;
    private String srcPath;
    private String strData;
    private URL url;

    public String getMethod() {
        return "PUT";
    }

    private PutObjectRequest(String str, String str2) {
        super(str, str2);
    }

    public PutObjectRequest(String str, String str2, String str3) {
        this(str, str2);
        this.srcPath = str3;
    }

    public PutObjectRequest(String str, String str2, byte[] bArr) {
        this(str, str2);
        this.data = bArr;
    }

    public PutObjectRequest(String str, String str2, StringBuilder sb) {
        this(str, str2);
        this.strData = sb.toString();
    }

    public PutObjectRequest(String str, String str2, InputStream inputStream2) throws CosXmlClientException {
        this(str, str2);
        this.inputStream = inputStream2;
    }

    public PutObjectRequest(String str, String str2, URL url2) {
        this(str, str2);
        this.url = url2;
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        String str = this.srcPath;
        if (str != null) {
            return RequestBodySerializer.file((String) null, new File(str));
        }
        byte[] bArr = this.data;
        if (bArr != null) {
            return RequestBodySerializer.bytes((String) null, bArr);
        }
        if (this.inputStream != null) {
            return RequestBodySerializer.stream((String) null, new File(CosXmlSimpleService.appCachePath, String.valueOf(System.currentTimeMillis())), this.inputStream);
        }
        String str2 = this.strData;
        if (str2 != null) {
            return RequestBodySerializer.bytes((String) null, str2.getBytes());
        }
        URL url2 = this.url;
        if (url2 != null) {
            return RequestBodySerializer.url((String) null, url2);
        }
        return null;
    }

    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.srcPath == null && this.data == null && this.inputStream == null && this.strData == null && this.url == null) {
            throw new CosXmlClientException("Data Source must not be null");
        }
        String str = this.srcPath;
        if (str != null && !new File(str).exists()) {
            throw new CosXmlClientException("upload file does not exist");
        }
    }

    public void setProgressListener(CosXmlProgressListener cosXmlProgressListener) {
        this.progressListener = cosXmlProgressListener;
    }

    public CosXmlProgressListener getProgressListener() {
        return this.progressListener;
    }

    public void setSrcPath(String str) {
        this.srcPath = str;
    }

    public String getSrcPath() {
        return this.srcPath;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setStrData(String str) {
        this.strData = str;
    }

    public String getStrData() {
        return this.strData;
    }

    public URL getUrl() {
        return this.url;
    }

    public void setUrl(URL url2) {
        this.url = url2;
    }

    public byte[] getData() {
        return this.data;
    }

    public long getFileLength() {
        String str = this.srcPath;
        if (str != null) {
            this.fileLength = new File(str).length();
        } else {
            byte[] bArr = this.data;
            if (bArr != null) {
                this.fileLength = (long) bArr.length;
            } else {
                String str2 = this.strData;
                if (str2 != null) {
                    this.fileLength = (long) str2.getBytes().length;
                }
            }
        }
        return this.fileLength;
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

    public void setContentEncodeing(String str) {
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
}
