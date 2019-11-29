package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class NewUploadRequestHeader extends Message {
    public static final Integer DEFAULT_FROM = 0;
    public static final String DEFAULT_MODEL = "";
    public static final Integer DEFAULT_MSGTYPE = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_OS = 0;
    public static final f DEFAULT_REQUESTID = f.f32736b;
    public static final f DEFAULT_TOKEN = f.f32736b;
    public static final Integer DEFAULT_TOTALBLOCK = 0;
    public static final Long DEFAULT_USERID = 0L;
    public static final Integer DEFAULT_VERSION = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer From;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String Model;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer MsgType;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String Name;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer OS;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f RequestId;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f Token;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer TotalBlock;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long UserID;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer Version;

    public NewUploadRequestHeader(Long l, f fVar, f fVar2, Integer num, Integer num2, Integer num3, String str, Integer num4, Integer num5, String str2) {
        this.UserID = l;
        this.RequestId = fVar;
        this.Token = fVar2;
        this.TotalBlock = num;
        this.From = num2;
        this.MsgType = num3;
        this.Name = str;
        this.OS = num4;
        this.Version = num5;
        this.Model = str2;
    }

    private NewUploadRequestHeader(Builder builder) {
        this(builder.UserID, builder.RequestId, builder.Token, builder.TotalBlock, builder.From, builder.MsgType, builder.Name, builder.OS, builder.Version, builder.Model);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewUploadRequestHeader)) {
            return false;
        }
        NewUploadRequestHeader newUploadRequestHeader = (NewUploadRequestHeader) obj;
        if (!equals((Object) this.UserID, (Object) newUploadRequestHeader.UserID) || !equals((Object) this.RequestId, (Object) newUploadRequestHeader.RequestId) || !equals((Object) this.Token, (Object) newUploadRequestHeader.Token) || !equals((Object) this.TotalBlock, (Object) newUploadRequestHeader.TotalBlock) || !equals((Object) this.From, (Object) newUploadRequestHeader.From) || !equals((Object) this.MsgType, (Object) newUploadRequestHeader.MsgType) || !equals((Object) this.Name, (Object) newUploadRequestHeader.Name) || !equals((Object) this.OS, (Object) newUploadRequestHeader.OS) || !equals((Object) this.Version, (Object) newUploadRequestHeader.Version) || !equals((Object) this.Model, (Object) newUploadRequestHeader.Model)) {
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
        f fVar2 = this.Token;
        int hashCode3 = (hashCode2 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Integer num = this.TotalBlock;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.From;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.MsgType;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.Name;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.OS;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.Version;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.Model;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<NewUploadRequestHeader> {
        public Integer From;
        public String Model;
        public Integer MsgType;
        public String Name;
        public Integer OS;
        public f RequestId;
        public f Token;
        public Integer TotalBlock;
        public Long UserID;
        public Integer Version;

        public Builder() {
        }

        public Builder(NewUploadRequestHeader newUploadRequestHeader) {
            super(newUploadRequestHeader);
            if (newUploadRequestHeader != null) {
                this.UserID = newUploadRequestHeader.UserID;
                this.RequestId = newUploadRequestHeader.RequestId;
                this.Token = newUploadRequestHeader.Token;
                this.TotalBlock = newUploadRequestHeader.TotalBlock;
                this.From = newUploadRequestHeader.From;
                this.MsgType = newUploadRequestHeader.MsgType;
                this.Name = newUploadRequestHeader.Name;
                this.OS = newUploadRequestHeader.OS;
                this.Version = newUploadRequestHeader.Version;
                this.Model = newUploadRequestHeader.Model;
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

        public Builder Token(f fVar) {
            this.Token = fVar;
            return this;
        }

        public Builder TotalBlock(Integer num) {
            this.TotalBlock = num;
            return this;
        }

        public Builder From(Integer num) {
            this.From = num;
            return this;
        }

        public Builder MsgType(Integer num) {
            this.MsgType = num;
            return this;
        }

        public Builder Name(String str) {
            this.Name = str;
            return this;
        }

        public Builder OS(Integer num) {
            this.OS = num;
            return this;
        }

        public Builder Version(Integer num) {
            this.Version = num;
            return this;
        }

        public Builder Model(String str) {
            this.Model = str;
            return this;
        }

        public NewUploadRequestHeader build() {
            return new NewUploadRequestHeader(this);
        }
    }
}
