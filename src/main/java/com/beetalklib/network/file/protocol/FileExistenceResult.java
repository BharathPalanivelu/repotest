package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class FileExistenceResult extends Message {
    public static final Boolean DEFAULT_EXIST = false;
    public static final String DEFAULT_NAME = "";
    public static final f DEFAULT_PARAMETER = f.f32736b;
    public static final f DEFAULT_TOKEN = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.BOOL)
    public final Boolean exist;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.BYTES)
    public final f parameter;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.BYTES)
    public final f token;

    public FileExistenceResult(String str, Boolean bool, f fVar, f fVar2) {
        this.name = str;
        this.exist = bool;
        this.token = fVar;
        this.parameter = fVar2;
    }

    private FileExistenceResult(Builder builder) {
        this(builder.name, builder.exist, builder.token, builder.parameter);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileExistenceResult)) {
            return false;
        }
        FileExistenceResult fileExistenceResult = (FileExistenceResult) obj;
        if (!equals((Object) this.name, (Object) fileExistenceResult.name) || !equals((Object) this.exist, (Object) fileExistenceResult.exist) || !equals((Object) this.token, (Object) fileExistenceResult.token) || !equals((Object) this.parameter, (Object) fileExistenceResult.parameter)) {
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
        Boolean bool = this.exist;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        f fVar = this.token;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.parameter;
        if (fVar2 != null) {
            i2 = fVar2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FileExistenceResult> {
        public Boolean exist;
        public String name;
        public f parameter;
        public f token;

        public Builder() {
        }

        public Builder(FileExistenceResult fileExistenceResult) {
            super(fileExistenceResult);
            if (fileExistenceResult != null) {
                this.name = fileExistenceResult.name;
                this.exist = fileExistenceResult.exist;
                this.token = fileExistenceResult.token;
                this.parameter = fileExistenceResult.parameter;
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder exist(Boolean bool) {
            this.exist = bool;
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

        public FileExistenceResult build() {
            checkRequiredFields();
            return new FileExistenceResult(this);
        }
    }
}
