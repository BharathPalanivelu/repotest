package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReportContactInfoResponse extends Message {
    public static final String DEFAULT_ITEM_ID = "";
    public static final Integer DEFAULT_REPORT_DATETIME = 0;
    public static final Integer DEFAULT_USER_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String item_id;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer report_datetime;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer user_id;

    public ReportContactInfoResponse(String str, Integer num, Integer num2) {
        this.item_id = str;
        this.user_id = num;
        this.report_datetime = num2;
    }

    private ReportContactInfoResponse(Builder builder) {
        this(builder.item_id, builder.user_id, builder.report_datetime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReportContactInfoResponse)) {
            return false;
        }
        ReportContactInfoResponse reportContactInfoResponse = (ReportContactInfoResponse) obj;
        if (!equals((Object) this.item_id, (Object) reportContactInfoResponse.item_id) || !equals((Object) this.user_id, (Object) reportContactInfoResponse.user_id) || !equals((Object) this.report_datetime, (Object) reportContactInfoResponse.report_datetime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.item_id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.user_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.report_datetime;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReportContactInfoResponse> {
        public String item_id;
        public Integer report_datetime;
        public Integer user_id;

        public Builder() {
        }

        public Builder(ReportContactInfoResponse reportContactInfoResponse) {
            super(reportContactInfoResponse);
            if (reportContactInfoResponse != null) {
                this.item_id = reportContactInfoResponse.item_id;
                this.user_id = reportContactInfoResponse.user_id;
                this.report_datetime = reportContactInfoResponse.report_datetime;
            }
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public Builder user_id(Integer num) {
            this.user_id = num;
            return this;
        }

        public Builder report_datetime(Integer num) {
            this.report_datetime = num;
            return this;
        }

        public ReportContactInfoResponse build() {
            return new ReportContactInfoResponse(this);
        }
    }
}
