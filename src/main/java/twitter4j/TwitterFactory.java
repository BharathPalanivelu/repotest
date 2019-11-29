package twitter4j;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

public class TwitterFactory implements Serializable {
    static final Authorization DEFAULT_AUTHORIZATION = AuthorizationFactory.getInstance(ConfigurationContext.getInstance());
    private static final Twitter SINGLETON;
    private static final Constructor<Twitter> TWITTER_CONSTRUCTOR;
    private static final long serialVersionUID = -563983536986910054L;
    private final Configuration conf;

    static {
        boolean z;
        try {
            Class.forName("com.google.appengine.api.urlfetch.URLFetchService");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        String str = null;
        if (z) {
            try {
                Class.forName("twitter4j.AppEngineTwitterImpl");
                str = "twitter4j.AppEngineTwitterImpl";
            } catch (ClassNotFoundException unused2) {
            }
        }
        if (str == null) {
            str = "twitter4j.TwitterImpl";
        }
        try {
            TWITTER_CONSTRUCTOR = Class.forName(str).getDeclaredConstructor(new Class[]{Configuration.class, Authorization.class});
            try {
                SINGLETON = TWITTER_CONSTRUCTOR.newInstance(new Object[]{ConfigurationContext.getInstance(), DEFAULT_AUTHORIZATION});
            } catch (InstantiationException e2) {
                throw new AssertionError(e2);
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            } catch (InvocationTargetException e4) {
                throw new AssertionError(e4);
            }
        } catch (NoSuchMethodException e5) {
            throw new AssertionError(e5);
        } catch (ClassNotFoundException e6) {
            throw new AssertionError(e6);
        }
    }

    public TwitterFactory() {
        this(ConfigurationContext.getInstance());
    }

    public TwitterFactory(Configuration configuration) {
        if (configuration != null) {
            this.conf = configuration;
            return;
        }
        throw new NullPointerException("configuration cannot be null");
    }

    public TwitterFactory(String str) {
        this(ConfigurationContext.getInstance(str));
    }

    public Twitter getInstance() {
        return getInstance(AuthorizationFactory.getInstance(this.conf));
    }

    public Twitter getInstance(AccessToken accessToken) {
        String oAuthConsumerKey = this.conf.getOAuthConsumerKey();
        String oAuthConsumerSecret = this.conf.getOAuthConsumerSecret();
        if (oAuthConsumerKey == null && oAuthConsumerSecret == null) {
            throw new IllegalStateException("Consumer key and Consumer secret not supplied.");
        }
        OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
        oAuthAuthorization.setOAuthAccessToken(accessToken);
        return getInstance((Authorization) oAuthAuthorization);
    }

    public Twitter getInstance(Authorization authorization) {
        try {
            return TWITTER_CONSTRUCTOR.newInstance(new Object[]{this.conf, authorization});
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        } catch (InvocationTargetException e4) {
            throw new AssertionError(e4);
        }
    }

    public static Twitter getSingleton() {
        return SINGLETON;
    }
}
