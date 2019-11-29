package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchUserEntity implements Serializable {
    private boolean has_more;
    private ArrayList<User> users;

    public boolean isHas_more() {
        return this.has_more;
    }

    public void setHas_more(boolean z) {
        this.has_more = z;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> arrayList = this.users;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setUsers(ArrayList<User> arrayList) {
        this.users = arrayList;
    }

    public class User implements Serializable {
        private String avatar;
        private long follower_count;
        private int shop_id;
        private boolean taggable;
        private int user_id;
        private String username;

        public User() {
        }

        public int getUser_id() {
            return this.user_id;
        }

        public void setUser_id(int i) {
            this.user_id = i;
        }

        public int getShop_id() {
            return this.shop_id;
        }

        public void setShop_id(int i) {
            this.shop_id = i;
        }

        public String getUsername() {
            String str = this.username;
            return str == null ? "" : str;
        }

        public void setUsername(String str) {
            this.username = str;
        }

        public String getAvatar() {
            String str = this.avatar;
            return str == null ? "" : str;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public long getFollower_count() {
            return this.follower_count;
        }

        public void setFollower_count(long j) {
            this.follower_count = j;
        }

        public boolean isTaggable() {
            return this.taggable;
        }

        public void setTaggable(boolean z) {
            this.taggable = z;
        }
    }
}
