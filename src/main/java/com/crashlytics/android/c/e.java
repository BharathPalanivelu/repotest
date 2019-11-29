package com.crashlytics.android.c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

class e extends FileOutputStream {

    /* renamed from: a  reason: collision with root package name */
    public static final FilenameFilter f6462a = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final String f6463b;

    /* renamed from: c  reason: collision with root package name */
    private File f6464c;

    /* renamed from: d  reason: collision with root package name */
    private File f6465d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6466e = false;

    public e(File file, String str) throws FileNotFoundException {
        super(new File(file, str + ".cls_temp"));
        this.f6463b = file + File.separator + str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6463b);
        sb.append(".cls_temp");
        this.f6464c = new File(sb.toString());
    }

    public synchronized void close() throws IOException {
        if (!this.f6466e) {
            this.f6466e = true;
            super.flush();
            super.close();
            File file = new File(this.f6463b + ".cls");
            if (this.f6464c.renameTo(file)) {
                this.f6464c = null;
                this.f6465d = file;
                return;
            }
            String str = "";
            if (file.exists()) {
                str = " (target already exists)";
            } else if (!this.f6464c.exists()) {
                str = " (source does not exist)";
            }
            throw new IOException("Could not rename temp file: " + this.f6464c + " -> " + file + str);
        }
    }

    public void a() throws IOException {
        if (!this.f6466e) {
            this.f6466e = true;
            super.flush();
            super.close();
        }
    }
}
