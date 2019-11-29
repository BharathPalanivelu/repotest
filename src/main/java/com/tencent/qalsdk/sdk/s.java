package com.tencent.qalsdk.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.RemoteException;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.location.places.Place;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qalsdk.QALInitListener;
import com.tencent.qalsdk.QALSDKManager;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.IMsfServiceCallbacker;
import com.tencent.qalsdk.base.remote.MsfServiceBindInfo;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.core.NetConnInfoCenter;
import com.tencent.qalsdk.core.k;
import com.tencent.qalsdk.util.QLog;

final class s extends x {

    /* renamed from: a  reason: collision with root package name */
    v f32273a;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f32274g = false;
    private IMsfServiceCallbacker h = new t(this);

    public s(String str) {
        super(str);
    }

    public final void a(v vVar) {
        this.f32273a = vVar;
        vVar.f32283d = this.f32292f;
    }

    /* access modifiers changed from: protected */
    public final void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        b(toServiceMsg, fromServiceMsg);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        try {
            ComponentName componentName = new ComponentName(QALSDKManager.getInstance().getContext().getPackageName(), this.f32273a.f32283d);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra("to_SenderProcessName", this.f32273a.f32284e);
            QALSDKManager.getInstance().getContext().startService(intent);
            QLog.d("MsfServiceProxy", 1, "start service finish");
        } catch (Exception e2) {
            QLog.d("MsfServiceProxy", 1, SQLBuilder.BLANK + e2, e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        boolean z = false;
        try {
            ComponentName componentName = new ComponentName(QALSDKManager.getInstance().getContext().getPackageName(), this.f32273a.f32283d);
            Intent intent = new Intent();
            intent.putExtra("to_SenderProcessName", this.f32273a.f32284e);
            intent.setComponent(componentName);
            z = QALSDKManager.getInstance().getContext().bindService(intent, this.f32291e, 1);
            QLog.d("MsfServiceProxy", 1, "threadID:" + Thread.currentThread().getId() + ", threadName: " + Thread.currentThread().getName() + " bind " + this.f32273a.f32283d + " service finished " + z);
            return z;
        } catch (Exception e2) {
            QLog.d("MsfServiceProxy", 1, SQLBuilder.BLANK + e2, e2);
            return z;
        }
    }

    public final boolean c() {
        try {
            ComponentName componentName = new ComponentName(QALSDKManager.getInstance().getContext().getPackageName(), this.f32273a.f32283d);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra("to_SenderProcessName", this.f32273a.f32284e);
            boolean stopService = QALSDKManager.getInstance().getContext().stopService(intent);
            QLog.i("MsfServiceProxy", 2, " stopService service finished: " + stopService);
            return stopService;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final int a(ToServiceMsg toServiceMsg) throws RemoteException {
        if (toServiceMsg == null) {
            return -1;
        }
        toServiceMsg.setAppId(this.f32273a.f32282c);
        toServiceMsg.getAttributes().put("to_SendTime", Long.valueOf(System.currentTimeMillis()));
        toServiceMsg.getAttributes().put("to_SenderProcessName", this.f32273a.f32284e);
        if (QLog.isColorLevel()) {
            QLog.d("MsfServiceProxy", 2, " send req to msfService:" + toServiceMsg);
        }
        return this.f32290d.sendToServiceMsg(toServiceMsg);
    }

    public final void e() {
        while (!f32287b.isEmpty()) {
            ToServiceMsg toServiceMsg = (ToServiceMsg) f32287b.poll();
            if (toServiceMsg != null) {
                try {
                    a(toServiceMsg);
                } catch (Exception e2) {
                    FromServiceMsg a2 = k.a(toServiceMsg);
                    a2.setBusinessFail(Place.TYPE_POINT_OF_INTEREST, toServiceMsg.getServiceName() + "sendMsgToServiceFailed，" + e2.toString());
                    b(toServiceMsg, a2);
                }
            }
        }
    }

    public final void f() {
        super.f();
        this.h = null;
    }

    private static boolean a(FromServiceMsg fromServiceMsg) {
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        if (fromServiceMsg.getAttributes().containsKey("_attr_sameDevice")) {
            ((Boolean) fromServiceMsg.getAttribute("_attr_sameDevice")).booleanValue();
        }
        if (businessFailCode != 2001) {
            if (businessFailCode != 2009) {
                switch (businessFailCode) {
                    case 2011:
                    case 2012:
                    case 2013:
                    case 2014:
                        break;
                    default:
                        return false;
                }
            }
            return true;
        }
        QLog.d("MsfServiceProxy", 1, "BaseConstants.CODE_NO_LOGIN " + fromServiceMsg.hashCode());
        return true;
    }

    /* access modifiers changed from: protected */
    public final void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d("MsfServiceProxy", 2, "add fail queue req:" + toServiceMsg + " from:" + fromServiceMsg);
        }
        this.f32273a.a(new r(toServiceMsg, fromServiceMsg));
    }

    /* access modifiers changed from: protected */
    public final void d() {
        ToServiceMsg toServiceMsg = new ToServiceMsg(this.f32273a.f32283d, AppEventsConstants.EVENT_PARAM_VALUE_NO, "cmd_RegisterMsfService");
        toServiceMsg.setMsfCommand(MsfCommand.registerMsfService);
        toServiceMsg.getAttributes().put("intent_bindServiceInfo", new MsfServiceBindInfo(this.f32273a.f32282c, this.f32273a.f32284e, this.f32273a.d(), this.h));
        toServiceMsg.setNeedCallback(false);
        this.f32274g = true;
        int b2 = b(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("MsfServiceProxy", 2, " registerMsfService result:" + b2);
        }
        u uVar = new u(this);
        uVar.setName("handleWaitSendProxyMsgThread");
        try {
            uVar.start();
        } catch (Throwable th) {
            QLog.i("MsfServiceProxy", 1, "error: " + th, th);
            e();
        }
        for (QALInitListener onInitSuccess : c.a().j().keySet()) {
            onInitSuccess.onInitSuccess();
        }
    }

    static /* synthetic */ void a(s sVar, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg2;
        QLog.d("MsfServiceProxy", "msfProxy onReceiveResp:" + toServiceMsg.getUin() + ":" + toServiceMsg.getServiceCmd() + " :" + toServiceMsg.getRequestSsoSeq() + ":" + toServiceMsg.getAppSeq());
        if (toServiceMsg.isHttpReq()) {
            toServiceMsg2 = (ToServiceMsg) f32288c.get(Integer.valueOf(toServiceMsg.getAppSeq()));
        } else {
            toServiceMsg2 = (ToServiceMsg) f32288c.remove(Integer.valueOf(toServiceMsg.getAppSeq()));
            QLog.d("MsfServiceProxy", "waiteSendSeqSet receiveResp remove:" + toServiceMsg.getUin() + ":" + toServiceMsg.getServiceCmd() + " :" + toServiceMsg.getRequestSsoSeq() + ":" + toServiceMsg.getAppSeq());
        }
        if (toServiceMsg2 != null) {
            QLog.d("MsfServiceProxy", "onReceiveResp SsoCmd:" + toServiceMsg.getServiceCmd() + " ssoSeq:" + toServiceMsg.getRequestSsoSeq());
            if (a(fromServiceMsg)) {
                return;
            }
            if (sVar.f32274g) {
                QLog.d("MsfServiceProxy", 2, "sdk add queue req:" + toServiceMsg + " from:" + fromServiceMsg);
                sVar.f32273a.a(new r(toServiceMsg, fromServiceMsg));
                return;
            }
            QLog.d("MsfServiceProxy", 2, " close msfServiceConn. msg is droped." + toServiceMsg.getRequestSsoSeq() + SQLBuilder.BLANK + fromServiceMsg);
            return;
        }
        QLog.d("MsfServiceProxy", 2, " found timeout resp to:" + toServiceMsg + " from:" + fromServiceMsg);
    }

    static /* synthetic */ void a(s sVar, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d("MsfServiceProxy", 2, " onRecvPushResp " + fromServiceMsg);
        }
        if (a(fromServiceMsg)) {
            return;
        }
        if (fromServiceMsg.getMsfCommand() == MsfCommand.pushSetConfig) {
            NetConnInfoCenter.socketConnState = ((Integer) fromServiceMsg.getAttribute("_attr_socket_connstate")).intValue();
            NetConnInfoCenter.servetTimeSecondInterv = ((Long) fromServiceMsg.getAttribute("_attr_server")).longValue();
            QLog.d("MsfServiceProxy", "server interval time:" + NetConnInfoCenter.servetTimeSecondInterv);
        } else if (sVar.f32274g) {
            QLog.d("MsfServiceProxy", 2, "onRecvServicePushResp  SsoCmd:" + fromServiceMsg.getServiceCmd() + " ssoSeq:" + fromServiceMsg.getRequestSsoSeq());
            sVar.f32273a.a(fromServiceMsg);
        } else if (QLog.isColorLevel()) {
            QLog.d("MsfServiceProxy", 2, " close msfServiceConn. push msg is droped." + fromServiceMsg);
        }
    }
}
