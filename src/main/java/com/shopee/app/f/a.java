package com.shopee.app.f;

import android.app.Activity;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.shopee.app.data.store.f;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f6964b;

    /* renamed from: a  reason: collision with root package name */
    List<String> f6965a = Arrays.asList(new String[]{"email", "user_birthday", "user_friends"});

    public static a a() {
        if (f6964b == null) {
            synchronized (a.class) {
                if (f6964b == null) {
                    f6964b = new a();
                }
            }
        }
        return f6964b;
    }

    private a() {
    }

    public boolean b() {
        return AccessToken.getCurrentAccessToken() != null;
    }

    public boolean c() {
        return AccessToken.getCurrentAccessToken() != null && AccessToken.getCurrentAccessToken().getPermissions().contains("publish_pages") && AccessToken.getCurrentAccessToken().getPermissions().contains("manage_pages");
    }

    public void a(Activity activity) {
        LoginManager.getInstance().logInWithReadPermissions(activity, (Collection<String>) this.f6965a);
    }

    public void b(Activity activity) {
        LoginManager.getInstance().logInWithPublishPermissions(activity, (Collection<String>) Arrays.asList(new String[]{"publish_pages", "manage_pages"}));
    }

    public String d() {
        if (AccessToken.getCurrentAccessToken() != null) {
            return AccessToken.getCurrentAccessToken().getToken();
        }
        return null;
    }

    public void e() {
        LoginManager.getInstance().logOut();
    }

    public void f() {
        e();
        f.a().b().a(false).v();
    }
}
