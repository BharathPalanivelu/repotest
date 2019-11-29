package com.tencent.qalsdk.sdk;

import com.g.a.a.f;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;
import qalsdk.aa;

public final class v extends w {

    /* renamed from: f  reason: collision with root package name */
    private static v f32277f = new v();

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f32278a = false;

    /* renamed from: b  reason: collision with root package name */
    s f32279b;

    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public final /* bridge */ /* synthetic */ void a(String str, int i, String str2) {
        super.a(str, i, str2);
    }

    public final /* bridge */ /* synthetic */ boolean a(FromServiceMsg fromServiceMsg) {
        return super.a(fromServiceMsg);
    }

    public final /* bridge */ /* synthetic */ boolean a(r rVar) {
        return super.a(rVar);
    }

    public final /* bridge */ /* synthetic */ LinkedBlockingDeque c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ String d() {
        return super.d();
    }

    private v() {
    }

    public static v a() {
        return f32277f;
    }

    public final void a(int i, String str, String str2, String str3) {
        this.f32279b = new s(str2);
        this.f32279b.a(this);
        super.a(str3, 537050853, str);
        this.f32278a = true;
    }

    public final String b() {
        if (this.f32278a) {
            return this.f32279b.f32273a.f32283d;
        }
        this.f32279b = new s("com.tencent.mobileqq.msf.service.MsfService");
        this.f32279b.a(this);
        this.f32278a = true;
        this.f32282c = 88886666;
        return this.f32279b.f32273a.f32283d;
    }

    public final ToServiceMsg a(aa aaVar) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(b(), aaVar.f34057a, "push.cmdRegister");
        toServiceMsg.setMsfCommand(MsfCommand.registerCmdCallback);
        f fVar = new f();
        aaVar.writeTo(fVar);
        toServiceMsg.addAttribute("to_push_cmdCallbackerInfo", fVar.a());
        toServiceMsg.setAppId(this.f32282c);
        toServiceMsg.setTimeout(10000);
        MsfSdkUtils.addToMsgProcessName(this.f32284e, toServiceMsg);
        return toServiceMsg;
    }

    public final int a(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return -1;
        }
        QLog.d("MsfServiceSdk", "sdk sendMsg. ssoCmd:" + toServiceMsg.getServiceCmd() + " msfCmd:" + toServiceMsg.getMsfCommand() + " appSeq:" + toServiceMsg.getAppSeq());
        if (toServiceMsg.getServiceName().equals(b())) {
            return this.f32279b.b(toServiceMsg);
        }
        return b.a(toServiceMsg);
    }
}
