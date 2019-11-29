package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ao extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1140a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<WeakReference<ao>> f1141b;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f1142c;

    /* renamed from: d  reason: collision with root package name */
    private final Resources.Theme f1143d;

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (f1140a) {
            if (f1141b == null) {
                f1141b = new ArrayList<>();
            } else {
                for (int size = f1141b.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f1141b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1141b.remove(size);
                    }
                }
                for (int size2 = f1141b.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f1141b.get(size2);
                    ao aoVar = weakReference2 != null ? (ao) weakReference2.get() : null;
                    if (aoVar != null && aoVar.getBaseContext() == context) {
                        return aoVar;
                    }
                }
            }
            ao aoVar2 = new ao(context);
            f1141b.add(new WeakReference(aoVar2));
            return aoVar2;
        }
    }

    private static boolean b(Context context) {
        if ((context instanceof ao) || (context.getResources() instanceof aq) || (context.getResources() instanceof aw)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21 || aw.a()) {
            return true;
        }
        return false;
    }

    private ao(Context context) {
        super(context);
        if (aw.a()) {
            this.f1142c = new aw(this, context.getResources());
            this.f1143d = this.f1142c.newTheme();
            this.f1143d.setTo(context.getTheme());
            return;
        }
        this.f1142c = new aq(this, context.getResources());
        this.f1143d = null;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1143d;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i) {
        Resources.Theme theme = this.f1143d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }

    public Resources getResources() {
        return this.f1142c;
    }

    public AssetManager getAssets() {
        return this.f1142c.getAssets();
    }
}
