package com.tencent.imsdk;

public class TIMUser {
    private String accountType = "";
    private String appIdAt3rd = "";
    private String identifier = "";
    private long sdkAppid = 0;
    private long tinyId = 0;

    public TIMUser() {
    }

    public TIMUser(TIMUser tIMUser) {
        this.sdkAppid = tIMUser.sdkAppid;
        this.accountType = tIMUser.accountType;
        this.appIdAt3rd = tIMUser.appIdAt3rd;
        this.identifier = tIMUser.identifier;
        this.tinyId = tIMUser.tinyId;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TIMUser)) {
            return false;
        }
        return toString().equals(((TIMUser) obj).toString());
    }

    @Deprecated
    public String getAccountType() {
        return this.accountType;
    }

    @Deprecated
    public String getAppIdAt3rd() {
        return this.appIdAt3rd;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public long getSdkAppid() {
        return this.sdkAppid;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public void parseFromString(String str) {
        if (str != null) {
            String[] split = str.split(":");
            this.sdkAppid = (long) Integer.parseInt(split[0]);
            this.accountType = split[1];
            this.identifier = split[2];
            this.appIdAt3rd = split[3];
        }
    }

    @Deprecated
    public void setAccountType(String str) {
        this.accountType = str;
    }

    @Deprecated
    public void setAppIdAt3rd(String str) {
        this.appIdAt3rd = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setSdkAppid(long j) {
        this.sdkAppid = j;
    }

    public void setTinyId(long j) {
        this.tinyId = j;
    }

    public String toString() {
        return this.sdkAppid + ":" + this.accountType + ":" + this.identifier + ":" + this.appIdAt3rd;
    }
}
