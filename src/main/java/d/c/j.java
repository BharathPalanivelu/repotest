package d.c;

import com.facebook.react.uimanager.events.TouchesHelper;
import d.h.m;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class j extends i {
    public static final String a(File file) {
        d.d.b.j.b(file, "$this$extension");
        String name = file.getName();
        d.d.b.j.a((Object) name, "name");
        return m.a(name, '.', "");
    }

    public static final File a(File file, File file2, boolean z, int i) {
        Closeable fileOutputStream;
        d.d.b.j.b(file, "$this$copyTo");
        d.d.b.j.b(file2, TouchesHelper.TARGET_KEY);
        if (file.exists()) {
            if (file2.exists()) {
                boolean z2 = true;
                if (z && file2.delete()) {
                    z2 = false;
                }
                if (z2) {
                    throw new d(file, file2, "The destination file already exists.");
                }
            }
            if (!file.isDirectory()) {
                File parentFile = file2.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                Closeable fileInputStream = new FileInputStream(file);
                Throwable th = null;
                try {
                    FileInputStream fileInputStream2 = (FileInputStream) fileInputStream;
                    fileOutputStream = new FileOutputStream(file2);
                    Throwable th2 = null;
                    a.a(fileInputStream2, (FileOutputStream) fileOutputStream, i);
                    b.a(fileOutputStream, th2);
                    b.a(fileInputStream, th);
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        b.a(fileInputStream, th4);
                        throw th5;
                    }
                }
            } else if (!file2.mkdirs()) {
                throw new e(file, file2, "Failed to create target directory.");
            }
            return file2;
        }
        throw new k(file, (File) null, "The source file doesn't exist.", 2, (g) null);
    }
}
