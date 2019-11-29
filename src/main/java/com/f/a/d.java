package com.f.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class d implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f6669a;

    public d(Handler handler) {
        this.f6669a = (Handler) m.b(handler);
    }

    public void a(int i, String str, String str2) {
        m.b(str2);
        Handler handler = this.f6669a;
        handler.sendMessage(handler.obtainMessage(i, str2));
    }

    static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final String f6670a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6671b;

        a(Looper looper, String str, int i) {
            super((Looper) m.b(looper));
            this.f6670a = (String) m.b(str);
            this.f6671b = i;
        }

        public void handleMessage(Message message) {
            FileWriter fileWriter;
            String str = (String) message.obj;
            try {
                fileWriter = new FileWriter(a(this.f6670a, "logs"), true);
                try {
                    a(fileWriter, str);
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                fileWriter = null;
                if (fileWriter != null) {
                    try {
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException unused3) {
                    }
                }
            }
        }

        private void a(FileWriter fileWriter, String str) throws IOException {
            m.b(fileWriter);
            m.b(str);
            fileWriter.append(str);
        }

        private File a(String str, String str2) {
            File file;
            m.b(str);
            m.b(str2);
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = null;
            File file4 = new File(file2, String.format("%s_%s.csv", new Object[]{str2, 0}));
            int i = 0;
            while (true) {
                File file5 = file4;
                file = file3;
                file3 = file5;
                if (!file3.exists()) {
                    break;
                }
                i++;
                file4 = new File(file2, String.format("%s_%s.csv", new Object[]{str2, Integer.valueOf(i)}));
            }
            return (file == null || file.length() >= ((long) this.f6671b)) ? file3 : file;
        }
    }
}
