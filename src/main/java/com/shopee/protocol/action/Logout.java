package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Logout extends Message {
    public static final String DEFAULT_BK_ACCESS_TOKEN = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final String DEFAULT_FB_ACCESS_TOKEN = "";
    public static final String DEFAULT_LINE_ACCESS_TOKEN = "";
    public static final String DEFAULT_PASSWD = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String bk_access_token;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String fb_access_token;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String line_access_token;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String passwd;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public Logout(String str, Integer num, f fVar, String str2, String str3, String str4, String str5, String str6) {
        this.requestid = str;
        this.userid = num;
        this.deviceid = fVar;
        this.passwd = str2;
        this.fb_access_token = str3;
        this.bk_access_token = str4;
        this.token = str5;
        this.line_access_token = str6;
    }

    private Logout(Builder builder) {
        this(builder.requestid, builder.userid, builder.deviceid, builder.passwd, builder.fb_access_token, builder.bk_access_token, builder.token, builder.line_access_token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Logout)) {
            return false;
        }
        Logout logout = (Logout) obj;
        if (!equals((Object) this.requestid, (Object) logout.requestid) || !equals((Object) this.userid, (Object) logout.userid) || !equals((Object) this.deviceid, (Object) logout.deviceid) || !equals((Object) this.passwd, (Object) logout.passwd) || !equals((Object) this.fb_access_token, (Object) logout.fb_access_token) || !equals((Object) this.bk_access_token, (Object) logout.bk_access_token) || !equals((Object) this.token, (Object) logout.token) || !equals((Object) this.line_access_token, (Object) logout.line_access_token)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str2 = this.passwd;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.fb_access_token;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.bk_access_token;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.token;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.line_access_token;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Logout> {
        public String bk_access_token;
        public f deviceid;
        public String fb_access_token;
        public String line_access_token;
        public String passwd;
        public String requestid;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(Logout logout) {
            super(logout);
            if (logout != null) {
                this.requestid = logout.requestid;
                this.userid = logout.userid;
                this.deviceid = logout.deviceid;
                this.passwd = logout.passwd;
                this.fb_access_token = logout.fb_access_token;
                this.bk_access_token = logout.bk_access_token;
                this.token = logout.token;
                this.line_access_token = logout.line_access_token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder passwd(String str) {
            this.passwd = str;
            return this;
        }

        public Builder fb_access_token(String str) {
            this.fb_access_token = str;
            return this;
        }

        public Builder bk_access_token(String str) {
            this.bk_access_token = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder line_access_token(String str) {
            this.line_access_token = str;
            return this;
        }

        public Logout build() {
            return new Logout(this);
        }
    }
}
