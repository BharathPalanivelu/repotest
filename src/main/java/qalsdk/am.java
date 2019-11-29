package qalsdk;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.core.NetConnInfoCenter;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.core.m;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class am {

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f34107b = false;

    /* renamed from: c  reason: collision with root package name */
    private static AtomicInteger f34108c = new AtomicInteger(1);

    /* renamed from: d  reason: collision with root package name */
    private static int f34109d = 50;

    /* renamed from: f  reason: collision with root package name */
    private static SQLiteDatabase f34110f;

    /* renamed from: a  reason: collision with root package name */
    Runnable f34111a = new an(this);

    /* renamed from: e  reason: collision with root package name */
    private aj f34112e = new aj(j.a().k);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ak> f34113g = new ArrayList<>();
    /* access modifiers changed from: private */
    public volatile Handler h;
    /* access modifiers changed from: private */
    public int i = 0;

    static /* synthetic */ int a(am amVar) {
        int i2 = amVar.i;
        amVar.i = i2 + 1;
        return i2;
    }

    static {
        new ConcurrentHashMap();
    }

    public am() {
        HandlerThread handlerThread = new HandlerThread("NetInfoCollection", 5);
        handlerThread.start();
        this.h = new Handler(handlerThread.getLooper());
    }

    public static boolean a() {
        return !MsfSdkUtils.isTopActivity(j.a().k);
    }

    public final void b() {
        this.f34113g.clear();
        this.h.post(this.f34111a);
    }

    public final void c() {
        this.i = 0;
        this.h.removeCallbacks(this.f34111a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081 A[LOOP:1: B:19:0x0079->B:21:0x0081, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0128 A[Catch:{ Exception -> 0x01c9, all -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0153 A[SYNTHETIC, Splitter:B:44:0x0153] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r25, long r26, java.util.ArrayList<qalsdk.d> r28, int r29) {
        /*
            r24 = this;
            r1 = r24
            r0 = r29
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r4 = r26
            int r5 = (int) r4
            java.lang.String r4 = android.os.Build.VERSION.RELEASE
            com.tencent.qalsdk.core.j r6 = com.tencent.qalsdk.core.j.a()
            android.content.Context r6 = r6.k
            boolean r6 = com.tencent.qalsdk.sdk.MsfSdkUtils.isTopActivity(r6)
            r7 = 1
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x0020
            r6 = 1
            goto L_0x0021
        L_0x0020:
            r6 = 2
        L_0x0021:
            r9 = 0
            r10 = 0
        L_0x0023:
            java.util.ArrayList<qalsdk.ak> r11 = r1.f34113g
            int r11 = r11.size()
            if (r10 >= r11) goto L_0x003e
            java.util.ArrayList<qalsdk.ak> r11 = r1.f34113g
            java.lang.Object r11 = r11.get(r10)
            qalsdk.ak r11 = (qalsdk.ak) r11
            int r11 = r11.f34101e
            r13 = -70
            if (r11 > r13) goto L_0x003b
            r10 = 3
            goto L_0x0040
        L_0x003b:
            int r10 = r10 + 1
            goto L_0x0023
        L_0x003e:
            r10 = r25
        L_0x0040:
            java.util.ArrayList<qalsdk.ak> r11 = r1.f34113g
            int r11 = r11.size()
            if (r11 <= 0) goto L_0x006a
            qalsdk.al r11 = new qalsdk.al
            r11.<init>()
            java.util.ArrayList<qalsdk.ak> r14 = r1.f34113g
            r11.f34106a = r14
            java.util.ArrayList<qalsdk.ak> r14 = r11.f34106a
            int r14 = r14.size()
            if (r14 <= 0) goto L_0x006a
            com.g.a.a.f r14 = new com.g.a.a.f
            r14.<init>()
            r11.writeTo(r14)
            byte[] r11 = r14.a()
            java.lang.String r11 = com.g.a.a.a.a((byte[]) r11)
            goto L_0x006b
        L_0x006a:
            r11 = 0
        L_0x006b:
            java.util.ArrayList<qalsdk.ak> r14 = r1.f34113g
            r14.clear()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.util.Iterator r15 = r28.iterator()
        L_0x0079:
            boolean r16 = r15.hasNext()
            java.lang.String r13 = "|"
            if (r16 == 0) goto L_0x009e
            java.lang.Object r16 = r15.next()
            r12 = r16
            qalsdk.d r12 = (qalsdk.d) r12
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r12 = r12.f34127b
            r8.append(r12)
            r8.append(r13)
            java.lang.String r8 = r8.toString()
            r14.append(r8)
            goto L_0x0079
        L_0x009e:
            java.lang.String r8 = r14.toString()
            boolean r12 = r8.endsWith(r13)
            if (r12 == 0) goto L_0x00b1
            int r12 = r8.length()
            int r12 = r12 - r7
            java.lang.String r8 = r8.substring(r9, r12)
        L_0x00b1:
            java.lang.String r12 = com.tencent.qalsdk.core.n.b()
            if (r10 == r7) goto L_0x00c8
            if (r0 != 0) goto L_0x00bb
            r0 = 1
            goto L_0x00c9
        L_0x00bb:
            if (r0 != r7) goto L_0x00be
            goto L_0x00c8
        L_0x00be:
            r13 = 2
            if (r0 != r13) goto L_0x00c3
            r0 = 3
            goto L_0x00c9
        L_0x00c3:
            r13 = 3
            if (r0 != r13) goto L_0x00c8
            r0 = 2
            goto L_0x00c9
        L_0x00c8:
            r0 = 0
        L_0x00c9:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "insert db,"
            r13.append(r14)
            r13.append(r2)
            java.lang.String r14 = ":"
            r13.append(r14)
            r13.append(r5)
            r13.append(r14)
            r13.append(r10)
            java.lang.String r15 = ":1"
            r13.append(r15)
            r13.append(r14)
            r13.append(r4)
            r13.append(r14)
            java.lang.String r15 = "2.2.17"
            r13.append(r15)
            r13.append(r14)
            r13.append(r6)
            r13.append(r14)
            r13.append(r8)
            r13.append(r14)
            r13.append(r12)
            r13.append(r14)
            r13.append(r0)
            r13.append(r14)
            java.util.ArrayList<qalsdk.ak> r14 = r1.f34113g
            int r14 = r14.size()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r14 = "MSF.C.StatReport"
            com.tencent.qalsdk.util.QLog.d(r14, r7, r13)
            android.database.sqlite.SQLiteDatabase r13 = f34110f     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            if (r13 != 0) goto L_0x0130
            qalsdk.aj r13 = r1.f34112e     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            android.database.sqlite.SQLiteDatabase r13 = r13.getWritableDatabase()     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            f34110f = r13     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
        L_0x0130:
            android.database.sqlite.SQLiteDatabase r16 = f34110f     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            java.lang.String r17 = "conntime"
            r13 = 2
            java.lang.String[] r7 = new java.lang.String[r13]     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            java.lang.String r13 = "timestamp"
            r7[r9] = r13     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            java.lang.String r13 = "cost_time"
            r18 = 1
            r7[r18] = r13     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r7
            android.database.Cursor r13 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            if (r13 == 0) goto L_0x0177
            int r7 = r13.getCount()     // Catch:{ Exception -> 0x01c4 }
            int r9 = f34109d     // Catch:{ Exception -> 0x01c4 }
            if (r7 <= r9) goto L_0x0177
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r9 = "statreport over,clear record.record_num:"
            r7.<init>(r9)     // Catch:{ Exception -> 0x01c4 }
            int r9 = r13.getCount()     // Catch:{ Exception -> 0x01c4 }
            r7.append(r9)     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01c4 }
            com.tencent.qalsdk.util.QLog.i(r14, r7)     // Catch:{ Exception -> 0x01c4 }
            android.database.sqlite.SQLiteDatabase r7 = f34110f     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r9 = "DELETE FROM conntime"
            r7.execSQL(r9)     // Catch:{ Exception -> 0x01c4 }
        L_0x0177:
            android.database.sqlite.SQLiteDatabase r7 = f34110f     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r9 = "insert into conntime(timestamp, cost_time,result,os, os_version, sdk_version, process_status,server_ip_port,gateway_ip,errcode,net_info) values(?,?,?,?,?,?,?,?,?,?,?)"
            r1 = 11
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x01c4 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x01c4 }
            r3 = 0
            r1[r3] = r2     // Catch:{ Exception -> 0x01c4 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x01c4 }
            r3 = 1
            r1[r3] = r2     // Catch:{ Exception -> 0x01c4 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x01c4 }
            r5 = 2
            r1[r5] = r2     // Catch:{ Exception -> 0x01c4 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x01c4 }
            r3 = 3
            r1[r3] = r2     // Catch:{ Exception -> 0x01c4 }
            r2 = 4
            r1[r2] = r4     // Catch:{ Exception -> 0x01c4 }
            r2 = 5
            r1[r2] = r15     // Catch:{ Exception -> 0x01c4 }
            r2 = 6
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x01c4 }
            r1[r2] = r3     // Catch:{ Exception -> 0x01c4 }
            r2 = 7
            r1[r2] = r8     // Catch:{ Exception -> 0x01c4 }
            r2 = 8
            r1[r2] = r12     // Catch:{ Exception -> 0x01c4 }
            r2 = 9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01c4 }
            r1[r2] = r0     // Catch:{ Exception -> 0x01c4 }
            r0 = 10
            r1[r0] = r11     // Catch:{ Exception -> 0x01c4 }
            r7.execSQL(r9, r1)     // Catch:{ Exception -> 0x01c4 }
            if (r13 == 0) goto L_0x01d6
            r13.close()
            return
        L_0x01c4:
            r0 = move-exception
            goto L_0x01cb
        L_0x01c6:
            r0 = move-exception
            r13 = 0
            goto L_0x01d8
        L_0x01c9:
            r0 = move-exception
            r13 = 0
        L_0x01cb:
            java.lang.String r1 = "qal_monitor data store failed."
            r2 = 1
            com.tencent.qalsdk.util.QLog.d(r14, r2, r1, r0)     // Catch:{ all -> 0x01d7 }
            if (r13 == 0) goto L_0x01d6
            r13.close()
        L_0x01d6:
            return
        L_0x01d7:
            r0 = move-exception
        L_0x01d8:
            if (r13 == 0) goto L_0x01dd
            r13.close()
        L_0x01dd:
            goto L_0x01df
        L_0x01de:
            throw r0
        L_0x01df:
            goto L_0x01de
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.am.a(int, long, java.util.ArrayList, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x029d, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x02b8 A[SYNTHETIC, Splitter:B:50:0x02b8] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02c3 A[SYNTHETIC, Splitter:B:59:0x02c3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void d() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            android.database.sqlite.SQLiteDatabase r0 = f34110f     // Catch:{ all -> 0x02c7 }
            if (r0 != 0) goto L_0x000f
            qalsdk.aj r0 = r1.f34112e     // Catch:{ all -> 0x02c7 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x02c7 }
            f34110f = r0     // Catch:{ all -> 0x02c7 }
        L_0x000f:
            r3 = 1
            android.database.sqlite.SQLiteDatabase r4 = f34110f     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r5 = "conntime"
            r0 = 11
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r0 = "timestamp"
            r12 = 0
            r6[r12] = r0     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r0 = "cost_time"
            r6[r3] = r0     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r0 = "result"
            r13 = 2
            r6[r13] = r0     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r0 = "os"
            r14 = 3
            r6[r14] = r0     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r0 = "os_version"
            r15 = 4
            r6[r15] = r0     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r0 = "sdk_version"
            r11 = 5
            r6[r11] = r0     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r0 = "process_status"
            r10 = 6
            r6[r10] = r0     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r0 = "server_ip_port"
            r9 = 7
            r6[r9] = r0     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r0 = "gateway_ip"
            r8 = 8
            r6[r8] = r0     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r0 = "errcode"
            r7 = 9
            r6[r7] = r0     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            java.lang.String r0 = "net_info"
            r2 = 10
            r6[r2] = r0     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            r0 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r2 = 9
            r7 = r0
            r0 = 8
            r8 = r17
            r2 = 7
            r9 = r18
            r0 = 6
            r10 = r19
            r2 = 5
            r11 = r20
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x02a1, all -> 0x029e }
            if (r4 == 0) goto L_0x0297
            int r5 = r4.getCount()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            if (r5 > 0) goto L_0x0078
            goto L_0x0297
        L_0x0078:
            r4.moveToFirst()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.qalsdk.im_open.QalMonitor$Request r5 = new com.tencent.qalsdk.im_open.QalMonitor$Request     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r5.<init>()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r6 = 0
        L_0x0081:
            boolean r7 = r4.isAfterLast()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            if (r7 != 0) goto L_0x0214
            com.tencent.qalsdk.im_open.QalMonitor$Request$Conn r7 = new com.tencent.qalsdk.im_open.QalMonitor$Request$Conn     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r7.<init>()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBUInt32Field r8 = r7.timestamp     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r9 = r4.getInt(r12)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.set(r9)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBInt32Field r8 = r7.cost_time     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r9 = r4.getInt(r3)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.set(r9)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBEnumField r8 = r7.result     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r9 = r4.getInt(r13)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.set(r9)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBEnumField r8 = r7.os     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r9 = r4.getInt(r14)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.set(r9)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r8 = r7.os_version     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r9 = r4.getString(r15)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.set(r9)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r8 = r7.sdk_version     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r9 = r4.getString(r2)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.set(r9)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBEnumField r8 = r7.process_status     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r9 = r4.getInt(r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.set(r9)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r8 = r7.server_ip_port     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r9 = 7
            java.lang.String r10 = r4.getString(r9)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.set(r10)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r8 = r7.gateway_ip     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r10 = 8
            java.lang.String r11 = r4.getString(r10)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.set(r11)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBInt32Field r8 = r7.errcode     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r11 = 9
            int r0 = r4.getInt(r11)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.set(r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0 = 10
            java.lang.String r8 = r4.getString(r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            if (r8 == 0) goto L_0x015e
            int r16 = r8.length()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            if (r16 == 0) goto L_0x015e
            com.g.a.a.e r0 = new com.g.a.a.e     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            byte[] r8 = com.g.a.a.a.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            qalsdk.al r8 = new qalsdk.al     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.<init>()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r8.readFrom(r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0 = 0
        L_0x010b:
            java.util.ArrayList<qalsdk.ak> r2 = r8.f34106a     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            if (r0 >= r2) goto L_0x015e
            java.util.ArrayList<qalsdk.ak> r2 = r8.f34106a     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            qalsdk.ak r2 = (qalsdk.ak) r2     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.qalsdk.im_open.QalMonitor$Request$Environment r9 = new com.tencent.qalsdk.im_open.QalMonitor$Request$Environment     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r9.<init>()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r10 = r9.apn     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r11 = r2.f34097a     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r10.set(r11)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r10 = r9.wifi_supplicant_state     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r11 = r2.f34098b     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r10.set(r11)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r10 = r9.wifi_ssid     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r11 = r2.f34099c     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r10.set(r11)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r10 = r9.wifi_bssid     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r11 = r2.f34100d     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r10.set(r11)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBInt32Field r10 = r9.wifi_rssi     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r11 = r2.f34101e     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r10.set(r11)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBInt32Field r10 = r9.rat     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r11 = r2.f34102f     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r10.set(r11)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBInt32Field r10 = r9.rat_ss     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r2 = r2.f34103g     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r10.set(r2)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBRepeatMessageField<com.tencent.qalsdk.im_open.QalMonitor$Request$Environment> r2 = r7.env     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r2.add(r9)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r0 = r0 + 1
            r9 = 7
            r10 = 8
            r11 = 9
            goto L_0x010b
        L_0x015e:
            com.tencent.mobileqq.pb.PBRepeatMessageField<com.tencent.qalsdk.im_open.QalMonitor$Request$Conn> r0 = r5.conn     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.add(r7)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.<init>()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r2 = "MSF.C.StatReport"
            java.lang.String r8 = "report conn time|"
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBUInt32Field r8 = r7.timestamp     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r8 = r8.get()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = "|"
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBInt32Field r8 = r7.cost_time     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r8 = r8.get()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = "|"
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBEnumField r8 = r7.result     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r8 = r8.get()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = "|"
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBEnumField r8 = r7.os     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r8 = r8.get()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = "|"
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r8 = r7.os_version     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = r8.get()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = "|"
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r8 = r7.sdk_version     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = r8.get()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = "|"
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBEnumField r8 = r7.process_status     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r8 = r8.get()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = "|"
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r8 = r7.server_ip_port     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = r8.get()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = "|"
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBStringField r8 = r7.gateway_ip     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = r8.get()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = "|"
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBInt32Field r8 = r7.errcode     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r8 = r8.get()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = "|"
            r0.append(r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBRepeatMessageField<com.tencent.qalsdk.im_open.QalMonitor$Request$Environment> r7 = r7.env     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r7 = r7.size()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.append(r7)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.qalsdk.util.QLog.d(r2, r15, r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r4.moveToNext()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r6 = r6 + 1
            r0 = 6
            r2 = 5
            goto L_0x0081
        L_0x0214:
            java.util.concurrent.atomic.AtomicInteger r0 = f34108c     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r0 = r0.incrementAndGet()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.mobileqq.pb.PBUInt32Field r2 = r5.seqno     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r2.set(r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            byte[] r0 = r5.toByteArray()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.qalsdk.base.remote.ToServiceMsg r2 = new com.tencent.qalsdk.base.remote.ToServiceMsg     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r5 = ""
            com.tencent.qalsdk.core.j r7 = com.tencent.qalsdk.core.j.a()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.qalsdk.core.a r7 = r7.c()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r7 = r7.b()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r8 = "CliLogSvc.QalUpload"
            r2.<init>(r5, r7, r8)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            byte[] r0 = com.tencent.qalsdk.core.n.a((byte[]) r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r2.putWupBuffer(r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0 = 20
            r2.setUinType(r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.qalsdk.sdk.MsfCommand r0 = com.tencent.qalsdk.sdk.MsfCommand.qal_reportEvent     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r2.setMsfCommand(r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0 = 537050853(0x2002bee5, float:1.107459E-19)
            r2.setAppId(r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r7 = 10000(0x2710, double:4.9407E-320)
            r2.setTimeout(r7)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.core.j.a()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            android.content.Context r0 = r0.k     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r0 = com.tencent.qalsdk.sdk.MsfSdkUtils.getProcessName(r0)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.qalsdk.sdk.MsfSdkUtils.addToMsgProcessName(r0, r2)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.core.j.a()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r0.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r2)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r2.getRequestSsoSeq()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            int r0 = f34109d     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            if (r6 <= r0) goto L_0x028b
            java.lang.String r0 = "MSF.C.StatReport"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r5 = "stat over max,clear record.record_num:"
            r2.<init>(r5)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            r2.append(r6)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            com.tencent.qalsdk.util.QLog.d(r0, r15, r2)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            android.database.sqlite.SQLiteDatabase r0 = f34110f     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
            java.lang.String r2 = "DELETE FROM conntime"
            r0.execSQL(r2)     // Catch:{ Exception -> 0x0294, all -> 0x0292 }
        L_0x028b:
            if (r4 == 0) goto L_0x02bd
            r4.close()     // Catch:{ all -> 0x02c7 }
            monitor-exit(r21)
            return
        L_0x0292:
            r0 = move-exception
            goto L_0x02c1
        L_0x0294:
            r0 = move-exception
            r2 = r4
            goto L_0x02a3
        L_0x0297:
            if (r4 == 0) goto L_0x029c
            r4.close()     // Catch:{ all -> 0x02c7 }
        L_0x029c:
            monitor-exit(r21)
            return
        L_0x029e:
            r0 = move-exception
            r4 = 0
            goto L_0x02c1
        L_0x02a1:
            r0 = move-exception
            r2 = 0
        L_0x02a3:
            java.lang.String r4 = "MSF.C.StatReport"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x02bf }
            java.lang.String r6 = "qal_monitor query conn time failed. "
            r5.<init>(r6)     // Catch:{ all -> 0x02bf }
            r5.append(r0)     // Catch:{ all -> 0x02bf }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x02bf }
            com.tencent.qalsdk.util.QLog.d(r4, r3, r5, r0)     // Catch:{ all -> 0x02bf }
            if (r2 == 0) goto L_0x02bd
            r2.close()     // Catch:{ all -> 0x02c7 }
            monitor-exit(r21)
            return
        L_0x02bd:
            monitor-exit(r21)
            return
        L_0x02bf:
            r0 = move-exception
            r4 = r2
        L_0x02c1:
            if (r4 == 0) goto L_0x02c6
            r4.close()     // Catch:{ all -> 0x02c7 }
        L_0x02c6:
            throw r0     // Catch:{ all -> 0x02c7 }
        L_0x02c7:
            r0 = move-exception
            monitor-exit(r21)
            goto L_0x02cb
        L_0x02ca:
            throw r0
        L_0x02cb:
            goto L_0x02ca
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.am.d():void");
    }

    public final void a(FromServiceMsg fromServiceMsg) {
        if (f34110f == null) {
            f34110f = this.f34112e.getWritableDatabase();
        }
        if (fromServiceMsg.isSuccess()) {
            f34110f.execSQL("DELETE FROM conntime");
            QLog.d("MSF.C.StatReport", "delete all conntime record");
        }
    }

    static /* synthetic */ ak b(am amVar) {
        if (m.d() || (!m.c() && m.i() == null)) {
            return c.d();
        }
        ak akVar = new ak();
        akVar.f34097a = c.a();
        akVar.f34102f = c.b();
        akVar.f34103g = NetConnInfoCenter.isGSM() ? NetConnInfoCenter.getGsmStrength() : NetConnInfoCenter.getCdmaStrength();
        return akVar;
    }
}
