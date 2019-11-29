package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PhoneInfo extends Message {
    public static final Integer DEFAULT_CALL_DATETIME = 0;
    public static final Integer DEFAULT_CALL_FLOW = 0;
    public static final String DEFAULT_CALL_NUMBER = "";
    public static final Integer DEFAULT_CALL_SPENDTIME = 0;
    public static final String DEFAULT_ITEM_ID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer call_datetime;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer call_flow;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String call_number;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer call_spendtime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String item_id;

    public PhoneInfo(String str, Integer num, Integer num2, Integer num3, String str2) {
        this.call_number = str;
        this.call_datetime = num;
        this.call_spendtime = num2;
        this.call_flow = num3;
        this.item_id = str2;
    }

    private PhoneInfo(Builder builder) {
        this(builder.call_number, builder.call_datetime, builder.call_spendtime, builder.call_flow, builder.item_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneInfo)) {
            return false;
        }
        PhoneInfo phoneInfo = (PhoneInfo) obj;
        if (!equals((Object) this.call_number, (Object) phoneInfo.call_number) || !equals((Object) this.call_datetime, (Object) phoneInfo.call_datetime) || !equals((Object) this.call_spendtime, (Object) phoneInfo.call_spendtime) || !equals((Object) this.call_flow, (Object) phoneInfo.call_flow) || !equals((Object) this.item_id, (Object) phoneInfo.item_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.call_number;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.call_datetime;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.call_spendtime;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.call_flow;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.item_id;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PhoneInfo> {
        public Integer call_datetime;
        public Integer call_flow;
        public String call_number;
        public Integer call_spendtime;
        public String item_id;

        public Builder() {
        }

        public Builder(PhoneInfo phoneInfo) {
            super(phoneInfo);
            if (phoneInfo != null) {
                this.call_number = phoneInfo.call_number;
                this.call_datetime = phoneInfo.call_datetime;
                this.call_spendtime = phoneInfo.call_spendtime;
                this.call_flow = phoneInfo.call_flow;
                this.item_id = phoneInfo.item_id;
            }
        }

        public Builder call_number(String str) {
            this.call_number = str;
            return this;
        }

        public Builder call_datetime(Integer num) {
            this.call_datetime = num;
            return this;
        }

        public Builder call_spendtime(Integer num) {
            this.call_spendtime = num;
            return this;
        }

        public Builder call_flow(Integer num) {
            this.call_flow = num;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public PhoneInfo build() {
            return new PhoneInfo(this);
        }
    }
}
