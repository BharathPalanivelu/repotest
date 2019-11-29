package io.a.a.a.a.d;

import android.content.Context;
import io.a.a.a.a.b.i;
import io.a.a.a.a.b.r;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class h implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f33160a;

    /* renamed from: b  reason: collision with root package name */
    private final File f33161b;

    /* renamed from: c  reason: collision with root package name */
    private final String f33162c;

    /* renamed from: d  reason: collision with root package name */
    private final File f33163d;

    /* renamed from: e  reason: collision with root package name */
    private r f33164e = new r(this.f33163d);

    /* renamed from: f  reason: collision with root package name */
    private File f33165f;

    public h(Context context, File file, String str, String str2) throws IOException {
        this.f33160a = context;
        this.f33161b = file;
        this.f33162c = str2;
        this.f33163d = new File(this.f33161b, str);
        e();
    }

    private void e() {
        this.f33165f = new File(this.f33161b, this.f33162c);
        if (!this.f33165f.exists()) {
            this.f33165f.mkdirs();
        }
    }

    public void a(byte[] bArr) throws IOException {
        this.f33164e.a(bArr);
    }

    public int a() {
        return this.f33164e.a();
    }

    public void a(String str) throws IOException {
        this.f33164e.close();
        a(this.f33163d, new File(this.f33165f, str));
        this.f33164e = new r(this.f33163d);
    }

    private void a(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                outputStream = a(file2);
                i.a((InputStream) fileInputStream, outputStream, new byte[1024]);
                i.a((Closeable) fileInputStream, "Failed to close file input stream");
                i.a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
            } catch (Throwable th) {
                th = th;
                i.a((Closeable) fileInputStream, "Failed to close file input stream");
                i.a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            i.a((Closeable) fileInputStream, "Failed to close file input stream");
            i.a((Closeable) outputStream, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream a(File file) throws IOException {
        return new FileOutputStream(file);
    }

    public List<File> a(int i) {
        ArrayList arrayList = new ArrayList();
        for (File add : this.f33165f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    public void a(List<File> list) {
        for (File next : list) {
            i.a(this.f33160a, String.format("deleting sent analytics file %s", new Object[]{next.getName()}));
            next.delete();
        }
    }

    public List<File> c() {
        return Arrays.asList(this.f33165f.listFiles());
    }

    public void d() {
        try {
            this.f33164e.close();
        } catch (IOException unused) {
        }
        this.f33163d.delete();
    }

    public boolean b() {
        return this.f33164e.b();
    }

    public boolean a(int i, int i2) {
        return this.f33164e.a(i, i2);
    }
}
