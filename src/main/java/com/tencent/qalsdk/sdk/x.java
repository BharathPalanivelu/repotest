package com.tencent.qalsdk.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.google.android.gms.location.places.Place;
import com.tencent.qalsdk.QALSDKManager;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.IBaseService;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.core.k;
import com.tencent.qalsdk.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class x {

    /* renamed from: a  reason: collision with root package name */
    private static int f32286a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected static ConcurrentLinkedQueue<ToServiceMsg> f32287b = new ConcurrentLinkedQueue<>();

    /* renamed from: c  reason: collision with root package name */
    protected static ConcurrentHashMap<Integer, ToServiceMsg> f32288c = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private static long f32289g = -1;
    private static boolean h = false;

    /* renamed from: d  reason: collision with root package name */
    protected volatile IBaseService f32290d;

    /* renamed from: e  reason: collision with root package name */
    protected ServiceConnection f32291e = new y(this);

    /* renamed from: f  reason: collision with root package name */
    String f32292f;
    private Object i = new Object();
    private volatile Handler j;
    private volatile long k = -1;
    private volatile long l = -1;
    private volatile int m = -1;
    private AtomicInteger n = new AtomicInteger();

    public x(String str) {
        this.f32292f = str;
    }

    /* access modifiers changed from: protected */
    public void d() {
        z zVar = new z(this);
        zVar.setName("handleWaitSendProxyMsgThread");
        zVar.start();
    }

    /* access modifiers changed from: protected */
    public int a(ToServiceMsg toServiceMsg) throws RemoteException {
        return this.f32290d.sendToServiceMsg(toServiceMsg);
    }

    protected static FromServiceMsg a(ToServiceMsg toServiceMsg, String str) {
        FromServiceMsg a2 = k.a(toServiceMsg);
        a2.setBusinessFail(Place.TYPE_POINT_OF_INTEREST, str);
        return a2;
    }

    /* access modifiers changed from: protected */
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        b(toServiceMsg, fromServiceMsg);
    }

    /* access modifiers changed from: protected */
    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        v.a().a(new r(toServiceMsg, fromServiceMsg));
    }

    public final int b(ToServiceMsg toServiceMsg) {
        boolean z;
        if (toServiceMsg == null) {
            return -1;
        }
        if (toServiceMsg.getAppSeq() < 0) {
            toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        }
        try {
            synchronized (this.i) {
                if (this.j == null) {
                    HandlerThread handlerThread = new HandlerThread("Timeout-Checker", 5);
                    handlerThread.start();
                    this.j = new Handler(handlerThread.getLooper());
                }
                z = false;
                if (this.f32290d != null) {
                    z = true;
                }
            }
            if (toServiceMsg.getTimeout() == -1) {
                toServiceMsg.setTimeout(10000);
            }
            if (toServiceMsg.isNeedCallback()) {
                toServiceMsg.addAttribute("appTimeoutReq", Integer.valueOf(this.n.incrementAndGet()));
                f32288c.put(Integer.valueOf(toServiceMsg.getAppSeq()), toServiceMsg);
                QLog.d("MSF.D.RemoteServiceProxy", "waiteSendSeqSet put:" + toServiceMsg.getUin() + toServiceMsg.getServiceCmd() + " :" + toServiceMsg.getRequestSsoSeq() + ":" + toServiceMsg.getAppSeq());
                a aVar = new a(toServiceMsg);
                if (!"LongConn.OffPicUp".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                    if (!"ImgStore.GroupPicUp".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                        this.j.postDelayed(aVar, toServiceMsg.getTimeout() + 2000);
                    }
                }
                this.j.postDelayed(aVar, toServiceMsg.getTimeout() + 20000);
                QLog.d("MSF.D.RemoteServiceProxy", 1, "PicUpMsg timer start, appSeq: " + toServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(toServiceMsg.getTimeout() + 20000));
            }
            if (z) {
                return a(toServiceMsg);
            }
            f32287b.add(toServiceMsg);
            synchronized (this.i) {
                a();
                b();
            }
            return -1;
        } catch (DeadObjectException unused) {
            QLog.e("MSF.D.RemoteServiceProxy", 1, "DeadObjectException!!!");
            f32287b.add(toServiceMsg);
            a();
            b();
        } catch (Exception e2) {
            if (this.f32290d == null) {
                f32287b.add(toServiceMsg);
            } else {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        try {
            ComponentName componentName = new ComponentName(QALSDKManager.getInstance().getContext().getPackageName(), this.f32292f);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            QALSDKManager.getInstance().getContext().startService(intent);
            if (QLog.isColorLevel()) {
                QLog.d("MSF.D.RemoteServiceProxy", 2, " start service finish");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        boolean z = false;
        try {
            ComponentName componentName = new ComponentName(QALSDKManager.getInstance().getContext().getPackageName(), this.f32292f);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            z = QALSDKManager.getInstance().getContext().bindService(intent, this.f32291e, 1);
            if (QLog.isColorLevel()) {
                QLog.d("MSF.D.RemoteServiceProxy", 2, " bind " + this.f32292f + " service finished " + z);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return z;
    }

    public void f() {
        try {
            QALSDKManager.getInstance().getContext().unbindService(this.f32291e);
            this.f32290d = null;
            QLog.i("MSF.D.RemoteServiceProxy", " unbindService service finished");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean c() {
        try {
            ComponentName componentName = new ComponentName(QALSDKManager.getInstance().getContext(), this.f32292f);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            boolean stopService = QALSDKManager.getInstance().getContext().stopService(intent);
            if (QLog.isColorLevel()) {
                QLog.d("MSF.D.RemoteServiceProxy", 2, " stopService " + this.f32292f + " service finished " + stopService);
            }
            return stopService;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private ToServiceMsg f32293a;

        public a(ToServiceMsg toServiceMsg) {
            this.f32293a = toServiceMsg;
        }

        public final void run() {
            if ("LongConn.OffPicUp".equalsIgnoreCase(this.f32293a.getServiceCmd()) || "ImgStore.GroupPicUp".equalsIgnoreCase(this.f32293a.getServiceCmd())) {
                QLog.d("MSF.D.RemoteServiceProxy", 1, "enter MonitorTaskWrapper.run(), appseq is " + this.f32293a.getAppSeq());
            }
            ToServiceMsg toServiceMsg = x.f32288c.get(Integer.valueOf(this.f32293a.getAppSeq()));
            if (toServiceMsg != null && toServiceMsg.getAttribute("appTimeoutReq", -1) == this.f32293a.getAttribute("appTimeoutReq", -2)) {
                ToServiceMsg remove = x.f32288c.remove(Integer.valueOf(this.f32293a.getAppSeq()));
                if (remove != null) {
                    QLog.i("MSF.D.RemoteServiceProxy", 1, "waiteSendSeqSet remove:" + remove.getUin() + ":" + remove.getServiceCmd() + " :" + remove.getRequestSsoSeq() + ":" + remove.getAppSeq() + ":" + this.f32293a.getAppSeq());
                    ToServiceMsg toServiceMsg2 = this.f32293a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f32293a.getServiceName());
                    sb.append(" timeout");
                    x.this.a(this.f32293a, x.a(toServiceMsg2, sb.toString()));
                }
            }
        }
    }

    static /* synthetic */ void a(x xVar) {
        f32286a = 0;
        xVar.l = -1;
        f32289g = -1;
        h = false;
    }
}
