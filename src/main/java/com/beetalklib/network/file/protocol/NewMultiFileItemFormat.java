package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class NewMultiFileItemFormat extends Message {
    public static final f DEFAULT_CONTENT = f.f32736b;
    public static final String DEFAULT_SUFFIX = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f Content;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String Suffix;

    public NewMultiFileItemFormat(String str, f fVar) {
        this.Suffix = str;
        this.Content = fVar;
    }

    private NewMultiFileItemFormat(Builder builder) {
        this(builder.Suffix, builder.Content);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewMultiFileItemFormat)) {
            return false;
        }
        NewMultiFileItemFormat newMultiFileItemFormat = (NewMultiFileItemFormat) obj;
        if (!equals((Object) this.Suffix, (Object) newMultiFileItemFormat.Suffix) || !equals((Object) this.Content, (Object) newMultiFileItemFormat.Content)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.Suffix;
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

    public static final class Builder extends Message.Builder<NewMultiFileItemFormat> {
        public f Content;
        public String Suffix;

        public Builder() {
        }

        public Builder(NewMultiFileItemFormat newMultiFileItemFormat) {
            super(newMultiFileItemFormat);
            if (newMultiFileItemFormat != null) {
                this.Suffix = newMultiFileItemFormat.Suffix;
                this.Content = newMultiFileItemFormat.Content;
            }
        }

        public Builder Suffix(String str) {
            this.Suffix = str;
            return this;
        }

        public Builder Content(f fVar) {
            this.Content = fVar;
            return this;
        }

        public NewMultiFileItemFormat build() {
            return new NewMultiFileItemFormat(this);
        }
    }
}
