package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingSocialMedia extends Message {
    public static final String DEFAULT_LOCATION = "";
    public static final String DEFAULT_SOCIALMEDIA = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String location;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String socialMedia;

    public TrackingSocialMedia(String str, String str2) {
        this.socialMedia = str;
        this.location = str2;
    }

    private TrackingSocialMedia(Builder builder) {
        this(builder.socialMedia, builder.location);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingSocialMedia)) {
            return false;
        }
        TrackingSocialMedia trackingSocialMedia = (TrackingSocialMedia) obj;
        if (!equals((Object) this.socialMedia, (Object) trackingSocialMedia.socialMedia) || !equals((Object) this.location, (Object) trackingSocialMedia.location)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.socialMedia;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.location;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingSocialMedia> {
        public String location;
        public String socialMedia;

        public Builder() {
        }

        public Builder(TrackingSocialMedia trackingSocialMedia) {
            super(trackingSocialMedia);
            if (trackingSocialMedia != null) {
                this.socialMedia = trackingSocialMedia.socialMedia;
                this.location = trackingSocialMedia.location;
            }
        }

        public Builder socialMedia(String str) {
            this.socialMedia = str;
            return this;
        }

        public Builder location(String str) {
            this.location = str;
            return this;
        }

        public TrackingSocialMedia build() {
            return new TrackingSocialMedia(this);
        }
    }
}
