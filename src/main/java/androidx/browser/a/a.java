package androidx.browser.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.d;
import androidx.core.content.b;
import java.util.ArrayList;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f1316a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f1317b;

    public void a(Context context, Uri uri) {
        this.f1316a.setData(uri);
        b.a(context, this.f1316a, this.f1317b);
    }

    a(Intent intent, Bundle bundle) {
        this.f1316a = intent;
        this.f1317b = bundle;
    }

    /* renamed from: androidx.browser.a.a$a  reason: collision with other inner class name */
    public static final class C0023a {

        /* renamed from: a  reason: collision with root package name */
        private final Intent f1318a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<Bundle> f1319b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f1320c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<Bundle> f1321d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1322e;

        public C0023a() {
            this((b) null);
        }

        public C0023a(b bVar) {
            this.f1318a = new Intent("android.intent.action.VIEW");
            IBinder iBinder = null;
            this.f1319b = null;
            this.f1320c = null;
            this.f1321d = null;
            this.f1322e = true;
            if (bVar != null) {
                this.f1318a.setPackage(bVar.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            d.a(bundle, "android.support.customtabs.extra.SESSION", bVar != null ? bVar.a() : iBinder);
            this.f1318a.putExtras(bundle);
        }

        public C0023a a(int i) {
            this.f1318a.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", i);
            return this;
        }

        public a a() {
            ArrayList<Bundle> arrayList = this.f1319b;
            if (arrayList != null) {
                this.f1318a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f1321d;
            if (arrayList2 != null) {
                this.f1318a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f1318a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f1322e);
            return new a(this.f1318a, this.f1320c);
        }
    }
}
