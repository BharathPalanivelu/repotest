package com.garena.reactpush.c;

import com.garena.reactpush.c.b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class h implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final b.a f8360a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8361b;

    /* renamed from: c  reason: collision with root package name */
    private b f8362c;

    public h(OkHttpClient okHttpClient, String str, String str2, String str3, b.a aVar) {
        this.f8362c = new b(okHttpClient, str, str3, this);
        this.f8361b = str2;
        this.f8360a = aVar;
    }

    public void a() {
        this.f8362c.a();
    }

    public void a(Call call, Exception exc) {
        this.f8360a.a(call, exc);
    }

    public void a(File file) {
        try {
            a(file.getPath(), this.f8361b);
            this.f8360a.a(file);
        } catch (IOException e2) {
            this.f8360a.a((Call) null, e2);
        }
    }

    private void a(String str, String str2) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
        byte[] bArr = new byte[1024];
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    new File(str2 + name).mkdirs();
                } else {
                    new File(str2 + name).getParentFile().mkdirs();
                    FileOutputStream fileOutputStream = new FileOutputStream(str2 + name);
                    while (true) {
                        int read = zipInputStream.read(bArr, 0, bArr.length);
                        if (read <= -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                    zipInputStream.closeEntry();
                }
            } else {
                zipInputStream.close();
                return;
            }
        }
    }
}
