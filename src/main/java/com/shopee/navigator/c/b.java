package com.shopee.navigator.c;

import android.app.Activity;
import android.content.Intent;
import com.google.a.o;
import com.shopee.navigator.c;
import com.shopee.navigator.c.a.a;

public abstract class b {
    public o a(Activity activity, a aVar, o oVar) {
        return oVar;
    }

    public abstract a a();

    public void a(Activity activity, a aVar, o oVar, boolean z, boolean z2) {
    }

    public abstract Class<? extends Activity> b();

    public Class<? extends Activity> d() {
        return null;
    }

    public boolean e() {
        return false;
    }

    public Intent a(Activity activity, a aVar, o oVar, boolean z) {
        return new c.a(activity, (!z || d() == null) ? b() : d()).a(a(activity, aVar, oVar)).a().i();
    }
}
