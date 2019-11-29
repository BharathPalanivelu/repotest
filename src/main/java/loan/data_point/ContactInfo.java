package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ContactInfo extends Message {
    public static final String DEFAULT_CONTACT_NAME = "";
    public static final String DEFAULT_CONTACT_NUMBER = "";
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_ITEM_ID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String contact_name;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String contact_number;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String item_id;

    public ContactInfo(String str, String str2, String str3, String str4) {
        this.contact_name = str;
        this.contact_number = str2;
        this.email = str3;
        this.item_id = str4;
    }

    private ContactInfo(Builder builder) {
        this(builder.contact_name, builder.contact_number, builder.email, builder.item_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContactInfo)) {
            return false;
        }
        ContactInfo contactInfo = (ContactInfo) obj;
        if (!equals((Object) this.contact_name, (Object) contactInfo.contact_name) || !equals((Object) this.contact_number, (Object) contactInfo.contact_number) || !equals((Object) this.email, (Object) contactInfo.email) || !equals((Object) this.item_id, (Object) contactInfo.item_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.contact_name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.contact_number;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.email;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.item_id;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ContactInfo> {
        public String contact_name;
        public String contact_number;
        public String email;
        public String item_id;

        public Builder() {
        }

        public Builder(ContactInfo contactInfo) {
            super(contactInfo);
            if (contactInfo != null) {
                this.contact_name = contactInfo.contact_name;
                this.contact_number = contactInfo.contact_number;
                this.email = contactInfo.email;
                this.item_id = contactInfo.item_id;
            }
        }

        public Builder contact_name(String str) {
            this.contact_name = str;
            return this;
        }

        public Builder contact_number(String str) {
            this.contact_number = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public ContactInfo build() {
            return new ContactInfo(this);
        }
    }
}
