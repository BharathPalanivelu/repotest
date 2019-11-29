package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class NewUploadRequestPartAck extends Message {
    public static final Integer DEFAULT_ERRORCODE = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_PARTID = 0;
    public static final f DEFAULT_REQUESTID = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer ErrorCode;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String Name;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer PartId;
    @ProtoField(tag = 1, type = Message.Datatype.BYTES)
    public final f RequestId;

    public NewUploadRequestPartAck(f fVar, Integer num, Integer num2, String str) {
        this.RequestId = fVar;
        this.PartId = num;
        this.ErrorCode = num2;
        this.Name = str;
    }

    private NewUploadRequestPartAck(Builder builder) {
        this(builder.RequestId, builder.PartId, builder.ErrorCode, builder.Name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewUploadRequestPartAck)) {
            return false;
        }
        NewUploadRequestPartAck newUploadRequestPartAck = (NewUploadRequestPartAck) obj;
        if (!equals((Object) this.RequestId, (Object) newUploadRequestPartAck.RequestId) || !equals((Object) this.PartId, (Object) newUploadRequestPartAck.PartId) || !equals((Object) this.ErrorCode, (Object) newUploadRequestPartAck.ErrorCode) || !equals((Object) this.Name, (Object) newUploadRequestPartAck.Name)) {
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
        Integer num = this.PartId;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.ErrorCode;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.Name;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<NewUploadRequestPartAck> {
        public Integer ErrorCode;
        public String Name;
        public Integer PartId;
        public f RequestId;

        public Builder() {
        }

        public Builder(NewUploadRequestPartAck newUploadRequestPartAck) {
            super(newUploadRequestPartAck);
            if (newUploadRequestPartAck != null) {
                this.RequestId = newUploadRequestPartAck.RequestId;
                this.PartId = newUploadRequestPartAck.PartId;
                this.ErrorCode = newUploadRequestPartAck.ErrorCode;
                this.Name = newUploadRequestPartAck.Name;
            }
        }

        public Builder RequestId(f fVar) {
            this.RequestId = fVar;
            return this;
        }

        public Builder PartId(Integer num) {
            this.PartId = num;
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

        public NewUploadRequestPartAck build() {
            return new NewUploadRequestPartAck(this);
        }
    }
}
