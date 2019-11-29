package tencent.tls.request;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.report.QLog;
import tencent.tls.request.TinyInfo;
import tencent.tls.tools.cryptor;
import tencent.tls.tools.util;

public class account_sig_info_map {
    public static final String TLS_ACCOUNT_TABLE = "name_tree";
    public static final String TLS_TICKET_TABLE = "tk_tree";
    private static final Object db_lock = new Object();
    private static TkDBHelper tlsDBHelper = null;
    public static final String tls_sdk_DBNAME = "tls_sdk.db";
    Context _context;
    TreeMap<String, TinyInfo> _name_map = new TreeMap<>();
    TreeMap<Long, AllSigInfo> _uin_map = new TreeMap<>();

    public account_sig_info_map(Context context) {
        this._context = context;
    }

    public synchronized int put_siginfo(long j, long j2, byte[] bArr, byte[] bArr2, long j3, long j4, long j5, ArrayList<Ticket> arrayList, int i) {
        int i2;
        byte[] bArr3;
        AllSigInfo allSigInfo;
        byte[] bArr4;
        long j6 = j;
        byte[] bArr5 = bArr;
        synchronized (this) {
            i2 = 0;
            if (this._context != null) {
                synchronized (db_lock) {
                    QLog.i("before put_siginfo", j6);
                    TreeMap<?, ?> loadTKTreeMap = loadTKTreeMap(this._context, TLS_TICKET_TABLE);
                    if (loadTKTreeMap == null) {
                        loadTKTreeMap = new TreeMap<>();
                    }
                    TreeMap<?, ?> treeMap = loadTKTreeMap;
                    AllSigInfo allSigInfo2 = this._uin_map.get(Long.valueOf(j));
                    if (allSigInfo2 == null) {
                        allSigInfo2 = (AllSigInfo) treeMap.get(Long.valueOf(j));
                        if (allSigInfo2 == null) {
                            allSigInfo2 = new AllSigInfo();
                        }
                    }
                    AllSigInfo allSigInfo3 = allSigInfo2;
                    byte[] bArr6 = new byte[0];
                    byte[] bArr7 = new byte[0];
                    SigInfo sigInfo = allSigInfo3._tk_map.get(Long.valueOf(j2));
                    if (!(sigInfo == null || sigInfo._en_A1 == null)) {
                        bArr6 = (byte[]) sigInfo._en_A1.clone();
                        if (sigInfo._noPicSig != null) {
                            bArr7 = (byte[]) sigInfo._noPicSig.clone();
                        }
                    }
                    byte[] bArr8 = bArr6;
                    byte[] bArr9 = bArr7;
                    allSigInfo3.put_siginfo(j3, j4, j5, arrayList, i);
                    if (bArr5 == null || bArr5.length <= 0) {
                        bArr4 = bArr9;
                        allSigInfo = allSigInfo3;
                        bArr3 = bArr8;
                    } else {
                        bArr4 = bArr9;
                        allSigInfo = allSigInfo3;
                        bArr3 = bArr8;
                        allSigInfo3.put_siginfo(j2, bArr, bArr2, j5);
                    }
                    treeMap.put(Long.valueOf(j), allSigInfo);
                    i2 = refreshTKTreeMap(treeMap, TLS_TICKET_TABLE);
                    if (i2 != 0) {
                        SigInfo sigInfo2 = allSigInfo._tk_map.get(Long.valueOf(j2));
                        if (sigInfo2 != null) {
                            sigInfo2._en_A1 = bArr3;
                            sigInfo2._noPicSig = bArr4;
                        }
                    }
                    this._uin_map.put(Long.valueOf(j), allSigInfo);
                    QLog.i("after put_siginfo", j6);
                }
            }
        }
        return i2;
    }

    public synchronized AllSigInfo get_all_siginfo(long j) {
        QLog.i("get_all_siginfo", j);
        AllSigInfo allSigInfo = this._uin_map.get(Long.valueOf(j));
        if (allSigInfo != null) {
            return allSigInfo;
        }
        TreeMap<?, ?> loadTKTreeMap = loadTKTreeMap(this._context, TLS_TICKET_TABLE);
        if (loadTKTreeMap == null) {
            return null;
        }
        AllSigInfo allSigInfo2 = (AllSigInfo) loadTKTreeMap.get(Long.valueOf(j));
        if (allSigInfo2 == null) {
            return null;
        }
        this._uin_map.put(Long.valueOf(j), allSigInfo2);
        return allSigInfo2.clone();
    }

    public synchronized void refresh_all_siginfo() {
        QLog.i("refresh_all_siginfo...");
        this._uin_map = loadTKTreeMap(this._context, TLS_ACCOUNT_TABLE);
        if (this._uin_map == null) {
            this._uin_map = new TreeMap<>();
        }
    }

    public synchronized SigInfo get_siginfo(long j, long j2) {
        QLog.i("get_siginfo", j);
        AllSigInfo allSigInfo = get_all_siginfo(j);
        if (allSigInfo == null) {
            return null;
        }
        SigInfo sigInfo = allSigInfo._tk_map.get(Long.valueOf(j2));
        if (sigInfo == null) {
            return null;
        }
        return sigInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void clear_sig(long r3, long r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r0.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = "clear_sig sdkAppid="
            r0.append(r1)     // Catch:{ all -> 0x0045 }
            r0.append(r5)     // Catch:{ all -> 0x0045 }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x0045 }
            tencent.tls.report.QLog.i(r5, r3)     // Catch:{ all -> 0x0045 }
            java.util.TreeMap<java.lang.Long, tencent.tls.request.AllSigInfo> r5 = r2._uin_map     // Catch:{ all -> 0x0045 }
            java.lang.Long r6 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0045 }
            r5.remove(r6)     // Catch:{ all -> 0x0045 }
            android.content.Context r5 = r2._context     // Catch:{ all -> 0x0045 }
            if (r5 == 0) goto L_0x0043
            java.lang.Object r5 = db_lock     // Catch:{ all -> 0x0045 }
            monitor-enter(r5)     // Catch:{ all -> 0x0045 }
            android.content.Context r6 = r2._context     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = "tk_tree"
            java.util.TreeMap r6 = loadTKTreeMap(r6, r0)     // Catch:{ all -> 0x0040 }
            if (r6 != 0) goto L_0x0032
            monitor-exit(r5)     // Catch:{ all -> 0x0040 }
            monitor-exit(r2)
            return
        L_0x0032:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0040 }
            r6.remove(r3)     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = "tk_tree"
            r2.refreshTKTreeMap(r6, r3)     // Catch:{ all -> 0x0040 }
            monitor-exit(r5)     // Catch:{ all -> 0x0040 }
            goto L_0x0043
        L_0x0040:
            r3 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0040 }
            throw r3     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r2)
            return
        L_0x0045:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.request.account_sig_info_map.clear_sig(long, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void remove_account(java.lang.String r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
            r0.<init>()     // Catch:{ all -> 0x00c7 }
            java.lang.String r1 = "remove_account "
            r0.append(r1)     // Catch:{ all -> 0x00c7 }
            r0.append(r11)     // Catch:{ all -> 0x00c7 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c7 }
            tencent.tls.report.QLog.i(r0)     // Catch:{ all -> 0x00c7 }
            tencent.tls.request.TinyInfo r11 = r10.getTinyInfo((java.lang.String) r11)     // Catch:{ all -> 0x00c7 }
            if (r11 != 0) goto L_0x001d
            monitor-exit(r10)
            return
        L_0x001d:
            java.util.TreeMap<java.lang.String, tencent.tls.request.TinyInfo> r0 = r10._name_map     // Catch:{ all -> 0x00c7 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x00c7 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00c7 }
            r1.<init>()     // Catch:{ all -> 0x00c7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00c7 }
        L_0x002c:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00c7 }
            if (r2 == 0) goto L_0x004f
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00c7 }
            java.util.TreeMap<java.lang.String, tencent.tls.request.TinyInfo> r3 = r10._name_map     // Catch:{ all -> 0x00c7 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x00c7 }
            tencent.tls.request.TinyInfo r3 = (tencent.tls.request.TinyInfo) r3     // Catch:{ all -> 0x00c7 }
            if (r3 != 0) goto L_0x0043
            goto L_0x002c
        L_0x0043:
            long r3 = r3._tinyid     // Catch:{ all -> 0x00c7 }
            long r5 = r11._tinyid     // Catch:{ all -> 0x00c7 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x002c
            r1.add(r2)     // Catch:{ all -> 0x00c7 }
            goto L_0x002c
        L_0x004f:
            java.util.Iterator r0 = r1.iterator()     // Catch:{ all -> 0x00c7 }
        L_0x0053:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00c7 }
            if (r2 == 0) goto L_0x0065
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00c7 }
            java.util.TreeMap<java.lang.String, tencent.tls.request.TinyInfo> r3 = r10._name_map     // Catch:{ all -> 0x00c7 }
            r3.remove(r2)     // Catch:{ all -> 0x00c7 }
            goto L_0x0053
        L_0x0065:
            r1.clear()     // Catch:{ all -> 0x00c7 }
            android.content.Context r0 = r10._context     // Catch:{ all -> 0x00c7 }
            if (r0 == 0) goto L_0x00c5
            java.lang.Object r0 = db_lock     // Catch:{ all -> 0x00c7 }
            monitor-enter(r0)     // Catch:{ all -> 0x00c7 }
            android.content.Context r2 = r10._context     // Catch:{ all -> 0x00c2 }
            java.lang.String r3 = "name_tree"
            java.util.TreeMap r2 = loadTKTreeMap(r2, r3)     // Catch:{ all -> 0x00c2 }
            if (r2 != 0) goto L_0x007e
            java.util.TreeMap r2 = new java.util.TreeMap     // Catch:{ all -> 0x00c2 }
            r2.<init>()     // Catch:{ all -> 0x00c2 }
        L_0x007e:
            java.util.Set r3 = r2.keySet()     // Catch:{ all -> 0x00c2 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00c2 }
        L_0x0086:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00c2 }
            if (r4 == 0) goto L_0x00a7
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00c2 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00c2 }
            java.lang.Object r5 = r2.get(r4)     // Catch:{ all -> 0x00c2 }
            tencent.tls.request.TinyInfo r5 = (tencent.tls.request.TinyInfo) r5     // Catch:{ all -> 0x00c2 }
            if (r5 != 0) goto L_0x009b
            goto L_0x0086
        L_0x009b:
            long r5 = r5._tinyid     // Catch:{ all -> 0x00c2 }
            long r7 = r11._tinyid     // Catch:{ all -> 0x00c2 }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0086
            r1.add(r4)     // Catch:{ all -> 0x00c2 }
            goto L_0x0086
        L_0x00a7:
            java.util.Iterator r11 = r1.iterator()     // Catch:{ all -> 0x00c2 }
        L_0x00ab:
            boolean r1 = r11.hasNext()     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x00bb
            java.lang.Object r1 = r11.next()     // Catch:{ all -> 0x00c2 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00c2 }
            r2.remove(r1)     // Catch:{ all -> 0x00c2 }
            goto L_0x00ab
        L_0x00bb:
            java.lang.String r11 = "name_tree"
            r10.refreshTKTreeMap(r2, r11)     // Catch:{ all -> 0x00c2 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
            goto L_0x00c5
        L_0x00c2:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
            throw r11     // Catch:{ all -> 0x00c7 }
        L_0x00c5:
            monitor-exit(r10)
            return
        L_0x00c7:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x00cb
        L_0x00ca:
            throw r11
        L_0x00cb:
            goto L_0x00ca
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.request.account_sig_info_map.remove_account(java.lang.String):void");
    }

    public synchronized void putTinyInfo(String str, String str2, long j, TinyInfo.UserType userType) {
        QLog.i("putTinyInfo " + str + " userType " + userType + " tinyid " + j);
        TinyInfo tinyInfo = getTinyInfo(str);
        if (tinyInfo != null) {
            tinyInfo._tinyid = j;
        } else {
            QLog.i("new tinyInfo");
            tinyInfo = new TinyInfo(req_global._acc_type, str2, j, userType);
        }
        tinyInfo.userType = userType;
        TinyInfo.UserType userType2 = TinyInfo.UserType.USER_TYPE_GUEST;
        tinyInfo._userid = str2;
        this._name_map.put(str, tinyInfo);
        if (!str.equals(str2)) {
            this._name_map.put(str2, tinyInfo);
        }
        if (this._context != null) {
            synchronized (db_lock) {
                TreeMap<?, ?> loadTKTreeMap = loadTKTreeMap(this._context, TLS_ACCOUNT_TABLE);
                if (loadTKTreeMap == null) {
                    loadTKTreeMap = new TreeMap<>();
                }
                loadTKTreeMap.put(str, tinyInfo);
                refreshTKTreeMap(loadTKTreeMap, TLS_ACCOUNT_TABLE);
            }
        }
    }

    public synchronized TinyInfo getTinyInfo(String str) {
        QLog.i("getTinyInfo " + util.getLineInfo(3) + util.getLineInfo(4));
        TinyInfo tinyInfo = this._name_map.get(str);
        if (tinyInfo != null) {
            return tinyInfo;
        }
        if (this._context == null) {
            return null;
        }
        TreeMap<?, ?> loadTKTreeMap = loadTKTreeMap(this._context, TLS_ACCOUNT_TABLE);
        if (loadTKTreeMap == null) {
            return null;
        }
        TinyInfo tinyInfo2 = (TinyInfo) loadTKTreeMap.get(str);
        if (tinyInfo2 == null) {
            return null;
        }
        this._name_map.put(str, tinyInfo2);
        return tinyInfo2;
    }

    private synchronized TinyInfo getTinyInfo(long j) {
        for (TinyInfo next : this._name_map.values()) {
            if (next._tinyid == j) {
                return next;
            }
        }
        if (this._context == null) {
            return null;
        }
        TreeMap<?, ?> loadTKTreeMap = loadTKTreeMap(this._context, TLS_ACCOUNT_TABLE);
        if (loadTKTreeMap == null) {
            return null;
        }
        Iterator<?> it = loadTKTreeMap.values().iterator();
        while (it.hasNext()) {
            TinyInfo tinyInfo = (TinyInfo) it.next();
            if (tinyInfo._tinyid == j) {
                this._name_map.put(tinyInfo._userid, tinyInfo);
                return tinyInfo;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bb, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<tencent.tls.platform.TLSUserInfo> get_all_logined_account() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00bc }
            r0.<init>()     // Catch:{ all -> 0x00bc }
            android.content.Context r2 = r1._context     // Catch:{ all -> 0x00bc }
            if (r2 == 0) goto L_0x00ba
            android.content.Context r2 = r1._context     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = "tk_tree"
            java.util.TreeMap r2 = loadTKTreeMap(r2, r3)     // Catch:{ all -> 0x00bc }
            if (r2 != 0) goto L_0x0018
            monitor-exit(r20)
            return r0
        L_0x0018:
            java.util.Set r3 = r2.keySet()     // Catch:{ all -> 0x00bc }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00bc }
        L_0x0020:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00bc }
            if (r4 == 0) goto L_0x00ba
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00bc }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x00bc }
            long r13 = r4.longValue()     // Catch:{ all -> 0x00bc }
            java.util.TreeMap<java.lang.Long, tencent.tls.request.AllSigInfo> r4 = r1._uin_map     // Catch:{ all -> 0x00bc }
            java.lang.Long r5 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x00bc }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00bc }
            tencent.tls.request.AllSigInfo r4 = (tencent.tls.request.AllSigInfo) r4     // Catch:{ all -> 0x00bc }
            if (r4 != 0) goto L_0x0054
            java.lang.Long r4 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x00bc }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ all -> 0x00bc }
            tencent.tls.request.AllSigInfo r4 = (tencent.tls.request.AllSigInfo) r4     // Catch:{ all -> 0x00bc }
            if (r4 != 0) goto L_0x004b
            goto L_0x0020
        L_0x004b:
            java.util.TreeMap<java.lang.Long, tencent.tls.request.AllSigInfo> r5 = r1._uin_map     // Catch:{ all -> 0x00bc }
            java.lang.Long r6 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x00bc }
            r5.put(r6, r4)     // Catch:{ all -> 0x00bc }
        L_0x0054:
            tencent.tls.request.TinyInfo r15 = r1.getTinyInfo((long) r13)     // Catch:{ all -> 0x00bc }
            r5 = 0
            if (r15 == 0) goto L_0x005d
            java.lang.String r5 = r15._userid     // Catch:{ all -> 0x00bc }
        L_0x005d:
            r16 = r5
            java.util.TreeMap<java.lang.Long, tencent.tls.request.SigInfo> r5 = r4._tk_map     // Catch:{ all -> 0x00bc }
            java.util.Set r5 = r5.keySet()     // Catch:{ all -> 0x00bc }
            java.util.Iterator r17 = r5.iterator()     // Catch:{ all -> 0x00bc }
        L_0x0069:
            boolean r5 = r17.hasNext()     // Catch:{ all -> 0x00bc }
            if (r5 == 0) goto L_0x0020
            java.lang.Object r5 = r17.next()     // Catch:{ all -> 0x00bc }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x00bc }
            long r5 = r5.longValue()     // Catch:{ all -> 0x00bc }
            long r7 = tencent.tls.request.req_global.sdkappid     // Catch:{ all -> 0x00bc }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0080
            goto L_0x0069
        L_0x0080:
            java.util.TreeMap<java.lang.Long, tencent.tls.request.SigInfo> r7 = r4._tk_map     // Catch:{ all -> 0x00bc }
            java.lang.Long r8 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00bc }
            java.lang.Object r7 = r7.get(r8)     // Catch:{ all -> 0x00bc }
            tencent.tls.request.SigInfo r7 = (tencent.tls.request.SigInfo) r7     // Catch:{ all -> 0x00bc }
            if (r7 != 0) goto L_0x008f
            goto L_0x0069
        L_0x008f:
            if (r16 != 0) goto L_0x0095
            r1.clear_sig(r13, r5)     // Catch:{ all -> 0x00bc }
            goto L_0x0069
        L_0x0095:
            long r5 = r7._A1_create_time     // Catch:{ all -> 0x00bc }
            r8 = 0
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x009f
            long r5 = r7._TLS_create_time     // Catch:{ all -> 0x00bc }
        L_0x009f:
            r10 = r5
            tencent.tls.platform.TLSUserInfo r12 = new tencent.tls.platform.TLSUserInfo     // Catch:{ all -> 0x00bc }
            int r6 = r15._acc_type     // Catch:{ all -> 0x00bc }
            tencent.tls.request.TinyInfo$UserType r8 = r15.userType     // Catch:{ all -> 0x00bc }
            r5 = r12
            r7 = r16
            r18 = r8
            r8 = r13
            r19 = r2
            r2 = r12
            r12 = r18
            r5.<init>(r6, r7, r8, r10, r12)     // Catch:{ all -> 0x00bc }
            r0.add(r2)     // Catch:{ all -> 0x00bc }
            r2 = r19
            goto L_0x0069
        L_0x00ba:
            monitor-exit(r20)
            return r0
        L_0x00bc:
            r0 = move-exception
            monitor-exit(r20)
            goto L_0x00c0
        L_0x00bf:
            throw r0
        L_0x00c0:
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.request.account_sig_info_map.get_all_logined_account():java.util.List");
    }

    public synchronized int refreshTKTreeMap(TreeMap<?, ?> treeMap, String str) {
        int i;
        i = 0;
        if (TLS_TICKET_TABLE.equals(str) || TLS_ACCOUNT_TABLE.equals(str)) {
            i = saveTKTreeMap(treeMap, str);
        }
        return i;
    }

    public synchronized int saveTKTreeMap(TreeMap<?, ?> treeMap, String str) {
        int i;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(treeMap);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            i = write_to_db(this._context, str, cryptor.encrypt(byteArray, 0, byteArray.length, req_global._IMEI_KEY));
            objectOutputStream.close();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            QLog.e(th);
            i = TLSErrInfo.LOGIN_STORAGE_ERR;
        }
        return i;
    }

    public static TreeMap<?, ?> loadTKTreeMap(Context context, String str) {
        byte[] bArr = get_from_db(context, str);
        TreeMap<?, ?> treeMap = null;
        if (bArr != null) {
            QLog.i("get_from_db len:" + bArr.length);
            try {
                byte[] decrypt = cryptor.decrypt(bArr, 0, bArr.length, req_global._IMEI_KEY);
                if (decrypt != null) {
                    ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decrypt));
                    TreeMap<?, ?> treeMap2 = (TreeMap) objectInputStream.readObject();
                    if (treeMap2 == null) {
                        return null;
                    }
                    try {
                        objectInputStream.close();
                        return treeMap2;
                    } catch (Throwable th) {
                        th = th;
                        treeMap = treeMap2;
                        QLog.e(th);
                        return treeMap;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                QLog.e(th);
                return treeMap;
            }
        }
        return treeMap;
    }

    public static int write_to_db(Context context, String str, byte[] bArr) {
        try {
            if (tlsDBHelper == null) {
                tlsDBHelper = new TkDBHelper(context, tls_sdk_DBNAME, (SQLiteDatabase.CursorFactory) null, 1);
            }
            SQLiteDatabase writableDatabase = tlsDBHelper.getWritableDatabase();
            try {
                writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (ID INTEGER PRIMARY KEY, " + str + " BLOB);");
                try {
                    Cursor query = writableDatabase.query(str, new String[]{"ID"}, "ID=0", (String[]) null, (String) null, (String) null, (String) null);
                    if (query == null || !query.moveToFirst()) {
                        try {
                            writableDatabase.execSQL("insert into " + str + " (ID, " + str + ") values (?,?);", new Object[]{0, new byte[1]});
                        } catch (SQLException e2) {
                            QLog.e(e2);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            return TLSErrInfo.LOGIN_STORAGE_ERR;
                        }
                    }
                    try {
                        writableDatabase.execSQL("update " + str + " set " + str + " =? where ID=0", new Object[]{bArr});
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        return 0;
                    } catch (SQLException e3) {
                        tlsDBHelper = null;
                        QLog.e(e3);
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        return TLSErrInfo.LOGIN_STORAGE_ERR;
                    }
                } catch (SQLException e4) {
                    QLog.e(e4);
                    return TLSErrInfo.LOGIN_STORAGE_ERR;
                }
            } catch (Exception e5) {
                tlsDBHelper = null;
                QLog.e(e5);
                return TLSErrInfo.LOGIN_STORAGE_ERR;
            }
        } catch (Exception e6) {
            tlsDBHelper = null;
            QLog.e(e6);
            return TLSErrInfo.LOGIN_STORAGE_ERR;
        }
    }

    public static byte[] get_from_db(Context context, String str) {
        Cursor cursor;
        Boolean bool = false;
        try {
            if (tlsDBHelper == null) {
                tlsDBHelper = new TkDBHelper(context, tls_sdk_DBNAME, (SQLiteDatabase.CursorFactory) null, 1);
            }
            SQLiteDatabase writableDatabase = tlsDBHelper.getWritableDatabase();
            try {
                cursor = writableDatabase.rawQuery("select count(*) from sqlite_master where type ='table' and name ='" + str + "' ", (String[]) null);
                try {
                    if (cursor.moveToNext() && cursor.getInt(0) > 0) {
                        bool = true;
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    if (!bool.booleanValue()) {
                        return null;
                    }
                    Cursor query = writableDatabase.query(str, new String[]{str}, "ID=0", (String[]) null, (String) null, (String) null, (String) null);
                    if (query == null || !query.moveToFirst()) {
                        return null;
                    }
                    byte[] blob = query.getBlob(0);
                    query.close();
                    return blob;
                } catch (SQLException e2) {
                    e = e2;
                    tlsDBHelper = null;
                    QLog.e(e);
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLException e3) {
                e = e3;
                cursor = null;
                tlsDBHelper = null;
                QLog.e(e);
                cursor.close();
                return null;
            }
        } catch (Exception e4) {
            tlsDBHelper = null;
            QLog.e(e4);
            return null;
        }
    }
}
