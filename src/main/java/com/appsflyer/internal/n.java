package com.appsflyer.internal;

public final class n {

    /* renamed from: ˊ  reason: contains not printable characters */
    private b f201;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String f202;

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean f203;

    n(b bVar, String str, boolean z) {
        this.f201 = bVar;
        this.f202 = str;
        this.f203 = z;
    }

    public final String toString() {
        return String.format("%s,%s", new Object[]{this.f202, Boolean.valueOf(this.f203)});
    }

    enum b {
        GOOGLE(0),
        AMAZON(1);
        

        /* renamed from: ॱ  reason: contains not printable characters */
        private int f207;

        private b(int i) {
            this.f207 = i;
        }

        public final String toString() {
            return String.valueOf(this.f207);
        }
    }
}
