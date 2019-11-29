package com.shopee.app.network.http.data.datapoint;

public class ReportUserInfoRequest {
    private String app_version;
    private int content_type;
    private String device_fingerprint;
    private String device_id;
    private String encrypt_data;
    private String encrypt_data_hash;
    private String encrypt_key;
    private int platform_type;
    private int user_id;

    private ReportUserInfoRequest(Builder builder) {
        this.user_id = builder.user_id;
        this.device_id = builder.device_id;
        this.device_fingerprint = builder.device_fingerprint;
        this.encrypt_data_hash = builder.encrypt_data_hash;
        this.platform_type = builder.platform_type;
        this.content_type = builder.content_type;
        this.encrypt_key = builder.encrypt_key;
        this.encrypt_data = builder.encrypt_data;
        this.app_version = builder.app_version;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String app_version;
        /* access modifiers changed from: private */
        public int content_type;
        /* access modifiers changed from: private */
        public String device_fingerprint;
        /* access modifiers changed from: private */
        public String device_id;
        /* access modifiers changed from: private */
        public String encrypt_data;
        /* access modifiers changed from: private */
        public String encrypt_data_hash;
        /* access modifiers changed from: private */
        public String encrypt_key;
        /* access modifiers changed from: private */
        public int platform_type;
        /* access modifiers changed from: private */
        public int user_id;

        public Builder user_id(int i) {
            this.user_id = i;
            return this;
        }

        public Builder device_id(String str) {
            this.device_id = str;
            return this;
        }

        public Builder device_fingerprint(String str) {
            this.device_fingerprint = str;
            return this;
        }

        public Builder encrypt_data_hash(String str) {
            this.encrypt_data_hash = str;
            return this;
        }

        public Builder platform_type(int i) {
            this.platform_type = i;
            return this;
        }

        public Builder content_type(int i) {
            this.content_type = i;
            return this;
        }

        public Builder encrypt_key(String str) {
            this.encrypt_key = str;
            return this;
        }

        public Builder encrypt_data(String str) {
            this.encrypt_data = str;
            return this;
        }

        public Builder app_version(String str) {
            this.app_version = str;
            return this;
        }

        public ReportUserInfoRequest build() {
            return new ReportUserInfoRequest(this);
        }
    }
}
