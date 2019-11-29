package com.tencent.imsdk;

import com.tencent.imsdk.protocol.msg_push;

final class ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMValueCallBack f30817a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ msg_push.ReqBody f30818b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30819c;

    ci(IMMsfCoreProxy iMMsfCoreProxy, TIMValueCallBack tIMValueCallBack, msg_push.ReqBody reqBody) {
        this.f30819c = iMMsfCoreProxy;
        this.f30817a = tIMValueCallBack;
        this.f30818b = reqBody;
    }

    public final void run() {
        this.f30817a.onSuccess(this.f30818b.msg_msg.msg_msg_body.msg_content.get().toByteArray());
    }
}
