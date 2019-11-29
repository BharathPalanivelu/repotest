package androidx.i;

import android.app.Application;
import android.content.Context;

public class b extends Application {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }
}
