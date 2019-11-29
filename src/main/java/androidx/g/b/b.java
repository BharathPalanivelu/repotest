package androidx.g.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.a;
import androidx.g.b.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class b extends a<Cursor> {

    /* renamed from: f  reason: collision with root package name */
    final c<Cursor>.a f2317f = new c.a();

    /* renamed from: g  reason: collision with root package name */
    Uri f2318g;
    String[] h;
    String i;
    String[] j;
    String k;
    Cursor l;
    androidx.core.d.b m;

    /* renamed from: h */
    public Cursor d() {
        Cursor a2;
        synchronized (this) {
            if (!g()) {
                this.m = new androidx.core.d.b();
            } else {
                throw new androidx.core.d.c();
            }
        }
        try {
            a2 = a.a(m().getContentResolver(), this.f2318g, this.h, this.i, this.j, this.k, this.m);
            if (a2 != null) {
                a2.getCount();
                a2.registerContentObserver(this.f2317f);
            }
            synchronized (this) {
                this.m = null;
            }
            return a2;
        } catch (RuntimeException e2) {
            a2.close();
            throw e2;
        } catch (Throwable th) {
            synchronized (this) {
                this.m = null;
                throw th;
            }
        }
    }

    public void f() {
        super.f();
        synchronized (this) {
            if (this.m != null) {
                this.m.c();
            }
        }
    }

    /* renamed from: a */
    public void b(Cursor cursor) {
        if (!p()) {
            Cursor cursor2 = this.l;
            this.l = cursor;
            if (n()) {
                super.b(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public b(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f2318g = uri;
        this.h = strArr;
        this.i = str;
        this.j = strArr2;
        this.k = str2;
    }

    /* access modifiers changed from: protected */
    public void i() {
        Cursor cursor = this.l;
        if (cursor != null) {
            b(cursor);
        }
        if (x() || this.l == null) {
            s();
        }
    }

    /* access modifiers changed from: protected */
    public void j() {
        r();
    }

    /* renamed from: b */
    public void a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        super.k();
        j();
        Cursor cursor = this.l;
        if (cursor != null && !cursor.isClosed()) {
            this.l.close();
        }
        this.l = null;
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f2318g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.u);
    }
}
