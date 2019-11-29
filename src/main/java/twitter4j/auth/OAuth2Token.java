package twitter4j.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import twitter4j.HttpResponse;
import twitter4j.JSONException;
import twitter4j.JSONObject;
import twitter4j.TwitterException;

public class OAuth2Token implements Serializable {
    private static final long serialVersionUID = -8985359441959903216L;
    private String accessToken;
    private String tokenType;

    OAuth2Token(HttpResponse httpResponse) throws TwitterException {
        JSONObject asJSONObject = httpResponse.asJSONObject();
        this.tokenType = getRawString("token_type", asJSONObject);
        try {
            this.accessToken = URLDecoder.decode(getRawString("access_token", asJSONObject), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public OAuth2Token(String str, String str2) {
        this.tokenType = str;
        this.accessToken = str2;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    /* access modifiers changed from: package-private */
    public String generateAuthorizationHeader() {
        String str;
        try {
            str = URLEncoder.encode(this.accessToken, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str = "";
        }
        return "Bearer " + str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0030
            boolean r1 = r4 instanceof twitter4j.auth.OAuth2Token
            if (r1 != 0) goto L_0x0008
            goto L_0x0030
        L_0x0008:
            twitter4j.auth.OAuth2Token r4 = (twitter4j.auth.OAuth2Token) r4
            java.lang.String r1 = r3.tokenType
            if (r1 == 0) goto L_0x0017
            java.lang.String r2 = r4.tokenType
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x001c
            goto L_0x001b
        L_0x0017:
            java.lang.String r1 = r4.tokenType
            if (r1 == 0) goto L_0x001c
        L_0x001b:
            return r0
        L_0x001c:
            java.lang.String r1 = r3.accessToken
            if (r1 == 0) goto L_0x0029
            java.lang.String r4 = r4.accessToken
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0029:
            java.lang.String r4 = r4.accessToken
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            return r0
        L_0x002e:
            r4 = 1
            return r4
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.auth.OAuth2Token.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.tokenType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.accessToken;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "OAuth2Token{tokenType='" + this.tokenType + '\'' + ", accessToken='" + this.accessToken + '\'' + '}';
    }

    private static String getRawString(String str, JSONObject jSONObject) {
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }
}
