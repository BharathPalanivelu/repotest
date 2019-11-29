package twitter4j.auth;

public final class AuthorizationFactory {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: twitter4j.auth.OAuthAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: twitter4j.auth.OAuth2Authorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static twitter4j.auth.Authorization getInstance(twitter4j.conf.Configuration r3) {
        /*
            java.lang.String r0 = r3.getOAuthConsumerKey()
            java.lang.String r1 = r3.getOAuthConsumerSecret()
            if (r0 == 0) goto L_0x0046
            if (r1 == 0) goto L_0x0046
            boolean r0 = r3.isApplicationOnlyAuthEnabled()
            if (r0 == 0) goto L_0x002c
            twitter4j.auth.OAuth2Authorization r0 = new twitter4j.auth.OAuth2Authorization
            r0.<init>(r3)
            java.lang.String r1 = r3.getOAuth2TokenType()
            java.lang.String r3 = r3.getOAuth2AccessToken()
            if (r1 == 0) goto L_0x005a
            if (r3 == 0) goto L_0x005a
            twitter4j.auth.OAuth2Token r2 = new twitter4j.auth.OAuth2Token
            r2.<init>(r1, r3)
            r0.setOAuth2Token(r2)
            goto L_0x005a
        L_0x002c:
            twitter4j.auth.OAuthAuthorization r0 = new twitter4j.auth.OAuthAuthorization
            r0.<init>(r3)
            java.lang.String r1 = r3.getOAuthAccessToken()
            java.lang.String r3 = r3.getOAuthAccessTokenSecret()
            if (r1 == 0) goto L_0x005a
            if (r3 == 0) goto L_0x005a
            twitter4j.auth.AccessToken r2 = new twitter4j.auth.AccessToken
            r2.<init>(r1, r3)
            r0.setOAuthAccessToken(r2)
            goto L_0x005a
        L_0x0046:
            java.lang.String r0 = r3.getUser()
            java.lang.String r3 = r3.getPassword()
            if (r0 == 0) goto L_0x0059
            if (r3 == 0) goto L_0x0059
            twitter4j.auth.BasicAuthorization r1 = new twitter4j.auth.BasicAuthorization
            r1.<init>(r0, r3)
            r0 = r1
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            if (r0 != 0) goto L_0x0060
            twitter4j.auth.NullAuthorization r0 = twitter4j.auth.NullAuthorization.getInstance()
        L_0x0060:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.auth.AuthorizationFactory.getInstance(twitter4j.conf.Configuration):twitter4j.auth.Authorization");
    }
}
