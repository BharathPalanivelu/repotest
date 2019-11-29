package com.c.a.c.c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.c.a.c.a.b;
import com.c.a.c.c.n;
import com.c.a.c.j;
import com.c.a.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import tencent.tls.platform.SigType;

public class f<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final d<Data> f5917a;

    public interface d<Data> {
        Class<Data> a();

        void a(Data data) throws IOException;

        Data b(File file) throws FileNotFoundException;
    }

    public boolean a(File file) {
        return true;
    }

    public f(d<Data> dVar) {
        this.f5917a = dVar;
    }

    public n.a<Data> a(File file, int i, int i2, j jVar) {
        return new n.a<>(new com.c.a.h.b(file), new c(file, this.f5917a));
    }

    private static class c<Data> implements com.c.a.c.a.b<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final File f5919a;

        /* renamed from: b  reason: collision with root package name */
        private final d<Data> f5920b;

        /* renamed from: c  reason: collision with root package name */
        private Data f5921c;

        public void b() {
        }

        public c(File file, d<Data> dVar) {
            this.f5919a = file;
            this.f5920b = dVar;
        }

        public void a(g gVar, b.a<? super Data> aVar) {
            try {
                this.f5921c = this.f5920b.b(this.f5919a);
                aVar.a(this.f5921c);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        public void a() {
            Data data = this.f5921c;
            if (data != null) {
                try {
                    this.f5920b.a(data);
                } catch (IOException unused) {
                }
            }
        }

        public Class<Data> d() {
            return this.f5920b.a();
        }

        public com.c.a.c.a c() {
            return com.c.a.c.a.LOCAL;
        }
    }

    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final d<Data> f5918a;

        public a(d<Data> dVar) {
            this.f5918a = dVar;
        }

        public final n<File, Data> a(r rVar) {
            return new f(this.f5918a);
        }
    }

    public static class e extends a<InputStream> {
        public e() {
            super(new d<InputStream>() {
                /* renamed from: a */
                public InputStream b(File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }

                public void a(InputStream inputStream) throws IOException {
                    inputStream.close();
                }

                public Class<InputStream> a() {
                    return InputStream.class;
                }
            });
        }
    }

    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new d<ParcelFileDescriptor>() {
                /* renamed from: a */
                public ParcelFileDescriptor b(File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, SigType.TLS);
                }

                public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }

                public Class<ParcelFileDescriptor> a() {
                    return ParcelFileDescriptor.class;
                }
            });
        }
    }
}
