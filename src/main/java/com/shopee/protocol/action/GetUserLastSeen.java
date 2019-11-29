package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetUserLastSeen extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final List<Integer> DEFAULT_USERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> userid;

    public GetUserLastSeen(String str, List<Integer> list, String str2) {
        this.requestid = str;
        this.userid = immutableCopyOf(list);
        this.token = str2;
    }

    private GetUserLastSeen(Builder builder) {
        this(builder.requestid, builder.userid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetUserLastSeen)) {
            return false;
        }
        GetUserLastSeen getUserLastSeen = (GetUserLastSeen) obj;
        if (!equals((Object) this.requestid, (Object) getUserLastSeen.requestid) || !equals((List<?>) this.userid, (List<?>) getUserLastSeen.userid) || !equals((Object) this.token, (Object) getUserLastSeen.token)) {
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
        List<Integer> list = this.userid;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetUserLastSeen> {
        public String requestid;
        public String token;
        public List<Integer> userid;

        public Builder() {
        }

        public Builder(GetUserLastSeen getUserLastSeen) {
            super(getUserLastSeen);
            if (getUserLastSeen != null) {
                this.requestid = getUserLastSeen.requestid;
                this.userid = GetUserLastSeen.copyOf(getUserLastSeen.userid);
                this.token = getUserLastSeen.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(List<Integer> list) {
            this.userid = checkForNulls(list);
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public GetUserLastSeen build() {
            return new GetUserLastSeen(this);
        }
    }
}
