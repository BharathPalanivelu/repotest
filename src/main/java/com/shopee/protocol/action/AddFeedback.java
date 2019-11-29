package com.shopee.protocol.action;

import com.shopee.protocol.shop.Feedback;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AddFeedback extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final Feedback feedback;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public AddFeedback(String str, Feedback feedback2) {
        this.requestid = str;
        this.feedback = feedback2;
    }

    private AddFeedback(Builder builder) {
        this(builder.requestid, builder.feedback);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddFeedback)) {
            return false;
        }
        AddFeedback addFeedback = (AddFeedback) obj;
        if (!equals((Object) this.requestid, (Object) addFeedback.requestid) || !equals((Object) this.feedback, (Object) addFeedback.feedback)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Feedback feedback2 = this.feedback;
        if (feedback2 != null) {
            i2 = feedback2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AddFeedback> {
        public Feedback feedback;
        public String requestid;

        public Builder() {
        }

        public Builder(AddFeedback addFeedback) {
            super(addFeedback);
            if (addFeedback != null) {
                this.requestid = addFeedback.requestid;
                this.feedback = addFeedback.feedback;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder feedback(Feedback feedback2) {
            this.feedback = feedback2;
            return this;
        }

        public AddFeedback build() {
            checkRequiredFields();
            return new AddFeedback(this);
        }
    }
}
