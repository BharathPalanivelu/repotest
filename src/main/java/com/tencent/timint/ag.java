package com.tencent.timint;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.IMFunc;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.TIMUser;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.im_open_common;
import com.tencent.imsdk.protocol.tinyid_to_userid;
import java.util.List;

final class ag implements TIMValueCallBack<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private List<TIMUser> f32505a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMValueCallBack f32506b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMTinyIdToUserId f32507c;

    public ag(TIMTinyIdToUserId tIMTinyIdToUserId, List list, TIMValueCallBack tIMValueCallBack) {
        this.f32507c = tIMTinyIdToUserId;
        this.f32506b = tIMValueCallBack;
        this.f32505a = list;
    }

    public final void onError(int i, String str) {
        this.f32506b.onError(i, str);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        byte[] bArr = (byte[]) obj;
        tinyid_to_userid.RspBody rspBody = new tinyid_to_userid.RspBody();
        try {
            rspBody.mergeFrom(bArr);
            List<TIMUser> list = this.f32505a;
            for (im_open_common.IMUserId next : rspBody.userid.get()) {
                TIMUser tIMUser = new TIMUser();
                tIMUser.setAccountType(next.uidtype.get().toStringUtf8());
                tIMUser.setAppIdAt3rd(String.valueOf(IMMsfCoreProxy.get().getSdkAppId()));
                tIMUser.setIdentifier(next.userid.get().toStringUtf8());
                tIMUser.setTinyId(next.tinyid.get());
                list.add(tIMUser);
                TIMUserIdToTinyId.get().userIdToTinyId.put(tIMUser, Long.valueOf(tIMUser.getTinyId()));
                TIMTinyIdToUserId.get().tinyIdToUserId.put(Long.valueOf(tIMUser.getTinyId()), tIMUser);
            }
            for (TIMUser next2 : list) {
                QLog.d("MSF.C.TinyIdToUserId", 1, "get userid: " + next2 + "|tinyid: " + next2.getTinyId());
            }
            this.f32506b.onSuccess(list);
        } catch (Throwable th) {
            QLog.e("MSF.C.TinyIdToUserId", 1, IMFunc.getExceptionInfo(th));
            this.f32506b.onError(BaseConstants.ERR_PARSE_RESPONSE_FAILED, "parse rsp failed");
        }
    }
}
