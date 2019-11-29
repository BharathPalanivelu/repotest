package com.tencent.qalsdk.service;

import android.content.Context;
import android.os.DeadObjectException;
import android.text.TextUtils;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.IMsfServiceCallbacker;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.sdk.r;
import com.tencent.qalsdk.util.QLog;

final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f32299a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f32300b = false;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f32301c = true;

    /* renamed from: d  reason: collision with root package name */
    private int f32302d = 0;

    a() {
    }

    private static boolean a(String str, b bVar) {
        int i;
        String str2 = str;
        b bVar2 = bVar;
        int i2 = 0;
        while (true) {
            if (bVar2.f32306d.isEmpty()) {
                break;
            }
            i = i2 + 1;
            if (i > 10) {
                break;
            }
            r poll = bVar2.f32306d.poll();
            if (poll == null) {
                break;
            }
            IMsfServiceCallbacker a2 = bVar.a();
            boolean z = a2 == null;
            if (!z) {
                try {
                    if (poll.f32271a == null) {
                        a2.onRecvPushResp(poll.f32272b);
                        QLog.d("MSF.S.AppProcessManager", 2, "send push " + str2 + " from:" + poll.f32272b.getUin() + "|" + poll.f32272b.getServiceCmd() + "|" + poll.f32272b.getRequestSsoSeq());
                    } else {
                        a2.onResponse(poll.f32271a, poll.f32272b);
                        QLog.i("MSF.S.AppProcessManager", 2, "service send resp :" + str2 + "| from:" + poll.f32272b.getUin() + "|" + poll.f32272b.getServiceCmd() + "|" + poll.f32272b.getRequestSsoSeq() + "|" + poll.f32271a.getAppSeq());
                    }
                } catch (DeadObjectException unused) {
                    bVar2.f32306d.addFirst(new r(poll.f32271a, poll.f32272b));
                    bVar.b();
                    QLog.i("MSF.S.AppProcessManager", 2, "DeadObjectException,add queue first " + poll.f32272b.getUin() + "|" + poll.f32272b.getServiceCmd() + "|" + poll.f32272b.getRequestSsoSeq());
                    z = true;
                } catch (Exception e2) {
                    QLog.e("MSF.S.AppProcessManager", 2, poll.toString() + SQLBuilder.BLANK + poll.f32272b, e2);
                }
            }
            if (z) {
                QLog.i("MSF.S.AppProcessManager", 2, "boot proccess" + str2 + " from:" + poll.f32272b.getUin() + ":" + poll.f32272b.getMsfCommand() + ":" + poll.f32272b.getServiceCmd());
                if (poll.f32272b.getMsfCommand() != MsfCommand.onRecvPushMsg) {
                    QLog.d("MSF.S.AppProcessManager", "proccess died,msf command need no boot");
                    bVar2.f32306d.poll();
                    break;
                }
                try {
                    String uin = poll.f32272b.getUin();
                    FromServiceMsg fromServiceMsg = poll.f32272b;
                    if (!TextUtils.isEmpty(bVar2.f32305c)) {
                        int a3 = c.f32311b.a(uin);
                        com.tencent.qalsdk.sdk.a aVar = j.a().c().c().get(uin);
                        if (aVar != null) {
                            Context context = QalService.context;
                            String str3 = bVar2.f32304b;
                            String str4 = aVar.f32223a;
                            String str5 = bVar2.f32305c;
                            String serviceCmd = fromServiceMsg.getServiceCmd();
                            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                            byte[] bArr = null;
                            if (wupBuffer.length - 4 >= 0) {
                                bArr = new byte[(wupBuffer.length - 4)];
                                System.arraycopy(wupBuffer, 4, bArr, 0, wupBuffer.length - 4);
                            }
                            com.tencent.qalsdk.config.a.a(context, str3, str4, str5, a3, serviceCmd, bArr);
                        }
                    }
                    bVar2.f32306d.poll();
                    return false;
                } catch (Exception e3) {
                    QLog.d("MSF.S.AppProcessManager", 1, "Boot exception", e3);
                }
            } else {
                i2 = i;
            }
        }
        i2 = i;
        return i2 > 10;
    }

    public final void run() {
        while (true) {
            if (this.f32301c) {
                this.f32301c = false;
                this.f32302d = 0;
                for (String next : c.f32310a.keySet()) {
                    b bVar = c.f32310a.get(next);
                    if (bVar != null) {
                        if (a(next, bVar)) {
                            this.f32301c = true;
                        }
                        this.f32302d += bVar.f32306d.size();
                    }
                }
            } else {
                this.f32300b = true;
                synchronized (this.f32299a) {
                    if (this.f32300b) {
                        try {
                            if (this.f32302d == 0) {
                                this.f32299a.wait(61440);
                            } else {
                                this.f32299a.wait(600);
                            }
                            this.f32301c = true;
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void a() {
        synchronized (this.f32299a) {
            this.f32301c = true;
            this.f32300b = false;
            this.f32299a.notify();
        }
    }
}
