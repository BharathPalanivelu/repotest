package com.garena.reactpush.c;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f8352a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f8353b = "download/";

    /* renamed from: c  reason: collision with root package name */
    public static String f8354c = "backup/";

    /* renamed from: d  reason: collision with root package name */
    public static String f8355d = "js.lock";

    /* renamed from: e  reason: collision with root package name */
    public static String f8356e = "assets.lock";

    /* renamed from: f  reason: collision with root package name */
    public static String f8357f = "assets.zip";

    public static void a(InputStream inputStream, String str) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
        byte[] bArr = new byte[1024];
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    new File(str + name).mkdirs();
                } else {
                    new File(str + name).getParentFile().mkdirs();
                    FileOutputStream fileOutputStream = new FileOutputStream(str + name);
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

    public static void a(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            for (String file2 : file.list()) {
                new File(file, file2).delete();
            }
        }
        file.delete();
    }

    public static String a(Context context, int i) throws IOException {
        return new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i))).readLine();
    }
}
