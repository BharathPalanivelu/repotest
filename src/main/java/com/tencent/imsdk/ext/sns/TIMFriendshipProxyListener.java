package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.IMBaseListener;
import com.tencent.imsdk.TIMSNSChangeInfo;
import com.tencent.imsdk.TIMUserProfile;
import java.util.List;

public interface TIMFriendshipProxyListener extends IMBaseListener {
    void OnAddFriendReqs(List<TIMSNSChangeInfo> list);

    void OnAddFriends(List<TIMUserProfile> list);

    void OnDelFriends(List<String> list);

    void OnFriendProfileUpdate(List<TIMUserProfile> list);
}
