package com.tencent.imsdk.ext.sns;

import com.tencent.imcore.FriendExtHelper;
import com.tencent.imcore.SWIGTYPE_p_void;

public class IMSnsExtBridge {
    public static SWIGTYPE_p_void getFrdManagerExt(String str) {
        return FriendExtHelper.getFriendshipManagerExt(str, new IMCoreFriendshipProxyCallback(str));
    }
}
