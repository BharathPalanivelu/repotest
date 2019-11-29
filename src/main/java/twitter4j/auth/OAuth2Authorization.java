package twitter4j.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import twitter4j.BASE64Encoder;
import twitter4j.HttpClient;
import twitter4j.HttpClientFactory;
import twitter4j.HttpParameter;
import twitter4j.HttpRequest;
import twitter4j.HttpResponse;
import twitter4j.HttpResponseListener;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;

public class OAuth2Authorization implements Serializable, Authorization, OAuth2Support {
    private static final long serialVersionUID = -2895232598422218647L;
    private final Configuration conf;
    private String consumerKey;
    private String consumerSecret;
    private final HttpClient http;
    private OAuth2Token token;

    public OAuth2Authorization(Configuration configuration) {
        this.conf = configuration;
        setOAuthConsumer(configuration.getOAuthConsumerKey(), configuration.getOAuthConsumerSecret());
        this.http = HttpClientFactory.getInstance(configuration.getHttpClientConfiguration());
    }

    public void setOAuthConsumer(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.consumerKey = str;
        if (str2 == null) {
            str2 = "";
        }
        this.consumerSecret = str2;
    }

    public OAuth2Token getOAuth2Token() throws TwitterException {
        if (this.token == null) {
            HttpParameter[] httpParameterArr = new HttpParameter[(this.conf.getOAuth2Scope() == null ? 1 : 2)];
            httpParameterArr[0] = new HttpParameter("grant_type", "client_credentials");
            if (this.conf.getOAuth2Scope() != null) {
                httpParameterArr[1] = new HttpParameter("scope", this.conf.getOAuth2Scope());
            }
            HttpResponse post = this.http.post(this.conf.getOAuth2TokenURL(), httpParameterArr, this, (HttpResponseListener) null);
            if (post.getStatusCode() == 200) {
                this.token = new OAuth2Token(post);
                return this.token;
            }
            throw new TwitterException("Obtaining OAuth 2 Bearer Token failed.", post);
        }
        throw new IllegalStateException("OAuth 2 Bearer Token is already available.");
    }

    public void setOAuth2Token(OAuth2Token oAuth2Token) {
        this.token = oAuth2Token;
    }

    /* JADX INFO: finally extract failed */
    public void invalidateOAuth2Token() throws TwitterException {
        OAuth2Token oAuth2Token = this.token;
        if (oAuth2Token != null) {
            HttpParameter[] httpParameterArr = {new HttpParameter("access_token", oAuth2Token.getAccessToken())};
            OAuth2Token oAuth2Token2 = this.token;
            try {
                this.token = null;
                HttpResponse post = this.http.post(this.conf.getOAuth2InvalidateTokenURL(), httpParameterArr, this, (HttpResponseListener) null);
                if (post.getStatusCode() != 200) {
                    throw new TwitterException("Invalidating OAuth 2 Bearer Token failed.", post);
                }
            } catch (Throwable th) {
                this.token = oAuth2Token2;
                throw th;
            }
        } else {
            throw new IllegalStateException("OAuth 2 Bearer Token is not available.");
        }
    }

    public String getAuthorizationHeader(HttpRequest httpRequest) {
        String str;
        OAuth2Token oAuth2Token = this.token;
        if (oAuth2Token != null) {
            return oAuth2Token.generateAuthorizationHeader();
        }
        try {
            str = URLEncoder.encode(this.consumerKey, "UTF-8") + ":" + URLEncoder.encode(this.consumerSecret, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str = "";
        }
        return "Basic " + BASE64Encoder.encode(str.getBytes());
    }

    public boolean isEnabled() {
        return this.token != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0042
            boolean r1 = r4 instanceof twitter4j.auth.OAuth2Authorization
            if (r1 != 0) goto L_0x0008
            goto L_0x0042
        L_0x0008:
            twitter4j.auth.OAuth2Authorization r4 = (twitter4j.auth.OAuth2Authorization) r4
            java.lang.String r1 = r3.consumerKey
            if (r1 == 0) goto L_0x0017
            java.lang.String r2 = r4.consumerKey
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x001c
            goto L_0x001b
        L_0x0017:
            java.lang.String r1 = r4.consumerKey
            if (r1 == 0) goto L_0x001c
        L_0x001b:
            return r0
        L_0x001c:
            java.lang.String r1 = r3.consumerSecret
            if (r1 == 0) goto L_0x0029
            java.lang.String r2 = r4.consumerSecret
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0029:
            java.lang.String r1 = r4.consumerSecret
            if (r1 == 0) goto L_0x002e
        L_0x002d:
            return r0
        L_0x002e:
            twitter4j.auth.OAuth2Token r1 = r3.token
            if (r1 == 0) goto L_0x003b
            twitter4j.auth.OAuth2Token r4 = r4.token
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0040
            goto L_0x003f
        L_0x003b:
            twitter4j.auth.OAuth2Token r4 = r4.token
            if (r4 == 0) goto L_0x0040
        L_0x003f:
            return r0
        L_0x0040:
            r4 = 1
            return r4
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.auth.OAuth2Authorization.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.consumerKey;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.consumerSecret;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        OAuth2Token oAuth2Token = this.token;
        if (oAuth2Token != null) {
            i = oAuth2Token.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("OAuth2Authorization{consumerKey='");
        sb.append(this.consumerKey);
        sb.append('\'');
        sb.append(", consumerSecret='******************************************', token=");
        OAuth2Token oAuth2Token = this.token;
        if (oAuth2Token == null) {
            str = "null";
        } else {
            str = oAuth2Token.toString();
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
