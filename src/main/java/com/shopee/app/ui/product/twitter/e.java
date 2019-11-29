package com.shopee.app.ui.product.twitter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.bc;
import com.shopee.app.data.store.f;
import com.shopee.app.g.m;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import java.io.File;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f24910a = false;

    /* renamed from: b  reason: collision with root package name */
    private static RequestToken f24911b;

    /* renamed from: c  reason: collision with root package name */
    private Twitter f24912c;

    public e() {
        f();
    }

    private void f() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true).setOAuthConsumerKey(m.f17570a).setOAuthConsumerSecret(m.f17571b).setOAuthAccessToken((String) null).setOAuthAccessTokenSecret((String) null);
        this.f24912c = new TwitterFactory(configurationBuilder.build()).getInstance();
        f24910a = false;
        f24911b = null;
    }

    public boolean a() {
        if (TextUtils.isEmpty((CharSequence) bc.a().c().b(null))) {
            return false;
        }
        if (!f24910a) {
            this.f24912c.setOAuthAccessToken(new AccessToken((String) bc.a().c().b(null), (String) bc.a().b().b(null)));
            f24910a = true;
        }
        return true;
    }

    public void b() {
        c();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        try {
            b.a("ON_TWITTER_USERNAME", new a(this.f24912c.users().getAccountSettings().getScreenName()), b.a.NETWORK_BUS);
        } catch (TwitterException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void a(Context context) {
        b(context);
    }

    /* access modifiers changed from: package-private */
    public void b(Context context) {
        RequestToken requestToken = f24911b;
        if (requestToken != null) {
            a(context, requestToken);
            return;
        }
        try {
            f24911b = this.f24912c.getOAuthRequestToken();
        } catch (TwitterException e2) {
            e2.printStackTrace();
            f24911b = null;
        }
        RequestToken requestToken2 = f24911b;
        if (requestToken2 != null) {
            a(context, requestToken2);
        }
    }

    private void a(Context context, RequestToken requestToken) {
        TwitterAuthPage_.a(context).a(requestToken.getAuthorizationURL()).a(0);
    }

    public void a(Intent intent) {
        String stringExtra = intent.getStringExtra(AbTestingModule.KEY_RESULT);
        int indexOf = stringExtra.indexOf("oauth_token=");
        int indexOf2 = stringExtra.indexOf("oauth_verifier=");
        stringExtra.substring(indexOf + 12, indexOf2);
        String substring = stringExtra.substring(indexOf2 + 15);
        f24910a = true;
        a(substring);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        try {
            AccessToken oAuthAccessToken = this.f24912c.getOAuthAccessToken(f24911b, str);
            bc.a().c().a(oAuthAccessToken.getToken()).v();
            bc.a().b().a(oAuthAccessToken.getTokenSecret()).v();
            this.f24912c.setOAuthAccessToken(oAuthAccessToken);
            b.a("ON_TWITTER_USERNAME", new a(this.f24912c.users().getAccountSettings().getScreenName()), b.a.NETWORK_BUS);
            a(oAuthAccessToken);
        } catch (TwitterException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void d() {
        e();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        bc.a().c().a(null).v();
        bc.a().b().a(null).v();
        f.a().c().a(false).v();
        f();
    }

    /* access modifiers changed from: package-private */
    public void a(AccessToken accessToken) {
        bc.a().c().a(accessToken.getToken()).v();
        bc.a().b().a(accessToken.getTokenSecret()).v();
    }

    public void a(long j, final String str, String str2, Long l, String str3, String str4, ShareConfigStore shareConfigStore) {
        String a2 = m.a(j, str4);
        String valueOf = String.valueOf(l);
        String shareText = shareConfigStore.getShareText("twitter", false, true).getShareText();
        final String a3 = m.a(shareText, str2, str3, str4, a2, valueOf);
        int length = (a3.length() - a2.length()) + 22 + 23;
        if (length > 140) {
            int length2 = str2.length() - ((length - 140) + 3);
            String str5 = "...";
            if (length2 > 0) {
                str5 = str2.substring(0, length2) + str5;
            }
            a3 = m.a(shareText, str5, str3, str4, a2, valueOf);
        }
        if (com.shopee.app.h.b.a.a().a(str)) {
            a(a3, new File(com.shopee.app.h.f.a().b(str)));
        } else {
            com.shopee.app.h.b.a.a().a(str, str, new Runnable() {
                public void run() {
                    if (com.shopee.app.h.b.a.a().a(str)) {
                        e.this.a(a3, new File(com.shopee.app.h.f.a().b(str)));
                    }
                }
            }, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, File file) {
        try {
            StatusUpdate statusUpdate = new StatusUpdate(str);
            statusUpdate.setMedia(file);
            this.f24912c.updateStatus(statusUpdate);
        } catch (Exception e2) {
            e2.printStackTrace();
            e();
        }
    }
}
