package androidx.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.e;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.i;
import androidx.lifecycle.p;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.savedstate.c;

public class b extends e implements d, h, t, c {
    private int mContentLayoutId;
    private final i mLifecycleRegistry;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final androidx.savedstate.b mSavedStateRegistryController;
    private s mViewModelStore;

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        Object f537a;

        /* renamed from: b  reason: collision with root package name */
        s f538b;

        a() {
        }
    }

    public b() {
        this.mLifecycleRegistry = new i(this);
        this.mSavedStateRegistryController = androidx.savedstate.b.a((c) this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() {
            public void run() {
                b.super.onBackPressed();
            }
        });
        if (getLifecycle() != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getLifecycle().a(new ComponentActivity$2(this));
            }
            getLifecycle().a(new ComponentActivity$3(this));
            if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
                getLifecycle().a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public b(int i) {
        this();
        this.mContentLayoutId = i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSavedStateRegistryController.a(bundle);
        p.a((Activity) this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.e lifecycle = getLifecycle();
        if (lifecycle instanceof i) {
            ((i) lifecycle).b(e.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
    }

    public final Object onRetainNonConfigurationInstance() {
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        s sVar = this.mViewModelStore;
        if (sVar == null) {
            a aVar = (a) getLastNonConfigurationInstance();
            if (aVar != null) {
                sVar = aVar.f538b;
            }
        }
        if (sVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f537a = onRetainCustomNonConfigurationInstance;
        aVar2.f538b = sVar;
        return aVar2;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        a aVar = (a) getLastNonConfigurationInstance();
        if (aVar != null) {
            return aVar.f537a;
        }
        return null;
    }

    public androidx.lifecycle.e getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public s getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                a aVar = (a) getLastNonConfigurationInstance();
                if (aVar != null) {
                    this.mViewModelStore = aVar.f538b;
                }
                if (this.mViewModelStore == null) {
                    this.mViewModelStore = new s();
                }
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.a();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a();
    }
}
