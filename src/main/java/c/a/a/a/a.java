package c.a.a.a;

import android.content.SharedPreferences;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected final SharedPreferences f3077a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f3078b;

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f3079c;

    public a(SharedPreferences sharedPreferences, String str) {
        this(sharedPreferences, str, false);
    }

    public a(SharedPreferences sharedPreferences, String str, boolean z) {
        this.f3077a = sharedPreferences;
        this.f3078b = str;
        this.f3079c = z;
    }

    public boolean a() {
        return this.f3077a.getBoolean(this.f3078b, this.f3079c);
    }

    public void a(boolean z) {
        this.f3077a.edit().putBoolean(this.f3078b, z).apply();
    }
}
