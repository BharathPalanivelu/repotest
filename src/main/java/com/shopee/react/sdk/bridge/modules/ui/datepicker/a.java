package com.shopee.react.sdk.bridge.modules.ui.datepicker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.widget.DatePicker;
import android.widget.TimePicker;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.modules.base.d;
import com.shopee.react.sdk.bridge.protocol.DatePickerOption;
import com.shopee.react.sdk.bridge.protocol.DatePickerResult;
import com.shopee.react.sdk.bridge.protocol.TimePickerOption;
import com.shopee.react.sdk.bridge.protocol.TimePickerResult;
import java.util.Calendar;

public class a extends d {
    public void a(Activity activity, DatePickerOption datePickerOption, final c<DatePickerResult> cVar) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(datePickerOption.getTimestamp() * 1000);
        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Calendar instance = Calendar.getInstance();
                instance.set(i, i2, i3, 0, 0, 0);
                DatePickerResult datePickerResult = new DatePickerResult();
                datePickerResult.setTimestamp(instance.getTimeInMillis());
                cVar.a(datePickerResult);
            }
        }, instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.getDatePicker().setMinDate(datePickerOption.getMinDate());
        datePickerDialog.getDatePicker().setMaxDate(datePickerOption.getMaxDate());
        datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                DatePickerResult datePickerResult = new DatePickerResult();
                datePickerResult.setCancelled(true);
                cVar.a(datePickerResult);
            }
        });
        datePickerDialog.show();
    }

    public void a(Activity activity, TimePickerOption timePickerOption, final c<TimePickerResult> cVar) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(timePickerOption.getTimestamp() * 1000);
        TimePickerDialog timePickerDialog = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker timePicker, int i, int i2) {
                Calendar instance = Calendar.getInstance();
                instance.set(11, i);
                instance.set(12, i2);
                TimePickerResult timePickerResult = new TimePickerResult();
                timePickerResult.setTimestamp(instance.getTimeInMillis());
                cVar.a(timePickerResult);
            }
        }, instance.get(11), instance.get(12), timePickerOption.getTimeFormat() == 1);
        timePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                TimePickerResult timePickerResult = new TimePickerResult();
                timePickerResult.setCancelled(true);
                cVar.a(timePickerResult);
            }
        });
        timePickerDialog.show();
    }
}
