package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.a;

public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f740a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f741b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f742c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f743d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f744e;

    public d() {
        super((Context) null);
    }

    public d(Context context, int i) {
        super(context);
        this.f740a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f741b = theme;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public Resources getResources() {
        return b();
    }

    private Resources b() {
        if (this.f744e == null) {
            if (this.f743d == null) {
                this.f744e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f744e = createConfigurationContext(this.f743d).getResources();
            }
        }
        return this.f744e;
    }

    public void setTheme(int i) {
        if (this.f740a != i) {
            this.f740a = i;
            c();
        }
    }

    public int a() {
        return this.f740a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f741b;
        if (theme != null) {
            return theme;
        }
        if (this.f740a == 0) {
            this.f740a = a.i.Theme_AppCompat_Light;
        }
        c();
        return this.f741b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f742c == null) {
            this.f742c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f742c;
    }

    /* access modifiers changed from: protected */
    public void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void c() {
        boolean z = this.f741b == null;
        if (z) {
            this.f741b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f741b.setTo(theme);
            }
        }
        a(this.f741b, this.f740a, z);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
