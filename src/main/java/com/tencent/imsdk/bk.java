package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.common;
import com.tencent.imsdk.protocol.stat_set_pushsound;

final class bk implements TIMValueCallBack<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f30766a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMOfflinePushSettings f30767b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30768c;

    bk(IMMsfCoreProxy iMMsfCoreProxy, String str, TIMOfflinePushSettings tIMOfflinePushSettings) {
        this.f30768c = iMMsfCoreProxy;
        this.f30766a = str;
        this.f30767b = tIMOfflinePushSettings;
    }

    public final void onError(int i, String str) {
        QLog.e("imsdk.IMMsfCoreProxy", 1, "initOfflinePushSettings request failed, code: " + i + "|desc: " + str);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        byte[] bArr = (byte[]) obj;
        stat_set_pushsound.RspBody rspBody = new stat_set_pushsound.RspBody();
        try {
            rspBody.mergeFrom(bArr);
            if (!rspBody.enum_cmd_error_code.has() || ((common.CmdErrorCode) rspBody.enum_cmd_error_code.get()).uint32_code.get() == 0) {
                QLog.i("imsdk.IMMsfCoreProxy", 1, "initOfflinePushSettings succ");
                this.f30768c.saveOfflinePushSettingsToLocal(this.f30766a, this.f30767b);
                return;
            }
            QLog.e("imsdk.IMMsfCoreProxy", 1, "initOfflinePushSettings failed, code: " + ((common.CmdErrorCode) rspBody.enum_cmd_error_code.get()).uint32_code.get() + "|desc: " + ((common.CmdErrorCode) rspBody.enum_cmd_error_code.get()).bytes_err_msg.get().toStringUtf8());
        } catch (Throwable th) {
            QLog.e("imsdk.IMMsfCoreProxy", 1, IMFunc.getExceptionInfo(th));
            QLog.e("imsdk.IMMsfCoreProxy", 1, "initOfflinePushSettings failed, parse rsp failed");
        }
    }
}
