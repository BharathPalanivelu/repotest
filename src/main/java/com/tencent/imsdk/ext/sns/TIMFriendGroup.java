package com.tencent.imsdk.ext.sns;

import com.tencent.imcore.FriendGroup;
import com.tencent.imcore.FriendProfile;
import com.tencent.imcore.FriendProfileVec;
import com.tencent.imcore.StrVec;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.TIMUserProfile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TIMFriendGroup {
    long count = 0;
    String name = "";
    List<TIMUserProfile> profiles = new ArrayList();
    List<String> users = new ArrayList();

    TIMFriendGroup() {
    }

    TIMFriendGroup(FriendGroup friendGroup) {
        try {
            setName(new String(friendGroup.getName(), "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        setCount(friendGroup.getCount());
        StrVec identifiers = friendGroup.getIdentifiers();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; ((long) i) < identifiers.size(); i++) {
            if (identifiers.get(i).length() != 0) {
                arrayList.add(identifiers.get(i));
            }
        }
        setUsers(arrayList);
        FriendProfileVec profiles2 = friendGroup.getProfiles();
        for (int i2 = 0; ((long) i2) < profiles2.size(); i2++) {
            FriendProfile friendProfile = profiles2.get(i2);
            if (friendProfile != null) {
                this.profiles.add(IMLiteBridge.userProfileFromInternal(friendProfile));
            }
        }
    }

    public long getCount() {
        return this.count;
    }

    public String getGroupName() {
        return this.name;
    }

    public List<TIMUserProfile> getProfiles() {
        return this.profiles;
    }

    public List<String> getUsers() {
        return this.users;
    }

    /* access modifiers changed from: package-private */
    public void setCount(long j) {
        this.count = j;
    }

    /* access modifiers changed from: package-private */
    public void setName(String str) {
        this.name = str;
    }

    /* access modifiers changed from: package-private */
    public void setUsers(List<String> list) {
        this.users = list;
    }
}
