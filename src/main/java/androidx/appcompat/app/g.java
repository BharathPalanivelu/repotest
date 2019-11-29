package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.b;
import androidx.core.g.e;

public class g extends Dialog implements e {

    /* renamed from: a  reason: collision with root package name */
    private f f645a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a f646b = new e.a() {
        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.a(keyEvent);
        }
    };

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public g(Context context, int i) {
        super(context, a(context, i));
        f b2 = b();
        b2.a(a(context, i));
        b2.a((Bundle) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        b().i();
        super.onCreate(bundle);
        b().a(bundle);
    }

    public void setContentView(int i) {
        b().c(i);
    }

    public void setContentView(View view) {
        b().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b().a(view, layoutParams);
    }

    public <T extends View> T findViewById(int i) {
        return b().b(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        b().a(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        b().a((CharSequence) getContext().getString(i));
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b().b(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        b().d();
    }

    public boolean a(int i) {
        return b().d(i);
    }

    public void invalidateOptionsMenu() {
        b().f();
    }

    public f b() {
        if (this.f645a == null) {
            this.f645a = f.a((Dialog) this, (e) this);
        }
        return this.f645a;
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0012a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: package-private */
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return e.a(this.f646b, getWindow().getDecorView(), this, keyEvent);
    }
}
