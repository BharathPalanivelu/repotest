package com.shopee.app.data.viewmodel;

public class UserBriefInfo {
    private boolean followed;
    private boolean hideFollow;
    private boolean isChatBlocked;
    private boolean isOfficialShop;
    private String matchKeyword;
    private String nickName;
    private String portrait;
    private int productCnt;
    private int score;
    private int shopId;
    private int shopeeVerified;
    private int status;
    private int userId;
    private String userName;

    public void setUserId(int i) {
        this.userId = i;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setScore(int i) {
        this.score = i;
    }

    public int getScore() {
        return this.score;
    }

    public void setProductCnt(int i) {
        this.productCnt = i;
    }

    public int getProductCnt() {
        return this.productCnt;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setFollowed(boolean z) {
        this.followed = z;
    }

    public boolean isFollowed() {
        return this.followed;
    }

    public String getMatchKeyword() {
        return this.matchKeyword;
    }

    public void setMatchKeyword(String str) {
        this.matchKeyword = str;
    }

    public boolean isOfficialShop() {
        return this.isOfficialShop;
    }

    public void setOfficialShop(boolean z) {
        this.isOfficialShop = z;
    }

    public String toString() {
        return "userName:" + getUserName() + " userId: " + getUserId() + " portrait: " + getPortrait() + " score: " + getScore() + " productCnt:" + getProductCnt() + " Nickname:" + getNickName() + " isFollowed: " + isFollowed();
    }

    public void hideFollow(boolean z) {
        this.hideFollow = z;
    }

    public boolean hideFollow() {
        return this.hideFollow;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UserBriefInfo) || ((UserBriefInfo) obj).getUserId() != this.userId) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return getUserId();
    }

    public boolean isChatBlocked() {
        return this.isChatBlocked;
    }

    public void setIsChatBlocked(boolean z) {
        this.isChatBlocked = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public boolean isUserBanned() {
        return this.status == 2;
    }

    public boolean isUserDeleted() {
        return this.status == 0;
    }

    public void setShopeeVerified(int i) {
        this.shopeeVerified = i;
    }

    public boolean isShopeeVerified() {
        return this.shopeeVerified == 1;
    }
}
