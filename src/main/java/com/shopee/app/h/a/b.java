package com.shopee.app.h.a;

import com.shopee.app.h.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private static b f17600b = new b();

    /* access modifiers changed from: protected */
    public String b() {
        return "file_system_check";
    }

    public static b c() {
        return f17600b;
    }

    private b() {
        a();
    }

    public synchronized byte[] a(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[fileInputStream.available()];
        fileInputStream.read(bArr);
        fileInputStream.close();
        file.setLastModified(com.garena.android.appkit.tools.a.a.b());
        return bArr;
    }

    public void a(File file) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        a(file2);
                    } else {
                        file2.delete();
                        com.garena.android.appkit.d.a.e("File successfully deleted  %s", file2.getName());
                    }
                }
            }
            file.delete();
            com.garena.android.appkit.d.a.e("Folder successfully deleted  %s", file.getName());
        }
    }
}
