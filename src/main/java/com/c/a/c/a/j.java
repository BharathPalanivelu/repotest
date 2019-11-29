package com.c.a.c.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.c.a.c.a;
import com.c.a.c.a.b;
import com.c.a.g;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class j<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f5672a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentResolver f5673b;

    /* renamed from: c  reason: collision with root package name */
    private T f5674c;

    /* access modifiers changed from: protected */
    public abstract void a(T t) throws IOException;

    /* access modifiers changed from: protected */
    public abstract T b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public void b() {
    }

    public j(ContentResolver contentResolver, Uri uri) {
        this.f5673b = contentResolver;
        this.f5672a = uri;
    }

    public final void a(g gVar, b.a<? super T> aVar) {
        try {
            this.f5674c = b(this.f5672a, this.f5673b);
            aVar.a(this.f5674c);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    public void a() {
        T t = this.f5674c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
        }
    }

    public a c() {
        return a.LOCAL;
    }
}
