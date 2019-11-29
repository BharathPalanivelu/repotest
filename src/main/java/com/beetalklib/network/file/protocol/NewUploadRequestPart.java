package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class NewUploadRequestPart extends Message {
    public static final f DEFAULT_CONTENT = f.f32736b;
    public static final Integer DEFAULT_PARTID = 0;
    public static final f DEFAULT_REQUESTID = f.f32736b;
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f Content;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer PartId;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f RequestId;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long UserID;

    public NewUploadRequestPart(Long l, f fVar, Integer num, f fVar2) {
        this.UserID = l;
        this.RequestId = fVar;
        this.PartId = num;
        this.Content = fVar2;
    }

    private NewUploadRequestPart(Builder builder) {
        this(builder.UserID, builder.RequestId, builder.PartId, builder.Content);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewUploadRequestPart)) {
            return false;
        }
        NewUploadRequestPart newUploadRequestPart = (NewUploadRequestPart) obj;
        if (!equals((Object) this.UserID, (Object) newUploadRequestPart.UserID) || !equals((Object) this.RequestId, (Object) newUploadRequestPart.RequestId) || !equals((Object) this.PartId, (Object) newUploadRequestPart.PartId) || !equals((Object) this.Content, (Object) newUploadRequestPart.Content)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.UserID;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        f fVar = this.RequestId;
        int hashCode2 = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num = this.PartId;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        f fVar2 = this.Content;
        if (fVar2 != null) {
            i2 = fVar2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<NewUploadRequestPart> {
        public f Content;
        public Integer PartId;
        public f RequestId;
        public Long UserID;

        public Builder() {
        }

        public Builder(NewUploadRequestPart newUploadRequestPart) {
            super(newUploadRequestPart);
            if (newUploadRequestPart != null) {
                this.UserID = newUploadRequestPart.UserID;
                this.RequestId = newUploadRequestPart.RequestId;
                this.PartId = newUploadRequestPart.PartId;
                this.Content = newUploadRequestPart.Content;
            }
        }

        public Builder UserID(Long l) {
            this.UserID = l;
            return this;
        }

        public Builder RequestId(f fVar) {
            this.RequestId = fVar;
            return this;
        }

        public Builder PartId(Integer num) {
            this.PartId = num;
            return this;
        }

        public Builder Content(f fVar) {
            this.Content = fVar;
            return this;
        }

        public NewUploadRequestPart build() {
            return new NewUploadRequestPart(this);
        }
    }
}
