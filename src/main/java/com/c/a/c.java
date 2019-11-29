package com.c.a;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.c.a.c.a.c;
import com.c.a.c.a.i;
import com.c.a.c.b.a.b;
import com.c.a.c.b.a.e;
import com.c.a.c.b.b.h;
import com.c.a.c.b.d.a;
import com.c.a.c.b.i;
import com.c.a.c.c.a;
import com.c.a.c.c.a.a;
import com.c.a.c.c.a.b;
import com.c.a.c.c.a.c;
import com.c.a.c.c.a.d;
import com.c.a.c.c.a.e;
import com.c.a.c.c.b;
import com.c.a.c.c.d;
import com.c.a.c.c.e;
import com.c.a.c.c.f;
import com.c.a.c.c.k;
import com.c.a.c.c.s;
import com.c.a.c.c.t;
import com.c.a.c.c.u;
import com.c.a.c.c.v;
import com.c.a.c.c.w;
import com.c.a.c.c.x;
import com.c.a.c.d.a.n;
import com.c.a.c.d.a.o;
import com.c.a.c.d.a.q;
import com.c.a.c.d.a.r;
import com.c.a.c.d.b.a;
import com.c.a.c.d.e.j;
import com.c.a.c.f;
import com.c.a.d.d;
import com.c.a.d.l;
import com.c.a.g.g;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TargetApi(14)
public class c implements ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f5632a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f5633b;

    /* renamed from: c  reason: collision with root package name */
    private final i f5634c;

    /* renamed from: d  reason: collision with root package name */
    private final e f5635d;

    /* renamed from: e  reason: collision with root package name */
    private final h f5636e;

    /* renamed from: f  reason: collision with root package name */
    private final a f5637f;

    /* renamed from: g  reason: collision with root package name */
    private final e f5638g;
    private final h h;
    private final b i;
    private final l j;
    private final d k;
    private final List<j> l = new ArrayList();
    private f m = f.NORMAL;

    public void onConfigurationChanged(Configuration configuration) {
    }

    public static c a(Context context) {
        if (f5632a == null) {
            synchronized (c.class) {
                if (f5632a == null) {
                    c(context);
                }
            }
        }
        return f5632a;
    }

    private static void c(Context context) {
        if (!f5633b) {
            f5633b = true;
            d(context);
            f5633b = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    private static void d(Context context) {
        Context applicationContext = context.getApplicationContext();
        a i2 = i();
        List<com.c.a.e.c> emptyList = Collections.emptyList();
        if (i2 == null || i2.c()) {
            emptyList = new com.c.a.e.e(applicationContext).a();
        }
        if (i2 != null && !i2.a().isEmpty()) {
            Set<Class<?>> a2 = i2.a();
            Iterator<com.c.a.e.c> it = emptyList.iterator();
            while (it.hasNext()) {
                com.c.a.e.c next = it.next();
                if (a2.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (com.c.a.e.c cVar : emptyList) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + cVar.getClass());
            }
        }
        d a3 = new d().a(i2 != null ? i2.b() : null);
        for (com.c.a.e.c a4 : emptyList) {
            a4.a(applicationContext, a3);
        }
        if (i2 != null) {
            i2.a(applicationContext, a3);
        }
        c a5 = a3.a(applicationContext);
        for (com.c.a.e.c a6 : emptyList) {
            a6.a(applicationContext, a5, a5.h);
        }
        if (i2 != null) {
            i2.a(applicationContext, a5, a5.h);
        }
        context.getApplicationContext().registerComponentCallbacks(a5);
        f5632a = a5;
    }

    private static a i() {
        try {
            return (a) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").newInstance();
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (InstantiationException e2) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e3);
        }
    }

    @TargetApi(14)
    c(Context context, i iVar, h hVar, e eVar, b bVar, l lVar, d dVar, int i2, g gVar, Map<Class<?>, k<?, ?>> map) {
        Context context2 = context;
        h hVar2 = hVar;
        e eVar2 = eVar;
        b bVar2 = bVar;
        this.f5634c = iVar;
        this.f5635d = eVar2;
        this.i = bVar2;
        this.f5636e = hVar2;
        this.j = lVar;
        this.k = dVar;
        this.f5637f = new a(hVar2, eVar2, (com.c.a.c.b) gVar.f().a(com.c.a.c.d.a.h.f6012a));
        Resources resources = context.getResources();
        this.h = new h();
        this.h.a((f) new com.c.a.c.d.a.f());
        com.c.a.c.d.a.h hVar3 = new com.c.a.c.d.a.h(this.h.a(), resources.getDisplayMetrics(), eVar2, bVar2);
        com.c.a.c.d.e.a aVar = new com.c.a.c.d.e.a(context2, this.h.a(), eVar2, bVar2);
        r rVar = new r(eVar2);
        com.c.a.c.d.a.e eVar3 = new com.c.a.c.d.a.e(hVar3);
        o oVar = new o(hVar3, bVar2);
        com.c.a.c.d.c.d dVar2 = new com.c.a.c.d.c.d(context2);
        s.b bVar3 = new s.b(resources);
        s.c cVar = new s.c(resources);
        s.a aVar2 = new s.a(resources);
        com.c.a.c.d.a.c cVar2 = new com.c.a.c.d.a.c();
        s.a aVar3 = aVar2;
        s.c cVar3 = cVar;
        Context context3 = context;
        this.h.a(ByteBuffer.class, new com.c.a.c.c.c()).a(InputStream.class, new t(bVar2)).a("Bitmap", ByteBuffer.class, Bitmap.class, eVar3).a("Bitmap", InputStream.class, Bitmap.class, oVar).a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, rVar).a("Bitmap", Bitmap.class, Bitmap.class, new q()).a(Bitmap.class, Bitmap.class, v.a.a()).a(Bitmap.class, cVar2).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.c.a.c.d.a.a(resources, eVar2, eVar3)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.c.a.c.d.a.a(resources, eVar2, oVar)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.c.a.c.d.a.a(resources, eVar2, rVar)).a(BitmapDrawable.class, new com.c.a.c.d.a.b(eVar2, cVar2)).a("Gif", InputStream.class, com.c.a.c.d.e.c.class, new j(this.h.a(), aVar, bVar2)).a("Gif", ByteBuffer.class, com.c.a.c.d.e.c.class, aVar).a(com.c.a.c.d.e.c.class, new com.c.a.c.d.e.d()).a(com.c.a.b.a.class, com.c.a.b.a.class, v.a.a()).a("Bitmap", com.c.a.b.a.class, Bitmap.class, new com.c.a.c.d.e.h(eVar2)).a(Uri.class, Drawable.class, dVar2).a(Uri.class, Bitmap.class, new n(dVar2, eVar2)).a((c.a) new a.C0107a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new com.c.a.c.d.d.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.a()).a((c.a) new i.a(bVar2)).a(Integer.TYPE, InputStream.class, bVar3).a(Integer.TYPE, ParcelFileDescriptor.class, aVar3).a(Integer.class, InputStream.class, bVar3).a(Integer.class, ParcelFileDescriptor.class, aVar3).a(Integer.class, Uri.class, cVar3).a(Integer.TYPE, Uri.class, cVar3).a(String.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.b()).a(String.class, ParcelFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new b.a()).a(Uri.class, InputStream.class, new a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).a(Uri.class, InputStream.class, new c.a(context3)).a(Uri.class, InputStream.class, new d.a(context3)).a(Uri.class, InputStream.class, new w.c(context.getContentResolver())).a(Uri.class, ParcelFileDescriptor.class, new w.a(context.getContentResolver())).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new e.a()).a(Uri.class, File.class, new k.a(context3)).a(com.c.a.c.c.g.class, InputStream.class, new a.C0103a()).a(byte[].class, ByteBuffer.class, new b.a()).a(byte[].class, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.a()).a(Drawable.class, Drawable.class, v.a.a()).a(Drawable.class, Drawable.class, new com.c.a.c.d.c.e()).a(Bitmap.class, BitmapDrawable.class, new com.c.a.c.d.f.b(resources, eVar2)).a(Bitmap.class, byte[].class, new com.c.a.c.d.f.a()).a(com.c.a.c.d.e.c.class, byte[].class, new com.c.a.c.d.f.c());
        Context context4 = context;
        this.f5638g = new e(context4, this.h, new com.c.a.g.a.b(), gVar, map, iVar, i2);
    }

    public com.c.a.c.b.a.e a() {
        return this.f5635d;
    }

    public com.c.a.c.b.a.b b() {
        return this.i;
    }

    public Context c() {
        return this.f5638g.getBaseContext();
    }

    /* access modifiers changed from: package-private */
    public com.c.a.d.d d() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public e e() {
        return this.f5638g;
    }

    public void f() {
        com.c.a.i.i.a();
        this.f5636e.a();
        this.f5635d.a();
        this.i.a();
    }

    public void a(int i2) {
        com.c.a.i.i.a();
        this.f5636e.a(i2);
        this.f5635d.a(i2);
        this.i.a(i2);
    }

    public l g() {
        return this.j;
    }

    private static l e(Context context) {
        com.c.a.i.h.a(context, "You cannot start a load on a not yet attached View or a  Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).g();
    }

    public static j b(Context context) {
        return e(context).a(context);
    }

    public h h() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public void a(com.c.a.g.a.e<?> eVar) {
        synchronized (this.l) {
            for (j b2 : this.l) {
                if (b2.b(eVar)) {
                    return;
                }
            }
            throw new IllegalStateException("Failed to remove target from managers");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(j jVar) {
        synchronized (this.l) {
            if (!this.l.contains(jVar)) {
                this.l.add(jVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(j jVar) {
        synchronized (this.l) {
            if (this.l.contains(jVar)) {
                this.l.remove(jVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public void onTrimMemory(int i2) {
        a(i2);
    }

    public void onLowMemory() {
        f();
    }
}
