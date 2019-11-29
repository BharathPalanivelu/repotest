package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FSGeneralError extends Message {
    public static final Integer DEFAULT_ERRORCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ErrorCode;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String RequestId;

    public FSGeneralError(Integer num, String str) {
        this.ErrorCode = num;
        this.RequestId = str;
    }

    private FSGeneralError(Builder builder) {
        this(builder.ErrorCode, builder.RequestId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FSGeneralError)) {
            return false;
        }
        FSGeneralError fSGeneralError = (FSGeneralError) obj;
        if (!equals((Object) this.ErrorCode, (Object) fSGeneralError.ErrorCode) || !equals((Object) this.RequestId, (Object) fSGeneralError.RequestId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ErrorCode;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.RequestId;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FSGeneralError> {
        public Integer ErrorCode;
        public String RequestId;

        public Builder() {
        }

        public Builder(FSGeneralError fSGeneralError) {
            super(fSGeneralError);
            if (fSGeneralError != null) {
                this.ErrorCode = fSGeneralError.ErrorCode;
                this.RequestId = fSGeneralError.RequestId;
            }
        }

        public Builder ErrorCode(Integer num) {
            this.ErrorCode = num;
            return this;
        }

        public Builder RequestId(String str) {
            this.RequestId = str;
            return this;
        }

        public FSGeneralError build() {
            checkRequiredFields();
            return new FSGeneralError(this);
        }
    }
}
