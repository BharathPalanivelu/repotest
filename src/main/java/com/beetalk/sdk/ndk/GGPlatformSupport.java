package com.beetalk.sdk.ndk;

import com.beetalk.sdk.data.DataModel;

public class GGPlatformSupport {
    public static native void OnBindNotify(LoginRet loginRet);

    public static native void OnDeleteTagsNotify(GGCallbackFlag gGCallbackFlag);

    public static native void OnFacebookInfoNotify(FacebookInfoRect facebookInfoRect);

    public static native void OnFeedbackNotify(GGCallbackFlag gGCallbackFlag);

    public static native void OnGetPlatformSessionNotify(LoginRet loginRet);

    public static native void OnLoginNotify(LoginRet loginRet);

    public static native void OnReceiveAppFriendGroups(DataModel.FriendGroupsRet friendGroupsRet);

    public static native void OnReceiveAppFriendIDs(DataModel.FriendIDsRet friendIDsRet);

    public static native void OnReceiveFriendGroups(DataModel.FriendGroupsRet friendGroupsRet);

    public static native void OnReceiveFriendIDs(DataModel.FriendIDsRet friendIDsRet);

    public static native void OnReceiveFriendsInfo(DataModel.FriendsInfoRet friendsInfoRet);

    public static native void OnReceiveGroupFriendsInfo(DataModel.GroupFriendsInfoRet groupFriendsInfoRet);

    public static native void OnSetTagsNotify(GGCallbackFlag gGCallbackFlag);

    public static native void OnShareCallback(ShareRet shareRet);

    public static native void OnShareNotify(ShareRet shareRet);

    public static native void OnWakeupNotify(WakeupRet wakeupRet);
}
