package com.tencent.qalsdk.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qalsdk.util.QLog;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    protected static boolean f32260a = true;

    /* renamed from: f  reason: collision with root package name */
    private static int f32261f = 1;
    /* access modifiers changed from: private */
    public volatile Context A = null;
    private String B = "";

    /* renamed from: b  reason: collision with root package name */
    LinkedBlockingDeque<String> f32262b = new LinkedBlockingDeque<>(15000);

    /* renamed from: c  reason: collision with root package name */
    Thread f32263c = new n(this);

    /* renamed from: d  reason: collision with root package name */
    Thread f32264d = new o(this);

    /* renamed from: e  reason: collision with root package name */
    public Runnable f32265e = new p(this);

    /* renamed from: g  reason: collision with root package name */
    private ReentrantLock f32266g = new ReentrantLock();
    /* access modifiers changed from: private */
    public final int[] h = {1, 2, 4, 8, 16, 29};
    private Object i = new Object();
    private String j = "";
    private long k = 0;
    private HashSet<String> l = new HashSet<>();
    private long m = 0;
    /* access modifiers changed from: private */
    public String n = "";
    private String o;
    private long p;
    private long q;
    /* access modifiers changed from: private */
    public String r = "";
    private String s = "";
    private FileWriter t;
    /* access modifiers changed from: private */
    public AtomicBoolean u = new AtomicBoolean(false);
    private long v = 0;
    private AtomicBoolean w = new AtomicBoolean(false);
    private String x;
    /* access modifiers changed from: private */
    public AtomicInteger y = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public Handler z = new Handler(Looper.getMainLooper());

    public final void a(Context context, String str) {
        this.x = str;
        this.A = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 23 && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            f32260a = false;
            QLog.i("MSF.D.QLogImpl", "no WRITE_EXTERNAL_STORAGE permission,can't log to file");
        }
        this.f32265e.run();
        c();
    }

    public final String a() {
        return this.o;
    }

    private String c() {
        try {
            this.s = this.A.getPackageName();
        } catch (Exception unused) {
            this.s = "unknow";
        }
        this.o = Environment.getExternalStorageDirectory().getPath() + "/tencent/qalsdklogs/" + this.s.replace(".", Constants.URL_PATH_DELIMITER) + Constants.URL_PATH_DELIMITER;
        return this.o;
    }

    public final String a(long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd.HH");
        this.B = new SimpleDateFormat("yy-MM-dd HH:mm:ss:SSS").format(Long.valueOf(j2));
        String format = simpleDateFormat.format(instance.getTime());
        instance.set(14, 0);
        this.q = instance.getTimeInMillis() + 1000;
        instance.add(11, 1);
        instance.set(12, 0);
        instance.set(13, 0);
        this.p = instance.getTimeInMillis();
        return format;
    }

    private synchronized void c(long j2) {
        if (j2 > this.q) {
            synchronized (this.i) {
                this.B = MsfSdkUtils.timeFormatter.format(Long.valueOf(j2));
                this.q += 1000;
            }
        }
    }

    public final String a(String str) {
        return this.x + "." + str + ".log";
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(long j2) throws IOException {
        File file;
        if (this.o == null) {
            c();
        }
        this.n = this.o + this.x + Constants.URL_PATH_DELIMITER;
        File file2 = new File(this.n);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.n);
        String a2 = a(j2);
        sb.append(this.x + "." + a2 + ".log");
        this.j = sb.toString();
        try {
            file = new File(this.j);
            try {
                if (!file.exists()) {
                    boolean createNewFile = file.createNewFile();
                    d();
                    if (this.t != null) {
                        FileWriter fileWriter = this.t;
                        fileWriter.write(this.B + "|" + this.r + "|D|MSF.D.QLogImpl" + "|" + Build.MODEL + SQLBuilder.BLANK + Build.VERSION.RELEASE + " create newLogFile " + file.getName() + SQLBuilder.BLANK + createNewFile + "\n");
                        this.t.flush();
                    }
                } else {
                    d();
                    if (this.t != null) {
                        FileWriter fileWriter2 = this.t;
                        fileWriter2.write(this.B + "|" + this.r + "|E|MSF.D.QLogImpl" + "|" + Build.MODEL + SQLBuilder.BLANK + Build.VERSION.RELEASE + "|newLogFile " + file.getName() + " is existed.\n");
                        this.t.flush();
                    }
                }
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                this.t = new FileWriter(file, true);
                d();
            }
        } catch (Throwable th2) {
            th = th2;
            file = file2;
            th.printStackTrace();
            this.t = new FileWriter(file, true);
            d();
        }
        this.t = new FileWriter(file, true);
        d();
    }

    private void d() throws IOException {
        if (this.t != null && !"".equals(QLog.sBuildNumber)) {
            FileWriter fileWriter = this.t;
            fileWriter.write(this.B + "|" + this.r + "|D||QQ_Version: " + QLog.sBuildNumber + IOUtils.LINE_SEPARATOR_WINDOWS);
            this.t.flush();
        }
    }

    public final void a(String str, String str2, Throwable th) {
        if (f32260a) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= this.q) {
                c(currentTimeMillis);
            }
            long id = Thread.currentThread().getId();
            String str3 = this.B + "|" + String.valueOf(id) + "|" + str + "|" + str2 + "\n";
            if (th != null) {
                str3 = str3 + "\n" + Log.getStackTraceString(th) + "\n";
            }
            if (b(str3) && this.A != null && System.currentTimeMillis() - this.v > 180000) {
                this.v = System.currentTimeMillis();
                try {
                    ((ActivityManager) this.A.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                } catch (Exception unused) {
                }
            }
        }
    }

    private boolean b(String str) {
        try {
            this.f32262b.add(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean c(String str) {
        try {
            this.f32262b.addFirst(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String b() {
        return this.n;
    }

    static /* synthetic */ void a(m mVar, String str) {
        try {
            if (!f32260a) {
                return;
            }
            if ("mounted".equals(Environment.getExternalStorageState())) {
                if (mVar.t == null) {
                    System.out.println("can not write log.");
                    long currentTimeMillis = System.currentTimeMillis();
                    if (mVar.k == 0) {
                        mVar.k = currentTimeMillis;
                    } else if (currentTimeMillis - mVar.k > 60000) {
                        mVar.b(System.currentTimeMillis());
                        mVar.k = currentTimeMillis;
                    }
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 > mVar.p) {
                        mVar.b(currentTimeMillis2);
                    }
                    if (mVar.f32266g.tryLock()) {
                        mVar.t.write(str);
                        mVar.t.flush();
                        mVar.f32266g.unlock();
                    } else if (!mVar.c(str)) {
                        Log.d("QLogImpl", "insertLogToCacheHead failed!");
                    }
                }
                mVar.w.compareAndSet(true, false);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            if (!(th instanceof IOException) || !th.getMessage().contains("ENOSPC")) {
                mVar.w.compareAndSet(true, false);
                th.printStackTrace();
                try {
                    mVar.b(System.currentTimeMillis());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } else if (mVar.w.compareAndSet(false, true)) {
                th.printStackTrace();
            }
        }
    }
}
