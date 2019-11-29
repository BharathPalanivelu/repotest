package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final androidx.b.a<String, Method> f3041a;

    /* renamed from: b  reason: collision with root package name */
    protected final androidx.b.a<String, Method> f3042b;

    /* renamed from: c  reason: collision with root package name */
    protected final androidx.b.a<String, Class> f3043c;

    /* access modifiers changed from: protected */
    public abstract void a(int i);

    /* access modifiers changed from: protected */
    public abstract void a(Parcelable parcelable);

    /* access modifiers changed from: protected */
    public abstract void a(CharSequence charSequence);

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    /* access modifiers changed from: protected */
    public abstract void a(boolean z);

    public void a(boolean z, boolean z2) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr);

    public boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: protected */
    public abstract boolean b(int i);

    /* access modifiers changed from: protected */
    public abstract a c();

    /* access modifiers changed from: protected */
    public abstract void c(int i);

    /* access modifiers changed from: protected */
    public abstract int d();

    /* access modifiers changed from: protected */
    public abstract String e();

    /* access modifiers changed from: protected */
    public abstract byte[] f();

    /* access modifiers changed from: protected */
    public abstract CharSequence g();

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T h();

    /* access modifiers changed from: protected */
    public abstract boolean i();

    public a(androidx.b.a<String, Method> aVar, androidx.b.a<String, Method> aVar2, androidx.b.a<String, Class> aVar3) {
        this.f3041a = aVar;
        this.f3042b = aVar2;
        this.f3043c = aVar3;
    }

    public void a(boolean z, int i) {
        c(i);
        a(z);
    }

    public void a(byte[] bArr, int i) {
        c(i);
        a(bArr);
    }

    public void a(CharSequence charSequence, int i) {
        c(i);
        a(charSequence);
    }

    public void a(int i, int i2) {
        c(i2);
        a(i);
    }

    public void a(String str, int i) {
        c(i);
        a(str);
    }

    public void a(Parcelable parcelable, int i) {
        c(i);
        a(parcelable);
    }

    public boolean b(boolean z, int i) {
        if (!b(i)) {
            return z;
        }
        return i();
    }

    public int b(int i, int i2) {
        if (!b(i2)) {
            return i;
        }
        return d();
    }

    public String b(String str, int i) {
        if (!b(i)) {
            return str;
        }
        return e();
    }

    public byte[] b(byte[] bArr, int i) {
        if (!b(i)) {
            return bArr;
        }
        return f();
    }

    public <T extends Parcelable> T b(T t, int i) {
        if (!b(i)) {
            return t;
        }
        return h();
    }

    public CharSequence b(CharSequence charSequence, int i) {
        if (!b(i)) {
            return charSequence;
        }
        return g();
    }

    public void a(c cVar, int i) {
        c(i);
        a(cVar);
    }

    /* access modifiers changed from: protected */
    public void a(c cVar) {
        if (cVar == null) {
            a((String) null);
            return;
        }
        b(cVar);
        a c2 = c();
        a(cVar, c2);
        c2.b();
    }

    private void b(c cVar) {
        try {
            a(b((Class<? extends c>) cVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    public <T extends c> T b(T t, int i) {
        if (!b(i)) {
            return t;
        }
        return j();
    }

    /* access modifiers changed from: protected */
    public <T extends c> T j() {
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        return a(e2, c());
    }

    /* access modifiers changed from: protected */
    public <T extends c> T a(String str, a aVar) {
        try {
            return (c) b(str).invoke((Object) null, new Object[]{aVar});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    /* access modifiers changed from: protected */
    public <T extends c> void a(T t, a aVar) {
        try {
            a((Class) t.getClass()).invoke((Object) null, new Object[]{t, aVar});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    private Method b(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f3041a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[]{a.class});
        this.f3041a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method a(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f3042b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class b2 = b((Class<? extends c>) cls);
        System.currentTimeMillis();
        Method declaredMethod = b2.getDeclaredMethod("write", new Class[]{cls, a.class});
        this.f3042b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private Class b(Class<? extends c> cls) throws ClassNotFoundException {
        Class cls2 = this.f3043c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f3043c.put(cls.getName(), cls3);
        return cls3;
    }
}
