package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class FileRequest extends Message {
    public static final String DEFAULT_NAME = "";
    public static final f DEFAULT_PARAMETER = f.f32736b;
    public static final f DEFAULT_TOKEN = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.BYTES)
    public final f parameter;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.BYTES)
    public final f token;

    public FileRequest(String str, f fVar, f fVar2) {
        this.name = str;
        this.token = fVar;
        this.parameter = fVar2;
    }

    private FileRequest(Builder builder) {
        this(builder.name, builder.token, builder.parameter);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileRequest)) {
            return false;
        }
        FileRequest fileRequest = (FileRequest) obj;
        if (!equals((Object) this.name, (Object) fileRequest.name) || !equals((Object) this.token, (Object) fileRequest.token) || !equals((Object) this.parameter, (Object) fileRequest.parameter)) {
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
        f fVar2 = this.parameter;
        if (fVar2 != null) {
            i2 = fVar2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FileRequest> {
        public String name;
        public f parameter;
        public f token;

        public Builder() {
        }

        public Builder(FileRequest fileRequest) {
            super(fileRequest);
            if (fileRequest != null) {
                this.name = fileRequest.name;
                this.token = fileRequest.token;
                this.parameter = fileRequest.parameter;
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

        public Builder parameter(f fVar) {
            this.parameter = fVar;
            return this;
        }

        public FileRequest build() {
            checkRequiredFields();
            return new FileRequest(this);
        }
    }
}
