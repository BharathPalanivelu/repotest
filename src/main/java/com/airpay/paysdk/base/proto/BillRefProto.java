package com.airpay.paysdk.base.proto;

import com.airpay.paysdk.libs.wire.FieldEncoding;
import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.ProtoAdapter;
import com.airpay.paysdk.libs.wire.ProtoReader;
import com.airpay.paysdk.libs.wire.ProtoWriter;
import com.airpay.paysdk.libs.wire.WireField;
import com.airpay.paysdk.libs.wire.internal.Internal;
import e.f;
import java.io.IOException;
import java.util.List;

public final class BillRefProto extends Message<BillRefProto, Builder> {
    public static final ProtoAdapter<BillRefProto> ADAPTER = new ProtoAdapter_BillRefProto();
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Boolean DEFAULT_EDITABLE = false;
    public static final Boolean DEFAULT_IS_A_DATE = false;
    public static final String DEFAULT_NAME = "";
    public static final Boolean DEFAULT_NUMERICAL = false;
    public static final String DEFAULT_PATTERN = "";
    public static final Boolean DEFAULT_REQUIRED = false;
    public static final String DEFAULT_VALUE = "";
    public static final Boolean DEFAULT_VERIFIED = false;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
    public final String description;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean editable;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean is_a_date;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean numerical;
    @WireField(adapter = "com.airpay.protocol.protobuf.BillRefProto$OptionProto#ADAPTER", label = WireField.Label.REPEATED, tag = 20)
    public final List<OptionProto> options;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 4)
    public final String pattern;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean required;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
    public final String value;
    @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean verified;

    public BillRefProto(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, List<OptionProto> list) {
        this(str, str2, str3, str4, bool, bool2, bool3, bool4, bool5, list, f.f32736b);
    }

    public BillRefProto(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, List<OptionProto> list, f fVar) {
        super(ADAPTER, fVar);
        this.name = str;
        this.description = str2;
        this.value = str3;
        this.pattern = str4;
        this.editable = bool;
        this.required = bool2;
        this.verified = bool3;
        this.numerical = bool4;
        this.is_a_date = bool5;
        this.options = Internal.immutableCopyOf("options", list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.description = this.description;
        builder.value = this.value;
        builder.pattern = this.pattern;
        builder.editable = this.editable;
        builder.required = this.required;
        builder.verified = this.verified;
        builder.numerical = this.numerical;
        builder.is_a_date = this.is_a_date;
        builder.options = Internal.copyOf("options", this.options);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BillRefProto)) {
            return false;
        }
        BillRefProto billRefProto = (BillRefProto) obj;
        if (!unknownFields().equals(billRefProto.unknownFields()) || !Internal.equals(this.name, billRefProto.name) || !Internal.equals(this.description, billRefProto.description) || !Internal.equals(this.value, billRefProto.value) || !Internal.equals(this.pattern, billRefProto.pattern) || !Internal.equals(this.editable, billRefProto.editable) || !Internal.equals(this.required, billRefProto.required) || !Internal.equals(this.verified, billRefProto.verified) || !Internal.equals(this.numerical, billRefProto.numerical) || !Internal.equals(this.is_a_date, billRefProto.is_a_date) || !this.options.equals(billRefProto.options)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.value;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.pattern;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool = this.editable;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.required;
        int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.verified;
        int hashCode8 = (hashCode7 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.numerical;
        int hashCode9 = (hashCode8 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.is_a_date;
        if (bool5 != null) {
            i2 = bool5.hashCode();
        }
        int hashCode10 = ((hashCode9 + i2) * 37) + this.options.hashCode();
        this.hashCode = hashCode10;
        return hashCode10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (this.description != null) {
            sb.append(", description=");
            sb.append(this.description);
        }
        if (this.value != null) {
            sb.append(", value=");
            sb.append(this.value);
        }
        if (this.pattern != null) {
            sb.append(", pattern=");
            sb.append(this.pattern);
        }
        if (this.editable != null) {
            sb.append(", editable=");
            sb.append(this.editable);
        }
        if (this.required != null) {
            sb.append(", required=");
            sb.append(this.required);
        }
        if (this.verified != null) {
            sb.append(", verified=");
            sb.append(this.verified);
        }
        if (this.numerical != null) {
            sb.append(", numerical=");
            sb.append(this.numerical);
        }
        if (this.is_a_date != null) {
            sb.append(", is_a_date=");
            sb.append(this.is_a_date);
        }
        if (!this.options.isEmpty()) {
            sb.append(", options=");
            sb.append(this.options);
        }
        StringBuilder replace = sb.replace(0, 2, "BillRefProto{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BillRefProto, Builder> {
        public String description;
        public Boolean editable;
        public Boolean is_a_date;
        public String name;
        public Boolean numerical;
        public List<OptionProto> options = Internal.newMutableList();
        public String pattern;
        public Boolean required;
        public String value;
        public Boolean verified;

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public Builder pattern(String str) {
            this.pattern = str;
            return this;
        }

        public Builder editable(Boolean bool) {
            this.editable = bool;
            return this;
        }

        public Builder required(Boolean bool) {
            this.required = bool;
            return this;
        }

        public Builder verified(Boolean bool) {
            this.verified = bool;
            return this;
        }

        public Builder numerical(Boolean bool) {
            this.numerical = bool;
            return this;
        }

        public Builder is_a_date(Boolean bool) {
            this.is_a_date = bool;
            return this;
        }

        public Builder options(List<OptionProto> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.options = list;
            return this;
        }

        public BillRefProto build() {
            return new BillRefProto(this.name, this.description, this.value, this.pattern, this.editable, this.required, this.verified, this.numerical, this.is_a_date, this.options, super.buildUnknownFields());
        }
    }

    public static final class OptionProto extends Message<OptionProto, Builder> {
        public static final ProtoAdapter<OptionProto> ADAPTER = new ProtoAdapter_OptionProto();
        public static final String DEFAULT_NAME = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;
        @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 2)
        public final String name;
        @WireField(adapter = "com.airpay.paysdk.libs.wire.ProtoAdapter#STRING", tag = 3)
        public final String value;

        public OptionProto(String str, String str2) {
            this(str, str2, f.f32736b);
        }

        public OptionProto(String str, String str2, f fVar) {
            super(ADAPTER, fVar);
            this.name = str;
            this.value = str2;
        }

        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.name = this.name;
            builder.value = this.value;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OptionProto)) {
                return false;
            }
            OptionProto optionProto = (OptionProto) obj;
            if (!unknownFields().equals(optionProto.unknownFields()) || !Internal.equals(this.name, optionProto.name) || !Internal.equals(this.value, optionProto.value)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.name;
            int i2 = 0;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            String str2 = this.value;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = hashCode2 + i2;
            this.hashCode = i3;
            return i3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.name != null) {
                sb.append(", name=");
                sb.append(this.name);
            }
            if (this.value != null) {
                sb.append(", value=");
                sb.append(this.value);
            }
            StringBuilder replace = sb.replace(0, 2, "OptionProto{");
            replace.append('}');
            return replace.toString();
        }

        public static final class Builder extends Message.Builder<OptionProto, Builder> {
            public String name;
            public String value;

            public Builder name(String str) {
                this.name = str;
                return this;
            }

            public Builder value(String str) {
                this.value = str;
                return this;
            }

            public OptionProto build() {
                return new OptionProto(this.name, this.value, super.buildUnknownFields());
            }
        }

        private static final class ProtoAdapter_OptionProto extends ProtoAdapter<OptionProto> {
            ProtoAdapter_OptionProto() {
                super(FieldEncoding.LENGTH_DELIMITED, OptionProto.class);
            }

            public int encodedSize(OptionProto optionProto) {
                int i = 0;
                int encodedSizeWithTag = optionProto.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, optionProto.name) : 0;
                if (optionProto.value != null) {
                    i = ProtoAdapter.STRING.encodedSizeWithTag(3, optionProto.value);
                }
                return encodedSizeWithTag + i + optionProto.unknownFields().h();
            }

            public void encode(ProtoWriter protoWriter, OptionProto optionProto) throws IOException {
                if (optionProto.name != null) {
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, optionProto.name);
                }
                if (optionProto.value != null) {
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, optionProto.value);
                }
                protoWriter.writeBytes(optionProto.unknownFields());
            }

            public OptionProto decode(ProtoReader protoReader) throws IOException {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return builder.build();
                    } else if (nextTag == 2) {
                        builder.name(ProtoAdapter.STRING.decode(protoReader));
                    } else if (nextTag != 3) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        builder.value(ProtoAdapter.STRING.decode(protoReader));
                    }
                }
            }

            public OptionProto redact(OptionProto optionProto) {
                Builder newBuilder = optionProto.newBuilder();
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
        }
    }

    private static final class ProtoAdapter_BillRefProto extends ProtoAdapter<BillRefProto> {
        ProtoAdapter_BillRefProto() {
            super(FieldEncoding.LENGTH_DELIMITED, BillRefProto.class);
        }

        public int encodedSize(BillRefProto billRefProto) {
            int i = 0;
            int encodedSizeWithTag = (billRefProto.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, billRefProto.name) : 0) + (billRefProto.description != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, billRefProto.description) : 0) + (billRefProto.value != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, billRefProto.value) : 0) + (billRefProto.pattern != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, billRefProto.pattern) : 0) + (billRefProto.editable != null ? ProtoAdapter.BOOL.encodedSizeWithTag(5, billRefProto.editable) : 0) + (billRefProto.required != null ? ProtoAdapter.BOOL.encodedSizeWithTag(6, billRefProto.required) : 0) + (billRefProto.verified != null ? ProtoAdapter.BOOL.encodedSizeWithTag(7, billRefProto.verified) : 0) + (billRefProto.numerical != null ? ProtoAdapter.BOOL.encodedSizeWithTag(8, billRefProto.numerical) : 0);
            if (billRefProto.is_a_date != null) {
                i = ProtoAdapter.BOOL.encodedSizeWithTag(9, billRefProto.is_a_date);
            }
            return encodedSizeWithTag + i + OptionProto.ADAPTER.asRepeated().encodedSizeWithTag(20, billRefProto.options) + billRefProto.unknownFields().h();
        }

        public void encode(ProtoWriter protoWriter, BillRefProto billRefProto) throws IOException {
            if (billRefProto.name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, billRefProto.name);
            }
            if (billRefProto.description != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, billRefProto.description);
            }
            if (billRefProto.value != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, billRefProto.value);
            }
            if (billRefProto.pattern != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, billRefProto.pattern);
            }
            if (billRefProto.editable != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 5, billRefProto.editable);
            }
            if (billRefProto.required != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 6, billRefProto.required);
            }
            if (billRefProto.verified != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 7, billRefProto.verified);
            }
            if (billRefProto.numerical != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 8, billRefProto.numerical);
            }
            if (billRefProto.is_a_date != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 9, billRefProto.is_a_date);
            }
            OptionProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 20, billRefProto.options);
            protoWriter.writeBytes(billRefProto.unknownFields());
        }

        public BillRefProto decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag != 20) {
                    switch (nextTag) {
                        case 1:
                            builder.name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.description(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.value(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.pattern(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.editable(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 6:
                            builder.required(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 7:
                            builder.verified(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 8:
                            builder.numerical(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 9:
                            builder.is_a_date(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    builder.options.add(OptionProto.ADAPTER.decode(protoReader));
                }
            }
        }

        public BillRefProto redact(BillRefProto billRefProto) {
            Builder newBuilder = billRefProto.newBuilder();
            Internal.redactElements(newBuilder.options, OptionProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
