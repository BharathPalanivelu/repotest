package com.shopee.feeds.feedlibrary.data.entity;

import com.shopee.feeds.feedlibrary.data.entity.SearchUserEntity;
import java.io.Serializable;
import java.util.ArrayList;

public class FollowingEntity implements Serializable {
    private boolean has_more;
    private String next_id;
    private ArrayList<SearchUserEntity.User> users;

    public boolean isHas_more() {
        return this.has_more;
    }

    public void setHas_more(boolean z) {
        this.has_more = z;
    }

    public String getNext_id() {
        String str = this.next_id;
        return str == null ? "" : str;
    }

    public void setNext_id(String str) {
        this.next_id = str;
    }

    public ArrayList<SearchUserEntity.User> getUsers() {
        ArrayList<SearchUserEntity.User> arrayList = this.users;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setUsers(ArrayList<SearchUserEntity.User> arrayList) {
        this.users = arrayList;
    }
}
