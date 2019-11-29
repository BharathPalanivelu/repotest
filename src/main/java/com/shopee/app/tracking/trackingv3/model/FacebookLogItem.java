package com.shopee.app.tracking.trackingv3.model;

import android.os.Bundle;
import com.facebook.appevents.AppEventsLogger;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.util.au;
import d.d.b.j;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public final class FacebookLogItem {
    private final String availability;
    private final String brand;
    private final String condition;
    private final String description;
    private final String id;
    private final String image_link;
    private final String link;
    private final HashMap<String, String> parameters;
    private final long price;
    private final String title;

    public static /* synthetic */ FacebookLogItem copy$default(FacebookLogItem facebookLogItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, String str8, HashMap hashMap, int i, Object obj) {
        FacebookLogItem facebookLogItem2 = facebookLogItem;
        int i2 = i;
        return facebookLogItem.copy((i2 & 1) != 0 ? facebookLogItem2.id : str, (i2 & 2) != 0 ? facebookLogItem2.availability : str2, (i2 & 4) != 0 ? facebookLogItem2.condition : str3, (i2 & 8) != 0 ? facebookLogItem2.description : str4, (i2 & 16) != 0 ? facebookLogItem2.image_link : str5, (i2 & 32) != 0 ? facebookLogItem2.link : str6, (i2 & 64) != 0 ? facebookLogItem2.title : str7, (i2 & 128) != 0 ? facebookLogItem2.price : j, (i2 & 256) != 0 ? facebookLogItem2.brand : str8, (i2 & 512) != 0 ? facebookLogItem2.parameters : hashMap);
    }

    public final String component1() {
        return this.id;
    }

    public final HashMap<String, String> component10() {
        return this.parameters;
    }

    public final String component2() {
        return this.availability;
    }

    public final String component3() {
        return this.condition;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.image_link;
    }

    public final String component6() {
        return this.link;
    }

    public final String component7() {
        return this.title;
    }

    public final long component8() {
        return this.price;
    }

    public final String component9() {
        return this.brand;
    }

    public final FacebookLogItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, String str8, HashMap<String, String> hashMap) {
        j.b(str, "id");
        j.b(str2, "availability");
        String str9 = str3;
        j.b(str9, "condition");
        String str10 = str4;
        j.b(str10, "description");
        String str11 = str5;
        j.b(str11, "image_link");
        String str12 = str6;
        j.b(str12, "link");
        String str13 = str7;
        j.b(str13, "title");
        String str14 = str8;
        j.b(str14, "brand");
        return new FacebookLogItem(str, str2, str9, str10, str11, str12, str13, j, str14, hashMap);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FacebookLogItem) {
                FacebookLogItem facebookLogItem = (FacebookLogItem) obj;
                if (j.a((Object) this.id, (Object) facebookLogItem.id) && j.a((Object) this.availability, (Object) facebookLogItem.availability) && j.a((Object) this.condition, (Object) facebookLogItem.condition) && j.a((Object) this.description, (Object) facebookLogItem.description) && j.a((Object) this.image_link, (Object) facebookLogItem.image_link) && j.a((Object) this.link, (Object) facebookLogItem.link) && j.a((Object) this.title, (Object) facebookLogItem.title)) {
                    if (!(this.price == facebookLogItem.price) || !j.a((Object) this.brand, (Object) facebookLogItem.brand) || !j.a((Object) this.parameters, (Object) facebookLogItem.parameters)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.availability;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.condition;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.description;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.image_link;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.link;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.title;
        int hashCode7 = (((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + Long.valueOf(this.price).hashCode()) * 31;
        String str8 = this.brand;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        HashMap<String, String> hashMap = this.parameters;
        if (hashMap != null) {
            i = hashMap.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "FacebookLogItem(id=" + this.id + ", availability=" + this.availability + ", condition=" + this.condition + ", description=" + this.description + ", image_link=" + this.image_link + ", link=" + this.link + ", title=" + this.title + ", price=" + this.price + ", brand=" + this.brand + ", parameters=" + this.parameters + SQLBuilder.PARENTHESES_RIGHT;
    }

    public FacebookLogItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, String str8, HashMap<String, String> hashMap) {
        j.b(str, "id");
        j.b(str2, "availability");
        j.b(str3, "condition");
        j.b(str4, "description");
        j.b(str5, "image_link");
        j.b(str6, "link");
        j.b(str7, "title");
        j.b(str8, "brand");
        this.id = str;
        this.availability = str2;
        this.condition = str3;
        this.description = str4;
        this.image_link = str5;
        this.link = str6;
        this.title = str7;
        this.price = j;
        this.brand = str8;
        this.parameters = hashMap;
    }

    public final String getId() {
        return this.id;
    }

    public final String getAvailability() {
        return this.availability;
    }

    public final String getCondition() {
        return this.condition;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getImage_link() {
        return this.image_link;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getPrice() {
        return this.price;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final HashMap<String, String> getParameters() {
        return this.parameters;
    }

    public final AppEventsLogger.ProductAvailability getAvailabilityEnum() {
        String str = this.availability;
        switch (str.hashCode()) {
            case -1279982965:
                if (str.equals("preorder")) {
                    return AppEventsLogger.ProductAvailability.PREORDER;
                }
                break;
            case -1205591089:
                if (str.equals("discontinued")) {
                    return AppEventsLogger.ProductAvailability.DISCONTINUED;
                }
                break;
            case -532790145:
                if (str.equals("out_of_stock")) {
                    return AppEventsLogger.ProductAvailability.OUT_OF_STOCK;
                }
                break;
            case -17811588:
                if (str.equals("in_stock")) {
                    return AppEventsLogger.ProductAvailability.IN_STOCK;
                }
                break;
            case 1661557346:
                if (str.equals("available_for_order")) {
                    return AppEventsLogger.ProductAvailability.AVALIABLE_FOR_ORDER;
                }
                break;
        }
        return null;
    }

    public final AppEventsLogger.ProductCondition getConditionEnum() {
        String str = this.condition;
        int hashCode = str.hashCode();
        if (hashCode != 108960) {
            if (hashCode != 3599293) {
                if (hashCode == 2008925419 && str.equals("refurbished")) {
                    return AppEventsLogger.ProductCondition.REFURBISHED;
                }
            } else if (str.equals("used")) {
                return AppEventsLogger.ProductCondition.USED;
            }
        } else if (str.equals("new")) {
            return AppEventsLogger.ProductCondition.NEW;
        }
        return null;
    }

    public final BigDecimal getPriceAsDecimal() {
        return new BigDecimal(au.a(this.price));
    }

    public final Currency getCurrencyEnum() {
        Currency instance = Currency.getInstance("IDR");
        j.a((Object) instance, "Currency.getInstance(CONST.CURRENCY)");
        return instance;
    }

    public final Bundle getParametersAsBundle() {
        Bundle bundle = new Bundle();
        HashMap<String, String> hashMap = this.parameters;
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                bundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return bundle;
    }
}
