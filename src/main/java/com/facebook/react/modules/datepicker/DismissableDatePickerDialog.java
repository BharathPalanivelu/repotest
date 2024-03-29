package com.facebook.react.modules.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.DatePicker;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DismissableDatePickerDialog extends DatePickerDialog {
    public DismissableDatePickerDialog(Context context, DatePickerDialog.OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        super(context, onDateSetListener, i, i2, i3);
        fixSpinner(context, i, i2, i3);
    }

    public DismissableDatePickerDialog(Context context, int i, DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        super(context, i, onDateSetListener, i2, i3, i4);
        fixSpinner(context, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (Build.VERSION.SDK_INT > 19) {
            super.onStop();
        }
    }

    private void fixSpinner(Context context, int i, int i2, int i3) {
        Context context2 = context;
        if (Build.VERSION.SDK_INT == 24) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$styleable");
                TypedArray obtainStyledAttributes = context2.obtainStyledAttributes((AttributeSet) null, (int[]) cls.getField("DatePicker").get((Object) null), 16843612, 0);
                int i4 = obtainStyledAttributes.getInt(cls.getField("DatePicker_datePickerMode").getInt((Object) null), 2);
                obtainStyledAttributes.recycle();
                if (i4 == 2) {
                    DatePicker datePicker = (DatePicker) findField(DatePickerDialog.class, DatePicker.class, "mDatePicker").get(this);
                    Field findField = findField(DatePicker.class, Class.forName("android.widget.DatePickerSpinnerDelegate"), "mDelegate");
                    Object obj = findField.get(datePicker);
                    if (obj.getClass() != Class.forName("android.widget.DatePickerSpinnerDelegate")) {
                        findField.set(datePicker, (Object) null);
                        datePicker.removeAllViews();
                        Method declaredMethod = DatePicker.class.getDeclaredMethod("createSpinnerUIDelegate", new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE});
                        declaredMethod.setAccessible(true);
                        findField.set(datePicker, declaredMethod.invoke(datePicker, new Object[]{context2, null, 16843612, 0}));
                        datePicker.setCalendarViewShown(false);
                        datePicker.init(i, i2, i3, this);
                    }
                }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private static Field findField(Class cls, Class cls2, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType() == cls2) {
                    field.setAccessible(true);
                    return field;
                }
            }
            return null;
        }
    }
}
