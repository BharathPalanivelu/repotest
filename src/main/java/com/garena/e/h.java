package com.garena.e;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class h {

    /* renamed from: a  reason: collision with root package name */
    static int f7931a = 52173;

    public static void a(String str, String str2) {
        com.beetalk.sdk.f.a.a().a(new a(str, str2), 200);
    }

    /* access modifiers changed from: private */
    public static String b() {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(new Date());
    }

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private String f7932a;

        /* renamed from: b  reason: collision with root package name */
        private String f7933b;

        /* renamed from: c  reason: collision with root package name */
        private String f7934c;

        private a(String str, String str2) {
            this.f7932a = str;
            this.f7933b = str2;
            this.f7934c = String.format(Locale.ENGLISH, "<22>1 %s %s %s - - - %s", new Object[]{h.b(), "Android", str, str2});
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                r0 = 0
                java.net.DatagramSocket r1 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x0027, all -> 0x0022 }
                r1.<init>()     // Catch:{ Exception -> 0x0027, all -> 0x0022 }
                java.lang.String r0 = "logs.papertrailapp.com"
                java.net.InetAddress r0 = java.net.InetAddress.getByName(r0)     // Catch:{ Exception -> 0x0020 }
                java.lang.String r2 = r7.f7934c     // Catch:{ Exception -> 0x0020 }
                java.lang.String r3 = "UTF-8"
                byte[] r2 = r2.getBytes(r3)     // Catch:{ Exception -> 0x0020 }
                java.net.DatagramPacket r3 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0020 }
                int r4 = r2.length     // Catch:{ Exception -> 0x0020 }
                int r5 = com.garena.e.h.f7931a     // Catch:{ Exception -> 0x0020 }
                r3.<init>(r2, r4, r0, r5)     // Catch:{ Exception -> 0x0020 }
                r1.send(r3)     // Catch:{ Exception -> 0x0020 }
                goto L_0x0030
            L_0x0020:
                r0 = move-exception
                goto L_0x002b
            L_0x0022:
                r1 = move-exception
                r6 = r1
                r1 = r0
                r0 = r6
                goto L_0x0035
            L_0x0027:
                r1 = move-exception
                r6 = r1
                r1 = r0
                r0 = r6
            L_0x002b:
                r0.printStackTrace()     // Catch:{ all -> 0x0034 }
                if (r1 == 0) goto L_0x0033
            L_0x0030:
                r1.close()
            L_0x0033:
                return
            L_0x0034:
                r0 = move-exception
            L_0x0035:
                if (r1 == 0) goto L_0x003a
                r1.close()
            L_0x003a:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.garena.e.h.a.run():void");
        }
    }
}
