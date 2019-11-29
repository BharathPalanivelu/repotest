package com.shopee.react.sdk.bridge.modules.ui.datepicker;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.activity.a;
import com.shopee.react.sdk.bridge.modules.base.ReactBaseLifecycleModule;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DatePickerOption;
import com.shopee.react.sdk.bridge.protocol.DatePickerResult;
import com.shopee.react.sdk.bridge.protocol.TimePickerOption;
import com.shopee.react.sdk.bridge.protocol.TimePickerResult;

@ReactModule(name = "GADatePicker")
public class DatePickerModule extends ReactBaseLifecycleModule<a> {
    public static final String NAME = "GADatePicker";

    public String getName() {
        return NAME;
    }

    public DatePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(a aVar) {
        return new a();
    }

    @ReactMethod
    public void show(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (DatePickerModule.this.isMatchingReactTag(i)) {
                    DatePickerOption datePickerOption = (DatePickerOption) com.shopee.react.sdk.a.a.f30143a.a(str, DatePickerOption.class);
                    if (DatePickerModule.this.getHelper() != null) {
                        ((a) DatePickerModule.this.getHelper()).a(DatePickerModule.this.getCurrentActivity(), datePickerOption, (c<DatePickerResult>) new c(promise));
                    }
                }
            }
        });
    }

    @ReactMethod
    public void showTimePicker(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (DatePickerModule.this.isMatchingReactTag(i)) {
                    TimePickerOption timePickerOption = (TimePickerOption) com.shopee.react.sdk.a.a.f30143a.a(str, TimePickerOption.class);
                    if (DatePickerModule.this.getHelper() != null) {
                        ((a) DatePickerModule.this.getHelper()).a(DatePickerModule.this.getCurrentActivity(), timePickerOption, (c<TimePickerResult>) new c(promise));
                    }
                }
            }
        });
    }
}
