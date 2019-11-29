package com.google.b.a;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public final class i {

    public static class a implements Externalizable {
        private static final long serialVersionUID = 1;
        private String domesticCarrierCodeFormattingRule_ = "";
        private String format_ = "";
        private boolean hasDomesticCarrierCodeFormattingRule;
        private boolean hasFormat;
        private boolean hasNationalPrefixFormattingRule;
        private boolean hasNationalPrefixOptionalWhenFormatting;
        private boolean hasPattern;
        private List<String> leadingDigitsPattern_ = new ArrayList();
        private String nationalPrefixFormattingRule_ = "";
        private boolean nationalPrefixOptionalWhenFormatting_ = false;
        private String pattern_ = "";

        /* renamed from: com.google.b.a.i$a$a  reason: collision with other inner class name */
        public static final class C0221a extends a {
            public C0221a a(a aVar) {
                if (aVar.b()) {
                    a(aVar.c());
                }
                if (aVar.d()) {
                    b(aVar.e());
                }
                for (int i = 0; i < aVar.f(); i++) {
                    c(aVar.a(i));
                }
                if (aVar.g()) {
                    d(aVar.h());
                }
                if (aVar.l()) {
                    e(aVar.m());
                }
                if (aVar.j()) {
                    a(aVar.k());
                }
                return this;
            }
        }

        public static C0221a a() {
            return new C0221a();
        }

        public boolean b() {
            return this.hasPattern;
        }

        public String c() {
            return this.pattern_;
        }

        public a a(String str) {
            this.hasPattern = true;
            this.pattern_ = str;
            return this;
        }

        public boolean d() {
            return this.hasFormat;
        }

        public String e() {
            return this.format_;
        }

        public a b(String str) {
            this.hasFormat = true;
            this.format_ = str;
            return this;
        }

        public int f() {
            return this.leadingDigitsPattern_.size();
        }

        public String a(int i) {
            return this.leadingDigitsPattern_.get(i);
        }

        public a c(String str) {
            if (str != null) {
                this.leadingDigitsPattern_.add(str);
                return this;
            }
            throw new NullPointerException();
        }

        public boolean g() {
            return this.hasNationalPrefixFormattingRule;
        }

        public String h() {
            return this.nationalPrefixFormattingRule_;
        }

        public a d(String str) {
            this.hasNationalPrefixFormattingRule = true;
            this.nationalPrefixFormattingRule_ = str;
            return this;
        }

        public a i() {
            this.hasNationalPrefixFormattingRule = false;
            this.nationalPrefixFormattingRule_ = "";
            return this;
        }

        public boolean j() {
            return this.hasNationalPrefixOptionalWhenFormatting;
        }

        public boolean k() {
            return this.nationalPrefixOptionalWhenFormatting_;
        }

        public a a(boolean z) {
            this.hasNationalPrefixOptionalWhenFormatting = true;
            this.nationalPrefixOptionalWhenFormatting_ = z;
            return this;
        }

        public boolean l() {
            return this.hasDomesticCarrierCodeFormattingRule;
        }

        public String m() {
            return this.domesticCarrierCodeFormattingRule_;
        }

        public a e(String str) {
            this.hasDomesticCarrierCodeFormattingRule = true;
            this.domesticCarrierCodeFormattingRule_ = str;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeUTF(this.pattern_);
            objectOutput.writeUTF(this.format_);
            int f2 = f();
            objectOutput.writeInt(f2);
            for (int i = 0; i < f2; i++) {
                objectOutput.writeUTF(this.leadingDigitsPattern_.get(i));
            }
            objectOutput.writeBoolean(this.hasNationalPrefixFormattingRule);
            if (this.hasNationalPrefixFormattingRule) {
                objectOutput.writeUTF(this.nationalPrefixFormattingRule_);
            }
            objectOutput.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
            if (this.hasDomesticCarrierCodeFormattingRule) {
                objectOutput.writeUTF(this.domesticCarrierCodeFormattingRule_);
            }
            objectOutput.writeBoolean(this.nationalPrefixOptionalWhenFormatting_);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            a(objectInput.readUTF());
            b(objectInput.readUTF());
            int readInt = objectInput.readInt();
            for (int i = 0; i < readInt; i++) {
                this.leadingDigitsPattern_.add(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                d(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                e(objectInput.readUTF());
            }
            a(objectInput.readBoolean());
        }
    }

    public static class d implements Externalizable {
        private static final long serialVersionUID = 1;
        private String exampleNumber_ = "";
        private boolean hasExampleNumber;
        private boolean hasNationalNumberPattern;
        private String nationalNumberPattern_ = "";
        private List<Integer> possibleLengthLocalOnly_ = new ArrayList();
        private List<Integer> possibleLength_ = new ArrayList();

        public String a() {
            return this.nationalNumberPattern_;
        }

        public d a(String str) {
            this.hasNationalNumberPattern = true;
            this.nationalNumberPattern_ = str;
            return this;
        }

        public List<Integer> b() {
            return this.possibleLength_;
        }

        public int c() {
            return this.possibleLength_.size();
        }

        public int a(int i) {
            return this.possibleLength_.get(i).intValue();
        }

        public List<Integer> d() {
            return this.possibleLengthLocalOnly_;
        }

        public int e() {
            return this.possibleLengthLocalOnly_.size();
        }

        public d b(String str) {
            this.hasExampleNumber = true;
            this.exampleNumber_ = str;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeBoolean(this.hasNationalNumberPattern);
            if (this.hasNationalNumberPattern) {
                objectOutput.writeUTF(this.nationalNumberPattern_);
            }
            int c2 = c();
            objectOutput.writeInt(c2);
            for (int i = 0; i < c2; i++) {
                objectOutput.writeInt(this.possibleLength_.get(i).intValue());
            }
            int e2 = e();
            objectOutput.writeInt(e2);
            for (int i2 = 0; i2 < e2; i2++) {
                objectOutput.writeInt(this.possibleLengthLocalOnly_.get(i2).intValue());
            }
            objectOutput.writeBoolean(this.hasExampleNumber);
            if (this.hasExampleNumber) {
                objectOutput.writeUTF(this.exampleNumber_);
            }
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readBoolean()) {
                a(objectInput.readUTF());
            }
            int readInt = objectInput.readInt();
            for (int i = 0; i < readInt; i++) {
                this.possibleLength_.add(Integer.valueOf(objectInput.readInt()));
            }
            int readInt2 = objectInput.readInt();
            for (int i2 = 0; i2 < readInt2; i2++) {
                this.possibleLengthLocalOnly_.add(Integer.valueOf(objectInput.readInt()));
            }
            if (objectInput.readBoolean()) {
                b(objectInput.readUTF());
            }
        }
    }

    public static class b implements Externalizable {
        private static final long serialVersionUID = 1;
        private d carrierSpecific_ = null;
        private int countryCode_ = 0;
        private d emergency_ = null;
        private d fixedLine_ = null;
        private d generalDesc_ = null;
        private boolean hasCarrierSpecific;
        private boolean hasCountryCode;
        private boolean hasEmergency;
        private boolean hasFixedLine;
        private boolean hasGeneralDesc;
        private boolean hasId;
        private boolean hasInternationalPrefix;
        private boolean hasLeadingDigits;
        private boolean hasLeadingZeroPossible;
        private boolean hasMainCountryForCode;
        private boolean hasMobile;
        private boolean hasMobileNumberPortableRegion;
        private boolean hasNationalPrefix;
        private boolean hasNationalPrefixForParsing;
        private boolean hasNationalPrefixTransformRule;
        private boolean hasNoInternationalDialling;
        private boolean hasPager;
        private boolean hasPersonalNumber;
        private boolean hasPreferredExtnPrefix;
        private boolean hasPreferredInternationalPrefix;
        private boolean hasPremiumRate;
        private boolean hasSameMobileAndFixedLinePattern;
        private boolean hasSharedCost;
        private boolean hasShortCode;
        private boolean hasSmsServices;
        private boolean hasStandardRate;
        private boolean hasTollFree;
        private boolean hasUan;
        private boolean hasVoicemail;
        private boolean hasVoip;
        private String id_ = "";
        private String internationalPrefix_ = "";
        private List<a> intlNumberFormat_ = new ArrayList();
        private String leadingDigits_ = "";
        private boolean leadingZeroPossible_ = false;
        private boolean mainCountryForCode_ = false;
        private boolean mobileNumberPortableRegion_ = false;
        private d mobile_ = null;
        private String nationalPrefixForParsing_ = "";
        private String nationalPrefixTransformRule_ = "";
        private String nationalPrefix_ = "";
        private d noInternationalDialling_ = null;
        private List<a> numberFormat_ = new ArrayList();
        private d pager_ = null;
        private d personalNumber_ = null;
        private String preferredExtnPrefix_ = "";
        private String preferredInternationalPrefix_ = "";
        private d premiumRate_ = null;
        private boolean sameMobileAndFixedLinePattern_ = false;
        private d sharedCost_ = null;
        private d shortCode_ = null;
        private d smsServices_ = null;
        private d standardRate_ = null;
        private d tollFree_ = null;
        private d uan_ = null;
        private d voicemail_ = null;
        private d voip_ = null;

        public d a() {
            return this.generalDesc_;
        }

        public b a(d dVar) {
            if (dVar != null) {
                this.hasGeneralDesc = true;
                this.generalDesc_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public d b() {
            return this.fixedLine_;
        }

        public b b(d dVar) {
            if (dVar != null) {
                this.hasFixedLine = true;
                this.fixedLine_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public d c() {
            return this.mobile_;
        }

        public b c(d dVar) {
            if (dVar != null) {
                this.hasMobile = true;
                this.mobile_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public d d() {
            return this.tollFree_;
        }

        public b d(d dVar) {
            if (dVar != null) {
                this.hasTollFree = true;
                this.tollFree_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public d e() {
            return this.premiumRate_;
        }

        public b e(d dVar) {
            if (dVar != null) {
                this.hasPremiumRate = true;
                this.premiumRate_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public d f() {
            return this.sharedCost_;
        }

        public b f(d dVar) {
            if (dVar != null) {
                this.hasSharedCost = true;
                this.sharedCost_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public d g() {
            return this.personalNumber_;
        }

        public b g(d dVar) {
            if (dVar != null) {
                this.hasPersonalNumber = true;
                this.personalNumber_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public d h() {
            return this.voip_;
        }

        public b h(d dVar) {
            if (dVar != null) {
                this.hasVoip = true;
                this.voip_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public d i() {
            return this.pager_;
        }

        public b i(d dVar) {
            if (dVar != null) {
                this.hasPager = true;
                this.pager_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public d j() {
            return this.uan_;
        }

        public b j(d dVar) {
            if (dVar != null) {
                this.hasUan = true;
                this.uan_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public b k(d dVar) {
            if (dVar != null) {
                this.hasEmergency = true;
                this.emergency_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public d k() {
            return this.voicemail_;
        }

        public b l(d dVar) {
            if (dVar != null) {
                this.hasVoicemail = true;
                this.voicemail_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public b m(d dVar) {
            if (dVar != null) {
                this.hasShortCode = true;
                this.shortCode_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public b n(d dVar) {
            if (dVar != null) {
                this.hasStandardRate = true;
                this.standardRate_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public b o(d dVar) {
            if (dVar != null) {
                this.hasCarrierSpecific = true;
                this.carrierSpecific_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public b p(d dVar) {
            if (dVar != null) {
                this.hasSmsServices = true;
                this.smsServices_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public b q(d dVar) {
            if (dVar != null) {
                this.hasNoInternationalDialling = true;
                this.noInternationalDialling_ = dVar;
                return this;
            }
            throw new NullPointerException();
        }

        public b a(String str) {
            this.hasId = true;
            this.id_ = str;
            return this;
        }

        public int l() {
            return this.countryCode_;
        }

        public b a(int i) {
            this.hasCountryCode = true;
            this.countryCode_ = i;
            return this;
        }

        public String m() {
            return this.internationalPrefix_;
        }

        public b b(String str) {
            this.hasInternationalPrefix = true;
            this.internationalPrefix_ = str;
            return this;
        }

        public boolean n() {
            return this.hasPreferredInternationalPrefix;
        }

        public String o() {
            return this.preferredInternationalPrefix_;
        }

        public b c(String str) {
            this.hasPreferredInternationalPrefix = true;
            this.preferredInternationalPrefix_ = str;
            return this;
        }

        public String p() {
            return this.nationalPrefix_;
        }

        public b d(String str) {
            this.hasNationalPrefix = true;
            this.nationalPrefix_ = str;
            return this;
        }

        public boolean q() {
            return this.hasPreferredExtnPrefix;
        }

        public String r() {
            return this.preferredExtnPrefix_;
        }

        public b e(String str) {
            this.hasPreferredExtnPrefix = true;
            this.preferredExtnPrefix_ = str;
            return this;
        }

        public String s() {
            return this.nationalPrefixForParsing_;
        }

        public b f(String str) {
            this.hasNationalPrefixForParsing = true;
            this.nationalPrefixForParsing_ = str;
            return this;
        }

        public String t() {
            return this.nationalPrefixTransformRule_;
        }

        public b g(String str) {
            this.hasNationalPrefixTransformRule = true;
            this.nationalPrefixTransformRule_ = str;
            return this;
        }

        public boolean u() {
            return this.sameMobileAndFixedLinePattern_;
        }

        public b a(boolean z) {
            this.hasSameMobileAndFixedLinePattern = true;
            this.sameMobileAndFixedLinePattern_ = z;
            return this;
        }

        public List<a> v() {
            return this.numberFormat_;
        }

        public int w() {
            return this.numberFormat_.size();
        }

        public List<a> x() {
            return this.intlNumberFormat_;
        }

        public int y() {
            return this.intlNumberFormat_.size();
        }

        public b b(boolean z) {
            this.hasMainCountryForCode = true;
            this.mainCountryForCode_ = z;
            return this;
        }

        public boolean z() {
            return this.hasLeadingDigits;
        }

        public String A() {
            return this.leadingDigits_;
        }

        public b h(String str) {
            this.hasLeadingDigits = true;
            this.leadingDigits_ = str;
            return this;
        }

        public b c(boolean z) {
            this.hasLeadingZeroPossible = true;
            this.leadingZeroPossible_ = z;
            return this;
        }

        public b d(boolean z) {
            this.hasMobileNumberPortableRegion = true;
            this.mobileNumberPortableRegion_ = z;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeBoolean(this.hasGeneralDesc);
            if (this.hasGeneralDesc) {
                this.generalDesc_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasFixedLine);
            if (this.hasFixedLine) {
                this.fixedLine_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasMobile);
            if (this.hasMobile) {
                this.mobile_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasTollFree);
            if (this.hasTollFree) {
                this.tollFree_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPremiumRate);
            if (this.hasPremiumRate) {
                this.premiumRate_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasSharedCost);
            if (this.hasSharedCost) {
                this.sharedCost_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPersonalNumber);
            if (this.hasPersonalNumber) {
                this.personalNumber_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasVoip);
            if (this.hasVoip) {
                this.voip_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPager);
            if (this.hasPager) {
                this.pager_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasUan);
            if (this.hasUan) {
                this.uan_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasEmergency);
            if (this.hasEmergency) {
                this.emergency_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasVoicemail);
            if (this.hasVoicemail) {
                this.voicemail_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasShortCode);
            if (this.hasShortCode) {
                this.shortCode_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasStandardRate);
            if (this.hasStandardRate) {
                this.standardRate_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasCarrierSpecific);
            if (this.hasCarrierSpecific) {
                this.carrierSpecific_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasSmsServices);
            if (this.hasSmsServices) {
                this.smsServices_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasNoInternationalDialling);
            if (this.hasNoInternationalDialling) {
                this.noInternationalDialling_.writeExternal(objectOutput);
            }
            objectOutput.writeUTF(this.id_);
            objectOutput.writeInt(this.countryCode_);
            objectOutput.writeUTF(this.internationalPrefix_);
            objectOutput.writeBoolean(this.hasPreferredInternationalPrefix);
            if (this.hasPreferredInternationalPrefix) {
                objectOutput.writeUTF(this.preferredInternationalPrefix_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefix);
            if (this.hasNationalPrefix) {
                objectOutput.writeUTF(this.nationalPrefix_);
            }
            objectOutput.writeBoolean(this.hasPreferredExtnPrefix);
            if (this.hasPreferredExtnPrefix) {
                objectOutput.writeUTF(this.preferredExtnPrefix_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefixForParsing);
            if (this.hasNationalPrefixForParsing) {
                objectOutput.writeUTF(this.nationalPrefixForParsing_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefixTransformRule);
            if (this.hasNationalPrefixTransformRule) {
                objectOutput.writeUTF(this.nationalPrefixTransformRule_);
            }
            objectOutput.writeBoolean(this.sameMobileAndFixedLinePattern_);
            int w = w();
            objectOutput.writeInt(w);
            for (int i = 0; i < w; i++) {
                this.numberFormat_.get(i).writeExternal(objectOutput);
            }
            int y = y();
            objectOutput.writeInt(y);
            for (int i2 = 0; i2 < y; i2++) {
                this.intlNumberFormat_.get(i2).writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.mainCountryForCode_);
            objectOutput.writeBoolean(this.hasLeadingDigits);
            if (this.hasLeadingDigits) {
                objectOutput.writeUTF(this.leadingDigits_);
            }
            objectOutput.writeBoolean(this.leadingZeroPossible_);
            objectOutput.writeBoolean(this.mobileNumberPortableRegion_);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readBoolean()) {
                d dVar = new d();
                dVar.readExternal(objectInput);
                a(dVar);
            }
            if (objectInput.readBoolean()) {
                d dVar2 = new d();
                dVar2.readExternal(objectInput);
                b(dVar2);
            }
            if (objectInput.readBoolean()) {
                d dVar3 = new d();
                dVar3.readExternal(objectInput);
                c(dVar3);
            }
            if (objectInput.readBoolean()) {
                d dVar4 = new d();
                dVar4.readExternal(objectInput);
                d(dVar4);
            }
            if (objectInput.readBoolean()) {
                d dVar5 = new d();
                dVar5.readExternal(objectInput);
                e(dVar5);
            }
            if (objectInput.readBoolean()) {
                d dVar6 = new d();
                dVar6.readExternal(objectInput);
                f(dVar6);
            }
            if (objectInput.readBoolean()) {
                d dVar7 = new d();
                dVar7.readExternal(objectInput);
                g(dVar7);
            }
            if (objectInput.readBoolean()) {
                d dVar8 = new d();
                dVar8.readExternal(objectInput);
                h(dVar8);
            }
            if (objectInput.readBoolean()) {
                d dVar9 = new d();
                dVar9.readExternal(objectInput);
                i(dVar9);
            }
            if (objectInput.readBoolean()) {
                d dVar10 = new d();
                dVar10.readExternal(objectInput);
                j(dVar10);
            }
            if (objectInput.readBoolean()) {
                d dVar11 = new d();
                dVar11.readExternal(objectInput);
                k(dVar11);
            }
            if (objectInput.readBoolean()) {
                d dVar12 = new d();
                dVar12.readExternal(objectInput);
                l(dVar12);
            }
            if (objectInput.readBoolean()) {
                d dVar13 = new d();
                dVar13.readExternal(objectInput);
                m(dVar13);
            }
            if (objectInput.readBoolean()) {
                d dVar14 = new d();
                dVar14.readExternal(objectInput);
                n(dVar14);
            }
            if (objectInput.readBoolean()) {
                d dVar15 = new d();
                dVar15.readExternal(objectInput);
                o(dVar15);
            }
            if (objectInput.readBoolean()) {
                d dVar16 = new d();
                dVar16.readExternal(objectInput);
                p(dVar16);
            }
            if (objectInput.readBoolean()) {
                d dVar17 = new d();
                dVar17.readExternal(objectInput);
                q(dVar17);
            }
            a(objectInput.readUTF());
            a(objectInput.readInt());
            b(objectInput.readUTF());
            if (objectInput.readBoolean()) {
                c(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                d(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                e(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                f(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                g(objectInput.readUTF());
            }
            a(objectInput.readBoolean());
            int readInt = objectInput.readInt();
            for (int i = 0; i < readInt; i++) {
                a aVar = new a();
                aVar.readExternal(objectInput);
                this.numberFormat_.add(aVar);
            }
            int readInt2 = objectInput.readInt();
            for (int i2 = 0; i2 < readInt2; i2++) {
                a aVar2 = new a();
                aVar2.readExternal(objectInput);
                this.intlNumberFormat_.add(aVar2);
            }
            b(objectInput.readBoolean());
            if (objectInput.readBoolean()) {
                h(objectInput.readUTF());
            }
            c(objectInput.readBoolean());
            d(objectInput.readBoolean());
        }
    }

    public static class c implements Externalizable {
        private static final long serialVersionUID = 1;
        private List<b> metadata_ = new ArrayList();

        public List<b> a() {
            return this.metadata_;
        }

        public int b() {
            return this.metadata_.size();
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            int b2 = b();
            objectOutput.writeInt(b2);
            for (int i = 0; i < b2; i++) {
                this.metadata_.get(i).writeExternal(objectOutput);
            }
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            int readInt = objectInput.readInt();
            for (int i = 0; i < readInt; i++) {
                b bVar = new b();
                bVar.readExternal(objectInput);
                this.metadata_.add(bVar);
            }
        }
    }
}
