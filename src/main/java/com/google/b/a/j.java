package com.google.b.a;

import java.io.Serializable;

public final class j {

    public static class a implements Serializable {
        private static final long serialVersionUID = 1;
        private C0222a countryCodeSource_ = C0222a.UNSPECIFIED;
        private int countryCode_ = 0;
        private String extension_ = "";
        private boolean hasCountryCode;
        private boolean hasCountryCodeSource;
        private boolean hasExtension;
        private boolean hasItalianLeadingZero;
        private boolean hasNationalNumber;
        private boolean hasNumberOfLeadingZeros;
        private boolean hasPreferredDomesticCarrierCode;
        private boolean hasRawInput;
        private boolean italianLeadingZero_ = false;
        private long nationalNumber_ = 0;
        private int numberOfLeadingZeros_ = 1;
        private String preferredDomesticCarrierCode_ = "";
        private String rawInput_ = "";

        /* renamed from: com.google.b.a.j$a$a  reason: collision with other inner class name */
        public enum C0222a {
            FROM_NUMBER_WITH_PLUS_SIGN,
            FROM_NUMBER_WITH_IDD,
            FROM_NUMBER_WITHOUT_PLUS_SIGN,
            FROM_DEFAULT_COUNTRY,
            UNSPECIFIED
        }

        public int a() {
            return this.countryCode_;
        }

        public a a(int i) {
            this.hasCountryCode = true;
            this.countryCode_ = i;
            return this;
        }

        public long b() {
            return this.nationalNumber_;
        }

        public a a(long j) {
            this.hasNationalNumber = true;
            this.nationalNumber_ = j;
            return this;
        }

        public boolean c() {
            return this.hasExtension;
        }

        public String d() {
            return this.extension_;
        }

        public a a(String str) {
            if (str != null) {
                this.hasExtension = true;
                this.extension_ = str;
                return this;
            }
            throw new NullPointerException();
        }

        public boolean e() {
            return this.hasItalianLeadingZero;
        }

        public boolean f() {
            return this.italianLeadingZero_;
        }

        public a a(boolean z) {
            this.hasItalianLeadingZero = true;
            this.italianLeadingZero_ = z;
            return this;
        }

        public boolean g() {
            return this.hasNumberOfLeadingZeros;
        }

        public int h() {
            return this.numberOfLeadingZeros_;
        }

        public a b(int i) {
            this.hasNumberOfLeadingZeros = true;
            this.numberOfLeadingZeros_ = i;
            return this;
        }

        public boolean i() {
            return this.hasRawInput;
        }

        public String j() {
            return this.rawInput_;
        }

        public a b(String str) {
            if (str != null) {
                this.hasRawInput = true;
                this.rawInput_ = str;
                return this;
            }
            throw new NullPointerException();
        }

        public boolean k() {
            return this.hasCountryCodeSource;
        }

        public C0222a l() {
            return this.countryCodeSource_;
        }

        public a a(C0222a aVar) {
            if (aVar != null) {
                this.hasCountryCodeSource = true;
                this.countryCodeSource_ = aVar;
                return this;
            }
            throw new NullPointerException();
        }

        public a m() {
            this.hasCountryCodeSource = false;
            this.countryCodeSource_ = C0222a.UNSPECIFIED;
            return this;
        }

        public boolean n() {
            return this.hasPreferredDomesticCarrierCode;
        }

        public String o() {
            return this.preferredDomesticCarrierCode_;
        }

        public a c(String str) {
            if (str != null) {
                this.hasPreferredDomesticCarrierCode = true;
                this.preferredDomesticCarrierCode_ = str;
                return this;
            }
            throw new NullPointerException();
        }

        public boolean a(a aVar) {
            if (aVar == null) {
                return false;
            }
            if (this == aVar) {
                return true;
            }
            if (this.countryCode_ == aVar.countryCode_ && this.nationalNumber_ == aVar.nationalNumber_ && this.extension_.equals(aVar.extension_) && this.italianLeadingZero_ == aVar.italianLeadingZero_ && this.numberOfLeadingZeros_ == aVar.numberOfLeadingZeros_ && this.rawInput_.equals(aVar.rawInput_) && this.countryCodeSource_ == aVar.countryCodeSource_ && this.preferredDomesticCarrierCode_.equals(aVar.preferredDomesticCarrierCode_) && n() == aVar.n()) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && a((a) obj);
        }

        public int hashCode() {
            int i = 1231;
            int a2 = (((((((((((((((2173 + a()) * 53) + Long.valueOf(b()).hashCode()) * 53) + d().hashCode()) * 53) + (f() ? 1231 : 1237)) * 53) + h()) * 53) + j().hashCode()) * 53) + l().hashCode()) * 53) + o().hashCode()) * 53;
            if (!n()) {
                i = 1237;
            }
            return a2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Country Code: ");
            sb.append(this.countryCode_);
            sb.append(" National Number: ");
            sb.append(this.nationalNumber_);
            if (e() && f()) {
                sb.append(" Leading Zero(s): true");
            }
            if (g()) {
                sb.append(" Number of leading zeros: ");
                sb.append(this.numberOfLeadingZeros_);
            }
            if (c()) {
                sb.append(" Extension: ");
                sb.append(this.extension_);
            }
            if (k()) {
                sb.append(" Country Code Source: ");
                sb.append(this.countryCodeSource_);
            }
            if (n()) {
                sb.append(" Preferred Domestic Carrier Code: ");
                sb.append(this.preferredDomesticCarrierCode_);
            }
            return sb.toString();
        }
    }
}
