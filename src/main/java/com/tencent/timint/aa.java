package com.tencent.timint;

import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.IMMsfUserInfo;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.relay;
import com.tencent.mobileqq.pb.ByteStringMicro;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    private static aa f32492a = new aa();

    private aa() {
    }

    public static aa a() {
        return f32492a;
    }

    private void a(String str, byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack, long j) {
        IMMsfUserInfo anyOnLineMsfUserInfo = IMMsfCoreProxy.get().getAnyOnLineMsfUserInfo();
        if (anyOnLineMsfUserInfo == null) {
            QLog.w("IMSdk.MultiVideoTinyId", 1, "MutivideoTinyId|requestOpenImRelay no user online");
            anyOnLineMsfUserInfo = new IMMsfUserInfo();
        }
        relay.ReqBody reqBody = new relay.ReqBody();
        reqBody.reqbody.set(ByteStringMicro.copyFrom(bArr));
        reqBody.reqbody.setHasFlag(true);
        IMMsfCoreProxy.get().request(anyOnLineMsfUserInfo.getIdentifier(), str, reqBody.toByteArray(), new ab(this, tIMValueCallBack, str), j);
    }

    public final void a(byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack, long j) {
        QLog.i("IMSdk.MultiVideoTinyId", 1, "multivideo|requestMultiVideoApp");
        a(IMMsfCoreProxy.get().getSdkType() + ".pbvideoapp", bArr, tIMValueCallBack, j);
    }

    public final void b(byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack, long j) {
        QLog.i("IMSdk.MultiVideoTinyId", 1, "multivideo|requestMultiVideoInfo");
        a(IMMsfCoreProxy.get().getSdkType() + ".pbvideoinfo", bArr, tIMValueCallBack, j);
    }
}
