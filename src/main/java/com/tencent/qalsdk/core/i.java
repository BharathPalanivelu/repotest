package com.tencent.qalsdk.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.location.places.Place;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.QLog;
import qalsdk.k;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    j f32180a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Handler f32181b;

    public i(j jVar) {
        this.f32180a = jVar;
    }

    public final void a() {
        HandlerThread handlerThread = new HandlerThread("MsfCoreTimeoutChecker", 5);
        handlerThread.start();
        this.f32181b = new Handler(handlerThread.getLooper());
    }

    public final Runnable a(ToServiceMsg toServiceMsg, long j) {
        a aVar = new a(toServiceMsg);
        if (!(toServiceMsg == null || this.f32181b == null)) {
            this.f32181b.postDelayed(aVar, j);
        }
        return aVar;
    }

    public final Runnable a(k kVar, long j) {
        if (kVar == null || this.f32181b == null) {
            return null;
        }
        b bVar = new b(this, kVar);
        this.f32181b.postDelayed(bVar, 300000);
        return bVar;
    }

    public final void a(Runnable runnable) {
        if (runnable != null && this.f32181b != null) {
            this.f32181b.removeCallbacks(runnable);
        }
    }

    public final Handler b() {
        return this.f32181b;
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private ToServiceMsg f32182a;

        public a(ToServiceMsg toServiceMsg) {
            this.f32182a = toServiceMsg;
        }

        public final void run() {
            if (this.f32182a != null) {
                try {
                    ToServiceMsg toServiceMsg = i.this.f32180a.f32187c.f().get(Integer.valueOf(this.f32182a.getRequestSsoSeq()));
                    if (toServiceMsg != null && toServiceMsg.isNeedCallback()) {
                        ToServiceMsg remove = i.this.f32180a.f32187c.f().remove(Integer.valueOf(this.f32182a.getRequestSsoSeq()));
                        if (remove == null) {
                            QLog.d("MSF.C.NetConnTag", 2, "timeout msg " + remove + " also received resp, return.");
                            return;
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.i("MSF.C.NetConnTag", 1, "[MsfAlarmer] netRecv ssoSeq:" + remove.getRequestSsoSeq() + " uin:" + remove.getUin() + " cmd:" + remove.getServiceCmd() + " len:0" + " costTime:" + remove.getTimeout() + NetConnInfoCenter.getSignalStrengthsLog() + " code:1002" + " failMsg:" + "wait serverResp timeout");
                        } else {
                            QLog.i("MSF.C.NetConnTag", 1, "[MsfAlarmer] netRecv ssoSeq:" + remove.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(remove.getUin()) + " cmd:" + remove.getServiceCmd() + " len:0" + " costTime:" + remove.getTimeout() + NetConnInfoCenter.getSignalStrengthsLog() + " code:1002" + " failMsg:" + "wait serverResp timeout");
                        }
                        FromServiceMsg a2 = k.a(remove);
                        int i = 1002;
                        if (i.this.f32180a.f32187c.k.a() || !i.this.f32180a.f32187c.k.c()) {
                            if (!i.this.f32180a.f32187c.k.a() && i.this.f32180a.f32187c.k.b()) {
                                QLog.i("MSF.C.NetConnTag", "package timeout, no conn && no network");
                            } else if (i.this.f32180a.f32187c.k.f34158b.e()) {
                                i = 1018;
                                QLog.i("MSF.C.NetConnTag", "package timeout, wifi does not have internet connection");
                            } else if (!i.this.f32180a.f32187c.k.f34159c.a()) {
                                QLog.i("MSF.C.NetConnTag", "package timeout, xg no conn && no network");
                            } else if (((Boolean) remove.getAttribute("shortConnection", false)).booleanValue() && ((Boolean) remove.getAttribute("noAvailableShortConnIP", false)).booleanValue()) {
                                i = 1019;
                                QLog.i("MSF.C.NetConnTag", "package timeout, no available short conn ip");
                            }
                            i = Place.TYPE_POST_BOX;
                        } else {
                            i = Place.TYPE_POSTAL_CODE;
                            QLog.i("MSF.C.NetConnTag", "package timeout, no try conn");
                        }
                        a2.setBusinessFail(i, "wait serverResp timeout");
                        if (i.this.f32180a.f32187c.a(remove, a2)) {
                            try {
                                i.this.f32180a.f().a(remove, a2);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e3) {
                    QLog.d("MSF.C.NetConnTag", 1, "got fail msg. " + e3, e3);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag", 2, "req null, return.");
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private k f32184a;

        public b(i iVar, k kVar) {
            this.f32184a = kVar;
        }

        public final void run() {
            k kVar = this.f32184a;
            if (kVar != null) {
                try {
                    kVar.e();
                } catch (Exception e2) {
                    QLog.d("MSF.C.NetConnTag", 1, "call loginConnectTimeOut error " + e2);
                }
            }
        }
    }
}
