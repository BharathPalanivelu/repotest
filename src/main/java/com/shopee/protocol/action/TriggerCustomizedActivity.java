package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TriggerCustomizedActivity extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TO_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final CustomizeActivityMeta activity_meta;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer to_userid;

    public TriggerCustomizedActivity(String str, BackendParam backendParam, Integer num, CustomizeActivityMeta customizeActivityMeta) {
        this.requestid = str;
        this.bparam = backendParam;
        this.to_userid = num;
        this.activity_meta = customizeActivityMeta;
    }

    private TriggerCustomizedActivity(Builder builder) {
        this(builder.requestid, builder.bparam, builder.to_userid, builder.activity_meta);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TriggerCustomizedActivity)) {
            return false;
        }
        TriggerCustomizedActivity triggerCustomizedActivity = (TriggerCustomizedActivity) obj;
        if (!equals((Object) this.requestid, (Object) triggerCustomizedActivity.requestid) || !equals((Object) this.bparam, (Object) triggerCustomizedActivity.bparam) || !equals((Object) this.to_userid, (Object) triggerCustomizedActivity.to_userid) || !equals((Object) this.activity_meta, (Object) triggerCustomizedActivity.activity_meta)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Integer num = this.to_userid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        CustomizeActivityMeta customizeActivityMeta = this.activity_meta;
        if (customizeActivityMeta != null) {
            i2 = customizeActivityMeta.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TriggerCustomizedActivity> {
        public CustomizeActivityMeta activity_meta;
        public BackendParam bparam;
        public String requestid;
        public Integer to_userid;

        public Builder() {
        }

        public Builder(TriggerCustomizedActivity triggerCustomizedActivity) {
            super(triggerCustomizedActivity);
            if (triggerCustomizedActivity != null) {
                this.requestid = triggerCustomizedActivity.requestid;
                this.bparam = triggerCustomizedActivity.bparam;
                this.to_userid = triggerCustomizedActivity.to_userid;
                this.activity_meta = triggerCustomizedActivity.activity_meta;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder to_userid(Integer num) {
            this.to_userid = num;
            return this;
        }

        public Builder activity_meta(CustomizeActivityMeta customizeActivityMeta) {
            this.activity_meta = customizeActivityMeta;
            return this;
        }

        public TriggerCustomizedActivity build() {
            return new TriggerCustomizedActivity(this);
        }
    }
}
