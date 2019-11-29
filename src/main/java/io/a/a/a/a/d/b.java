package io.a.a.a.a.d;

import android.content.Context;
import com.tencent.ugc.TXRecordCommon;
import io.a.a.a.a.b.i;
import io.a.a.a.a.b.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f33150a;

    /* renamed from: b  reason: collision with root package name */
    protected final a<T> f33151b;

    /* renamed from: c  reason: collision with root package name */
    protected final k f33152c;

    /* renamed from: d  reason: collision with root package name */
    protected final c f33153d;

    /* renamed from: e  reason: collision with root package name */
    protected volatile long f33154e;

    /* renamed from: f  reason: collision with root package name */
    protected final List<d> f33155f = new CopyOnWriteArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final int f33156g;

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public int c() {
        return TXRecordCommon.AUDIO_SAMPLERATE_8000;
    }

    public b(Context context, a<T> aVar, k kVar, c cVar, int i) throws IOException {
        this.f33150a = context.getApplicationContext();
        this.f33151b = aVar;
        this.f33153d = cVar;
        this.f33152c = kVar;
        this.f33154e = this.f33152c.a();
        this.f33156g = i;
    }

    public void a(T t) throws IOException {
        byte[] a2 = this.f33151b.a(t);
        a(a2.length);
        this.f33153d.a(a2);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.f33155f.add(dVar);
        }
    }

    public boolean d() throws IOException {
        String str;
        boolean z = true;
        if (!this.f33153d.b()) {
            str = a();
            this.f33153d.a(str);
            i.a(this.f33150a, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.f33154e = this.f33152c.a();
        } else {
            str = null;
            z = false;
        }
        b(str);
        return z;
    }

    private void a(int i) throws IOException {
        if (!this.f33153d.a(i, c())) {
            i.a(this.f33150a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.f33153d.a()), Integer.valueOf(i), Integer.valueOf(c())}));
            d();
        }
    }

    /* access modifiers changed from: protected */
    public int b() {
        return this.f33156g;
    }

    private void b(String str) {
        for (d a2 : this.f33155f) {
            try {
                a2.a(str);
            } catch (Exception e2) {
                i.a(this.f33150a, "One of the roll over listeners threw an exception", (Throwable) e2);
            }
        }
    }

    public List<File> e() {
        return this.f33153d.a(1);
    }

    public void a(List<File> list) {
        this.f33153d.a(list);
    }

    public void f() {
        c cVar = this.f33153d;
        cVar.a(cVar.c());
        this.f33153d.d();
    }

    public void g() {
        List<File> c2 = this.f33153d.c();
        int b2 = b();
        if (c2.size() > b2) {
            int size = c2.size() - b2;
            i.a(this.f33150a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c2.size()), Integer.valueOf(b2), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new Comparator<a>() {
                /* renamed from: a */
                public int compare(a aVar, a aVar2) {
                    return (int) (aVar.f33159b - aVar2.f33159b);
                }
            });
            for (File next : c2) {
                treeSet.add(new a(next, a(next.getName())));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((a) it.next()).f33158a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.f33153d.a((List<File>) arrayList);
        }
    }

    public long a(String str) {
        String[] split = str.split("_");
        if (split.length != 3) {
            return 0;
        }
        try {
            return Long.valueOf(split[2]).longValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final File f33158a;

        /* renamed from: b  reason: collision with root package name */
        final long f33159b;

        public a(File file, long j) {
            this.f33158a = file;
            this.f33159b = j;
        }
    }
}
