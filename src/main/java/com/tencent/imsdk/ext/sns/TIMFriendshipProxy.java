package com.tencent.imsdk.ext.sns;

import android.text.TextUtils;
import com.tencent.imcore.BytesVec;
import com.tencent.imcore.FriendGroupVec;
import com.tencent.imcore.FriendProfileVec;
import com.tencent.imcore.FriendshipManagerExt;
import com.tencent.imcore.StrVec;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.log.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TIMFriendshipProxy {
    private static TIMFriendshipProxy inst = null;
    private static final String tag = "imsdk.TIMFriendshipProxy";
    private String identifier = "";

    private TIMFriendshipProxy() {
    }

    private TIMFriendshipProxy(String str) {
        this.identifier = str;
    }

    private FriendshipManagerExt getFriendshipMgrExt() {
        return TIMFriendshipManagerExt.getInstanceById(this.identifier).getFriendshipMgrExt();
    }

    public static TIMFriendshipProxy getInstance() {
        return getInstanceById(IMLiteBridge.getIdentifier(TIMManager.getInstance()));
    }

    public static synchronized TIMFriendshipProxy getInstanceById(String str) {
        TIMFriendshipProxy tIMFriendshipProxy;
        synchronized (TIMFriendshipProxy.class) {
            if (inst == null) {
                inst = new TIMFriendshipProxy(str);
            } else {
                inst.identifier = str;
            }
            tIMFriendshipProxy = inst;
        }
        return tIMFriendshipProxy;
    }

    public List<TIMUserProfile> getFriends() {
        FriendProfileVec friendProfileVec = new FriendProfileVec();
        int friendList = getFriendshipMgrExt().getFriendList(friendProfileVec);
        if (friendList == 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; ((long) i) < friendProfileVec.size(); i++) {
                arrayList.add(IMLiteBridge.userProfileFromInternal(friendProfileVec.get(i)));
            }
            return arrayList;
        }
        QLog.d(tag, 1, "getFriends failed, code: " + friendList);
        return null;
    }

    public List<TIMFriendGroup> getFriendsByGroups(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() == 0) {
            return arrayList;
        }
        FriendGroupVec friendGroupVec = new FriendGroupVec();
        BytesVec bytesVec = new BytesVec();
        if (list != null) {
            for (String bytes : list) {
                try {
                    bytesVec.add(bytes.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        int friendGroup = getFriendshipMgrExt().getFriendGroup(bytesVec, friendGroupVec);
        if (friendGroup != 0) {
            QLog.d(tag, 1, "getFriendsByGroups failed, code: " + friendGroup);
            return null;
        }
        for (int i = 0; ((long) i) < friendGroupVec.size(); i++) {
            arrayList.add(new TIMFriendGroup(friendGroupVec.get(i)));
        }
        return arrayList;
    }

    public List<TIMUserProfile> getFriendsById(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        FriendProfileVec friendProfileVec = new FriendProfileVec();
        StrVec strVec = new StrVec();
        for (String next : list) {
            if (!TextUtils.isEmpty(next)) {
                strVec.add(next);
            }
        }
        int friendProfile = getFriendshipMgrExt().getFriendProfile(strVec, friendProfileVec);
        if (friendProfile == 0) {
            for (int i = 0; ((long) i) < friendProfileVec.size(); i++) {
                arrayList.add(IMLiteBridge.userProfileFromInternal(friendProfileVec.get(i)));
            }
            return arrayList;
        }
        QLog.d(tag, 1, "getFriendsById failed, code: " + friendProfile);
        return null;
    }

    /* access modifiers changed from: package-private */
    public String getIdentifier() {
        return this.identifier;
    }

    /* access modifiers changed from: package-private */
    public void setIdentifier(String str) {
        this.identifier = str;
    }
}
