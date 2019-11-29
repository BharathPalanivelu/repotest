package twitter4j.conf;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import twitter4j.HttpClientConfiguration;
import twitter4j.Logger;

class ConfigurationBase implements Serializable, Configuration {
    private static final List<ConfigurationBase> instances = new ArrayList();
    private static final long serialVersionUID = 6175546394599249696L;
    private boolean applicationOnlyAuthEnabled = false;
    private int asyncNumThreads = 1;
    private long contributingTo = -1;
    private boolean daemonEnabled = true;
    private boolean debug = false;
    private String dispatcherImpl = "twitter4j.DispatcherImpl";
    private HttpClientConfiguration httpConf = new MyHttpClientConfiguration((String) null, (String) null, (String) null, -1, 20000, 120000, false, true);
    /* access modifiers changed from: private */
    public int httpRetryCount = 0;
    /* access modifiers changed from: private */
    public int httpRetryIntervalSeconds = 5;
    private int httpStreamingReadTimeout = 40000;
    private boolean includeEmailEnabled = false;
    private boolean includeEntitiesEnabled = true;
    private boolean includeExtAltTextEnabled = true;
    private boolean includeMyRetweetEnabled = true;
    private boolean jsonStoreEnabled = false;
    private String loggerFactory = null;
    private boolean mbeanEnabled = false;
    private String mediaProvider = "TWITTER";
    private String mediaProviderAPIKey = null;
    private Properties mediaProviderParameters = null;
    private String oAuth2AccessToken;
    private String oAuth2InvalidateTokenURL = "https://api.twitter.com/oauth2/invalidate_token";
    private String oAuth2Scope;
    private String oAuth2TokenType;
    private String oAuth2TokenURL = "https://api.twitter.com/oauth2/token";
    private String oAuthAccessToken = null;
    private String oAuthAccessTokenSecret = null;
    private String oAuthAccessTokenURL = "https://api.twitter.com/oauth/access_token";
    private String oAuthAuthenticationURL = "https://api.twitter.com/oauth/authenticate";
    private String oAuthAuthorizationURL = "https://api.twitter.com/oauth/authorize";
    private String oAuthConsumerKey = null;
    private String oAuthConsumerSecret = null;
    private String oAuthRequestTokenURL = "https://api.twitter.com/oauth/request_token";
    private String password = null;
    private String restBaseURL = "https://api.twitter.com/1.1/";
    private String siteStreamBaseURL = "https://sitestream.twitter.com/1.1/";
    private boolean stallWarningsEnabled = true;
    private String streamBaseURL = "https://stream.twitter.com/1.1/";
    private String streamThreadName = "";
    private boolean trimUserEnabled = false;
    private boolean tweetModeExtended = false;
    private String uploadBaseURL = "https://upload.twitter.com/1.1/";
    private String user = null;
    private String userStreamBaseURL = "https://userstream.twitter.com/1.1/";
    private boolean userStreamRepliesAllEnabled = false;
    private boolean userStreamWithFollowingsEnabled = true;

    protected ConfigurationBase() {
    }

    class MyHttpClientConfiguration implements Serializable, HttpClientConfiguration {
        private static final long serialVersionUID = 8226866124868861058L;
        private boolean gzipEnabled = true;
        private int httpConnectionTimeout = 20000;
        private String httpProxyHost = null;
        private String httpProxyPassword = null;
        private int httpProxyPort = -1;
        private String httpProxyUser = null;
        private int httpReadTimeout = 120000;
        private boolean prettyDebug = false;

        MyHttpClientConfiguration(String str, String str2, String str3, int i, int i2, int i3, boolean z, boolean z2) {
            this.httpProxyHost = str;
            this.httpProxyUser = str2;
            this.httpProxyPassword = str3;
            this.httpProxyPort = i;
            this.httpConnectionTimeout = i2;
            this.httpReadTimeout = i3;
            this.prettyDebug = z;
            this.gzipEnabled = z2;
        }

        public String getHttpProxyHost() {
            return this.httpProxyHost;
        }

        public int getHttpProxyPort() {
            return this.httpProxyPort;
        }

        public String getHttpProxyUser() {
            return this.httpProxyUser;
        }

        public String getHttpProxyPassword() {
            return this.httpProxyPassword;
        }

        public int getHttpConnectionTimeout() {
            return this.httpConnectionTimeout;
        }

        public int getHttpReadTimeout() {
            return this.httpReadTimeout;
        }

        public int getHttpRetryCount() {
            return ConfigurationBase.this.httpRetryCount;
        }

        public int getHttpRetryIntervalSeconds() {
            return ConfigurationBase.this.httpRetryIntervalSeconds;
        }

        public boolean isPrettyDebugEnabled() {
            return this.prettyDebug;
        }

        public boolean isGZIPEnabled() {
            return this.gzipEnabled;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MyHttpClientConfiguration myHttpClientConfiguration = (MyHttpClientConfiguration) obj;
            if (this.gzipEnabled != myHttpClientConfiguration.gzipEnabled || this.httpConnectionTimeout != myHttpClientConfiguration.httpConnectionTimeout || this.httpProxyPort != myHttpClientConfiguration.httpProxyPort || this.httpReadTimeout != myHttpClientConfiguration.httpReadTimeout || this.prettyDebug != myHttpClientConfiguration.prettyDebug) {
                return false;
            }
            String str = this.httpProxyHost;
            if (str == null ? myHttpClientConfiguration.httpProxyHost != null : !str.equals(myHttpClientConfiguration.httpProxyHost)) {
                return false;
            }
            String str2 = this.httpProxyPassword;
            if (str2 == null ? myHttpClientConfiguration.httpProxyPassword != null : !str2.equals(myHttpClientConfiguration.httpProxyPassword)) {
                return false;
            }
            String str3 = this.httpProxyUser;
            return str3 == null ? myHttpClientConfiguration.httpProxyUser == null : str3.equals(myHttpClientConfiguration.httpProxyUser);
        }

        public int hashCode() {
            String str = this.httpProxyHost;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.httpProxyUser;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.httpProxyPassword;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return ((((((((((hashCode2 + i) * 31) + this.httpProxyPort) * 31) + this.httpConnectionTimeout) * 31) + this.httpReadTimeout) * 31) + (this.prettyDebug ? 1 : 0)) * 31) + (this.gzipEnabled ? 1 : 0);
        }

        public String toString() {
            return "MyHttpClientConfiguration{httpProxyHost='" + this.httpProxyHost + '\'' + ", httpProxyUser='" + this.httpProxyUser + '\'' + ", httpProxyPassword='" + this.httpProxyPassword + '\'' + ", httpProxyPort=" + this.httpProxyPort + ", httpConnectionTimeout=" + this.httpConnectionTimeout + ", httpReadTimeout=" + this.httpReadTimeout + ", prettyDebug=" + this.prettyDebug + ", gzipEnabled=" + this.gzipEnabled + '}';
        }
    }

    public void dumpConfiguration() {
        Logger logger = Logger.getLogger(ConfigurationBase.class);
        if (this.debug) {
            for (Field field : ConfigurationBase.class.getDeclaredFields()) {
                try {
                    Object obj = field.get(this);
                    String valueOf = String.valueOf(obj);
                    if (obj != null && field.getName().matches("oAuthConsumerSecret|oAuthAccessTokenSecret|password")) {
                        valueOf = String.valueOf(obj).replaceAll(".", "*");
                    }
                    logger.debug(field.getName() + ": " + valueOf);
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public final boolean isDebugEnabled() {
        return this.debug;
    }

    /* access modifiers changed from: protected */
    public final void setDebug(boolean z) {
        this.debug = z;
    }

    public final String getUser() {
        return this.user;
    }

    /* access modifiers changed from: protected */
    public final void setUser(String str) {
        this.user = str;
    }

    public final String getPassword() {
        return this.password;
    }

    public HttpClientConfiguration getHttpClientConfiguration() {
        return this.httpConf;
    }

    /* access modifiers changed from: protected */
    public final void setPassword(String str) {
        this.password = str;
    }

    /* access modifiers changed from: protected */
    public final void setPrettyDebugEnabled(boolean z) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), z, this.httpConf.isGZIPEnabled());
    }

    /* access modifiers changed from: protected */
    public final void setGZIPEnabled(boolean z) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), z);
    }

    /* access modifiers changed from: protected */
    public final void setHttpProxyHost(String str) {
        this.httpConf = new MyHttpClientConfiguration(str, this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* access modifiers changed from: protected */
    public final void setHttpProxyUser(String str) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), str, this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* access modifiers changed from: protected */
    public final void setHttpProxyPassword(String str) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), str, this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* access modifiers changed from: protected */
    public final void setHttpProxyPort(int i) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), i, this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* access modifiers changed from: protected */
    public final void setHttpConnectionTimeout(int i) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), i, this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* access modifiers changed from: protected */
    public final void setHttpReadTimeout(int i) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), i, this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    public int getHttpStreamingReadTimeout() {
        return this.httpStreamingReadTimeout;
    }

    /* access modifiers changed from: protected */
    public final void setHttpStreamingReadTimeout(int i) {
        this.httpStreamingReadTimeout = i;
    }

    /* access modifiers changed from: protected */
    public final void setHttpRetryCount(int i) {
        this.httpRetryCount = i;
    }

    /* access modifiers changed from: protected */
    public final void setHttpRetryIntervalSeconds(int i) {
        this.httpRetryIntervalSeconds = i;
    }

    public final String getOAuthConsumerKey() {
        return this.oAuthConsumerKey;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthConsumerKey(String str) {
        this.oAuthConsumerKey = str;
    }

    public final String getOAuthConsumerSecret() {
        return this.oAuthConsumerSecret;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthConsumerSecret(String str) {
        this.oAuthConsumerSecret = str;
    }

    public String getOAuthAccessToken() {
        return this.oAuthAccessToken;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthAccessToken(String str) {
        this.oAuthAccessToken = str;
    }

    public String getOAuthAccessTokenSecret() {
        return this.oAuthAccessTokenSecret;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthAccessTokenSecret(String str) {
        this.oAuthAccessTokenSecret = str;
    }

    public String getOAuth2TokenType() {
        return this.oAuth2TokenType;
    }

    /* access modifiers changed from: protected */
    public final void setOAuth2TokenType(String str) {
        this.oAuth2TokenType = str;
    }

    public String getOAuth2AccessToken() {
        return this.oAuth2AccessToken;
    }

    public String getOAuth2Scope() {
        return this.oAuth2Scope;
    }

    /* access modifiers changed from: protected */
    public final void setOAuth2AccessToken(String str) {
        this.oAuth2AccessToken = str;
    }

    /* access modifiers changed from: protected */
    public final void setOAuth2Scope(String str) {
        this.oAuth2Scope = str;
    }

    public final int getAsyncNumThreads() {
        return this.asyncNumThreads;
    }

    /* access modifiers changed from: protected */
    public final void setAsyncNumThreads(int i) {
        this.asyncNumThreads = i;
    }

    public final long getContributingTo() {
        return this.contributingTo;
    }

    /* access modifiers changed from: protected */
    public final void setContributingTo(long j) {
        this.contributingTo = j;
    }

    public String getRestBaseURL() {
        return this.restBaseURL;
    }

    /* access modifiers changed from: protected */
    public final void setRestBaseURL(String str) {
        this.restBaseURL = str;
    }

    public String getUploadBaseURL() {
        return this.uploadBaseURL;
    }

    /* access modifiers changed from: protected */
    public final void setUploadBaseURL(String str) {
        this.uploadBaseURL = str;
    }

    public String getStreamBaseURL() {
        return this.streamBaseURL;
    }

    /* access modifiers changed from: protected */
    public final void setStreamBaseURL(String str) {
        this.streamBaseURL = str;
    }

    public String getUserStreamBaseURL() {
        return this.userStreamBaseURL;
    }

    /* access modifiers changed from: protected */
    public final void setUserStreamBaseURL(String str) {
        this.userStreamBaseURL = str;
    }

    public String getSiteStreamBaseURL() {
        return this.siteStreamBaseURL;
    }

    /* access modifiers changed from: protected */
    public final void setSiteStreamBaseURL(String str) {
        this.siteStreamBaseURL = str;
    }

    public String getOAuthRequestTokenURL() {
        return this.oAuthRequestTokenURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthRequestTokenURL(String str) {
        this.oAuthRequestTokenURL = str;
    }

    public String getOAuthAuthorizationURL() {
        return this.oAuthAuthorizationURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthAuthorizationURL(String str) {
        this.oAuthAuthorizationURL = str;
    }

    public String getOAuthAccessTokenURL() {
        return this.oAuthAccessTokenURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthAccessTokenURL(String str) {
        this.oAuthAccessTokenURL = str;
    }

    public String getOAuthAuthenticationURL() {
        return this.oAuthAuthenticationURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthAuthenticationURL(String str) {
        this.oAuthAuthenticationURL = str;
    }

    public String getOAuth2TokenURL() {
        return this.oAuth2TokenURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuth2TokenURL(String str) {
        this.oAuth2TokenURL = str;
    }

    public String getOAuth2InvalidateTokenURL() {
        return this.oAuth2InvalidateTokenURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuth2InvalidateTokenURL(String str) {
        this.oAuth2InvalidateTokenURL = str;
    }

    public String getDispatcherImpl() {
        return this.dispatcherImpl;
    }

    /* access modifiers changed from: protected */
    public final void setDispatcherImpl(String str) {
        this.dispatcherImpl = str;
    }

    public String getLoggerFactory() {
        return this.loggerFactory;
    }

    public boolean isIncludeEntitiesEnabled() {
        return this.includeEntitiesEnabled;
    }

    /* access modifiers changed from: protected */
    public void setIncludeEntitiesEnabled(boolean z) {
        this.includeEntitiesEnabled = z;
    }

    /* access modifiers changed from: protected */
    public final void setLoggerFactory(String str) {
        this.loggerFactory = str;
    }

    public boolean isIncludeMyRetweetEnabled() {
        return this.includeMyRetweetEnabled;
    }

    public void setIncludeMyRetweetEnabled(boolean z) {
        this.includeMyRetweetEnabled = z;
    }

    public boolean isTrimUserEnabled() {
        return this.trimUserEnabled;
    }

    public boolean isIncludeExtAltTextEnabled() {
        return this.includeExtAltTextEnabled;
    }

    public boolean isTweetModeExtended() {
        return this.tweetModeExtended;
    }

    public boolean isDaemonEnabled() {
        return this.daemonEnabled;
    }

    /* access modifiers changed from: protected */
    public void setDaemonEnabled(boolean z) {
        this.daemonEnabled = z;
    }

    public boolean isIncludeEmailEnabled() {
        return this.includeEmailEnabled;
    }

    /* access modifiers changed from: protected */
    public void setIncludeEmailEnabled(boolean z) {
        this.includeEmailEnabled = z;
    }

    public void setTrimUserEnabled(boolean z) {
        this.trimUserEnabled = z;
    }

    public void setIncludeExtAltTextEnabled(boolean z) {
        this.includeExtAltTextEnabled = z;
    }

    public void setTweetModeExtended(boolean z) {
        this.tweetModeExtended = z;
    }

    public boolean isJSONStoreEnabled() {
        return this.jsonStoreEnabled;
    }

    /* access modifiers changed from: protected */
    public final void setJSONStoreEnabled(boolean z) {
        this.jsonStoreEnabled = z;
    }

    public boolean isMBeanEnabled() {
        return this.mbeanEnabled;
    }

    /* access modifiers changed from: protected */
    public final void setMBeanEnabled(boolean z) {
        this.mbeanEnabled = z;
    }

    public boolean isUserStreamRepliesAllEnabled() {
        return this.userStreamRepliesAllEnabled;
    }

    public boolean isUserStreamWithFollowingsEnabled() {
        return this.userStreamWithFollowingsEnabled;
    }

    /* access modifiers changed from: protected */
    public final void setUserStreamRepliesAllEnabled(boolean z) {
        this.userStreamRepliesAllEnabled = z;
    }

    /* access modifiers changed from: protected */
    public final void setUserStreamWithFollowingsEnabled(boolean z) {
        this.userStreamWithFollowingsEnabled = z;
    }

    public boolean isStallWarningsEnabled() {
        return this.stallWarningsEnabled;
    }

    /* access modifiers changed from: protected */
    public final void setStallWarningsEnabled(boolean z) {
        this.stallWarningsEnabled = z;
    }

    public boolean isApplicationOnlyAuthEnabled() {
        return this.applicationOnlyAuthEnabled;
    }

    /* access modifiers changed from: protected */
    public final void setApplicationOnlyAuthEnabled(boolean z) {
        this.applicationOnlyAuthEnabled = z;
    }

    public String getMediaProvider() {
        return this.mediaProvider;
    }

    /* access modifiers changed from: protected */
    public final void setMediaProvider(String str) {
        this.mediaProvider = str;
    }

    public String getMediaProviderAPIKey() {
        return this.mediaProviderAPIKey;
    }

    /* access modifiers changed from: protected */
    public final void setMediaProviderAPIKey(String str) {
        this.mediaProviderAPIKey = str;
    }

    public Properties getMediaProviderParameters() {
        return this.mediaProviderParameters;
    }

    /* access modifiers changed from: protected */
    public final void setMediaProviderParameters(Properties properties) {
        this.mediaProviderParameters = properties;
    }

    public String getStreamThreadName() {
        return this.streamThreadName;
    }

    /* access modifiers changed from: protected */
    public final void setStreamThreadName(String str) {
        this.streamThreadName = str;
    }

    static String fixURL(boolean z, String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("://");
        if (-1 != indexOf) {
            String substring = str.substring(indexOf + 3);
            if (z) {
                return "https://" + substring;
            }
            return "http://" + substring;
        }
        throw new IllegalArgumentException("url should contain '://'");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConfigurationBase configurationBase = (ConfigurationBase) obj;
        if (this.debug != configurationBase.debug || this.httpStreamingReadTimeout != configurationBase.httpStreamingReadTimeout || this.httpRetryCount != configurationBase.httpRetryCount || this.httpRetryIntervalSeconds != configurationBase.httpRetryIntervalSeconds || this.asyncNumThreads != configurationBase.asyncNumThreads || this.contributingTo != configurationBase.contributingTo || this.includeMyRetweetEnabled != configurationBase.includeMyRetweetEnabled || this.includeEntitiesEnabled != configurationBase.includeEntitiesEnabled || this.trimUserEnabled != configurationBase.trimUserEnabled || this.includeExtAltTextEnabled != configurationBase.includeExtAltTextEnabled || this.tweetModeExtended != configurationBase.tweetModeExtended || this.includeEmailEnabled != configurationBase.includeEmailEnabled || this.jsonStoreEnabled != configurationBase.jsonStoreEnabled || this.mbeanEnabled != configurationBase.mbeanEnabled || this.userStreamRepliesAllEnabled != configurationBase.userStreamRepliesAllEnabled || this.userStreamWithFollowingsEnabled != configurationBase.userStreamWithFollowingsEnabled || this.stallWarningsEnabled != configurationBase.stallWarningsEnabled || this.applicationOnlyAuthEnabled != configurationBase.applicationOnlyAuthEnabled || this.daemonEnabled != configurationBase.daemonEnabled) {
            return false;
        }
        String str = this.user;
        if (str == null ? configurationBase.user != null : !str.equals(configurationBase.user)) {
            return false;
        }
        String str2 = this.password;
        if (str2 == null ? configurationBase.password != null : !str2.equals(configurationBase.password)) {
            return false;
        }
        HttpClientConfiguration httpClientConfiguration = this.httpConf;
        if (httpClientConfiguration == null ? configurationBase.httpConf != null : !httpClientConfiguration.equals(configurationBase.httpConf)) {
            return false;
        }
        String str3 = this.oAuthConsumerKey;
        if (str3 == null ? configurationBase.oAuthConsumerKey != null : !str3.equals(configurationBase.oAuthConsumerKey)) {
            return false;
        }
        String str4 = this.oAuthConsumerSecret;
        if (str4 == null ? configurationBase.oAuthConsumerSecret != null : !str4.equals(configurationBase.oAuthConsumerSecret)) {
            return false;
        }
        String str5 = this.oAuthAccessToken;
        if (str5 == null ? configurationBase.oAuthAccessToken != null : !str5.equals(configurationBase.oAuthAccessToken)) {
            return false;
        }
        String str6 = this.oAuthAccessTokenSecret;
        if (str6 == null ? configurationBase.oAuthAccessTokenSecret != null : !str6.equals(configurationBase.oAuthAccessTokenSecret)) {
            return false;
        }
        String str7 = this.oAuth2TokenType;
        if (str7 == null ? configurationBase.oAuth2TokenType != null : !str7.equals(configurationBase.oAuth2TokenType)) {
            return false;
        }
        String str8 = this.oAuth2AccessToken;
        if (str8 == null ? configurationBase.oAuth2AccessToken != null : !str8.equals(configurationBase.oAuth2AccessToken)) {
            return false;
        }
        String str9 = this.oAuth2Scope;
        if (str9 == null ? configurationBase.oAuth2Scope != null : !str9.equals(configurationBase.oAuth2Scope)) {
            return false;
        }
        String str10 = this.oAuthRequestTokenURL;
        if (str10 == null ? configurationBase.oAuthRequestTokenURL != null : !str10.equals(configurationBase.oAuthRequestTokenURL)) {
            return false;
        }
        String str11 = this.oAuthAuthorizationURL;
        if (str11 == null ? configurationBase.oAuthAuthorizationURL != null : !str11.equals(configurationBase.oAuthAuthorizationURL)) {
            return false;
        }
        String str12 = this.oAuthAccessTokenURL;
        if (str12 == null ? configurationBase.oAuthAccessTokenURL != null : !str12.equals(configurationBase.oAuthAccessTokenURL)) {
            return false;
        }
        String str13 = this.oAuthAuthenticationURL;
        if (str13 == null ? configurationBase.oAuthAuthenticationURL != null : !str13.equals(configurationBase.oAuthAuthenticationURL)) {
            return false;
        }
        String str14 = this.oAuth2TokenURL;
        if (str14 == null ? configurationBase.oAuth2TokenURL != null : !str14.equals(configurationBase.oAuth2TokenURL)) {
            return false;
        }
        String str15 = this.oAuth2InvalidateTokenURL;
        if (str15 == null ? configurationBase.oAuth2InvalidateTokenURL != null : !str15.equals(configurationBase.oAuth2InvalidateTokenURL)) {
            return false;
        }
        String str16 = this.restBaseURL;
        if (str16 == null ? configurationBase.restBaseURL != null : !str16.equals(configurationBase.restBaseURL)) {
            return false;
        }
        String str17 = this.streamBaseURL;
        if (str17 == null ? configurationBase.streamBaseURL != null : !str17.equals(configurationBase.streamBaseURL)) {
            return false;
        }
        String str18 = this.userStreamBaseURL;
        if (str18 == null ? configurationBase.userStreamBaseURL != null : !str18.equals(configurationBase.userStreamBaseURL)) {
            return false;
        }
        String str19 = this.siteStreamBaseURL;
        if (str19 == null ? configurationBase.siteStreamBaseURL != null : !str19.equals(configurationBase.siteStreamBaseURL)) {
            return false;
        }
        String str20 = this.uploadBaseURL;
        if (str20 == null ? configurationBase.uploadBaseURL != null : !str20.equals(configurationBase.uploadBaseURL)) {
            return false;
        }
        String str21 = this.dispatcherImpl;
        if (str21 == null ? configurationBase.dispatcherImpl != null : !str21.equals(configurationBase.dispatcherImpl)) {
            return false;
        }
        String str22 = this.loggerFactory;
        if (str22 == null ? configurationBase.loggerFactory != null : !str22.equals(configurationBase.loggerFactory)) {
            return false;
        }
        String str23 = this.mediaProvider;
        if (str23 == null ? configurationBase.mediaProvider != null : !str23.equals(configurationBase.mediaProvider)) {
            return false;
        }
        String str24 = this.mediaProviderAPIKey;
        if (str24 == null ? configurationBase.mediaProviderAPIKey != null : !str24.equals(configurationBase.mediaProviderAPIKey)) {
            return false;
        }
        Properties properties = this.mediaProviderParameters;
        if (properties == null ? configurationBase.mediaProviderParameters != null : !properties.equals(configurationBase.mediaProviderParameters)) {
            return false;
        }
        String str25 = this.streamThreadName;
        if (str25 != null) {
            return str25.equals(configurationBase.streamThreadName);
        }
        if (configurationBase.streamThreadName == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = (this.debug ? 1 : 0) * true;
        String str = this.user;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.password;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        HttpClientConfiguration httpClientConfiguration = this.httpConf;
        int hashCode3 = (((((((hashCode2 + (httpClientConfiguration != null ? httpClientConfiguration.hashCode() : 0)) * 31) + this.httpStreamingReadTimeout) * 31) + this.httpRetryCount) * 31) + this.httpRetryIntervalSeconds) * 31;
        String str3 = this.oAuthConsumerKey;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.oAuthConsumerSecret;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.oAuthAccessToken;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.oAuthAccessTokenSecret;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.oAuth2TokenType;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.oAuth2AccessToken;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.oAuth2Scope;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.oAuthRequestTokenURL;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.oAuthAuthorizationURL;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.oAuthAccessTokenURL;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.oAuthAuthenticationURL;
        int hashCode14 = (hashCode13 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.oAuth2TokenURL;
        int hashCode15 = (hashCode14 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.oAuth2InvalidateTokenURL;
        int hashCode16 = (hashCode15 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.restBaseURL;
        int hashCode17 = (hashCode16 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.streamBaseURL;
        int hashCode18 = (hashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.userStreamBaseURL;
        int hashCode19 = (hashCode18 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.siteStreamBaseURL;
        int hashCode20 = (hashCode19 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.uploadBaseURL;
        int hashCode21 = (hashCode20 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.dispatcherImpl;
        int hashCode22 = (((hashCode21 + (str21 != null ? str21.hashCode() : 0)) * 31) + this.asyncNumThreads) * 31;
        String str22 = this.loggerFactory;
        int hashCode23 = str22 != null ? str22.hashCode() : 0;
        long j = this.contributingTo;
        int i3 = (((((((((((((((((((((((((((hashCode22 + hashCode23) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.includeMyRetweetEnabled ? 1 : 0)) * 31) + (this.includeEntitiesEnabled ? 1 : 0)) * 31) + (this.trimUserEnabled ? 1 : 0)) * 31) + (this.includeExtAltTextEnabled ? 1 : 0)) * 31) + (this.tweetModeExtended ? 1 : 0)) * 31) + (this.includeEmailEnabled ? 1 : 0)) * 31) + (this.jsonStoreEnabled ? 1 : 0)) * 31) + (this.mbeanEnabled ? 1 : 0)) * 31) + (this.userStreamRepliesAllEnabled ? 1 : 0)) * 31) + (this.userStreamWithFollowingsEnabled ? 1 : 0)) * 31) + (this.stallWarningsEnabled ? 1 : 0)) * 31) + (this.applicationOnlyAuthEnabled ? 1 : 0)) * 31;
        String str23 = this.mediaProvider;
        int hashCode24 = (i3 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.mediaProviderAPIKey;
        int hashCode25 = (hashCode24 + (str24 != null ? str24.hashCode() : 0)) * 31;
        Properties properties = this.mediaProviderParameters;
        int hashCode26 = (((hashCode25 + (properties != null ? properties.hashCode() : 0)) * 31) + (this.daemonEnabled ? 1 : 0)) * 31;
        String str25 = this.streamThreadName;
        if (str25 != null) {
            i2 = str25.hashCode();
        }
        return hashCode26 + i2;
    }

    public String toString() {
        return "ConfigurationBase{debug=" + this.debug + ", user='" + this.user + '\'' + ", password='" + this.password + '\'' + ", httpConf=" + this.httpConf + ", httpStreamingReadTimeout=" + this.httpStreamingReadTimeout + ", httpRetryCount=" + this.httpRetryCount + ", httpRetryIntervalSeconds=" + this.httpRetryIntervalSeconds + ", oAuthConsumerKey='" + this.oAuthConsumerKey + '\'' + ", oAuthConsumerSecret='" + this.oAuthConsumerSecret + '\'' + ", oAuthAccessToken='" + this.oAuthAccessToken + '\'' + ", oAuthAccessTokenSecret='" + this.oAuthAccessTokenSecret + '\'' + ", oAuth2TokenType='" + this.oAuth2TokenType + '\'' + ", oAuth2AccessToken='" + this.oAuth2AccessToken + '\'' + ", oAuth2Scope='" + this.oAuth2Scope + '\'' + ", oAuthRequestTokenURL='" + this.oAuthRequestTokenURL + '\'' + ", oAuthAuthorizationURL='" + this.oAuthAuthorizationURL + '\'' + ", oAuthAccessTokenURL='" + this.oAuthAccessTokenURL + '\'' + ", oAuthAuthenticationURL='" + this.oAuthAuthenticationURL + '\'' + ", oAuth2TokenURL='" + this.oAuth2TokenURL + '\'' + ", oAuth2InvalidateTokenURL='" + this.oAuth2InvalidateTokenURL + '\'' + ", restBaseURL='" + this.restBaseURL + '\'' + ", streamBaseURL='" + this.streamBaseURL + '\'' + ", userStreamBaseURL='" + this.userStreamBaseURL + '\'' + ", siteStreamBaseURL='" + this.siteStreamBaseURL + '\'' + ", uploadBaseURL='" + this.uploadBaseURL + '\'' + ", dispatcherImpl='" + this.dispatcherImpl + '\'' + ", asyncNumThreads=" + this.asyncNumThreads + ", loggerFactory='" + this.loggerFactory + '\'' + ", contributingTo=" + this.contributingTo + ", includeMyRetweetEnabled=" + this.includeMyRetweetEnabled + ", includeEntitiesEnabled=" + this.includeEntitiesEnabled + ", trimUserEnabled=" + this.trimUserEnabled + ", includeExtAltTextEnabled=" + this.includeExtAltTextEnabled + ", tweetModeExtended=" + this.tweetModeExtended + ", includeEmailEnabled=" + this.includeEmailEnabled + ", jsonStoreEnabled=" + this.jsonStoreEnabled + ", mbeanEnabled=" + this.mbeanEnabled + ", userStreamRepliesAllEnabled=" + this.userStreamRepliesAllEnabled + ", userStreamWithFollowingsEnabled=" + this.userStreamWithFollowingsEnabled + ", stallWarningsEnabled=" + this.stallWarningsEnabled + ", applicationOnlyAuthEnabled=" + this.applicationOnlyAuthEnabled + ", mediaProvider='" + this.mediaProvider + '\'' + ", mediaProviderAPIKey='" + this.mediaProviderAPIKey + '\'' + ", mediaProviderParameters=" + this.mediaProviderParameters + ", daemonEnabled=" + this.daemonEnabled + ", streamThreadName='" + this.streamThreadName + '\'' + '}';
    }

    private static void cacheInstance(ConfigurationBase configurationBase) {
        if (!instances.contains(configurationBase)) {
            instances.add(configurationBase);
        }
    }

    /* access modifiers changed from: protected */
    public void cacheInstance() {
        cacheInstance(this);
    }

    private static ConfigurationBase getInstance(ConfigurationBase configurationBase) {
        int indexOf = instances.indexOf(configurationBase);
        if (indexOf != -1) {
            return instances.get(indexOf);
        }
        instances.add(configurationBase);
        return configurationBase;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() throws ObjectStreamException {
        return getInstance(this);
    }
}
