package com.shopee.react.sdk.bridge.protocol;

public class UserInfoData {
    private String avatarId;
    private String portrait;
    private int shopeId;
    private String shopeeToken;
    private int userId;
    private String username;

    private UserInfoData(Builder builder) {
        this.shopeeToken = builder.shopeeToken;
        this.userId = builder.userId;
        this.shopeId = builder.shopeId;
        this.username = builder.username;
        this.avatarId = builder.avatarId;
        this.portrait = builder.portrait;
    }

    public String getShopeeToken() {
        return this.shopeeToken;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getShopeId() {
        return this.shopeId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getAvatarId() {
        return this.avatarId;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String avatarId;
        /* access modifiers changed from: private */
        public String portrait;
        /* access modifiers changed from: private */
        public int shopeId;
        /* access modifiers changed from: private */
        public String shopeeToken;
        /* access modifiers changed from: private */
        public int userId;
        /* access modifiers changed from: private */
        public String username;

        public Builder shopeeToken(String str) {
            this.shopeeToken = str;
            return this;
        }

        public Builder userId(int i) {
            this.userId = i;
            return this;
        }

        public Builder shopeId(int i) {
            this.shopeId = i;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder avatarId(String str) {
            this.avatarId = str;
            return this;
        }

        public Builder portrait(String str) {
            this.portrait = str;
            return this;
        }

        public UserInfoData build() {
            return new UserInfoData(this);
        }
    }
}
