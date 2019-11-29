package com.tencent.imsdk;

import android.content.Context;
import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALPushListener;

final class cg implements QALPushListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f30812a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ IMMsfCoreProxy f30813b;

    cg(IMMsfCoreProxy iMMsfCoreProxy, Context context) {
        this.f30813b = iMMsfCoreProxy;
        this.f30812a = context;
    }

    public final void onError(String str, int i, String str2) {
        QLog.e("imsdk.IMMsfCoreProxy", 1, "recv push cmd im_open_push.msg_push error, id: " + str + "|code:" + i + "|desc: " + str2);
    }

    public final void onSuccess(String str, byte[] bArr) {
        QLog.d("imsdk.IMMsfCoreProxy", 1, "cmd:im_open_push.msg_push|req:" + IMFunc.byte2hex(bArr));
        this.f30813b.pool.execute(new ch(this, str, bArr));
    }
}
