package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.a;
import androidx.core.util.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class g<E> extends d {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f2169a;

    /* renamed from: b  reason: collision with root package name */
    final i f2170b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f2171c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f2172d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2173e;

    public View a(int i) {
        return null;
    }

    public void a(Fragment fragment, String[] strArr, int i) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a() {
        return true;
    }

    public boolean a(Fragment fragment) {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment) {
    }

    public void d() {
    }

    public boolean e() {
        return true;
    }

    public abstract E g();

    g(c cVar) {
        this(cVar, cVar, new Handler(), 0);
    }

    g(Activity activity, Context context, Handler handler, int i) {
        this.f2170b = new i();
        this.f2169a = activity;
        this.f2171c = (Context) e.a(context, (Object) "context == null");
        this.f2172d = (Handler) e.a(handler, (Object) "handler == null");
        this.f2173e = i;
    }

    public LayoutInflater b() {
        return LayoutInflater.from(this.f2171c);
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            this.f2171c.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            a.a(this.f2169a, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    public int f() {
        return this.f2173e;
    }

    /* access modifiers changed from: package-private */
    public Activity h() {
        return this.f2169a;
    }

    /* access modifiers changed from: package-private */
    public Context i() {
        return this.f2171c;
    }

    /* access modifiers changed from: package-private */
    public Handler j() {
        return this.f2172d;
    }
}
