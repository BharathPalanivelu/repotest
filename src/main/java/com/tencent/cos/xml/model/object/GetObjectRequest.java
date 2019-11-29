package com.tencent.cos.xml.model.object;

import com.appsflyer.share.Constants;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.common.Range;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.File;
import java.util.Map;

public final class GetObjectRequest extends ObjectRequest {
    private CosXmlProgressListener progressListener;
    private Range range;
    private String rspCacheControl;
    private String rspContentDisposition;
    private String rspContentEncoding;
    private String rspContentLanguage;
    private String rspContentType;
    private String rspExpires;
    private String saveFileName;
    private String savePath;
    private String versionId;

    public String getMethod() {
        return "GET";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public GetObjectRequest(String str, String str2, String str3) {
        super(str, str2);
        this.savePath = str3;
    }

    public GetObjectRequest(String str, String str2, String str3, String str4) {
        super(str, str2);
        this.savePath = str3;
        this.saveFileName = str4;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public void setRspContentType(String str) {
        this.rspContentType = str;
    }

    public String getRspContentType() {
        return this.rspContentType;
    }

    public void setRspContentLanguage(String str) {
        this.rspContentLanguage = str;
    }

    public String getRspContentLanguage() {
        return this.rspContentLanguage;
    }

    public void setRspExpires(String str) {
        this.rspExpires = str;
    }

    public String getRspExpires() {
        return this.rspExpires;
    }

    public void setRspCacheControl(String str) {
        this.rspCacheControl = str;
    }

    public String getRspCacheControl() {
        return this.rspCacheControl;
    }

    public void setRspContentDispositon(String str) {
        this.rspContentDisposition = str;
    }

    public String getRspContentDispositon() {
        return this.rspContentDisposition;
    }

    public void setRspContentEncoding(String str) {
        this.rspContentEncoding = str;
    }

    public String getRspContentEncoding() {
        return this.rspContentEncoding;
    }

    public void setRange(long j, long j2) {
        if (j < 0) {
            j = 0;
        }
        Range range2 = new Range(j, j2);
        addHeader("Range", range2.getRange());
        this.range = range2;
    }

    public void setRange(long j) {
        setRange(j, -1);
    }

    public Range getRange() {
        return this.range;
    }

    public void setIfModifiedSince(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.IF_MODIFIED_SINCE, str);
        }
    }

    public void setIfUnmodifiedSince(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.IF_UNMODIFIED_SINCE, str);
        }
    }

    public void setIfMatch(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.IF_MATCH, str);
        }
    }

    public void setIfNONEMatch(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.IF_NONE_MATCH, str);
        }
    }

    public void setProgressListener(CosXmlProgressListener cosXmlProgressListener) {
        this.progressListener = cosXmlProgressListener;
    }

    public CosXmlProgressListener getProgressListener() {
        return this.progressListener;
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public String getDownloadPath() {
        String str;
        String str2 = this.savePath;
        if (str2 == null) {
            return null;
        }
        if (!str2.endsWith(Constants.URL_PATH_DELIMITER)) {
            str = this.savePath + Constants.URL_PATH_DELIMITER;
        } else {
            str = this.savePath;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (this.saveFileName != null) {
            return str + this.saveFileName;
        } else if (this.cosPath == null) {
            return str;
        } else {
            int lastIndexOf = this.cosPath.lastIndexOf(Constants.URL_PATH_DELIMITER);
            if (lastIndexOf >= 0) {
                return str + this.cosPath.substring(lastIndexOf + 1);
            }
            return str + this.cosPath;
        }
    }

    public Map<String, String> getQueryString() {
        if (this.versionId != null) {
            this.queryParameters.put("versionId", this.versionId);
        }
        if (this.rspContentType != null) {
            this.queryParameters.put("response-content-type=", this.rspContentType);
        }
        if (this.rspContentLanguage != null) {
            this.queryParameters.put("response-content-language", this.rspContentLanguage);
        }
        if (this.rspExpires != null) {
            this.queryParameters.put("response-expires", this.rspExpires);
        }
        if (this.rspCacheControl != null) {
            this.queryParameters.put("response-cache-control", this.rspCacheControl);
        }
        if (this.rspContentDisposition != null) {
            this.queryParameters.put("response-content-disposition", this.rspContentDisposition);
        }
        if (this.rspContentEncoding != null) {
            this.queryParameters.put("response-content-encoding", this.rspContentEncoding);
        }
        return super.getQueryString();
    }
}
