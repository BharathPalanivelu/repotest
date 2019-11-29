package com.tencent.imsdk.ext.sns;

import com.tencent.imcore.AddFriendReq;
import com.tencent.imcore.AddFriendReqVec;
import com.tencent.imcore.FriendProfileVec;
import com.tencent.imcore.IFriendshipNotify;
import com.tencent.imcore.StrVec;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.TIMManager;
import java.util.ArrayList;

public class IMCoreFriendshipProxyCallback extends IFriendshipNotify {
    private String identifier;

    public IMCoreFriendshipProxyCallback(String str) {
        this.identifier = str;
        swigReleaseOwnership();
    }

    public void onAddFriendNotify(FriendProfileVec friendProfileVec) {
        if (friendProfileVec != null) {
            long size = friendProfileVec.size();
            if (size > 0) {
                TIMFriendshipProxyListener friendshipProxyListener = new TIMUserConfigSnsExt(TIMManager.getInstanceById(this.identifier).getUserConfig()).getFriendshipProxyListener();
                if (friendshipProxyListener != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; ((long) i) < size; i++) {
                        arrayList.add(IMLiteBridge.userProfileFromInternal(friendProfileVec.get(i)));
                    }
                    IMMsfCoreProxy.mainHandler.post(new aa(this, friendshipProxyListener, arrayList));
                }
            }
        }
    }

    public void onAddFriendReq(AddFriendReqVec addFriendReqVec) {
        if (addFriendReqVec != null) {
            long size = addFriendReqVec.size();
            if (size > 0) {
                TIMFriendshipProxyListener friendshipProxyListener = new TIMUserConfigSnsExt(TIMManager.getInstanceById(this.identifier).getUserConfig()).getFriendshipProxyListener();
                if (friendshipProxyListener != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; ((long) i) < size; i++) {
                        try {
                            AddFriendReq addFriendReq = addFriendReqVec.get(i);
                            arrayList.add(IMLiteBridge.snsChangeInfoFromInternal(this.identifier, new String(addFriendReq.getSource(), "utf-8"), new String(addFriendReq.getWording(), "utf-8"), new String(addFriendReq.getNickname(), "utf-8")));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    IMMsfCoreProxy.mainHandler.post(new ad(this, friendshipProxyListener, arrayList));
                }
            }
        }
    }

    public void onDeleteFriendNotify(StrVec strVec) {
        if (strVec != null) {
            long size = strVec.size();
            if (size > 0) {
                TIMFriendshipProxyListener friendshipProxyListener = new TIMUserConfigSnsExt(TIMManager.getInstanceById(this.identifier).getUserConfig()).getFriendshipProxyListener();
                if (friendshipProxyListener != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; ((long) i) < size; i++) {
                        arrayList.add(strVec.get(i));
                    }
                    IMMsfCoreProxy.mainHandler.post(new ab(this, friendshipProxyListener, arrayList));
                }
            }
        }
    }

    public void onFriendProfileUpdate(FriendProfileVec friendProfileVec) {
        if (friendProfileVec != null) {
            long size = friendProfileVec.size();
            if (size > 0) {
                TIMFriendshipProxyListener friendshipProxyListener = new TIMUserConfigSnsExt(TIMManager.getInstanceById(this.identifier).getUserConfig()).getFriendshipProxyListener();
                if (friendshipProxyListener != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; ((long) i) < size; i++) {
                        arrayList.add(IMLiteBridge.userProfileFromInternal(friendProfileVec.get(i)));
                    }
                    IMMsfCoreProxy.mainHandler.post(new ac(this, friendshipProxyListener, arrayList));
                }
            }
        }
    }
}
