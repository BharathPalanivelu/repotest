package com.tencent.timint;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.IMFunc;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.relay;

final class ab implements TIMValueCallBack<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMValueCallBack f32493a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f32494b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ aa f32495c;

    ab(aa aaVar, TIMValueCallBack tIMValueCallBack, String str) {
        this.f32495c = aaVar;
        this.f32493a = tIMValueCallBack;
        this.f32494b = str;
    }

    public final void onError(int i, String str) {
        QLog.e("IMSdk.MultiVideoTinyId", 1, "multivideo|failed: " + i + " desc: " + str);
        this.f32493a.onError(i, str);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        byte[] bArr = (byte[]) obj;
        relay.RspBody rspBody = new relay.RspBody();
        try {
            rspBody.mergeFrom(bArr);
            QLog.i("IMSdk.MultiVideoTinyId", 1, "multivideo|callback: " + this.f32494b);
            this.f32493a.onSuccess(rspBody.rspbody.get().toByteArray());
        } catch (Throwable th) {
            QLog.e("IMSdk.MultiVideoTinyId", 1, IMFunc.getExceptionInfo(th));
            QLog.e("IMSdk.MultiVideoTinyId", 1, "multivideo|parse failed");
            this.f32493a.onError(BaseConstants.ERR_PARSE_RESPONSE_FAILED, "parse rsp failed");
        }
    }
}
