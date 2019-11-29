package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.b;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.tls.platform.SigType;

public final class o implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Intent> f1624a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f1625b;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private o(Context context) {
        this.f1625b = context;
    }

    public static o a(Context context) {
        return new o(context);
    }

    public o a(Intent intent) {
        this.f1624a.add(intent);
        return this;
    }

    public o a(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = g.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f1625b.getPackageManager());
            }
            a(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public o a(ComponentName componentName) {
        int size = this.f1624a.size();
        try {
            Intent a2 = g.a(this.f1625b, componentName);
            while (a2 != null) {
                this.f1624a.add(size, a2);
                a2 = g.a(this.f1625b, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1624a.iterator();
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (!this.f1624a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f1624a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!b.a(this.f1625b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(SigType.TLS);
                this.f1625b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
