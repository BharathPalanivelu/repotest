package com.tencent.imsdk;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.common;
import com.tencent.imsdk.protocol.stat_get_pushsound;

final class bm implements TIMValueCallBack<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TIMValueCallBack f30772a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30773b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30774c;

    bm(IMMsfCoreProxy iMMsfCoreProxy, TIMValueCallBack tIMValueCallBack, String str) {
        this.f30774c = iMMsfCoreProxy;
        this.f30772a = tIMValueCallBack;
        this.f30773b = str;
    }

    public final void onError(int i, String str) {
        QLog.e("imsdk.IMMsfCoreProxy", 1, "getOfflinePushSettings request failed, code: " + i + "|desc: " + str);
        IMMsfCoreProxy.mainHandler.post(new bn(this, i, str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        byte[] bArr = (byte[]) obj;
        stat_get_pushsound.RspBody rspBody = new stat_get_pushsound.RspBody();
        try {
            rspBody.mergeFrom(bArr);
            if (!rspBody.enum_cmd_error_code.has() || ((common.CmdErrorCode) rspBody.enum_cmd_error_code.get()).uint32_code.get() == 0) {
                TIMOfflinePushSettings tIMOfflinePushSettings = new TIMOfflinePushSettings();
                if (rspBody.msg_config.has()) {
                    tIMOfflinePushSettings.setEnabled(rspBody.msg_config.uint32_openpush.get() == 1);
                    String stringUtf8 = rspBody.msg_config.bytes_c2c_sound.get().toStringUtf8();
                    if (!TextUtils.isEmpty(stringUtf8)) {
                        tIMOfflinePushSettings.setC2cMsgRemindSound(Uri.parse(stringUtf8));
                    }
                    String stringUtf82 = rspBody.msg_config.bytes_grp_sound.get().toStringUtf8();
                    if (!TextUtils.isEmpty(stringUtf82)) {
                        tIMOfflinePushSettings.setGroupMsgRemindSound(Uri.parse(stringUtf82));
                    }
                }
                QLog.i("imsdk.IMMsfCoreProxy", 1, "getOfflinePushSettings succ");
                IMMsfCoreProxy.mainHandler.post(new bp(this, tIMOfflinePushSettings));
                this.f30774c.saveOfflinePushSettingsToLocal(this.f30773b, tIMOfflinePushSettings);
                return;
            }
            IMErrInfo iMErrInfo = new IMErrInfo(((common.CmdErrorCode) rspBody.enum_cmd_error_code.get()).uint32_code.get(), ((common.CmdErrorCode) rspBody.enum_cmd_error_code.get()).bytes_err_msg.get().toStringUtf8());
            QLog.e("imsdk.IMMsfCoreProxy", 1, "getOfflinePushSettings failed, code: " + iMErrInfo.getCode() + "|desc: " + iMErrInfo.getMsg());
            IMMsfCoreProxy.mainHandler.post(new bo(this, iMErrInfo));
        } catch (Throwable th) {
            QLog.e("imsdk.IMMsfCoreProxy", 1, IMFunc.getExceptionInfo(th));
            QLog.e("imsdk.IMMsfCoreProxy", 1, "getOfflinePushSettings failed, parse rsp failed");
        }
    }
}
