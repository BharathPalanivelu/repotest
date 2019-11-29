package com.shopee.app.react.modules.ui.datepicker;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.DatePicker;
import android.widget.TimePicker;
import com.afollestad.materialdialogs.f;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DatePickerOption;
import com.shopee.react.sdk.bridge.protocol.DatePickerResult;
import com.shopee.react.sdk.bridge.protocol.TimePickerOption;
import com.shopee.react.sdk.bridge.protocol.TimePickerResult;
import java.util.Calendar;

public class a extends com.shopee.react.sdk.bridge.modules.ui.datepicker.a {
    public void a(Activity activity, DatePickerOption datePickerOption, final c<DatePickerResult> cVar) {
        if (!activity.isFinishing()) {
            com.shopee.app.ui.dialog.a.a((Context) activity, datePickerOption.getTimestamp(), datePickerOption.getMinDate(), datePickerOption.getMaxDate(), datePickerOption.isHideDay(), (DatePicker.OnDateChangedListener) new DatePicker.OnDateChangedListener() {
                public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
                    a.a(c.this, datePicker, i, i2, i3);
                }
            }, (f.b) new f.b() {
                public void onNegative(f fVar) {
                    DatePickerResult datePickerResult = new DatePickerResult();
                    datePickerResult.setCancelled(true);
                    cVar.a(datePickerResult);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(c cVar, DatePicker datePicker, int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2, i3, 0, 0, 0);
        DatePickerResult datePickerResult = new DatePickerResult();
        datePickerResult.setTimestamp(instance.getTimeInMillis());
        cVar.a(datePickerResult);
    }

    public void a(Activity activity, TimePickerOption timePickerOption, c<TimePickerResult> cVar) {
        if (!activity.isFinishing()) {
            com.shopee.app.ui.dialog.a.a((Context) activity, timePickerOption.getTimestamp(), timePickerOption.getTimeFormat() == 1, timePickerOption.getMinuteInterval(), (TimePickerDialog.OnTimeSetListener) new TimePickerDialog.OnTimeSetListener() {
                public final void onTimeSet(TimePicker timePicker, int i, int i2) {
                    a.a(c.this, timePicker, i, i2);
                }
            }, (DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    a.a(c.this, dialogInterface);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(c cVar, TimePicker timePicker, int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, i);
        instance.set(12, i2);
        TimePickerResult timePickerResult = new TimePickerResult();
        timePickerResult.setTimestamp(instance.getTimeInMillis());
        cVar.a(timePickerResult);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(c cVar, DialogInterface dialogInterface) {
        TimePickerResult timePickerResult = new TimePickerResult();
        timePickerResult.setCancelled(true);
        cVar.a(timePickerResult);
    }
}
