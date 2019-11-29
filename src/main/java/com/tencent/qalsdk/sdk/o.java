package com.tencent.qalsdk.sdk;

import com.tencent.qalsdk.util.QLog;
import java.io.File;

final class o extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ m f32268a;

    o(m mVar) {
        this.f32268a = mVar;
    }

    public final void run() {
        try {
            String a2 = this.f32268a.a(this.f32268a.a(System.currentTimeMillis() - 604800000));
            QLog.d("MSF.D.QLogImpl", "delete log file before:" + a2);
            File file = new File(this.f32268a.n);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.getName().compareTo(a2) < 0) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            System.out.println("delete log file error." + e2);
        }
    }
}
