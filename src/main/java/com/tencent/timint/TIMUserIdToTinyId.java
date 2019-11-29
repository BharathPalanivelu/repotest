package com.tencent.timint;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.IMMsfUserInfo;
import com.tencent.imsdk.TIMUser;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.im_open_common;
import com.tencent.imsdk.protocol.userid_to_tinyid;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TIMUserIdToTinyId {
    static TIMUserIdToTinyId inst = new TIMUserIdToTinyId();
    private static final String tag = "MSF.C.UserIdToTinyId";
    ConcurrentHashMap<TIMUser, Long> userIdToTinyId = new ConcurrentHashMap<>();

    private TIMUserIdToTinyId() {
    }

    public static TIMUserIdToTinyId get() {
        return inst;
    }

    private void localUserIdToTinyId(List<TIMUser> list, List<TIMUser> list2) {
        Iterator<TIMUser> it = list.iterator();
        while (it.hasNext()) {
            TIMUser next = it.next();
            if (this.userIdToTinyId.containsKey(next)) {
                TIMUser tIMUser = new TIMUser(next);
                tIMUser.setTinyId(this.userIdToTinyId.get(next).longValue());
                list2.add(tIMUser);
                it.remove();
            }
        }
    }

    public void userIdToTinyId(List<TIMUser> list, TIMValueCallBack<List<TIMUser>> tIMValueCallBack, long j) {
        TIMValueCallBack<List<TIMUser>> tIMValueCallBack2 = tIMValueCallBack;
        if (tIMValueCallBack2 != null) {
            IMMsfUserInfo anyOnLineMsfUserInfo = IMMsfCoreProxy.get().getAnyOnLineMsfUserInfo();
            if (anyOnLineMsfUserInfo == null || !anyOnLineMsfUserInfo.isLoggedIn()) {
                tIMValueCallBack2.onError(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "not logged in");
                return;
            }
            ArrayList<TIMUser> arrayList = new ArrayList<>();
            localUserIdToTinyId(list, arrayList);
            if (list.isEmpty()) {
                for (TIMUser tIMUser : arrayList) {
                    QLog.d(tag, 1, "local get userid: " + tIMUser + "|tinyid: " + tIMUser.getTinyId());
                }
                tIMValueCallBack2.onSuccess(arrayList);
                return;
            }
            userid_to_tinyid.ReqBody reqBody = new userid_to_tinyid.ReqBody();
            for (TIMUser identifier : list) {
                im_open_common.IMUserId iMUserId = new im_open_common.IMUserId();
                iMUserId.uidtype.set(ByteStringMicro.copyFromUtf8(IMMsfCoreProxy.get().getAccountType()));
                iMUserId.userappid.set(IMMsfCoreProxy.get().getSdkAppId());
                iMUserId.userid.set(ByteStringMicro.copyFromUtf8(identifier.getIdentifier()));
                reqBody.userid.add(iMUserId);
            }
            IMMsfCoreProxy.get().request(anyOnLineMsfUserInfo.getIdentifier(), "openim.pbuseridtotinyid", reqBody.toByteArray(), new ah(this, arrayList, tIMValueCallBack2), j);
        }
    }
}
