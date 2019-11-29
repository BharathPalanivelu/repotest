package com.tencent.qcloud.core.auth;

import android.util.Base64;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.http.HttpResult;
import com.tencent.qcloud.core.http.QCloudHttpClient;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SessionCredentialProvider extends ShortTimeCredentialProvider {
    private String appid;
    private String region;
    private String secretId;
    private String secretKey;
    private String userAgent;

    @Deprecated
    public SessionCredentialProvider(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, 0);
        this.secretId = str;
        this.secretKey = str2;
        this.appid = str3;
        this.userAgent = str5;
        this.region = str4;
    }

    public SessionCredentialProvider(HttpRequest<String> httpRequest) {
        super(httpRequest);
    }

    /* access modifiers changed from: package-private */
    public QCloudLifecycleCredentials onGetCredentialFromLocal(String str, String str2) throws QCloudClientException {
        try {
            this.httpRequest = getRequestByKey();
            return parseCAMResponse((String) ((HttpResult) QCloudHttpClient.getDefault().resolveRequest(this.httpRequest).executeNow()).content());
        } catch (QCloudServiceException e2) {
            throw new QCloudClientException("get session json fails", e2);
        }
    }

    /* access modifiers changed from: protected */
    public QCloudLifecycleCredentials onRemoteCredentialReceived(String str) throws QCloudClientException {
        return parseCAMResponse(str);
    }

    private QCloudLifecycleCredentials parseCAMResponse(String str) throws QCloudClientException {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                optJSONObject = jSONObject;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("credentials");
            long optLong = optJSONObject.optLong("expiredTime");
            if (optJSONObject2 == null) {
                return null;
            }
            return new SessionQCloudCredentials(optJSONObject2.optString("tmpSecretId"), optJSONObject2.optString("tmpSecretKey"), optJSONObject2.optString("sessionToken"), optLong);
        } catch (JSONException e2) {
            throw new QCloudClientException("parse session json fails", e2);
        }
    }

    private HttpRequest<String> getRequestByKey() {
        TreeMap treeMap = new TreeMap();
        String str = this.appid;
        treeMap.put("policy", String.format("{\"statement\": [{\"action\": [\"name/cos:*\"],\"effect\": \"allow\",\"resource\":[\"qcs::cos:%s:uid/%s:prefix//%s/*\"]}],\"version\": \"2.0\"}", new Object[]{this.region, str, str}));
        treeMap.put("name", "Rabbitliu");
        treeMap.put("Action", "GetFederationToken");
        treeMap.put("SecretId", this.secretId);
        treeMap.put("Nonce", "" + new Random().nextInt(Integer.MAX_VALUE));
        treeMap.put("Timestamp", "" + (System.currentTimeMillis() / 1000));
        treeMap.put("RequestClient", this.userAgent);
        byte[] hmacSha1 = Utils.hmacSha1(makeSignPlainText(treeMap, "GET", "sts.api.qcloud.com", "/v2/index.php"), this.secretKey);
        if (hmacSha1 != null) {
            treeMap.put("Signature", Base64.encodeToString(hmacSha1, 0));
        }
        return new HttpRequest.Builder().scheme("https").host("sts.api.qcloud.com").path("/v2/index.php").method("GET").query(treeMap).build();
    }

    private String makeSignPlainText(Map<String, String> map, String str, String str2, String str3) {
        return ((("" + str) + str2) + str3) + buildParamStr(map);
    }

    private String buildParamStr(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() == 0) {
                sb.append('?');
            } else {
                sb.append('&');
            }
            sb.append(((String) next.getKey()).replace("_", "."));
            sb.append('=');
            sb.append(((String) next.getValue()).toString());
        }
        return sb.toString();
    }
}
