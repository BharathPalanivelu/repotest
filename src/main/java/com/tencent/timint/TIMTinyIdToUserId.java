package com.tencent.timint;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.IMMsfUserInfo;
import com.tencent.imsdk.TIMUser;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.tinyid_to_userid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TIMTinyIdToUserId {
    static TIMTinyIdToUserId inst = new TIMTinyIdToUserId();
    private static final String tag = "MSF.C.TinyIdToUserId";
    ConcurrentHashMap<Long, TIMUser> tinyIdToUserId = new ConcurrentHashMap<>();

    private TIMTinyIdToUserId() {
    }

    public static TIMTinyIdToUserId get() {
        return inst;
    }

    private void localTinyIdToUserId(List<Long> list, List<TIMUser> list2) {
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            Long next = it.next();
            if (this.tinyIdToUserId.containsKey(next)) {
                TIMUser tIMUser = new TIMUser(this.tinyIdToUserId.get(next));
                tIMUser.setTinyId(next.longValue());
                list2.add(tIMUser);
                it.remove();
            }
        }
    }

    public void tinyIdToUserId(List<Long> list, TIMValueCallBack<List<TIMUser>> tIMValueCallBack, long j) {
        TIMValueCallBack<List<TIMUser>> tIMValueCallBack2 = tIMValueCallBack;
        if (tIMValueCallBack2 != null) {
            IMMsfUserInfo anyOnLineMsfUserInfo = IMMsfCoreProxy.get().getAnyOnLineMsfUserInfo();
            if (anyOnLineMsfUserInfo == null || !anyOnLineMsfUserInfo.isLoggedIn()) {
                tIMValueCallBack2.onError(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "not logged in");
                return;
            }
            ArrayList<TIMUser> arrayList = new ArrayList<>();
            localTinyIdToUserId(list, arrayList);
            if (list.isEmpty()) {
                for (TIMUser tIMUser : arrayList) {
                    QLog.d(tag, 1, "local get userid: " + tIMUser + "|tinyid: " + tIMUser.getTinyId());
                }
                tIMValueCallBack2.onSuccess(arrayList);
                return;
            }
            tinyid_to_userid.ReqBody reqBody = new tinyid_to_userid.ReqBody();
            for (Long add : list) {
                reqBody.tinyid.add(add);
            }
            IMMsfCoreProxy.get().request(anyOnLineMsfUserInfo.getIdentifier(), "openim.pbtinyidtouserid", reqBody.toByteArray(), new ag(this, arrayList, tIMValueCallBack2), j);
        }
    }
}
