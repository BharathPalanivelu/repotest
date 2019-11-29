package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class FileResponse extends Message {
    public static final f DEFAULT_CONTENT = f.f32736b;
    public static final Integer DEFAULT_ERROR_CODE = 0;
    public static final Integer DEFAULT_EXPIRE = 24;
    public static final String DEFAULT_NAME = "";
    public static final f DEFAULT_PARAMETER = f.f32736b;
    public static final f DEFAULT_TOKEN = f.f32736b;
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f content;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer error_code;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer expire;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.BYTES)
    public final f parameter;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f token;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String type;

    public FileResponse(String str, f fVar, String str2, f fVar2, f fVar3, Integer num, Integer num2) {
        this.name = str;
        this.token = fVar;
        this.type = str2;
        this.content = fVar2;
        this.parameter = fVar3;
        this.expire = num;
        this.error_code = num2;
    }

    private FileResponse(Builder builder) {
        this(builder.name, builder.token, builder.type, builder.content, builder.parameter, builder.expire, builder.error_code);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileResponse)) {
            return false;
        }
        FileResponse fileResponse = (FileResponse) obj;
        if (!equals((Object) this.name, (Object) fileResponse.name) || !equals((Object) this.token, (Object) fileResponse.token) || !equals((Object) this.type, (Object) fileResponse.type) || !equals((Object) this.content, (Object) fileResponse.content) || !equals((Object) this.parameter, (Object) fileResponse.parameter) || !equals((Object) this.expire, (Object) fileResponse.expire) || !equals((Object) this.error_code, (Object) fileResponse.error_code)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        f fVar = this.token;
        int hashCode2 = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str2 = this.type;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar2 = this.content;
        int hashCode4 = (hashCode3 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        f fVar3 = this.parameter;
        int hashCode5 = (hashCode4 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        Integer num = this.expire;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.error_code;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FileResponse> {
        public f content;
        public Integer error_code;
        public Integer expire;
        public String name;
        public f parameter;
        public f token;
        public String type;

        public Builder() {
        }

        public Builder(FileResponse fileResponse) {
            super(fileResponse);
            if (fileResponse != null) {
                this.name = fileResponse.name;
                this.token = fileResponse.token;
                this.type = fileResponse.type;
                this.content = fileResponse.content;
                this.parameter = fileResponse.parameter;
                this.expire = fileResponse.expire;
                this.error_code = fileResponse.error_code;
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder token(f fVar) {
            this.token = fVar;
            return this;
        }

        public Builder type(String str) {
            this.type = str;
            return this;
        }

        public Builder content(f fVar) {
            this.content = fVar;
            return this;
        }

        public Builder parameter(f fVar) {
            this.parameter = fVar;
            return this;
        }

        public Builder expire(Integer num) {
            this.expire = num;
            return this;
        }

        public Builder error_code(Integer num) {
            this.error_code = num;
            return this;
        }

        public FileResponse build() {
            checkRequiredFields();
            return new FileResponse(this);
        }
    }
}
