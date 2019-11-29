package androidx.core.app;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.Set;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f1617a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f1618b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence[] f1619c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1620d;

    /* renamed from: e  reason: collision with root package name */
    private final Bundle f1621e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<String> f1622f;

    public String a() {
        return this.f1617a;
    }

    public CharSequence b() {
        return this.f1618b;
    }

    public CharSequence[] c() {
        return this.f1619c;
    }

    public Set<String> d() {
        return this.f1622f;
    }

    public boolean e() {
        return this.f1620d;
    }

    public Bundle f() {
        return this.f1621e;
    }

    static RemoteInput[] a(m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[mVarArr.length];
        for (int i = 0; i < mVarArr.length; i++) {
            remoteInputArr[i] = a(mVarArr[i]);
        }
        return remoteInputArr;
    }

    static RemoteInput a(m mVar) {
        return new RemoteInput.Builder(mVar.a()).setLabel(mVar.b()).setChoices(mVar.c()).setAllowFreeFormInput(mVar.e()).addExtras(mVar.f()).build();
    }
}
