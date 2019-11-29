package com.shopee.react.sdk.bridge.protocol;

public class ContactPickerResult {
    private ContactData data;
    private int error;

    private ContactPickerResult(Builder builder) {
        this.data = builder.data;
        this.error = builder.error;
    }

    public static class ContactData {
        private String name;
        private String phone;

        public ContactData(String str, String str2) {
            this.name = str;
            this.phone = str2;
        }
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public ContactData data;
        /* access modifiers changed from: private */
        public int error;

        public Builder data(ContactData contactData) {
            this.data = contactData;
            return this;
        }

        public Builder error(int i) {
            this.error = i;
            return this;
        }

        public ContactPickerResult build() {
            return new ContactPickerResult(this);
        }
    }
}
