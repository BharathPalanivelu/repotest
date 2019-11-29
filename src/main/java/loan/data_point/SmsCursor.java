package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SmsCursor extends Message {
    public static final String DEFAULT_ITEM_ID = "";
    public static final Integer DEFAULT_SMS_TIMESTAMP = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String item_id;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer sms_timestamp;

    public SmsCursor(Integer num, String str) {
        this.sms_timestamp = num;
        this.item_id = str;
    }

    private SmsCursor(Builder builder) {
        this(builder.sms_timestamp, builder.item_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SmsCursor)) {
            return false;
        }
        SmsCursor smsCursor = (SmsCursor) obj;
        if (!equals((Object) this.sms_timestamp, (Object) smsCursor.sms_timestamp) || !equals((Object) this.item_id, (Object) smsCursor.item_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.sms_timestamp;
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

    public static final class Builder extends Message.Builder<SmsCursor> {
        public String item_id;
        public Integer sms_timestamp;

        public Builder() {
        }

        public Builder(SmsCursor smsCursor) {
            super(smsCursor);
            if (smsCursor != null) {
                this.sms_timestamp = smsCursor.sms_timestamp;
                this.item_id = smsCursor.item_id;
            }
        }

        public Builder sms_timestamp(Integer num) {
            this.sms_timestamp = num;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public SmsCursor build() {
            return new SmsCursor(this);
        }
    }
}
