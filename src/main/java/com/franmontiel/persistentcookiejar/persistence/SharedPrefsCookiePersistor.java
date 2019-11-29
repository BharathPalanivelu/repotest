package com.franmontiel.persistentcookiejar.persistence;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import java.util.Collection;
import okhttp3.Cookie;

@SuppressLint({"CommitPrefEdits"})
public class SharedPrefsCookiePersistor implements CookiePersistor {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f7276a;

    public void a(Collection<Cookie> collection) {
        SharedPreferences.Editor edit = this.f7276a.edit();
        for (Cookie next : collection) {
            edit.putString(a(next), new SerializableCookie().a(next));
        }
        edit.commit();
    }

    public void b(Collection<Cookie> collection) {
        SharedPreferences.Editor edit = this.f7276a.edit();
        for (Cookie a2 : collection) {
            edit.remove(a(a2));
        }
        edit.commit();
    }

    private static String a(Cookie cookie) {
        StringBuilder sb = new StringBuilder();
        sb.append(cookie.secure() ? "https" : "http");
        sb.append("://");
        sb.append(cookie.domain());
        sb.append(cookie.path());
        sb.append("|");
        sb.append(cookie.name());
        return sb.toString();
    }
}
