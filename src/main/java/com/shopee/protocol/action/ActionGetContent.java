package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ActionGetContent extends Message {
    public static final List<Long> DEFAULT_ACTIONID_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> actionid_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public ActionGetContent(String str, List<Long> list, String str2) {
        this.requestid = str;
        this.actionid_list = immutableCopyOf(list);
        this.token = str2;
    }

    private ActionGetContent(Builder builder) {
        this(builder.requestid, builder.actionid_list, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActionGetContent)) {
            return false;
        }
        ActionGetContent actionGetContent = (ActionGetContent) obj;
        if (!equals((Object) this.requestid, (Object) actionGetContent.requestid) || !equals((List<?>) this.actionid_list, (List<?>) actionGetContent.actionid_list) || !equals((Object) this.token, (Object) actionGetContent.token)) {
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
        List<Long> list = this.actionid_list;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActionGetContent> {
        public List<Long> actionid_list;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(ActionGetContent actionGetContent) {
            super(actionGetContent);
            if (actionGetContent != null) {
                this.requestid = actionGetContent.requestid;
                this.actionid_list = ActionGetContent.copyOf(actionGetContent.actionid_list);
                this.token = actionGetContent.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder actionid_list(List<Long> list) {
            this.actionid_list = checkForNulls(list);
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public ActionGetContent build() {
            return new ActionGetContent(this);
        }
    }
}
