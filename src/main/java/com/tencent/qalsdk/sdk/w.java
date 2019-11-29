package com.tencent.qalsdk.sdk;

import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;

class w {

    /* renamed from: a  reason: collision with root package name */
    private LinkedBlockingDeque<r> f32280a = new LinkedBlockingDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private String f32281b;

    /* renamed from: c  reason: collision with root package name */
    protected int f32282c;

    /* renamed from: d  reason: collision with root package name */
    protected String f32283d;

    /* renamed from: e  reason: collision with root package name */
    protected String f32284e;

    /* renamed from: f  reason: collision with root package name */
    private Object f32285f = new Object();

    w() {
    }

    public void a(String str, int i, String str2) {
        this.f32282c = i;
        a(str2);
        this.f32284e = str;
    }

    public boolean a(r rVar) {
        boolean z;
        if (MsfSdkUtils.isPrivilegeCMD(rVar.f32272b.getServiceCmd())) {
            this.f32280a.addFirst(rVar);
            QLog.d("MsfServiceSub", "serviceSub add first:" + System.currentTimeMillis() + "|" + rVar.f32272b.getServiceCmd() + "|" + rVar.f32272b.getRequestSsoSeq() + "|" + rVar.f32272b.getAppSeq());
            z = true;
        } else {
            boolean add = this.f32280a.add(rVar);
            QLog.d("MsfServiceSub", "serviceSub add last:" + System.currentTimeMillis() + "|" + rVar.f32272b.getServiceCmd() + "|" + rVar.f32272b.getRequestSsoSeq());
            z = add;
        }
        synchronized (this.f32285f) {
            this.f32285f.notify();
        }
        return z;
    }

    public boolean a(FromServiceMsg fromServiceMsg) {
        boolean add = this.f32280a.add(new r((ToServiceMsg) null, fromServiceMsg));
        if (!(fromServiceMsg == null || fromServiceMsg.getServiceCmd() == null)) {
            fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c");
        }
        synchronized (this.f32285f) {
            this.f32285f.notify();
        }
        return add;
    }

    public String d() {
        return this.f32281b;
    }

    public void a(String str) {
        this.f32281b = str;
    }

    public LinkedBlockingDeque<r> c() {
        return this.f32280a;
    }
}
