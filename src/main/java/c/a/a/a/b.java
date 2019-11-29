package c.a.a.a;

import android.content.SharedPreferences;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected final SharedPreferences f3080a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f3081b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f3082c;

    public b(SharedPreferences sharedPreferences, String str) {
        this(sharedPreferences, str, 0);
    }

    public b(SharedPreferences sharedPreferences, String str, int i) {
        this.f3080a = sharedPreferences;
        this.f3081b = str;
        this.f3082c = i;
    }

    public int a() {
        return this.f3080a.getInt(this.f3081b, this.f3082c);
    }

    public void a(int i) {
        this.f3080a.edit().putInt(this.f3081b, i).apply();
    }
}
