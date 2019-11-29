package com.bca.xco.widget.d.a.a.h;

import java.io.File;
import java.io.IOException;

public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5032a = new a() {
        public void a(File file) {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public boolean b(File file) {
            return file.exists();
        }

        public long c(File file) {
            return file.length();
        }

        public void a(File file, File file2) {
            a(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }
    };

    void a(File file);

    void a(File file, File file2);

    boolean b(File file);

    long c(File file);
}
