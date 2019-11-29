package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class MultiFileDataItemFormat extends Message {
    public static final f DEFAULT_CONTENT = f.f32736b;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f Content;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String Name;

    public MultiFileDataItemFormat(String str, f fVar) {
        this.Name = str;
        this.Content = fVar;
    }

    private MultiFileDataItemFormat(Builder builder) {
        this(builder.Name, builder.Content);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiFileDataItemFormat)) {
            return false;
        }
        MultiFileDataItemFormat multiFileDataItemFormat = (MultiFileDataItemFormat) obj;
        if (!equals((Object) this.Name, (Object) multiFileDataItemFormat.Name) || !equals((Object) this.Content, (Object) multiFileDataItemFormat.Content)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.Name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        f fVar = this.Content;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MultiFileDataItemFormat> {
        public f Content;
        public String Name;

        public Builder() {
        }

        public Builder(MultiFileDataItemFormat multiFileDataItemFormat) {
            super(multiFileDataItemFormat);
            if (multiFileDataItemFormat != null) {
                this.Name = multiFileDataItemFormat.Name;
                this.Content = multiFileDataItemFormat.Content;
            }
        }

        public Builder Name(String str) {
            this.Name = str;
            return this;
        }

        public Builder Content(f fVar) {
            this.Content = fVar;
            return this;
        }

        public MultiFileDataItemFormat build() {
            checkRequiredFields();
            return new MultiFileDataItemFormat(this);
        }
    }
}
