package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imcore.IMCore;
import com.tencent.imcore.IMCoreUser;
import com.tencent.imsdk.log.QLog;

final class ch implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f30814a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ byte[] f30815b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ cg f30816c;

    ch(cg cgVar, String str, byte[] bArr) {
        this.f30816c = cgVar;
        this.f30814a = str;
        this.f30815b = bArr;
    }

    public final void run() {
        String identifier = TextUtils.isEmpty(this.f30814a) ? TIMManager.getInstance().getIdentifier() : this.f30814a;
        QLog.i("imsdk.IMMsfCoreProxy", 1, "RecvMsg|1-OnlinePush|Succ|cmd=im_open_push.msg_push, " + this.f30814a + "|" + identifier);
        if (this.f30816c.f30813b.mode == 1 && IMCoreWrapper.get().isIMCoreInited()) {
            try {
                IMCoreUser user = IMCore.get().getUser(identifier);
                if (user.fake()) {
                    this.f30816c.f30813b.handleMsg(this.f30814a, this.f30816c.f30812a, this.f30815b);
                } else if (user.manualPush(this.f30815b) != 0) {
                    this.f30816c.f30813b.handleMsg(this.f30814a, this.f30816c.f30812a, this.f30815b);
                }
            } catch (Throwable th) {
                QLog.e("imsdk.IMMsfCoreProxy", 1, IMFunc.getExceptionInfo(th));
            }
        } else {
            this.f30816c.f30813b.handleMsg(this.f30814a, this.f30816c.f30812a, this.f30815b);
        }
    }
}
