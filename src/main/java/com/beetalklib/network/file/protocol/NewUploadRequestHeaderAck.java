package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class NewUploadRequestHeaderAck extends Message {
    public static final Integer DEFAULT_ERRORCODE = 0;
    public static final String DEFAULT_NAME = "";
    public static final f DEFAULT_REQUESTID = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer ErrorCode;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String Name;
    @ProtoField(tag = 1, type = Message.Datatype.BYTES)
    public final f RequestId;

    public NewUploadRequestHeaderAck(f fVar, Integer num, String str) {
        this.RequestId = fVar;
        this.ErrorCode = num;
        this.Name = str;
    }

    private NewUploadRequestHeaderAck(Builder builder) {
        this(builder.RequestId, builder.ErrorCode, builder.Name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewUploadRequestHeaderAck)) {
            return false;
        }
        NewUploadRequestHeaderAck newUploadRequestHeaderAck = (NewUploadRequestHeaderAck) obj;
        if (!equals((Object) this.RequestId, (Object) newUploadRequestHeaderAck.RequestId) || !equals((Object) this.ErrorCode, (Object) newUploadRequestHeaderAck.ErrorCode) || !equals((Object) this.Name, (Object) newUploadRequestHeaderAck.Name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        f fVar = this.RequestId;
        int i2 = 0;
        int hashCode = (fVar != null ? fVar.hashCode() : 0) * 37;
        Integer num = this.ErrorCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.Name;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<NewUploadRequestHeaderAck> {
        public Integer ErrorCode;
        public String Name;
        public f RequestId;

        public Builder() {
        }

        public Builder(NewUploadRequestHeaderAck newUploadRequestHeaderAck) {
            super(newUploadRequestHeaderAck);
            if (newUploadRequestHeaderAck != null) {
                this.RequestId = newUploadRequestHeaderAck.RequestId;
                this.ErrorCode = newUploadRequestHeaderAck.ErrorCode;
                this.Name = newUploadRequestHeaderAck.Name;
            }
        }

        public Builder RequestId(f fVar) {
            this.RequestId = fVar;
            return this;
        }

        public Builder ErrorCode(Integer num) {
            this.ErrorCode = num;
            return this;
        }

        public Builder Name(String str) {
            this.Name = str;
            return this;
        }

        public NewUploadRequestHeaderAck build() {
            return new NewUploadRequestHeaderAck(this);
        }
    }
}
