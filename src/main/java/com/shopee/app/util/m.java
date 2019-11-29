package com.shopee.app.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.LocaleList;
import java.util.Locale;

public class m extends ContextWrapper {
    public m(Context context) {
        super(context);
    }

    @TargetApi(24)
    public static ContextWrapper a(Context context, Locale locale) {
        if (locale == null) {
            return new ContextWrapper(context);
        }
        Configuration configuration = context.getResources().getConfiguration();
        Locale.setDefault(locale);
        configuration.setLocale(locale);
        configuration.setLocales(new LocaleList(new Locale[]{locale}));
        return new m(context.createConfigurationContext(configuration));
    }
}
