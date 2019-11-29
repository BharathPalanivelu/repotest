package com.shopee.sdk.modules.app.tracker;

import com.google.a.a.c;
import com.google.a.o;

public class TrackingEvent {
    @c(a = "info")
    public TrackingInfo info;
    @c(a = "pageId")
    public String pageId;
    @c(a = "source")
    public String source;
    @c(a = "timestamp")
    public long timestamp;
    @c(a = "type")
    public String type;

    public TrackingEvent(String str, TrackingInfo trackingInfo) {
        this.type = "v3";
        this.source = "android";
        this.info = trackingInfo;
        this.pageId = str;
        this.timestamp = System.currentTimeMillis();
    }

    private TrackingEvent(Builder builder) {
        this.type = "v3";
        this.source = "android";
        this.type = builder.type;
        this.source = builder.source;
        this.timestamp = builder.timestamp;
        this.pageId = builder.pageId;
        this.info = builder.info;
    }

    public static class TrackingInfo {
        @c(a = "data")
        public o data;
        @c(a = "operation")
        public String operation;
        @c(a = "page_section")
        public String pageSection;
        @c(a = "page_type")
        public String pageType;
        @c(a = "target_type")
        public String targetType;
        @c(a = "usage_id")
        public Integer usageId;

        private TrackingInfo(Builder builder) {
            this.pageType = builder.pageType;
            this.pageSection = builder.pageSection;
            this.targetType = builder.targetType;
            this.operation = builder.operation;
            this.data = builder.data;
            this.usageId = builder.usageId;
        }

        public static final class Builder {
            /* access modifiers changed from: private */
            public o data;
            /* access modifiers changed from: private */
            public String operation;
            /* access modifiers changed from: private */
            public String pageSection;
            /* access modifiers changed from: private */
            public String pageType;
            /* access modifiers changed from: private */
            public String targetType;
            /* access modifiers changed from: private */
            public Integer usageId;

            public Builder pageType(String str) {
                this.pageType = str;
                return this;
            }

            public Builder pageSection(String str) {
                this.pageSection = str;
                return this;
            }

            public Builder targetType(String str) {
                this.targetType = str;
                return this;
            }

            public Builder operation(String str) {
                this.operation = str;
                return this;
            }

            public Builder data(o oVar) {
                this.data = oVar;
                return this;
            }

            public Builder usageId(Integer num) {
                this.usageId = num;
                return this;
            }

            public TrackingInfo build() {
                return new TrackingInfo(this);
            }
        }
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public TrackingInfo info;
        /* access modifiers changed from: private */
        public String pageId;
        /* access modifiers changed from: private */
        public String source = "android";
        /* access modifiers changed from: private */
        public long timestamp;
        /* access modifiers changed from: private */
        public String type = "v3";

        public Builder type(String str) {
            this.type = str;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder timestamp(long j) {
            this.timestamp = j;
            return this;
        }

        public Builder pageId(String str) {
            this.pageId = str;
            return this;
        }

        public Builder info(TrackingInfo trackingInfo) {
            this.info = trackingInfo;
            return this;
        }

        public TrackingEvent build() {
            return new TrackingEvent(this);
        }
    }
}
