package c.a.a.a;

import android.content.SharedPreferences;

public class d {

    /* renamed from: a  reason: collision with root package name */
    protected final SharedPreferences f3086a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f3087b;

    /* renamed from: c  reason: collision with root package name */
    protected final String f3088c;

    public d(SharedPreferences sharedPreferences, String str) {
        this(sharedPreferences, str, "");
    }

    public d(SharedPreferences sharedPreferences, String str, String str2) {
        this.f3086a = sharedPreferences;
        this.f3087b = str;
        this.f3088c = str2;
    }

    public String a() {
        return this.f3086a.getString(this.f3087b, this.f3088c);
    }

    public void a(String str) {
        this.f3086a.edit().putString(this.f3087b, str).apply();
    }
}
