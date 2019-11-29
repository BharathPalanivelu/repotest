package com.shopee.app.web.protocol.notification;

import android.text.TextUtils;
import d.d.b.j;

public final class ShareDataField {
    public static final Companion Companion = new Companion((g) null);
    private final String android_text;
    private final String android_title;
    private final String beetalk;
    private final String buzz;
    private final String copy_info;
    private final String copy_link;

    /* renamed from: default  reason: not valid java name */
    private final String f344default;
    private final String email_body;
    private final String email_subject;
    private final String facebook;
    private final String instagram;
    private final String line;
    private final String messenger;
    private final String pinterest;
    private final String sms;
    private final String twitter;
    private final String viber;
    private final String whatsapp;

    public ShareDataField(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18) {
        String str19 = str;
        String str20 = str2;
        String str21 = str3;
        String str22 = str4;
        String str23 = str5;
        String str24 = str6;
        String str25 = str7;
        String str26 = str8;
        String str27 = str9;
        String str28 = str10;
        String str29 = str11;
        String str30 = str12;
        String str31 = str13;
        String str32 = str14;
        String str33 = str16;
        j.b(str19, "default");
        j.b(str20, "facebook");
        j.b(str21, "copy_info");
        j.b(str22, "copy_link");
        j.b(str23, "sms");
        j.b(str24, "instagram");
        j.b(str25, "whatsapp");
        j.b(str26, "twitter");
        j.b(str27, "line");
        j.b(str28, "pinterest");
        j.b(str29, "beetalk");
        j.b(str30, "buzz");
        j.b(str31, "email_body");
        j.b(str32, "email_subject");
        j.b(str15, "viber");
        j.b(str16, "messenger");
        j.b(str17, "android_title");
        j.b(str18, "android_text");
        this.f344default = str19;
        this.facebook = str20;
        this.copy_info = str21;
        this.copy_link = str22;
        this.sms = str23;
        this.instagram = str24;
        this.whatsapp = str25;
        this.twitter = str26;
        this.line = str27;
        this.pinterest = str28;
        this.beetalk = str29;
        this.buzz = str30;
        this.email_body = str31;
        this.email_subject = str32;
        this.viber = str15;
        this.messenger = str16;
        this.android_title = str17;
        this.android_text = str18;
    }

    public final String getDefault() {
        return this.f344default;
    }

    public final String getFacebook() {
        return this.facebook;
    }

    public final String getCopy_info() {
        return this.copy_info;
    }

    public final String getCopy_link() {
        return this.copy_link;
    }

    public final String getSms() {
        return this.sms;
    }

    public final String getInstagram() {
        return this.instagram;
    }

    public final String getWhatsapp() {
        return this.whatsapp;
    }

    public final String getTwitter() {
        return this.twitter;
    }

    public final String getLine() {
        return this.line;
    }

    public final String getPinterest() {
        return this.pinterest;
    }

    public final String getBeetalk() {
        return this.beetalk;
    }

    public final String getBuzz() {
        return this.buzz;
    }

    public final String getEmail_body() {
        return this.email_body;
    }

    public final String getEmail_subject() {
        return this.email_subject;
    }

    public final String getViber() {
        return this.viber;
    }

    public final String getMessenger() {
        return this.messenger;
    }

    public final String getAndroid_title() {
        return this.android_title;
    }

    public final String getAndroid_text() {
        return this.android_text;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getValue(String str, ShareDataField shareDataField, String str2) {
            j.b(str2, "appKey");
            if (shareDataField == null) {
                return str;
            }
            switch (str2.hashCode()) {
                case -1489704055:
                    if (str2.equals("email_subject")) {
                        return getWithDefault(shareDataField.getEmail_subject(), shareDataField.getDefault());
                    }
                    break;
                case -1436108013:
                    if (str2.equals("messenger")) {
                        return getWithDefault(shareDataField.getMessenger(), shareDataField.getDefault());
                    }
                    break;
                case -1220420276:
                    if (str2.equals("system_android_subject")) {
                        return getWithDefault(shareDataField.getAndroid_title(), shareDataField.getDefault());
                    }
                    break;
                case -916346253:
                    if (str2.equals("twitter")) {
                        return getWithDefault(shareDataField.getTwitter(), shareDataField.getDefault());
                    }
                    break;
                case -230580178:
                    if (str2.equals("beetalk")) {
                        return getWithDefault(shareDataField.getBeetalk(), shareDataField.getDefault());
                    }
                    break;
                case -95244193:
                    if (str2.equals("system_android")) {
                        return getWithDefault(shareDataField.getAndroid_text(), shareDataField.getDefault());
                    }
                    break;
                case -1034342:
                    if (str2.equals("pinterest")) {
                        return getWithDefault(shareDataField.getPinterest(), shareDataField.getDefault());
                    }
                    break;
                case 114009:
                    if (str2.equals("sms")) {
                        return getWithDefault(shareDataField.getSms(), shareDataField.getDefault());
                    }
                    break;
                case 3035859:
                    if (str2.equals("buzz")) {
                        return getWithDefault(shareDataField.getBuzz(), shareDataField.getDefault());
                    }
                    break;
                case 3321844:
                    if (str2.equals("line")) {
                        return getWithDefault(shareDataField.getLine(), shareDataField.getDefault());
                    }
                    break;
                case 28903346:
                    if (str2.equals("instagram")) {
                        return getWithDefault(shareDataField.getInstagram(), shareDataField.getDefault());
                    }
                    break;
                case 96619420:
                    if (str2.equals("email")) {
                        return getWithDefault(shareDataField.getEmail_body(), shareDataField.getDefault());
                    }
                    break;
                case 112200956:
                    if (str2.equals("viber")) {
                        return getWithDefault(shareDataField.getViber(), shareDataField.getDefault());
                    }
                    break;
                case 497130182:
                    if (str2.equals("facebook")) {
                        return getWithDefault(shareDataField.getFacebook(), shareDataField.getDefault());
                    }
                    break;
                case 1505349432:
                    if (str2.equals("copy_info")) {
                        return getWithDefault(shareDataField.getCopy_info(), shareDataField.getDefault());
                    }
                    break;
                case 1505434244:
                    if (str2.equals("copy_link")) {
                        return getWithDefault(shareDataField.getCopy_link(), shareDataField.getDefault());
                    }
                    break;
                case 1934780818:
                    if (str2.equals("whatsapp")) {
                        return getWithDefault(shareDataField.getWhatsapp(), shareDataField.getDefault());
                    }
                    break;
            }
            return shareDataField.getDefault();
        }

        public final String getWithDefault(String str, String str2) {
            if (str == null || TextUtils.isEmpty(str)) {
                return (str2 == null || TextUtils.isEmpty(str2)) ? "" : str2;
            }
            return str;
        }
    }
}
