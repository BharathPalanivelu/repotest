package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMUserConfig;

public class TIMUserConfigSnsExt extends TIMUserConfig {
    public TIMUserConfigSnsExt(TIMUserConfig tIMUserConfig) {
        super(tIMUserConfig);
    }

    public TIMUserConfigSnsExt enableFriendshipStorage(boolean z) {
        this.isFriendshipStorageEnabled = z;
        return this;
    }

    public TIMFriendshipProxyListener getFriendshipProxyListener() {
        if (this.friendshipProxyListener instanceof TIMFriendshipProxyListener) {
            return (TIMFriendshipProxyListener) this.friendshipProxyListener;
        }
        return null;
    }

    public boolean isFriendshipStorageEnabled() {
        return this.isFriendshipStorageEnabled;
    }

    public TIMUserConfigSnsExt setFriendshipProxyListener(TIMFriendshipProxyListener tIMFriendshipProxyListener) {
        this.friendshipProxyListener = tIMFriendshipProxyListener;
        return this;
    }
}
