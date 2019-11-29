package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SmsInfo extends Message {
    public static final String DEFAULT_ITEM_ID = "";
    public static final String DEFAULT_SMS_CONTENT = "";
    public static final Integer DEFAULT_SMS_FLOW = 0;
    public static final String DEFAULT_SMS_PHONE = "";
    public static final Integer DEFAULT_SMS_TIMESTAMP = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String item_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String sms_content;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer sms_flow;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String sms_phone;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer sms_timestamp;

    public SmsInfo(String str, String str2, Integer num, Integer num2, String str3) {
        this.sms_phone = str;
        this.sms_content = str2;
        this.sms_timestamp = num;
        this.sms_flow = num2;
        this.item_id = str3;
    }

    private SmsInfo(Builder builder) {
        this(builder.sms_phone, builder.sms_content, builder.sms_timestamp, builder.sms_flow, builder.item_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SmsInfo)) {
            return false;
        }
        SmsInfo smsInfo = (SmsInfo) obj;
        if (!equals((Object) this.sms_phone, (Object) smsInfo.sms_phone) || !equals((Object) this.sms_content, (Object) smsInfo.sms_content) || !equals((Object) this.sms_timestamp, (Object) smsInfo.sms_timestamp) || !equals((Object) this.sms_flow, (Object) smsInfo.sms_flow) || !equals((Object) this.item_id, (Object) smsInfo.item_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.sms_phone;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.sms_content;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.sms_timestamp;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.sms_flow;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.item_id;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SmsInfo> {
        public String item_id;
        public String sms_content;
        public Integer sms_flow;
        public String sms_phone;
        public Integer sms_timestamp;

        public Builder() {
        }

        public Builder(SmsInfo smsInfo) {
            super(smsInfo);
            if (smsInfo != null) {
                this.sms_phone = smsInfo.sms_phone;
                this.sms_content = smsInfo.sms_content;
                this.sms_timestamp = smsInfo.sms_timestamp;
                this.sms_flow = smsInfo.sms_flow;
                this.item_id = smsInfo.item_id;
            }
        }

        public Builder sms_phone(String str) {
            this.sms_phone = str;
            return this;
        }

        public Builder sms_content(String str) {
            this.sms_content = str;
            return this;
        }

        public Builder sms_timestamp(Integer num) {
            this.sms_timestamp = num;
            return this;
        }

        public Builder sms_flow(Integer num) {
            this.sms_flow = num;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public SmsInfo build() {
            return new SmsInfo(this);
        }
    }
}
