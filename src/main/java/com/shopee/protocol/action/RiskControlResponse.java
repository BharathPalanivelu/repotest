package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RiskControlResponse extends Message {
    public static final List<Integer> DEFAULT_AUTHENTICATIONS_REQUIRED = Collections.emptyList();
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_DECISION = 0;
    public static final String DEFAULT_DECISION_TOKEN = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> authentications_required;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer decision;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String decision_token;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public RiskControlResponse(String str, Integer num, List<Integer> list, String str2, String str3, Integer num2) {
        this.requestid = str;
        this.decision = num;
        this.authentications_required = immutableCopyOf(list);
        this.decision_token = str2;
        this.debug_msg = str3;
        this.errcode = num2;
    }

    private RiskControlResponse(Builder builder) {
        this(builder.requestid, builder.decision, builder.authentications_required, builder.decision_token, builder.debug_msg, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RiskControlResponse)) {
            return false;
        }
        RiskControlResponse riskControlResponse = (RiskControlResponse) obj;
        if (!equals((Object) this.requestid, (Object) riskControlResponse.requestid) || !equals((Object) this.decision, (Object) riskControlResponse.decision) || !equals((List<?>) this.authentications_required, (List<?>) riskControlResponse.authentications_required) || !equals((Object) this.decision_token, (Object) riskControlResponse.decision_token) || !equals((Object) this.debug_msg, (Object) riskControlResponse.debug_msg) || !equals((Object) this.errcode, (Object) riskControlResponse.errcode)) {
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
        Integer num = this.decision;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<Integer> list = this.authentications_required;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.decision_token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.debug_msg;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.errcode;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RiskControlResponse> {
        public List<Integer> authentications_required;
        public String debug_msg;
        public Integer decision;
        public String decision_token;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(RiskControlResponse riskControlResponse) {
            super(riskControlResponse);
            if (riskControlResponse != null) {
                this.requestid = riskControlResponse.requestid;
                this.decision = riskControlResponse.decision;
                this.authentications_required = RiskControlResponse.copyOf(riskControlResponse.authentications_required);
                this.decision_token = riskControlResponse.decision_token;
                this.debug_msg = riskControlResponse.debug_msg;
                this.errcode = riskControlResponse.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder decision(Integer num) {
            this.decision = num;
            return this;
        }

        public Builder authentications_required(List<Integer> list) {
            this.authentications_required = checkForNulls(list);
            return this;
        }

        public Builder decision_token(String str) {
            this.decision_token = str;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public RiskControlResponse build() {
            return new RiskControlResponse(this);
        }
    }
}
