package com.shopee.live.livestreaming.util.a;

import a.k;
import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.shopee.live.livestreaming.util.i;
import com.shopee.live.livestreaming.util.t;
import java.io.File;
import java.util.concurrent.Callable;

public class d {

    /* renamed from: a  reason: collision with root package name */
    a f29374a;

    /* renamed from: b  reason: collision with root package name */
    private Context f29375b;

    /* renamed from: c  reason: collision with root package name */
    private int f29376c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public File f29377d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f29378e;

    /* renamed from: f  reason: collision with root package name */
    private StringBuilder f29379f = new StringBuilder();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f29380g = false;
    /* access modifiers changed from: private */
    public int h;
    private String i;

    static /* synthetic */ int a(d dVar) {
        int i2 = dVar.h;
        dVar.h = i2 + 1;
        return i2;
    }

    class a extends Handler {
        a() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 18) {
                d.a(d.this);
                if (d.this.h < 6) {
                    sendEmptyMessageDelayed(18, 1000);
                    return;
                }
                int unused = d.this.h = 0;
                boolean unused2 = d.this.f29380g = false;
            }
        }
    }

    public d(Context context, String str) {
        this.f29375b = context;
        this.i = str;
        this.f29374a = new a();
    }

    public void a(String str) {
        if (!b() || !c()) {
            return;
        }
        if (this.f29380g) {
            this.f29379f.append(str);
            return;
        }
        this.f29380g = true;
        String sb = this.f29379f.toString();
        StringBuilder sb2 = this.f29379f;
        sb2.delete(0, sb2.length());
        a((Object) sb);
        this.f29374a.sendEmptyMessageDelayed(18, 1000);
    }

    public void a(final Object obj) {
        k.a(new Callable<Object>() {
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0062 A[SYNTHETIC, Splitter:B:25:0x0062] */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x006d A[SYNTHETIC, Splitter:B:32:0x006d] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x007a A[SYNTHETIC, Splitter:B:40:0x007a] */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0068=Splitter:B:29:0x0068, B:22:0x005d=Splitter:B:22:0x005d} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object call() throws java.lang.Exception {
                /*
                    r5 = this;
                    r0 = 0
                    com.shopee.live.livestreaming.util.a.d r1 = com.shopee.live.livestreaming.util.a.d.this     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0059 }
                    java.io.File r1 = r1.f29377d     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0059 }
                    boolean r1 = r1.exists()     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0059 }
                    if (r1 != 0) goto L_0x001f
                    com.shopee.live.livestreaming.util.a.d r1 = com.shopee.live.livestreaming.util.a.d.this     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0059 }
                    java.io.File r1 = r1.f29377d     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0059 }
                    boolean r1 = r1.createNewFile()     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0059 }
                    if (r1 != 0) goto L_0x001f
                    r1 = 0
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0059 }
                    return r0
                L_0x001f:
                    java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0059 }
                    com.shopee.live.livestreaming.util.a.d r2 = com.shopee.live.livestreaming.util.a.d.this     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0059 }
                    java.io.File r2 = r2.f29377d     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0059 }
                    java.lang.String r3 = "rw"
                    r1.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x005b, all -> 0x0059 }
                    com.shopee.live.livestreaming.util.a.d r2 = com.shopee.live.livestreaming.util.a.d.this     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x004f, all -> 0x004a }
                    java.io.File r2 = r2.f29377d     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x004f, all -> 0x004a }
                    long r2 = r2.length()     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x004f, all -> 0x004a }
                    r1.seek(r2)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x004f, all -> 0x004a }
                    java.lang.Object r2 = r2     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x004f, all -> 0x004a }
                    java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x004f, all -> 0x004a }
                    byte[] r2 = r2.getBytes()     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x004f, all -> 0x004a }
                    r1.write(r2)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x004f, all -> 0x004a }
                    r1.close()     // Catch:{ IOException -> 0x0071 }
                    goto L_0x0075
                L_0x004a:
                    r0 = move-exception
                    r4 = r1
                    r1 = r0
                    r0 = r4
                    goto L_0x0078
                L_0x004f:
                    r2 = move-exception
                    r4 = r2
                    r2 = r1
                    r1 = r4
                    goto L_0x005d
                L_0x0054:
                    r2 = move-exception
                    r4 = r2
                    r2 = r1
                    r1 = r4
                    goto L_0x0068
                L_0x0059:
                    r1 = move-exception
                    goto L_0x0078
                L_0x005b:
                    r1 = move-exception
                    r2 = r0
                L_0x005d:
                    r1.printStackTrace()     // Catch:{ all -> 0x0076 }
                    if (r2 == 0) goto L_0x0075
                    r2.close()     // Catch:{ IOException -> 0x0071 }
                    goto L_0x0075
                L_0x0066:
                    r1 = move-exception
                    r2 = r0
                L_0x0068:
                    r1.printStackTrace()     // Catch:{ all -> 0x0076 }
                    if (r2 == 0) goto L_0x0075
                    r2.close()     // Catch:{ IOException -> 0x0071 }
                    goto L_0x0075
                L_0x0071:
                    r1 = move-exception
                    r1.printStackTrace()
                L_0x0075:
                    return r0
                L_0x0076:
                    r1 = move-exception
                    r0 = r2
                L_0x0078:
                    if (r0 == 0) goto L_0x0082
                    r0.close()     // Catch:{ IOException -> 0x007e }
                    goto L_0x0082
                L_0x007e:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x0082:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.util.a.d.AnonymousClass1.call():java.lang.Object");
            }
        });
    }

    private boolean b() {
        if (this.f29378e) {
            return true;
        }
        t.a().a((Activity) this.f29375b, new t.b() {
            public void a(String str, boolean z) {
            }

            public void a(String str) {
                boolean unused = d.this.f29378e = true;
            }
        });
        return false;
    }

    public void a(int i2) {
        this.f29376c = i2;
    }

    private boolean c() {
        File file = this.f29377d;
        if (file != null) {
            return file.length() <= 15728640;
        }
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            String str = externalStorageDirectory.getAbsolutePath() + File.separator + "ShopeeLiveStreamingLogs";
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdir();
            }
            File file3 = new File(str, String.valueOf(this.f29376c));
            if (!file3.exists()) {
                file3.mkdir();
            }
            d();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public void a(final File file) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file : listFiles) {
                            if (!file.isDirectory()) {
                                String name = file.getName();
                                int lastIndexOf = name.lastIndexOf("_");
                                if (lastIndexOf <= 0) {
                                    return null;
                                }
                                String substring = name.substring(lastIndexOf + 1, name.length() - 4);
                                if (!com.shopee.live.livestreaming.util.d.a(substring) && System.currentTimeMillis() - Long.valueOf(substring).longValue() >= 259200000) {
                                    file.delete();
                                }
                            } else if (file.listFiles().length > 0) {
                                d.this.a(file);
                            }
                        }
                    }
                }
                d.this.b(file);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(File file) {
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory() && file2.listFiles().length <= 0) {
                        file2.delete();
                    }
                }
                return;
            }
            file.delete();
        }
    }

    private void d() {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            this.f29377d = new File(new File(externalStorageDirectory.getAbsolutePath() + File.separator + "ShopeeLiveStreamingLogs", String.valueOf(this.f29376c)).getPath(), i.a() + "_" + this.i + "_" + System.currentTimeMillis() + ".txt");
            if (!this.f29377d.exists()) {
                this.f29377d.createNewFile();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        a aVar = this.f29374a;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages((Object) null);
        }
    }
}
