package com.shopee.app.react.modules.ui.datepicker;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.react.sdk.activity.a;

@ReactModule(name = "GADatePicker")
public class DatePickerModule extends com.shopee.react.sdk.bridge.modules.ui.datepicker.DatePickerModule {
    public DatePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(a aVar) {
        return new a();
    }

    @ReactMethod
    public void show(int i, String str, Promise promise) {
        super.show(i, str, promise);
    }

    @ReactMethod
    public void showTimePicker(int i, String str, Promise promise) {
        super.showTimePicker(i, str, promise);
    }
}
