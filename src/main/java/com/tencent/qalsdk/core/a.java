package com.tencent.qalsdk.core;

import com.g.a.a.e;
import com.g.a.a.f;
import com.tencent.qalsdk.config.NativeConfigStore;
import com.tencent.qalsdk.util.CodecWarpper;
import com.tencent.qalsdk.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f32165a = null;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, com.tencent.qalsdk.sdk.a> f32166b = new ConcurrentHashMap<>();

    public final void a() {
        ArrayList arrayList = new ArrayList();
        try {
            a((ArrayList<com.tencent.qalsdk.sdk.a>) arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.qalsdk.sdk.a aVar = (com.tencent.qalsdk.sdk.a) it.next();
                try {
                    b(aVar);
                    n.f32209a = aVar.f32228f;
                    CodecWarpper.setAccountKey(aVar.f32224b, (byte[]) null, aVar.f32225c, (byte[]) null, (byte[]) null, aVar.f32226d, (byte[]) null, aVar.f32227e, (byte[]) null, (String) null);
                    n.a(aVar.f32224b, false);
                    QLog.i("MSF.C.AccountCenter", 2, "handle account: " + aVar.f32224b + ":" + aVar.f32223a);
                } catch (Exception e2) {
                    QLog.e("MSF.C.AccountCenter", 1, "parse account error " + e2.toString(), e2);
                }
            }
        } catch (UnsatisfiedLinkError unused) {
            QLog.e("MSF.C.AccountCenter", "AccountCenter init UnsatisfiedLinkError. so init:" + j.f32185a.get());
        }
    }

    private static void a(ArrayList<com.tencent.qalsdk.sdk.a> arrayList) {
        if (arrayList.size() == 0) {
            String[] configList = l.a().getConfigList("key_account_head_");
            if (configList != null && configList.length > 0) {
                QLog.d("MSF.C.AccountCenter", 1, "try load accounts " + configList.length);
                for (String a2 : configList) {
                    try {
                        e eVar = new e(com.g.a.a.a.a(a2));
                        com.tencent.qalsdk.sdk.a aVar = new com.tencent.qalsdk.sdk.a();
                        aVar.readFrom(eVar);
                        arrayList.add(aVar);
                        QLog.i("MSF.C.AccountCenter", 2, "load account tinyid:" + aVar.f32224b + ":" + aVar.f32223a + " registed:" + aVar.f32229g);
                    } catch (Throwable th) {
                        QLog.w("MSF.C.AccountCenter", 1, "parse account error " + th.toString(), th);
                    }
                }
            }
        }
    }

    private void b(com.tencent.qalsdk.sdk.a aVar) {
        this.f32166b.put(aVar.f32224b, aVar);
        QLog.i("MSF.C.AccountCenter", "addAccount " + aVar.f32224b + ":" + aVar.f32223a);
    }

    public final synchronized void a(com.tencent.qalsdk.sdk.a aVar) {
        try {
            b(aVar);
            n.f32209a = aVar.f32228f;
            CodecWarpper.setAccountKey(aVar.f32224b, (byte[]) null, aVar.f32225c, (byte[]) null, (byte[]) null, aVar.f32226d, (byte[]) null, aVar.f32227e, (byte[]) null, (String) null);
            n.a(aVar.f32224b, false);
            this.f32165a = aVar.f32224b;
            String str = aVar.f32224b;
            try {
                f fVar = new f();
                this.f32166b.get(str).writeTo(fVar);
                String a2 = com.g.a.a.a.a(fVar.a());
                NativeConfigStore a3 = l.a();
                a3.n_setConfig("key_account_head_" + str, a2);
                QLog.i("MSF.C.AccountCenter", 4, "storeAccount tinyID:" + str);
            } catch (Exception e2) {
                QLog.e("MSF.C.AccountCenter", "storeAccount exception:" + e2.getMessage());
                return;
            }
        } catch (Exception e3) {
            QLog.e("MSF.C.AccountCenter", "setAndStorAccount exception:" + e3.getMessage());
        }
        return;
    }

    public final String b() {
        return this.f32165a;
    }

    public final ConcurrentHashMap<String, com.tencent.qalsdk.sdk.a> c() {
        return this.f32166b;
    }

    public final boolean a(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    NativeConfigStore a2 = l.a();
                    a2.n_removeConfig("key_account_head_" + str);
                }
            } catch (Exception e2) {
                QLog.e("MSF.C.AccountCenter", "removeAccount exception:" + e2.getMessage());
            }
        }
        QLog.i("MSF.C.AccountCenter", 2, "del user " + str + " succ.");
        this.f32166b.remove(str);
        return true;
    }

    public final synchronized void a(String str, long j) {
        com.tencent.qalsdk.sdk.a aVar = this.f32166b.get(str);
        if (aVar != null) {
            aVar.h = j;
        }
    }

    public final long b(String str) {
        com.tencent.qalsdk.sdk.a aVar = this.f32166b.get(str);
        if (aVar != null) {
            return aVar.h;
        }
        return 0;
    }
}
