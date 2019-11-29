package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ContactCursor extends Message {
    public static final String DEFAULT_CONTACT_NAME = "";
    public static final String DEFAULT_ITEM_ID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String contact_name;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String item_id;

    public ContactCursor(String str, String str2) {
        this.contact_name = str;
        this.item_id = str2;
    }

    private ContactCursor(Builder builder) {
        this(builder.contact_name, builder.item_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContactCursor)) {
            return false;
        }
        ContactCursor contactCursor = (ContactCursor) obj;
        if (!equals((Object) this.contact_name, (Object) contactCursor.contact_name) || !equals((Object) this.item_id, (Object) contactCursor.item_id)) {
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
        String str2 = this.item_id;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ContactCursor> {
        public String contact_name;
        public String item_id;

        public Builder() {
        }

        public Builder(ContactCursor contactCursor) {
            super(contactCursor);
            if (contactCursor != null) {
                this.contact_name = contactCursor.contact_name;
                this.item_id = contactCursor.item_id;
            }
        }

        public Builder contact_name(String str) {
            this.contact_name = str;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public ContactCursor build() {
            return new ContactCursor(this);
        }
    }
}
