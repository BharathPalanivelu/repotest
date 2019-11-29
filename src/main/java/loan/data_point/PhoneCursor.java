package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PhoneCursor extends Message {
    public static final Integer DEFAULT_CALL_DATETIME = 0;
    public static final String DEFAULT_ITEM_ID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer call_datetime;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String item_id;

    public PhoneCursor(Integer num, String str) {
        this.call_datetime = num;
        this.item_id = str;
    }

    private PhoneCursor(Builder builder) {
        this(builder.call_datetime, builder.item_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneCursor)) {
            return false;
        }
        PhoneCursor phoneCursor = (PhoneCursor) obj;
        if (!equals((Object) this.call_datetime, (Object) phoneCursor.call_datetime) || !equals((Object) this.item_id, (Object) phoneCursor.item_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.call_datetime;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.item_id;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PhoneCursor> {
        public Integer call_datetime;
        public String item_id;

        public Builder() {
        }

        public Builder(PhoneCursor phoneCursor) {
            super(phoneCursor);
            if (phoneCursor != null) {
                this.call_datetime = phoneCursor.call_datetime;
                this.item_id = phoneCursor.item_id;
            }
        }

        public Builder call_datetime(Integer num) {
            this.call_datetime = num;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public PhoneCursor build() {
            return new PhoneCursor(this);
        }
    }
}
