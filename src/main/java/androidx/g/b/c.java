package androidx.g.b;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class c<D> {
    int n;
    C0052c<D> o;
    b<D> p;
    Context q;
    boolean r = false;
    boolean s = false;
    boolean t = true;
    boolean u = false;
    boolean v = false;

    public interface b<D> {
        void a(c<D> cVar);
    }

    /* renamed from: androidx.g.b.c$c  reason: collision with other inner class name */
    public interface C0052c<D> {
        void a(c<D> cVar, D d2);
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public void v() {
    }

    public final class a extends ContentObserver {
        public boolean deliverSelfNotifications() {
            return true;
        }

        public a() {
            super(new Handler());
        }

        public void onChange(boolean z) {
            c.this.A();
        }
    }

    public c(Context context) {
        this.q = context.getApplicationContext();
    }

    public void b(D d2) {
        C0052c<D> cVar = this.o;
        if (cVar != null) {
            cVar.a(this, d2);
        }
    }

    public void l() {
        b<D> bVar = this.p;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public Context m() {
        return this.q;
    }

    public void a(int i, C0052c<D> cVar) {
        if (this.o == null) {
            this.o = cVar;
            this.n = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void a(C0052c<D> cVar) {
        C0052c<D> cVar2 = this.o;
        if (cVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (cVar2 == cVar) {
            this.o = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public boolean n() {
        return this.r;
    }

    public boolean o() {
        return this.s;
    }

    public boolean p() {
        return this.t;
    }

    public final void q() {
        this.r = true;
        this.t = false;
        this.s = false;
        i();
    }

    public boolean r() {
        return b();
    }

    public void s() {
        a();
    }

    public void t() {
        this.r = false;
        j();
    }

    public void u() {
        this.s = true;
        v();
    }

    public void w() {
        k();
        this.t = true;
        this.r = false;
        this.s = false;
        this.u = false;
        this.v = false;
    }

    public boolean x() {
        boolean z = this.u;
        this.u = false;
        this.v |= z;
        return z;
    }

    public void y() {
        this.v = false;
    }

    public void z() {
        if (this.v) {
            A();
        }
    }

    public void A() {
        if (this.r) {
            s();
        } else {
            this.u = true;
        }
    }

    public String c(D d2) {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.util.a.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.util.a.a(this, sb);
        sb.append(" id=");
        sb.append(this.n);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.n);
        printWriter.print(" mListener=");
        printWriter.println(this.o);
        if (this.r || this.u || this.v) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.r);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.u);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.v);
        }
        if (this.s || this.t) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.s);
            printWriter.print(" mReset=");
            printWriter.println(this.t);
        }
    }
}
