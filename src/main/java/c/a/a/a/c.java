package c.a.a.a;

import android.content.SharedPreferences;

public class c {

    /* renamed from: a  reason: collision with root package name */
    protected final SharedPreferences f3083a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f3084b;

    /* renamed from: c  reason: collision with root package name */
    protected final long f3085c;

    public c(SharedPreferences sharedPreferences, String str) {
        this(sharedPreferences, str, 0);
    }

    public c(SharedPreferences sharedPreferences, String str, long j) {
        this.f3083a = sharedPreferences;
        this.f3084b = str;
        this.f3085c = j;
    }

    public long a() {
        return this.f3083a.getLong(this.f3084b, this.f3085c);
    }

    public void a(long j) {
        this.f3083a.edit().putLong(this.f3084b, j).apply();
    }
}
