package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CheckActivityRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final CuratedActivity activity;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public CheckActivityRequest(RequestHeader requestHeader, CuratedActivity curatedActivity) {
        this.header = requestHeader;
        this.activity = curatedActivity;
    }

    private CheckActivityRequest(Builder builder) {
        this(builder.header, builder.activity);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckActivityRequest)) {
            return false;
        }
        CheckActivityRequest checkActivityRequest = (CheckActivityRequest) obj;
        if (!equals((Object) this.header, (Object) checkActivityRequest.header) || !equals((Object) this.activity, (Object) checkActivityRequest.activity)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        CuratedActivity curatedActivity = this.activity;
        if (curatedActivity != null) {
            i2 = curatedActivity.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckActivityRequest> {
        public CuratedActivity activity;
        public RequestHeader header;

        public Builder() {
        }

        public Builder(CheckActivityRequest checkActivityRequest) {
            super(checkActivityRequest);
            if (checkActivityRequest != null) {
                this.header = checkActivityRequest.header;
                this.activity = checkActivityRequest.activity;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder activity(CuratedActivity curatedActivity) {
            this.activity = curatedActivity;
            return this;
        }

        public CheckActivityRequest build() {
            return new CheckActivityRequest(this);
        }
    }
}
