package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class LoginRecords extends Message {
    public static final List<LoginRecord> DEFAULT_RECORDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = LoginRecord.class, tag = 1)
    public final List<LoginRecord> records;

    public LoginRecords(List<LoginRecord> list) {
        this.records = immutableCopyOf(list);
    }

    private LoginRecords(Builder builder) {
        this(builder.records);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoginRecords)) {
            return false;
        }
        return equals((List<?>) this.records, (List<?>) ((LoginRecords) obj).records);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<LoginRecord> list = this.records;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<LoginRecords> {
        public List<LoginRecord> records;

        public Builder() {
        }

        public Builder(LoginRecords loginRecords) {
            super(loginRecords);
            if (loginRecords != null) {
                this.records = LoginRecords.copyOf(loginRecords.records);
            }
        }

        public Builder records(List<LoginRecord> list) {
            this.records = checkForNulls(list);
            return this;
        }

        public LoginRecords build() {
            return new LoginRecords(this);
        }
    }
}
