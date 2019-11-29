package com.tencent.cos.xml.model.object;

import com.appsflyer.share.Constants;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.transfer.ExRequestBodySerializer;
import com.tencent.cos.xml.utils.DateUtils;
import com.tencent.cos.xml.utils.DigestUtils;
import com.tencent.cos.xml.utils.GenerateGetObjectURLUtils;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PostObjectRequest extends ObjectRequest {
    private long contentLength;
    private FormStruct formStruct;
    private long offset;
    private CosXmlProgressListener progressListener;

    public String getMethod() {
        return "POST";
    }

    private PostObjectRequest(String str, String str2) {
        super(str, Constants.URL_PATH_DELIMITER);
        this.formStruct = new FormStruct();
        this.offset = -1;
        this.contentLength = -1;
        this.formStruct.key = str2;
    }

    public PostObjectRequest(String str, String str2, String str3) {
        this(str, str2);
        this.formStruct.srcPath = str3;
    }

    public PostObjectRequest(String str, String str2, byte[] bArr) {
        this(str, str2);
        this.formStruct.data = bArr;
    }

    public PostObjectRequest(String str, String str2, InputStream inputStream) {
        this(str, str2);
        this.formStruct.inputStream = inputStream;
    }

    public void setRange(long j, long j2) {
        this.offset = j;
        this.contentLength = j2;
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        if (this.formStruct.srcPath != null) {
            return ExRequestBodySerializer.multipart(this.formStruct.getFormParameters(), new File(this.formStruct.srcPath), this.offset, this.contentLength);
        }
        if (this.formStruct.data != null) {
            return ExRequestBodySerializer.multipart(this.formStruct.getFormParameters(), (String) null, this.formStruct.data, this.offset, this.contentLength);
        }
        if (this.formStruct.inputStream == null) {
            return null;
        }
        try {
            File file = new File(CosXmlSimpleService.appCachePath, String.valueOf(System.currentTimeMillis()));
            if (!file.exists()) {
                file.createNewFile();
            }
            return ExRequestBodySerializer.multipart(this.formStruct.getFormParameters(), file, this.formStruct.inputStream, this.offset, this.contentLength);
        } catch (IOException e2) {
            throw new CosXmlClientException((Throwable) e2);
        }
    }

    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.formStruct.key != null) {
            this.formStruct.signature.checkParameters();
            return;
        }
        throw new CosXmlClientException("cosPath must not be null ");
    }

    public void setProgressListener(CosXmlProgressListener cosXmlProgressListener) {
        this.progressListener = cosXmlProgressListener;
    }

    public CosXmlProgressListener getProgressListener() {
        return this.progressListener;
    }

    public void setSecretIdAndKey(String str, String str2, String str3) {
        this.formStruct.signature.secretId = str;
        this.formStruct.signature.signKey = str2;
        this.formStruct.signature.keyTime = str3;
    }

    public void setSign(long j) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        setSign(currentTimeMillis, j + currentTimeMillis);
    }

    public void setSign(long j, long j2) {
        Signature signature = this.formStruct.signature;
        signature.signTime = j + ";" + j2;
    }

    public void setSign(long j, Map<String, String> map, Map<String, String> map2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        setSign(currentTimeMillis, currentTimeMillis + j, map, map2);
    }

    public void setSign(long j, long j2, Map<String, String> map, Map<String, String> map2) {
        Signature signature = this.formStruct.signature;
        signature.signTime = j + ";" + j2;
        this.formStruct.signature.parameters = map;
        this.formStruct.signature.headers = map2;
    }

    public void setSign(long j, Set<String> set, Set<String> set2) {
        throw new IllegalArgumentException("need to invoke setSign(long, Map<String, String>,  Map<String, String>) or setSign(long)");
    }

    public void setSign(long j, long j2, Set<String> set, Set<String> set2) {
        throw new IllegalArgumentException("need to invoke setSign(long, long, Map<String, String>,  Map<String, String>)or setSign(long, long)");
    }

    public void setAcl(String str) {
        this.formStruct.acl = str;
    }

    public void setCacheControl(String str) {
        this.formStruct.headers.put(COSRequestHeaderKey.CACHE_CONTROL, str);
    }

    public void setContentType(String str) {
        this.formStruct.headers.put(HttpConstants.Header.CONTENT_TYPE, str);
    }

    public void setContentDisposition(String str) {
        this.formStruct.headers.put(COSRequestHeaderKey.CONTENT_DISPOSITION, str);
    }

    public void setContentEncoding(String str) {
        this.formStruct.headers.put(COSRequestHeaderKey.CONTENT_ENCODING, str);
    }

    public void setExpires(String str) {
        this.formStruct.headers.put(COSRequestHeaderKey.EXPIRES, str);
    }

    public void setHeader(String str, String str2) {
        if (str != null && str2 != null) {
            this.formStruct.headers.put(str, str2);
        }
    }

    public void setCustomerHeader(String str, String str2) {
        if (str != null && str2 != null) {
            this.formStruct.customHeaders.put(str, str2);
        }
    }

    public void setCosStorageClass(String str) {
        this.formStruct.xCosStorageClass = str;
    }

    public void setSuccessActionRedirect(String str) {
        this.formStruct.successActionRedirect = str;
    }

    public void setSuccessActionStatus(int i) {
        this.formStruct.successActionStatus = String.valueOf(i);
    }

    public void setPolicy(Policy policy) {
        this.formStruct.policy = policy;
    }

    private class FormStruct {
        String acl;
        Map<String, String> customHeaders = new LinkedHashMap();
        byte[] data;
        Map<String, String> headers = new LinkedHashMap();
        InputStream inputStream;
        String key;
        Policy policy;
        Signature signature;
        String srcPath;
        String successActionRedirect;
        String successActionStatus;
        String xCosStorageClass;

        public FormStruct() {
            this.signature = new Signature();
        }

        public Map<String, String> getFormParameters() throws CosXmlClientException {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str = this.acl;
            if (str != null) {
                linkedHashMap.put("Acl", str);
            }
            for (Map.Entry next : this.headers.entrySet()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
            linkedHashMap.put("key", this.key);
            String str2 = this.successActionRedirect;
            if (str2 != null) {
                linkedHashMap.put("success_action_redirect", str2);
            }
            String str3 = this.successActionStatus;
            if (str3 != null) {
                linkedHashMap.put("success_action_status", str3);
            }
            for (Map.Entry next2 : this.customHeaders.entrySet()) {
                linkedHashMap.put(next2.getKey(), next2.getValue());
            }
            String str4 = this.xCosStorageClass;
            if (str4 != null) {
                linkedHashMap.put(COSRequestHeaderKey.X_COS_STORAGE_CLASS_, str4);
            }
            linkedHashMap.put("Signature", this.signature.getSign());
            Policy policy2 = this.policy;
            if (policy2 != null) {
                linkedHashMap.put("policy", DigestUtils.getBase64(policy2.content()));
            }
            return linkedHashMap;
        }
    }

    public Map<String, String> testFormParameters() throws CosXmlClientException {
        return this.formStruct.getFormParameters();
    }

    private class Signature {
        public Map<String, String> headers;
        public String keyTime;
        public Map<String, String> parameters;
        public String secretId;
        public String signKey;
        public String signTime;

        public Signature() {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.signTime = currentTimeMillis + ";" + (currentTimeMillis + 600);
        }

        public void checkParameters() throws CosXmlClientException {
            if (this.secretId == null || this.signKey == null) {
                throw new CosXmlClientException("secretId or secretKey must not be null");
            }
        }

        public String getSign() throws CosXmlClientException {
            return GenerateGetObjectURLUtils.getSign("POST", Constants.URL_PATH_DELIMITER, this.headers, this.parameters, this.signTime, this.keyTime, this.secretId, this.signKey);
        }
    }

    public static class Policy {
        private JSONArray conditions = new JSONArray();
        private String expiration;

        public void setExpiration(long j) {
            this.expiration = DateUtils.getFormatTime("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", j);
        }

        public void setExpiration(String str) {
            this.expiration = str;
        }

        public void addConditions(String str, String str2, boolean z) throws CosXmlClientException {
            if (z) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put("starts-with");
                jSONArray.put(str);
                jSONArray.put(str2);
                this.conditions.put(jSONArray);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str, str2);
                this.conditions.put(jSONObject);
            } catch (JSONException e2) {
                throw new CosXmlClientException((Throwable) e2);
            }
        }

        public void addContentConditions(int i, int i2) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("content-length-range");
            jSONArray.put(i);
            jSONArray.put(i2);
            this.conditions.put(jSONArray);
        }

        public String content() throws CosXmlClientException {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.expiration != null) {
                    jSONObject.put("expiration", this.expiration);
                }
                jSONObject.put("conditions", this.conditions);
                return jSONObject.toString();
            } catch (JSONException e2) {
                throw new CosXmlClientException((Throwable) e2);
            }
        }
    }
}
