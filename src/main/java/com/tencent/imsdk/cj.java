package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALValueCallBack;

final class cj implements QALValueCallBack {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TIMValueCallBack f30820a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30821b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30822c;

    cj(IMMsfCoreProxy iMMsfCoreProxy, TIMValueCallBack tIMValueCallBack, String str) {
        this.f30822c = iMMsfCoreProxy;
        this.f30820a = tIMValueCallBack;
        this.f30821b = str;
    }

    public final void onError(int i, String str) {
        IMErrInfo iMErrInfo = new IMErrInfo(i, str);
        BaseConstants.covertErrorCode(iMErrInfo);
        this.f30820a.onError(iMErrInfo.getCode(), iMErrInfo.getMsg());
    }

    public final void onSuccess(byte[] bArr) {
        String str;
        StringBuilder sb;
        if (IMCoreWrapper.get().isIMCoreInited()) {
            sb = new StringBuilder("cmd:");
            sb.append(this.f30821b);
            str = "|rsp";
        } else {
            sb = new StringBuilder("cmd:");
            sb.append(this.f30821b);
            sb.append("|rsp:");
            str = IMFunc.byte2hex(bArr);
        }
        sb.append(str);
        QLog.d("imsdk.IMMsfCoreProxy", 1, sb.toString());
        if (this.f30821b.equals("im_open_msg.msg_sync") || this.f30821b.equals("group_open_svc.group_msg_get") || this.f30821b.equals("Recentcontact.Get_PB")) {
            this.f30822c.pool.execute(new ck(this, bArr));
        } else {
            this.f30820a.onSuccess(bArr);
        }
    }
}
