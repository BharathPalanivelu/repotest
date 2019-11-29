package com.shopee.app.tracking;

import android.content.Context;
import com.facebook.appevents.AppEventsLogger;
import com.shopee.app.tracking.trackingv3.model.FacebookLogItem;
import com.shopee.app.web.WebRegister;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private AppEventsLogger f19160a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f19161b;

    public static d a(Context context) {
        return new d(context);
    }

    public d(Context context) {
        this.f19161b = context;
    }

    private void a() {
        if (this.f19160a == null) {
            try {
                this.f19160a = AppEventsLogger.newLogger(this.f19161b);
            } catch (Exception unused) {
            }
        }
    }

    public void a(String str) {
        a();
        if (this.f19160a != null) {
            try {
                FacebookLogItem facebookLogItem = (FacebookLogItem) WebRegister.GSON.a(str, FacebookLogItem.class);
                this.f19160a.logProductItem(facebookLogItem.getId(), facebookLogItem.getAvailabilityEnum(), facebookLogItem.getConditionEnum(), facebookLogItem.getDescription(), facebookLogItem.getImage_link(), facebookLogItem.getLink(), facebookLogItem.getTitle(), facebookLogItem.getPriceAsDecimal(), facebookLogItem.getCurrencyEnum(), (String) null, (String) null, facebookLogItem.getBrand(), facebookLogItem.getParametersAsBundle());
            } catch (Exception unused) {
            }
        }
    }
}
