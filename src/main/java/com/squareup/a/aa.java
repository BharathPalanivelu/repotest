package com.squareup.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent;
import com.squareup.a.w;
import com.squareup.a.z;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f30497a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    private final w f30498b;

    /* renamed from: c  reason: collision with root package name */
    private final z.a f30499c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30500d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30501e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f30502f;

    /* renamed from: g  reason: collision with root package name */
    private int f30503g;
    private int h;
    private int i;
    private int j;
    private Drawable k;
    private Drawable l;
    private Object m;

    aa(w wVar, Uri uri, int i2) {
        this.f30502f = true;
        if (!wVar.m) {
            this.f30498b = wVar;
            this.f30499c = new z.a(uri, i2, wVar.j);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    aa() {
        this.f30502f = true;
        this.f30498b = null;
        this.f30499c = new z.a((Uri) null, 0, (Bitmap.Config) null);
    }

    public aa a(int i2) {
        if (!this.f30502f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i2 == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.k == null) {
            this.f30503g = i2;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public aa a(Drawable drawable) {
        if (!this.f30502f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (this.f30503g == 0) {
            this.k = drawable;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public aa b(int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.l == null) {
            this.h = i2;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public aa a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Tag invalid.");
        } else if (this.m == null) {
            this.m = obj;
            return this;
        } else {
            throw new IllegalStateException("Tag already set.");
        }
    }

    public aa a() {
        this.f30501e = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public aa b() {
        this.f30501e = false;
        return this;
    }

    /* access modifiers changed from: package-private */
    public aa c() {
        this.m = null;
        return this;
    }

    public aa a(int i2, int i3) {
        Resources resources = this.f30498b.f7155c.getResources();
        return b(resources.getDimensionPixelSize(i2), resources.getDimensionPixelSize(i3));
    }

    public aa b(int i2, int i3) {
        this.f30499c.a(i2, i3);
        return this;
    }

    public aa d() {
        this.f30499c.a(17);
        return this;
    }

    public aa c(int i2) {
        this.f30499c.a(i2);
        return this;
    }

    public aa e() {
        this.f30499c.d();
        return this;
    }

    public aa f() {
        this.f30499c.e();
        return this;
    }

    public aa a(float f2) {
        this.f30499c.a(f2);
        return this;
    }

    public aa a(Bitmap.Config config) {
        this.f30499c.a(config);
        return this;
    }

    public aa a(String str) {
        this.f30499c.a(str);
        return this;
    }

    public aa a(w.e eVar) {
        this.f30499c.a(eVar);
        return this;
    }

    public aa a(ah ahVar) {
        this.f30499c.a(ahVar);
        return this;
    }

    public aa a(r rVar, r... rVarArr) {
        if (rVar != null) {
            this.i = rVar.index | this.i;
            if (rVarArr != null) {
                if (rVarArr.length > 0) {
                    int length = rVarArr.length;
                    int i2 = 0;
                    while (i2 < length) {
                        r rVar2 = rVarArr[i2];
                        if (rVar2 != null) {
                            this.i = rVar2.index | this.i;
                            i2++;
                        } else {
                            throw new IllegalArgumentException("Memory policy cannot be null.");
                        }
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("Memory policy cannot be null.");
        }
        throw new IllegalArgumentException("Memory policy cannot be null.");
    }

    public aa g() {
        this.f30500d = true;
        return this;
    }

    public Bitmap h() throws IOException {
        long nanoTime = System.nanoTime();
        aj.a();
        if (this.f30501e) {
            throw new IllegalStateException("Fit cannot be used with get.");
        } else if (!this.f30499c.a()) {
            return null;
        } else {
            z a2 = a(nanoTime);
            m mVar = new m(this.f30498b, a2, this.i, this.j, this.m, aj.a(a2, new StringBuilder()));
            w wVar = this.f30498b;
            return c.a(wVar, wVar.f7156d, this.f30498b.f7157e, this.f30498b.f7158f, (a) mVar).a();
        }
    }

    public void i() {
        a((e) null);
    }

    public void a(e eVar) {
        long nanoTime = System.nanoTime();
        if (this.f30501e) {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        } else if (this.f30499c.a()) {
            if (!this.f30499c.c()) {
                this.f30499c.a(w.e.LOW);
            }
            z a2 = a(nanoTime);
            String a3 = aj.a(a2, new StringBuilder());
            if (!r.a(this.i) || this.f30498b.c(a3) == null) {
                this.f30498b.b((a) new k(this.f30498b, a2, this.i, this.j, this.m, a3, eVar));
                return;
            }
            if (this.f30498b.l) {
                String b2 = a2.b();
                aj.a("Main", ChatFileTransferEvent.COMPLETED, b2, "from " + w.d.MEMORY);
            }
            if (eVar != null) {
                eVar.c();
            }
        }
    }

    public void a(af afVar) {
        long nanoTime = System.nanoTime();
        aj.b();
        if (afVar == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f30501e) {
            Drawable drawable = null;
            if (!this.f30499c.a()) {
                this.f30498b.a(afVar);
                if (this.f30502f) {
                    drawable = j();
                }
                afVar.a(drawable);
                return;
            }
            z a2 = a(nanoTime);
            String a3 = aj.a(a2);
            if (r.a(this.i)) {
                Bitmap c2 = this.f30498b.c(a3);
                if (c2 != null) {
                    this.f30498b.a(afVar);
                    afVar.a(c2, w.d.MEMORY);
                    return;
                }
            }
            if (this.f30502f) {
                drawable = j();
            }
            afVar.a(drawable);
            this.f30498b.a((a) new ag(this.f30498b, afVar, a2, this.i, this.j, this.l, a3, this.m, this.h));
        } else {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
    }

    public void a(ImageView imageView) {
        a(imageView, (e) null);
    }

    public void a(ImageView imageView, e eVar) {
        ImageView imageView2 = imageView;
        e eVar2 = eVar;
        long nanoTime = System.nanoTime();
        aj.b();
        if (imageView2 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f30499c.a()) {
            this.f30498b.a(imageView2);
            if (this.f30502f) {
                x.a(imageView2, j());
            }
        } else {
            if (this.f30501e) {
                if (!this.f30499c.b()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width == 0 || height == 0 || imageView.isLayoutRequested()) {
                        if (this.f30502f) {
                            x.a(imageView2, j());
                        }
                        this.f30498b.a(imageView2, new h(this, imageView2, eVar2));
                        return;
                    }
                    this.f30499c.a(width, height);
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            z a2 = a(nanoTime);
            String a3 = aj.a(a2);
            if (r.a(this.i)) {
                Bitmap c2 = this.f30498b.c(a3);
                if (c2 != null) {
                    this.f30498b.a(imageView2);
                    x.a(imageView, this.f30498b.f7155c, c2, w.d.MEMORY, this.f30500d, this.f30498b.k);
                    if (this.f30498b.l) {
                        String b2 = a2.b();
                        aj.a("Main", ChatFileTransferEvent.COMPLETED, b2, "from " + w.d.MEMORY);
                    }
                    if (eVar2 != null) {
                        eVar.c();
                        return;
                    }
                    return;
                }
            }
            if (this.f30502f) {
                x.a(imageView2, j());
            }
            this.f30498b.a((a) new n(this.f30498b, imageView, a2, this.i, this.j, this.h, this.l, a3, this.m, eVar, this.f30500d));
        }
    }

    private Drawable j() {
        if (this.f30503g != 0) {
            return this.f30498b.f7155c.getResources().getDrawable(this.f30503g);
        }
        return this.k;
    }

    private z a(long j2) {
        int andIncrement = f30497a.getAndIncrement();
        z f2 = this.f30499c.f();
        f2.f30598a = andIncrement;
        f2.f30599b = j2;
        boolean z = this.f30498b.l;
        if (z) {
            aj.a("Main", "created", f2.b(), f2.toString());
        }
        z a2 = this.f30498b.a(f2);
        if (a2 != f2) {
            a2.f30598a = andIncrement;
            a2.f30599b = j2;
            if (z) {
                String a3 = a2.a();
                aj.a("Main", "changed", a3, "into " + a2);
            }
        }
        return a2;
    }
}
